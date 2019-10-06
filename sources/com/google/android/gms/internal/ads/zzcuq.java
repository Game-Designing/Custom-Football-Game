package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcuq implements zzdti<zzcul> {

    /* renamed from: a */
    private final zzdtu<zzbbl> f27404a;

    /* renamed from: b */
    private final zzdtu<ScheduledExecutorService> f27405b;

    /* renamed from: c */
    private final zzdtu<String> f27406c;

    /* renamed from: d */
    private final zzdtu<zzcpf> f27407d;

    /* renamed from: e */
    private final zzdtu<Context> f27408e;

    /* renamed from: f */
    private final zzdtu<zzcxv> f27409f;

    private zzcuq(zzdtu<zzbbl> zzdtu, zzdtu<ScheduledExecutorService> zzdtu2, zzdtu<String> zzdtu3, zzdtu<zzcpf> zzdtu4, zzdtu<Context> zzdtu5, zzdtu<zzcxv> zzdtu6) {
        this.f27404a = zzdtu;
        this.f27405b = zzdtu2;
        this.f27406c = zzdtu3;
        this.f27407d = zzdtu4;
        this.f27408e = zzdtu5;
        this.f27409f = zzdtu6;
    }

    /* renamed from: a */
    public static zzcuq m28891a(zzdtu<zzbbl> zzdtu, zzdtu<ScheduledExecutorService> zzdtu2, zzdtu<String> zzdtu3, zzdtu<zzcpf> zzdtu4, zzdtu<Context> zzdtu5, zzdtu<zzcxv> zzdtu6) {
        zzcuq zzcuq = new zzcuq(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5, zzdtu6);
        return zzcuq;
    }

    public final /* synthetic */ Object get() {
        zzcul zzcul = new zzcul((zzbbl) this.f27404a.get(), (ScheduledExecutorService) this.f27405b.get(), (String) this.f27406c.get(), (zzcpf) this.f27407d.get(), (Context) this.f27408e.get(), (zzcxv) this.f27409f.get());
        return zzcul;
    }
}
