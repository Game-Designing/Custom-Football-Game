package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.util.ByteBufferBackedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class ByteBufferDeserializer extends StdScalarDeserializer<ByteBuffer> {
    public /* bridge */ /* synthetic */ Object deserialize(JsonParser x0, DeserializationContext x1, Object x2) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) x2;
        deserialize(x0, x1, byteBuffer);
        return byteBuffer;
    }

    protected ByteBufferDeserializer() {
        super(ByteBuffer.class);
    }

    public ByteBuffer deserialize(JsonParser parser, DeserializationContext cx) throws IOException {
        return ByteBuffer.wrap(parser.getBinaryValue());
    }

    public ByteBuffer deserialize(JsonParser jp, DeserializationContext ctxt, ByteBuffer intoValue) throws IOException {
        OutputStream out = new ByteBufferBackedOutputStream(intoValue);
        jp.readBinaryValue(ctxt.getBase64Variant(), out);
        out.close();
        return intoValue;
    }
}
