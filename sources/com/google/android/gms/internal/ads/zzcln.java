package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcln implements zzcka<zzbvx, zzams, zzcla> {

    /* renamed from: a */
    private final Context f26987a;

    /* renamed from: b */
    private final zzbws f26988b;

    /* renamed from: c */
    private final zzbai f26989c;

    public zzcln(Context context, zzbai zzbai, zzbws zzbws) {
        this.f26987a = context;
        this.f26989c = zzbai;
        this.f26988b = zzbws;
    }

    /* renamed from: b */
    public final void mo31191b(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzams, zzcla> zzcjy) throws RemoteException {
        if (this.f26989c.f25059c < 4100000) {
            ((zzams) zzcjy.f26729b).mo29851b(ObjectWrapper.m22188a(this.f26987a), zzcxu.f27595a.f27589a.f27600d, zzcxm.f27568s.toString(), (zzamv) zzcjy.f26730c);
        } else {
            ((zzams) zzcjy.f26729b).mo29845a(ObjectWrapper.m22188a(this.f26987a), zzcxu.f27595a.f27589a.f27600d, zzcxm.f27568s.toString(), zzazc.m26260a((zzazf) zzcxm.f27565p), (zzamv) zzcjy.f26730c);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo31190a(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        zzbvy a = this.f26988b.mo28122a(new zzbpr(zzcxu, zzcxm, zzcjy.f26728a), new zzbvz(new C9151Tj(zzcjy)));
        ((zzcla) zzcjy.f26730c).mo31197a((zzamv) a.mo28012f());
        return a.mo28182h();
    }
}
