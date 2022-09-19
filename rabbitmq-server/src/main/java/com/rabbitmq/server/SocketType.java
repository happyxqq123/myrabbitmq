package com.rabbitmq.server;

/**
 * @author xqq
 * @date 2022/9/19 22:24
 */
public enum SocketType {
    /**
     * normal socket
     */
    NORMAL,
    /**
     * MQTT socket
     */
    MQTT,
    /**
     * MQTT web socket
     */
    MQTT_WS;
}
