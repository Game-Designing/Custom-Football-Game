package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

public final class zzcrv implements zzcva<zzcuz<Bundle>> {

    /* renamed from: a */
    private final Executor f27299a;

    /* renamed from: b */
    private final zzawm f27300b;

    zzcrv(Executor executor, zzawm zzawm) {
        this.f27299a = executor;
        this.f27300b = zzawm;
    }

    /* renamed from: a */
    public final zzbbh<zzcuz<Bundle>> mo28586a() {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24139nc)).booleanValue()) {
            return zzbar.m26376a(null);
        }
        return zzbar.m26380a(this.f27300b.mo30178j(), C9540kl.f22690a, this.f27299a);
    }
}
