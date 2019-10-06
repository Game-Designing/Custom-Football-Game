package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.C6534A;
import com.facebook.C6787r;
import com.facebook.C6817z;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.C6545b;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TimeZone;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.facebook.internal.S */
/* compiled from: Utility */
public final class C6694S {

    /* renamed from: a */
    private static int f12222a = 0;

    /* renamed from: b */
    private static long f12223b = -1;

    /* renamed from: c */
    private static long f12224c = -1;

    /* renamed from: d */
    private static long f12225d = -1;

    /* renamed from: e */
    private static String f12226e;

    /* renamed from: f */
    private static String f12227f;

    /* renamed from: g */
    private static String f12228g = "NoCarrier";

    /* renamed from: com.facebook.internal.S$a */
    /* compiled from: Utility */
    public interface C6695a {
        /* renamed from: a */
        void mo19649a(FacebookException facebookException);

        /* renamed from: a */
        void mo19650a(JSONObject jSONObject);
    }

    /* renamed from: com.facebook.internal.S$b */
    /* compiled from: Utility */
    public static class C6696b {

        /* renamed from: a */
        List<String> f12229a;

        /* renamed from: b */
        List<String> f12230b;

        /* renamed from: c */
        List<String> f12231c;

        public C6696b(List<String> grantedPermissions, List<String> declinedPermissions, List<String> expiredPermissions) {
            this.f12229a = grantedPermissions;
            this.f12230b = declinedPermissions;
            this.f12231c = expiredPermissions;
        }

        /* renamed from: c */
        public List<String> mo19910c() {
            return this.f12229a;
        }

        /* renamed from: a */
        public List<String> mo19908a() {
            return this.f12230b;
        }

        /* renamed from: b */
        public List<String> mo19909b() {
            return this.f12231c;
        }
    }

    static {
        String str = "";
        f12226e = str;
        f12227f = str;
    }

    /* renamed from: a */
    public static <T> boolean m13430a(Collection<T> c) {
        return c == null || c.size() == 0;
    }

    /* renamed from: b */
    public static boolean m13436b(String s) {
        return s == null || s.length() == 0;
    }

    /* renamed from: a */
    public static String m13403a(String s, String valueIfNullOrEmpty) {
        if (m13436b(s)) {
            return valueIfNullOrEmpty;
        }
        return s;
    }

    /* renamed from: b */
    public static <T> Collection<T> m13432b(T... ts) {
        return Collections.unmodifiableCollection(Arrays.asList(ts));
    }

    /* renamed from: c */
    public static String m13438c(String key) {
        return m13439c("MD5", key);
    }

    /* renamed from: a */
    public static String m13406a(byte[] bytes) {
        return m13404a("SHA-1", bytes);
    }

    /* renamed from: e */
    public static String m13446e(String key) {
        if (key == null) {
            return null;
        }
        return m13439c("SHA-256", key);
    }

    /* renamed from: c */
    private static String m13439c(String algorithm, String key) {
        return m13404a(algorithm, key.getBytes());
    }

    /* renamed from: a */
    private static String m13404a(String algorithm, byte[] bytes) {
        try {
            return m13405a(MessageDigest.getInstance(algorithm), bytes);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m13405a(MessageDigest hash, byte[] bytes) {
        hash.update(bytes);
        byte[] digest = hash.digest();
        StringBuilder builder = new StringBuilder();
        for (byte b : digest) {
            builder.append(Integer.toHexString((b >> 4) & 15));
            builder.append(Integer.toHexString((b >> 0) & 15));
        }
        return builder.toString();
    }

    /* renamed from: a */
    public static Uri m13397a(String authority, String path, Bundle parameters) {
        Builder builder = new Builder();
        builder.scheme("https");
        builder.authority(authority);
        builder.path(path);
        if (parameters != null) {
            for (String key : parameters.keySet()) {
                Object parameter = parameters.get(key);
                if (parameter instanceof String) {
                    builder.appendQueryParameter(key, (String) parameter);
                }
            }
        }
        return builder.build();
    }

    /* renamed from: d */
    public static Bundle m13443d(String queryString) {
        Bundle params = new Bundle();
        if (!m13436b(queryString)) {
            for (String parameter : queryString.split("&")) {
                String[] keyValuePair = parameter.split("=");
                try {
                    String str = "UTF-8";
                    if (keyValuePair.length == 2) {
                        params.putString(URLDecoder.decode(keyValuePair[0], str), URLDecoder.decode(keyValuePair[1], str));
                    } else if (keyValuePair.length == 1) {
                        params.putString(URLDecoder.decode(keyValuePair[0], str), "");
                    }
                } catch (UnsupportedEncodingException e) {
                    m13422a("FacebookSDK", (Exception) e);
                }
            }
        }
        return params;
    }

    /* renamed from: a */
    public static void m13418a(Bundle b, String key, String value) {
        if (!m13436b(value)) {
            b.putString(key, value);
        }
    }

    /* renamed from: a */
    public static void m13417a(Bundle b, String key, Uri uri) {
        if (uri != null) {
            m13418a(b, key, uri.toString());
        }
    }

    /* renamed from: a */
    public static boolean m13427a(Bundle bundle, String key, Object value) {
        if (value == null) {
            bundle.remove(key);
        } else if (value instanceof Boolean) {
            bundle.putBoolean(key, ((Boolean) value).booleanValue());
        } else if (value instanceof boolean[]) {
            bundle.putBooleanArray(key, (boolean[]) value);
        } else if (value instanceof Double) {
            bundle.putDouble(key, ((Double) value).doubleValue());
        } else if (value instanceof double[]) {
            bundle.putDoubleArray(key, (double[]) value);
        } else if (value instanceof Integer) {
            bundle.putInt(key, ((Integer) value).intValue());
        } else if (value instanceof int[]) {
            bundle.putIntArray(key, (int[]) value);
        } else if (value instanceof Long) {
            bundle.putLong(key, ((Long) value).longValue());
        } else if (value instanceof long[]) {
            bundle.putLongArray(key, (long[]) value);
        } else if (value instanceof String) {
            bundle.putString(key, (String) value);
        } else if (value instanceof JSONArray) {
            bundle.putString(key, value.toString());
        } else if (!(value instanceof JSONObject)) {
            return false;
        } else {
            bundle.putString(key, value.toString());
        }
        return true;
    }

    /* renamed from: a */
    public static void m13420a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static void m13424a(URLConnection connection) {
        if (connection != null && (connection instanceof HttpURLConnection)) {
            ((HttpURLConnection) connection).disconnect();
        }
    }

    /* renamed from: c */
    public static String m13437c(Context context) {
        C6697T.m13461a((Object) context, "context");
        C6787r.m13813c(context);
        return C6787r.m13816f();
    }

    /* renamed from: a */
    public static Object m13400a(JSONObject jsonObject, String key, String nonJSONPropertyKey) throws JSONException {
        Object value = jsonObject.opt(key);
        if (value != null && (value instanceof String)) {
            value = new JSONTokener((String) value).nextValue();
        }
        if (value == null || (value instanceof JSONObject) || (value instanceof JSONArray)) {
            return value;
        }
        if (nonJSONPropertyKey != null) {
            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.putOpt(nonJSONPropertyKey, value);
            return jsonObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    /* renamed from: a */
    public static String m13402a(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        InputStreamReader reader = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            reader = new InputStreamReader(bufferedInputStream);
            StringBuilder stringBuilder = new StringBuilder();
            char[] buffer = new char[Opcodes.ACC_STRICT];
            while (true) {
                int read = reader.read(buffer);
                int n = read;
                if (read == -1) {
                    return stringBuilder.toString();
                }
                stringBuilder.append(buffer, 0, n);
            }
        } finally {
            m13420a((Closeable) bufferedInputStream);
            m13420a((Closeable) reader);
        }
    }

    /* renamed from: a */
    public static int m13394a(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        int totalBytes = 0;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            byte[] buffer = new byte[Opcodes.ACC_ANNOTATION];
            while (true) {
                int read = bufferedInputStream2.read(buffer);
                int bytesRead = read;
                if (read == -1) {
                    break;
                }
                outputStream.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }
            bufferedInputStream2.close();
            if (inputStream != null) {
                inputStream.close();
            }
            return totalBytes;
        } catch (Throwable th) {
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static void m13416a(Context context, String domain) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookies = cookieManager.getCookie(domain);
        if (cookies != null) {
            for (String cookie : cookies.split(";")) {
                String[] cookieParts = cookie.split("=");
                if (cookieParts.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(cookieParts[0].trim());
                    sb.append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                    cookieManager.setCookie(domain, sb.toString());
                }
            }
            cookieManager.removeExpiredCookie();
        }
    }

    /* renamed from: a */
    public static void m13415a(Context context) {
        m13416a(context, "facebook.com");
        m13416a(context, ".facebook.com");
        m13416a(context, "https://facebook.com");
        m13416a(context, "https://.facebook.com");
    }

    /* renamed from: a */
    public static void m13422a(String tag, Exception e) {
        if (C6787r.m13827q() && tag != null && e != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.getClass().getSimpleName());
            sb.append(": ");
            sb.append(e.getMessage());
            Log.d(tag, sb.toString());
        }
    }

    /* renamed from: b */
    public static void m13433b(String tag, String msg) {
        if (C6787r.m13827q() && tag != null && msg != null) {
            Log.d(tag, msg);
        }
    }

    /* renamed from: a */
    public static void m13423a(String tag, String msg, Throwable t) {
        if (C6787r.m13827q() && !m13436b(tag)) {
            Log.d(tag, msg, t);
        }
    }

    /* renamed from: a */
    public static <T> boolean m13429a(T a, T b) {
        if (a != null) {
            return a.equals(b);
        }
        return b == null;
    }

    /* renamed from: a */
    public static <T> List<T> m13411a(T... array) {
        ArrayList<T> result = new ArrayList<>();
        for (T t : array) {
            if (t != null) {
                result.add(t);
            }
        }
        return result;
    }

    /* renamed from: a */
    public static List<String> m13410a(JSONArray jsonArray) throws JSONException {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            result.add(jsonArray.getString(i));
        }
        return result;
    }

    /* renamed from: a */
    public static void m13426a(JSONObject params, C6709b attributionIdentifiers, String anonymousAppDeviceGUID, boolean limitEventUsage) throws JSONException {
        if (!(attributionIdentifiers == null || attributionIdentifiers.mo19952c() == null)) {
            params.put("attribution", attributionIdentifiers.mo19952c());
        }
        if (!(attributionIdentifiers == null || attributionIdentifiers.mo19950a() == null)) {
            params.put("advertiser_id", attributionIdentifiers.mo19950a());
            params.put("advertiser_tracking_enabled", !attributionIdentifiers.mo19953d());
        }
        if (!(attributionIdentifiers == null || attributionIdentifiers.mo19951b() == null)) {
            params.put("installer_package", attributionIdentifiers.mo19951b());
        }
        params.put("anon_id", anonymousAppDeviceGUID);
        params.put("application_tracking_enabled", !limitEventUsage);
    }

    /* renamed from: a */
    public static void m13425a(JSONObject params, Context appContext) throws JSONException {
        Locale locale;
        JSONArray extraInfoArray = new JSONArray();
        extraInfoArray.put("a2");
        m13453h(appContext);
        String pkgName = appContext.getPackageName();
        int versionCode = -1;
        String versionName = "";
        try {
            PackageInfo pi = appContext.getPackageManager().getPackageInfo(pkgName, 0);
            versionCode = pi.versionCode;
            versionName = pi.versionName;
        } catch (NameNotFoundException e) {
        }
        extraInfoArray.put(pkgName);
        extraInfoArray.put(versionCode);
        extraInfoArray.put(versionName);
        extraInfoArray.put(VERSION.RELEASE);
        extraInfoArray.put(Build.MODEL);
        try {
            locale = appContext.getResources().getConfiguration().locale;
        } catch (Exception e2) {
            locale = Locale.getDefault();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage());
        sb.append("_");
        sb.append(locale.getCountry());
        extraInfoArray.put(sb.toString());
        extraInfoArray.put(f12226e);
        extraInfoArray.put(f12228g);
        int width = 0;
        int height = 0;
        double density = 0.0d;
        try {
            WindowManager wm = (WindowManager) appContext.getSystemService("window");
            if (wm != null) {
                Display display = wm.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                display.getMetrics(displayMetrics);
                width = displayMetrics.widthPixels;
                height = displayMetrics.heightPixels;
                density = (double) displayMetrics.density;
            }
        } catch (Exception e3) {
        }
        extraInfoArray.put(width);
        extraInfoArray.put(height);
        extraInfoArray.put(new DecimalFormat("#.##").format(density));
        extraInfoArray.put(m13442d());
        extraInfoArray.put(f12224c);
        extraInfoArray.put(f12225d);
        extraInfoArray.put(f12227f);
        params.put("extinfo", extraInfoArray.toString());
    }

    /* renamed from: a */
    public static Method m13407a(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        try {
            return clazz.getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static Method m13408a(String className, String methodName, Class<?>... parameterTypes) {
        try {
            return m13407a(Class.forName(className), methodName, parameterTypes);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static Object m13399a(Object receiver, Method method, Object... args) {
        try {
            return method.invoke(receiver, args);
        } catch (IllegalAccessException e) {
            return null;
        } catch (InvocationTargetException e2) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m13431b(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        return context.getClass().getSimpleName();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        if ("fbstaging".equalsIgnoreCase(r2.getScheme()) != false) goto L_0x0026;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m13445d(android.net.Uri r2) {
        /*
            if (r2 == 0) goto L_0x0028
            java.lang.String r0 = r2.getScheme()
            java.lang.String r1 = "http"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = r2.getScheme()
            java.lang.String r1 = "https"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = r2.getScheme()
            java.lang.String r1 = "fbstaging"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0028
        L_0x0026:
            r0 = 1
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.C6694S.m13445d(android.net.Uri):boolean");
    }

    /* renamed from: b */
    public static boolean m13435b(Uri uri) {
        if (uri != null) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m13441c(Uri uri) {
        if (uri != null) {
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static long m13396a(Uri contentUri) {
        Cursor cursor = null;
        try {
            cursor = C6787r.m13815e().getContentResolver().query(contentUri, null, null, null, null);
            int sizeIndex = cursor.getColumnIndex("_size");
            cursor.moveToFirst();
            return cursor.getLong(sizeIndex);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* renamed from: a */
    public static Date m13409a(Bundle bundle, String key, Date dateBase) {
        long secondsFromBase;
        if (bundle == null) {
            return null;
        }
        Object secondsObject = bundle.get(key);
        if (secondsObject instanceof Long) {
            secondsFromBase = ((Long) secondsObject).longValue();
        } else if (!(secondsObject instanceof String)) {
            return null;
        } else {
            try {
                secondsFromBase = Long.parseLong((String) secondsObject);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        if (secondsFromBase == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date(dateBase.getTime() + (1000 * secondsFromBase));
    }

    /* renamed from: a */
    public static void m13419a(Parcel parcel, Map<String, String> map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Entry<String, String> entry : map.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
    }

    /* renamed from: a */
    public static Map<String, String> m13413a(Parcel parcel) {
        int size = parcel.readInt();
        if (size < 0) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put(parcel.readString(), parcel.readString());
        }
        return map;
    }

    /* renamed from: a */
    public static boolean m13428a(AccessToken token) {
        return token != null && token.equals(AccessToken.m12820c());
    }

    /* renamed from: a */
    public static void m13421a(String accessToken, C6695a callback) {
        JSONObject cachedValue = C6689M.m13385a(accessToken);
        if (cachedValue != null) {
            callback.mo19650a(cachedValue);
            return;
        }
        C6545b graphCallback = new C6692P(callback, accessToken);
        GraphRequest graphRequest = m13449f(accessToken);
        graphRequest.mo19677a(graphCallback);
        graphRequest.mo19681c();
    }

    /* renamed from: a */
    public static JSONObject m13414a(String accessToken) {
        JSONObject cachedValue = C6689M.m13385a(accessToken);
        if (cachedValue != null) {
            return cachedValue;
        }
        C6817z response = m13449f(accessToken).mo19680b();
        if (response.mo20227a() != null) {
            return null;
        }
        return response.mo20228b();
    }

    /* renamed from: f */
    private static GraphRequest m13449f(String accessToken) {
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,first_name,middle_name,last_name,link");
        parameters.putString("access_token", accessToken);
        GraphRequest graphRequest = new GraphRequest(null, "me", parameters, C6534A.GET, null);
        return graphRequest;
    }

    /* renamed from: d */
    private static int m13442d() {
        int i = f12222a;
        if (i > 0) {
            return i;
        }
        try {
            File[] cpuFiles = new File("/sys/devices/system/cpu/").listFiles(new C6693Q());
            if (cpuFiles != null) {
                f12222a = cpuFiles.length;
            }
        } catch (Exception e) {
        }
        if (f12222a <= 0) {
            f12222a = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return f12222a;
    }

    /* renamed from: h */
    private static void m13453h(Context appContext) {
        if (f12223b == -1 || System.currentTimeMillis() - f12223b >= BuildConfig.ANALYTICS_SESSION_INTERVAL_IN_MILLIS) {
            f12223b = System.currentTimeMillis();
            m13447e();
            m13452g(appContext);
            m13450f();
            m13440c();
        }
    }

    /* renamed from: e */
    private static void m13447e() {
        try {
            TimeZone tz = TimeZone.getDefault();
            f12226e = tz.getDisplayName(tz.inDaylightTime(new Date()), 0);
            f12227f = tz.getID();
        } catch (AssertionError | Exception e) {
        }
    }

    /* renamed from: g */
    private static void m13452g(Context appContext) {
        if (f12228g.equals("NoCarrier")) {
            try {
                f12228g = ((TelephonyManager) appContext.getSystemService("phone")).getNetworkOperatorName();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    private static boolean m13434b() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    /* renamed from: c */
    private static void m13440c() {
        try {
            if (m13434b()) {
                StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
                f12225d = ((long) stat.getAvailableBlocks()) * ((long) stat.getBlockSize());
            }
            f12225d = m13395a((double) f12225d);
        } catch (Exception e) {
        }
    }

    /* renamed from: f */
    private static void m13450f() {
        try {
            if (m13434b()) {
                StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
                f12224c = ((long) stat.getBlockCount()) * ((long) stat.getBlockSize());
            }
            f12224c = m13395a((double) f12224c);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private static long m13395a(double bytes) {
        return Math.round(bytes / 1.073741824E9d);
    }

    /* renamed from: a */
    public static C6696b m13398a(JSONObject result) throws JSONException {
        JSONArray data = result.getJSONObject("permissions").getJSONArray("data");
        List<String> grantedPermissions = new ArrayList<>(data.length());
        List<String> declinedPermissions = new ArrayList<>(data.length());
        List<String> expiredPermissions = new ArrayList<>(data.length());
        for (int i = 0; i < data.length(); i++) {
            JSONObject object = data.optJSONObject(i);
            String permission = object.optString("permission");
            if (permission != null && !permission.equals("installed")) {
                String status = object.optString("status");
                if (status != null) {
                    if (status.equals("granted")) {
                        grantedPermissions.add(permission);
                    } else if (status.equals("declined")) {
                        declinedPermissions.add(permission);
                    } else if (status.equals("expired")) {
                        expiredPermissions.add(permission);
                    }
                }
            }
        }
        return new C6696b(grantedPermissions, declinedPermissions, expiredPermissions);
    }

    /* renamed from: a */
    public static String m13401a(int length) {
        return new BigInteger(length * 5, new Random()).toString(32);
    }

    /* renamed from: f */
    public static boolean m13451f(Context context) {
        return m13444d(context);
    }

    /* renamed from: d */
    public static boolean m13444d(Context context) {
        boolean z = false;
        if (VERSION.SDK_INT < 26) {
            return false;
        }
        AutofillManager afm = (AutofillManager) context.getSystemService(AutofillManager.class);
        if (afm != null && afm.isAutofillSupported() && afm.isEnabled()) {
            z = true;
        }
        return z;
    }

    /* renamed from: e */
    public static boolean m13448e(Context context) {
        if (VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String str = Build.DEVICE;
        return str != null && str.matches(".+_cheets|cheets_.+");
    }

    /* renamed from: a */
    public static Locale m13412a() {
        try {
            return C6787r.m13815e().getResources().getConfiguration().locale;
        } catch (Exception e) {
            return Locale.getDefault();
        }
    }
}
