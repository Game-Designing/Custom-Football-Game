package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbqy.zza;
import java.util.Collections;

@zzard
public final class zzcpt extends zzzl implements zzbtf {

    /* renamed from: b */
    private final zzbjm f27194b;

    /* renamed from: c */
    private final Context f27195c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final ViewGroup f27196d;

    /* renamed from: e */
    private final zzcpw f27197e = new zzcpw();

    /* renamed from: f */
    private final zzcpv f27198f = new zzcpv();

    /* renamed from: g */
    private final zzcpy f27199g = new zzcpy();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final zzbtb f27200h;

    /* renamed from: i */
    private final zzcxx f27201i = new zzcxx();

    /* renamed from: j */
    private zzado f27202j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public zzbnf f27203k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public zzbbh<zzbnf> f27204l;

    public zzcpt(zzbjm zzbjm, Context context, zzyd zzyd, String str) {
        this.f27196d = new FrameLayout(context);
        this.f27194b = zzbjm;
        this.f27195c = context;
        this.f27201i.mo31292a(zzyd).mo31294a(str);
        this.f27200h = zzbjm.mo30695c();
        this.f27200h.mo30897a(this, this.f27194b.mo30693a());
    }

    /* renamed from: Aa */
    public final IObjectWrapper mo29502Aa() {
        Preconditions.m21862a("destroy must be called on the main UI thread.");
        return ObjectWrapper.m22188a(this.f27196d);
    }

    /* renamed from: b */
    public final synchronized boolean mo29521b(zzxz zzxz) {
        Preconditions.m21862a("loadAd must be called on the main UI thread.");
        if (this.f27204l != null) {
            return false;
        }
        zzcya.m28996a(this.f27195c, zzxz.f29728f);
        zzboc a = m28706a(this.f27201i.mo31291a(zzxz).mo31301c());
        this.f27204l = a.mo29322b();
        zzbar.m26383a(this.f27204l, (zzban<? super V>) new C9106Rk<Object>(this, a), this.f27194b.mo30693a());
        return true;
    }

    /* renamed from: a */
    private final synchronized zzboc m28706a(zzcxv zzcxv) {
        return this.f27194b.mo30698f().mo29295a(new zza().mo30871a(this.f27195c).mo30873a(zzcxv).mo30875a()).mo29296a(new zzbtv.zza().mo30915a((zzxr) this.f27197e, this.f27194b.mo30693a()).mo30915a((zzxr) this.f27198f, this.f27194b.mo30693a()).mo30910a((zzbrl) this.f27197e, this.f27194b.mo30693a()).mo30914a((zzbsr) this.f27197e, this.f27194b.mo30693a()).mo30911a((zzbro) this.f27197e, this.f27194b.mo30693a()).mo30908a((AppEventListener) this.f27199g, this.f27194b.mo30693a()).mo30917a()).mo29298a(new zzcow(this.f27202j)).mo29297a(new zzbxk(zzbzc.f26157a, null)).mo29294a(new zzbox(this.f27200h)).mo29293a(new zzbnc(this.f27196d)).mo29292a();
    }

    public final synchronized void destroy() {
        Preconditions.m21862a("destroy must be called on the main UI thread.");
        if (this.f27203k != null) {
            this.f27203k.mo30853a();
        }
    }

    public final synchronized void pause() {
        Preconditions.m21862a("pause must be called on the main UI thread.");
        if (this.f27203k != null) {
            this.f27203k.mo30855d().mo30879b(null);
        }
    }

    public final synchronized void resume() {
        Preconditions.m21862a("resume must be called on the main UI thread.");
        if (this.f27203k != null) {
            this.f27203k.mo30855d().mo30880c(null);
        }
    }

    /* renamed from: a */
    public final void mo29517a(zzyz zzyz) {
        Preconditions.m21862a("setAdListener must be called on the main UI thread.");
        this.f27197e.mo31231a(zzyz);
    }

    /* renamed from: Ya */
    public final zzyz mo29507Ya() {
        return this.f27197e.mo31230a();
    }

    /* renamed from: a */
    public final void mo29519a(zzzs zzzs) {
        Preconditions.m21862a("setAppEventListener must be called on the main UI thread.");
        this.f27199g.mo31234a(zzzs);
    }

    /* renamed from: Ta */
    public final zzzs mo29506Ta() {
        return this.f27199g.mo31233a();
    }

    /* renamed from: db */
    public final synchronized void mo29523db() {
        Preconditions.m21862a("recordManualImpression must be called on the main UI thread.");
        if (this.f27203k != null) {
            this.f27203k.mo28638j();
        }
    }

    /* renamed from: Za */
    public final synchronized zzyd mo29508Za() {
        Preconditions.m21862a("getAdSize must be called on the main UI thread.");
        if (this.f27203k != null) {
            return zzcxy.m28988a(this.f27195c, Collections.singletonList(this.f27203k.mo28636h()));
        }
        return this.f27201i.mo31303d();
    }

    /* renamed from: a */
    public final synchronized void mo29515a(zzyd zzyd) {
        Preconditions.m21862a("setAdSize must be called on the main UI thread.");
        this.f27201i.mo31292a(zzyd);
        if (this.f27203k != null) {
            this.f27203k.mo28632a(this.f27196d, zzyd);
        }
    }

    public final synchronized String getMediationAdapterClassName() {
        return this.f27203k == null ? null : this.f27203k.mo30854b();
    }

    /* renamed from: L */
    public final synchronized String mo29505L() {
        return this.f27203k == null ? null : this.f27203k.mo30856e();
    }

    /* renamed from: a */
    public final synchronized void mo29520a(zzzy zzzy) {
        Preconditions.m21862a("setCorrelationIdProvider must be called on the main UI thread");
        this.f27201i.mo31293a(zzzy);
    }

    /* renamed from: m */
    public final synchronized void mo29530m(boolean z) {
        Preconditions.m21862a("setManualImpressionsEnabled must be called from the main thread.");
        this.f27201i.mo31296a(z);
    }

    /* renamed from: I */
    public final synchronized boolean mo29503I() {
        return this.f27204l != null && !this.f27204l.isDone();
    }

    public final synchronized zzaar getVideoController() {
        Preconditions.m21862a("getVideoController must be called from the main thread.");
        if (this.f27203k == null) {
            return null;
        }
        return this.f27203k.mo28634f();
    }

    /* renamed from: cb */
    public final synchronized String mo29522cb() {
        return this.f27201i.mo31300b();
    }

    /* renamed from: a */
    public final synchronized void mo29510a(zzacd zzacd) {
        Preconditions.m21862a("setVideoOptions must be called on the main UI thread.");
        this.f27201i.mo31288a(zzacd);
    }

    /* renamed from: a */
    public final void mo29516a(zzyw zzyw) {
        Preconditions.m21862a("setAdListener must be called on the main UI thread.");
        this.f27198f.mo31229a(zzyw);
    }

    /* renamed from: a */
    public final synchronized void mo29511a(zzado zzado) {
        Preconditions.m21862a("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.f27202j = zzado;
    }

    /* renamed from: gb */
    public final synchronized void mo30894gb() {
        boolean z;
        ViewParent parent = this.f27196d.getParent();
        if (!(parent instanceof View)) {
            z = false;
        } else {
            View view = (View) parent;
            z = zzk.zzlg().mo30235a(view, view.getContext());
        }
        if (z) {
            mo29521b(this.f27201i.mo31297a());
        } else {
            this.f27200h.mo30891b(60);
        }
    }

    /* renamed from: a */
    public final void mo29518a(zzzp zzzp) {
        Preconditions.m21862a("setAdMetadataListener must be called on the main UI thread.");
    }

    public final Bundle getAdMetadata() {
        Preconditions.m21862a("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final boolean isReady() {
        return false;
    }

    public final void showInterstitial() {
    }

    /* renamed from: Ka */
    public final void mo29504Ka() {
    }

    /* renamed from: a */
    public final void mo29512a(zzaqn zzaqn) {
    }

    /* renamed from: a */
    public final void mo29513a(zzaqt zzaqt, String str) {
    }

    /* renamed from: a */
    public final void mo29514a(zzatb zzatb) {
    }

    public final void setUserId(String str) {
    }

    /* renamed from: e */
    public final void mo29525e(String str) {
    }

    /* renamed from: a */
    public final void mo29509a(zzaax zzaax) {
    }

    public final void setImmersiveMode(boolean z) {
    }
}
