package com.google.android.gms.internal.ads;

import android.os.Bundle;

@zzard
/* renamed from: com.google.android.gms.internal.ads.Ub */
final class C9164Ub {

    /* renamed from: a */
    private long f21789a = -1;

    /* renamed from: b */
    private long f21790b = -1;

    /* renamed from: c */
    private final /* synthetic */ zzawj f21791c;

    public C9164Ub(zzawj zzawj) {
        this.f21791c = zzawj;
    }

    /* renamed from: b */
    public final long mo28627b() {
        return this.f21790b;
    }

    /* renamed from: c */
    public final void mo28628c() {
        this.f21790b = this.f21791c.f24876a.mo27934a();
    }

    /* renamed from: d */
    public final void mo28629d() {
        this.f21789a = this.f21791c.f24876a.mo27934a();
    }

    /* renamed from: a */
    public final Bundle mo28626a() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.f21789a);
        bundle.putLong("tclose", this.f21790b);
        return bundle;
    }
}
