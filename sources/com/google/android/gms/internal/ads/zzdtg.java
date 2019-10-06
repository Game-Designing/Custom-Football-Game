package com.google.android.gms.internal.ads;

public final class zzdtg<T> implements zzdti<T> {

    /* renamed from: a */
    private zzdtu<T> f28299a;

    public final T get() {
        zzdtu<T> zzdtu = this.f28299a;
        if (zzdtu != null) {
            return zzdtu.get();
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public static <T> void m30106a(zzdtu<T> zzdtu, zzdtu<T> zzdtu2) {
        zzdto.m30113a(zzdtu2);
        zzdtg zzdtg = (zzdtg) zzdtu;
        if (zzdtg.f28299a == null) {
            zzdtg.f28299a = zzdtu2;
            return;
        }
        throw new IllegalStateException();
    }
}
