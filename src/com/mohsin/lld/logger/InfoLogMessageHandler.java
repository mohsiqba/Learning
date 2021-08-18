package com.mohsin.lld.logger;

import static com.mohsin.lld.logger.ConfigUtils.LOGGER_LEVEL;

public class InfoLogMessageHandler implements ILogMessageHandler{

    private ILogMessageHandler logMessageHandler;

    @Override
    public void setNextHandler(ILogMessageHandler logMessageHandler) {
        this.logMessageHandler=logMessageHandler;
    }

    @Override
    public void flushMessage(String sinkMessage, LogMessage logMessage) {
        if(logMessage.getSeverity().getSeverity()>=LOGGER_LEVEL && MessageSeverity.INFO.getSeverity()>=LOGGER_LEVEL){
            System.out.println(sinkMessage+"["+logMessage.getSeverity()+"]::"+logMessage.getMessage());
        }
        if(logMessageHandler!=null){
            logMessageHandler.flushMessage(sinkMessage, logMessage);
        }
    }
}
