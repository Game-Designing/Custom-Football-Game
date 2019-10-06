package p005cm.aptoide.p006pt.crashreports;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.CrashLogger;
import p005cm.aptoide.p006pt.logger.Logger;

/* renamed from: cm.aptoide.pt.crashreports.ConsoleLogger */
public class ConsoleLogger implements CrashLogger {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = ConsoleLogger.class.getName();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5016233528226440479L, "cm/aptoide/pt/crashreports/ConsoleLogger", 6);
        $jacocoData = probes;
        return probes;
    }

    public ConsoleLogger() {
        $jacocoInit()[0] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[5] = true;
    }

    public void log(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        $jacocoInit[1] = true;
        instance.mo2141e(str, "Exception found", throwable);
        $jacocoInit[2] = true;
    }

    public void log(String key, String value) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("logString : key: ");
        sb.append(key);
        sb.append(" , value: ");
        sb.append(value);
        String sb2 = sb.toString();
        $jacocoInit[3] = true;
        instance.mo2148w(str, sb2);
        $jacocoInit[4] = true;
    }
}
