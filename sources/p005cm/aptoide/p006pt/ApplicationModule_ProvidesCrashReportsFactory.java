package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesCrashReportsFactory */
public final class ApplicationModule_ProvidesCrashReportsFactory implements C13181b<CrashReport> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3641837089688948645L, "cm/aptoide/pt/ApplicationModule_ProvidesCrashReportsFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesCrashReportsFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public CrashReport get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        CrashReport providesCrashReports = applicationModule.providesCrashReports();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesCrashReports, "Cannot return null from a non-@Nullable @Provides method");
        CrashReport crashReport = providesCrashReports;
        $jacocoInit[3] = true;
        return crashReport;
    }

    public static C13181b<CrashReport> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesCrashReportsFactory applicationModule_ProvidesCrashReportsFactory = new ApplicationModule_ProvidesCrashReportsFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesCrashReportsFactory;
    }

    public static CrashReport proxyProvidesCrashReports(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport providesCrashReports = instance.providesCrashReports();
        $jacocoInit[5] = true;
        return providesCrashReports;
    }
}
