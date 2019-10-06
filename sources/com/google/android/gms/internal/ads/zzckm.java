package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzckm implements zzcka<zzbnf, zzaov, zzcla> {

    /* renamed from: a */
    private final Context f26749a;

    /* renamed from: b */
    private final zzboc f26750b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f26751c;

    public zzckm(Context context, zzboc zzboc) {
        this.f26749a = context;
        this.f26750b = zzboc;
    }

    /* renamed from: b */
    public final void mo31191b(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzaov, zzcla> zzcjy) throws RemoteException {
        ((zzaov) zzcjy.f26729b).mo29958a(zzcxm.f27545K, zzcxm.f27568s.toString(), zzcxu.f27595a.f27589a.f27600d, ObjectWrapper.m22188a(this.f26749a), new C8875Gj(this, zzcjy), (zzamv) zzcjy.f26730c, zzcxu.f27595a.f27589a.f27601e);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo31190a(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        zzboc zzboc = this.f26750b;
        zzbpr zzbpr = new zzbpr(zzcxu, zzcxm, zzcjy.f26728a);
        View view = this.f26751c;
        zzaov zzaov = (zzaov) zzcjy.f26729b;
        zzaov.getClass();
        zzbng a = zzboc.mo29319a(zzbpr, new zzbnk(view, null, C8833Ej.m22488a(zzaov), (zzcxn) zzcxm.f27567r.get(0)));
        a.mo28015i().mo30923a(this.f26751c);
        ((zzcla) zzcjy.f26730c).mo31197a((zzamv) a.mo28012f());
        return a.mo28013g();
    }
}
