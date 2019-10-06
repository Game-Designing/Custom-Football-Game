package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcfy implements zzdti<Set<zzbuz<zzczz>>> {

    /* renamed from: a */
    private final zzcfp f26561a;

    /* renamed from: b */
    private final zzdtu<zzcfz> f26562b;

    /* renamed from: c */
    private final zzdtu<Executor> f26563c;

    private zzcfy(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26561a = zzcfp;
        this.f26562b = zzdtu;
        this.f26563c = zzdtu2;
    }

    /* renamed from: a */
    public static zzcfy m28390a(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcfy(zzcfp, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        Set h = zzcfp.m28379h((zzcfz) this.f26562b.get(), (Executor) this.f26563c.get());
        zzdto.m30114a(h, "Cannot return null from a non-@Nullable @Provides method");
        return h;
    }
}
