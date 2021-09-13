package com.mohsin.lld.logger;

public class LogMessage {
    private String message;
    private MessageSeverity severity;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(MessageSeverity severity) {
        this.severity = severity;
    }

    public LogMessage(MessageSeverity severity, String message) {
        this.message = message;
        this.severity = severity;
    }
}
