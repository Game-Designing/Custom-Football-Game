package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbwj implements zzdti<zzavf> {

    /* renamed from: a */
    private final zzbvz f25946a;

    /* renamed from: b */
    private final zzdtu<Context> f25947b;

    /* renamed from: c */
    private final zzdtu<zzcxv> f25948c;

    private zzbwj(zzbvz zzbvz, zzdtu<Context> zzdtu, zzdtu<zzcxv> zzdtu2) {
        this.f25946a = zzbvz;
        this.f25947b = zzdtu;
        this.f25948c = zzdtu2;
    }

    /* renamed from: a */
    public static zzbwj m27870a(zzbvz zzbvz, zzdtu<Context> zzdtu, zzdtu<zzcxv> zzdtu2) {
        return new zzbwj(zzbvz, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzavf zzavf = new zzavf((Context) this.f25947b.get(), ((zzcxv) this.f25948c.get()).f27602f);
        zzdto.m30114a(zzavf, "Cannot return null from a non-@Nullable @Provides method");
        return zzavf;
    }
}
