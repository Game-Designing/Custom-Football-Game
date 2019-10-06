package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

public final class zzchb implements zzdti<zzbbh<String>> {

    /* renamed from: a */
    private final zzdtu<zzdh> f26615a;

    /* renamed from: b */
    private final zzdtu<Context> f26616b;

    /* renamed from: c */
    private final zzdtu<zzbbl> f26617c;

    private zzchb(zzdtu<zzdh> zzdtu, zzdtu<Context> zzdtu2, zzdtu<zzbbl> zzdtu3) {
        this.f26615a = zzdtu;
        this.f26616b = zzdtu2;
        this.f26617c = zzdtu3;
    }

    /* renamed from: a */
    public static zzchb m28431a(zzdtu<zzdh> zzdtu, zzdtu<Context> zzdtu2, zzdtu<zzbbl> zzdtu3) {
        return new zzchb(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        zzbbh a = ((zzbbl) this.f26617c.get()).mo30326a((Callable<T>) new C9104Ri<T>((zzdh) this.f26615a.get(), (Context) this.f26616b.get()));
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
