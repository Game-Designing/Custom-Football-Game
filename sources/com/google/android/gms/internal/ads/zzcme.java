package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcme implements zzcka<zzbyn, zzams, zzcla> {

    /* renamed from: a */
    private final Context f27004a;

    /* renamed from: b */
    private final zzbxo f27005b;

    public zzcme(Context context, zzbxo zzbxo) {
        this.f27004a = context;
        this.f27005b = zzbxo;
    }

    /* renamed from: b */
    public final void mo31191b(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzams, zzcla> zzcjy) throws RemoteException {
        zzams zzams = (zzams) zzcjy.f26729b;
        IObjectWrapper a = ObjectWrapper.m22188a(this.f27004a);
        zzxz zzxz = zzcxu.f27595a.f27589a.f27600d;
        String jSONObject = zzcxm.f27568s.toString();
        String a2 = zzazc.m26260a((zzazf) zzcxm.f27565p);
        zzamv zzamv = (zzamv) zzcjy.f26730c;
        zzcxv zzcxv = zzcxu.f27595a.f27589a;
        zzams.mo29846a(a, zzxz, jSONObject, a2, zzamv, zzcxv.f27605i, zzcxv.f27603g);
    }

    /* renamed from: a */
    private static boolean m28580a(zzcxu zzcxu, int i) {
        return zzcxu.f27595a.f27589a.f27603g.contains(Integer.toString(i));
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo31190a(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        zzbyt zzbyt;
        zzana eb = ((zzams) zzcjy.f26729b).mo29855eb();
        zzand bb = ((zzams) zzcjy.f26729b).mo29852bb();
        zzang S = ((zzams) zzcjy.f26729b).mo29839S();
        if (S != null && m28580a(zzcxu, 6)) {
            zzbyt = zzbyt.m27987a(S);
        } else if (eb != null && m28580a(zzcxu, 6)) {
            zzbyt = zzbyt.m27989b(eb);
        } else if (eb != null && m28580a(zzcxu, 2)) {
            zzbyt = zzbyt.m27985a(eb);
        } else if (bb != null && m28580a(zzcxu, 6)) {
            zzbyt = zzbyt.m27990b(bb);
        } else if (bb == null || !m28580a(zzcxu, 1)) {
            throw new zzcmw("No native ad mappers", 0);
        } else {
            zzbyt = zzbyt.m27986a(bb);
        }
        if (zzcxu.f27595a.f27589a.f27603g.contains(Integer.toString(zzbyt.mo31016n()))) {
            zzbyw a = this.f27005b.mo29201a(new zzbpr(zzcxu, zzcxm, zzcjy.f26728a), new zzbzf(zzbyt), new zzcag(bb, eb, S));
            ((zzcla) zzcjy.f26730c).mo31197a((zzamv) a.mo28012f());
            return a.mo29232g();
        }
        throw new zzcmw("No corresponding native ad listener", 0);
    }
}
