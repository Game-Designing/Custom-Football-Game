package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.google.android.gms.internal.ads.ye */
final class C9832ye implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f23517a;

    /* renamed from: b */
    private final /* synthetic */ String f23518b;

    /* renamed from: c */
    private final /* synthetic */ long f23519c;

    /* renamed from: d */
    private final /* synthetic */ long f23520d;

    /* renamed from: e */
    private final /* synthetic */ boolean f23521e;

    /* renamed from: f */
    private final /* synthetic */ zzbft f23522f;

    C9832ye(zzbft zzbft, String str, String str2, long j, long j2, boolean z) {
        this.f23522f = zzbft;
        this.f23517a = str;
        this.f23518b = str2;
        this.f23519c = j;
        this.f23520d = j2;
        this.f23521e = z;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.f23517a);
        hashMap.put("cachedSrc", this.f23518b);
        hashMap.put("bufferedDuration", Long.toString(this.f23519c));
        hashMap.put("totalDuration", Long.toString(this.f23520d));
        hashMap.put("cacheReady", this.f23521e ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        this.f23522f.m26712a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
