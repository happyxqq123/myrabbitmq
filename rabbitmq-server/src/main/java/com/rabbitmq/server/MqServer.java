package com.rabbitmq.server;

import com.rabbitmq.handler.ProtoBufDecoder;
import com.rabbitmq.handler.ProtoBufEncoder;
import com.rabbitmq.handler.ServerInHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.concurrent.TimeUnit;

public class MqServer {

    private ServerBootstrap serverBootstrap;
    private EventLoopGroup bossEventLoop;
    private EventLoopGroup workerEventLoop;

    private GenericFutureListener genericFutureListener;

    public void setGenericFutureListener(GenericFutureListener genericFutureListener) {
        this.genericFutureListener = genericFutureListener;
    }

    public void start() throws InterruptedException {
        start0();
    }

    public void start0() throws InterruptedException {
        serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossEventLoop,workerEventLoop);
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new LoggingHandler()); //日志
                pipeline.addLast(new LengthFieldBasedFrameDecoder(8192,0,0,0,4));  //消息协议格式 frameLength(4字节）+frame
                pipeline.addLast(new ProtoBufDecoder());  // bytebuf to protobuf 需要释放bytebuf
                pipeline.addLast(new ServerInHandler());  //处理业务需求
                pipeline.addLast(new IdleStateHandler(6, 0 , 0, TimeUnit.SECONDS));
                pipeline.addLast(new LengthFieldPrepender(4));
                pipeline.addLast(new ProtoBufEncoder());
            }
        });
        ChannelFuture channelFuture = serverBootstrap.bind(8888).sync();
        channelFuture.addListener(genericFutureListener);
        channelFuture.channel().closeFuture().sync();
    }





}
