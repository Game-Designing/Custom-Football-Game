package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.EventLogger;
import p005cm.aptoide.analytics.implementation.loggers.AptoideBiEventLogger;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAptoideEventLoggerFactory */
public final class ApplicationModule_ProvidesAptoideEventLoggerFactory implements C13181b<EventLogger> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AptoideBiEventLogger> aptoideBiEventLoggerProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3793018928909013416L, "cm/aptoide/pt/ApplicationModule_ProvidesAptoideEventLoggerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAptoideEventLoggerFactory(ApplicationModule module2, Provider<AptoideBiEventLogger> aptoideBiEventLoggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.aptoideBiEventLoggerProvider = aptoideBiEventLoggerProvider2;
        $jacocoInit[0] = true;
    }

    public EventLogger get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AptoideBiEventLogger> provider = this.aptoideBiEventLoggerProvider;
        $jacocoInit[1] = true;
        EventLogger providesAptoideEventLogger = applicationModule.providesAptoideEventLogger((AptoideBiEventLogger) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAptoideEventLogger, "Cannot return null from a non-@Nullable @Provides method");
        EventLogger eventLogger = providesAptoideEventLogger;
        $jacocoInit[3] = true;
        return eventLogger;
    }

    public static C13181b<EventLogger> create(ApplicationModule module2, Provider<AptoideBiEventLogger> aptoideBiEventLoggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAptoideEventLoggerFactory applicationModule_ProvidesAptoideEventLoggerFactory = new ApplicationModule_ProvidesAptoideEventLoggerFactory(module2, aptoideBiEventLoggerProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAptoideEventLoggerFactory;
    }

    public static EventLogger proxyProvidesAptoideEventLogger(ApplicationModule instance, AptoideBiEventLogger aptoideBiEventLogger) {
        boolean[] $jacocoInit = $jacocoInit();
        EventLogger providesAptoideEventLogger = instance.providesAptoideEventLogger(aptoideBiEventLogger);
        $jacocoInit[5] = true;
        return providesAptoideEventLogger;
    }
}
