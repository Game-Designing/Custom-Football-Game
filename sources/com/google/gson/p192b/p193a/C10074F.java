package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigInteger;

/* renamed from: com.google.gson.b.a.F */
/* compiled from: TypeAdapters */
class C10074F extends C10054C<BigInteger> {
    C10074F() {
    }

    /* renamed from: a */
    public BigInteger m32865a(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        try {
            return new BigInteger(in.nextString());
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException((Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, BigInteger value) throws IOException {
        out.value((Number) value);
    }
}
