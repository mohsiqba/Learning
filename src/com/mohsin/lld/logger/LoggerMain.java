package com.mohsin.lld.logger;

public class LoggerMain {

    public static void main(String[] args) {

        //set COR Pattern for log level
        ILogMessageHandler warnLogMessageHandler=new WarnLogMessageHandler();
        ILogMessageHandler infoLogMessageHandler=new InfoLogMessageHandler();
        ILogMessageHandler debugLogMessageHandler=new DebugLogMessageHandler();
        ILogMessageHandler errorLogMessageHandler=new ErrorLogMessageHandler();

        errorLogMessageHandler.setNextHandler(infoLogMessageHandler);
        infoLogMessageHandler.setNextHandler(debugLogMessageHandler);
        debugLogMessageHandler.setNextHandler(warnLogMessageHandler);
        warnLogMessageHandler.setNextHandler(null);

        // set sink for each level
        ISinkHandler fileSinkHandler=new FileSinkHandler(errorLogMessageHandler);
        ISinkHandler consoleSinkHandler=new ConsoleSinkHandler(errorLogMessageHandler);
        ISinkHandler dbSinkHandler=new DbSinkHandler(errorLogMessageHandler);

        ILoggerPublisher publisher=new LoggerPublisher();
        publisher.add(MessageSeverity.INFO,consoleSinkHandler);
        publisher.add(MessageSeverity.ERROR,consoleSinkHandler);
        publisher.add(MessageSeverity.ERROR,fileSinkHandler);
        publisher.add(MessageSeverity.ERROR,dbSinkHandler);
        publisher.add(MessageSeverity.DEBUG,fileSinkHandler);
        publisher.add(MessageSeverity.WARN,dbSinkHandler);

        Logger logger=Logger.getInstance();
        logger.setLoggerPublisher(publisher);

        logger.info("mohsin info");
        logger.debug("mohsin debug");
        logger.warn("mohsin warn");
        logger.error("mohsin error");
    }
}
