package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

public final class zzcnl implements zzcjv<zzcdb> {

    /* renamed from: a */
    private final Context f27088a;

    /* renamed from: b */
    private final zzcdn f27089b;

    /* renamed from: c */
    private final zzcdf f27090c;

    /* renamed from: d */
    private final zzcxv f27091d;

    /* renamed from: e */
    private final Executor f27092e;

    /* renamed from: f */
    private final zzbai f27093f;

    public zzcnl(Context context, zzbai zzbai, zzcxv zzcxv, Executor executor, zzcdf zzcdf, zzcdn zzcdn) {
        this.f27088a = context;
        this.f27091d = zzcxv;
        this.f27090c = zzcdf;
        this.f27092e = executor;
        this.f27093f = zzbai;
        this.f27089b = zzcdn;
    }

    /* renamed from: b */
    public final boolean mo31186b(zzcxu zzcxu, zzcxm zzcxm) {
        zzcxq zzcxq = zzcxm.f27565p;
        return (zzcxq == null || zzcxq.f27585a == null) ? false : true;
    }

    /* renamed from: a */
    public final zzbbh<zzcdb> mo31185a(zzcxu zzcxu, zzcxm zzcxm) {
        zzced zzced = new zzced();
        zzbbh<zzcdb> a = zzbar.m26379a((zzbbh<A>) zzbar.m26376a(null), (zzbal<? super A, ? extends B>) new C9561lk<Object,Object>(this, zzcxm, zzced, zzcxu), this.f27092e);
        a.mo28811a(C9583mk.m23881a(zzced), this.f27092e);
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo31213a(zzcxm zzcxm, zzced zzced, zzcxu zzcxu, Object obj) throws Exception {
        zzbgz a = this.f27089b.mo31124a(this.f27091d.f27601e);
        a.mo28731a(zzcxm.f27547M);
        zzced.mo31135a(this.f27088a, a.getView());
        zzbbr zzbbr = new zzbbr();
        zzcdc a2 = this.f27090c.mo28259a(new zzbpr(zzcxu, zzcxm, null), new zzcdd(new C9649pk(this, a, zzcxm, zzbbr), a));
        zzbbr.mo30338b(a2);
        zzahx.m25065a(a, (zzahy) a2.mo28316k());
        a2.mo28010d().mo30897a(new C9670qk(a), zzbbm.f25065b);
        a2.mo28312g().mo31128a(a, true);
        a2.mo28312g();
        zzcxq zzcxq = zzcxm.f27565p;
        zzbbh a3 = zzcdp.m28312a(a, zzcxq.f27586b, zzcxq.f27585a);
        if (zzcxm.f27539E) {
            a3.mo28811a(new C9691rk(a), this.f27092e);
        }
        a3.mo28811a(new C9712sk(a), this.f27092e);
        return zzbar.m26380a(a3, (zzbam<A, B>) new C9733tk<A,B>(a2), zzbbm.f25065b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31214a(zzbgz zzbgz, zzcxm zzcxm, zzbbr zzbbr, boolean z, Context context) {
        zzbgz zzbgz2;
        zzcxm zzcxm2 = zzcxm;
        try {
            zzcdc zzcdc = (zzcdc) zzbbr.get();
            if (zzbgz.mo28761k()) {
                if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24035Xa)).booleanValue()) {
                    zzbgz a = this.f27089b.mo31124a(this.f27091d.f27601e);
                    zzahx.m25065a(a, (zzahy) zzcdc.mo28316k());
                    zzced zzced = new zzced();
                    zzced.mo31135a(this.f27088a, a.getView());
                    zzcdc.mo28312g().mo31128a(a, true);
                    a.mo28714a().mo30597a((zzbij) new C9605nk(zzced, a));
                    zzbii a2 = a.mo28714a();
                    a.getClass();
                    a2.mo30598a(C9627ok.m23996a(a));
                    a.mo28728a(zzcxm2.f27565p.f27586b, zzcxm2.f27565p.f27585a, null);
                    zzbgz2 = a;
                    zzbgz2.mo28749e(true);
                    zzk.zzlg();
                    zzh zzh = new zzh(false, zzaxi.m26145m(this.f27088a), false, 0.0f, -1, z, zzcxm2.f27540F, zzcxm2.f27541G);
                    zzk.zzlf();
                    AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(null, ((zzcdc) zzbbr.get()).mo28314i(), null, zzbgz2, zzcxm2.f27542H, this.f27093f, zzcxm2.f27574y, zzh);
                    zzm.zza(context, adOverlayInfoParcel, true);
                }
            }
            zzbgz2 = zzbgz;
            zzbgz2.mo28749e(true);
            zzk.zzlg();
            zzh zzh2 = new zzh(false, zzaxi.m26145m(this.f27088a), false, 0.0f, -1, z, zzcxm2.f27540F, zzcxm2.f27541G);
            zzk.zzlf();
            AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel(null, ((zzcdc) zzbbr.get()).mo28314i(), null, zzbgz2, zzcxm2.f27542H, this.f27093f, zzcxm2.f27574y, zzh2);
            zzm.zza(context, adOverlayInfoParcel2, true);
        } catch (Exception e) {
        }
    }
}
