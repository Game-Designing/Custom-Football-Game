package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10185p;
import com.google.gson.C10188s;
import com.google.gson.C10190t;
import com.google.gson.C10191u;
import com.google.gson.C10192v;
import com.google.gson.JsonElement;
import com.google.gson.p192b.C10161u;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.gson.b.a.T */
/* compiled from: TypeAdapters */
class C10087T extends C10054C<C10188s> {
    C10087T() {
    }

    /* renamed from: a */
    public C10188s m32914a(JsonReader in) throws IOException {
        switch (C10101ca.f30679a[in.peek().ordinal()]) {
            case 1:
                return new C10192v((Number) new C10161u(in.nextString()));
            case 2:
                return new C10192v(Boolean.valueOf(in.nextBoolean()));
            case 3:
                return new C10192v(in.nextString());
            case 4:
                in.nextNull();
                return C10190t.f30874a;
            case 5:
                C10185p array = new C10185p();
                in.beginArray();
                while (in.hasNext()) {
                    array.mo33431a(m32914a(in));
                }
                in.endArray();
                return array;
            case 6:
                C10191u object = new C10191u();
                in.beginObject();
                while (in.hasNext()) {
                    object.mo33467a(in.nextName(), m32914a(in));
                }
                in.endObject();
                return object;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, C10188s value) throws IOException {
        if (value == null || value.mo33448j()) {
            out.nullValue();
        } else if (value.mo33450l()) {
            C10192v primitive = value.mo33446f();
            if (primitive.mo33484q()) {
                out.value(primitive.mo33482o());
            } else if (primitive.mo33483p()) {
                out.value(primitive.mo33433a());
            } else {
                out.value(primitive.mo33439h());
            }
        } else if (value.mo33447i()) {
            out.beginArray();
            Iterator it = value.mo33444d().iterator();
            while (it.hasNext()) {
                mo33198a(out, (C10188s) it.next());
            }
            out.endArray();
        } else if (value.mo33449k()) {
            out.beginObject();
            for (Entry<String, JsonElement> e : value.mo33445e().mo33476m()) {
                out.name((String) e.getKey());
                mo33198a(out, (C10188s) e.getValue());
            }
            out.endObject();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Couldn't write ");
            sb.append(value.getClass());
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
