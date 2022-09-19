package com.rabbitmq.server;

import lombok.extern.slf4j.Slf4j;

/**
 * event dispatcher(dispatch message ，channel, exception event to the corresponding listener, avoid use thread pool model to let the worker thread return)
 */
@Slf4j
public class EventDispatcher {
}
