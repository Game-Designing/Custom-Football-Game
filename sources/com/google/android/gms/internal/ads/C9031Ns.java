package com.google.android.gms.internal.ads;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.Ns */
final class C9031Ns implements zzqw {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final int f21525a;

    /* renamed from: b */
    private final /* synthetic */ C8884Gs f21526b;

    public C9031Ns(C8884Gs gs, int i) {
        this.f21526b = gs;
        this.f21525a = i;
    }

    public final boolean isReady() {
        return this.f21526b.mo28293a(this.f21525a);
    }

    /* renamed from: a */
    public final void mo28468a() throws IOException {
        this.f21526b.mo28303h();
    }

    /* renamed from: a */
    public final int mo28467a(zzlj zzlj, zznd zznd, boolean z) {
        return this.f21526b.mo28282a(this.f21525a, zzlj, zznd, z);
    }

    /* renamed from: a */
    public final void mo28469a(long j) {
        this.f21526b.mo28287a(this.f21525a, j);
    }
}
