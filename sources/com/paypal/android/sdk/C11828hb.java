package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.paypal.android.sdk.hb */
public class C11828hb {

    /* renamed from: a */
    private static Map f37229a;

    static {
        C11828hb.class.getSimpleName();
    }

    /* renamed from: a */
    private static String m39166a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 128).versionName;
        } catch (NameNotFoundException e) {
            return "unknown versionName";
        }
    }

    /* renamed from: a */
    public static JSONObject m39167a() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : f37229a.keySet()) {
                jSONObject.put(str, f37229a.get(str));
            }
            return jSONObject;
        } catch (JSONException e) {
            Log.e("paypal.sdk", "Error encoding JSON", e);
            return null;
        }
    }

    /* renamed from: a */
    public static void m39168a(C11788a aVar) {
        Map map;
        String str;
        if (f37229a == null) {
            HashMap hashMap = new HashMap();
            f37229a = hashMap;
            hashMap.put("app_version", m39166a(aVar.mo38698f()));
            f37229a.put("app_category", "1");
            String str2 = "client_platform";
            if (aVar.mo38692b() == 1) {
                map = f37229a;
                str = "AndroidGSM";
            } else if (aVar.mo38692b() == 2) {
                map = f37229a;
                str = "AndroidCDMA";
            } else {
                map = f37229a;
                str = "AndroidOther";
            }
            map.put(str2, str);
            f37229a.put("device_app_id", aVar.mo38694c());
        }
    }
}
