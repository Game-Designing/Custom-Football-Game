package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbqy.zza;

public final class zzcpp extends zzzd {

    /* renamed from: b */
    private final Context f27185b;

    /* renamed from: c */
    private final zzbjm f27186c;

    /* renamed from: d */
    private final zzcxx f27187d;

    /* renamed from: e */
    private final zzbzc f27188e;

    /* renamed from: f */
    private final zzcpw f27189f = new zzcpw();

    /* renamed from: g */
    private final zzbro f27190g;

    /* renamed from: h */
    private zzbpk f27191h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f27192i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f27193j;

    public zzcpp(Context context, zzbjm zzbjm, zzcxx zzcxx, zzbzc zzbzc, zzyz zzyz) {
        this.f27185b = context;
        this.f27186c = zzbjm;
        this.f27187d = zzcxx;
        this.f27188e = zzbzc;
        this.f27189f.mo31231a(zzyz);
        this.f27190g = new C9065Pk(this.f27189f, zzbzc.mo31039e());
    }

    /* renamed from: I */
    public final synchronized boolean mo28920I() throws RemoteException {
        return this.f27191h != null && this.f27191h.mo30859a();
    }

    /* renamed from: a */
    public final void mo28922a(zzxz zzxz) {
        mo28923a(zzxz, 1);
    }

    /* renamed from: a */
    public final synchronized void mo28923a(zzxz zzxz, int i) {
        if (this.f27187d.mo31300b() == null) {
            zzbad.m26355b("Ad unit ID should not be null for AdLoader.");
            this.f27186c.mo30693a().execute(new C9044Ok(this));
            return;
        }
        zzcya.m28996a(this.f27185b, zzxz.f29728f);
        this.f27192i = null;
        this.f27193j = null;
        zzcxv c = this.f27187d.mo31291a(zzxz).mo31286a(i).mo31301c();
        zzbxo a = this.f27186c.mo30700h().mo29180a(new zza().mo30871a(this.f27185b).mo30873a(c).mo30875a()).mo29181a(new zzbtv.zza().mo30914a((zzbsr) this.f27189f, this.f27186c.mo30693a()).mo30911a(this.f27190g, this.f27186c.mo30693a()).mo30913a((zzbrw) this.f27189f, this.f27186c.mo30693a()).mo30915a((zzxr) this.f27189f, this.f27186c.mo30693a()).mo30910a((zzbrl) this.f27189f, this.f27186c.mo30693a()).mo30916a(c.f27610n, this.f27186c.mo30693a()).mo30917a()).mo29182a(new zzbxk(this.f27188e, this.f27189f.mo31230a())).mo29179a();
        a.mo29204d().mo31305a(1);
        this.f27191h = a.mo29199a();
        this.f27191h.mo30858a((zzban<zzbpc>) new C9086Qk<zzbpc>(this, a));
    }

    public final synchronized String getMediationAdapterClassName() {
        return this.f27192i;
    }

    /* renamed from: L */
    public final synchronized String mo28921L() {
        return this.f27193j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ib */
    public final /* synthetic */ void mo31228ib() {
        this.f27190g.onAdFailedToLoad(1);
    }
}
