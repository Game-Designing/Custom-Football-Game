package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.facebook.p127a.p130b.C6608m;
import com.facebook.p127a.p130b.C6615s;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.A */
/* compiled from: FetchedAppSettingsManager */
class C6667A implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f12161a;

    /* renamed from: b */
    final /* synthetic */ String f12162b;

    /* renamed from: c */
    final /* synthetic */ String f12163c;

    C6667A(Context context, String str, String str2) {
        this.f12161a = context;
        this.f12162b = str;
        this.f12163c = str2;
    }

    public void run() {
        SharedPreferences sharedPrefs = this.f12161a.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
        String settingsJSONString = sharedPrefs.getString(this.f12162b, null);
        C6738z appSettings = null;
        if (!C6694S.m13436b(settingsJSONString)) {
            JSONObject settingsJSON = null;
            try {
                settingsJSON = new JSONObject(settingsJSONString);
            } catch (JSONException je) {
                C6694S.m13422a("FacebookSDK", (Exception) je);
            }
            if (settingsJSON != null) {
                appSettings = C6670D.m13307b(this.f12163c, settingsJSON);
            }
        }
        JSONObject resultJSON = C6670D.m13310c(this.f12163c);
        if (resultJSON != null) {
            C6670D.m13307b(this.f12163c, resultJSON);
            sharedPrefs.edit().putString(this.f12162b, resultJSON.toString()).apply();
        }
        if (appSettings != null) {
            String updateMessage = appSettings.mo19979g();
            if (!C6670D.f12172f && updateMessage != null && updateMessage.length() > 0) {
                C6670D.f12172f = true;
                Log.w(C6670D.f12167a, updateMessage);
            }
        }
        C6737y.m13571a(this.f12163c, true);
        C6608m.m13120b();
        C6615s.m13129c();
        C6670D.f12170d.set(C6670D.f12169c.containsKey(this.f12163c) ? C6671a.SUCCESS : C6671a.ERROR);
        C6670D.m13314g();
    }
}
