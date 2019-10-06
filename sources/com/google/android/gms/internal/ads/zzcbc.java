package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcbc implements zzdti<zzcau> {

    /* renamed from: a */
    private final zzdtu<Context> f26295a;

    /* renamed from: b */
    private final zzdtu<zzcan> f26296b;

    /* renamed from: c */
    private final zzdtu<zzdh> f26297c;

    /* renamed from: d */
    private final zzdtu<zzbai> f26298d;

    /* renamed from: e */
    private final zzdtu<zza> f26299e;

    /* renamed from: f */
    private final zzdtu<zzwj> f26300f;

    /* renamed from: g */
    private final zzdtu<Executor> f26301g;

    /* renamed from: h */
    private final zzdtu<zzcxv> f26302h;

    /* renamed from: i */
    private final zzdtu<zzcbi> f26303i;

    /* renamed from: j */
    private final zzdtu<ScheduledExecutorService> f26304j;

    public zzcbc(zzdtu<Context> zzdtu, zzdtu<zzcan> zzdtu2, zzdtu<zzdh> zzdtu3, zzdtu<zzbai> zzdtu4, zzdtu<zza> zzdtu5, zzdtu<zzwj> zzdtu6, zzdtu<Executor> zzdtu7, zzdtu<zzcxv> zzdtu8, zzdtu<zzcbi> zzdtu9, zzdtu<ScheduledExecutorService> zzdtu10) {
        this.f26295a = zzdtu;
        this.f26296b = zzdtu2;
        this.f26297c = zzdtu3;
        this.f26298d = zzdtu4;
        this.f26299e = zzdtu5;
        this.f26300f = zzdtu6;
        this.f26301g = zzdtu7;
        this.f26302h = zzdtu8;
        this.f26303i = zzdtu9;
        this.f26304j = zzdtu10;
    }

    public final /* synthetic */ Object get() {
        zzcau zzcau = new zzcau((Context) this.f26295a.get(), (zzcan) this.f26296b.get(), (zzdh) this.f26297c.get(), (zzbai) this.f26298d.get(), (zza) this.f26299e.get(), (zzwj) this.f26300f.get(), (Executor) this.f26301g.get(), (zzcxv) this.f26302h.get(), (zzcbi) this.f26303i.get(), (ScheduledExecutorService) this.f26304j.get());
        return zzcau;
    }
}
