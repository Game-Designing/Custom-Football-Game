package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcww implements zzdti<zzcwu> {

    /* renamed from: a */
    private final zzdtu<zzaqm> f27519a;

    /* renamed from: b */
    private final zzdtu<ScheduledExecutorService> f27520b;

    /* renamed from: c */
    private final zzdtu<Context> f27521c;

    public zzcww(zzdtu<zzaqm> zzdtu, zzdtu<ScheduledExecutorService> zzdtu2, zzdtu<Context> zzdtu3) {
        this.f27519a = zzdtu;
        this.f27520b = zzdtu2;
        this.f27521c = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        return new zzcwu((zzaqm) this.f27519a.get(), (ScheduledExecutorService) this.f27520b.get(), (Context) this.f27521c.get());
    }
}
