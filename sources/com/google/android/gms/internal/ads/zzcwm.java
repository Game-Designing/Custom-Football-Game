package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcwm implements zzcuz<JSONObject> {

    /* renamed from: a */
    private List<String> f27502a;

    public zzcwm(List<String> list) {
        this.f27502a = list;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        try {
            ((JSONObject) obj).put("eid", TextUtils.join(",", this.f27502a));
        } catch (JSONException e) {
            zzawz.m26003f("Failed putting experiment ids.");
        }
    }
}
