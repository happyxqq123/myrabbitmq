package com.rabbitmq.server;

import io.netty.channel.ChannelHandler;

/**
 * @author happyxqq222@163.com
 * @date 2022/09/19/ 22:27
 */
@FunctionalInterface
public interface ChannelHandlerFunc {

    /**
     * new a instance
     * @return
     */
    ChannelHandler newInstance();
}
