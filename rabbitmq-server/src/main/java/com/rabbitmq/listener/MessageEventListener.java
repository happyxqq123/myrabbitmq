package com.rabbitmq.listener;

import com.rabbitmq.server.WrappedChannel;
import io.netty.channel.ChannelHandlerContext;

import java.util.EventListener;

public interface MessageEventListener extends EventListener {

    /**
     * receive message
     */

    EventBehavior channelRead(ChannelHandlerContext ctx, WrappedChannel channel,Object msg);

}
