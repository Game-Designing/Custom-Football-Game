package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.b.a.ga */
/* compiled from: TypeAdapters */
class C10109ga extends C10054C<Number> {
    C10109ga() {
    }

    /* renamed from: a */
    public Number m32962a(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        try {
            return Short.valueOf((short) in.nextInt());
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException((Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Number value) throws IOException {
        out.value(value);
    }
}
