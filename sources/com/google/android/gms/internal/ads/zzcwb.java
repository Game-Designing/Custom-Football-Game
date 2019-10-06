package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzcwb implements zzcuz<JSONObject> {

    /* renamed from: a */
    private JSONObject f27486a;

    public zzcwb(JSONObject jSONObject) {
        this.f27486a = jSONObject;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        try {
            ((JSONObject) obj).put("cache_state", this.f27486a);
        } catch (JSONException e) {
            zzawz.m26003f("Unable to get cache_state");
        }
    }
}
