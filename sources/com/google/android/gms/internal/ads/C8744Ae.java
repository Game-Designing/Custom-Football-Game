package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.google.android.gms.internal.ads.Ae */
final class C8744Ae implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f20376a;

    /* renamed from: b */
    private final /* synthetic */ String f20377b;

    /* renamed from: c */
    private final /* synthetic */ int f20378c;

    /* renamed from: d */
    private final /* synthetic */ int f20379d;

    /* renamed from: e */
    private final /* synthetic */ long f20380e;

    /* renamed from: f */
    private final /* synthetic */ long f20381f;

    /* renamed from: g */
    private final /* synthetic */ boolean f20382g;

    /* renamed from: h */
    private final /* synthetic */ int f20383h;

    /* renamed from: i */
    private final /* synthetic */ int f20384i;

    /* renamed from: j */
    private final /* synthetic */ zzbft f20385j;

    C8744Ae(zzbft zzbft, String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        this.f20385j = zzbft;
        this.f20376a = str;
        this.f20377b = str2;
        this.f20378c = i;
        this.f20379d = i2;
        this.f20380e = j;
        this.f20381f = j2;
        this.f20382g = z;
        this.f20383h = i3;
        this.f20384i = i4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.f20376a);
        hashMap.put("cachedSrc", this.f20377b);
        hashMap.put("bytesLoaded", Integer.toString(this.f20378c));
        hashMap.put("totalBytes", Integer.toString(this.f20379d));
        hashMap.put("bufferedDuration", Long.toString(this.f20380e));
        hashMap.put("totalDuration", Long.toString(this.f20381f));
        hashMap.put("cacheReady", this.f20382g ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        hashMap.put("playerCount", Integer.toString(this.f20383h));
        hashMap.put("playerPreparedCount", Integer.toString(this.f20384i));
        this.f20385j.m26712a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
