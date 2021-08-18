package com.mohsin.lld.logger;

public enum MessageSeverity {
    WARN(1),
    DEBUG(2),
    INFO(3),
    ERROR(4);

    private int severity;
    MessageSeverity(int severity) {this.severity=severity;}
    public int getSeverity() {
        return severity;
    }
}
