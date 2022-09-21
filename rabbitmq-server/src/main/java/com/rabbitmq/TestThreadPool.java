package com.rabbitmq;

import com.rabbitmq.datasource.HsqlDatasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestThreadPool {

    public static void main1(String[] args) {
        final Random random = new Random();
        final List<Integer> list = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i = 0 ; i < 100000; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        executorService.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
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
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName()+",离开");
                        connection.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            executorService.shutdown();
    }

    static class MyTask implements  Runnable{

        private int taskId;

        MyTask(int id){
            this.taskId = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+","+taskId);
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
