package com.mohsin.lld.logger;

/**
 *  ERROR > INFO > DEBUG > WARN
 */
public interface ILogMessageHandler {
    void setNextHandler(ILogMessageHandler logMessageHandler);
    void flushMessage(String sinkMessage,LogMessage logMessage);
}
