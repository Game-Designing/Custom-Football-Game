package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzcwi implements zzcuz<JSONObject> {

    /* renamed from: a */
    private String f27494a;

    /* renamed from: b */
    private String f27495b;

    public zzcwi(String str, String str2) {
        this.f27494a = str;
        this.f27495b = str2;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        try {
            JSONObject a = zzazc.m26265a((JSONObject) obj, "pii");
            a.put("doritos", this.f27494a);
            a.put("doritos_v2", this.f27495b);
        } catch (JSONException e) {
            zzawz.m26003f("Failed putting doritos string.");
        }
    }
}
