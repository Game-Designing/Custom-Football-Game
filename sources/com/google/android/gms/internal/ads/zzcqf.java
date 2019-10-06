package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbqy.zza;

public final class zzcqf extends zzatu {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public zzbbh<zzcdb> f27226b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public zzcdb f27227c;

    /* renamed from: d */
    private final zzbjm f27228d;

    /* renamed from: e */
    private final Context f27229e;

    /* renamed from: f */
    private final zzcqa f27230f = new zzcqa();

    /* renamed from: g */
    private final zzcqb f27231g = new zzcqb();

    /* renamed from: h */
    private final zzcpz f27232h = new zzcpz();

    /* renamed from: i */
    private zzbss f27233i;

    /* renamed from: j */
    private final String f27234j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f27235k = false;

    /* renamed from: l */
    private final zzcxx f27236l;

    public zzcqf(zzbjm zzbjm, Context context, String str) {
        zzcxx zzcxx = new zzcxx();
        zzcxx.f27627p.add("new_rewarded");
        this.f27236l = zzcxx;
        this.f27228d = zzbjm;
        this.f27229e = context;
        this.f27234j = str;
    }

    /* renamed from: a */
    public final synchronized void mo29552a(zzxz zzxz, zzaub zzaub) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        this.f27231g.mo31238a(zzaub);
        this.f27235k = false;
        if (this.f27226b == null) {
            if (this.f27227c == null) {
                zzcya.m28996a(this.f27229e, zzxz.f29728f);
                zzcdf a = this.f27228d.mo30701i().mo28195a(new zza().mo30871a(this.f27229e).mo30873a(this.f27236l.mo31294a(this.f27234j).mo31292a(zzyd.m31510a()).mo31291a(zzxz).mo31301c()).mo30875a()).mo28196a(new zzbtv.zza().mo30910a((zzbrl) this.f27230f, this.f27228d.mo30693a()).mo30914a((zzbsr) new C9215Wk(this, this.f27231g), this.f27228d.mo30693a()).mo30911a((zzbro) this.f27231g, this.f27228d.mo30693a()).mo30912a((zzbrs) this.f27230f, this.f27228d.mo30693a()).mo30909a((AdMetadataListener) this.f27232h, this.f27228d.mo30693a()).mo30908a((AppEventListener) new zzcpy(), this.f27228d.mo30693a()).mo30917a()).mo28194a();
                this.f27233i = a.mo28261c();
                this.f27226b = a.mo28260b();
                zzbar.m26383a(this.f27226b, (zzban<? super V>) new C9173Uk<Object>(this, a), this.f27228d.mo30693a());
            }
        }
    }

    /* renamed from: C */
    public final synchronized void mo29546C(IObjectWrapper iObjectWrapper) throws RemoteException {
        mo29547a(iObjectWrapper, false);
    }

    /* renamed from: a */
    public final synchronized void mo29547a(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        if (this.f27227c == null) {
            zzbad.m26359d("Rewarded can not be shown before loaded");
            this.f27230f.mo30876d(2);
            return;
        }
        this.f27227c.mo31120a(z, (Activity) ObjectWrapper.m22187H(iObjectWrapper));
    }

    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        if (this.f27227c == null) {
            return null;
        }
        return this.f27227c.mo30854b();
    }

    public final boolean isLoaded() throws RemoteException {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        return this.f27235k;
    }

    /* renamed from: a */
    public final void mo29549a(zzatw zzatw) throws RemoteException {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        this.f27230f.mo31236a(zzatw);
    }

    /* renamed from: a */
    public final void mo29550a(zzaue zzaue) throws RemoteException {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        this.f27230f.mo31237a(zzaue);
    }

    /* renamed from: a */
    public final void mo29548a(zzaao zzaao) throws RemoteException {
        this.f27232h.mo31235a(new C9194Vk(this, zzaao));
    }

    public final Bundle getAdMetadata() throws RemoteException {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        if (this.f27235k) {
            zzbss zzbss = this.f27233i;
            if (zzbss != null) {
                return zzbss.mo30889G();
            }
        }
        return new Bundle();
    }

    /* renamed from: xa */
    public final zzatq mo29556xa() {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        if (this.f27235k) {
            zzcdb zzcdb = this.f27227c;
            if (zzcdb != null) {
                return zzcdb.mo31123h();
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ib */
    public final void mo31241ib() {
        this.f27235k = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: jb */
    public final void mo31242jb() {
        this.f27232h.onAdMetadataChanged();
    }

    /* renamed from: a */
    public final synchronized void mo29551a(zzaum zzaum) throws RemoteException {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        this.f27236l.mo31298b(zzaum.f24827a);
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24072cb)).booleanValue()) {
            this.f27236l.mo31302c(zzaum.f24828b);
        }
    }
}
