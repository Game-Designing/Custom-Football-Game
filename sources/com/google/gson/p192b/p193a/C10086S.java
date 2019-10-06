package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

/* renamed from: com.google.gson.b.a.S */
/* compiled from: TypeAdapters */
class C10086S extends C10054C<Locale> {
    C10086S() {
    }

    /* renamed from: a */
    public Locale m32910a(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        StringTokenizer tokenizer = new StringTokenizer(in.nextString(), "_");
        String language = null;
        String country = null;
        String variant = null;
        if (tokenizer.hasMoreElements()) {
            language = tokenizer.nextToken();
        }
        if (tokenizer.hasMoreElements()) {
            country = tokenizer.nextToken();
        }
        if (tokenizer.hasMoreElements()) {
            variant = tokenizer.nextToken();
        }
        if (country == null && variant == null) {
            return new Locale(language);
        }
        if (variant == null) {
            return new Locale(language, country);
        }
        return new Locale(language, country, variant);
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Locale value) throws IOException {
        out.value(value == null ? null : value.toString());
    }
}
