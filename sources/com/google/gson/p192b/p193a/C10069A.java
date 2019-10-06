package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.b.a.A */
/* compiled from: TypeAdapters */
class C10069A extends C10054C<Number> {
    C10069A() {
    }

    /* renamed from: a */
    public Number m32845a(JsonReader in) throws IOException {
        if (in.peek() != JsonToken.NULL) {
            return Double.valueOf(in.nextDouble());
        }
        in.nextNull();
        return null;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Number value) throws IOException {
        out.value(value);
    }
}
