package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbtv.zza;
import java.util.concurrent.Executor;

public final class zzcqd extends zzzl {

    /* renamed from: b */
    private final zzbjm f27215b;

    /* renamed from: c */
    private final Context f27216c;

    /* renamed from: d */
    private final Executor f27217d;

    /* renamed from: e */
    private final zzcpw f27218e = new zzcpw();

    /* renamed from: f */
    private final zzcpy f27219f = new zzcpy();

    /* renamed from: g */
    private final zzcqc f27220g = new zzcqc();

    /* renamed from: h */
    private final zzcxx f27221h = new zzcxx();

    /* renamed from: i */
    private zzado f27222i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public zzbvx f27223j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public zzbbh<zzbvx> f27224k;

    /* renamed from: l */
    private boolean f27225l = false;

    public zzcqd(zzbjm zzbjm, Context context, zzyd zzyd, String str) {
        this.f27215b = zzbjm;
        this.f27221h.mo31292a(zzyd).mo31294a(str);
        this.f27217d = zzbjm.mo30693a();
        this.f27216c = context;
    }

    /* renamed from: b */
    public final synchronized boolean mo29521b(zzxz zzxz) {
        Preconditions.m21862a("loadAd must be called on the main UI thread.");
        if (this.f27224k == null) {
            if (!m28752ib()) {
                zzcya.m28996a(this.f27216c, zzxz.f29728f);
                this.f27223j = null;
                zzcxv c = this.f27221h.mo31291a(zzxz).mo31301c();
                zza zza = new zza();
                if (this.f27220g != null) {
                    zza.mo30910a((zzbrl) this.f27220g, this.f27215b.mo30693a()).mo30914a((zzbsr) this.f27220g, this.f27215b.mo30693a()).mo30911a((zzbro) this.f27220g, this.f27215b.mo30693a());
                }
                zzbws a = this.f27215b.mo30699g().mo28074a(new zzbqy.zza().mo30871a(this.f27216c).mo30873a(c).mo30875a()).mo28075a(zza.mo30910a((zzbrl) this.f27218e, this.f27215b.mo30693a()).mo30914a((zzbsr) this.f27218e, this.f27215b.mo30693a()).mo30911a((zzbro) this.f27218e, this.f27215b.mo30693a()).mo30915a((zzxr) this.f27218e, this.f27215b.mo30693a()).mo30908a((AppEventListener) this.f27219f, this.f27215b.mo30693a()).mo30917a()).mo28076a(new zzcow(this.f27222i)).mo28073a();
                this.f27224k = a.mo28123b();
                zzbar.m26383a(this.f27224k, (zzban<? super V>) new C9152Tk<Object>(this, a), this.f27217d);
                return true;
            }
        }
        return false;
    }

    public final synchronized void destroy() {
        Preconditions.m21862a("destroy must be called on the main UI thread.");
        if (this.f27223j != null) {
            this.f27223j.mo30933g().mo30881d(null);
        }
    }

    public final synchronized void pause() {
        Preconditions.m21862a("pause must be called on the main UI thread.");
        if (this.f27223j != null) {
            this.f27223j.mo30933g().mo30879b(null);
        }
    }

    public final synchronized void resume() {
        Preconditions.m21862a("resume must be called on the main UI thread.");
        if (this.f27223j != null) {
            this.f27223j.mo30933g().mo30880c(null);
        }
    }

    /* renamed from: a */
    public final void mo29517a(zzyz zzyz) {
        Preconditions.m21862a("setAdListener must be called on the main UI thread.");
        this.f27218e.mo31231a(zzyz);
    }

    /* renamed from: a */
    public final void mo29519a(zzzs zzzs) {
        Preconditions.m21862a("setAppEventListener must be called on the main UI thread.");
        this.f27219f.mo31234a(zzzs);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void showInterstitial() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "showInterstitial must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.m21862a(r0)     // Catch:{ all -> 0x001d }
            com.google.android.gms.internal.ads.zzbvx r0 = r2.f27223j     // Catch:{ all -> 0x001d }
            if (r0 != 0) goto L_0x000c
            monitor-exit(r2)
            return
        L_0x000c:
            com.google.android.gms.internal.ads.zzbvx r0 = r2.f27223j     // Catch:{ all -> 0x001d }
            boolean r0 = r0.mo30934h()     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzbvx r0 = r2.f27223j     // Catch:{ all -> 0x001d }
            boolean r1 = r2.f27225l     // Catch:{ all -> 0x001d }
            r0.mo30931a(r1)     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r2)
            return
        L_0x001d:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqd.showInterstitial():void");
    }

    public final synchronized String getMediationAdapterClassName() {
        return this.f27223j == null ? null : this.f27223j.mo30854b();
    }

    /* renamed from: L */
    public final synchronized String mo29505L() {
        return this.f27223j == null ? null : this.f27223j.mo30856e();
    }

    /* renamed from: a */
    public final synchronized void mo29520a(zzzy zzzy) {
        Preconditions.m21862a("setCorrelationIdProvider must be called on the main UI thread");
        this.f27221h.mo31293a(zzzy);
    }

    /* renamed from: m */
    public final synchronized void mo29530m(boolean z) {
        Preconditions.m21862a("setManualImpressionsEnabled must be called from the main thread.");
        this.f27221h.mo31296a(z);
    }

    /* renamed from: I */
    public final synchronized boolean mo29503I() {
        return this.f27224k != null && !this.f27224k.isDone();
    }

    public final synchronized boolean isReady() {
        Preconditions.m21862a("isLoaded must be called on the main UI thread.");
        return m28752ib();
    }

    /* renamed from: cb */
    public final synchronized String mo29522cb() {
        return this.f27221h.mo31300b();
    }

    /* renamed from: Ta */
    public final zzzs mo29506Ta() {
        return this.f27219f.mo31233a();
    }

    /* renamed from: Ya */
    public final zzyz mo29507Ya() {
        return this.f27218e.mo31230a();
    }

    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.m21862a("setImmersiveMode must be called on the main UI thread.");
        this.f27225l = z;
    }

    /* renamed from: a */
    public final synchronized void mo29510a(zzacd zzacd) {
        this.f27221h.mo31288a(zzacd);
    }

    /* renamed from: a */
    public final synchronized void mo29511a(zzado zzado) {
        Preconditions.m21862a("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.f27222i = zzado;
    }

    /* renamed from: ib */
    private final synchronized boolean m28752ib() {
        return this.f27223j != null && !this.f27223j.mo30932f();
    }

    /* renamed from: a */
    public final void mo29518a(zzzp zzzp) {
        Preconditions.m21862a("setAdMetadataListener must be called on the main UI thread.");
    }

    public final Bundle getAdMetadata() {
        Preconditions.m21862a("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    /* renamed from: Aa */
    public final IObjectWrapper mo29502Aa() {
        return null;
    }

    /* renamed from: Za */
    public final zzyd mo29508Za() {
        return null;
    }

    /* renamed from: a */
    public final void mo29515a(zzyd zzyd) {
    }

    /* renamed from: Ka */
    public final void mo29504Ka() {
    }

    /* renamed from: db */
    public final void mo29523db() {
    }

    /* renamed from: a */
    public final void mo29512a(zzaqn zzaqn) {
    }

    /* renamed from: a */
    public final void mo29513a(zzaqt zzaqt, String str) {
    }

    /* renamed from: a */
    public final void mo29516a(zzyw zzyw) {
    }

    /* renamed from: a */
    public final void mo29514a(zzatb zzatb) {
        this.f27220g.mo31240a(zzatb);
    }

    public final void setUserId(String str) {
    }

    /* renamed from: e */
    public final void mo29525e(String str) {
    }

    public final zzaar getVideoController() {
        return null;
    }

    /* renamed from: a */
    public final void mo29509a(zzaax zzaax) {
    }
}
