package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.gson.b.a.ja */
/* compiled from: TypeAdapters */
class C10115ja extends C10054C<AtomicBoolean> {
    C10115ja() {
    }

    /* renamed from: a */
    public AtomicBoolean m32981a(JsonReader in) throws IOException {
        return new AtomicBoolean(in.nextBoolean());
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, AtomicBoolean value) throws IOException {
        out.value(value.get());
    }
}
