package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcmg implements zzcka<zzbyn, zzaov, zzcla> {

    /* renamed from: a */
    private final Context f27008a;

    /* renamed from: b */
    private final zzbxo f27009b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public zzang f27010c;

    public zzcmg(Context context, zzbxo zzbxo) {
        this.f27008a = context;
        this.f27009b = zzbxo;
    }

    /* renamed from: b */
    public final void mo31191b(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzaov, zzcla> zzcjy) throws RemoteException {
        ((zzaov) zzcjy.f26729b).mo29960a(zzcxm.f27545K, zzcxm.f27568s.toString(), zzcxu.f27595a.f27589a.f27600d, ObjectWrapper.m22188a(this.f27008a), (zzaop) new C9385dk(this, zzcjy), (zzamv) zzcjy.f26730c);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo31190a(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        if (zzcxu.f27595a.f27589a.f27603g.contains(Integer.toString(6))) {
            zzbyt a = zzbyt.m27987a(this.f27010c);
            if (zzcxu.f27595a.f27589a.f27603g.contains(Integer.toString(a.mo31016n()))) {
                zzbyw a2 = this.f27009b.mo29201a(new zzbpr(zzcxu, zzcxm, zzcjy.f26728a), new zzbzf(a), new zzcag(null, null, this.f27010c));
                ((zzcla) zzcjy.f26730c).mo31197a((zzamv) a2.mo28012f());
                return a2.mo29232g();
            }
            throw new zzcmw("No corresponding native ad listener", 0);
        }
        throw new zzcmw("Unified must be used for RTB.", 1);
    }
}
