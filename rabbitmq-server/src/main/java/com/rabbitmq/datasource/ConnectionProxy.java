package com.rabbitmq.datasource;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.LinkedList;

/**
 * create a connection proxy object
 */
public class ConnectionProxy implements InvocationHandler {

    private LinkedList<Connection> connectionPool;

    private Object obj;

    ConnectionProxy(Object obj,LinkedList<Connection> connectionPool){
        this.obj = obj;
        this.connectionPool = connectionPool;
    }

    public static Connection getConnectionProxy(Object obj,LinkedList<Connection> pool){
        return (Connection) Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                new Class[]{Connection.class},
                new ConnectionProxy(obj,pool));
    }




    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * if it invoke close method that recyle the connection and cant invoke connection's close method
         */
        if(method.getName().equals("close")) {
            synchronized (connectionPool){
                connectionPool.add((Connection) proxy);
                connectionPool.notify();
            }
            return null;
        }
        return method.invoke(obj,args);
    }
}
