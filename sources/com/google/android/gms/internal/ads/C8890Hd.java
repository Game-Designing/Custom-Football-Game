package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.ads.Hd */
final class C8890Hd implements zzgh {

    /* renamed from: a */
    private WeakReference<zzgh> f21127a;

    /* renamed from: b */
    private final /* synthetic */ zzbdk f21128b;

    private C8890Hd(zzbdk zzbdk) {
        this.f21128b = zzbdk;
        this.f21127a = new WeakReference<>(null);
    }

    /* renamed from: a */
    public final void mo28308a(zzgh zzgh) {
        this.f21127a = new WeakReference<>(zzgh);
    }

    /* renamed from: a */
    public final void mo28309a(boolean z, int i) {
        zzgh zzgh = (zzgh) this.f21127a.get();
        if (zzgh != null) {
            zzgh.mo28309a(z, i);
        }
    }

    /* renamed from: a */
    public final void mo28306a() {
        zzgh zzgh = (zzgh) this.f21127a.get();
        if (zzgh != null) {
            zzgh.mo28306a();
        }
    }

    /* renamed from: a */
    public final void mo28307a(zzgd zzgd) {
        this.f21128b.m26549a("PlayerError", zzgd.getMessage());
        zzgh zzgh = (zzgh) this.f21127a.get();
        if (zzgh != null) {
            zzgh.mo28307a(zzgd);
        }
    }
}
