package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;

@JacksonStdImpl
public class TokenBufferDeserializer extends StdScalarDeserializer<TokenBuffer> {
    public TokenBufferDeserializer() {
        super(TokenBuffer.class);
    }

    public TokenBuffer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        TokenBuffer createBufferInstance = createBufferInstance(p);
        createBufferInstance.deserialize(p, ctxt);
        return createBufferInstance;
    }

    /* access modifiers changed from: protected */
    public TokenBuffer createBufferInstance(JsonParser p) {
        return new TokenBuffer(p);
    }
}
