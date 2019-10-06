package com.inmobi.commons.p217a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.utilities.C10699c;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.inmobi.commons.a.a */
/* compiled from: SdkContext */
public final class C10619a {

    /* renamed from: a */
    private static final String f32345a = C10619a.class.getSimpleName();

    /* renamed from: b */
    private static final boolean f32346b = false;

    /* renamed from: c */
    private static Context f32347c;

    /* renamed from: d */
    private static String f32348d;

    /* renamed from: e */
    private static String f32349e;

    /* renamed from: f */
    private static AtomicBoolean f32350f = new AtomicBoolean();

    /* renamed from: g */
    private static boolean f32351g = false;

    static {
        "row".contains("staging");
        String str = "";
        f32348d = str;
        f32349e = str;
    }

    /* renamed from: a */
    public static void m34835a(Context context, String str) {
        if (!m34838a()) {
            f32347c = context.getApplicationContext();
            f32349e = str;
            f32350f.set(true);
            if (VERSION.SDK_INT < 17) {
                try {
                    f32348d = new WebView(context).getSettings().getUserAgentString();
                } catch (Exception e) {
                    f32347c = null;
                    new StringBuilder("SDK encountered an unexpected error in SdkContext.fetchWebviewUserAgent().handler() method; ").append(e.getMessage());
                }
            }
            m34850h();
        }
    }

    /* renamed from: a */
    public static boolean m34838a() {
        return f32347c != null;
    }

    /* renamed from: b */
    public static Context m34839b() {
        return f32347c;
    }

    /* renamed from: c */
    public static void m34844c() {
        f32347c = null;
    }

    /* renamed from: a */
    public static void m34837a(boolean z) {
        f32351g = z;
    }

    /* renamed from: d */
    public static boolean m34846d() {
        return f32351g;
    }

    /* renamed from: e */
    public static String m34847e() {
        return f32349e;
    }

    /* renamed from: f */
    public static String m34848f() {
        if (TextUtils.isEmpty(f32348d) && VERSION.SDK_INT >= 17) {
            f32348d = m34843c(f32347c);
        }
        return f32348d;
    }

    /* renamed from: g */
    public static boolean m34849g() {
        return f32350f.get();
    }

    /* renamed from: b */
    public static void m34841b(boolean z) {
        f32350f.set(z);
    }

    /* renamed from: a */
    public static File m34831a(Context context) {
        return new File(context.getFilesDir(), "im_cached_content");
    }

    /* renamed from: a */
    public static void m34836a(File file) {
        C10699c.m35140a(file);
    }

    @TargetApi(17)
    /* renamed from: c */
    private static String m34843c(Context context) {
        String str;
        String str2 = "";
        try {
            if (!f32346b) {
                return WebSettings.getDefaultUserAgent(context.getApplicationContext());
            }
            throw new Exception("android.util.AndroidRuntimeException: android.content.pm.PackageManager$NameNotFoundException: com.google.android.webview");
        } catch (Throwable th) {
            new StringBuilder("SDK encountered an unexpected error in getting user agent information; ").append(th.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(th));
            try {
                str = System.getProperty("http.agent");
                if (str == null) {
                    return str2;
                }
                return str;
            } catch (Exception e) {
                new StringBuilder("SDK encountered an unexpected error in getting property of http.agent; ").append(e.getMessage());
                C10621a.m34854a().mo34423a(new C10658a(e));
                str = str2;
            }
        }
    }

    /* renamed from: b */
    public static boolean m34842b(Context context, String str) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (VERSION.SDK_INT >= 23) {
            z = m34845c(context, str);
        } else if (packageManager.checkPermission(str, packageManager.getNameForUid(Binder.getCallingUid())) == 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    private static boolean m34845c(Context context, String str) {
        if (context == null || str == null) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), Opcodes.ACC_SYNTHETIC);
            if (packageInfo.requestedPermissions != null) {
                for (String equals : packageInfo.requestedPermissions) {
                    if (equals.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Could not check manifest for permission:");
            sb.append(str);
            sb.append(" Error:");
            sb.append(e.getLocalizedMessage());
        }
        return false;
    }

    /* renamed from: a */
    public static void m34833a(Context context, ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.getApplication().unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            activity.getApplication().registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    /* renamed from: a */
    public static void m34834a(Context context, Intent intent) {
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* renamed from: a */
    public static File m34832a(String str) {
        m34850h();
        File a = m34831a(f32347c);
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode() & MoPubClientPositioning.NO_REPEAT);
        StringBuilder sb = new StringBuilder();
        sb.append(valueOf);
        sb.append(String.valueOf(str.substring(length).hashCode() & MoPubClientPositioning.NO_REPEAT));
        return new File(a, sb.toString());
    }

    /* renamed from: b */
    public static void m34840b(Context context) {
        try {
            File file = new File(context.getCacheDir(), "im_cached_content");
            if (file.exists()) {
                C10699c.m35140a(file);
            }
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in clearOldMediaCacheDirectory; ").append(e.getMessage());
        }
    }

    /* renamed from: h */
    private static void m34850h() {
        File a = m34831a(f32347c);
        if (!a.mkdir()) {
            a.isDirectory();
        }
    }
}
