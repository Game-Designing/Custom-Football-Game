package com.google.android.gms.internal.ads;

import java.io.InputStream;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.gj */
final /* synthetic */ class C9450gj implements zzczc {

    /* renamed from: a */
    static final zzczc f22379a = new C9450gj();

    private C9450gj() {
    }

    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        String str = "error_code";
        if (jSONObject.optInt(str) == 6) {
            return (InputStream) zzalo.f24412c.mo28114a(jSONObject.getJSONObject("response"));
        }
        throw new zzcif(jSONObject.getString("error_reason"), jSONObject.optInt(str, 0));
    }
}
