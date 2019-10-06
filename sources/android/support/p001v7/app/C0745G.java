package android.support.p001v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: android.support.v7.app.G */
/* compiled from: ResourcesFlusher */
class C0745G {

    /* renamed from: a */
    private static Field f2235a;

    /* renamed from: b */
    private static boolean f2236b;

    /* renamed from: c */
    private static Class f2237c;

    /* renamed from: d */
    private static boolean f2238d;

    /* renamed from: e */
    private static Field f2239e;

    /* renamed from: f */
    private static boolean f2240f;

    /* renamed from: g */
    private static Field f2241g;

    /* renamed from: h */
    private static boolean f2242h;

    /* renamed from: a */
    static boolean m3489a(Resources resources) {
        int i = VERSION.SDK_INT;
        if (i >= 24) {
            return m3493d(resources);
        }
        if (i >= 23) {
            return m3492c(resources);
        }
        if (i >= 21) {
            return m3491b(resources);
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m3491b(Resources resources) {
        String str = "ResourcesFlusher";
        if (!f2236b) {
            try {
                f2235a = Resources.class.getDeclaredField("mDrawableCache");
                f2235a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e(str, "Could not retrieve Resources#mDrawableCache field", e);
            }
            f2236b = true;
        }
        Field field = f2235a;
        if (field != null) {
            Map drawableCache = null;
            try {
                drawableCache = (Map) field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e(str, "Could not retrieve value from Resources#mDrawableCache", e2);
            }
            if (drawableCache != null) {
                drawableCache.clear();
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private static boolean m3492c(Resources resources) {
        String str = "ResourcesFlusher";
        if (!f2236b) {
            try {
                f2235a = Resources.class.getDeclaredField("mDrawableCache");
                f2235a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e(str, "Could not retrieve Resources#mDrawableCache field", e);
            }
            f2236b = true;
        }
        Object drawableCache = null;
        Field field = f2235a;
        if (field != null) {
            try {
                drawableCache = field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e(str, "Could not retrieve value from Resources#mDrawableCache", e2);
            }
        }
        boolean z = false;
        if (drawableCache == null) {
            return false;
        }
        if (drawableCache != null && m3490a(drawableCache)) {
            z = true;
        }
        return z;
    }

    /* renamed from: d */
    private static boolean m3493d(Resources resources) {
        String str = "ResourcesFlusher";
        boolean z = true;
        if (!f2242h) {
            try {
                f2241g = Resources.class.getDeclaredField("mResourcesImpl");
                f2241g.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e(str, "Could not retrieve Resources#mResourcesImpl field", e);
            }
            f2242h = true;
        }
        Field field = f2241g;
        if (field == null) {
            return false;
        }
        Object resourcesImpl = null;
        try {
            resourcesImpl = field.get(resources);
        } catch (IllegalAccessException e2) {
            Log.e(str, "Could not retrieve value from Resources#mResourcesImpl", e2);
        }
        if (resourcesImpl == null) {
            return false;
        }
        if (!f2236b) {
            try {
                f2235a = resourcesImpl.getClass().getDeclaredField("mDrawableCache");
                f2235a.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e(str, "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
            }
            f2236b = true;
        }
        Object drawableCache = null;
        Field field2 = f2235a;
        if (field2 != null) {
            try {
                drawableCache = field2.get(resourcesImpl);
            } catch (IllegalAccessException e4) {
                Log.e(str, "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
            }
        }
        if (drawableCache == null || !m3490a(drawableCache)) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m3490a(Object cache) {
        String str = "ResourcesFlusher";
        if (!f2238d) {
            try {
                f2237c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e(str, "Could not find ThemedResourceCache class", e);
            }
            f2238d = true;
        }
        Class cls = f2237c;
        if (cls == null) {
            return false;
        }
        if (!f2240f) {
            try {
                f2239e = cls.getDeclaredField("mUnthemedEntries");
                f2239e.setAccessible(true);
            } catch (NoSuchFieldException ee) {
                Log.e(str, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", ee);
            }
            f2240f = true;
        }
        Field field = f2239e;
        if (field == null) {
            return false;
        }
        LongSparseArray unthemedEntries = null;
        try {
            unthemedEntries = (LongSparseArray) field.get(cache);
        } catch (IllegalAccessException e2) {
            Log.e(str, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e2);
        }
        if (unthemedEntries == null) {
            return false;
        }
        unthemedEntries.clear();
        return true;
    }
}
