package p005cm.aptoide.p006pt;

import com.google.android.gms.safetynet.SafetyNetClient;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsLogger;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.p006pt.analytics.FirstLaunchAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesFirstLaunchAnalyticsFactory */
public final class ApplicationModule_ProvidesFirstLaunchAnalyticsFactory implements C13181b<FirstLaunchAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<AnalyticsLogger> loggerProvider;
    private final ApplicationModule module;
    private final Provider<SafetyNetClient> safetyNetClientProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5521490781324576619L, "cm/aptoide/pt/ApplicationModule_ProvidesFirstLaunchAnalyticsFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesFirstLaunchAnalyticsFactory(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<AnalyticsLogger> loggerProvider2, Provider<SafetyNetClient> safetyNetClientProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.loggerProvider = loggerProvider2;
        this.safetyNetClientProvider = safetyNetClientProvider2;
        $jacocoInit[0] = true;
    }

    public FirstLaunchAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AnalyticsManager> provider = this.analyticsManagerProvider;
        $jacocoInit[1] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider.get();
        AnalyticsLogger analyticsLogger = (AnalyticsLogger) this.loggerProvider.get();
        SafetyNetClient safetyNetClient = (SafetyNetClient) this.safetyNetClientProvider.get();
        $jacocoInit[2] = true;
        FirstLaunchAnalytics providesFirstLaunchAnalytics = applicationModule.providesFirstLaunchAnalytics(analyticsManager, analyticsLogger, safetyNetClient);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesFirstLaunchAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        FirstLaunchAnalytics firstLaunchAnalytics = providesFirstLaunchAnalytics;
        $jacocoInit[4] = true;
        return firstLaunchAnalytics;
    }

    public static C13181b<FirstLaunchAnalytics> create(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<AnalyticsLogger> loggerProvider2, Provider<SafetyNetClient> safetyNetClientProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesFirstLaunchAnalyticsFactory applicationModule_ProvidesFirstLaunchAnalyticsFactory = new ApplicationModule_ProvidesFirstLaunchAnalyticsFactory(module2, analyticsManagerProvider2, loggerProvider2, safetyNetClientProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvidesFirstLaunchAnalyticsFactory;
    }

    public static FirstLaunchAnalytics proxyProvidesFirstLaunchAnalytics(ApplicationModule instance, AnalyticsManager analyticsManager, AnalyticsLogger logger, SafetyNetClient safetyNetClient) {
        boolean[] $jacocoInit = $jacocoInit();
        FirstLaunchAnalytics providesFirstLaunchAnalytics = instance.providesFirstLaunchAnalytics(analyticsManager, logger, safetyNetClient);
        $jacocoInit[6] = true;
        return providesFirstLaunchAnalytics;
    }
}
