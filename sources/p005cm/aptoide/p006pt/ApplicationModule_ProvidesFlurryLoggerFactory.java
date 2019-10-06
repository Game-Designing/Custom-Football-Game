package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsLogger;
import p005cm.aptoide.analytics.implementation.loggers.FlurryEventLogger;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesFlurryLoggerFactory */
public final class ApplicationModule_ProvidesFlurryLoggerFactory implements C13181b<FlurryEventLogger> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsLogger> loggerProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7319629768894418581L, "cm/aptoide/pt/ApplicationModule_ProvidesFlurryLoggerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesFlurryLoggerFactory(ApplicationModule module2, Provider<AnalyticsLogger> loggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.loggerProvider = loggerProvider2;
        $jacocoInit[0] = true;
    }

    public FlurryEventLogger get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AnalyticsLogger> provider = this.loggerProvider;
        $jacocoInit[1] = true;
        FlurryEventLogger providesFlurryLogger = applicationModule.providesFlurryLogger((AnalyticsLogger) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesFlurryLogger, "Cannot return null from a non-@Nullable @Provides method");
        FlurryEventLogger flurryEventLogger = providesFlurryLogger;
        $jacocoInit[3] = true;
        return flurryEventLogger;
    }

    public static C13181b<FlurryEventLogger> create(ApplicationModule module2, Provider<AnalyticsLogger> loggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesFlurryLoggerFactory applicationModule_ProvidesFlurryLoggerFactory = new ApplicationModule_ProvidesFlurryLoggerFactory(module2, loggerProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesFlurryLoggerFactory;
    }

    public static FlurryEventLogger proxyProvidesFlurryLogger(ApplicationModule instance, AnalyticsLogger logger) {
        boolean[] $jacocoInit = $jacocoInit();
        FlurryEventLogger providesFlurryLogger = instance.providesFlurryLogger(logger);
        $jacocoInit[5] = true;
        return providesFlurryLogger;
    }
}
