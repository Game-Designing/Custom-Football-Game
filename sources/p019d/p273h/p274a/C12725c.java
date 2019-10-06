package p019d.p273h.p274a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.WindowManager;
import com.mopub.common.GpsHelper;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONObject;

/* renamed from: d.h.a.c */
/* compiled from: DeviceStatus */
public class C12725c {

    /* renamed from: a */
    private static String f39047a = null;

    /* renamed from: b */
    public static String[] m41090b(Context c) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> mAdvertisingIdClientClass = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
        Object mInfoClass = mAdvertisingIdClientClass.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(mAdvertisingIdClientClass, new Object[]{c});
        Method getIdMethod = mInfoClass.getClass().getMethod("getId", new Class[0]);
        Method isLimitAdTrackingEnabledMethod = mInfoClass.getClass().getMethod(GpsHelper.IS_LIMIT_AD_TRACKING_ENABLED_KEY, new Class[0]);
        String advertisingId = getIdMethod.invoke(mInfoClass, new Object[0]).toString();
        boolean isLimitedTrackingEnabled = ((Boolean) isLimitAdTrackingEnabledMethod.invoke(mInfoClass, new Object[0])).booleanValue();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(isLimitedTrackingEnabled);
        return new String[]{advertisingId, sb.toString()};
    }

    /* renamed from: a */
    private static long m41083a(File f) {
        long res;
        StatFs stat = new StatFs(f.getPath());
        if (VERSION.SDK_INT < 19) {
            res = ((long) stat.getAvailableBlocks()) * ((long) stat.getBlockSize());
        } else {
            res = stat.getAvailableBlocksLong() * stat.getBlockSizeLong();
        }
        return res / 1048576;
    }

    /* renamed from: i */
    public static String m41103i(Context c) {
        return ((TelephonyManager) c.getSystemService("phone")).getNetworkOperatorName();
    }

    /* renamed from: b */
    public static String m41088b() {
        return VERSION.RELEASE;
    }

    /* renamed from: a */
    public static int m41081a() {
        return VERSION.SDK_INT;
    }

    /* renamed from: e */
    public static String m41096e() {
        return Build.MODEL;
    }

    /* renamed from: f */
    public static String m41098f() {
        return Build.MANUFACTURER;
    }

    /* renamed from: g */
    public static String m41099g() {
        return "android";
    }

    /* renamed from: i */
    public static boolean m41104i() {
        return m41089b("su");
    }

    /* renamed from: b */
    private static boolean m41089b(String binaryName) {
        String[] paths;
        try {
            for (String path : new String[]{"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"}) {
                StringBuilder sb = new StringBuilder();
                sb.append(path);
                sb.append(binaryName);
                if (new File(sb.toString()).exists()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: c */
    public static int m41092c(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    /* renamed from: k */
    public static float m41106k(Context context) {
        AudioManager audio = (AudioManager) context.getSystemService("audio");
        return ((float) audio.getStreamVolume(3)) / ((float) audio.getStreamMaxVolume(3));
    }

    /* renamed from: h */
    public static int m41101h() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    /* renamed from: d */
    public static int m41093d() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    /* renamed from: a */
    public static int m41082a(Context activity) {
        if (activity instanceof Activity) {
            return ((Activity) activity).getRequestedOrientation();
        }
        return -1;
    }

    /* renamed from: e */
    public static int m41095e(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    /* renamed from: c */
    public static float m41091c() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    /* renamed from: g */
    public static List<ApplicationInfo> m41100g(Context context) {
        return context.getPackageManager().getInstalledApplications(0);
    }

    /* renamed from: l */
    public static boolean m41107l(Context context) {
        return System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) != 1;
    }

    /* renamed from: f */
    public static File m41097f(Context context) {
        return context.getExternalCacheDir();
    }

    /* renamed from: h */
    public static String m41102h(Context context) {
        File internalFile = context.getCacheDir();
        if (internalFile != null) {
            return internalFile.getPath();
        }
        return null;
    }

    /* renamed from: a */
    public static long m41084a(String path) {
        return m41083a(new File(path));
    }

    @TargetApi(19)
    /* renamed from: a */
    public static boolean m41086a(Activity activity) {
        int uiOptions = activity.getWindow().getDecorView().getSystemUiVisibility();
        return (uiOptions | Opcodes.ACC_SYNTHETIC) == uiOptions || (uiOptions | Opcodes.ACC_STRICT) == uiOptions;
    }

    /* renamed from: d */
    public static int m41094d(Context context) {
        try {
            Intent batteryIntent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int scale = 0;
            int level = batteryIntent != null ? batteryIntent.getIntExtra("level", -1) : 0;
            if (batteryIntent != null) {
                scale = batteryIntent.getIntExtra("scale", -1);
            }
            if (level == -1 || scale == -1) {
                return -1;
            }
            return (int) ((((float) level) / ((float) scale)) * 100.0f);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: j */
    public static synchronized String m41105j(Context context) {
        synchronized (C12725c.class) {
            if (!TextUtils.isEmpty(f39047a)) {
                String str = f39047a;
                return str;
            }
            try {
                SharedPreferences preferences = context.getSharedPreferences("Mediation_Shared_Preferences", 0);
                if (preferences.getBoolean("uuidEnabled", true)) {
                    String id = preferences.getString("cachedUUID", "");
                    if (TextUtils.isEmpty(id)) {
                        f39047a = UUID.randomUUID().toString();
                        Editor editor = preferences.edit();
                        editor.putString("cachedUUID", f39047a);
                        editor.apply();
                    } else {
                        f39047a = id;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String str2 = f39047a;
            return str2;
        }
    }

    /* renamed from: a */
    private static boolean m41087a(ResolveInfo resolveInfo) {
        return (resolveInfo.activityInfo.applicationInfo.flags & 1) != 0;
    }

    /* renamed from: a */
    public static JSONObject m41085a(Context ctx, boolean includeSystemPackages) {
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> pkgAppsList = ctx.getPackageManager().queryIntentActivities(intent, 0);
        JSONObject packagesInstalledPerDate = new JSONObject();
        PackageManager manager = ctx.getPackageManager();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        for (int i = 0; i < pkgAppsList.size(); i++) {
            ResolveInfo resolveInfo = (ResolveInfo) pkgAppsList.get(i);
            if (!includeSystemPackages) {
                try {
                    if (m41087a(resolveInfo)) {
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String installTime = sdf.format(new Date(manager.getPackageInfo(resolveInfo.activityInfo.packageName, Opcodes.ACC_SYNTHETIC).firstInstallTime));
            packagesInstalledPerDate.put(installTime, packagesInstalledPerDate.optInt(installTime, 0) + 1);
        }
        return packagesInstalledPerDate;
    }
}
