package com.rabbitmq.server;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

/**
 * event dispatcher(dispatch message ，channel, exception event to the corresponding listener, avoid use thread pool model to let the worker thread return)
 */
@Slf4j
public class EventDispatcher {

    private Service service;

    public EventDispatcher(Service service) {
        if(service == null){
            throw new IllegalArgumentException("service is null.");
        }
        this.service = service;
    }

    private void doMessageEvent(final ChannelHandlerContext ctx,final WrappedChannel channel,final Object msg){
        try{
            service.getEventListeners().parallelStream().forEach(eventListener -> {
            });

        }catch (Exception ex){

        }
    }



}
