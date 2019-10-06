package com.ironsource.sdk.controller;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;
import p019d.p273h.p285d.p286a.C12957d;
import p019d.p273h.p285d.p286a.C12959e;
import p019d.p273h.p285d.p295h.C13003f;

/* renamed from: com.ironsource.sdk.controller.b */
/* compiled from: BannerJSAdapter */
public class C10839b implements C12959e {

    /* renamed from: a */
    private static final String f33077a = C10839b.class.getSimpleName();

    /* renamed from: b */
    private C12957d f33078b;

    /* renamed from: c */
    private C10865ma f33079c;

    /* renamed from: a */
    public void mo35409a(C10865ma delegate) {
        this.f33079c = delegate;
    }

    /* renamed from: a */
    public void mo35410a(C12957d adView) {
        this.f33078b = adView;
        this.f33078b.setControllerDelegate(this);
    }

    /* renamed from: a */
    public void mo35413a(String message, JSONObject params) {
        if (this.f33079c != null && !TextUtils.isEmpty(message)) {
            this.f33079c.mo35445a(message, params);
        }
    }

    /* renamed from: a */
    public void mo35412a(String failureMethod, String errorMessage) {
        mo35413a(failureMethod, (JSONObject) new C10837a(this, errorMessage));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35411a(String message) {
        try {
            JSONObject functionData = new JSONObject(message);
            String functionName = functionData.optString("functionName");
            JSONObject functionParams = functionData.optJSONObject("functionParams");
            String successMethod = functionData.optString(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION);
            String failureMethod = functionData.optString("fail");
            if (TextUtils.isEmpty(functionName)) {
                String str = f33077a;
                StringBuilder sb = new StringBuilder();
                sb.append("BannerJSAdapter | sendMessageToISNAdView | Invalid message format: ");
                sb.append(message);
                C13003f.m42438c(str, sb.toString());
            } else if (this.f33078b == null) {
                mo35412a(failureMethod, "Send message to ISNAdView failed");
            } else {
                this.f33078b.mo41797a(functionName, functionParams, successMethod, failureMethod);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
