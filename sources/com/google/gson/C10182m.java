package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.google.gson.m */
/* compiled from: Gson */
class C10182m extends C10054C<AtomicLong> {

    /* renamed from: a */
    final /* synthetic */ C10054C f30870a;

    C10182m(C10054C c) {
        this.f30870a = c;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, AtomicLong value) throws IOException {
        this.f30870a.mo33198a(out, Long.valueOf(value.get()));
    }

    /* renamed from: a */
    public AtomicLong m33140a(JsonReader in) throws IOException {
        return new AtomicLong(((Number) this.f30870a.mo33197a(in)).longValue());
    }
}
