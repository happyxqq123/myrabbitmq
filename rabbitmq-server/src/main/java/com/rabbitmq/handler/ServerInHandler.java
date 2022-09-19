package com.rabbitmq.handler;

import com.rabbitmq.protocol.MessageDataOuterClass;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerInHandler extends SimpleChannelInboundHandler<MessageDataOuterClass.MessageData> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageDataOuterClass.MessageData msg) throws Exception {
        System.out.println(msg);
    }
}
