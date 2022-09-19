package com.rabbitmq.strategy.executors.impl;

import com.rabbitmq.protocol.MessageDataOuterClass;
import com.rabbitmq.strategy.Operation;
import com.rabbitmq.strategy.executors.BaseExecutor;

public class TopicDataExecutor extends BaseExecutor {

    @Override
    public int getMessageType() {
        return Operation.REQ_TOPIC_DATA;
    }

    @Override
    public MessageDataOuterClass.MessageData execute(MessageDataOuterClass.MessageData messageData) {

        messageData  = null;
        return null;
    }
}
