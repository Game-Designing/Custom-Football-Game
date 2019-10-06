package com.google.android.gms.internal.ads;

public final class zzcor<AdT> implements zzcjv<AdT> {

    /* renamed from: a */
    private final zzado f27139a;

    /* renamed from: b */
    private final zzbbl f27140b;

    /* renamed from: c */
    private final zzczt f27141c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzcou<AdT> f27142d;

    public zzcor(zzczt zzczt, zzbbl zzbbl, zzado zzado, zzcou<AdT> zzcou) {
        this.f27141c = zzczt;
        this.f27140b = zzbbl;
        this.f27139a = zzado;
        this.f27142d = zzcou;
    }

    /* renamed from: b */
    public final boolean mo31186b(zzcxu zzcxu, zzcxm zzcxm) {
        if (this.f27139a != null) {
            zzcxq zzcxq = zzcxm.f27565p;
            if (!(zzcxq == null || zzcxq.f27585a == null)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final zzbbh<AdT> mo31185a(zzcxu zzcxu, zzcxm zzcxm) {
        zzbbr zzbbr = new zzbbr();
        zzcoz zzcoz = new zzcoz();
        C8876Gk gk = new C8876Gk(this, zzbbr, zzcxu, zzcxm, zzcoz);
        zzcoz.mo31221a(gk);
        zzcxq zzcxq = zzcxm.f27565p;
        return this.f27141c.mo31318a(zzczs.CUSTOM_RENDER_SYN).mo31323a((zzczd) new C8855Fk(this, new zzadj(zzcoz, zzcxq.f27586b, zzcxq.f27585a)), this.f27140b).mo31332a(zzczs.CUSTOM_RENDER_ACK).mo31328a((zzbbh<O2>) zzbbr).mo31325a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31218a(zzadj zzadj) throws Exception {
        this.f27139a.mo29628a(zzadj);
    }
}
