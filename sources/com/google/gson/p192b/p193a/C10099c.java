package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.Gson;
import com.google.gson.p192b.C10139b;
import com.google.gson.p192b.C10157q;
import com.google.gson.p192b.C10170z;
import com.google.gson.p195c.C10172a;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

/* renamed from: com.google.gson.b.a.c */
/* compiled from: CollectionTypeAdapterFactory */
public final class C10099c implements C10055D {

    /* renamed from: a */
    private final C10157q f30676a;

    /* renamed from: com.google.gson.b.a.c$a */
    /* compiled from: CollectionTypeAdapterFactory */
    private static final class C10100a<E> extends C10054C<Collection<E>> {

        /* renamed from: a */
        private final C10054C<E> f30677a;

        /* renamed from: b */
        private final C10170z<? extends Collection<E>> f30678b;

        public C10100a(Gson context, Type elementType, C10054C<E> elementTypeAdapter, C10170z<? extends Collection<E>> constructor) {
            this.f30677a = new C10135w(context, elementTypeAdapter, elementType);
            this.f30678b = constructor;
        }

        /* renamed from: a */
        public Collection<E> m32938a(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            Collection<E> collection = (Collection) this.f30678b.mo33363a();
            in.beginArray();
            while (in.hasNext()) {
                collection.add(this.f30677a.mo33197a(in));
            }
            in.endArray();
            return collection;
        }

        /* renamed from: a */
        public void mo33198a(JsonWriter out, Collection<E> collection) throws IOException {
            if (collection == null) {
                out.nullValue();
                return;
            }
            out.beginArray();
            for (E element : collection) {
                this.f30677a.mo33198a(out, element);
            }
            out.endArray();
        }
    }

    public C10099c(C10157q constructorConstructor) {
        this.f30676a = constructorConstructor;
    }

    /* renamed from: a */
    public <T> C10054C<T> mo33201a(Gson gson, C10172a<T> typeToken) {
        Type type = typeToken.mo33421b();
        Class<? super T> rawType = typeToken.mo33420a();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type elementType = C10139b.m33053a(type, rawType);
        return new C10100a<>(gson, elementType, gson.getAdapter(C10172a.m33120a(elementType)), this.f30676a.mo33364a(typeToken));
    }
}
