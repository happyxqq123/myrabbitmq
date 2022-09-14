package com.rabbitmq.server;

import com.rabbitmq.handler.LengthDecoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MqServer {

    private ServerBootstrap serverBootstrap;
    private EventLoopGroup bossEventLoop;
    private EventLoopGroup workerEventLoop;

    public void start(){
        start0();
    }

    public void start0() {
        serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossEventLoop,workerEventLoop);
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new LengthDecoder());
            }
        });
    }



}
