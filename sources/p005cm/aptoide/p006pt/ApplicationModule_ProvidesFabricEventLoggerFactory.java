package p005cm.aptoide.p006pt;

import com.crashlytics.android.p124a.C6378b;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsLogger;
import p005cm.aptoide.analytics.EventLogger;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesFabricEventLoggerFactory */
public final class ApplicationModule_ProvidesFabricEventLoggerFactory implements C13181b<EventLogger> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<C6378b> fabricProvider;
    private final Provider<AnalyticsLogger> loggerProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4185699285149884714L, "cm/aptoide/pt/ApplicationModule_ProvidesFabricEventLoggerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesFabricEventLoggerFactory(ApplicationModule module2, Provider<C6378b> fabricProvider2, Provider<AnalyticsLogger> loggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fabricProvider = fabricProvider2;
        this.loggerProvider = loggerProvider2;
        $jacocoInit[0] = true;
    }

    public EventLogger get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<C6378b> provider = this.fabricProvider;
        $jacocoInit[1] = true;
        EventLogger providesFabricEventLogger = applicationModule.providesFabricEventLogger((C6378b) provider.get(), (AnalyticsLogger) this.loggerProvider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesFabricEventLogger, "Cannot return null from a non-@Nullable @Provides method");
        EventLogger eventLogger = providesFabricEventLogger;
        $jacocoInit[3] = true;
        return eventLogger;
    }

    public static C13181b<EventLogger> create(ApplicationModule module2, Provider<C6378b> fabricProvider2, Provider<AnalyticsLogger> loggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesFabricEventLoggerFactory applicationModule_ProvidesFabricEventLoggerFactory = new ApplicationModule_ProvidesFabricEventLoggerFactory(module2, fabricProvider2, loggerProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesFabricEventLoggerFactory;
    }

    public static EventLogger proxyProvidesFabricEventLogger(ApplicationModule instance, C6378b fabric, AnalyticsLogger logger) {
        boolean[] $jacocoInit = $jacocoInit();
        EventLogger providesFabricEventLogger = instance.providesFabricEventLogger(fabric, logger);
        $jacocoInit[5] = true;
        return providesFabricEventLogger;
    }
}
