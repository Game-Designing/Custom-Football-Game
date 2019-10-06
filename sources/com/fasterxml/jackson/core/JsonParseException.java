package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.RequestPayload;

public class JsonParseException extends JsonProcessingException {
    protected transient JsonParser _processor;
    protected RequestPayload _requestPayload;

    public JsonParseException(JsonParser p, String msg) {
        super(msg, p == null ? null : p.getCurrentLocation());
        this._processor = p;
    }

    public JsonParseException(JsonParser p, String msg, Throwable root) {
        super(msg, p == null ? null : p.getCurrentLocation(), root);
        this._processor = p;
    }

    public JsonParseException withRequestPayload(RequestPayload p) {
        this._requestPayload = p;
        return this;
    }

    public JsonParser getProcessor() {
        return this._processor;
    }

    public String getMessage() {
        String msg = super.getMessage();
        if (this._requestPayload == null) {
            return msg;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(msg);
        sb.append("\nRequest payload : ");
        this._requestPayload.toString();
        throw null;
    }
}
