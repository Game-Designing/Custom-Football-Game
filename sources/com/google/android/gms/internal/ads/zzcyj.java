package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcyj implements zzdti<zzcyi> {

    /* renamed from: a */
    private final zzdtu<Context> f27637a;

    /* renamed from: b */
    private final zzdtu<zzawu> f27638b;

    private zzcyj(zzdtu<Context> zzdtu, zzdtu<zzawu> zzdtu2) {
        this.f27637a = zzdtu;
        this.f27638b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcyj m29007a(zzdtu<Context> zzdtu, zzdtu<zzawu> zzdtu2) {
        return new zzcyj(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcyi((Context) this.f27637a.get(), (zzawu) this.f27638b.get());
    }
}
