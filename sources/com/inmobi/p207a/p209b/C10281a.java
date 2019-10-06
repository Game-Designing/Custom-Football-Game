package com.inmobi.p207a.p209b;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.a.b.a */
/* compiled from: WifiInfo */
public class C10281a {

    /* renamed from: e */
    private static final String f31151e = C10281a.class.getSimpleName();

    /* renamed from: a */
    public long f31152a;

    /* renamed from: b */
    String f31153b;

    /* renamed from: c */
    int f31154c;

    /* renamed from: d */
    int f31155d;

    /* renamed from: a */
    public final JSONObject mo33647a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bssid", this.f31152a);
            jSONObject.put("essid", this.f31153b);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
