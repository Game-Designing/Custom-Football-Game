package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

public final class zzcuc implements zzdti<zzcub> {

    /* renamed from: a */
    private final zzdtu<ApplicationInfo> f27386a;

    /* renamed from: b */
    private final zzdtu<PackageInfo> f27387b;

    private zzcuc(zzdtu<ApplicationInfo> zzdtu, zzdtu<PackageInfo> zzdtu2) {
        this.f27386a = zzdtu;
        this.f27387b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcuc m28877a(zzdtu<ApplicationInfo> zzdtu, zzdtu<PackageInfo> zzdtu2) {
        return new zzcuc(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcub((ApplicationInfo) this.f27386a.get(), (PackageInfo) this.f27387b.get());
    }
}
