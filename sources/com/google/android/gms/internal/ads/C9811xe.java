package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.google.android.gms.internal.ads.xe */
final class C9811xe implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f23437a;

    /* renamed from: b */
    private final /* synthetic */ String f23438b;

    /* renamed from: c */
    private final /* synthetic */ int f23439c;

    /* renamed from: d */
    private final /* synthetic */ int f23440d = 0;

    /* renamed from: e */
    private final /* synthetic */ boolean f23441e;

    /* renamed from: f */
    private final /* synthetic */ int f23442f;

    /* renamed from: g */
    private final /* synthetic */ int f23443g;

    /* renamed from: h */
    private final /* synthetic */ zzbft f23444h;

    C9811xe(zzbft zzbft, String str, String str2, int i, int i2, boolean z, int i3, int i4) {
        this.f23444h = zzbft;
        this.f23437a = str;
        this.f23438b = str2;
        this.f23439c = i;
        this.f23441e = z;
        this.f23442f = i3;
        this.f23443g = i4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.f23437a);
        hashMap.put("cachedSrc", this.f23438b);
        hashMap.put("bytesLoaded", Integer.toString(this.f23439c));
        hashMap.put("totalBytes", Integer.toString(this.f23440d));
        hashMap.put("cacheReady", this.f23441e ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        hashMap.put("playerCount", Integer.toString(this.f23442f));
        hashMap.put("playerPreparedCount", Integer.toString(this.f23443g));
        this.f23444h.m26712a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
