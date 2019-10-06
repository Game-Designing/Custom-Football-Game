package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import com.crashlytics.android.C0075a;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsLogger;
import p005cm.aptoide.analytics.implementation.AptoideBiEventService;
import p005cm.aptoide.analytics.implementation.EventsPersistence;
import p005cm.aptoide.analytics.implementation.loggers.AptoideBiEventLogger;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAptoideBILoggerFactory */
public final class ApplicationModule_ProvidesAptoideBILoggerFactory implements C13181b<AptoideBiEventLogger> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<C0075a> crashlyticsProvider;
    private final Provider<AnalyticsLogger> debugLoggerProvider;
    private final ApplicationModule module;
    private final Provider<EventsPersistence> persistenceProvider;
    private final Provider<SharedPreferences> preferencesProvider;
    private final Provider<AptoideBiEventService> serviceProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1376028365734125023L, "cm/aptoide/pt/ApplicationModule_ProvidesAptoideBILoggerFactory", 12);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAptoideBILoggerFactory(ApplicationModule module2, Provider<EventsPersistence> persistenceProvider2, Provider<AptoideBiEventService> serviceProvider2, Provider<C0075a> crashlyticsProvider2, Provider<SharedPreferences> preferencesProvider2, Provider<AnalyticsLogger> debugLoggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.persistenceProvider = persistenceProvider2;
        this.serviceProvider = serviceProvider2;
        this.crashlyticsProvider = crashlyticsProvider2;
        this.preferencesProvider = preferencesProvider2;
        this.debugLoggerProvider = debugLoggerProvider2;
        $jacocoInit[0] = true;
    }

    public AptoideBiEventLogger get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<EventsPersistence> provider = this.persistenceProvider;
        $jacocoInit[1] = true;
        EventsPersistence eventsPersistence = (EventsPersistence) provider.get();
        Provider<AptoideBiEventService> provider2 = this.serviceProvider;
        $jacocoInit[2] = true;
        AptoideBiEventService aptoideBiEventService = (AptoideBiEventService) provider2.get();
        Provider<C0075a> provider3 = this.crashlyticsProvider;
        $jacocoInit[3] = true;
        C0075a aVar = (C0075a) provider3.get();
        Provider<SharedPreferences> provider4 = this.preferencesProvider;
        $jacocoInit[4] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider4.get();
        Provider<AnalyticsLogger> provider5 = this.debugLoggerProvider;
        $jacocoInit[5] = true;
        AnalyticsLogger analyticsLogger = (AnalyticsLogger) provider5.get();
        $jacocoInit[6] = true;
        AptoideBiEventLogger providesAptoideBILogger = applicationModule.providesAptoideBILogger(eventsPersistence, aptoideBiEventService, aVar, sharedPreferences, analyticsLogger);
        $jacocoInit[7] = true;
        C13182c.m43111a(providesAptoideBILogger, "Cannot return null from a non-@Nullable @Provides method");
        AptoideBiEventLogger aptoideBiEventLogger = providesAptoideBILogger;
        $jacocoInit[8] = true;
        return aptoideBiEventLogger;
    }

    public static C13181b<AptoideBiEventLogger> create(ApplicationModule module2, Provider<EventsPersistence> persistenceProvider2, Provider<AptoideBiEventService> serviceProvider2, Provider<C0075a> crashlyticsProvider2, Provider<SharedPreferences> preferencesProvider2, Provider<AnalyticsLogger> debugLoggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAptoideBILoggerFactory applicationModule_ProvidesAptoideBILoggerFactory = new ApplicationModule_ProvidesAptoideBILoggerFactory(module2, persistenceProvider2, serviceProvider2, crashlyticsProvider2, preferencesProvider2, debugLoggerProvider2);
        $jacocoInit[9] = true;
        return applicationModule_ProvidesAptoideBILoggerFactory;
    }

    public static AptoideBiEventLogger proxyProvidesAptoideBILogger(ApplicationModule instance, EventsPersistence persistence, AptoideBiEventService service, C0075a crashlytics, SharedPreferences preferences, AnalyticsLogger debugLogger) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideBiEventLogger providesAptoideBILogger = instance.providesAptoideBILogger(persistence, service, crashlytics, preferences, debugLogger);
        $jacocoInit[10] = true;
        return providesAptoideBILogger;
    }
}
