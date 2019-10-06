package com.google.gson;

import com.google.gson.p192b.p193a.C10114j;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* renamed from: com.google.gson.C */
/* compiled from: TypeAdapter */
public abstract class C10054C<T> {
    /* renamed from: a */
    public abstract T mo33197a(JsonReader jsonReader) throws IOException;

    /* renamed from: a */
    public abstract void mo33198a(JsonWriter jsonWriter, T t) throws IOException;

    /* renamed from: a */
    public final C10054C<T> mo33199a() {
        return new C10053B(this);
    }

    /* renamed from: a */
    public final C10188s mo33200a(T value) {
        try {
            C10114j jsonWriter = new C10114j();
            mo33198a(jsonWriter, value);
            return jsonWriter.mo33321a();
        } catch (IOException e) {
            throw new JsonIOException((Throwable) e);
        }
    }
}
