package com.google.gson.p195c;

import com.google.gson.p192b.C10068a;
import com.google.gson.p192b.C10139b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* renamed from: com.google.gson.c.a */
/* compiled from: TypeToken */
public class C10172a<T> {

    /* renamed from: a */
    final Class<? super T> f30859a;

    /* renamed from: b */
    final Type f30860b;

    /* renamed from: c */
    final int f30861c;

    protected C10172a() {
        this.f30860b = m33121b(getClass());
        this.f30859a = C10139b.m33065e(this.f30860b);
        this.f30861c = this.f30860b.hashCode();
    }

    C10172a(Type type) {
        C10068a.m32842a(type);
        this.f30860b = C10139b.m33060b(type);
        this.f30859a = C10139b.m33065e(this.f30860b);
        this.f30861c = this.f30860b.hashCode();
    }

    /* renamed from: b */
    static Type m33121b(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (!(superclass instanceof Class)) {
            return C10139b.m33060b(((ParameterizedType) superclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    /* renamed from: a */
    public final Class<? super T> mo33420a() {
        return this.f30859a;
    }

    /* renamed from: b */
    public final Type mo33421b() {
        return this.f30860b;
    }

    public final int hashCode() {
        return this.f30861c;
    }

    public final boolean equals(Object o) {
        return (o instanceof C10172a) && C10139b.m33059a(this.f30860b, ((C10172a) o).f30860b);
    }

    public final String toString() {
        return C10139b.m33068h(this.f30860b);
    }

    /* renamed from: a */
    public static C10172a<?> m33120a(Type type) {
        return new C10172a<>(type);
    }

    /* renamed from: a */
    public static <T> C10172a<T> m33119a(Class<T> type) {
        return new C10172a<>(type);
    }
}
