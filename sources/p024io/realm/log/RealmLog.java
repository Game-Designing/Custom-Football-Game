package p024io.realm.log;

import android.util.Log;
import java.util.Locale;

/* renamed from: io.realm.log.RealmLog */
public final class RealmLog {

    /* renamed from: a */
    private static String f14334a = "REALM_JAVA";

    private static native int nativeGetLogLevel();

    private static native void nativeLog(int i, String str, Throwable th, String str2);

    /* renamed from: a */
    public static int m16232a() {
        return nativeGetLogLevel();
    }

    /* renamed from: a */
    public static void m16234a(String message, Object... args) {
        m16235a(null, message, args);
    }

    /* renamed from: a */
    public static void m16235a(Throwable throwable, String message, Object... args) {
        m16233a(3, throwable, message, args);
    }

    /* renamed from: c */
    public static void m16238c(String message, Object... args) {
        m16239c(null, message, args);
    }

    /* renamed from: c */
    public static void m16239c(Throwable throwable, String message, Object... args) {
        m16233a(5, throwable, message, args);
    }

    /* renamed from: b */
    public static void m16236b(String message, Object... args) {
        m16237b(null, message, args);
    }

    /* renamed from: b */
    public static void m16237b(Throwable throwable, String message, Object... args) {
        m16233a(7, throwable, message, args);
    }

    /* renamed from: a */
    private static void m16233a(int level, Throwable throwable, String message, Object... args) {
        if (level >= m16232a()) {
            StringBuilder stringBuilder = new StringBuilder();
            if (args != null && args.length > 0) {
                message = String.format(Locale.US, message, args);
            }
            if (throwable != null) {
                stringBuilder.append(Log.getStackTraceString(throwable));
            }
            if (message != null) {
                if (throwable != null) {
                    stringBuilder.append("\n");
                }
                stringBuilder.append(message);
            }
            nativeLog(level, f14334a, throwable, stringBuilder.toString());
        }
    }
}
