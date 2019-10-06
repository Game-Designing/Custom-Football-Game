package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.SessionLogger;
import p005cm.aptoide.analytics.implementation.loggers.FlurryEventLogger;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesFlurrySessionLoggerFactory */
public final class ApplicationModule_ProvidesFlurrySessionLoggerFactory implements C13181b<SessionLogger> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<FlurryEventLogger> eventLoggerProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8381619684395088771L, "cm/aptoide/pt/ApplicationModule_ProvidesFlurrySessionLoggerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesFlurrySessionLoggerFactory(ApplicationModule module2, Provider<FlurryEventLogger> eventLoggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.eventLoggerProvider = eventLoggerProvider2;
        $jacocoInit[0] = true;
    }

    public SessionLogger get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<FlurryEventLogger> provider = this.eventLoggerProvider;
        $jacocoInit[1] = true;
        SessionLogger providesFlurrySessionLogger = applicationModule.providesFlurrySessionLogger((FlurryEventLogger) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesFlurrySessionLogger, "Cannot return null from a non-@Nullable @Provides method");
        SessionLogger sessionLogger = providesFlurrySessionLogger;
        $jacocoInit[3] = true;
        return sessionLogger;
    }

    public static C13181b<SessionLogger> create(ApplicationModule module2, Provider<FlurryEventLogger> eventLoggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesFlurrySessionLoggerFactory applicationModule_ProvidesFlurrySessionLoggerFactory = new ApplicationModule_ProvidesFlurrySessionLoggerFactory(module2, eventLoggerProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesFlurrySessionLoggerFactory;
    }

    public static SessionLogger proxyProvidesFlurrySessionLogger(ApplicationModule instance, FlurryEventLogger eventLogger) {
        boolean[] $jacocoInit = $jacocoInit();
        SessionLogger providesFlurrySessionLogger = instance.providesFlurrySessionLogger(eventLogger);
        $jacocoInit[5] = true;
        return providesFlurrySessionLogger;
    }
}
