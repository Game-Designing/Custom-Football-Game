package p005cm.aptoide.analytics.implementation;

/* renamed from: cm.aptoide.analytics.implementation.CrashLogger */
public interface CrashLogger {
    void log(String str, String str2);

    void log(Throwable th);
}
