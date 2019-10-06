package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.Be */
final class C8765Be implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f20494a;

    /* renamed from: b */
    private final /* synthetic */ String f20495b;

    /* renamed from: c */
    private final /* synthetic */ int f20496c;

    /* renamed from: d */
    private final /* synthetic */ zzbft f20497d;

    C8765Be(zzbft zzbft, String str, String str2, int i) {
        this.f20497d = zzbft;
        this.f20494a = str;
        this.f20495b = str2;
        this.f20496c = i;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.f20494a);
        hashMap.put("cachedSrc", this.f20495b);
        hashMap.put("totalBytes", Integer.toString(this.f20496c));
        this.f20497d.m26712a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
