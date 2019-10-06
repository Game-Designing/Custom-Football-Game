package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzckb implements zzcjv<zzbnf> {

    /* renamed from: a */
    private final zzboc f26731a;

    /* renamed from: b */
    private final Context f26732b;

    /* renamed from: c */
    private final zzcdn f26733c;

    /* renamed from: d */
    private final zzcxv f26734d;

    /* renamed from: e */
    private final Executor f26735e;

    /* renamed from: f */
    private final zzbam<zzcxm, zzayb> f26736f;

    public zzckb(zzboc zzboc, Context context, Executor executor, zzcdn zzcdn, zzcxv zzcxv, zzbam<zzcxm, zzayb> zzbam) {
        this.f26732b = context;
        this.f26731a = zzboc;
        this.f26735e = executor;
        this.f26733c = zzcdn;
        this.f26734d = zzcxv;
        this.f26736f = zzbam;
    }

    /* renamed from: b */
    public final boolean mo31186b(zzcxu zzcxu, zzcxm zzcxm) {
        zzcxq zzcxq = zzcxm.f27565p;
        return (zzcxq == null || zzcxq.f27585a == null) ? false : true;
    }

    /* renamed from: a */
    public final zzbbh<zzbnf> mo31185a(zzcxu zzcxu, zzcxm zzcxm) {
        return zzbar.m26379a((zzbbh<A>) zzbar.m26376a(null), (zzbal<? super A, ? extends B>) new C9816xj<Object,Object>(this, zzcxu, zzcxm), this.f26735e);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31193a(zzbgz zzbgz) {
        zzbgz.mo28787t();
        zzbhq g = zzbgz.mo28754g();
        zzacd zzacd = this.f26734d.f27598b;
        if (zzacd != null && g != null) {
            g.mo30631b(zzacd);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo31192a(zzcxu zzcxu, zzcxm zzcxm, Object obj) throws Exception {
        zzcxn zzcxn;
        zzyd a = zzcxy.m28988a(this.f26732b, zzcxm.f27567r);
        zzbgz a2 = this.f26733c.mo31124a(a);
        a2.mo28731a(zzcxm.f27547M);
        zzboc zzboc = this.f26731a;
        zzbpr zzbpr = new zzbpr(zzcxu, zzcxm, null);
        zzcec zzcec = new zzcec(this.f26732b, a2.getView(), (zzayb) this.f26736f.apply(zzcxm));
        a2.getClass();
        zzbpb a3 = C9837yj.m24307a(a2);
        if (a.f29776i) {
            zzcxn = new zzcxn(-3, 0, true);
        } else {
            zzcxn = new zzcxn(a.f29772e, a.f29769b, false);
        }
        zzbng a4 = zzboc.mo29319a(zzbpr, new zzbnk(zzcec, a2, a3, zzcxn));
        a4.mo28014h().mo31128a(a2, false);
        a4.mo28010d().mo30897a(new C9858zj(a2), zzbbm.f25065b);
        a4.mo28014h();
        zzcxq zzcxq = zzcxm.f27565p;
        zzbbh a5 = zzcdp.m28312a(a2, zzcxq.f27586b, zzcxq.f27585a);
        if (zzcxm.f27539E) {
            a2.getClass();
            a5.mo28811a(C8749Aj.m22277a(a2), this.f26735e);
        }
        a5.mo28811a(new C8770Bj(this, a2), this.f26735e);
        return zzbar.m26380a(a5, (zzbam<A, B>) new C8791Cj<A,B>(a4), zzbbm.f25065b);
    }
}
