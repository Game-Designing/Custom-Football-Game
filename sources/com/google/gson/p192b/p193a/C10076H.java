package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.b.a.H */
/* compiled from: TypeAdapters */
class C10076H extends C10054C<Class> {
    C10076H() {
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo33198a(JsonWriter jsonWriter, Object obj) throws IOException {
        mo33273a(jsonWriter, (Class) obj);
        throw null;
    }

    /* renamed from: a */
    public void mo33273a(JsonWriter out, Class value) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Attempted to serialize java.lang.Class: ");
        sb.append(value.getName());
        sb.append(". Forgot to register a type adapter?");
        throw new UnsupportedOperationException(sb.toString());
    }

    /* renamed from: a */
    public Class mo33197a(JsonReader in) throws IOException {
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }
}
