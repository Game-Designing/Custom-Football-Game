package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Currency;

/* renamed from: com.google.gson.b.a.N */
/* compiled from: TypeAdapters */
class C10082N extends C10054C<Currency> {
    C10082N() {
    }

    /* renamed from: a */
    public Currency m32897a(JsonReader in) throws IOException {
        return Currency.getInstance(in.nextString());
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Currency value) throws IOException {
        out.value(value.getCurrencyCode());
    }
}
