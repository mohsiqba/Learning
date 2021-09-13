package com.mohsin.lld.logger;

public interface ISinkHandler {
    void writeMessage(LogMessage message);
}
