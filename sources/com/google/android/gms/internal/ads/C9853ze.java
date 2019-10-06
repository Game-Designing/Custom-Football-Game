package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.google.android.gms.internal.ads.ze */
final class C9853ze implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f23560a;

    /* renamed from: b */
    private final /* synthetic */ String f23561b;

    /* renamed from: c */
    private final /* synthetic */ long f23562c;

    /* renamed from: d */
    private final /* synthetic */ long f23563d;

    /* renamed from: e */
    private final /* synthetic */ boolean f23564e;

    /* renamed from: f */
    private final /* synthetic */ int f23565f;

    /* renamed from: g */
    private final /* synthetic */ int f23566g;

    /* renamed from: h */
    private final /* synthetic */ zzbft f23567h;

    C9853ze(zzbft zzbft, String str, String str2, long j, long j2, boolean z, int i, int i2) {
        this.f23567h = zzbft;
        this.f23560a = str;
        this.f23561b = str2;
        this.f23562c = j;
        this.f23563d = j2;
        this.f23564e = z;
        this.f23565f = i;
        this.f23566g = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.f23560a);
        hashMap.put("cachedSrc", this.f23561b);
        hashMap.put("bufferedDuration", Long.toString(this.f23562c));
        hashMap.put("totalDuration", Long.toString(this.f23563d));
        hashMap.put("cacheReady", this.f23564e ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        hashMap.put("playerCount", Integer.toString(this.f23565f));
        hashMap.put("playerPreparedCount", Integer.toString(this.f23566g));
        this.f23567h.m26712a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
