package com.rabbitmq.handler.listener;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class MqGenericFutureListener implements GenericFutureListener {

    @Override
    public void operationComplete(Future future) throws Exception {
        if(future.isSuccess()){
            System.out.println("服务启动成功！");
        }
    }
}
