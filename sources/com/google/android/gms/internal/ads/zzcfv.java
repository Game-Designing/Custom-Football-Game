package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcfv implements zzdti<Set<zzbuz<AppEventListener>>> {

    /* renamed from: a */
    private final zzcfp f26552a;

    /* renamed from: b */
    private final zzdtu<zzcfz> f26553b;

    /* renamed from: c */
    private final zzdtu<Executor> f26554c;

    private zzcfv(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26552a = zzcfp;
        this.f26553b = zzdtu;
        this.f26554c = zzdtu2;
    }

    /* renamed from: a */
    public static zzcfv m28387a(zzcfp zzcfp, zzdtu<zzcfz> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcfv(zzcfp, zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        Set b = zzcfp.m28373b((zzcfz) this.f26553b.get(), (Executor) this.f26554c.get());
        zzdto.m30114a(b, "Cannot return null from a non-@Nullable @Provides method");
        return b;
    }
}
