package com.rabbitmq.server;

import io.netty.channel.ChannelException;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.Data;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author xqq
 * @date 2022/9/19 22:23
 */
@Data
public abstract class Service {

    /**
     * socket type
     */
    protected SocketType socketType = SocketType.NORMAL;

    /**
     * bind the port ,default is 8000
     */
    protected int port = 8000;

    /**
     * if the serve have multiple ip we can assign the single ip
     */
    protected String ip;

    /**
     * whether to enable keepAlive
     */
    protected boolean keepAlive = true;

    /**
     * whether to enable tcpNoDelay
     */
    protected boolean tcpNoDelay = true;

    /**
     * the number of worker thread pool
     */
    protected int workerCount;

    /**
     * whether to open executor thread pool
     */
    protected boolean openExecutor = false;

    /**
     * the thread pool are for processing message event
     */
    protected ExecutorService messageExecutor;

    /**
     * the thread pool are for processing channel event business
     */
    protected ExecutorService channelExecutor;

    /**
     * the thread poll are for processing exception event
     */
    protected ExecutorService exceptionExecutor;

    /**
     * the minimum number of thread pool that it is for processing message event
     */
    protected int corePoolSize = 10;

    /**
     * the maximum number of thread pool that it is for processing message event
     */
    protected int maximumPoolSize = 150;

    /**
     * the maximum number of queue capacity that it is for processing message event
     */
    protected int queueCapacity = 1000000;

    /**
     * whether to set heartbeat detection
     */
    protected boolean checkHeartbeat = true;

    /**
     * read idle time during heartbeat check
     */
    protected int readIdleTimeSeconds = 30;

    /**
     * write idle time during heartbeat check
     */
    protected int writeIdleTimeSeconds = 10;

    protected ChannelInboundHandlerAdapter heartbeatHandler;

    protected LinkedHashMap<String, ChannelHandlerFunc> handlers = new LinkedHashMap<>();

    protected List<EventListener> eventListeners = new ArrayList<>();

    protected EventDispatcher eventDispatcher;

    public Service(){
        //default number of worker threads
        this.workerCount = Runtime.getRuntime().availableProcessors() + 1;
        //add hooks when the jvm shut down
        Runtime.getRuntime().addShutdownHook(new ShutdownHook(this));
    }

    protected void init(){
        if(openExecutor){
            messageExecutor = new ThreadPoolExecutor(
                    this.corePoolSize,
                    this.maximumPoolSize,
                    60L,
                    TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(this.queueCapacity),
                    new BasicThreadFactory.Builder().namingPattern("MessageEventProcessor-%d").daemon(true).build(),
                    new ThreadPoolExecutor.AbortPolicy()
            );
            exceptionExecutor = Executors.newCachedThreadPool(
                    new BasicThreadFactory.Builder().namingPattern("ExceptionEventProcessor-%d").daemon(true).build()
            );

            channelExecutor = Executors.newCachedThreadPool(
                    new BasicThreadFactory.Builder().namingPattern("ChannelEventProcessor-%d").daemon(true).build()
            );

        }
    }

    public abstract void shutdown();




    class ShutdownHook extends Thread{
        private Service service;

        public ShutdownHook(Service service){
            this.service = service;
        }

        @Override
        public void run() {
        }
    }



}
