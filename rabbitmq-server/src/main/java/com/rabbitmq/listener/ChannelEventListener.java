package com.rabbitmq.listener;

import com.rabbitmq.server.WrappedChannel;
import io.netty.channel.ChannelHandlerContext;

import java.util.EventListener;

public interface ChannelEventListener extends EventListener {

    /**
     * channel connection
     * @param ctx
     * @param channel
     * @return
     */
    EventBehavior channelActive(ChannelHandlerContext ctx, WrappedChannel channel);

    /**
     * channel close
     * @param ctx
     * @param channel
     * @return
     */
    EventBehavior channelInactive(ChannelHandlerContext ctx,WrappedChannel channel);
}
