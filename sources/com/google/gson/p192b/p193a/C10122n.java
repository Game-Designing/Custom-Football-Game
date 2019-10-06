package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.p192b.C10164x;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.gson.b.a.n */
/* compiled from: ObjectTypeAdapter */
public final class C10122n extends C10054C<Object> {

    /* renamed from: a */
    public static final C10055D f30751a = new C10120l();

    /* renamed from: b */
    private final Gson f30752b;

    C10122n(Gson gson) {
        this.f30752b = gson;
    }

    /* renamed from: a */
    public Object mo33197a(JsonReader in) throws IOException {
        switch (C10121m.f30750a[in.peek().ordinal()]) {
            case 1:
                List<Object> list = new ArrayList<>();
                in.beginArray();
                while (in.hasNext()) {
                    list.add(mo33197a(in));
                }
                in.endArray();
                return list;
            case 2:
                Map<String, Object> map = new C10164x<>();
                in.beginObject();
                while (in.hasNext()) {
                    map.put(in.nextName(), mo33197a(in));
                }
                in.endObject();
                return map;
            case 3:
                return in.nextString();
            case 4:
                return Double.valueOf(in.nextDouble());
            case 5:
                return Boolean.valueOf(in.nextBoolean());
            case 6:
                in.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, Object value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        TypeAdapter<Object> typeAdapter = this.f30752b.getAdapter(value.getClass());
        if (typeAdapter instanceof C10122n) {
            out.beginObject();
            out.endObject();
            return;
        }
        typeAdapter.mo33198a(out, value);
    }
}
