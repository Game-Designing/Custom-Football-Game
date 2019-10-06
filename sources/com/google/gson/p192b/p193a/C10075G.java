package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.b.a.G */
/* compiled from: TypeAdapters */
class C10075G extends C10054C<StringBuilder> {
    C10075G() {
    }

    /* renamed from: a */
    public StringBuilder m32869a(JsonReader in) throws IOException {
        if (in.peek() != JsonToken.NULL) {
            return new StringBuilder(in.nextString());
        }
        in.nextNull();
        return null;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, StringBuilder value) throws IOException {
        out.value(value == null ? null : value.toString());
    }
}
