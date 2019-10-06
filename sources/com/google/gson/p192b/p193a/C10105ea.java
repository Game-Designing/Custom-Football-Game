package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.b.a.ea */
/* compiled from: TypeAdapters */
class C10105ea extends C10054C<Boolean> {
    C10105ea() {
    }

    /* renamed from: a */
    public Boolean m32952a(JsonReader in) throws IOException {
        if (in.peek() != JsonToken.NULL) {
            return Boolean.valueOf(in.nextString());
        }
        in.nextNull();
        return null;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Boolean value) throws IOException {
        out.value(value == null ? "null" : value.toString());
    }
}
