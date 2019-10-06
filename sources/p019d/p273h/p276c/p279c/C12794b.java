package p019d.p273h.p276c.p279c;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Pair;
import com.mopub.common.logging.MoPubLog;
import java.util.ArrayList;
import java.util.Iterator;
import p019d.p273h.p276c.C12951y;
import p019d.p273h.p276c.p284h.C12916j;

/* renamed from: d.h.c.c.b */
/* compiled from: IntegrationHelper */
public class C12794b {
    /* renamed from: a */
    public static void m41563a(Activity activity) {
        String[] adapters;
        String str = "IntegrationHelper";
        Log.i(str, "Verifying Integration:");
        m41572c(activity);
        String str2 = "SupersonicAds";
        for (String adapter : new String[]{str2, "AdColony", "AppLovin", "Chartboost", "HyprMX", "UnityAds", "Vungle", "InMobi", "Facebook", "Fyber", "MediaBrix", "Tapjoy", "AdMob", MoPubLog.LOGTAG, "Maio"}) {
            String str3 = ">>>> ";
            if (m41569b(activity, adapter)) {
                if (adapter.equalsIgnoreCase(str2)) {
                    Log.i(str, ">>>> IronSource - VERIFIED");
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str3);
                    sb.append(adapter);
                    sb.append(" - VERIFIED");
                    Log.i(str, sb.toString());
                }
            } else if (adapter.equalsIgnoreCase(str2)) {
                Log.e(str, ">>>> IronSource - NOT VERIFIED");
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(adapter);
                sb2.append(" - NOT VERIFIED");
                Log.e(str, sb2.toString());
            }
        }
        m41568b(activity);
    }

    /* renamed from: b */
    private static boolean m41569b(Activity activity, String adapterName) {
        String str = "SupersonicAds";
        String str2 = "IntegrationHelper";
        try {
            if (adapterName.equalsIgnoreCase(str)) {
                Log.i(str2, "--------------- IronSource  --------------");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("--------------- ");
                sb.append(adapterName);
                sb.append(" --------------");
                Log.i(str2, sb.toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("com.ironsource.adapters.");
            sb2.append(adapterName.toLowerCase());
            sb2.append(".");
            sb2.append(adapterName);
            sb2.append("Adapter");
            String className = sb2.toString();
            C12951y data = m41562a(activity, className);
            if (data == null || !m41571b(data)) {
                return false;
            }
            if (!adapterName.equalsIgnoreCase(str) && !m41566a(data)) {
                return false;
            }
            boolean ret = true;
            if (!adapterName.equalsIgnoreCase(str)) {
                m41564a(className);
            }
            if (!m41565a(activity, data.f39859c)) {
                ret = false;
            }
            if (!m41567a(data.f39860d)) {
                ret = false;
            }
            if (!m41570b(activity, data.f39861e)) {
                ret = false;
            }
            if (data.f39862f && VERSION.SDK_INT <= 18) {
                if (activity.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", activity.getPackageName()) == 0) {
                    Log.i(str2, "android.permission.WRITE_EXTERNAL_STORAGE - VERIFIED");
                } else {
                    Log.e(str2, "android.permission.WRITE_EXTERNAL_STORAGE - MISSING");
                    ret = false;
                }
            }
            return ret;
        } catch (Exception e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("isAdapterValid ");
            sb3.append(adapterName);
            Log.e(str2, sb3.toString(), e);
            return false;
        }
    }

    /* renamed from: b */
    private static boolean m41570b(Activity activity, String[] services) {
        String str = " - MISSING";
        if (services == null) {
            return true;
        }
        PackageManager packageManager = activity.getPackageManager();
        String str2 = "IntegrationHelper";
        Log.i(str2, "*** Services ***");
        boolean ret = true;
        for (String service : services) {
            try {
                if (packageManager.queryIntentServices(new Intent(activity, Class.forName(service)), 65536).size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(service);
                    sb.append(" - VERIFIED");
                    Log.i(str2, sb.toString());
                } else {
                    ret = false;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(service);
                    sb2.append(str);
                    Log.e(str2, sb2.toString());
                }
            } catch (ClassNotFoundException e) {
                ret = false;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(service);
                sb3.append(str);
                Log.e(str2, sb3.toString());
            }
        }
        return ret;
    }

    /* renamed from: a */
    private static boolean m41567a(ArrayList<Pair<String, String>> externalLibs) {
        if (externalLibs == null) {
            return true;
        }
        String str = "IntegrationHelper";
        Log.i(str, "*** External Libraries ***");
        boolean ret = true;
        Iterator it = externalLibs.iterator();
        while (it.hasNext()) {
            Pair<String, String> externalLibrary = (Pair) it.next();
            try {
                Class cls = Class.forName((String) externalLibrary.first);
                StringBuilder sb = new StringBuilder();
                sb.append((String) externalLibrary.second);
                sb.append(" - VERIFIED");
                Log.i(str, sb.toString());
            } catch (ClassNotFoundException e) {
                ret = false;
                StringBuilder sb2 = new StringBuilder();
                sb2.append((String) externalLibrary.second);
                sb2.append(" - MISSING");
                Log.e(str, sb2.toString());
            }
        }
        return ret;
    }

    /* renamed from: a */
    private static boolean m41565a(Activity activity, String[] activities) {
        String str = " - MISSING";
        if (activities == null) {
            return true;
        }
        String str2 = "IntegrationHelper";
        Log.i(str2, "*** Activities ***");
        boolean ret = true;
        for (String act : activities) {
            try {
                if (activity.getPackageManager().queryIntentActivities(new Intent(activity, Class.forName(act)), 65536).size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(act);
                    sb.append(" - VERIFIED");
                    Log.i(str2, sb.toString());
                } else {
                    ret = false;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(act);
                    sb2.append(str);
                    Log.e(str2, sb2.toString());
                }
            } catch (ClassNotFoundException e) {
                ret = false;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(act);
                sb3.append(str);
                Log.e(str2, sb3.toString());
            }
        }
        return ret;
    }

    /* renamed from: c */
    private static void m41572c(Activity activity) {
        String str = "IntegrationHelper";
        Log.i(str, "*** Permissions ***");
        PackageManager pm = activity.getPackageManager();
        if (pm.checkPermission("android.permission.INTERNET", activity.getPackageName()) == 0) {
            Log.i(str, "android.permission.INTERNET - VERIFIED");
        } else {
            Log.e(str, "android.permission.INTERNET - MISSING");
        }
        if (pm.checkPermission("android.permission.ACCESS_NETWORK_STATE", activity.getPackageName()) == 0) {
            Log.i(str, "android.permission.ACCESS_NETWORK_STATE - VERIFIED");
        } else {
            Log.e(str, "android.permission.ACCESS_NETWORK_STATE - MISSING");
        }
    }

    /* renamed from: b */
    private static boolean m41571b(C12951y data) {
        if (!data.f39857a.equalsIgnoreCase("AppLovin") && !data.f39857a.equalsIgnoreCase("AdMob") && !data.f39857a.equalsIgnoreCase("Facebook") && !data.f39857a.equalsIgnoreCase("InMobi") && !data.f39857a.equalsIgnoreCase("Fyber")) {
            return true;
        }
        String str = "4.3";
        if (data.f39858b.startsWith(str)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(data.f39857a);
        sb.append(" adapter ");
        sb.append(data.f39858b);
        sb.append(" is incompatible for showing banners with SDK version ");
        sb.append(C12916j.m41971b());
        sb.append(", please update your adapter to version ");
        sb.append(str);
        sb.append(".*");
        Log.e("IntegrationHelper", sb.toString());
        return false;
    }

    /* renamed from: a */
    private static boolean m41566a(C12951y data) {
        String str = "4.1";
        String str2 = "IntegrationHelper";
        if (data.f39858b.startsWith(str) || data.f39858b.startsWith("4.3")) {
            Log.i(str2, "Adapter - VERIFIED");
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(data.f39857a);
        sb.append(" adapter ");
        sb.append(data.f39858b);
        sb.append(" is incompatible with SDK version ");
        sb.append(C12916j.m41971b());
        sb.append(", please update your adapter to version ");
        sb.append(str);
        sb.append(".*");
        Log.e(str2, sb.toString());
        return false;
    }

    /* renamed from: a */
    private static C12951y m41562a(Activity activity, String className) {
        String str = "IntegrationHelper";
        try {
            C12951y ret = (C12951y) Class.forName(className).getMethod("getIntegrationData", new Class[]{Activity.class}).invoke(null, new Object[]{activity});
            StringBuilder sb = new StringBuilder();
            sb.append("Adapter ");
            sb.append(ret.f39858b);
            sb.append(" - VERIFIED");
            Log.i(str, sb.toString());
            return ret;
        } catch (ClassNotFoundException e) {
            Log.e(str, "Adapter - MISSING");
            return null;
        } catch (Exception e2) {
            Log.e(str, "Adapter version - NOT VERIFIED");
            return null;
        }
    }

    /* renamed from: b */
    private static void m41568b(Activity activity) {
        String str = "com.google.android.gms.version";
        String str2 = "Google Play Services";
        new C12793a(activity).start();
    }

    /* renamed from: a */
    private static void m41564a(String className) {
        try {
            String sdkVersion = (String) Class.forName(className).getMethod("getAdapterSDKVersion", new Class[0]).invoke(null, new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append("SDK Version - ");
            sb.append(sdkVersion);
            Log.i("IntegrationHelper", sb.toString());
        } catch (Exception e) {
            Log.w("validateSDKVersion", "Unable to get SDK version");
        }
    }
}
