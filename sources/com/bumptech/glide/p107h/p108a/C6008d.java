package com.bumptech.glide.p107h.p108a;

import android.util.Log;
import java.util.List;
import p002b.p003c.p053g.p061f.C1269m;
import p002b.p003c.p053g.p061f.C1270n;
import p002b.p003c.p053g.p061f.C1271o;

/* renamed from: com.bumptech.glide.h.a.d */
/* compiled from: FactoryPools */
public final class C6008d {

    /* renamed from: a */
    private static final C6012d<Object> f10644a = new C6005a();

    /* renamed from: com.bumptech.glide.h.a.d$a */
    /* compiled from: FactoryPools */
    public interface C6009a<T> {
        T create();
    }

    /* renamed from: com.bumptech.glide.h.a.d$b */
    /* compiled from: FactoryPools */
    private static final class C6010b<T> implements C1269m<T> {

        /* renamed from: a */
        private final C6009a<T> f10645a;

        /* renamed from: b */
        private final C6012d<T> f10646b;

        /* renamed from: c */
        private final C1269m<T> f10647c;

        C6010b(C1269m<T> pool, C6009a<T> factory, C6012d<T> resetter) {
            this.f10647c = pool;
            this.f10645a = factory;
            this.f10646b = resetter;
        }

        /* renamed from: a */
        public T mo9148a() {
            T result = this.f10647c.mo9148a();
            if (result == null) {
                result = this.f10645a.create();
                String str = "FactoryPools";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Created new ");
                    sb.append(result.getClass());
                    Log.v(str, sb.toString());
                }
            }
            if (result instanceof C6011c) {
                ((C6011c) result).mo18779e().mo18794a(false);
            }
            return result;
        }

        /* renamed from: a */
        public boolean mo9149a(T instance) {
            if (instance instanceof C6011c) {
                ((C6011c) instance).mo18779e().mo18794a(true);
            }
            this.f10646b.mo18792a(instance);
            return this.f10647c.mo9149a(instance);
        }
    }

    /* renamed from: com.bumptech.glide.h.a.d$c */
    /* compiled from: FactoryPools */
    public interface C6011c {
        /* renamed from: e */
        C6015g mo18779e();
    }

    /* renamed from: com.bumptech.glide.h.a.d$d */
    /* compiled from: FactoryPools */
    public interface C6012d<T> {
        /* renamed from: a */
        void mo18792a(T t);
    }

    /* renamed from: a */
    public static <T extends C6011c> C1269m<T> m11222a(int size, C6009a<T> factory) {
        return m11223a((C1269m<T>) new C1270n<T>(size), factory);
    }

    /* renamed from: b */
    public static <T extends C6011c> C1269m<T> m11225b(int size, C6009a<T> factory) {
        return m11223a((C1269m<T>) new C1271o<T>(size), factory);
    }

    /* renamed from: a */
    public static <T> C1269m<List<T>> m11220a() {
        return m11221a(20);
    }

    /* renamed from: a */
    public static <T> C1269m<List<T>> m11221a(int size) {
        return m11224a(new C1271o(size), new C6006b(), new C6007c());
    }

    /* renamed from: a */
    private static <T extends C6011c> C1269m<T> m11223a(C1269m<T> pool, C6009a<T> factory) {
        return m11224a(pool, factory, m11226b());
    }

    /* renamed from: a */
    private static <T> C1269m<T> m11224a(C1269m<T> pool, C6009a<T> factory, C6012d<T> resetter) {
        return new C6010b(pool, factory, resetter);
    }

    /* renamed from: b */
    private static <T> C6012d<T> m11226b() {
        return f10644a;
    }
}
