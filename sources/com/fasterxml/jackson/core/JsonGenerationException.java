package com.fasterxml.jackson.core;

public class JsonGenerationException extends JsonProcessingException {
    protected transient JsonGenerator _processor;

    public JsonGenerationException(String msg, JsonGenerator g) {
        super(msg, (JsonLocation) null);
        this._processor = g;
    }

    public JsonGenerator getProcessor() {
        return this._processor;
    }
}
