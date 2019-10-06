package p024io.fabric.sdk.android.p348a.p350b;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.file.CacheHelper;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;

/* renamed from: io.fabric.sdk.android.a.b.l */
/* compiled from: CommonUtils */
public class C13852l {

    /* renamed from: a */
    private static Boolean f42027a = null;

    /* renamed from: b */
    private static final char[] f42028b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c */
    private static long f42029c = -1;

    /* renamed from: d */
    public static final Comparator<File> f42030d = new C13851k();

    /* renamed from: io.fabric.sdk.android.a.b.l$a */
    /* compiled from: CommonUtils */
    enum C13853a {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        

        /* renamed from: k */
        private static final Map<String, C13853a> f42041k = null;

        static {
            f42041k = new HashMap(4);
            f42041k.put("armeabi-v7a", ARMV7);
            f42041k.put("armeabi", ARMV6);
            f42041k.put("arm64-v8a", ARM64);
            f42041k.put("x86", X86_32);
        }

        /* renamed from: e */
        static C13853a m44064e() {
            String arch = Build.CPU_ABI;
            if (TextUtils.isEmpty(arch)) {
                C13920f.m44245e().mo43326c("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            C13853a value = (C13853a) f42041k.get(arch.toLowerCase(Locale.US));
            if (value == null) {
                value = UNKNOWN;
            }
            return value;
        }
    }

    /* renamed from: i */
    public static SharedPreferences m44057i(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    /* renamed from: a */
    public static String m44026a(File file, String fieldname) {
        String str = "Failed to close system file reader.";
        String toReturn = null;
        if (file.exists()) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file), Opcodes.ACC_ABSTRACT);
                while (true) {
                    String readLine = br.readLine();
                    String line = readLine;
                    if (readLine == null) {
                        break;
                    }
                    String[] pieces = Pattern.compile("\\s*:\\s*").split(line, 2);
                    if (pieces.length > 1 && pieces[0].equals(fieldname)) {
                        toReturn = pieces[1];
                        break;
                    }
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error parsing ");
                sb.append(file);
                C13920f.m44245e().mo43325b("Fabric", sb.toString(), e);
            } catch (Throwable th) {
                m44036a((Closeable) null, str);
                throw th;
            }
            m44036a((Closeable) br, str);
        }
        return toReturn;
    }

    /* renamed from: a */
    public static int m44018a() {
        return C13853a.m44064e().ordinal();
    }

    /* renamed from: b */
    public static synchronized long m44041b() {
        long bytes;
        synchronized (C13852l.class) {
            if (f42029c == -1) {
                long bytes2 = 0;
                String result = m44026a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(result)) {
                    String result2 = result.toUpperCase(Locale.US);
                    try {
                        if (result2.endsWith("KB")) {
                            bytes2 = m44023a(result2, "KB", (int) Opcodes.ACC_ABSTRACT);
                        } else if (result2.endsWith("MB")) {
                            bytes2 = m44023a(result2, "MB", (int) CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES);
                        } else if (result2.endsWith("GB")) {
                            bytes2 = m44023a(result2, "GB", 1073741824);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unexpected meminfo format while computing RAM: ");
                            sb.append(result2);
                            C13920f.m44245e().mo43326c("Fabric", sb.toString());
                        }
                    } catch (NumberFormatException e) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Unexpected meminfo format while computing RAM: ");
                        sb2.append(result2);
                        C13920f.m44245e().mo43325b("Fabric", sb2.toString(), e);
                    }
                }
                f42029c = bytes2;
            }
            bytes = f42029c;
        }
        return bytes;
    }

    /* renamed from: a */
    static long m44023a(String memInfo, String notation, int notationMultiplier) {
        return Long.parseLong(memInfo.split(notation)[0].trim()) * ((long) notationMultiplier);
    }

    /* renamed from: a */
    public static RunningAppProcessInfo m44024a(String packageName, Context context) {
        List<RunningAppProcessInfo> processes = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (processes == null) {
            return null;
        }
        for (RunningAppProcessInfo info : processes) {
            if (info.processName.equals(packageName)) {
                return info;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static String m44044b(InputStream is) throws IOException {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    /* renamed from: c */
    public static String m44048c(String source) {
        return m44029a(source, "SHA-1");
    }

    /* renamed from: d */
    public static String m44052d(String source) {
        return m44029a(source, "SHA-256");
    }

    /* renamed from: a */
    public static String m44027a(InputStream source) {
        return m44028a(source, "SHA-1");
    }

    /* renamed from: a */
    private static String m44029a(String s, String algorithm) {
        return m44031a(s.getBytes(), algorithm);
    }

    /* renamed from: a */
    private static String m44028a(InputStream source, String sha1Instance) {
        try {
            MessageDigest digest = MessageDigest.getInstance(sha1Instance);
            byte[] buffer = new byte[Opcodes.ACC_ABSTRACT];
            while (true) {
                int read = source.read(buffer);
                int length = read;
                if (read == -1) {
                    return m44030a(digest.digest());
                }
                digest.update(buffer, 0, length);
            }
        } catch (Exception e) {
            C13920f.m44245e().mo43325b("Fabric", "Could not calculate hash for app icon.", e);
            return "";
        }
    }

    /* renamed from: a */
    private static String m44031a(byte[] bytes, String algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            digest.update(bytes);
            return m44030a(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            C13929o e2 = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Could not create hashing algorithm: ");
            sb.append(algorithm);
            sb.append(", returning empty string.");
            e2.mo43325b("Fabric", sb.toString(), e);
            return "";
        }
    }

    /* renamed from: a */
    public static String m44032a(String... sliceIds) {
        String str = null;
        if (sliceIds == null || sliceIds.length == 0) {
            return null;
        }
        List<String> sliceIdList = new ArrayList<>();
        for (String id : sliceIds) {
            if (id != null) {
                sliceIdList.add(id.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(sliceIdList);
        StringBuilder sb = new StringBuilder();
        for (String id2 : sliceIdList) {
            sb.append(id2);
        }
        String concatValue = sb.toString();
        if (concatValue.length() > 0) {
            str = m44048c(concatValue);
        }
        return str;
    }

    /* renamed from: a */
    public static long m44021a(Context context) {
        MemoryInfo mi = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(mi);
        return mi.availMem;
    }

    /* renamed from: a */
    public static long m44022a(String path) {
        StatFs statFs = new StatFs(path);
        long blockSizeBytes = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSizeBytes) - (((long) statFs.getAvailableBlocks()) * blockSizeBytes);
    }

    /* renamed from: e */
    public static Float m44053e(Context context) {
        Intent battery = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (battery == null) {
            return null;
        }
        return Float.valueOf(((float) battery.getIntExtra("level", -1)) / ((float) battery.getIntExtra("scale", -1)));
    }

    /* renamed from: g */
    public static boolean m44055g(Context context) {
        boolean z = false;
        if (m44060l(context)) {
            return false;
        }
        if (((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    public static void m44049c(Context context, String msg) {
        if (m44059k(context)) {
            C13920f.m44245e().mo43326c("Fabric", msg);
        }
    }

    /* renamed from: a */
    public static void m44034a(Context context, String msg, Throwable tr) {
        if (m44059k(context)) {
            C13920f.m44245e().mo43324b("Fabric", msg);
        }
    }

    /* renamed from: a */
    public static void m44033a(Context context, int level, String tag, String msg) {
        if (m44059k(context)) {
            C13920f.m44245e().mo43319a(level, "Fabric", msg);
        }
    }

    /* renamed from: k */
    public static boolean m44059k(Context context) {
        if (f42027a == null) {
            f42027a = Boolean.valueOf(m44040a(context, "com.crashlytics.Trace", false));
        }
        return f42027a.booleanValue();
    }

    /* renamed from: a */
    public static boolean m44040a(Context context, String key, boolean defaultValue) {
        if (context != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                int id = m44019a(context, key, "bool");
                if (id > 0) {
                    return resources.getBoolean(id);
                }
                int id2 = m44019a(context, key, "string");
                if (id2 > 0) {
                    return Boolean.parseBoolean(context.getString(id2));
                }
            }
        }
        return defaultValue;
    }

    /* renamed from: a */
    public static int m44019a(Context context, String key, String resourceType) {
        return context.getResources().getIdentifier(key, resourceType, m44056h(context));
    }

    /* renamed from: l */
    public static boolean m44060l(Context context) {
        String androidId = Secure.getString(context.getContentResolver(), "android_id");
        if (!"sdk".equals(Build.PRODUCT)) {
            if (!"google_sdk".equals(Build.PRODUCT) && androidId != null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: m */
    public static boolean m44061m(Context context) {
        boolean isEmulator = m44060l(context);
        String buildTags = Build.TAGS;
        if ((!isEmulator && buildTags != null && buildTags.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (isEmulator || !file.exists()) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m44050c() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    /* renamed from: f */
    public static int m44054f(Context context) {
        int deviceState = 0;
        if (m44060l(context)) {
            deviceState = 0 | 1;
        }
        if (m44061m(context)) {
            deviceState |= 2;
        }
        if (m44050c()) {
            return deviceState | 4;
        }
        return deviceState;
    }

    /* renamed from: a */
    public static int m44020a(Context context, boolean powerConnected) {
        Float batteryLevel = m44053e(context);
        if (!powerConnected || batteryLevel == null) {
            return 1;
        }
        if (((double) batteryLevel.floatValue()) >= 99.0d) {
            return 3;
        }
        if (((double) batteryLevel.floatValue()) < 99.0d) {
            return 2;
        }
        return 0;
    }

    /* renamed from: a */
    public static String m44030a(byte[] bytes) {
        char[] hexChars = new char[(bytes.length * 2)];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 255;
            int i2 = i * 2;
            char[] cArr = f42028b;
            hexChars[i2] = cArr[v >>> 4];
            hexChars[(i * 2) + 1] = cArr[v & 15];
        }
        return new String(hexChars);
    }

    /* renamed from: j */
    public static boolean m44058j(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: b */
    public static String m44043b(Context context, String key) {
        int id = m44019a(context, key, "string");
        if (id > 0) {
            return context.getString(id);
        }
        return "";
    }

    /* renamed from: a */
    public static void m44036a(Closeable c, String message) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                C13920f.m44245e().mo43325b("Fabric", message, e);
            }
        }
    }

    /* renamed from: a */
    public static void m44037a(Flushable f, String message) {
        if (f != null) {
            try {
                f.flush();
            } catch (IOException e) {
                C13920f.m44245e().mo43325b("Fabric", message, e);
            }
        }
    }

    /* renamed from: b */
    public static boolean m44046b(String s) {
        return s == null || s.length() == 0;
    }

    /* renamed from: b */
    public static String m44042b(int value) {
        if (value >= 0) {
            return String.format(Locale.US, "%1$10s", new Object[]{Integer.valueOf(value)}).replace(' ', '0');
        }
        throw new IllegalArgumentException("value must be zero or greater");
    }

    /* renamed from: h */
    public static String m44056h(Context context) {
        int iconId = context.getApplicationContext().getApplicationInfo().icon;
        if (iconId <= 0) {
            return context.getPackageName();
        }
        try {
            return context.getResources().getResourcePackageName(iconId);
        } catch (NotFoundException e) {
            return context.getPackageName();
        }
    }

    /* renamed from: a */
    public static void m44038a(InputStream is, OutputStream os, byte[] buffer) throws IOException {
        while (true) {
            int read = is.read(buffer);
            int count = read;
            if (read != -1) {
                os.write(buffer, 0, count);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static String m44025a(int priority) {
        switch (priority) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                return "?";
        }
    }

    /* renamed from: c */
    public static String m44047c(Context context) {
        String str = "Failed to close icon input stream.";
        InputStream is = null;
        String str2 = null;
        try {
            is = context.getResources().openRawResource(m44051d(context));
            String sha1 = m44027a(is);
            if (!m44046b(sha1)) {
                str2 = sha1;
            }
            return str2;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not calculate hash for app icon:");
            sb.append(e.getMessage());
            C13920f.m44245e().mo43321a("Fabric", sb.toString());
            return null;
        } finally {
            m44036a((Closeable) is, str);
        }
    }

    /* renamed from: d */
    public static int m44051d(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    /* renamed from: n */
    public static String m44062n(Context context) {
        String str = "string";
        int id = m44019a(context, "io.fabric.android.build_id", str);
        if (id == 0) {
            id = m44019a(context, "com.crashlytics.android.build_id", str);
        }
        if (id == 0) {
            return null;
        }
        String buildId = context.getResources().getString(id);
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append("Build ID is: ");
        sb.append(buildId);
        e.mo43326c("Fabric", sb.toString());
        return buildId;
    }

    /* renamed from: o */
    public static String m44063o(Context context) {
        int id = m44019a(context, "com.google.firebase.crashlytics.unity_version", "string");
        if (id == 0) {
            return null;
        }
        String version = context.getResources().getString(id);
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append("Unity Editor version is: ");
        sb.append(version);
        e.mo43326c("Fabric", sb.toString());
        return version;
    }

    /* renamed from: a */
    public static void m44035a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException rethrown) {
                throw rethrown;
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m44039a(Context context, String permission) {
        return context.checkCallingOrSelfPermission(permission) == 0;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    public static boolean m44045b(Context context) {
        boolean isConnected = true;
        if (!m44039a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetwork = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetwork == null || !activeNetwork.isConnectedOrConnecting()) {
            isConnected = false;
        }
        return isConnected;
    }
}
