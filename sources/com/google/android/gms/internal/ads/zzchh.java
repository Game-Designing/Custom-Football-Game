package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzchh implements zzdti<String> {

    /* renamed from: a */
    private final zzdtu<Context> f26626a;

    private zzchh(zzdtu<Context> zzdtu) {
        this.f26626a = zzdtu;
    }

    /* renamed from: a */
    public static zzchh m28437a(zzdtu<Context> zzdtu) {
        return new zzchh(zzdtu);
    }

    public final /* synthetic */ Object get() {
        String packageName = ((Context) this.f26626a.get()).getPackageName();
        zzdto.m30114a(packageName, "Cannot return null from a non-@Nullable @Provides method");
        return packageName;
    }
}
