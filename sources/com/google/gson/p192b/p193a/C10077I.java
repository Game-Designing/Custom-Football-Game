package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.b.a.I */
/* compiled from: TypeAdapters */
class C10077I extends C10054C<StringBuffer> {
    C10077I() {
    }

    /* renamed from: a */
    public StringBuffer m32877a(JsonReader in) throws IOException {
        if (in.peek() != JsonToken.NULL) {
            return new StringBuffer(in.nextString());
        }
        in.nextNull();
        return null;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, StringBuffer value) throws IOException {
        out.value(value == null ? null : value.toString());
    }
}
