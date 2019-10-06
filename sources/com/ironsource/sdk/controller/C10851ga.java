package com.ironsource.sdk.controller;

import android.app.Application;
import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;
import p019d.p273h.p285d.p288c.p289a.C12974b;
import p019d.p273h.p285d.p288c.p289a.C12974b.C12975a;

/* renamed from: com.ironsource.sdk.controller.ga */
/* compiled from: MOATJSAdapter */
public class C10851ga {

    /* renamed from: a */
    private Application f33102a;

    /* renamed from: com.ironsource.sdk.controller.ga$a */
    /* compiled from: MOATJSAdapter */
    private static class C10852a {

        /* renamed from: a */
        String f33103a;

        /* renamed from: b */
        JSONObject f33104b;

        /* renamed from: c */
        String f33105c;

        /* renamed from: d */
        String f33106d;

        private C10852a() {
        }

        /* synthetic */ C10852a(C10849fa x0) {
            this();
        }
    }

    public C10851ga(Application application) {
        this.f33102a = application;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35429a(String params, C10881a callback, WebView webView) throws Exception {
        C10852a fCall = m35423a(params);
        if ("initWithOptions".equals(fCall.f33103a)) {
            C12974b.m42319a(fCall.f33104b, this.f33102a);
            return;
        }
        if (!"createAdTracker".equals(fCall.f33103a) || webView == null) {
            if ("startTracking".equals(fCall.f33103a)) {
                C12974b.m42318a(m35424a(callback, fCall.f33105c, fCall.f33106d));
                C12974b.m42320b();
                return;
            }
            if ("stopTracking".equals(fCall.f33103a)) {
                C12974b.m42318a(m35424a(callback, fCall.f33105c, fCall.f33106d));
                C12974b.m42321c();
                return;
            }
            return;
        }
        C12974b.m42317a(webView);
    }

    /* renamed from: a */
    private C12975a m35424a(C10881a callback, String success, String fail) {
        return new C10849fa(this, callback, success, fail);
    }

    /* renamed from: a */
    private C10852a m35423a(String params) throws JSONException {
        JSONObject functionData = new JSONObject(params);
        C10852a res = new C10852a(null);
        res.f33103a = functionData.optString("moatFunction");
        res.f33104b = functionData.optJSONObject("moatParams");
        res.f33105c = functionData.optString(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION);
        res.f33106d = functionData.optString("fail");
        return res;
    }
}
