package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.gson.b.a.ia */
/* compiled from: TypeAdapters */
class C10113ia extends C10054C<AtomicInteger> {
    C10113ia() {
    }

    /* renamed from: a */
    public AtomicInteger m32975a(JsonReader in) throws IOException {
        try {
            return new AtomicInteger(in.nextInt());
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException((Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, AtomicInteger value) throws IOException {
        out.value((long) value.get());
    }
}
