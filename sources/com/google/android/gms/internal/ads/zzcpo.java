package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzcpo extends zzzg {

    /* renamed from: b */
    private final Context f27180b;

    /* renamed from: c */
    private final zzbjm f27181c;
    @VisibleForTesting

    /* renamed from: d */
    private final zzcxx f27182d = new zzcxx();
    @VisibleForTesting

    /* renamed from: e */
    private final zzbze f27183e = new zzbze();

    /* renamed from: f */
    private zzyz f27184f;

    public zzcpo(zzbjm zzbjm, Context context, String str) {
        this.f27181c = zzbjm;
        this.f27182d.mo31294a(str);
        this.f27180b = context;
    }

    /* renamed from: Fa */
    public final zzzc mo29490Fa() {
        zzbzc a = this.f27183e.mo31042a();
        this.f27182d.mo31295a(a.mo31040f());
        this.f27182d.mo31299b(a.mo31041g());
        zzcxx zzcxx = this.f27182d;
        if (zzcxx.mo31303d() == null) {
            zzcxx.mo31292a(zzyd.m31511a(this.f27180b));
        }
        zzcpp zzcpp = new zzcpp(this.f27180b, this.f27181c, this.f27182d, a, this.f27184f);
        return zzcpp;
    }

    /* renamed from: b */
    public final void mo29500b(zzyz zzyz) {
        this.f27184f = zzyz;
    }

    /* renamed from: a */
    public final void mo29493a(zzafi zzafi) {
        this.f27183e.mo31043a(zzafi);
    }

    /* renamed from: a */
    public final void mo29496a(zzafx zzafx) {
        this.f27183e.mo31046a(zzafx);
    }

    /* renamed from: a */
    public final void mo29494a(zzafl zzafl) {
        this.f27183e.mo31044a(zzafl);
    }

    /* renamed from: a */
    public final void mo29499a(String str, zzafr zzafr, zzafo zzafo) {
        this.f27183e.mo31048a(str, zzafr, zzafo);
    }

    /* renamed from: a */
    public final void mo29492a(zzady zzady) {
        this.f27182d.mo31289a(zzady);
    }

    /* renamed from: a */
    public final void mo29497a(zzaiy zzaiy) {
        this.f27182d.mo31290a(zzaiy);
    }

    /* renamed from: a */
    public final void mo29498a(zzaje zzaje) {
        this.f27183e.mo31047a(zzaje);
    }

    /* renamed from: b */
    public final void mo29501b(zzzy zzzy) {
        this.f27182d.mo31293a(zzzy);
    }

    /* renamed from: a */
    public final void mo29495a(zzafu zzafu, zzyd zzyd) {
        this.f27183e.mo31045a(zzafu);
        this.f27182d.mo31292a(zzyd);
    }

    /* renamed from: a */
    public final void mo29491a(PublisherAdViewOptions publisherAdViewOptions) {
        this.f27182d.mo31287a(publisherAdViewOptions);
    }
}
