package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzcuz;

/* renamed from: com.google.android.gms.internal.ads.ql */
final class C9671ql<S extends zzcuz> {

    /* renamed from: a */
    public final zzbbh<S> f22904a;

    /* renamed from: b */
    private final long f22905b;

    /* renamed from: c */
    private final Clock f22906c;

    public C9671ql(zzbbh<S> zzbbh, long j, Clock clock) {
        this.f22904a = zzbbh;
        this.f22906c = clock;
        this.f22905b = clock.mo27934a() + j;
    }

    /* renamed from: a */
    public final boolean mo29142a() {
        return this.f22905b < this.f22906c.mo27934a();
    }
}
