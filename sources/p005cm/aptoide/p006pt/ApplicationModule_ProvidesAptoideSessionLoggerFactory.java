package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.SessionLogger;
import p005cm.aptoide.analytics.implementation.loggers.AptoideBiEventLogger;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAptoideSessionLoggerFactory */
public final class ApplicationModule_ProvidesAptoideSessionLoggerFactory implements C13181b<SessionLogger> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AptoideBiEventLogger> aptoideBiEventLoggerProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2634020342333005011L, "cm/aptoide/pt/ApplicationModule_ProvidesAptoideSessionLoggerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAptoideSessionLoggerFactory(ApplicationModule module2, Provider<AptoideBiEventLogger> aptoideBiEventLoggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.aptoideBiEventLoggerProvider = aptoideBiEventLoggerProvider2;
        $jacocoInit[0] = true;
    }

    public SessionLogger get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AptoideBiEventLogger> provider = this.aptoideBiEventLoggerProvider;
        $jacocoInit[1] = true;
        SessionLogger providesAptoideSessionLogger = applicationModule.providesAptoideSessionLogger((AptoideBiEventLogger) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAptoideSessionLogger, "Cannot return null from a non-@Nullable @Provides method");
        SessionLogger sessionLogger = providesAptoideSessionLogger;
        $jacocoInit[3] = true;
        return sessionLogger;
    }

    public static C13181b<SessionLogger> create(ApplicationModule module2, Provider<AptoideBiEventLogger> aptoideBiEventLoggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAptoideSessionLoggerFactory applicationModule_ProvidesAptoideSessionLoggerFactory = new ApplicationModule_ProvidesAptoideSessionLoggerFactory(module2, aptoideBiEventLoggerProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAptoideSessionLoggerFactory;
    }

    public static SessionLogger proxyProvidesAptoideSessionLogger(ApplicationModule instance, AptoideBiEventLogger aptoideBiEventLogger) {
        boolean[] $jacocoInit = $jacocoInit();
        SessionLogger providesAptoideSessionLogger = instance.providesAptoideSessionLogger(aptoideBiEventLogger);
        $jacocoInit[5] = true;
        return providesAptoideSessionLogger;
    }
}
