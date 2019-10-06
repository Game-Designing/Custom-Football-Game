package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.google.android.gms.internal.ads.Yh */
final /* synthetic */ class C9254Yh implements zzue {

    /* renamed from: a */
    private final zzbgz f21990a;

    C9254Yh(zzbgz zzbgz) {
        this.f21990a = zzbgz;
    }

    /* renamed from: a */
    public final void mo28694a(zzud zzud) {
        zzbgz zzbgz = this.f21990a;
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", zzud.f29465m ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        zzbgz.mo28729a("onAdVisibilityChanged", (Map<String, ?>) hashMap);
    }
}
