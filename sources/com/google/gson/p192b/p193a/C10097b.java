package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.gson.b.a.b */
/* compiled from: ArrayTypeAdapter */
public final class C10097b<E> extends C10054C<Object> {

    /* renamed from: a */
    public static final C10055D f30671a = new C10094a();

    /* renamed from: b */
    private final Class<E> f30672b;

    /* renamed from: c */
    private final C10054C<E> f30673c;

    public C10097b(Gson context, C10054C<E> componentTypeAdapter, Class<E> componentType) {
        this.f30673c = new C10135w(context, componentTypeAdapter, componentType);
        this.f30672b = componentType;
    }

    /* renamed from: a */
    public Object mo33197a(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        List<E> list = new ArrayList<>();
        in.beginArray();
        while (in.hasNext()) {
            list.add(this.f30673c.mo33197a(in));
        }
        in.endArray();
        int size = list.size();
        Object array = Array.newInstance(this.f30672b, size);
        for (int i = 0; i < size; i++) {
            Array.set(array, i, list.get(i));
        }
        return array;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Object array) throws IOException {
        if (array == null) {
            out.nullValue();
            return;
        }
        out.beginArray();
        int length = Array.getLength(array);
        for (int i = 0; i < length; i++) {
            this.f30673c.mo33198a(out, Array.get(array, i));
        }
        out.endArray();
    }
}
