package com.rabbitmq.strategy.executors.impl;

import com.rabbitmq.protocol.MessageDataOuterClass;
import com.rabbitmq.strategy.Operation;
import com.rabbitmq.strategy.executors.BaseExecutor;

public class SendMessageExecutor extends BaseExecutor {

    @Override
    public int getMessageType() {
        return Operation.SEND_MESSAGE;
    }

    @Override
    public MessageDataOuterClass.MessageData execute(MessageDataOuterClass.MessageData messageData) {

        messageData  = null;
        return null;
    }
}
