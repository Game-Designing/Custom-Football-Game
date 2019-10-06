package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.Rf */
final /* synthetic */ class C9101Rf implements Runnable {

    /* renamed from: a */
    private final zzbgz f21657a;

    /* renamed from: b */
    private final JSONObject f21658b;

    C9101Rf(zzbgz zzbgz, JSONObject jSONObject) {
        this.f21657a = zzbgz;
        this.f21658b = jSONObject;
    }

    public final void run() {
        this.f21657a.mo28740b("AFMA_updateActiveView", this.f21658b);
    }
}
