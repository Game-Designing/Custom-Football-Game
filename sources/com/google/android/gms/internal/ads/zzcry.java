package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcry implements zzdti<zzcrv> {

    /* renamed from: a */
    private final zzdtu<Executor> f27301a;

    /* renamed from: b */
    private final zzdtu<zzawm> f27302b;

    private zzcry(zzdtu<Executor> zzdtu, zzdtu<zzawm> zzdtu2) {
        this.f27301a = zzdtu;
        this.f27302b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcry m28832a(zzdtu<Executor> zzdtu, zzdtu<zzawm> zzdtu2) {
        return new zzcry(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcrv((Executor) this.f27301a.get(), (zzawm) this.f27302b.get());
    }
}
