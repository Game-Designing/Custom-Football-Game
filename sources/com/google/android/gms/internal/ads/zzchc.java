package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class zzchc implements zzdti<zzbbh<String>> {

    /* renamed from: a */
    private final zzdtu<zzczt> f26618a;

    /* renamed from: b */
    private final zzdtu<Context> f26619b;

    private zzchc(zzdtu<zzczt> zzdtu, zzdtu<Context> zzdtu2) {
        this.f26618a = zzdtu;
        this.f26619b = zzdtu2;
    }

    /* renamed from: a */
    public static zzchc m28432a(zzdtu<zzczt> zzdtu, zzdtu<Context> zzdtu2) {
        return new zzchc(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzcze a = ((zzczt) this.f26618a.get()).mo31318a(zzczs.WEBVIEW_COOKIE).mo31324a((Callable<O>) new C9063Pi<O>((Context) this.f26619b.get())).mo31326a(1, TimeUnit.SECONDS).mo31331a(Exception.class, C9084Qi.f21615a).mo31325a();
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
