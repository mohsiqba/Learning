package com.mohsin.lld.logger;

/**
 * SUBJECT : OBSERVER
 */
public interface ILoggerPublisher {

    void add(MessageSeverity severity,ISinkHandler subscriber);
    void remove(MessageSeverity severity,ISinkHandler subscriber);
    void publish(LogMessage message);
}
