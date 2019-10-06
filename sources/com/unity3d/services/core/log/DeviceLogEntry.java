package com.unity3d.services.core.log;

class DeviceLogEntry {
    private DeviceLogLevel _logLevel = null;
    private String _originalMessage = null;
    private StackTraceElement _stackTraceElement = null;

    public DeviceLogEntry(DeviceLogLevel logLevel, String originalMessage, StackTraceElement stackTraceElement) {
        this._logLevel = logLevel;
        this._originalMessage = originalMessage;
        this._stackTraceElement = stackTraceElement;
    }

    public DeviceLogLevel getLogLevel() {
        return this._logLevel;
    }

    public String getParsedMessage() {
        String message = this._originalMessage;
        String className = "UnknownClass";
        String methodName = "unknownMethod";
        int lineNumber = -1;
        StackTraceElement stackTraceElement = this._stackTraceElement;
        if (stackTraceElement != null) {
            className = stackTraceElement.getClassName();
            methodName = this._stackTraceElement.getMethodName();
            lineNumber = this._stackTraceElement.getLineNumber();
        }
        if (message != null && !message.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(" :: ");
            sb.append(message);
            message = sb.toString();
        }
        if (message == null) {
            message = "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" (line:");
        sb2.append(lineNumber);
        sb2.append(")");
        String lineNumberPart = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(className);
        sb3.append(".");
        sb3.append(methodName);
        sb3.append("()");
        sb3.append(lineNumberPart);
        sb3.append(message);
        return sb3.toString();
    }
}
