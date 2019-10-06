package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;

public final class zzbqn implements zzdti<zzb> {

    /* renamed from: a */
    private final zzbqm f25797a;

    /* renamed from: b */
    private final zzdtu<Context> f25798b;

    /* renamed from: c */
    private final zzdtu<zzavb> f25799c;

    private zzbqn(zzbqm zzbqm, zzdtu<Context> zzdtu, zzdtu<zzavb> zzdtu2) {
        this.f25797a = zzbqm;
        this.f25798b = zzdtu;
        this.f25799c = zzdtu2;
    }

    /* renamed from: a */
    public static zzbqn m27695a(zzbqm zzbqm, zzdtu<Context> zzdtu, zzdtu<zzavb> zzdtu2) {
        return new zzbqn(zzbqm, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzb zzb = new zzb((Context) this.f25798b.get(), (zzavb) this.f25799c.get(), null);
        zzdto.m30114a(zzb, "Cannot return null from a non-@Nullable @Provides method");
        return zzb;
    }
}
