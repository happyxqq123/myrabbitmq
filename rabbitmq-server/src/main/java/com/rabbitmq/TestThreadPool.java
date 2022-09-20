package com.rabbitmq;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        for(int i= 0 ;i < 100; i++){
            executorService1.execute(new MyTask(i));
        }
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
