package com.rabbitmq.listener;


public enum EventBehavior {

    /**
     * continue to transfer message
     */
    CONTINUE,
    /**
     * stop to transfer message
     */
    BREAK
}
