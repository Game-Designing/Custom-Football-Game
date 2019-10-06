package p019d.p273h.p276c.p284h;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;
import p019d.p273h.p276c.C12791c;
import p019d.p273h.p276c.C12932n;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;

/* renamed from: d.h.c.h.j */
/* compiled from: IronSourceUtils */
public class C12916j {

    /* renamed from: a */
    private static int f39675a = 1;

    /* renamed from: c */
    public static int m41979c() {
        return f39675a;
    }

    /* renamed from: a */
    public static String m41960a(String input) {
        try {
            String hashtext = new BigInteger(1, MessageDigest.getInstance("MD5").digest(input.getBytes())).toString(16);
            while (hashtext.length() < 32) {
                StringBuilder sb = new StringBuilder();
                sb.append(BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
                sb.append(hashtext);
                hashtext = sb.toString();
            }
            return hashtext;
        } catch (Throwable e) {
            if (input == null) {
                C12802d.m41613c().mo41426a(C12801a.NATIVE, "getMD5(input:null)", e);
            } else {
                C12802d c = C12802d.m41613c();
                C12801a aVar = C12801a.NATIVE;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getMD5(input:");
                sb2.append(input);
                sb2.append(")");
                c.mo41426a(aVar, sb2.toString(), e);
            }
            return "";
        }
    }

    /* renamed from: g */
    private static String m41990g(String input) {
        try {
            return String.format("%064x", new Object[]{new BigInteger(1, MessageDigest.getInstance("SHA-256").digest(input.getBytes()))});
        } catch (NoSuchAlgorithmException e) {
            if (input == null) {
                C12802d.m41613c().mo41426a(C12801a.NATIVE, "getSHA256(input:null)", (Throwable) e);
            } else {
                C12802d c = C12802d.m41613c();
                C12801a aVar = C12801a.NATIVE;
                StringBuilder sb = new StringBuilder();
                sb.append("getSHA256(input:");
                sb.append(input);
                sb.append(")");
                c.mo41426a(aVar, sb.toString(), (Throwable) e);
            }
            return "";
        }
    }

    /* renamed from: b */
    public static String m41974b(String strToTransId) {
        return m41990g(strToTransId);
    }

    /* renamed from: a */
    public static int m41955a() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    /* renamed from: a */
    public static String m41958a(Context c) {
        String str = "WIFI";
        String str2 = "MOBILE";
        String str3 = "none";
        String str4 = "wifi";
        String str5 = "cellular";
        String str6 = "none";
        if (c == null) {
            return str6;
        }
        ConnectivityManager cm = (ConnectivityManager) c.getSystemService("connectivity");
        if (cm == null) {
            return str6;
        }
        String str7 = "cellular";
        String str8 = "wifi";
        if (VERSION.SDK_INT >= 23) {
            NetworkCapabilities mNetworkCapabilities = cm.getNetworkCapabilities(cm.getActiveNetwork());
            if (mNetworkCapabilities == null) {
                return str6;
            }
            if (mNetworkCapabilities.hasTransport(1)) {
                return str8;
            }
            if (mNetworkCapabilities.hasTransport(0)) {
                return str7;
            }
            return str6;
        }
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null || !info.isConnected()) {
            return str6;
        }
        if (info.getTypeName().equalsIgnoreCase("WIFI")) {
            return str8;
        }
        if (info.getTypeName().equalsIgnoreCase("MOBILE")) {
            return str7;
        }
        return str6;
    }

    /* renamed from: b */
    public static String m41971b() {
        return "6.8.3";
    }

    /* renamed from: d */
    private static String m41984d(String eventType) {
        if ("IS".equals(eventType)) {
            return "default_is_events_url";
        }
        if ("RV".equals(eventType)) {
            return "default_rv_events_url";
        }
        return "";
    }

    /* renamed from: f */
    private static String m41988f(String eventType) {
        if ("IS".equals(eventType)) {
            return "default_is_opt_out_events";
        }
        if ("RV".equals(eventType)) {
            return "default_rv_opt_out_events";
        }
        return "";
    }

    /* renamed from: e */
    private static String m41986e(String eventType) {
        if ("IS".equals(eventType)) {
            return "default_is_events_formatter_type";
        }
        if ("RV".equals(eventType)) {
            return "default_rv_events_formatter_type";
        }
        return "";
    }

    /* renamed from: e */
    public static synchronized void m41987e(Context context, String eventType, String eventsUrl) {
        synchronized (C12916j.class) {
            try {
                Editor editor = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
                editor.putString(m41984d(eventType), eventsUrl);
                editor.commit();
            } catch (Exception e) {
                C12802d c = C12802d.m41613c();
                C12801a aVar = C12801a.NATIVE;
                StringBuilder sb = new StringBuilder();
                sb.append("IronSourceUtils:saveDefaultEventsURL(eventType: ");
                sb.append(eventType);
                sb.append(", eventsUrl:");
                sb.append(eventsUrl);
                sb.append(")");
                c.mo41426a(aVar, sb.toString(), (Throwable) e);
            }
        }
        return;
    }

    /* renamed from: a */
    public static synchronized void m41967a(Context context, String eventType, int[] optOutEvents) {
        synchronized (C12916j.class) {
            try {
                Editor editor = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
                String optOutEventsString = null;
                if (optOutEvents != null) {
                    StringBuilder str = new StringBuilder();
                    for (int append : optOutEvents) {
                        str.append(append);
                        str.append(",");
                    }
                    optOutEventsString = str.toString();
                }
                editor.putString(m41988f(eventType), optOutEventsString);
                editor.commit();
            } catch (Exception e) {
                C12802d c = C12802d.m41613c();
                C12801a aVar = C12801a.NATIVE;
                StringBuilder sb = new StringBuilder();
                sb.append("IronSourceUtils:saveDefaultOptOutEvents(eventType: ");
                sb.append(eventType);
                sb.append(", optOutEvents:");
                sb.append(optOutEvents);
                sb.append(")");
                c.mo41426a(aVar, sb.toString(), (Throwable) e);
            }
        }
        return;
    }

    /* renamed from: d */
    public static synchronized void m41985d(Context context, String eventType, String formatterType) {
        synchronized (C12916j.class) {
            try {
                Editor editor = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
                editor.putString(m41986e(eventType), formatterType);
                editor.commit();
            } catch (Exception e) {
                C12802d c = C12802d.m41613c();
                C12801a aVar = C12801a.NATIVE;
                StringBuilder sb = new StringBuilder();
                sb.append("IronSourceUtils:saveDefaultEventsFormatterType(eventType: ");
                sb.append(eventType);
                sb.append(", formatterType:");
                sb.append(formatterType);
                sb.append(")");
                c.mo41426a(aVar, sb.toString(), (Throwable) e);
            }
        }
        return;
    }

    /* renamed from: a */
    public static synchronized String m41959a(Context context, String eventType, String defaultFormatterType) {
        String formatterType;
        synchronized (C12916j.class) {
            formatterType = defaultFormatterType;
            try {
                formatterType = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(m41986e(eventType), defaultFormatterType);
            } catch (Exception e) {
                C12802d c = C12802d.m41613c();
                C12801a aVar = C12801a.NATIVE;
                StringBuilder sb = new StringBuilder();
                sb.append("IronSourceUtils:getDefaultEventsFormatterType(eventType: ");
                sb.append(eventType);
                sb.append(", defaultFormatterType:");
                sb.append(defaultFormatterType);
                sb.append(")");
                c.mo41426a(aVar, sb.toString(), (Throwable) e);
            }
        }
        return formatterType;
    }

    /* renamed from: b */
    public static synchronized String m41973b(Context context, String eventType, String defaultEventsURL) {
        String serverUrl;
        synchronized (C12916j.class) {
            serverUrl = defaultEventsURL;
            try {
                serverUrl = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(m41984d(eventType), defaultEventsURL);
            } catch (Exception e) {
                C12802d c = C12802d.m41613c();
                C12801a aVar = C12801a.NATIVE;
                StringBuilder sb = new StringBuilder();
                sb.append("IronSourceUtils:getDefaultEventsURL(eventType: ");
                sb.append(eventType);
                sb.append(", defaultEventsURL:");
                sb.append(defaultEventsURL);
                sb.append(")");
                c.mo41426a(aVar, sb.toString(), (Throwable) e);
            }
        }
        return serverUrl;
    }

    /* renamed from: a */
    public static synchronized int[] m41970a(Context context, String eventType) {
        int[] optOutEvents;
        synchronized (C12916j.class) {
            optOutEvents = null;
            try {
                String optOutEventsString = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(m41988f(eventType), null);
                if (!TextUtils.isEmpty(optOutEventsString)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(optOutEventsString, ",");
                    ArrayList<Integer> result = new ArrayList<>();
                    while (stringTokenizer.hasMoreTokens()) {
                        result.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                    }
                    optOutEvents = new int[result.size()];
                    for (int i = 0; i < optOutEvents.length; i++) {
                        optOutEvents[i] = ((Integer) result.get(i)).intValue();
                    }
                }
            } catch (Exception e) {
                C12802d c = C12802d.m41613c();
                C12801a aVar = C12801a.NATIVE;
                StringBuilder sb = new StringBuilder();
                sb.append("IronSourceUtils:getDefaultOptOutEvents(eventType: ");
                sb.append(eventType);
                sb.append(")");
                c.mo41426a(aVar, sb.toString(), (Throwable) e);
            }
        }
        return optOutEvents;
    }

    /* renamed from: b */
    public static synchronized void m41975b(Context context, String response) {
        synchronized (C12916j.class) {
            Editor editor = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
            editor.putString("last_response", response);
            editor.apply();
        }
    }

    /* renamed from: b */
    public static String m41972b(Context context) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString("last_response", "");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void m41968a(android.content.Context r5, org.json.JSONObject r6) {
        /*
            java.lang.Class<d.h.c.h.j> r0 = p019d.p273h.p276c.p284h.C12916j.class
            monitor-enter(r0)
            if (r5 == 0) goto L_0x0024
            if (r6 != 0) goto L_0x0008
            goto L_0x0024
        L_0x0008:
            java.lang.String r1 = "Mediation_Shared_Preferences"
            r2 = 0
            android.content.SharedPreferences r1 = r5.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x0021 }
            android.content.SharedPreferences$Editor r2 = r1.edit()     // Catch:{ all -> 0x0021 }
            java.lang.String r3 = "general_properties"
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0021 }
            r2.putString(r3, r4)     // Catch:{ all -> 0x0021 }
            r2.apply()     // Catch:{ all -> 0x0021 }
            monitor-exit(r0)
            return
        L_0x0021:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        L_0x0024:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.p284h.C12916j.m41968a(android.content.Context, org.json.JSONObject):void");
    }

    /* renamed from: c */
    public static boolean m41982c(Context context) {
        NetworkInfo activeNetwork = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetwork == null) {
            return false;
        }
        return activeNetwork.isConnected();
    }

    /* renamed from: d */
    public static long m41983d() {
        return System.currentTimeMillis();
    }

    /* renamed from: a */
    public static JSONObject m41962a(C12791c smash, boolean isDemandOnlyMode) {
        JSONObject data = new JSONObject();
        if (isDemandOnlyMode) {
            try {
                data.put("networkInstance", "true");
            } catch (Exception e) {
                C12802d c = C12802d.m41613c();
                C12801a aVar = C12801a.NATIVE;
                StringBuilder sb = new StringBuilder();
                sb.append("IronSourceUtils:getProviderAdditionalData(adapter: ");
                sb.append(smash.mo41403t());
                sb.append(")");
                c.mo41426a(aVar, sb.toString(), (Throwable) e);
            }
        } else {
            data.put("providerPriority", smash.mo41405v());
        }
        data.put("spId", smash.mo41406w());
        data.put("provider", smash.mo41396l());
        data.put("providerSDKVersion", smash.mo41397n().getCoreSDKVersion());
        data.put("providerAdapterVersion", smash.mo41397n().getVersion());
        return data;
    }

    /* renamed from: a */
    public static JSONObject m41963a(C12932n smash) {
        JSONObject data = new JSONObject();
        try {
            data.put("spId", smash.mo41733f());
            data.put("provider", smash.mo41727b());
            data.put("providerSDKVersion", smash.mo41730c().getCoreSDKVersion());
            data.put("providerAdapterVersion", smash.mo41730c().getVersion());
            data.put("providerPriority", smash.mo41732e());
        } catch (Exception e) {
            C12802d c = C12802d.m41613c();
            C12801a aVar = C12801a.NATIVE;
            StringBuilder sb = new StringBuilder();
            sb.append("IronSourceUtils:getProviderAdditionalData(adapter: ");
            sb.append(smash.mo41731d());
            sb.append(")");
            c.mo41426a(aVar, sb.toString(), (Throwable) e);
        }
        return data;
    }

    /* renamed from: a */
    public static JSONObject m41965a(boolean isDemandOnlyMode) {
        return m41966a(isDemandOnlyMode, false);
    }

    /* renamed from: a */
    public static JSONObject m41966a(boolean isDemandOnlyMode, boolean isProgrammatic) {
        JSONObject data = new JSONObject();
        try {
            data.put("provider", "Mediation");
            if (isDemandOnlyMode) {
                data.put("networkInstance", "true");
            }
            if (isProgrammatic) {
                data.put("programmatic", 1);
            }
        } catch (JSONException e) {
        }
        return data;
    }

    /* renamed from: f */
    static void m41989f(Context context, String key, String value) {
        Editor editor = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        editor.putString(key, value);
        editor.apply();
    }

    /* renamed from: c */
    static String m41980c(Context context, String key, String defaultValue) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(key, defaultValue);
    }

    /* renamed from: b */
    static void m41978b(Context context, String key, boolean value) {
        Editor editor = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /* renamed from: a */
    static boolean m41969a(Context context, String key, boolean defaultValue) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getBoolean(key, defaultValue);
    }

    /* renamed from: b */
    static void m41976b(Context context, String key, int value) {
        Editor editor = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /* renamed from: a */
    static int m41956a(Context context, String key, int defaultValue) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getInt(key, defaultValue);
    }

    /* renamed from: b */
    static void m41977b(Context context, String key, long value) {
        Editor editor = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /* renamed from: a */
    static long m41957a(Context context, String key, long defaultValue) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getLong(key, defaultValue);
    }

    /* renamed from: a */
    public static JSONObject m41964a(JSONObject mainJson, JSONObject secondaryJson) {
        if (mainJson == null && secondaryJson == null) {
            try {
                return new JSONObject();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (mainJson == null) {
            return secondaryJson;
        } else {
            if (secondaryJson == null) {
                return mainJson;
            }
            Iterator it = secondaryJson.keys();
            while (it.hasNext()) {
                String key = (String) it.next();
                if (!mainJson.has(key)) {
                    mainJson.put(key, secondaryJson.get(key));
                }
            }
        }
        return mainJson;
    }

    /* renamed from: c */
    public static synchronized void m41981c(String text) {
        synchronized (C12916j.class) {
            StringBuilder sb = new StringBuilder();
            sb.append("automation_log:");
            sb.append(Long.toString(System.currentTimeMillis()));
            sb.append("text:");
            sb.append(text);
            C12802d.m41613c().mo41427b(C12801a.INTERNAL, sb.toString(), 1);
        }
    }

    /* renamed from: a */
    static Map<String, String> m41961a(JSONObject genericParams) {
        Map<String, String> genericParamsMap = new HashMap<>();
        try {
            if (genericParams != JSONObject.NULL) {
                Iterator<?> keys = genericParams.keys();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    if (!genericParams.get(key).toString().isEmpty()) {
                        genericParamsMap.put(key, genericParams.get(key).toString());
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return genericParamsMap;
    }
}
