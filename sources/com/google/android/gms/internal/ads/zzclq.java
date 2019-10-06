package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzclq implements zzcka<zzbvx, zzaov, zzcla> {

    /* renamed from: a */
    private final Context f26993a;

    /* renamed from: b */
    private final zzbws f26994b;

    public zzclq(Context context, zzbws zzbws) {
        this.f26993a = context;
        this.f26994b = zzbws;
    }

    /* renamed from: b */
    public final void mo31191b(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzaov, zzcla> zzcjy) throws RemoteException {
        ((zzaov) zzcjy.f26729b).mo29959a(zzcxm.f27545K, zzcxm.f27568s.toString(), zzcxu.f27595a.f27589a.f27600d, ObjectWrapper.m22188a(this.f26993a), (zzaom) new C9214Wj(this, zzcjy), (zzamv) zzcjy.f26730c);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo31190a(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        zzcjx zzcjx = new zzcjx(zzcxm);
        zzbvy a = this.f26994b.mo28122a(new zzbpr(zzcxu, zzcxm, zzcjy.f26728a), new zzbvz(new C9172Uj(zzcjy, zzcjx)));
        zzcjx.mo31188a(a.mo28010d());
        ((zzcla) zzcjy.f26730c).mo31197a((zzamv) a.mo28012f());
        return a.mo28182h();
    }
}
