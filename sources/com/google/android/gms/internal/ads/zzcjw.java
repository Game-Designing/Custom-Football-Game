package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.Executor;

public final class zzcjw<DelegateT, AdapterT> implements zzcjv<AdapterT> {
    @VisibleForTesting

    /* renamed from: a */
    private final zzcjv<DelegateT> f26724a;

    /* renamed from: b */
    private final zzbam<DelegateT, AdapterT> f26725b;

    public zzcjw(zzcjv<DelegateT> zzcjv, zzbam<DelegateT, AdapterT> zzbam) {
        this.f26724a = zzcjv;
        this.f26725b = zzbam;
    }

    /* renamed from: b */
    public final boolean mo31186b(zzcxu zzcxu, zzcxm zzcxm) {
        return this.f26724a.mo31186b(zzcxu, zzcxm);
    }

    /* renamed from: a */
    public final zzbbh<AdapterT> mo31185a(zzcxu zzcxu, zzcxm zzcxm) {
        return zzbar.m26380a(this.f26724a.mo31185a(zzcxu, zzcxm), this.f26725b, (Executor) zzaxg.f24958a);
    }
}
