package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.C6787r;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.C6545b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;
import p005cm.aptoide.p006pt.database.realm.Notification;

/* renamed from: com.facebook.internal.y */
/* compiled from: FetchedAppGateKeepersManager */
public class C6737y {

    /* renamed from: a */
    private static final String f12313a = C6737y.class.getCanonicalName();

    /* renamed from: b */
    private static final Map<String, JSONObject> f12314b = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static Long f12315c = null;

    /* renamed from: a */
    public static synchronized void m13572a() {
        synchronized (C6737y.class) {
            if (!m13576b(f12315c)) {
                Context context = C6787r.m13815e();
                String applicationId = C6787r.m13816f();
                C6787r.m13822l().execute(new C6736x(context, String.format("com.facebook.internal.APP_GATEKEEPERS.%s", new Object[]{applicationId}), applicationId));
            }
        }
    }

    /* renamed from: a */
    public static JSONObject m13571a(String applicationId, boolean forceRequery) {
        if (!forceRequery && f12314b.containsKey(applicationId)) {
            return (JSONObject) f12314b.get(applicationId);
        }
        JSONObject response = m13574b(applicationId);
        if (response == null) {
            return null;
        }
        Context context = C6787r.m13815e();
        context.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(String.format("com.facebook.internal.APP_GATEKEEPERS.%s", new Object[]{applicationId}), response.toString()).apply();
        return m13575b(applicationId, response);
    }

    /* renamed from: a */
    public static boolean m13573a(String name, String applicationId, boolean defaultValue) {
        m13572a();
        if (applicationId == null || !f12314b.containsKey(applicationId)) {
            return defaultValue;
        }
        return ((JSONObject) f12314b.get(applicationId)).optBoolean(name, defaultValue);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static JSONObject m13574b(String applicationId) {
        Bundle appGateKeepersParams = new Bundle();
        appGateKeepersParams.putString("platform", "android");
        appGateKeepersParams.putString("sdk_version", C6787r.m13826p());
        appGateKeepersParams.putString("fields", "gatekeepers");
        GraphRequest request = GraphRequest.m12874a((AccessToken) null, String.format("%s/%s", new Object[]{applicationId, "mobile_sdk_gk"}), (C6545b) null);
        request.mo19679a(true);
        request.mo19675a(appGateKeepersParams);
        return request.mo19680b().mo20228b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static synchronized JSONObject m13575b(String applicationId, JSONObject gateKeepersJSON) {
        JSONObject result;
        synchronized (C6737y.class) {
            if (f12314b.containsKey(applicationId)) {
                result = (JSONObject) f12314b.get(applicationId);
            } else {
                result = new JSONObject();
            }
            JSONArray arr = gateKeepersJSON.optJSONArray("data");
            JSONObject gateKeepers = null;
            if (arr != null) {
                gateKeepers = arr.optJSONObject(0);
            }
            if (!(gateKeepers == null || gateKeepers.optJSONArray("gatekeepers") == null)) {
                JSONArray data = gateKeepers.optJSONArray("gatekeepers");
                for (int i = 0; i < data.length(); i++) {
                    try {
                        JSONObject gk = data.getJSONObject(i);
                        result.put(gk.getString(Notification.KEY), gk.getBoolean(DonationsAnalytics.VALUE));
                    } catch (JSONException je) {
                        C6694S.m13422a("FacebookSDK", (Exception) je);
                    }
                }
            }
            f12314b.put(applicationId, result);
        }
        return result;
    }

    /* renamed from: b */
    private static boolean m13576b(Long timestamp) {
        boolean z = false;
        if (timestamp == null) {
            return false;
        }
        if (System.currentTimeMillis() - timestamp.longValue() < 3600000) {
            z = true;
        }
        return z;
    }
}
