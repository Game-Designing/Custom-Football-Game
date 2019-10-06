package com.google.android.gms.internal.ads;

public final class zzdtj<T> implements zzdte<T>, zzdti<T> {

    /* renamed from: a */
    private static final zzdtj<Object> f28303a = new zzdtj<>(null);

    /* renamed from: b */
    private final T f28304b;

    /* renamed from: a */
    public static <T> zzdti<T> m30109a(T t) {
        zzdto.m30114a(t, "instance cannot be null");
        return new zzdtj(t);
    }

    private zzdtj(T t) {
        this.f28304b = t;
    }

    public final T get() {
        return this.f28304b;
    }
}
