package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcnc implements zzdti<zzcna> {

    /* renamed from: a */
    private final zzdtu<Context> f27068a;

    /* renamed from: b */
    private final zzdtu<Executor> f27069b;

    /* renamed from: c */
    private final zzdtu<zzcdf> f27070c;

    public zzcnc(zzdtu<Context> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<zzcdf> zzdtu3) {
        this.f27068a = zzdtu;
        this.f27069b = zzdtu2;
        this.f27070c = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        return new zzcna((Context) this.f27068a.get(), (Executor) this.f27069b.get(), (zzcdf) this.f27070c.get());
    }
}
