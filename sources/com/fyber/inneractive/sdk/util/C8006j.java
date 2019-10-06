package com.fyber.inneractive.sdk.util;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.fyber.inneractive.sdk.util.j */
public class C8006j {

    /* renamed from: a */
    protected static Context f16335a;

    /* renamed from: com.fyber.inneractive.sdk.util.j$a */
    private static class C8008a {

        /* renamed from: a */
        private static Map<String, String> f16337a = new HashMap();

        /* renamed from: a */
        public static String m18082a(String str) {
            String str2 = (String) f16337a.get(str);
            if (TextUtils.isEmpty(str2)) {
                StringBuilder sb = new StringBuilder("Assets cache: reading file: ");
                sb.append(str);
                IAlog.m18021b(sb.toString());
                try {
                    str2 = C8017o.m18095a(C8006j.f16335a.getAssets().open(str, 3));
                    StringBuilder sb2 = new StringBuilder("Assets cache: success - ");
                    sb2.append(str);
                    IAlog.m18021b(sb2.toString());
                } catch (IOException e) {
                    IAlog.m18021b("Assets cache: Could not read response from file");
                    IAlog.m18019a(C8017o.m18096a((Throwable) e));
                }
                if (!TextUtils.isEmpty(str2)) {
                    f16337a.put(str, str2);
                }
            } else {
                StringBuilder sb3 = new StringBuilder("Assets cache: returning cached assets for ");
                sb3.append(str);
                IAlog.m18021b(sb3.toString());
            }
            return str2;
        }

        /* renamed from: a */
        static void m18083a() {
            f16337a.clear();
        }
    }

    /* renamed from: n */
    public static Context m18075n() {
        return f16335a;
    }

    /* renamed from: a */
    public static void m18069a(Context context) {
        f16335a = context;
    }

    /* renamed from: o */
    public static void m18076o() {
        C8008a.m18083a();
        f16335a = null;
    }

    /* renamed from: a */
    public static int m18066a(int i) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) f16335a.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return (int) ((((float) i) / displayMetrics.density) + 0.5f);
    }

    /* renamed from: b */
    public static int m18072b(int i) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) f16335a.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return (int) ((((float) i) * displayMetrics.density) + 0.5f);
    }

    /* renamed from: q */
    public static int m18078q() {
        int i = f16335a.getResources().getConfiguration().orientation;
        StringBuilder sb = new StringBuilder("The device orientation: ");
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        sb.append(z);
        IAlog.m18021b(sb.toString() != null ? "portait" : "landscape");
        return i;
    }

    /* renamed from: a */
    public static void m18071a(View view, Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* renamed from: r */
    public static void m18079r() {
        if (VERSION.SDK_INT < 21) {
            CookieSyncManager.getInstance().startSync();
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    public static Drawable m18074c(int i) {
        if (VERSION.SDK_INT >= 21) {
            return f16335a.getDrawable(i);
        }
        return f16335a.getResources().getDrawable(i);
    }

    /* renamed from: a */
    public static List<ResolveInfo> m18068a(Context context, Uri uri) {
        return context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", uri), 32);
    }

    /* renamed from: a */
    public static Intent m18067a(Context context, List<ResolveInfo> list, Uri uri, String str) {
        Intent intent;
        ActivityNotFoundException e;
        Exception e2;
        Intent intent2 = null;
        if (list != null && !list.isEmpty()) {
            for (ResolveInfo resolveInfo : list) {
                if (resolveInfo.activityInfo.packageName.equalsIgnoreCase(str)) {
                    try {
                        intent = new Intent("android.intent.action.VIEW", uri);
                        try {
                            intent.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                            if (context instanceof Application) {
                                intent.setFlags(268435456);
                            }
                            IAlog.m18021b("IAJavaUtil: getValidResolverIntent: found google play package");
                            return intent;
                        } catch (ActivityNotFoundException e3) {
                            e = e3;
                            e.printStackTrace();
                            intent2 = intent;
                        } catch (Exception e4) {
                            e2 = e4;
                            e2.printStackTrace();
                            intent2 = intent;
                        }
                    } catch (ActivityNotFoundException e5) {
                        intent = intent2;
                        e = e5;
                        e.printStackTrace();
                        intent2 = intent;
                    } catch (Exception e6) {
                        intent = intent2;
                        e2 = e6;
                        e2.printStackTrace();
                        intent2 = intent;
                    }
                }
            }
        }
        return intent2;
    }

    /* renamed from: a */
    public static <P> void m18070a(AsyncTask<P, ?, ?> asyncTask, P... pArr) {
        if (VERSION.SDK_INT < 11) {
            asyncTask.execute(pArr);
        } else {
            asyncTask.executeOnExecutor(C8009k.f16338a, pArr);
        }
    }

    /* renamed from: a */
    public static int m18065a(float f) {
        return (int) (TypedValue.applyDimension(1, f, f16335a.getResources().getDisplayMetrics()) + 0.5f);
    }

    /* renamed from: p */
    public static int m18077p() {
        return ((WindowManager) f16335a.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    /* renamed from: b */
    public static boolean m18073b(String str) {
        return f16335a.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: s */
    public static int m18080s() {
        Display defaultDisplay = ((WindowManager) f16335a.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT < 13) {
            return defaultDisplay.getHeight();
        }
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    /* renamed from: t */
    public static int m18081t() {
        Display defaultDisplay = ((WindowManager) f16335a.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT < 13) {
            return defaultDisplay.getWidth();
        }
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }
}
