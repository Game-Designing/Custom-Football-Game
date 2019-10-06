package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcvx implements zzcuz<JSONObject> {

    /* renamed from: a */
    private final JSONObject f27477a;

    public zzcvx(JSONObject jSONObject) {
        this.f27477a = jSONObject;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        try {
            JSONObject a = zzazc.m26265a((JSONObject) obj, "content_info");
            JSONObject jSONObject = this.f27477a;
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                a.put(str, jSONObject.get(str));
            }
        } catch (JSONException e) {
            zzawz.m26003f("Failed putting app indexing json.");
        }
    }
}
