package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.Xi */
final /* synthetic */ class C9234Xi implements zzbal {

    /* renamed from: a */
    private final zzchq f21923a;

    /* renamed from: b */
    private final zzxt f21924b;

    C9234Xi(zzchq zzchq, zzxt zzxt) {
        this.f21923a = zzchq;
        this.f21924b = zzxt;
    }

    /* renamed from: a */
    public final zzbbh mo26658a(Object obj) {
        zzxt zzxt = this.f21924b;
        String str = (String) obj;
        String str2 = zzxt.f29719a;
        String str3 = zzxt.f29720b;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("headers", new JSONObject());
        jSONObject3.put("body", str2);
        jSONObject2.put("base_url", "");
        jSONObject2.put("signals", new JSONObject(str3));
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", new JSONObject());
        return zzbar.m26376a(jSONObject);
    }
}
