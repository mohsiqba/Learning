package com.mohsin.lld.logger;


public class Logger {
    ILoggerPublisher loggerPublisher;
    private static final Logger INSTANCE = new Logger();

    private Logger() {
    }

    public static Logger getInstance() {
        return INSTANCE;
    }

    void info(String message) {
        loggerPublisher.publish(new LogMessage(MessageSeverity.INFO,message));
    }

    void warn(String message) {
        loggerPublisher.publish(new LogMessage(MessageSeverity.WARN,message));
    }

    void debug(String message) {
        loggerPublisher.publish(new LogMessage(MessageSeverity.DEBUG,message));
    }

    void error(String message) {
        loggerPublisher.publish(new LogMessage(MessageSeverity.ERROR,message));
    }

    public void setLoggerPublisher(ILoggerPublisher loggerPublisher) {
        this.loggerPublisher = loggerPublisher;
    }
}
