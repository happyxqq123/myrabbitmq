package com.rabbitmq.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AcceptorIdleStateTrigger extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleState state = ((IdleStateEvent) evt).state();
            if (state == IdleState.READER_IDLE) {
                log.info("客户端 {} 读超时，关闭连接 ", ctx.channel().remoteAddress());
                ctx.close();
            } else if (state == IdleState.WRITER_IDLE) {
                log.info("客户端 {} 写超时，关闭连接 ", ctx.channel().remoteAddress());
                ctx.close();
            } else if (state == IdleState.ALL_IDLE) {
                log.info("客户端 {} 读写超时，关闭连接 ", ctx.channel().remoteAddress());
                ctx.close();
            }
        } else {
            log.info("AcceptorIdleStateTrigger userEventTriggered {} ", ctx.channel().remoteAddress());
            super.userEventTriggered(ctx, evt);
        }
    }
}
