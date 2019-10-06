package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.unity3d.ads.metadata.MediationMetaData;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.w */
/* compiled from: FacebookWebFallbackDialog */
public class C6735w extends C6702Y {

    /* renamed from: o */
    private static final String f12308o = C6735w.class.getName();

    /* renamed from: p */
    private boolean f12309p;

    /* renamed from: a */
    public static C6735w m13565a(Context context, String url, String expectedRedirectUrl) {
        C6702Y.m13476a(context);
        return new C6735w(context, url, expectedRedirectUrl);
    }

    private C6735w(Context context, String url, String expectedRedirectUrl) {
        super(context, url);
        mo19920b(expectedRedirectUrl);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Bundle mo19915a(String url) {
        Bundle queryParams = C6694S.m13443d(Uri.parse(url).getQuery());
        String str = "bridge_args";
        String bridgeArgsJSONString = queryParams.getString(str);
        queryParams.remove(str);
        String str2 = "Unable to parse bridge_args JSON";
        if (!C6694S.m13436b(bridgeArgsJSONString)) {
            try {
                queryParams.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", C6720k.m13539a(new JSONObject(bridgeArgsJSONString)));
            } catch (JSONException je) {
                C6694S.m13423a(f12308o, str2, (Throwable) je);
            }
        }
        String str3 = "method_results";
        String methodResultsJSONString = queryParams.getString(str3);
        queryParams.remove(str3);
        if (!C6694S.m13436b(methodResultsJSONString)) {
            try {
                queryParams.putBundle("com.facebook.platform.protocol.RESULT_ARGS", C6720k.m13539a(new JSONObject(C6694S.m13436b(methodResultsJSONString) ? "{}" : methodResultsJSONString)));
            } catch (JSONException je2) {
                C6694S.m13423a(f12308o, str2, (Throwable) je2);
            }
        }
        queryParams.remove(MediationMetaData.KEY_VERSION);
        queryParams.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", C6678J.m13352c());
        return queryParams;
    }

    public void cancel() {
        WebView webView = mo19919b();
        if (!mo19923d() || mo19921c() || webView == null || !webView.isShown()) {
            super.cancel();
        } else if (!this.f12309p) {
            this.f12309p = true;
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:");
            sb.append("(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();");
            webView.loadUrl(sb.toString());
            new Handler(Looper.getMainLooper()).postDelayed(new C6734v(this), 1500);
        }
    }
}
