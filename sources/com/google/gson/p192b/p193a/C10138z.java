package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.b.a.z */
/* compiled from: TypeAdapters */
class C10138z extends C10054C<Number> {
    C10138z() {
    }

    /* renamed from: a */
    public Number m33045a(JsonReader in) throws IOException {
        if (in.peek() != JsonToken.NULL) {
            return Float.valueOf((float) in.nextDouble());
        }
        in.nextNull();
        return null;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Number value) throws IOException {
        out.value(value);
    }
}
