package com.rabbitmq;

import com.rabbitmq.datasource.HsqlDatasource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestDatasource {


    public static void main(){
        HsqlDatasource hsqlDatasource = new HsqlDatasource();
        hsqlDatasource.setUrl("jdbc:mysql://rm-2ze94q1dv8mrbg424co.mysql.rds.aliyuncs.com:3306/ry-react?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8");
        hsqlDatasource.setDriverClassName("com.mysql.jdbc.Driver");
        hsqlDatasource.setUsername("ecs");
        hsqlDatasource.setPassword("@1128ecs");
        hsqlDatasource.setPoolSize(10);
        hsqlDatasource.init();
        ExecutorService executorService =  Executors.newFixedThreadPool(30);
        for(int i =0;i< 30; i++){
            executorService.execute(()->{
                try {
                    Connection connection =  hsqlDatasource.getConnection();
                    System.out.println(Thread.currentThread().getName()+",获取到连接");
                    Thread.sleep(20000);
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
