package com.rabbitmq.listener;

import com.rabbitmq.server.WrappedChannel;
import io.netty.channel.ChannelHandlerContext;

import java.util.EventListener;


/**
 * exception evnt listener
 */
public interface ExceptionEventListener extends EventListener {

    /**
     * exception caught
     * @param ctx
     * @param channel
     * @param cause
     * @return
     */
    EventBehavior exceptionCaught(ChannelHandlerContext ctx, WrappedChannel channel,Throwable cause);
}
