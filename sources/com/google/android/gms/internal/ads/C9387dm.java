package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.dm */
final /* synthetic */ class C9387dm implements Callable {

    /* renamed from: a */
    private final zzbbh f22187a;

    /* renamed from: b */
    private final zzbbh f22188b;

    C9387dm(zzbbh zzbbh, zzbbh zzbbh2) {
        this.f22187a = zzbbh;
        this.f22188b = zzbbh2;
    }

    public final Object call() {
        return new zzcwi((String) this.f22187a.get(), (String) this.f22188b.get());
    }
}
