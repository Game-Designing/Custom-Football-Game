package p002b.p003c.p053g.p060e;

import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: b.c.g.e.a */
/* compiled from: ICUCompat */
public final class C1242a {

    /* renamed from: a */
    private static Method f4007a;

    /* renamed from: b */
    private static Method f4008b;

    static {
        String str = "addLikelySubtags";
        if (VERSION.SDK_INT >= 21) {
            try {
                f4008b = Class.forName("libcore.icu.ICU").getMethod(str, new Class[]{Locale.class});
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        } else {
            try {
                Class<?> clazz = Class.forName("libcore.icu.ICU");
                if (clazz != null) {
                    f4007a = clazz.getMethod("getScript", new Class[]{String.class});
                    f4008b = clazz.getMethod(str, new Class[]{String.class});
                }
            } catch (Exception e2) {
                f4007a = null;
                f4008b = null;
                Log.w("ICUCompat", e2);
            }
        }
    }

    /* renamed from: a */
    public static String m5864a(Locale locale) {
        String str = "ICUCompat";
        if (VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) f4008b.invoke(null, new Object[]{locale})).getScript();
            } catch (InvocationTargetException e) {
                Log.w(str, e);
                return locale.getScript();
            } catch (IllegalAccessException e2) {
                Log.w(str, e2);
                return locale.getScript();
            }
        } else {
            String localeWithSubtags = m5865b(locale);
            if (localeWithSubtags != null) {
                return m5863a(localeWithSubtags);
            }
            return null;
        }
    }

    /* renamed from: a */
    private static String m5863a(String localeStr) {
        String str = "ICUCompat";
        try {
            if (f4007a != null) {
                return (String) f4007a.invoke(null, new Object[]{localeStr});
            }
        } catch (IllegalAccessException e) {
            Log.w(str, e);
        } catch (InvocationTargetException e2) {
            Log.w(str, e2);
        }
        return null;
    }

    /* renamed from: b */
    private static String m5865b(Locale locale) {
        String str = "ICUCompat";
        String localeStr = locale.toString();
        try {
            if (f4008b != null) {
                return (String) f4008b.invoke(null, new Object[]{localeStr});
            }
        } catch (IllegalAccessException e) {
            Log.w(str, e);
        } catch (InvocationTargetException e2) {
            Log.w(str, e2);
        }
        return localeStr;
    }
}
