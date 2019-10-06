package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.UUID;

/* renamed from: com.google.gson.b.a.M */
/* compiled from: TypeAdapters */
class C10081M extends C10054C<UUID> {
    C10081M() {
    }

    /* renamed from: a */
    public UUID m32893a(JsonReader in) throws IOException {
        if (in.peek() != JsonToken.NULL) {
            return UUID.fromString(in.nextString());
        }
        in.nextNull();
        return null;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, UUID value) throws IOException {
        out.value(value == null ? null : value.toString());
    }
}
