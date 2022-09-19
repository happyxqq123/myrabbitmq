package com.rabbitmq.strategy;

public class Operation {

    public static final int REQ_SEND_MESSAGE = 1; //发送消息
    public static final int REQ_PULL = 2; //拉取消息
    public static final int REQ_TOPIC_DATA = 3; // 拉去消息
    public static final int REQ_COMMIT_OFFSET =4; //同步确认消息消费位点
    public static final int REQ_RESP = 5; //请求返回resp
}
