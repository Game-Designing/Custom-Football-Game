package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public final class zzche implements zzdti<ApplicationInfo> {

    /* renamed from: a */
    private final zzdtu<Context> f26622a;

    private zzche(zzdtu<Context> zzdtu) {
        this.f26622a = zzdtu;
    }

    /* renamed from: a */
    public static zzche m28434a(zzdtu<Context> zzdtu) {
        return new zzche(zzdtu);
    }

    public final /* synthetic */ Object get() {
        ApplicationInfo applicationInfo = ((Context) this.f26622a.get()).getApplicationInfo();
        zzdto.m30114a(applicationInfo, "Cannot return null from a non-@Nullable @Provides method");
        return applicationInfo;
    }
}
