package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzckj implements zzcka<zzbnf, zzams, zzcla> {

    /* renamed from: a */
    private final Context f26743a;

    /* renamed from: b */
    private final zzbai f26744b;

    /* renamed from: c */
    private final zzboc f26745c;

    public zzckj(Context context, zzbai zzbai, zzboc zzboc) {
        this.f26743a = context;
        this.f26744b = zzbai;
        this.f26745c = zzboc;
    }

    /* renamed from: b */
    public final void mo31191b(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzams, zzcla> zzcjy) throws RemoteException {
        zzyd a = zzcxy.m28988a(this.f26743a, zzcxm.f27567r);
        if (this.f26744b.f25059c < 4100000) {
            ((zzams) zzcjy.f26729b).mo29847a(ObjectWrapper.m22188a(this.f26743a), a, zzcxu.f27595a.f27589a.f27600d, zzcxm.f27568s.toString(), (zzamv) zzcjy.f26730c);
        } else {
            ((zzams) zzcjy.f26729b).mo29848a(ObjectWrapper.m22188a(this.f26743a), a, zzcxu.f27595a.f27589a.f27600d, zzcxm.f27568s.toString(), zzazc.m26260a((zzazf) zzcxm.f27565p), (zzamv) zzcjy.f26730c);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo31190a(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        zzboc zzboc = this.f26745c;
        zzbpr zzbpr = new zzbpr(zzcxu, zzcxm, zzcjy.f26728a);
        View view = (View) ObjectWrapper.m22187H(((zzams) zzcjy.f26729b).mo29837Ca());
        zzams zzams = (zzams) zzcjy.f26729b;
        zzams.getClass();
        zzbng a = zzboc.mo29319a(zzbpr, new zzbnk(view, null, C8812Dj.m22416a(zzams), (zzcxn) zzcxm.f27567r.get(0)));
        a.mo28015i().mo30923a((View) ObjectWrapper.m22187H(((zzams) zzcjy.f26729b).mo29837Ca()));
        ((zzcla) zzcjy.f26730c).mo31197a((zzamv) a.mo28012f());
        return a.mo28013g();
    }
}
