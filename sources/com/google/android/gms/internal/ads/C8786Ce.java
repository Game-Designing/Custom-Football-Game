package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.Ce */
final class C8786Ce implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f20539a;

    /* renamed from: b */
    private final /* synthetic */ String f20540b;

    /* renamed from: c */
    private final /* synthetic */ long f20541c;

    /* renamed from: d */
    private final /* synthetic */ zzbft f20542d;

    C8786Ce(zzbft zzbft, String str, String str2, long j) {
        this.f20542d = zzbft;
        this.f20539a = str;
        this.f20540b = str2;
        this.f20541c = j;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.f20539a);
        hashMap.put("cachedSrc", this.f20540b);
        hashMap.put("totalDuration", Long.toString(this.f20541c));
        this.f20542d.m26712a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
