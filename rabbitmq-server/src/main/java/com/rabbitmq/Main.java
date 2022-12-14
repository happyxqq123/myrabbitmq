package com.rabbitmq;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.protobuf.Any;
import com.rabbitmq.handler.ProtoBufDecoder;
import com.rabbitmq.handler.ProtoBufEncoder;
import com.rabbitmq.protocol.MessageDataOuterClass;
import com.rabbitmq.protocol.message.SendMessageOuterClass;
import com.rabbitmq.server.Service;
import com.rabbitmq.strategy.Operation;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.logging.LoggingHandler;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.io.IOException;
import java.util.concurrent.ThreadFactory;

public class Main {

    public static void main1(String[] args) throws IOException {
        EmbeddedChannel embeddedChannel = new EmbeddedChannel();
        ChannelPipeline channelPipeline = embeddedChannel.pipeline();
        channelPipeline.addLast(new LoggingHandler());
        channelPipeline.addLast(new LengthFieldBasedFrameDecoder(8192,0,4,0,4));
        channelPipeline.addLast(new ProtoBufDecoder());
        channelPipeline.addLast(new LengthFieldPrepender(4));
        channelPipeline.addLast(new ProtoBufEncoder());


        SendMessageOuterClass.SendMessage.Builder builder =  SendMessageOuterClass.SendMessage.newBuilder();
        builder.setBody("abc");
        builder.setMsgId("abcd");
        builder.setKey("a123");
        builder.setTag("ddd");
        SendMessageOuterClass.SendMessage confirm = builder.build();

        MessageDataOuterClass.MessageData.Builder reqMessageBuilder =  MessageDataOuterClass.MessageData.newBuilder();
        reqMessageBuilder.setData(Any.pack(confirm));
        reqMessageBuilder.setReqId(2);
        reqMessageBuilder.setOperation(Operation.REQ_SEND_MESSAGE);
        MessageDataOuterClass.MessageData  msgData =  reqMessageBuilder.build();
        byte[] bytes =  msgData.toByteArray();
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
        embeddedChannel.writeInbound(byteBuf);
    }

    public static void main(String[] args) {
        ThreadFactory guavaThreadFactory = new ThreadFactoryBuilder().setNameFormat("retryClient-pool-%d").build();
        guavaThreadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        ThreadFactory basicThreadFactory = new BasicThreadFactory.Builder().namingPattern("MessageEventProcessor-%d").build();
        basicThreadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());

            }
        }).start();

    }
}
