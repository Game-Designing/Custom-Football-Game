package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcig extends zzarn {

    /* renamed from: b */
    private final Context f26659b;

    /* renamed from: c */
    private final Executor f26660c;

    /* renamed from: d */
    private final zzasm f26661d;

    /* renamed from: e */
    private final zzasl f26662e;

    /* renamed from: f */
    private final zzblp f26663f;

    public zzcig(Context context, Executor executor, zzasm zzasm, zzblp zzblp, zzasl zzasl) {
        zzacu.m24782a(context);
        this.f26659b = context;
        this.f26660c = executor;
        this.f26661d = zzasm;
        this.f26662e = zzasl;
        this.f26663f = zzblp;
    }

    /* renamed from: a */
    public final zzbbh<InputStream> mo31169a(zzarx zzarx) {
        zzalr a = zzk.zzlt().mo29806a(this.f26659b, zzbai.m26367a());
        zzcvs a2 = this.f26663f.mo30691a(zzarx);
        C9384dj djVar = new C9384dj(a2);
        zzczc zzczc = C9406ej.f22218a;
        zzalj a3 = a.mo29808a("AFMA_getAdDictionary", zzalo.f24411b, C9428fj.f22294a);
        zzalj a4 = a.mo29808a("google.afma.response.normalize", zzcir.f26664a, zzalo.f24412c);
        zzciu zzciu = new zzciu(this.f26659b, zzarx.f24716b.f25057a, this.f26661d, zzarx.f24721g);
        zzczt c = a2.mo29267c();
        zzcze a5 = c.mo31319a(zzczs.GMS_SIGNALS, (zzbbh<I>) zzbar.m26376a(zzarx.f24715a)).mo31327a((zzbal<O, O2>) djVar).mo31329a(zzczc).mo31325a();
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24171se)).booleanValue()) {
            zzaln<JSONObject> zzaln = zzalo.f24411b;
            return c.mo31319a(zzczs.AD_REQUEST, (zzbbh<I>) a5).mo31327a((zzbal<O, O2>) a.mo29808a("google.afma.request.getAdResponse", zzaln, zzaln)).mo31329a(C9450gj.f22379a).mo31325a();
        }
        zzcze a6 = c.mo31319a(zzczs.BUILD_URL, (zzbbh<I>) a5).mo31327a((zzbal<O, O2>) a3).mo31325a();
        zzcze a7 = c.mo31317a(zzczs.HTTP, (zzbbh<?>[]) new zzbbh[]{a6, a5}).mo31321a(new C9472hj(a5, a6)).mo31329a((zzczc<O, O2>) zzciu).mo31325a();
        return c.mo31317a(zzczs.PRE_PROCESS, (zzbbh<?>[]) new zzbbh[]{a5, a6, a7}).mo31321a(new C9494ij(a7, a5, a6)).mo31327a((zzbal<O, O2>) a4).mo31325a();
    }

    /* renamed from: a */
    public final void mo30023a(zzarx zzarx, zzarr zzarr) {
        zzbbh a = mo31169a(zzarx);
        m28456a(a, zzarr);
        a.mo28811a(new C9516jj(this), this.f26660c);
    }

    /* renamed from: b */
    public final void mo30024b(zzarx zzarx, zzarr zzarr) {
        zzbbh zzbbh;
        zzalr a = zzk.zzlt().mo29806a(this.f26659b, zzbai.m26367a());
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f23937Ge)).booleanValue()) {
            zzbbh = zzbar.m26375a((Throwable) new Exception("Signal collection disabled."));
        } else {
            zzcvs a2 = this.f26663f.mo30691a(zzarx);
            zzcvb b = this.f26663f.mo30691a(zzarx).mo29266b();
            zzbbh = a2.mo29267c().mo31319a(zzczs.GET_SIGNALS, (zzbbh<I>) zzbar.m26376a(zzarx.f24715a)).mo31327a((zzbal<O, O2>) new C9538kj<O,O2>(b)).mo31332a(zzczs.JS_SIGNALS).mo31327a((zzbal<O, O2>) a.mo29808a("google.afma.request.getSignals", zzalo.f24411b, zzalo.f24412c)).mo31325a();
        }
        m28456a(zzbbh, zzarr);
    }

    /* renamed from: a */
    private final void m28456a(zzbbh<InputStream> zzbbh, zzarr zzarr) {
        zzbar.m26383a(zzbar.m26379a(zzbbh, (zzbal<? super A, ? extends B>) new C9560lj<Object,Object>(this), (Executor) zzaxg.f24958a), (zzban<? super V>) new C9582mj<Object>(this, zzarr), zzbbm.f25065b);
    }

    /* renamed from: a */
    public final zzari mo30021a(zzarg zzarg) throws RemoteException {
        return null;
    }

    /* renamed from: a */
    public final void mo30022a(zzarg zzarg, zzarp zzarp) throws RemoteException {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ib */
    public final /* synthetic */ void mo31170ib() {
        zzbao.m26373a(this.f26662e.mo30046a(), "persistFlags");
    }
}
