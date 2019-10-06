package p019d.p307j.p308a.p313e;

import android.util.Log;

/* renamed from: d.j.a.e.d */
/* compiled from: FileDownloadLog */
public class C13117d {

    /* renamed from: a */
    public static boolean f40139a = false;

    /* renamed from: a */
    public static void m42779a(Object o, Throwable e, String msg, Object... args) {
        m42777a(6, o, e, msg, args);
    }

    /* renamed from: b */
    public static void m42780b(Object o, String msg, Object... args) {
        m42776a(6, o, msg, args);
    }

    /* renamed from: c */
    public static void m42781c(Object o, String msg, Object... args) {
        m42776a(4, o, msg, args);
    }

    /* renamed from: a */
    public static void m42778a(Object o, String msg, Object... args) {
        m42776a(3, o, msg, args);
    }

    /* renamed from: e */
    public static void m42783e(Object o, String msg, Object... args) {
        m42776a(5, o, msg, args);
    }

    /* renamed from: d */
    public static void m42782d(Object o, String msg, Object... args) {
        m42776a(2, o, msg, args);
    }

    /* renamed from: a */
    private static void m42776a(int priority, Object o, String message, Object... args) {
        m42777a(priority, o, null, message, args);
    }

    /* renamed from: a */
    private static void m42777a(int priority, Object o, Throwable throwable, String message, Object... args) {
        if ((priority >= 5) || f40139a) {
            Log.println(priority, m42775a(o), C13121g.m42792a(message, args));
            if (throwable != null) {
                throwable.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static String m42775a(Object o) {
        StringBuilder sb = new StringBuilder();
        sb.append("FileDownloader.");
        sb.append((o instanceof Class ? (Class) o : o.getClass()).getSimpleName());
        return sb.toString();
    }
}
