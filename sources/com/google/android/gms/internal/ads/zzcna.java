package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

public final class zzcna implements zzcka<zzcdb, zzams, zzcla> {

    /* renamed from: a */
    private final Context f27065a;

    /* renamed from: b */
    private final Executor f27066b;

    /* renamed from: c */
    private final zzcdf f27067c;

    public zzcna(Context context, Executor executor, zzcdf zzcdf) {
        this.f27065a = context;
        this.f27066b = executor;
        this.f27067c = zzcdf;
    }

    /* renamed from: b */
    public final void mo31191b(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzams, zzcla> zzcjy) throws RemoteException {
        try {
            ((zzams) zzcjy.f26729b).mo29843a(ObjectWrapper.m22188a(this.f27065a), zzcxu.f27595a.f27589a.f27600d, zzcxm.f27568s.toString(), (zzamv) zzcjy.f26730c);
        } catch (Exception e) {
            String str = "Fail to load ad from adapter ";
            String valueOf = String.valueOf(zzcjy.f26728a);
            zzbad.m26358c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo31190a(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        zzcdc a = this.f27067c.mo28259a(new zzbpr(zzcxu, zzcxm, zzcjy.f26728a), new zzcdd(new C9473hk(zzcjy)));
        a.mo28007a().mo30897a(new zzccy((zzams) zzcjy.f26729b), this.f27066b);
        ((zzcla) zzcjy.f26730c).mo31197a((zzamv) a.mo28317l());
        return a.mo28315j();
    }
}
