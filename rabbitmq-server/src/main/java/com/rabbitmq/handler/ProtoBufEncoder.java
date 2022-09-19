package com.rabbitmq.handler;

import com.rabbitmq.protocol.MessageDataOuterClass;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.handler.codec.MessageToMessageEncoder;
import javassist.Loader;

import java.util.List;
import java.util.Objects;

public class ProtoBufEncoder extends MessageToMessageEncoder<MessageDataOuterClass.MessageData> {

    @Override
    protected void encode(ChannelHandlerContext ctx, MessageDataOuterClass.MessageData msg, List<Object> out) throws Exception {
        if(!Objects.isNull(msg)){
            ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
            byteBuf.writeBytes(msg.toByteArray());
            out.add(byteBuf);
        }
    }
}
