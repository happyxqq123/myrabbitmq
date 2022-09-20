package com.rabbitmq.listener;

import com.rabbitmq.server.WrappedChannel;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

/**
 * default exception event execute listener
 */
@Slf4j
public class DefaultExceptionListener implements ExceptionEventListener{
    @Override
    public EventBehavior exceptionCaught(ChannelHandlerContext ctx, WrappedChannel channel, Throwable cause) {
        if(cause != null && channel.remoteAddress() != null){
            log.warn("Exception caught on channel {}, caused by : {}",channel.id().asShortText(),cause);
        }
        return EventBehavior.CONTINUE;
    }
}
