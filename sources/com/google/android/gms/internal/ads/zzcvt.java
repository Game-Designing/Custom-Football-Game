package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzcvt implements zzcuz<JSONObject> {

    /* renamed from: a */
    private final String f27472a;

    public zzcvt(String str) {
        this.f27472a = str;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        try {
            ((JSONObject) obj).put("ms", this.f27472a);
        } catch (JSONException e) {
            zzawz.m26002e("Failed putting Ad ID.", e);
        }
    }
}
