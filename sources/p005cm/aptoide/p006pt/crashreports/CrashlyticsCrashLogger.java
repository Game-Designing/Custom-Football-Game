package p005cm.aptoide.p006pt.crashreports;

import com.crashlytics.android.C0075a;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.CrashLogger;

/* renamed from: cm.aptoide.pt.crashreports.CrashlyticsCrashLogger */
public class CrashlyticsCrashLogger implements CrashLogger {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String LANGUAGE = "Language";
    private static final String TAG = CrashlyticsCrashLogger.class.getName();
    private final C0075a crashlytics;
    private String language;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(83376801694064631L, "cm/aptoide/pt/crashreports/CrashlyticsCrashLogger", 8);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[7] = true;
    }

    public CrashlyticsCrashLogger(C0075a crashlytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashlytics = crashlytics2;
        $jacocoInit[0] = true;
    }

    public String getLanguage() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.language;
        $jacocoInit[1] = true;
        return str;
    }

    public void setLanguage(String language2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.language = language2;
        $jacocoInit[2] = true;
    }

    public void log(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        C0075a aVar = this.crashlytics;
        C0075a.m538a(LANGUAGE, this.language);
        $jacocoInit[3] = true;
        C0075a aVar2 = this.crashlytics;
        C0075a.m539a(throwable);
        $jacocoInit[4] = true;
    }

    public void log(String key, String value) {
        boolean[] $jacocoInit = $jacocoInit();
        C0075a aVar = this.crashlytics;
        C0075a.m538a(LANGUAGE, this.language);
        $jacocoInit[5] = true;
        C0075a aVar2 = this.crashlytics;
        C0075a.m538a(key, value);
        $jacocoInit[6] = true;
    }
}
