package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.C10188s;
import com.google.gson.C10192v;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.p192b.C10060B;
import com.google.gson.p192b.C10139b;
import com.google.gson.p192b.C10157q;
import com.google.gson.p192b.C10160t;
import com.google.gson.p192b.C10170z;
import com.google.gson.p195c.C10172a;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.gson.b.a.k */
/* compiled from: MapTypeAdapterFactory */
public final class C10116k implements C10055D {

    /* renamed from: a */
    private final C10157q f30690a;

    /* renamed from: b */
    final boolean f30691b;

    /* renamed from: com.google.gson.b.a.k$a */
    /* compiled from: MapTypeAdapterFactory */
    private final class C10117a<K, V> extends C10054C<Map<K, V>> {

        /* renamed from: a */
        private final C10054C<K> f30692a;

        /* renamed from: b */
        private final C10054C<V> f30693b;

        /* renamed from: c */
        private final C10170z<? extends Map<K, V>> f30694c;

        public C10117a(Gson context, Type keyType, C10054C<K> keyTypeAdapter, Type valueType, C10054C<V> valueTypeAdapter, C10170z<? extends Map<K, V>> constructor) {
            this.f30692a = new C10135w(context, keyTypeAdapter, keyType);
            this.f30693b = new C10135w(context, valueTypeAdapter, valueType);
            this.f30694c = constructor;
        }

        /* renamed from: a */
        public Map<K, V> m32988a(JsonReader in) throws IOException {
            JsonToken peek = in.peek();
            if (peek == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            Map<K, V> map = (Map) this.f30694c.mo33363a();
            String str = "duplicate key: ";
            if (peek == JsonToken.BEGIN_ARRAY) {
                in.beginArray();
                while (in.hasNext()) {
                    in.beginArray();
                    K key = this.f30692a.mo33197a(in);
                    if (map.put(key, this.f30693b.mo33197a(in)) == null) {
                        in.endArray();
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(key);
                        throw new JsonSyntaxException(sb.toString());
                    }
                }
                in.endArray();
            } else {
                in.beginObject();
                while (in.hasNext()) {
                    C10160t.INSTANCE.promoteNameToValue(in);
                    K key2 = this.f30692a.mo33197a(in);
                    if (map.put(key2, this.f30693b.mo33197a(in)) != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(key2);
                        throw new JsonSyntaxException(sb2.toString());
                    }
                }
                in.endObject();
            }
            return map;
        }

        /* renamed from: a */
        public void mo33198a(JsonWriter out, Map<K, V> map) throws IOException {
            if (map == null) {
                out.nullValue();
            } else if (!C10116k.this.f30691b) {
                out.beginObject();
                for (Entry<K, V> entry : map.entrySet()) {
                    out.name(String.valueOf(entry.getKey()));
                    this.f30693b.mo33198a(out, entry.getValue());
                }
                out.endObject();
            } else {
                boolean hasComplexKeys = false;
                List<JsonElement> keys = new ArrayList<>(map.size());
                List<V> values = new ArrayList<>(map.size());
                for (Entry<K, V> entry2 : map.entrySet()) {
                    C10188s keyElement = this.f30692a.mo33200a(entry2.getKey());
                    keys.add(keyElement);
                    values.add(entry2.getValue());
                    hasComplexKeys |= keyElement.mo33447i() || keyElement.mo33449k();
                }
                if (hasComplexKeys) {
                    out.beginArray();
                    int size = keys.size();
                    for (int i = 0; i < size; i++) {
                        out.beginArray();
                        C10060B.m32834a((C10188s) keys.get(i), out);
                        this.f30693b.mo33198a(out, values.get(i));
                        out.endArray();
                    }
                    out.endArray();
                } else {
                    out.beginObject();
                    int size2 = keys.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        out.name(m32986a((C10188s) keys.get(i2)));
                        this.f30693b.mo33198a(out, values.get(i2));
                    }
                    out.endObject();
                }
            }
        }

        /* renamed from: a */
        private String m32986a(C10188s keyElement) {
            if (keyElement.mo33450l()) {
                C10192v primitive = keyElement.mo33446f();
                if (primitive.mo33484q()) {
                    return String.valueOf(primitive.mo33482o());
                }
                if (primitive.mo33483p()) {
                    return Boolean.toString(primitive.mo33433a());
                }
                if (primitive.mo33485r()) {
                    return primitive.mo33439h();
                }
                throw new AssertionError();
            } else if (keyElement.mo33448j()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }

    public C10116k(C10157q constructorConstructor, boolean complexMapKeySerialization) {
        this.f30690a = constructorConstructor;
        this.f30691b = complexMapKeySerialization;
    }

    /* renamed from: a */
    public <T> C10054C<T> mo33201a(Gson gson, C10172a<T> typeToken) {
        Gson gson2 = gson;
        Type type = typeToken.mo33421b();
        if (!Map.class.isAssignableFrom(typeToken.mo33420a())) {
            return null;
        }
        Type[] keyAndValueTypes = C10139b.m33062b(type, C10139b.m33065e(type));
        C10054C a = m32984a(gson2, keyAndValueTypes[0]);
        Gson gson3 = gson;
        C10054C c = a;
        C10117a aVar = new C10117a(gson3, keyAndValueTypes[0], c, keyAndValueTypes[1], gson2.getAdapter(C10172a.m33120a(keyAndValueTypes[1])), this.f30690a.mo33364a(typeToken));
        return aVar;
    }

    /* renamed from: a */
    private C10054C<?> m32984a(Gson context, Type keyType) {
        if (keyType == Boolean.TYPE || keyType == Boolean.class) {
            return C10118ka.f30727f;
        }
        return context.getAdapter(C10172a.m33120a(keyType));
    }
}
