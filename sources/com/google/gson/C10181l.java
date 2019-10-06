package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.l */
/* compiled from: Gson */
class C10181l extends C10054C<Number> {
    C10181l() {
    }

    /* renamed from: a */
    public Number m33136a(JsonReader in) throws IOException {
        if (in.peek() != JsonToken.NULL) {
            return Long.valueOf(in.nextLong());
        }
        in.nextNull();
        return null;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Number value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value.toString());
        }
    }
}
