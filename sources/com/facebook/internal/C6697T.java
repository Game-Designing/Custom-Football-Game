package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.facebook.C6787r;
import com.facebook.FacebookSdkNotInitializedException;
import java.util.Collection;
import java.util.List;

/* renamed from: com.facebook.internal.T */
/* compiled from: Validate */
public final class C6697T {

    /* renamed from: a */
    private static final String f12232a = C6697T.class.getName();

    /* renamed from: a */
    public static void m13461a(Object arg, String name) {
        if (arg == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Argument '");
            sb.append(name);
            sb.append("' cannot be null");
            throw new NullPointerException(sb.toString());
        }
    }

    /* renamed from: b */
    public static <T> void m13467b(Collection<T> container, String name) {
        if (container.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Container '");
            sb.append(name);
            sb.append("' cannot be empty");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    public static <T> void m13463a(Collection<T> container, String name) {
        m13461a((Object) container, name);
        for (T item : container) {
            if (item == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Container '");
                sb.append(name);
                sb.append("' cannot contain null values");
                throw new NullPointerException(sb.toString());
            }
        }
    }

    /* renamed from: c */
    public static <T> void m13469c(Collection<T> container, String name) {
        m13463a(container, name);
        m13467b(container, name);
    }

    /* renamed from: a */
    public static void m13462a(String arg, String name) {
        if (C6694S.m13436b(arg)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Argument '");
            sb.append(name);
            sb.append("' cannot be null or empty");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: c */
    public static void m13468c() {
        if (!C6787r.m13829s()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    /* renamed from: a */
    public static String m13459a() {
        String id = C6787r.m13816f();
        if (id != null) {
            return id;
        }
        throw new IllegalStateException("No App ID found, please set the App ID.");
    }

    /* renamed from: b */
    public static String m13465b() {
        String token = C6787r.m13820j();
        if (token != null) {
            return token;
        }
        throw new IllegalStateException("No Client Token found, please set the Client Token.");
    }

    /* renamed from: b */
    public static void m13466b(Context context, boolean shouldThrow) {
        m13461a((Object) context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            String str = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
            if (!shouldThrow) {
                Log.w(f12232a, str);
                return;
            }
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: a */
    public static void m13460a(Context context, boolean shouldThrow) {
        m13461a((Object) context, "context");
        PackageManager pm = context.getPackageManager();
        ActivityInfo activityInfo = null;
        if (pm != null) {
            try {
                activityInfo = pm.getActivityInfo(new ComponentName(context, "com.facebook.FacebookActivity"), 1);
            } catch (NameNotFoundException e) {
            }
        }
        if (activityInfo == null) {
            String str = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
            if (!shouldThrow) {
                Log.w(f12232a, str);
                return;
            }
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: a */
    public static boolean m13464a(Context context) {
        m13461a((Object) context, "context");
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> infos = null;
        if (pm != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            StringBuilder sb = new StringBuilder();
            sb.append("fb");
            sb.append(C6787r.m13816f());
            sb.append("://authorize");
            intent.setData(Uri.parse(sb.toString()));
            infos = pm.queryIntentActivities(intent, 64);
        }
        boolean hasActivity = false;
        if (infos != null) {
            for (ResolveInfo info : infos) {
                ActivityInfo activityInfo = info.activityInfo;
                if (!activityInfo.name.equals("com.facebook.CustomTabActivity") || !activityInfo.packageName.equals(context.getPackageName())) {
                    return false;
                }
                hasActivity = true;
            }
        }
        return hasActivity;
    }
}
