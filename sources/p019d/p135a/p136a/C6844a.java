package p019d.p135a.p136a;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.Base64;
import android.util.Log;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p135a.p136a.p142e.C6912j;

/* renamed from: d.a.a.a */
/* compiled from: DeviceTokenGenerator */
final class C6844a {

    /* renamed from: a */
    private static final String f12559a = C6844a.class.getSimpleName();

    private C6844a() {
    }

    /* renamed from: a */
    static String m13919a(Context context, C6924p paymentStateHandler) {
        JSONObject deviceInfo = new JSONObject();
        try {
            String androidId = Secure.getString(context.getContentResolver(), "android_id");
            deviceInfo.put("deviceFingerprintVersion", "1.0");
            deviceInfo.put("platform", "android");
            deviceInfo.put("apiVersion", "4");
            deviceInfo.put("osVersion", VERSION.SDK_INT);
            deviceInfo.put("sdkVersion", "1.10.0");
            deviceInfo.put("deviceIdentifier", androidId);
            deviceInfo.put("locale", C6912j.m14059a(context));
            return Base64.encodeToString(deviceInfo.toString().getBytes(Charset.forName("UTF-8")), 2);
        } catch (JSONException jsonException) {
            Log.e(f12559a, "Token could not be created", jsonException);
            paymentStateHandler.mo22387b((Throwable) jsonException);
            return "";
        }
    }
}
