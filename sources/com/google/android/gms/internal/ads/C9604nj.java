package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.nj */
final class C9604nj implements zzalm<zzcir> {
    C9604nj() {
    }

    /* renamed from: a */
    public final /* synthetic */ JSONObject mo28177a(Object obj) throws JSONException {
        zzcir zzcir = (zzcir) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzcir.f26667d.mo30040b());
        jSONObject2.put("signals", zzcir.f26666c);
        jSONObject3.put("body", zzcir.f26665b.f26681c);
        jSONObject3.put("headers", zzk.zzlg().mo30230a(zzcir.f26665b.f26680b));
        jSONObject3.put("response_code", zzcir.f26665b.f26679a);
        jSONObject3.put("latency", zzcir.f26665b.f26682d);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzcir.f26667d.mo30043e());
        return jSONObject;
    }
}
