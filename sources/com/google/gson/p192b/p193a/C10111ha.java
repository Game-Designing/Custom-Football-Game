package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.b.a.ha */
/* compiled from: TypeAdapters */
class C10111ha extends C10054C<Number> {
    C10111ha() {
    }

    /* renamed from: a */
    public Number m32971a(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        try {
            return Integer.valueOf(in.nextInt());
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException((Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Number value) throws IOException {
        out.value(value);
    }
}
