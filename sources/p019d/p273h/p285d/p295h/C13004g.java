package p019d.p273h.p285d.p295h;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import com.ironsource.sdk.data.C10895h;
import com.ironsource.sdk.data.C10897j;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;
import p019d.p273h.p274a.C12725c;

/* renamed from: d.h.d.h.g */
/* compiled from: SDKUtils */
public class C13004g {

    /* renamed from: a */
    private static final String f39968a = C13004g.class.getSimpleName();

    /* renamed from: b */
    private static String f39969b;

    /* renamed from: c */
    private static boolean f39970c = true;

    /* renamed from: d */
    private static String f39971d;

    /* renamed from: e */
    private static int f39972e = 0;

    /* renamed from: f */
    private static String f39973f;

    /* renamed from: g */
    private static Map<String, String> f39974g;

    /* renamed from: h */
    private static String f39975h = "";

    /* renamed from: i */
    private static final AtomicInteger f39976i = new AtomicInteger(1);

    /* renamed from: b */
    public static String m42452b(String url) {
        String[] assetSplit = url.split(File.separator);
        try {
            return URLEncoder.encode(assetSplit[assetSplit.length - 1].split("\\?")[0], "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static int m42440a(long dp) {
        return (int) ((((float) dp) * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: c */
    public static String m42456c(int orientation) {
        String result = "none";
        if (orientation != 0) {
            if (orientation != 1) {
                if (orientation != 11) {
                    if (orientation != 12) {
                        switch (orientation) {
                            case 6:
                            case 8:
                                break;
                            case 7:
                            case 9:
                                break;
                            default:
                                return result;
                        }
                    }
                }
            }
            return "portrait";
        }
        return "landscape";
    }

    /* renamed from: b */
    public static String m42451b(int orientation) {
        String strOrientation = "none";
        if (orientation == 1) {
            return "portrait";
        }
        if (orientation != 2) {
            return strOrientation;
        }
        return "landscape";
    }

    /* renamed from: a */
    public static JSONObject m42447a(Context context) {
        JSONObject obj = new JSONObject();
        try {
            obj.put(AdUnitActivity.EXTRA_ORIENTATION, m42451b(C12725c.m41095e(context)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /* renamed from: a */
    public static String m42444a(String action, String stage) {
        return String.format("%s Failure occurred during initiation at: %s", new Object[]{action, stage});
    }

    /* renamed from: f */
    public static Long m42462f() {
        return Long.valueOf(System.currentTimeMillis());
    }

    /* renamed from: a */
    public static String m42443a(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    /* renamed from: c */
    public static String m42457c(String input) {
        try {
            String hashtext = new BigInteger(1, MessageDigest.getInstance("MD5").digest(input.getBytes())).toString(16);
            while (hashtext.length() < 32) {
                StringBuilder sb = new StringBuilder();
                sb.append(BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
                sb.append(hashtext);
                hashtext = sb.toString();
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    public static void m42454b(Context context) {
        String str;
        StringBuilder sb;
        String str2 = ": ";
        Exception exception = null;
        try {
            String[] deviceInfo = C12725c.m41090b(context);
            f39969b = deviceInfo[0];
            f39970c = Boolean.valueOf(deviceInfo[1]).booleanValue();
            if (exception != null) {
                if (exception.getMessage() != null) {
                    String str3 = f39968a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(exception.getClass().getSimpleName());
                    sb2.append(str2);
                    sb2.append(exception.getMessage());
                    C13003f.m42438c(str3, sb2.toString());
                }
                if (exception.getCause() != null) {
                    str = f39968a;
                    sb = new StringBuilder();
                    sb.append(exception.getClass().getSimpleName());
                    sb.append(str2);
                    sb.append(exception.getCause());
                    C13003f.m42438c(str, sb.toString());
                }
            }
        } catch (Exception e) {
            exception = e;
            if (exception.getMessage() != null) {
                String str4 = f39968a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(exception.getClass().getSimpleName());
                sb3.append(str2);
                sb3.append(exception.getMessage());
                C13003f.m42438c(str4, sb3.toString());
            }
            if (exception.getCause() != null) {
                str = f39968a;
                sb = new StringBuilder();
            }
        } catch (Throwable th) {
            if (exception != null) {
                if (exception.getMessage() != null) {
                    String str5 = f39968a;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(exception.getClass().getSimpleName());
                    sb4.append(str2);
                    sb4.append(exception.getMessage());
                    C13003f.m42438c(str5, sb4.toString());
                }
                if (exception.getCause() != null) {
                    String str6 = f39968a;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(exception.getClass().getSimpleName());
                    sb5.append(str2);
                    sb5.append(exception.getCause());
                    C13003f.m42438c(str6, sb5.toString());
                }
            }
            throw th;
        }
    }

    /* renamed from: b */
    public static String m42450b() {
        return f39969b;
    }

    /* renamed from: l */
    public static boolean m42469l() {
        return f39970c;
    }

    /* renamed from: e */
    public static String m42460e() {
        if (!TextUtils.isEmpty(f39971d)) {
            return f39971d;
        }
        return "";
    }

    /* renamed from: i */
    public static String m42466i() {
        return "5.61";
    }

    /* renamed from: f */
    public static void m42463f(String url) {
        f39971d = url;
    }

    /* renamed from: c */
    public static String m42455c() {
        return f39973f;
    }

    /* renamed from: e */
    public static void m42461e(String config) {
        f39973f = config;
    }

    /* renamed from: h */
    public static Map<String, String> m42465h() {
        return f39974g;
    }

    /* renamed from: g */
    public static int m42464g() {
        return f39972e;
    }

    /* renamed from: a */
    public static void m42449a(int debugMode) {
        f39972e = debugMode;
    }

    /* renamed from: b */
    public static String m42453b(String json, String key) {
        try {
            return new JSONObject(json).getString(key);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: k */
    public static boolean m42468k() {
        String state = Environment.getExternalStorageState();
        return "mounted".equals(state) || "mounted_ro".equals(state);
    }

    /* renamed from: a */
    public static int m42441a(boolean isImmersive) {
        int uiFlags = 0;
        if (VERSION.SDK_INT >= 14) {
            uiFlags = 2;
        }
        if (VERSION.SDK_INT >= 16) {
            uiFlags |= 1796;
        }
        if (VERSION.SDK_INT < 19 || !isImmersive) {
            return uiFlags;
        }
        return uiFlags | Opcodes.ACC_SYNTHETIC;
    }

    /* renamed from: m */
    private static int m42470m() {
        int result;
        int newValue;
        do {
            result = f39976i.get();
            newValue = result + 1;
            if (newValue > 16777215) {
                newValue = 1;
            }
        } while (!f39976i.compareAndSet(result, newValue));
        return result;
    }

    /* renamed from: a */
    public static int m42439a() {
        if (VERSION.SDK_INT < 17) {
            return m42470m();
        }
        return View.generateViewId();
    }

    /* renamed from: d */
    public static JSONObject m42459d() {
        try {
            return new JSONObject(m42455c());
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    /* renamed from: d */
    public static C10895h m42458d(String product) {
        if (product.equalsIgnoreCase(C10895h.RewardedVideo.toString())) {
            return C10895h.RewardedVideo;
        }
        if (product.equalsIgnoreCase(C10895h.Interstitial.toString())) {
            return C10895h.Interstitial;
        }
        if (product.equalsIgnoreCase(C10895h.OfferWall.toString())) {
            return C10895h.OfferWall;
        }
        return null;
    }

    /* renamed from: j */
    public static String m42467j() {
        return f39975h;
    }

    /* renamed from: a */
    public static JSONObject m42448a(JSONObject obj1, JSONObject obj2) throws Exception {
        JSONObject merged = new JSONObject();
        JSONArray names = new JSONArray();
        if (obj1 != null) {
            merged = new JSONObject(obj1.toString());
        }
        if (obj2 != null) {
            names = obj2.names();
        }
        for (int i = 0; i < names.length(); i++) {
            String key = names.getString(i);
            merged.putOpt(key, obj2.opt(key));
        }
        return merged;
    }

    /* renamed from: a */
    public static String m42445a(Map<String, String> params) {
        JSONObject jsObj = new JSONObject();
        if (params != null) {
            Iterator<Entry<String, String>> it = params.entrySet().iterator();
            while (it.hasNext()) {
                Entry<String, String> pairs = (Entry) it.next();
                try {
                    jsObj.putOpt((String) pairs.getKey(), m42443a((String) pairs.getValue()));
                } catch (JSONException e) {
                    String str = f39968a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("flatMapToJsonAsStringfailed ");
                    sb.append(e.toString());
                    C13003f.m42438c(str, sb.toString());
                }
                it.remove();
            }
        }
        return jsObj.toString();
    }

    /* renamed from: a */
    public static String m42442a(C10897j ssaObj) {
        return m42446a(ssaObj.mo35667a());
    }

    /* renamed from: a */
    public static String m42446a(JSONObject ssaObj) {
        String demandSourceId = ssaObj.optString("demandSourceId");
        return !TextUtils.isEmpty(demandSourceId) ? demandSourceId : ssaObj.optString("demandSourceName");
    }
}
