package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.Sf */
final /* synthetic */ class C9122Sf implements Runnable {

    /* renamed from: a */
    private final zzbmy f21692a;

    /* renamed from: b */
    private final JSONObject f21693b;

    C9122Sf(zzbmy zzbmy, JSONObject jSONObject) {
        this.f21692a = zzbmy;
        this.f21693b = jSONObject;
    }

    public final void run() {
        this.f21692a.mo30747a(this.f21693b);
    }
}
