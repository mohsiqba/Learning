package com.mohsin.lld.logger;

public class ConsoleSinkHandler implements ISinkHandler{
    private ILogMessageHandler logMessageHandler;

    @Override
    public void writeMessage(LogMessage message) {
        logMessageHandler.flushMessage("[console]", message);
    }

    public ConsoleSinkHandler(ILogMessageHandler logMessageHandler) {
        this.logMessageHandler = logMessageHandler;
    }
}
