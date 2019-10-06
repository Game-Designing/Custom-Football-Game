package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcob implements zzdti<zzcnw> {

    /* renamed from: a */
    private final zzdtu<Context> f27103a;

    /* renamed from: b */
    private final zzdtu<Executor> f27104b;

    /* renamed from: c */
    private final zzdtu<zzcdf> f27105c;

    public zzcob(zzdtu<Context> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<zzcdf> zzdtu3) {
        this.f27103a = zzdtu;
        this.f27104b = zzdtu2;
        this.f27105c = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        return new zzcnw((Context) this.f27103a.get(), (Executor) this.f27104b.get(), (zzcdf) this.f27105c.get());
    }
}
