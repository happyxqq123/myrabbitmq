package com.rabbitmq.strategy.executors;

import com.rabbitmq.protocol.MessageDataOuterClass;

/**
 * 消息处理器基类
 *
 */
public abstract class BaseExecutor {

    public abstract int getMessageType();  //获取消息类型

    public abstract MessageDataOuterClass.MessageData execute(MessageDataOuterClass.MessageData messageData); //具体消息处理

}
