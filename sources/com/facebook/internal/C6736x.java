package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.x */
/* compiled from: FetchedAppGateKeepersManager */
class C6736x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f12310a;

    /* renamed from: b */
    final /* synthetic */ String f12311b;

    /* renamed from: c */
    final /* synthetic */ String f12312c;

    C6736x(Context context, String str, String str2) {
        this.f12310a = context;
        this.f12311b = str;
        this.f12312c = str2;
    }

    public void run() {
        SharedPreferences gateKeepersSharedPrefs = this.f12310a.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0);
        String gateKeepersJSONString = gateKeepersSharedPrefs.getString(this.f12311b, null);
        if (!C6694S.m13436b(gateKeepersJSONString)) {
            JSONObject gateKeepersJSON = null;
            try {
                gateKeepersJSON = new JSONObject(gateKeepersJSONString);
            } catch (JSONException je) {
                C6694S.m13422a("FacebookSDK", (Exception) je);
            }
            if (gateKeepersJSON != null) {
                C6737y.m13575b(this.f12312c, gateKeepersJSON);
            }
        }
        JSONObject gateKeepersResultJSON = C6737y.m13574b(this.f12312c);
        if (gateKeepersResultJSON != null) {
            C6737y.f12315c = Long.valueOf(System.currentTimeMillis());
            C6737y.m13575b(this.f12312c, gateKeepersResultJSON);
            gateKeepersSharedPrefs.edit().putString(this.f12311b, gateKeepersResultJSON.toString()).apply();
        }
    }
}
