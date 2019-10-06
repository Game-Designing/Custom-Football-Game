package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.De */
final class C8807De implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f20581a;

    /* renamed from: b */
    private final /* synthetic */ String f20582b;

    /* renamed from: c */
    private final /* synthetic */ String f20583c;

    /* renamed from: d */
    private final /* synthetic */ String f20584d;

    /* renamed from: e */
    private final /* synthetic */ zzbft f20585e;

    C8807De(zzbft zzbft, String str, String str2, String str3, String str4) {
        this.f20585e = zzbft;
        this.f20581a = str;
        this.f20582b = str2;
        this.f20583c = str3;
        this.f20584d = str4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheCanceled");
        hashMap.put("src", this.f20581a);
        if (!TextUtils.isEmpty(this.f20582b)) {
            hashMap.put("cachedSrc", this.f20582b);
        }
        hashMap.put("type", zzbft.mo30562c(this.f20583c));
        hashMap.put("reason", this.f20583c);
        if (!TextUtils.isEmpty(this.f20584d)) {
            hashMap.put("message", this.f20584d);
        }
        this.f20585e.m26712a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
