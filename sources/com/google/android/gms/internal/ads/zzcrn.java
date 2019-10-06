package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcrn implements zzdti<zzcrk> {

    /* renamed from: a */
    private final zzdtu<zzbbh<String>> f27280a;

    /* renamed from: b */
    private final zzdtu<Executor> f27281b;

    private zzcrn(zzdtu<zzbbh<String>> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f27280a = zzdtu;
        this.f27281b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcrn m28825a(zzdtu<zzbbh<String>> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcrn(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcrk((zzbbh) this.f27280a.get(), (Executor) this.f27281b.get());
    }
}
