package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.N */
final class C9012N implements zzahw {

    /* renamed from: a */
    private final /* synthetic */ zzbbr f21498a;

    C9012N(zzahu zzahu, zzbbr zzbbr) {
        this.f21498a = zzbbr;
    }

    /* renamed from: a */
    public final void mo28373a(JSONObject jSONObject) {
        this.f21498a.mo30338b(jSONObject);
    }

    public final void onFailure(String str) {
        this.f21498a.mo30337a(new zzali(str));
    }
}
