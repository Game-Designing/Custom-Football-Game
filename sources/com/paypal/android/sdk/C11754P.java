package com.paypal.android.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
import p024io.realm.internal.Collection;

/* renamed from: com.paypal.android.sdk.P */
public final class C11754P {

    /* renamed from: a */
    private static final boolean f36872a = Boolean.valueOf(System.getProperty("dyson.debug.mode", Boolean.FALSE.toString())).booleanValue();

    /* renamed from: b */
    private static final boolean f36873b = Boolean.valueOf(System.getProperty("prd.debug.mode", Boolean.FALSE.toString())).booleanValue();

    /* renamed from: c */
    private static final String f36874c;

    /* renamed from: d */
    private static final Uri f36875d;

    static {
        Uri uri;
        StringBuilder sb = new StringBuilder();
        sb.append(C12010u.class.getSimpleName());
        sb.append(".");
        sb.append(C11754P.class.getSimpleName());
        f36874c = sb.toString();
        try {
            uri = Uri.parse("content://com.google.android.gsf.gservices");
        } catch (Exception e) {
            uri = null;
        }
        f36875d = uri;
    }

    private C11754P() {
    }

    /* renamed from: a */
    public static Location m38920a(LocationManager locationManager) {
        Location location = null;
        try {
            List providers = locationManager.getProviders(true);
            for (int size = providers.size() - 1; size >= 0; size--) {
                location = locationManager.getLastKnownLocation((String) providers.get(size));
                if (location != null) {
                    break;
                }
            }
        } catch (RuntimeException e) {
        }
        return location;
    }

    /* renamed from: a */
    public static C11858p m38921a(Context context) {
        C11858p pVar = new C11858p();
        pVar.mo38833a(context.getPackageName());
        try {
            pVar.mo38835b(context.getPackageManager().getPackageInfo(pVar.mo38832a(), 0).versionName);
        } catch (NameNotFoundException e) {
        }
        return pVar;
    }

    /* renamed from: a */
    public static Object m38922a(Object obj, Class cls) {
        if (obj == null || !cls.isAssignableFrom(obj.getClass())) {
            return null;
        }
        return cls.cast(obj);
    }

    /* renamed from: a */
    public static Object m38923a(Map map, Class cls, String str, Object obj) {
        if (map == null) {
            return obj;
        }
        Object obj2 = map.get(str);
        if (obj2 == null) {
            return obj;
        }
        if (cls.isAssignableFrom(obj2.getClass())) {
            return cls.cast(obj2);
        }
        String str2 = "cannot parse data for ";
        StringBuilder sb = new StringBuilder(str2);
        sb.append(str);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder(str2);
        sb3.append(str);
        m38930a(6, "PRD", sb2, (Throwable) new Exception(sb3.toString()));
        return obj;
    }

    /* renamed from: a */
    public static String m38924a() {
        String str = "";
        try {
            C11998r rVar = new C11998r();
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
            sb.append("/Android/data/com.ebay.lid/");
            rVar.mo39181a(sb.toString());
            String str2 = "fb.bin";
            String b = rVar.mo39183b(str2);
            try {
                if (str.equals(b.trim())) {
                    str = m38941b(Boolean.TRUE.booleanValue());
                    rVar.mo39182a(str2, str.getBytes("UTF-8"));
                    return str;
                }
            } catch (Exception e) {
            }
            return b;
        } catch (Exception e2) {
            return str;
        }
    }

    /* renamed from: a */
    public static String m38925a(Context context, String str, String str2) {
        try {
            new StringBuilder("entering getMetadata loading name=").append(str);
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                new StringBuilder("leaving getMetadata successfully loading name=").append(str);
                return applicationInfo.metaData.getString(str);
            }
        } catch (NameNotFoundException e) {
            new StringBuilder("load metadata in manifest failed, name=").append(str);
        }
        new StringBuilder("leaving getMetadata with default value,name=").append(str);
        return null;
    }

    /* renamed from: a */
    public static String m38926a(String str) {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.update(str.getBytes());
        byte[] digest = instance.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : digest) {
            stringBuffer.append(Integer.toString((b & 255) + Collection.MODE_EMPTY, 16).substring(1));
        }
        return stringBuffer.toString().substring(0, 32);
    }

    /* renamed from: a */
    public static String m38927a(Map map, String str, String str2) {
        return (String) m38923a(map, String.class, str, (Object) null);
    }

    /* renamed from: a */
    public static List m38928a(boolean z) {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (!(inetAddress instanceof Inet6Address) || z) {
                            arrayList.add(hostAddress);
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m38929a(int i, String str, String str2) {
        if (f36873b) {
            Log.println(i, str, str2);
        }
    }

    /* renamed from: a */
    public static void m38930a(int i, String str, String str2, Throwable th) {
        if (f36873b) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(10);
            sb.append(Log.getStackTraceString(th));
            Log.println(6, str, sb.toString());
        }
    }

    /* renamed from: a */
    public static void m38931a(String str, String str2) {
    }

    /* renamed from: a */
    public static void m38932a(String str, String str2, Throwable th) {
    }

    /* renamed from: a */
    public static void m38933a(String str, JSONObject jSONObject) {
        if (f36872a && jSONObject != null) {
            jSONObject.toString();
        }
    }

    /* renamed from: a */
    public static boolean m38934a(Context context, String str) {
        try {
            return context.getApplicationContext().checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m38935a(PackageManager packageManager, Intent intent) {
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    /* renamed from: a */
    public static boolean m38936a(Map map, String str, Boolean bool) {
        return ((Boolean) m38923a(map, Boolean.class, str, (Object) bool)).booleanValue();
    }

    /* renamed from: b */
    public static String m38937b() {
        List a = m38928a(false);
        return a.isEmpty() ? "" : (String) a.get(0);
    }

    /* renamed from: b */
    public static String m38938b(Context context) {
        if (f36875d != null && m38934a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES")) {
            Cursor query = context.getContentResolver().query(f36875d, null, null, new String[]{"android_id"}, null);
            if (query == null) {
                return null;
            }
            try {
                if (query.moveToFirst()) {
                    if (query.getColumnCount() >= 2) {
                        String hexString = Long.toHexString(Long.parseLong(query.getString(1)));
                        query.close();
                        return hexString;
                    }
                }
                return null;
            } catch (NumberFormatException e) {
            } finally {
                query.close();
            }
        }
        return null;
    }

    /* renamed from: b */
    public static String m38939b(Context context, String str) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                bufferedReader.close();
                return new String(Base64.decode(sb.toString(), 0), "UTF-8");
            }
        }
    }

    /* renamed from: b */
    public static String m38940b(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ((charAt >= '0' && charAt <= '9') || ((charAt >= 'A' && charAt <= 'F') || (charAt >= 'a' && charAt <= 'f'))) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str.charAt(i2));
                int parseInt = Integer.parseInt(sb2.toString(), 16);
                i += parseInt;
                arrayList.add(Integer.valueOf(parseInt));
            }
        }
        int i3 = i + 1;
        int size = arrayList.size() % 4;
        for (int i4 = 0; i4 < arrayList.size() - size; i4 += 4) {
            sb.append(Integer.toHexString((((Integer) arrayList.get((((Integer) arrayList.get(i4 + 3)).intValue() % 4) + i4)).intValue() + i3) % 16));
        }
        if (sb.toString().length() == 0) {
            return null;
        }
        return sb.toString().length() >= 4 ? sb.toString().substring(0, 4) : sb.toString();
    }

    /* renamed from: b */
    public static String m38941b(boolean z) {
        return z ? UUID.randomUUID().toString() : UUID.randomUUID().toString().replaceAll("-", "");
    }

    /* renamed from: b */
    public static boolean m38942b(String str, String str2) {
        String str3 = "\\.";
        String[] split = str.split(str3);
        String[] split2 = str2.split(str3);
        new StringBuilder("Cached version is ").append(str);
        new StringBuilder("default version is ").append(str2);
        int i = 0;
        while (i < split.length && i < split2.length && split[i].equals(split2[i])) {
            i++;
        }
        return Integer.valueOf(Integer.signum((i >= split.length || i >= split2.length) ? split.length - split2.length : Integer.valueOf(split[i]).compareTo(Integer.valueOf(split2[i])))).intValue() >= 0;
    }

    /* renamed from: c */
    public static long m38943c() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (IllegalArgumentException e) {
            e.getLocalizedMessage();
            return 0;
        }
    }

    /* renamed from: c */
    public static String m38944c(Context context, String str) {
        String str2 = "RiskManagerAG";
        SharedPreferences sharedPreferences = context.getSharedPreferences(str2, 0);
        String str3 = "";
        String string = sharedPreferences.getString(str2, str3);
        Editor edit = sharedPreferences.edit();
        if (str == null || str.equals(string)) {
            if (!string.equals(str3)) {
                return string;
            }
            str = m38941b(Boolean.TRUE.booleanValue());
        }
        edit.putString(str2, str);
        edit.commit();
        return str;
    }

    /* renamed from: c */
    public static void m38945c(Context context) {
        String str = "RiskManagerCT";
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        int i = sharedPreferences.getInt(str, 0);
        Editor edit = sharedPreferences.edit();
        int i2 = 1;
        if (i > 0 && i < Integer.MAX_VALUE) {
            i2 = 1 + i;
        }
        edit.putInt(str, i2);
        edit.commit();
    }

    /* renamed from: d */
    public static String m38946d() {
        if (VERSION.SDK_INT >= 14) {
            String property = System.getProperty("http.proxyHost");
            if (property != null) {
                String property2 = System.getProperty("http.proxyPort");
                if (property2 != null) {
                    StringBuilder sb = new StringBuilder("host=");
                    sb.append(property);
                    sb.append(",port=");
                    sb.append(property2);
                    return sb.toString();
                }
            }
        }
        return null;
    }

    /* renamed from: d */
    public static String m38947d(Context context) {
        String str = "RiskManagerCT";
        int i = context.getSharedPreferences(str, 0).getInt(str, 0);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        return sb.toString();
    }

    /* renamed from: e */
    public static String m38948e() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.isUp() && networkInterface.getInterfaceAddresses().size() != 0) {
                    String name = networkInterface.getName();
                    if (name.startsWith("ppp") || name.startsWith("tun") || name.startsWith("tap")) {
                        return name;
                    }
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
}
