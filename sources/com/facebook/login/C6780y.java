package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.login.LoginClient.Request;
import com.facebook.p127a.C6647y;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.login.y */
/* compiled from: LoginLogger */
class C6780y {

    /* renamed from: a */
    private final C6647y f12459a;

    /* renamed from: b */
    private String f12460b;

    /* renamed from: c */
    private String f12461c;

    C6780y(Context context, String applicationId) {
        this.f12460b = applicationId;
        this.f12459a = new C6647y(context, applicationId);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                PackageInfo facebookInfo = packageManager.getPackageInfo("com.facebook.katana", 0);
                if (facebookInfo != null) {
                    this.f12461c = facebookInfo.versionName;
                }
            }
        } catch (NameNotFoundException e) {
        }
    }

    /* renamed from: a */
    public String mo20127a() {
        return this.f12460b;
    }

    /* renamed from: a */
    static Bundle m13793a(String authLoggerId) {
        Bundle bundle = new Bundle();
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString("0_auth_logger_id", authLoggerId);
        String str = "";
        bundle.putString("3_method", str);
        bundle.putString("2_result", str);
        bundle.putString("5_error_message", str);
        bundle.putString("4_error_code", str);
        bundle.putString("6_extras", str);
        return bundle;
    }

    /* renamed from: a */
    public void mo20128a(Request pendingLoginRequest) {
        Bundle bundle = m13793a(pendingLoginRequest.mo20064b());
        try {
            JSONObject extras = new JSONObject();
            extras.put("login_behavior", pendingLoginRequest.mo20070g().toString());
            extras.put("request_code", LoginClient.m13688h());
            extras.put("permissions", TextUtils.join(",", pendingLoginRequest.mo20071h()));
            extras.put("default_audience", pendingLoginRequest.mo20066d().toString());
            extras.put("isReauthorize", pendingLoginRequest.mo20073j());
            if (this.f12461c != null) {
                extras.put("facebookVersion", this.f12461c);
            }
            bundle.putString("6_extras", extras.toString());
        } catch (JSONException e) {
        }
        this.f12459a.mo19853a("fb_mobile_login_start", (Double) null, bundle);
    }

    /* renamed from: a */
    public void mo20132a(String loginRequestId, Map<String, String> loggingExtras, C6752a result, Map<String, String> resultExtras, Exception exception) {
        Bundle bundle = m13793a(loginRequestId);
        if (result != null) {
            bundle.putString("2_result", result.mo20077e());
        }
        if (!(exception == null || exception.getMessage() == null)) {
            bundle.putString("5_error_message", exception.getMessage());
        }
        JSONObject jsonObject = null;
        if (!loggingExtras.isEmpty()) {
            jsonObject = new JSONObject(loggingExtras);
        }
        if (resultExtras != null) {
            if (jsonObject == null) {
                jsonObject = new JSONObject();
            }
            try {
                for (Entry<String, String> entry : resultExtras.entrySet()) {
                    jsonObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
            }
        }
        if (jsonObject != null) {
            bundle.putString("6_extras", jsonObject.toString());
        }
        this.f12459a.mo19856b("fb_mobile_login_complete", bundle);
    }

    /* renamed from: b */
    public void mo20133b(String authId, String method) {
        Bundle bundle = m13793a(authId);
        bundle.putString("3_method", method);
        this.f12459a.mo19856b("fb_mobile_login_method_start", bundle);
    }

    /* renamed from: a */
    public void mo20131a(String authId, String method, String result, String errorMessage, String errorCode, Map<String, String> loggingExtras) {
        Bundle bundle = m13793a(authId);
        if (result != null) {
            bundle.putString("2_result", result);
        }
        if (errorMessage != null) {
            bundle.putString("5_error_message", errorMessage);
        }
        if (errorCode != null) {
            bundle.putString("4_error_code", errorCode);
        }
        if (loggingExtras != null && !loggingExtras.isEmpty()) {
            bundle.putString("6_extras", new JSONObject(loggingExtras).toString());
        }
        bundle.putString("3_method", method);
        this.f12459a.mo19856b("fb_mobile_login_method_complete", bundle);
    }

    /* renamed from: a */
    public void mo20129a(String authId, String method) {
        Bundle bundle = m13793a(authId);
        bundle.putString("3_method", method);
        this.f12459a.mo19856b("fb_mobile_login_method_not_tried", bundle);
    }

    /* renamed from: c */
    public void mo20134c(String eventName, String errorMessage) {
        mo20130a(eventName, errorMessage, "");
    }

    /* renamed from: a */
    public void mo20130a(String eventName, String errorMessage, String method) {
        Bundle bundle = m13793a("");
        bundle.putString("2_result", C6752a.ERROR.mo20077e());
        bundle.putString("5_error_message", errorMessage);
        bundle.putString("3_method", method);
        this.f12459a.mo19856b(eventName, bundle);
    }
}
