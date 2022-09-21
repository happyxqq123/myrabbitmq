package com.rabbitmq.datasource;

import io.netty.util.internal.StringUtil;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class HsqlDatasource implements DataSource {

    private final String CLASSPATH_PREFIX = "classpath:";
    /**
     * 连接池大小
     */
    @Setter
    @Getter
    private int poolSize = 3;

    @Setter
    @Getter
    private String driverClassName;

    @Getter
    @Setter
    private String url;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    /**
     * connection time out
     */
    @Getter
    @Setter
    private int timeout = 1000;
    /**
     * 建表脚本
     */
    private String tableScript;
    private boolean inited = false;

    private LinkedList<Connection> connectionPool = new LinkedList<>();

    public HsqlDatasource(){

    }

    public HsqlDatasource(int poolSize, String driverClassName, String url, String username, String password, int timeout) {
        this.poolSize = poolSize;
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
        this.timeout = timeout;
    }

    public int getCurrentConnectionPoolSize(){
        return connectionPool.size();
    }

    public void init(){
        try{
            if(poolSize <= 0){
                throw new IllegalArgumentException("Invalid pool size "+poolSize);
            }
            if(StringUtils.isBlank(driverClassName)){
                throw new IllegalArgumentException("dirverClassName cannot be null");
            }
            Class.forName(driverClassName);
            for(int i = 0;i < poolSize; i++){
               Connection connection =   DriverManager.getConnection(url,username,password);
               connection =  ConnectionProxy.getConnectionProxy(connection,connectionPool);
               connectionPool.add(connection);
            }

        }catch (Exception e){
            throw new RuntimeException(e.getMessage(),e);
        }finally{

        }
        inited = true;
    }

    @Override
    public Connection getConnection() throws SQLException {
        synchronized (connectionPool){
            if(!inited) init();
            if(connectionPool.size() == 0){
                try {
                    connectionPool.wait(timeout);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return getConnection();
            }else{
                return connectionPool.removeFirst();
            }
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return getConnection();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return (T) this;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return DataSource.class.equals(iface);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        throw new RuntimeException("Nonsupport Operation.");
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        throw new RuntimeException("Nonsupport Operation.");
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        throw new RuntimeException("Nonsupport Operation.");
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
