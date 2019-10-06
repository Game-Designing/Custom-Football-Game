package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

public final class zzcwz implements zzdti<ApplicationInfo> {

    /* renamed from: a */
    private final zzcwx f27524a;

    public zzcwz(zzcwx zzcwx) {
        this.f27524a = zzcwx;
    }

    /* renamed from: a */
    public static ApplicationInfo m28940a(zzcwx zzcwx) {
        ApplicationInfo f = zzcwx.mo31279f();
        zzdto.m30114a(f, "Cannot return null from a non-@Nullable @Provides method");
        return f;
    }

    public final /* synthetic */ Object get() {
        return m28940a(this.f27524a);
    }
}
