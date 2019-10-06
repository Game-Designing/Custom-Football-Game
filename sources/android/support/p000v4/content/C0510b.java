package android.support.p000v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.TypedValue;
import java.io.File;

/* renamed from: android.support.v4.content.b */
/* compiled from: ContextCompat */
public class C0510b {

    /* renamed from: a */
    private static final Object f1660a = new Object();

    /* renamed from: b */
    private static TypedValue f1661b;

    /* renamed from: a */
    public static boolean m2568a(Context context, Intent[] intents, Bundle options) {
        if (VERSION.SDK_INT >= 16) {
            context.startActivities(intents, options);
        } else {
            context.startActivities(intents);
        }
        return true;
    }

    /* renamed from: a */
    public static void m2567a(Context context, Intent intent, Bundle options) {
        if (VERSION.SDK_INT >= 16) {
            context.startActivity(intent, options);
        } else {
            context.startActivity(intent);
        }
    }

    /* renamed from: b */
    public static File[] m2571b(Context context, String type) {
        if (VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs(type);
        }
        return new File[]{context.getExternalFilesDir(type)};
    }

    /* renamed from: b */
    public static File[] m2570b(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return context.getExternalCacheDirs();
        }
        return new File[]{context.getExternalCacheDir()};
    }

    /* renamed from: c */
    public static Drawable m2572c(Context context, int id) {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            return context.getDrawable(id);
        }
        if (i >= 16) {
            return context.getResources().getDrawable(id);
        }
        synchronized (f1660a) {
            try {
                if (f1661b == null) {
                    f1661b = new TypedValue();
                }
                context.getResources().getValue(id, f1661b, true);
                int resolvedId = f1661b.resourceId;
                try {
                    return context.getResources().getDrawable(resolvedId);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    /* renamed from: b */
    public static ColorStateList m2569b(Context context, int id) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(id);
        }
        return context.getResources().getColorStateList(id);
    }

    /* renamed from: a */
    public static int m2564a(Context context, int id) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColor(id);
        }
        return context.getResources().getColor(id);
    }

    /* renamed from: a */
    public static int m2565a(Context context, String permission) {
        if (permission != null) {
            return context.checkPermission(permission, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    /* renamed from: a */
    public static Context m2566a(Context context) {
        if (VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext();
        }
        return null;
    }
}
