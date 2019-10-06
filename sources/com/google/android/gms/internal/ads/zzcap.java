package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzcap implements zzdti<zzcan> {

    /* renamed from: a */
    private final zzdtu<zzayu> f26276a;

    /* renamed from: b */
    private final zzdtu<Clock> f26277b;

    /* renamed from: c */
    private final zzdtu<Executor> f26278c;

    public zzcap(zzdtu<zzayu> zzdtu, zzdtu<Clock> zzdtu2, zzdtu<Executor> zzdtu3) {
        this.f26276a = zzdtu;
        this.f26277b = zzdtu2;
        this.f26278c = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        return new zzcan((zzayu) this.f26276a.get(), (Clock) this.f26277b.get(), (Executor) this.f26278c.get());
    }
}
