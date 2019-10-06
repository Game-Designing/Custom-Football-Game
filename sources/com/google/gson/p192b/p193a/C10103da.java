package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.b.a.da */
/* compiled from: TypeAdapters */
class C10103da extends C10054C<Boolean> {
    C10103da() {
    }

    /* renamed from: a */
    public Boolean m32943a(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        } else if (in.peek() == JsonToken.STRING) {
            return Boolean.valueOf(Boolean.parseBoolean(in.nextString()));
        } else {
            return Boolean.valueOf(in.nextBoolean());
        }
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Boolean value) throws IOException {
        out.value(value);
    }
}
