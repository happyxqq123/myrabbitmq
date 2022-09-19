package com.rabbitmq.handler;

import com.google.protobuf.Any;
import com.rabbitmq.protocol.MessageDataOuterClass;
import com.rabbitmq.protocol.message.SendMessageOuterClass;
import com.rabbitmq.strategy.MessageStrategy;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


@ChannelHandler.Sharable
public class ProtoBufDecoder extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf byteBuf) throws Exception {
        try{
            MessageDataOuterClass.MessageData reqMessage = MessageDataOuterClass.MessageData.parseFrom(byteBuf.nioBuffer());
        }finally {
            byteBuf.release();
        }
    }
}
