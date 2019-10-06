package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcha implements zzdti<zzbbh<Bundle>> {

    /* renamed from: a */
    private final zzdtu<zzczt> f26613a;

    /* renamed from: b */
    private final zzdtu<zzcvb<Bundle>> f26614b;

    private zzcha(zzdtu<zzczt> zzdtu, zzdtu<zzcvb<Bundle>> zzdtu2) {
        this.f26613a = zzdtu;
        this.f26614b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcha m28430a(zzdtu<zzczt> zzdtu, zzdtu<zzcvb<Bundle>> zzdtu2) {
        return new zzcha(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzcze a = ((zzczt) this.f26613a.get()).mo31318a(zzczs.SIGNALS).mo31322a(((zzcvb) this.f26614b.get()).mo31269a(new Bundle())).mo31325a();
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
