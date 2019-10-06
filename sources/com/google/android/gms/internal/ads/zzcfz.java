package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.zzk;
import java.util.Collections;
import java.util.List;

public final class zzcfz implements AppEventListener, zzbrl, zzbro, zzbrw, zzbrx, zzbsr, zzbtk, zzczz, zzxr {

    /* renamed from: a */
    private final List<Object> f26564a;

    /* renamed from: b */
    private final zzcfn f26565b;

    /* renamed from: c */
    private long f26566c;

    public zzcfz(zzcfn zzcfn, zzbjm zzbjm) {
        this.f26565b = zzcfn;
        this.f26564a = Collections.singletonList(zzbjm);
    }

    /* renamed from: b */
    public final void mo29183b(Context context) {
        m28391a(zzbrx.class, "onPause", context);
    }

    /* renamed from: d */
    public final void mo29185d(Context context) {
        m28391a(zzbrx.class, "onResume", context);
    }

    /* renamed from: c */
    public final void mo29184c(Context context) {
        m28391a(zzbrx.class, "onDestroy", context);
    }

    public final void onAppEvent(String str, String str2) {
        m28391a(AppEventListener.class, "onAppEvent", str, str2);
    }

    public final void onAdLoaded() {
        long a = zzk.zzln().mo27934a() - this.f26566c;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Ad Request Latency : ");
        sb.append(a);
        zzawz.m26003f(sb.toString());
        m28391a(zzbsr.class, "onAdLoaded", new Object[0]);
    }

    public final void onAdFailedToLoad(int i) {
        m28391a(zzbro.class, "onAdFailedToLoad", Integer.valueOf(i));
    }

    public final void onAdOpened() {
        m28391a(zzbrl.class, "onAdOpened", new Object[0]);
    }

    public final void onAdClosed() {
        m28391a(zzbrl.class, "onAdClosed", new Object[0]);
    }

    public final void onAdLeftApplication() {
        m28391a(zzbrl.class, "onAdLeftApplication", new Object[0]);
    }

    public final void onAdClicked() {
        m28391a(zzxr.class, "onAdClicked", new Object[0]);
    }

    public final void onAdImpression() {
        m28391a(zzbrw.class, "onAdImpression", new Object[0]);
    }

    public final void onRewardedVideoStarted() {
        m28391a(zzbrl.class, "onRewardedVideoStarted", new Object[0]);
    }

    /* renamed from: a */
    public final void mo30729a(zzasr zzasr, String str, String str2) {
        m28391a(zzbrl.class, "onRewarded", zzasr, str, str2);
    }

    public final void onRewardedVideoCompleted() {
        m28391a(zzbrl.class, "onRewardedVideoCompleted", new Object[0]);
    }

    /* renamed from: c */
    public final void mo31139c(zzczs zzczs, String str) {
        m28391a(zzczr.class, "onTaskCreated", str);
    }

    /* renamed from: b */
    public final void mo31138b(zzczs zzczs, String str) {
        m28391a(zzczr.class, "onTaskStarted", str);
    }

    /* renamed from: a */
    public final void mo31137a(zzczs zzczs, String str, Throwable th) {
        m28391a(zzczr.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    /* renamed from: a */
    public final void mo31136a(zzczs zzczs, String str) {
        m28391a(zzczr.class, "onTaskSucceeded", str);
    }

    /* renamed from: a */
    private final void m28391a(Class cls, String str, Object... objArr) {
        zzcfn zzcfn = this.f26565b;
        List<Object> list = this.f26564a;
        String valueOf = String.valueOf(cls.getSimpleName());
        String str2 = "Event-";
        zzcfn.mo31145a(list, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), str, objArr);
    }

    /* renamed from: a */
    public final void mo28900a(zzarx zzarx) {
        this.f26566c = zzk.zzln().mo27934a();
        m28391a(zzbtk.class, "onAdRequest", new Object[0]);
    }

    /* renamed from: a */
    public final void mo28901a(zzcxu zzcxu) {
    }
}
