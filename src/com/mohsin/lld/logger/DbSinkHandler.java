package com.mohsin.lld.logger;

public class DbSinkHandler implements ISinkHandler{
    private ILogMessageHandler logMessageHandler;

    @Override
    public void writeMessage(LogMessage message) {
        logMessageHandler.flushMessage("[DB]", message);
    }

    public DbSinkHandler(ILogMessageHandler logMessageHandler) {
        this.logMessageHandler = logMessageHandler;
    }
}
