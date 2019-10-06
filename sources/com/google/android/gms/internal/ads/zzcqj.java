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

public final class zzcqj extends zzasx {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public zzbbh<zzcdb> f27237b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public zzcdb f27238c;

    /* renamed from: d */
    private final zzbjm f27239d;

    /* renamed from: e */
    private final Context f27240e;

    /* renamed from: f */
    private final zzcqc f27241f = new zzcqc();

    /* renamed from: g */
    private final zzcpx f27242g = new zzcpx();

    /* renamed from: h */
    private final zzcpy f27243h = new zzcpy();

    /* renamed from: i */
    private zzbss f27244i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f27245j = false;

    /* renamed from: k */
    private final zzcxx f27246k = new zzcxx();

    /* renamed from: l */
    private boolean f27247l = false;

    public zzcqj(zzbjm zzbjm, Context context) {
        this.f27239d = zzbjm;
        this.f27240e = context;
    }

    /* renamed from: h */
    public final void mo29568h(String str) throws RemoteException {
    }

    /* renamed from: a */
    public final synchronized void mo29562a(zzath zzath) throws RemoteException {
        Preconditions.m21862a("loadAd must be called on the main UI thread.");
        this.f27245j = false;
        if (zzath.f24812b == null) {
            zzbad.m26355b("Ad unit ID should not be null for rewarded video ad.");
            this.f27239d.mo30693a().execute(new C9236Xk(this));
        } else if (!zzacw.m24785a(zzath.f24812b)) {
            if (this.f27237b == null) {
                if (m28793lb()) {
                    if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24123ke)).booleanValue()) {
                        return;
                    }
                }
                zzcya.m28996a(this.f27240e, zzath.f24811a.f29728f);
                this.f27238c = null;
                zzcdf a = this.f27239d.mo30701i().mo28195a(new zza().mo30871a(this.f27240e).mo30873a(this.f27246k.mo31294a(zzath.f24812b).mo31292a(zzyd.m31510a()).mo31291a(zzath.f24811a).mo31301c()).mo30874a((String) null).mo30875a()).mo28196a(new zzbtv.zza().mo30910a((zzbrl) this.f27241f, this.f27239d.mo30693a()).mo30914a((zzbsr) new C9298_k(this, this.f27241f), this.f27239d.mo30693a()).mo30911a((zzbro) this.f27241f, this.f27239d.mo30693a()).mo30909a((AdMetadataListener) this.f27242g, this.f27239d.mo30693a()).mo30908a((AppEventListener) this.f27243h, this.f27239d.mo30693a()).mo30917a()).mo28194a();
                this.f27244i = a.mo28261c();
                this.f27237b = a.mo28260b();
                zzbar.m26383a(this.f27237b, (zzban<? super V>) new C9257Yk<Object>(this, a), this.f27239d.mo30693a());
            }
        }
    }

    public final void destroy() throws RemoteException {
        mo29567h((IObjectWrapper) null);
    }

    /* renamed from: h */
    public final synchronized void mo29567h(IObjectWrapper iObjectWrapper) {
        Preconditions.m21862a("destroy must be called on the main UI thread.");
        Context context = null;
        this.f27242g.mo31232a(null);
        this.f27245j = false;
        if (this.f27238c != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.m22187H(iObjectWrapper);
            }
            this.f27238c.mo31122g().mo30881d(context);
        }
    }

    public final void pause() throws RemoteException {
        mo29559G(null);
    }

    /* renamed from: G */
    public final synchronized void mo29559G(IObjectWrapper iObjectWrapper) {
        Preconditions.m21862a("pause must be called on the main UI thread.");
        if (this.f27238c != null) {
            this.f27238c.mo31122g().mo30879b(iObjectWrapper == null ? null : (Context) ObjectWrapper.m22187H(iObjectWrapper));
        }
    }

    public final void resume() throws RemoteException {
        mo29558D(null);
    }

    /* renamed from: D */
    public final synchronized void mo29558D(IObjectWrapper iObjectWrapper) {
        Preconditions.m21862a("resume must be called on the main UI thread.");
        if (this.f27238c != null) {
            this.f27238c.mo31122g().mo30880c(iObjectWrapper == null ? null : (Context) ObjectWrapper.m22187H(iObjectWrapper));
        }
    }

    public final synchronized void show() throws RemoteException {
        mo29557A(null);
    }

    /* renamed from: A */
    public final synchronized void mo29557A(IObjectWrapper iObjectWrapper) throws RemoteException {
        Activity activity;
        Preconditions.m21862a("showAd must be called on the main UI thread.");
        if (this.f27238c != null) {
            if (iObjectWrapper != null) {
                Object H = ObjectWrapper.m22187H(iObjectWrapper);
                if (H instanceof Activity) {
                    activity = (Activity) H;
                    this.f27238c.mo31120a(this.f27247l, activity);
                }
            }
            activity = null;
            this.f27238c.mo31120a(this.f27247l, activity);
        }
    }

    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        if (this.f27238c == null) {
            return null;
        }
        return this.f27238c.mo30854b();
    }

    public final boolean isLoaded() throws RemoteException {
        Preconditions.m21862a("isLoaded must be called on the main UI thread.");
        return m28793lb();
    }

    /* renamed from: a */
    public final void mo29561a(zzatb zzatb) throws RemoteException {
        Preconditions.m21862a("setRewardedVideoAdListener can only be called from the UI thread.");
        this.f27241f.mo31240a(zzatb);
    }

    /* renamed from: a */
    public final void mo29560a(zzasu zzasu) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.f27241f.mo31239a(zzasu);
    }

    /* renamed from: a */
    public final void mo29563a(zzzp zzzp) {
        Preconditions.m21862a("setAdMetadataListener can only be called from the UI thread.");
        this.f27242g.mo31232a(new C9278Zk(this, zzzp));
    }

    public final Bundle getAdMetadata() {
        Preconditions.m21862a("getAdMetadata can only be called from the UI thread.");
        if (this.f27245j) {
            zzbss zzbss = this.f27244i;
            if (zzbss != null) {
                return zzbss.mo30889G();
            }
        }
        return new Bundle();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ib */
    public final void mo31243ib() {
        this.f27245j = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: jb */
    public final void mo31244jb() {
        this.f27242g.onAdMetadataChanged();
    }

    public final synchronized void setUserId(String str) throws RemoteException {
        Preconditions.m21862a("setUserId must be called on the main UI thread.");
        this.f27246k.mo31298b(str);
    }

    public final synchronized void setCustomData(String str) throws RemoteException {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24072cb)).booleanValue()) {
            Preconditions.m21862a("#008 Must be called on the main UI thread.: setCustomData");
            this.f27246k.mo31302c(str);
        }
    }

    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.m21862a("setImmersiveMode must be called on the main UI thread.");
        this.f27247l = z;
    }

    /* renamed from: lb */
    private final synchronized boolean m28793lb() {
        return this.f27238c != null && !this.f27238c.mo31121f();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: kb */
    public final /* synthetic */ void mo31245kb() {
        this.f27241f.onAdFailedToLoad(1);
    }
}
