package com.rabbitmq;

import java.util.concurrent.Semaphore;

public class TestSemaphore {

    //停车场同时容纳的车辆数
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        //模拟100辆车进入停车场
        for (int i = 0 ;i < 100; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        System.out.println("======"+Thread.currentThread().getName()+"欢迎来到停车场");
                        if(semaphore.availablePermits() == 0){
                            System.out.println("车位不足，请耐心等待");
                        }
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+"成功进入停车场");
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName()+"驶出停车场");
                        semaphore.release();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }

}
