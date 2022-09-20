package com.rabbitmq.exception;

/**
 * socket runtime exception
 * @author xqq
 */
public class SocketRuntimeException extends RuntimeException{

    public SocketRuntimeException(){super();}

    public SocketRuntimeException(String message,Throwable cause){super(message,cause);}

    public SocketRuntimeException(String message){super(message);}

    public SocketRuntimeException(Throwable cause){super(cause);}
}
