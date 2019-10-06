package com.google.android.gms.internal.ads;

@zzard
public final class zzbgf extends zzbft {
    public zzbgf(zzbdf zzbdf) {
        super(zzbdf);
    }

    /* renamed from: a */
    public final boolean mo30546a(String str) {
        zzbdf zzbdf = (zzbdf) this.f25279c.get();
        if (zzbdf != null) {
            zzbdf.mo28727a(mo30548b(str), (zzbft) this);
        }
        zzbad.m26359d("VideoStreamNoopCache is doing nothing.");
        mo30545a(str, mo30548b(str), "noop", "Noop cache is a noop.");
        return false;
    }

    /* renamed from: b */
    public final void mo30549b() {
    }
}
