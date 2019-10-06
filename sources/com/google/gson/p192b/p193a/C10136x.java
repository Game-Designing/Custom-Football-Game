package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* renamed from: com.google.gson.b.a.x */
/* compiled from: TypeAdapters */
class C10136x extends C10054C<AtomicIntegerArray> {
    C10136x() {
    }

    /* renamed from: a */
    public AtomicIntegerArray m33037a(JsonReader in) throws IOException {
        List<Integer> list = new ArrayList<>();
        in.beginArray();
        while (in.hasNext()) {
            try {
                list.add(Integer.valueOf(in.nextInt()));
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException((Throwable) e);
            }
        }
        in.endArray();
        int length = list.size();
        AtomicIntegerArray array = new AtomicIntegerArray(length);
        for (int i = 0; i < length; i++) {
            array.set(i, ((Integer) list.get(i)).intValue());
        }
        return array;
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, AtomicIntegerArray value) throws IOException {
        out.beginArray();
        int length = value.length();
        for (int i = 0; i < length; i++) {
            out.value((long) value.get(i));
        }
        out.endArray();
    }
}
