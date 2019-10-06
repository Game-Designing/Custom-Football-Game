package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;

/* renamed from: com.google.gson.b.a.E */
/* compiled from: TypeAdapters */
class C10073E extends C10054C<BigDecimal> {
    C10073E() {
    }

    /* renamed from: a */
    public BigDecimal m32861a(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        try {
            return new BigDecimal(in.nextString());
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException((Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, BigDecimal value) throws IOException {
        out.value((Number) value);
    }
}
