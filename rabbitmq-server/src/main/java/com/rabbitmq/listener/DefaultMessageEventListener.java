package com.rabbitmq.listener;

import com.rabbitmq.server.WrappedChannel;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

/**
 *default message event execute
 */
@Slf4j
public class DefaultMessageEventListener implements  MessageEventListener{
    @Override
    public EventBehavior channelRead(ChannelHandlerContext ctx, WrappedChannel channel, Object msg) {
        if(log.isDebugEnabled()){
            log.debug("Message received on channel {}",channel.id().asShortText());
        }
        if(msg != null){
        }
        return null;
    }
}
