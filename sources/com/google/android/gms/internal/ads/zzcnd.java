package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcnd implements zzcka<zzcdb, zzaov, zzcla> {

    /* renamed from: a */
    private final Context f27071a;

    /* renamed from: b */
    private final zzcdf f27072b;

    public zzcnd(Context context, zzcdf zzcdf) {
        this.f27071a = context;
        this.f27072b = zzcdf;
    }

    /* renamed from: b */
    public final void mo31191b(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzaov, zzcla> zzcjy) throws RemoteException {
        ((zzaov) zzcjy.f26729b).mo29961a(zzcxm.f27545K, zzcxm.f27568s.toString(), zzcxu.f27595a.f27589a.f27600d, ObjectWrapper.m22188a(this.f27071a), (zzaos) new C9539kk(this, zzcjy), (zzamv) zzcjy.f26730c);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo31190a(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        zzcjx zzcjx = new zzcjx(zzcxm);
        zzcdc a = this.f27072b.mo28259a(new zzbpr(zzcxu, zzcxm, zzcjy.f26728a), new zzcdd(new C9495ik(zzcjy, zzcjx)));
        zzcjx.mo31188a(a.mo28010d());
        ((zzcla) zzcjy.f26730c).mo31197a((zzamv) a.mo28317l());
        return a.mo28315j();
    }
}
