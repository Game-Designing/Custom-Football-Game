package com.ironsource.sdk.controller;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.sdk.controller.a */
/* compiled from: BannerJSAdapter */
class C10837a extends JSONObject {

    /* renamed from: a */
    final /* synthetic */ String f33072a;

    /* renamed from: b */
    final /* synthetic */ C10839b f33073b;

    C10837a(C10839b this$0, String str) throws RuntimeException, Error {
        this.f33073b = this$0;
        this.f33072a = str;
        try {
            put("errMsg", this.f33072a);
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
    }
}
