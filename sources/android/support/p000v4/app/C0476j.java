package android.support.p000v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.app.j */
/* compiled from: BundleCompat */
public final class C0476j {

    /* renamed from: android.support.v4.app.j$a */
    /* compiled from: BundleCompat */
    static class C0477a {

        /* renamed from: a */
        private static Method f1606a;

        /* renamed from: b */
        private static boolean f1607b;

        /* renamed from: c */
        private static Method f1608c;

        /* renamed from: d */
        private static boolean f1609d;

        /* renamed from: a */
        public static IBinder m2417a(Bundle bundle, String key) {
            String str = "BundleCompatBaseImpl";
            if (!f1607b) {
                try {
                    f1606a = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    f1606a.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i(str, "Failed to retrieve getIBinder method", e);
                }
                f1607b = true;
            }
            Method method = f1606a;
            if (method != null) {
                try {
                    return (IBinder) method.invoke(bundle, new Object[]{key});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i(str, "Failed to invoke getIBinder via reflection", e2);
                    f1606a = null;
                }
            }
            return null;
        }

        /* renamed from: a */
        public static void m2418a(Bundle bundle, String key, IBinder binder) {
            String str = "BundleCompatBaseImpl";
            if (!f1609d) {
                try {
                    f1608c = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                    f1608c.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i(str, "Failed to retrieve putIBinder method", e);
                }
                f1609d = true;
            }
            Method method = f1608c;
            if (method != null) {
                try {
                    method.invoke(bundle, new Object[]{key, binder});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i(str, "Failed to invoke putIBinder via reflection", e2);
                    f1608c = null;
                }
            }
        }
    }

    /* renamed from: a */
    public static IBinder m2415a(Bundle bundle, String key) {
        if (VERSION.SDK_INT >= 18) {
            return bundle.getBinder(key);
        }
        return C0477a.m2417a(bundle, key);
    }

    /* renamed from: a */
    public static void m2416a(Bundle bundle, String key, IBinder binder) {
        if (VERSION.SDK_INT >= 18) {
            bundle.putBinder(key, binder);
        } else {
            C0477a.m2418a(bundle, key, binder);
        }
    }
}
