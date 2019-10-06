package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsLogger;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAnalyticsDebugLoggerFactory */
public final class ApplicationModule_ProvidesAnalyticsDebugLoggerFactory implements C13181b<AnalyticsLogger> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4725561537341026051L, "cm/aptoide/pt/ApplicationModule_ProvidesAnalyticsDebugLoggerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAnalyticsDebugLoggerFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public AnalyticsLogger get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        AnalyticsLogger providesAnalyticsDebugLogger = applicationModule.providesAnalyticsDebugLogger();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAnalyticsDebugLogger, "Cannot return null from a non-@Nullable @Provides method");
        AnalyticsLogger analyticsLogger = providesAnalyticsDebugLogger;
        $jacocoInit[3] = true;
        return analyticsLogger;
    }

    public static C13181b<AnalyticsLogger> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAnalyticsDebugLoggerFactory applicationModule_ProvidesAnalyticsDebugLoggerFactory = new ApplicationModule_ProvidesAnalyticsDebugLoggerFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAnalyticsDebugLoggerFactory;
    }

    public static AnalyticsLogger proxyProvidesAnalyticsDebugLogger(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsLogger providesAnalyticsDebugLogger = instance.providesAnalyticsDebugLogger();
        $jacocoInit[5] = true;
        return providesAnalyticsDebugLogger;
    }
}
