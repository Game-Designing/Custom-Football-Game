package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.google.android.gms.internal.ads.we */
final class C9790we implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f23353a;

    /* renamed from: b */
    private final /* synthetic */ String f23354b;

    /* renamed from: c */
    private final /* synthetic */ int f23355c;

    /* renamed from: d */
    private final /* synthetic */ int f23356d;

    /* renamed from: e */
    private final /* synthetic */ boolean f23357e = false;

    /* renamed from: f */
    private final /* synthetic */ zzbft f23358f;

    C9790we(zzbft zzbft, String str, String str2, int i, int i2, boolean z) {
        this.f23358f = zzbft;
        this.f23353a = str;
        this.f23354b = str2;
        this.f23355c = i;
        this.f23356d = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.f23353a);
        hashMap.put("cachedSrc", this.f23354b);
        hashMap.put("bytesLoaded", Integer.toString(this.f23355c));
        hashMap.put("totalBytes", Integer.toString(this.f23356d));
        hashMap.put("cacheReady", this.f23357e ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        this.f23358f.m26712a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
