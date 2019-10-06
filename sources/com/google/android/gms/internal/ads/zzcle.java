package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

public final class zzcle implements zzcjv<zzbvx> {

    /* renamed from: a */
    private final Context f26975a;

    /* renamed from: b */
    private final zzcdn f26976b;

    /* renamed from: c */
    private final zzbws f26977c;

    /* renamed from: d */
    private final zzcxv f26978d;

    /* renamed from: e */
    private final Executor f26979e;

    /* renamed from: f */
    private final zzbai f26980f;

    public zzcle(Context context, zzbai zzbai, zzcxv zzcxv, Executor executor, zzbws zzbws, zzcdn zzcdn) {
        this.f26975a = context;
        this.f26978d = zzcxv;
        this.f26977c = zzbws;
        this.f26979e = executor;
        this.f26980f = zzbai;
        this.f26976b = zzcdn;
    }

    /* renamed from: b */
    public final boolean mo31186b(zzcxu zzcxu, zzcxm zzcxm) {
        zzcxq zzcxq = zzcxm.f27565p;
        return (zzcxq == null || zzcxq.f27585a == null) ? false : true;
    }

    /* renamed from: a */
    public final zzbbh<zzbvx> mo31185a(zzcxu zzcxu, zzcxm zzcxm) {
        zzced zzced = new zzced();
        zzbbh<zzbvx> a = zzbar.m26379a((zzbbh<A>) zzbar.m26376a(null), (zzbal<? super A, ? extends B>) new C9001Mj<Object,Object>(this, zzcxm, zzced, zzcxu), this.f26979e);
        a.mo28811a(C9022Nj.m22834a(zzced), this.f26979e);
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo31204a(zzcxm zzcxm, zzced zzced, zzcxu zzcxu, Object obj) throws Exception {
        zzbgz a = this.f26976b.mo31124a(this.f26978d.f27601e);
        a.mo28731a(zzcxm.f27547M);
        zzced.mo31135a(this.f26975a, a.getView());
        zzbbr zzbbr = new zzbbr();
        zzbvy a2 = this.f26977c.mo28122a(new zzbpr(zzcxu, zzcxm, null), new zzbvz(new C9043Oj(this, a, zzcxm, zzbbr), a));
        zzbbr.mo30338b(a2);
        a2.mo28010d().mo30897a(new C9064Pj(a), zzbbm.f25065b);
        a2.mo28181g().mo31128a(a, true);
        a2.mo28181g();
        zzcxq zzcxq = zzcxm.f27565p;
        zzbbh a3 = zzcdp.m28312a(a, zzcxq.f27586b, zzcxq.f27585a);
        if (zzcxm.f27539E) {
            a3.mo28811a(new C9085Qj(a), this.f26979e);
        }
        a3.mo28811a(new C9105Rj(a), this.f26979e);
        return zzbar.m26380a(a3, (zzbam<A, B>) new C9126Sj<A,B>(a2), zzbbm.f25065b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31205a(zzbgz zzbgz, zzcxm zzcxm, zzbbr zzbbr, boolean z, Context context) {
        zzcxm zzcxm2 = zzcxm;
        try {
            zzbgz.mo28749e(true);
            zzk.zzlg();
            zzh zzh = new zzh(false, zzaxi.m26145m(this.f26975a), false, 0.0f, -1, z, zzcxm2.f27540F, false);
            zzk.zzlf();
            AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(null, ((zzbvy) zzbbr.get()).mo28184j(), null, zzbgz, zzcxm2.f27542H, this.f26980f, zzcxm2.f27574y, zzh);
            zzm.zza(context, adOverlayInfoParcel, true);
        } catch (Exception e) {
        }
    }
}
