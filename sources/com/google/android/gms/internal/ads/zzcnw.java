package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

public final class zzcnw implements zzcka<zzcdb, zzams, zzclb> {

    /* renamed from: a */
    private final Context f27100a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Executor f27101b;

    /* renamed from: c */
    private final zzcdf f27102c;

    public zzcnw(Context context, Executor executor, zzcdf zzcdf) {
        this.f27100a = context;
        this.f27101b = executor;
        this.f27102c = zzcdf;
    }

    /* renamed from: b */
    public final void mo31191b(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzams, zzclb> zzcjy) throws RemoteException {
        if (!((zzams) zzcjy.f26729b).isInitialized()) {
            ((zzclb) zzcjy.f26730c).mo31199a((zzbvo) new C9775vk(this, zzcxu, zzcxm, zzcjy));
            ((zzams) zzcjy.f26729b).mo29844a(ObjectWrapper.m22188a(this.f27100a), zzcxu.f27595a.f27589a.f27600d, (String) null, (zzatk) zzcjy.f26730c, zzcxm.f27568s.toString());
            return;
        }
        m28619c(zzcxu, zzcxm, zzcjy);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m28619c(zzcxu zzcxu, zzcxm zzcxm, zzcjy<zzams, zzclb> zzcjy) {
        try {
            ((zzams) zzcjy.f26729b).mo29849a(zzcxu.f27595a.f27589a.f27600d, zzcxm.f27568s.toString());
        } catch (Exception e) {
            String str = "Fail to load ad from adapter ";
            String valueOf = String.valueOf(zzcjy.f26728a);
            zzbad.m26358c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo31190a(zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) throws RemoteException, zzcmw {
        zzcdc a = this.f27102c.mo28259a(new zzbpr(zzcxu, zzcxm, zzcjy.f26728a), new zzcdd(new C9754uk(zzcjy)));
        a.mo28007a().mo30897a(new zzccy((zzams) zzcjy.f26729b), this.f27101b);
        zzbse b = a.mo28008b();
        zzbri c = a.mo28009c();
        zzclb zzclb = (zzclb) zzcjy.f26730c;
        C9838yk ykVar = new C9838yk(this, a.mo28313h(), c, b, a.mo28316k());
        zzclb.mo31198a((zzatk) ykVar);
        return a.mo28315j();
    }
}
