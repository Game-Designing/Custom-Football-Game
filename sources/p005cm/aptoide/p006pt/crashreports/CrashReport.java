package p005cm.aptoide.p006pt.crashreports;

import android.util.Log;
import java.util.ArrayList;
import p005cm.aptoide.analytics.implementation.CrashLogger;

/* renamed from: cm.aptoide.pt.crashreports.CrashReport */
public class CrashReport implements CrashLogger {
    private static final String TAG = CrashReport.class.getName();
    private static CrashReport singleton = new CrashReport();
    private ArrayList<CrashLogger> crashLoggers = new ArrayList<>();

    private CrashReport() {
    }

    public static CrashReport getInstance() {
        return singleton;
    }

    public CrashReport addLogger(CrashLogger crashLogger) {
        this.crashLoggers.add(crashLogger);
        return this;
    }

    public void log(Throwable throwable) {
        if (!isInitialized()) {
            Log.e(TAG, "not initialized");
            return;
        }
        for (int i = 0; i < this.crashLoggers.size(); i++) {
            ((CrashLogger) this.crashLoggers.get(i)).log(throwable);
        }
    }

    public void log(String key, String value) {
        if (!isInitialized()) {
            Log.e(TAG, "not initialized");
            return;
        }
        for (int i = 0; i < this.crashLoggers.size(); i++) {
            ((CrashLogger) this.crashLoggers.get(i)).log(key, value);
        }
    }

    private boolean isInitialized() {
        ArrayList<CrashLogger> arrayList = this.crashLoggers;
        return arrayList != null && !arrayList.isEmpty();
    }

    public CrashLogger getLogger(Class<? extends CrashLogger> clazz) {
        if (!isInitialized()) {
            Log.e(TAG, "not initialized");
            return null;
        }
        for (int i = 0; i < this.crashLoggers.size(); i++) {
            if (clazz.isAssignableFrom(((CrashLogger) this.crashLoggers.get(i)).getClass())) {
                return (CrashLogger) this.crashLoggers.get(i);
            }
        }
        return null;
    }
}
