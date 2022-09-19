package com.rabbitmq.strategy;

import com.rabbitmq.protocol.MessageDataOuterClass;
import com.rabbitmq.strategy.executors.BaseExecutor;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 消息处理器工具类
 */
public class MessageStrategy {

    private static Map<Integer, BaseExecutor> messageExecutorMap ;

    static{
        //初始化加载消息处理类
        messageExecutorMap = new HashMap<>();
        Reflections reflections =  new Reflections("com.rabbitmq.strategy.executors.impl");
        Set<Class<? extends BaseExecutor>> typeClass =  reflections.getSubTypesOf(BaseExecutor.class);
        typeClass.stream().forEach(clazz -> {
            try {
                BaseExecutor baseExecutor = clazz.newInstance();
                messageExecutorMap.put(baseExecutor.getMessageType(), baseExecutor);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        });
    }

    public static MessageDataOuterClass.MessageData execute(MessageDataOuterClass.MessageData messageData){
        BaseExecutor baseExecutor =  messageExecutorMap.get(messageData.getOperation());
        return baseExecutor.execute(messageData);
    }

}
