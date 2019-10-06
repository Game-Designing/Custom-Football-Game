package com.facebook.p127a.p130b;

import android.os.Build;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.C6787r;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.C6545b;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6709b;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.facebook.a.b.g */
/* compiled from: ActivityLifecycleTracker */
class C6601g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f11984a;

    C6601g(String str) {
        this.f11984a = str;
    }

    public void run() {
        boolean z = true;
        GraphRequest request = GraphRequest.m12875a((AccessToken) null, String.format(Locale.US, "%s/app_indexing_session", new Object[]{this.f11984a}), (JSONObject) null, (C6545b) null);
        Bundle requestParameters = request.mo19688i();
        if (requestParameters == null) {
            requestParameters = new Bundle();
        }
        C6709b identifiers = C6709b.m13508a(C6787r.m13815e());
        JSONArray extInfoArray = new JSONArray();
        String str = Build.MODEL;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        extInfoArray.put(str);
        if (identifiers == null || identifiers.mo19950a() == null) {
            extInfoArray.put(str2);
        } else {
            extInfoArray.put(identifiers.mo19950a());
        }
        String str3 = BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
        extInfoArray.put(str3);
        if (C6603i.m13112d()) {
            str3 = "1";
        }
        extInfoArray.put(str3);
        Locale locale = C6694S.m13412a();
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage());
        sb.append("_");
        sb.append(locale.getCountry());
        extInfoArray.put(sb.toString());
        String extInfo = extInfoArray.toString();
        requestParameters.putString("device_session_id", C6602h.m13101m());
        requestParameters.putString("extinfo", extInfo);
        request.mo19675a(requestParameters);
        if (request != null) {
            JSONObject jsonRes = request.mo19680b().mo20228b();
            if (jsonRes == null || !jsonRes.optBoolean("is_app_indexing_enabled", false)) {
                z = false;
            }
            C6602h.f11999o = Boolean.valueOf(z);
            if (!C6602h.f11999o.booleanValue()) {
                C6602h.f11998n = null;
            } else {
                C6602h.f11997m.mo19771b();
            }
        }
        C6602h.f12000p = Boolean.valueOf(false);
    }
}
