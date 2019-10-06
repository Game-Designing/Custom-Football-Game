package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

public final class zzcok implements zzcjv<zzbnf> {

    /* renamed from: a */
    private final Context f27123a;

    /* renamed from: b */
    private final zzboc f27124b;

    /* renamed from: c */
    private final zzado f27125c;

    /* renamed from: d */
    private final zzbbl f27126d;

    /* renamed from: e */
    private final zzczt f27127e;

    public zzcok(Context context, zzboc zzboc, zzczt zzczt, zzbbl zzbbl, zzado zzado) {
        this.f27123a = context;
        this.f27124b = zzboc;
        this.f27127e = zzczt;
        this.f27126d = zzbbl;
        this.f27125c = zzado;
    }

    /* renamed from: b */
    public final boolean mo31186b(zzcxu zzcxu, zzcxm zzcxm) {
        if (this.f27125c != null) {
            zzcxq zzcxq = zzcxm.f27565p;
            if (!(zzcxq == null || zzcxq.f27585a == null)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final zzbbh<zzbnf> mo31185a(zzcxu zzcxu, zzcxm zzcxm) {
        C8834Ek ek = new C8834Ek(this, new View(this.f27123a), null, C8792Ck.f20558a, (zzcxn) zzcxm.f27567r.get(0));
        zzbng a = this.f27124b.mo29319a(new zzbpr(zzcxu, zzcxm, null), (zzbnk) ek);
        zzcoo j = a.mo28016j();
        zzcxq zzcxq = zzcxm.f27565p;
        return this.f27127e.mo31318a(zzczs.CUSTOM_RENDER_SYN).mo31323a((zzczd) new C8813Dk(this, new zzadj(j, zzcxq.f27586b, zzcxq.f27585a)), this.f27126d).mo31332a(zzczs.CUSTOM_RENDER_ACK).mo31328a((zzbbh<O2>) zzbar.m26376a(a.mo28013g())).mo31325a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31217a(zzadj zzadj) throws Exception {
        this.f27125c.mo29628a(zzadj);
    }
}
