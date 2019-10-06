package com.paypal.android.sdk;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.paypal.android.sdk.lb */
public class C11844lb {

    /* renamed from: a */
    private static final HashMap f37272a = new C11848mb();

    /* renamed from: b */
    private static Map f37273b;

    static {
        C11844lb.class.getSimpleName();
    }

    /* renamed from: a */
    public static JSONObject m39198a() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : f37273b.keySet()) {
                jSONObject.put(str, f37273b.get(str));
            }
            return jSONObject;
        } catch (JSONException e) {
            Log.e("paypal.sdk", "Error encoding JSON", e);
            return null;
        }
    }

    /* renamed from: a */
    public static void m39199a(C11788a aVar) {
        if (f37273b == null) {
            HashMap hashMap = new HashMap();
            f37273b = hashMap;
            hashMap.put("device_identifier", C11723Fa.m38812a(aVar.mo38697e()));
            String str = "Android";
            f37273b.put("device_type", str);
            f37273b.put("device_name", C11723Fa.m38812a(Build.DEVICE));
            f37273b.put("device_model", C11723Fa.m38812a(Build.MODEL));
            Map map = f37273b;
            String str2 = (String) f37272a.get(Integer.valueOf(aVar.mo38692b()));
            if (TextUtils.isEmpty(str2)) {
                str2 = "ANDROIDGSM_UNDEFINED";
            }
            map.put("device_key_type", str2);
            f37273b.put("device_os", str);
            f37273b.put("device_os_version", C11723Fa.m38812a(VERSION.RELEASE));
            f37273b.put("is_device_simulator", Boolean.toString(Build.PRODUCT.equals("sdk") || Build.PRODUCT.equals("google_sdk") || Build.FINGERPRINT.contains("generic")));
        }
    }
}
