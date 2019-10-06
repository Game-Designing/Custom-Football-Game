package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.bm */
final class C9343bm implements zzcva<zzcuz<JSONObject>> {

    /* renamed from: a */
    private final JSONObject f22128a;

    C9343bm(Context context) {
        this.f22128a = zzasj.m25733a(context);
    }

    /* renamed from: a */
    public final zzbbh<zzcuz<JSONObject>> mo28586a() {
        return zzbar.m26376a(new C9365cm(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo28874a(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.f22128a);
        } catch (JSONException e) {
            zzawz.m26003f("Failed putting version constants.");
        }
    }
}
