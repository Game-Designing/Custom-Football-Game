package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzbal;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbbh;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.ads.internal.a */
final /* synthetic */ class C8582a implements zzbal {

    /* renamed from: a */
    static final zzbal f19077a = new C8582a();

    private C8582a() {
    }

    /* renamed from: a */
    public final zzbbh mo26658a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            zzk.zzlk().mo30177i().mo30203a(jSONObject.getString("appSettingsJson"));
        }
        return zzbar.m26376a(null);
    }
}
