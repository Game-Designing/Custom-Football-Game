package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.Gson;
import com.google.gson.p192b.p193a.C10124p.C10125a;
import com.google.gson.p195c.C10172a;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* renamed from: com.google.gson.b.a.w */
/* compiled from: TypeAdapterRuntimeTypeWrapper */
final class C10135w<T> extends C10054C<T> {

    /* renamed from: a */
    private final Gson f30786a;

    /* renamed from: b */
    private final C10054C<T> f30787b;

    /* renamed from: c */
    private final Type f30788c;

    C10135w(Gson context, C10054C<T> delegate, Type type) {
        this.f30786a = context;
        this.f30787b = delegate;
        this.f30788c = type;
    }

    /* renamed from: a */
    public T mo33197a(JsonReader in) throws IOException {
        return this.f30787b.mo33197a(in);
    }

    /* renamed from: a */
    public void mo33198a(JsonWriter out, T value) throws IOException {
        C10054C chosen = this.f30787b;
        Type runtimeType = m33033a(this.f30788c, (Object) value);
        if (runtimeType != this.f30788c) {
            C10054C runtimeTypeAdapter = this.f30786a.getAdapter(C10172a.m33120a(runtimeType));
            if (!(runtimeTypeAdapter instanceof C10125a)) {
                chosen = runtimeTypeAdapter;
            } else if (!(this.f30787b instanceof C10125a)) {
                chosen = this.f30787b;
            } else {
                chosen = runtimeTypeAdapter;
            }
        }
        chosen.mo33198a(out, value);
    }

    /* renamed from: a */
    private Type m33033a(Type type, Object value) {
        if (value == null) {
            return type;
        }
        if (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) {
            return value.getClass();
        }
        return type;
    }
}
