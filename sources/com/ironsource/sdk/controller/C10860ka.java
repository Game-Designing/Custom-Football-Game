package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.sdk.data.C10897j;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;
import p019d.p273h.p274a.C12723a;
import p019d.p273h.p285d.p295h.C13003f;

/* renamed from: com.ironsource.sdk.controller.ka */
/* compiled from: PermissionsJSAdapter */
public class C10860ka {

    /* renamed from: a */
    private static final String f33116a = C10860ka.class.getSimpleName();

    /* renamed from: b */
    private Context f33117b;

    /* renamed from: com.ironsource.sdk.controller.ka$a */
    /* compiled from: PermissionsJSAdapter */
    private static class C10861a {

        /* renamed from: a */
        String f33118a;

        /* renamed from: b */
        JSONObject f33119b;

        /* renamed from: c */
        String f33120c;

        /* renamed from: d */
        String f33121d;

        private C10861a() {
        }
    }

    public C10860ka(Context context) {
        this.f33117b = context;
    }

    /* renamed from: a */
    private C10861a m35439a(String params) throws JSONException {
        JSONObject functionData = new JSONObject(params);
        C10861a res = new C10861a();
        res.f33118a = functionData.optString("functionName");
        res.f33119b = functionData.optJSONObject("functionParams");
        res.f33120c = functionData.optString(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION);
        res.f33121d = functionData.optString("fail");
        return res;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35440a(String params, C10881a callback) throws Exception {
        C10861a fCall = m35439a(params);
        if ("getPermissions".equals(fCall.f33118a)) {
            mo35441a(fCall.f33119b, fCall, callback);
            return;
        }
        if ("isPermissionGranted".equals(fCall.f33118a)) {
            mo35442b(fCall.f33119b, fCall, callback);
            return;
        }
        String str = f33116a;
        StringBuilder sb = new StringBuilder();
        sb.append("PermissionsJSAdapter unhandled API request ");
        sb.append(params);
        C13003f.m42438c(str, sb.toString());
    }

    /* renamed from: b */
    public void mo35442b(JSONObject value, C10861a fCall, C10881a callback) {
        String str = "permission";
        C10897j permissionAndStatus = new C10897j();
        try {
            String permissionName = value.getString(str);
            permissionAndStatus.mo35668a(str, permissionName);
            String str2 = "status";
            if (C12723a.m41069c(this.f33117b, permissionName)) {
                permissionAndStatus.mo35668a(str2, String.valueOf(C12723a.m41067b(this.f33117b, permissionName)));
                callback.mo35605a(true, fCall.f33120c, permissionAndStatus);
                return;
            }
            permissionAndStatus.mo35668a(str2, "unhandledPermission");
            callback.mo35605a(false, fCall.f33121d, permissionAndStatus);
        } catch (Exception e) {
            e.printStackTrace();
            permissionAndStatus.mo35668a("errMsg", e.getMessage());
            callback.mo35605a(false, fCall.f33121d, permissionAndStatus);
        }
    }

    /* renamed from: a */
    public void mo35441a(JSONObject value, C10861a fCall, C10881a callback) {
        String str = "permissions";
        C10897j permissions = new C10897j();
        try {
            permissions.mo35669a(str, C12723a.m41065a(this.f33117b, value.getJSONArray(str)));
            callback.mo35605a(true, fCall.f33120c, permissions);
        } catch (Exception e) {
            e.printStackTrace();
            String str2 = f33116a;
            StringBuilder sb = new StringBuilder();
            sb.append("PermissionsJSAdapter getPermissions JSON Exception when getting permissions parameter ");
            sb.append(e.getMessage());
            C13003f.m42438c(str2, sb.toString());
            permissions.mo35668a("errMsg", e.getMessage());
            callback.mo35605a(false, fCall.f33121d, permissions);
        }
    }
}
