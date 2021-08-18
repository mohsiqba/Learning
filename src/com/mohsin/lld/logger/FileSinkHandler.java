package com.mohsin.lld.logger;

public class FileSinkHandler implements ISinkHandler{
    private ILogMessageHandler logMessageHandler;

    @Override
    public void writeMessage(LogMessage message) {
        logMessageHandler.flushMessage("[file]", message);
    }

    public FileSinkHandler(ILogMessageHandler logMessageHandler) {
        this.logMessageHandler = logMessageHandler;
    }
}
