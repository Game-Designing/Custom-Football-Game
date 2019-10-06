package com.google.android.gms.internal.ads;

import java.util.List;

/* renamed from: com.google.android.gms.internal.ads.Ii */
final /* synthetic */ class C8916Ii implements Runnable {

    /* renamed from: a */
    private final zzcgb f21256a;

    /* renamed from: b */
    private final zzams f21257b;

    /* renamed from: c */
    private final zzaiq f21258c;

    /* renamed from: d */
    private final List f21259d;

    C8916Ii(zzcgb zzcgb, zzams zzams, zzaiq zzaiq, List list) {
        this.f21256a = zzcgb;
        this.f21257b = zzams;
        this.f21258c = zzaiq;
        this.f21259d = list;
    }

    public final void run() {
        this.f21256a.mo31148a(this.f21257b, this.f21258c, this.f21259d);
    }
}
