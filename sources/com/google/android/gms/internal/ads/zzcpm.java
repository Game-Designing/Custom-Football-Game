package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

public final class zzcpm extends zzzl {

    /* renamed from: b */
    private final Context f27171b;

    /* renamed from: c */
    private final zzyz f27172c;

    /* renamed from: d */
    private final zzcxv f27173d;

    /* renamed from: e */
    private final zzbnf f27174e;

    /* renamed from: f */
    private final ViewGroup f27175f;

    public zzcpm(Context context, zzyz zzyz, zzcxv zzcxv, zzbnf zzbnf) {
        this.f27171b = context;
        this.f27172c = zzyz;
        this.f27173d = zzcxv;
        this.f27174e = zzbnf;
        FrameLayout frameLayout = new FrameLayout(this.f27171b);
        frameLayout.removeAllViews();
        frameLayout.addView(this.f27174e.mo28635g(), zzk.zzli().mo30257b());
        frameLayout.setMinimumHeight(mo29508Za().f29770c);
        frameLayout.setMinimumWidth(mo29508Za().f29773f);
        this.f27175f = frameLayout;
    }

    /* renamed from: Aa */
    public final IObjectWrapper mo29502Aa() throws RemoteException {
        return ObjectWrapper.m22188a(this.f27175f);
    }

    public final void destroy() throws RemoteException {
        Preconditions.m21862a("destroy must be called on the main UI thread.");
        this.f27174e.mo30853a();
    }

    /* renamed from: b */
    public final boolean mo29521b(zzxz zzxz) throws RemoteException {
        zzbad.m26357c("loadAd is not supported for a Publisher AdView returned from AdLoader.");
        return false;
    }

    public final void pause() throws RemoteException {
        Preconditions.m21862a("destroy must be called on the main UI thread.");
        this.f27174e.mo30855d().mo30879b(null);
    }

    public final void resume() throws RemoteException {
        Preconditions.m21862a("destroy must be called on the main UI thread.");
        this.f27174e.mo30855d().mo30880c(null);
    }

    /* renamed from: db */
    public final void mo29523db() throws RemoteException {
        this.f27174e.mo28638j();
    }

    /* renamed from: Za */
    public final zzyd mo29508Za() {
        return zzcxy.m28988a(this.f27171b, Collections.singletonList(this.f27174e.mo28636h()));
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return this.f27174e.mo30854b();
    }

    public final zzaar getVideoController() throws RemoteException {
        return this.f27174e.mo28634f();
    }

    /* renamed from: cb */
    public final String mo29522cb() throws RemoteException {
        return this.f27173d.f27602f;
    }

    /* renamed from: Ta */
    public final zzzs mo29506Ta() throws RemoteException {
        return this.f27173d.f27610n;
    }

    /* renamed from: Ya */
    public final zzyz mo29507Ya() throws RemoteException {
        return this.f27172c;
    }

    /* renamed from: L */
    public final String mo29505L() throws RemoteException {
        return this.f27174e.mo30856e();
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    /* renamed from: a */
    public final void mo29510a(zzacd zzacd) throws RemoteException {
        zzbad.m26357c("setVideoOptions is not supported in Publisher AdView returned by AdLoader.");
    }

    /* renamed from: a */
    public final void mo29509a(zzaax zzaax) throws RemoteException {
    }

    /* renamed from: I */
    public final boolean mo29503I() throws RemoteException {
        return false;
    }

    /* renamed from: a */
    public final void mo29514a(zzatb zzatb) throws RemoteException {
    }

    public final void setUserId(String str) throws RemoteException {
    }

    /* renamed from: e */
    public final void mo29525e(String str) throws RemoteException {
    }

    /* renamed from: a */
    public final void mo29515a(zzyd zzyd) throws RemoteException {
        zzbnf zzbnf = this.f27174e;
        if (zzbnf != null) {
            zzbnf.mo28632a(this.f27175f, zzyd);
        }
    }

    /* renamed from: a */
    public final void mo29512a(zzaqn zzaqn) throws RemoteException {
    }

    /* renamed from: a */
    public final void mo29513a(zzaqt zzaqt, String str) throws RemoteException {
    }

    public final boolean isReady() throws RemoteException {
        return false;
    }

    /* renamed from: a */
    public final void mo29511a(zzado zzado) throws RemoteException {
        zzbad.m26357c("setOnCustomRenderedAdLoadedListener is not supported in Publisher AdView returned by AdLoader.");
    }

    /* renamed from: a */
    public final void mo29516a(zzyw zzyw) throws RemoteException {
        zzbad.m26357c("setAdClickListener is not supported in Publisher AdView returned by AdLoader.");
    }

    /* renamed from: a */
    public final void mo29520a(zzzy zzzy) throws RemoteException {
        zzbad.m26357c("setCorrelationIdProvider is not supported in Publisher AdView returned by AdLoader.");
    }

    /* renamed from: m */
    public final void mo29530m(boolean z) throws RemoteException {
        zzbad.m26357c("setManualImpressionsEnabled is not supported in Publisher AdView returned by AdLoader.");
    }

    /* renamed from: a */
    public final void mo29517a(zzyz zzyz) throws RemoteException {
        zzbad.m26357c("setAdListener is not supported in Publisher AdView returned by AdLoader.");
    }

    /* renamed from: a */
    public final void mo29519a(zzzs zzzs) throws RemoteException {
        zzbad.m26357c("setAppEventListener is not supported in Publisher AdView returned by AdLoader.");
    }

    /* renamed from: a */
    public final void mo29518a(zzzp zzzp) throws RemoteException {
        zzbad.m26357c("setAdMetadataListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final Bundle getAdMetadata() throws RemoteException {
        zzbad.m26357c("getAdMetadata is not supported in Publisher AdView returned by AdLoader.");
        return new Bundle();
    }

    public final void showInterstitial() throws RemoteException {
    }

    /* renamed from: Ka */
    public final void mo29504Ka() throws RemoteException {
    }
}
