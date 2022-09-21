package com.rabbitmq.server;


public class ServerContext {


    private ServerContext(){

    }

    public static ServerContext instance = new ServerContext();

    public static ServerContext getInstance(){
        return instance;
    }

}
