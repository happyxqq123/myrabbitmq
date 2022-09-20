package com.rabbitmq.server;

import io.netty.channel.ChannelException;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import sun.nio.ch.ThreadPool;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author xqq
 * @date 2022/9/19 22:23
 */
public abstract class Service {

    /**
     * socket type
     */
    protected SocketType socketType = SocketType.NORMAL;

    /**
     * bind the port ,default is 8000
     */
    @Getter
    @Setter
    protected int port = 8000;

    /**
     * if the serve have multiple ip we can assign the single ip
     */
    @Getter
    @Setter
    protected String ip;

    /**
     * whether to enable keepAlive
     */
    @Getter
    @Setter
    protected boolean keepAlive = true;

    /**
     * whether to enable tcpNoDelay
     */
    @Getter
    @Setter
    protected boolean tcpNoDelay = true;

    /**
     * the number of worker thread pool
     */
    @Getter
    @Setter
    protected int workerCount;

    /**
     * whether to open executor thread pool
     */
    @Getter
    @Setter
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
    @Getter
    @Setter
    protected int corePoolSize = 10;

    /**
     * the maximum number of thread pool that it is for processing message event
     */
    @Getter
    @Setter
    protected int maximumPoolSize = 150;

    /**
     * the maximum number of queue capacity that it is for processing message event
     */
    @Getter
    @Setter
    protected int queueCapacity = 1000000;

    /**
     * whether to set heartbeat detection
     */
    @Getter
    @Setter
    protected boolean checkHeartbeat = true;

    /**
     * read idle time during heartbeat check
     */
    @Getter
    @Setter
    protected int readIdleTimeSeconds = 30;

    /**
     * write idle time during heartbeat check
     */
    @Getter
    @Setter
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
            // it is for processing message  event business
            messageExecutor = new ThreadPoolExecutor(
                    this.corePoolSize,
                    this.maximumPoolSize,
                    60L,
                    TimeUnit.SECONDS,
                    new LinkedBlockingQueue<Runnable>(this.queueCapacity),
                    new BasicThreadFactory.Builder().namingPattern("MessageEventProcessor-%d").daemon(true).build(),
                    new ThreadPoolExecutor.AbortPolicy()
            );
            //process exception event business , it will due to cpu 100%
            exceptionExecutor = Executors.newCachedThreadPool(
                    new BasicThreadFactory.Builder().namingPattern("ExceptionEventProcessor-%d").daemon(true).build()
            );

            //process channel event business ,it will due to cpu 100%
            channelExecutor = Executors.newCachedThreadPool(
                    new BasicThreadFactory.Builder().namingPattern("ChannelEventProcessor-%d").daemon(true).build()
            );


        }
    }

    public abstract void shutdown();

    /**
     * set a new message executor before shutdown the old message executor and then the new message executor will execute the remaining runnable task
     * @param executor
     */
    public void setExecutor(ExecutorService executor){
        if(executor == null){
            throw new NullPointerException("exception is null");
        }
        ExecutorService preExecutor = this.messageExecutor;
        this.messageExecutor = executor;
        List<Runnable> tasks = preExecutor.shutdownNow();
        tasks.parallelStream().forEach(task -> this.messageExecutor.execute(task));
    }

    /**
     * return the executor active count
     * @return
     */
    public int getExecutorActiveCount(){
        if(messageExecutor instanceof ThreadPoolExecutor){
            return ((ThreadPoolExecutor) messageExecutor).getActiveCount();
        }
        return -1;
    }

    /**
     * return the approximate  executor completed task count
     * @return
     */
    public long getExecutorCompletedTaskCount(){
        if(messageExecutor instanceof ThreadPoolExecutor){
            return ((ThreadPoolExecutor) messageExecutor).getCompletedTaskCount();
        }
        return -1;
    }

    public int getExecutorLargestPoolSize(){
        if(messageExecutor instanceof ThreadPoolExecutor){
            return ((ThreadPoolExecutor) messageExecutor).getLargestPoolSize();
        }
        return -1;
    }

    public int getExecutorPoolSize(){
        if(messageExecutor instanceof ThreadPoolExecutor){
            return ((ThreadPoolExecutor) messageExecutor).getPoolSize();
        }
        return -1;
    }

    public long getExecutorTaskCount(){
        if(messageExecutor instanceof ThreadPoolExecutor){
            return ((ThreadPoolExecutor) messageExecutor).getTaskCount();
        }
        return -1;
    }

    public long getExecutorQueueSize(){
        if(messageExecutor instanceof ThreadPoolExecutor){
            return ((ThreadPoolExecutor) messageExecutor).getQueue().size();
        }
        return -1;
    }

    public void addEventListener(EventListener eventListener){
        this.eventListeners.add(eventListener);
    }

    public void addChannelHandler(String key, ChannelHandlerFunc handler){
        this.handlers.put(key,handler);
    }

    public LinkedHashMap<String,ChannelHandlerFunc> getHandlers(){
        return handlers;
    }

    public void setHandlers(LinkedHashMap<String, ChannelHandlerFunc> handlers) {
        this.handlers = handlers;
    }

    public List<EventListener> getEventListeners() {
        return eventListeners;
    }

    public void setListeners(List<EventListener> listeners) {
        if (listeners == null) {
            listeners = new ArrayList<>();
        }
        eventListeners = listeners;
    }





    class ShutdownHook extends Thread{
        private Service service;

        public ShutdownHook(Service service){
            this.service = service;
        }

        @Override
        public void run() {
            service.shutdown();
        }
    }



}
