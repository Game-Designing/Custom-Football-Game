package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

public final class zzchg implements zzdti<PackageInfo> {

    /* renamed from: a */
    private final zzdtu<Context> f26624a;

    /* renamed from: b */
    private final zzdtu<ApplicationInfo> f26625b;

    private zzchg(zzdtu<Context> zzdtu, zzdtu<ApplicationInfo> zzdtu2) {
        this.f26624a = zzdtu;
        this.f26625b = zzdtu2;
    }

    /* renamed from: a */
    public static zzchg m28436a(zzdtu<Context> zzdtu, zzdtu<ApplicationInfo> zzdtu2) {
        return new zzchg(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return zzcgt.m28425a((Context) this.f26624a.get(), (ApplicationInfo) this.f26625b.get());
    }
}
