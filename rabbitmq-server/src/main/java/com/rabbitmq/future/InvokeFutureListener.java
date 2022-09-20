package com.rabbitmq.future;

/**
 * invoke future listener
 */
public interface InvokeFutureListener {

    void operationComplete(InvokeFuture future) throws Exception;
}
