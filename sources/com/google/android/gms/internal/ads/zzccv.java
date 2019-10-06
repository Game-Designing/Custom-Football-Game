package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Executor;

public final class zzccv implements zzdti<zzccj> {

    /* renamed from: a */
    private final zzdtu<Context> f26389a;

    /* renamed from: b */
    private final zzdtu<Executor> f26390b;

    /* renamed from: c */
    private final zzdtu<zzdh> f26391c;

    /* renamed from: d */
    private final zzdtu<zzbai> f26392d;

    /* renamed from: e */
    private final zzdtu<zza> f26393e;

    /* renamed from: f */
    private final zzdtu<zzbhf> f26394f;

    public zzccv(zzdtu<Context> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<zzdh> zzdtu3, zzdtu<zzbai> zzdtu4, zzdtu<zza> zzdtu5, zzdtu<zzbhf> zzdtu6) {
        this.f26389a = zzdtu;
        this.f26390b = zzdtu2;
        this.f26391c = zzdtu3;
        this.f26392d = zzdtu4;
        this.f26393e = zzdtu5;
        this.f26394f = zzdtu6;
    }

    public final /* synthetic */ Object get() {
        zzccj zzccj = new zzccj((Context) this.f26389a.get(), (Executor) this.f26390b.get(), (zzdh) this.f26391c.get(), (zzbai) this.f26392d.get(), (zza) this.f26393e.get(), (zzbhf) this.f26394f.get());
        return zzccj;
    }
}
