package com.google.android.gms.internal.ads;

public final class zzdtt<T> implements zzdtu<T> {

    /* renamed from: a */
    private static final Object f28314a = new Object();

    /* renamed from: b */
    private volatile zzdtu<T> f28315b;

    /* renamed from: c */
    private volatile Object f28316c = f28314a;

    private zzdtt(zzdtu<T> zzdtu) {
        this.f28315b = zzdtu;
    }

    public final T get() {
        T t = this.f28316c;
        if (t != f28314a) {
            return t;
        }
        zzdtu<T> zzdtu = this.f28315b;
        if (zzdtu == null) {
            return this.f28316c;
        }
        T t2 = zzdtu.get();
        this.f28316c = t2;
        this.f28315b = null;
        return t2;
    }

    /* renamed from: a */
    public static <P extends zzdtu<T>, T> zzdtu<T> m30124a(P p) {
        if ((p instanceof zzdtt) || (p instanceof zzdth)) {
            return p;
        }
        zzdto.m30113a(p);
        return new zzdtt((zzdtu) p);
    }
}
