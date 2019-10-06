package com.facebook.p127a.p128a;

import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.C6537C;
import com.facebook.C6787r;
import com.facebook.C6817z;
import com.facebook.GraphRequest;
import com.facebook.internal.C6676H;
import com.facebook.internal.C6694S;
import com.facebook.p127a.p130b.C6602h;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;

/* renamed from: com.facebook.a.a.j */
/* compiled from: ViewIndexer */
class C6587j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f11963a;

    /* renamed from: b */
    final /* synthetic */ C6589l f11964b;

    C6587j(C6589l this$0, String str) {
        this.f11964b = this$0;
        this.f11963a = str;
    }

    public void run() {
        String str = "is_app_indexing_enabled";
        String currentDigest = C6694S.m13438c(this.f11963a);
        AccessToken accessToken = AccessToken.m12820c();
        if (currentDigest == null || !currentDigest.equals(this.f11964b.f11970f)) {
            GraphRequest request = C6589l.m13062a(this.f11963a, accessToken, C6787r.m13816f(), "app_indexing");
            if (request != null) {
                C6817z res = request.mo19680b();
                try {
                    JSONObject jsonRes = res.mo20228b();
                    if (jsonRes != null) {
                        if ("true".equals(jsonRes.optString(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION))) {
                            C6676H.m13322a(C6537C.APP_EVENTS, C6589l.f11965a, "Successfully send UI component tree to server");
                            this.f11964b.f11970f = currentDigest;
                        }
                        if (jsonRes.has(str)) {
                            C6602h.m13090c(Boolean.valueOf(jsonRes.getBoolean(str)));
                        }
                    } else {
                        String a = C6589l.f11965a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error sending UI component tree to Facebook: ");
                        sb.append(res.mo20227a());
                        Log.e(a, sb.toString());
                    }
                } catch (JSONException e) {
                    Log.e(C6589l.f11965a, "Error decoding server response.", e);
                }
            }
        }
    }
}
