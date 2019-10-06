package com.fasterxml.jackson.core.p134io;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* renamed from: com.fasterxml.jackson.core.io.JsonEOFException */
public class JsonEOFException extends JsonParseException {
    protected final JsonToken _token;

    public JsonEOFException(JsonParser p, JsonToken token, String msg) {
        super(p, msg);
        this._token = token;
    }
}
