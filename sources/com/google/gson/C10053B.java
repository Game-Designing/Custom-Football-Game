package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.B */
/* compiled from: TypeAdapter */
class C10053B extends C10054C<T> {

    /* renamed from: a */
    final /* synthetic */ C10054C f30641a;

    C10053B(C10054C this$0) {
        this.f30641a = this$0;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, T value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            this.f30641a.mo33198a(out, value);
        }
    }

    /* renamed from: a */
    public T mo33197a(JsonReader reader) throws IOException {
        if (reader.peek() != JsonToken.NULL) {
            return this.f30641a.mo33197a(reader);
        }
        reader.nextNull();
        return null;
    }
}
