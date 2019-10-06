package com.google.android.gms.internal.ads;

import org.json.JSONObject;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;

/* renamed from: com.google.android.gms.internal.ads._j */
final /* synthetic */ class C9297_j implements zzbal {

    /* renamed from: a */
    static final zzbal f22049a = new C9297_j();

    private C9297_j() {
    }

    /* renamed from: a */
    public final zzbbh mo26658a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION)) {
            return zzbar.m26376a(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzali("process json failed");
    }
}
