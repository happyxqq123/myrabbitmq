package com.rabbitmq.strategy;

public class Operation {

    public static final int SEND_MESSAGE = 1; //发送消息
    public static final int PULL = 2; //拉取消息
    public static final int TOPIC_DATA = 3; // 拉去消息
    public static final int COMMIT_OFFSET =4; //同步确认消息消费位点
    public static final int RESP = 5; //请求返回resp
}
