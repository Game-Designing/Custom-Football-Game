package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzcuz;
import java.util.concurrent.atomic.AtomicReference;

public final class zzcsk<S extends zzcuz> implements zzcva<S> {

    /* renamed from: a */
    private final AtomicReference<C9671ql<S>> f27331a = new AtomicReference<>();

    /* renamed from: b */
    private final Clock f27332b;

    /* renamed from: c */
    private final zzcva<S> f27333c;

    /* renamed from: d */
    private final long f27334d;

    public zzcsk(zzcva<S> zzcva, long j, Clock clock) {
        this.f27332b = clock;
        this.f27333c = zzcva;
        this.f27334d = j;
    }

    /* renamed from: a */
    public final zzbbh<S> mo28586a() {
        C9671ql qlVar = (C9671ql) this.f27331a.get();
        if (qlVar == null || qlVar.mo29142a()) {
            qlVar = new C9671ql(this.f27333c.mo28586a(), this.f27334d, this.f27332b);
            this.f27331a.set(qlVar);
        }
        return qlVar.f22904a;
    }
}
