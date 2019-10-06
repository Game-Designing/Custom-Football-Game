package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.b.a.D */
/* compiled from: TypeAdapters */
class C10072D extends C10054C<String> {
    C10072D() {
    }

    /* renamed from: a */
    public String m32857a(JsonReader in) throws IOException {
        JsonToken peek = in.peek();
        if (peek == JsonToken.NULL) {
            in.nextNull();
            return null;
        } else if (peek == JsonToken.BOOLEAN) {
            return Boolean.toString(in.nextBoolean());
        } else {
            return in.nextString();
        }
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, String value) throws IOException {
        out.value(value);
    }
}
