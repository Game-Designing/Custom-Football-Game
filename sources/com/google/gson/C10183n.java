package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongArray;

/* renamed from: com.google.gson.n */
/* compiled from: Gson */
class C10183n extends C10054C<AtomicLongArray> {

    /* renamed from: a */
    final /* synthetic */ C10054C f30871a;

    C10183n(C10054C c) {
        this.f30871a = c;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, AtomicLongArray value) throws IOException {
        out.beginArray();
        int length = value.length();
        for (int i = 0; i < length; i++) {
            this.f30871a.mo33198a(out, Long.valueOf(value.get(i)));
        }
        out.endArray();
    }

    /* renamed from: a */
    public AtomicLongArray m33144a(JsonReader in) throws IOException {
        List<Long> list = new ArrayList<>();
        in.beginArray();
        while (in.hasNext()) {
            list.add(Long.valueOf(((Number) this.f30871a.mo33197a(in)).longValue()));
        }
        in.endArray();
        int length = list.size();
        AtomicLongArray array = new AtomicLongArray(length);
        for (int i = 0; i < length; i++) {
            array.set(i, ((Long) list.get(i)).longValue());
        }
        return array;
    }
}
