package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.EventLogger;
import p005cm.aptoide.analytics.implementation.loggers.FlurryEventLogger;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesFlurryEventLoggerFactory */
public final class ApplicationModule_ProvidesFlurryEventLoggerFactory implements C13181b<EventLogger> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<FlurryEventLogger> eventLoggerProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6316029680118715778L, "cm/aptoide/pt/ApplicationModule_ProvidesFlurryEventLoggerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesFlurryEventLoggerFactory(ApplicationModule module2, Provider<FlurryEventLogger> eventLoggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.eventLoggerProvider = eventLoggerProvider2;
        $jacocoInit[0] = true;
    }

    public EventLogger get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<FlurryEventLogger> provider = this.eventLoggerProvider;
        $jacocoInit[1] = true;
        EventLogger providesFlurryEventLogger = applicationModule.providesFlurryEventLogger((FlurryEventLogger) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesFlurryEventLogger, "Cannot return null from a non-@Nullable @Provides method");
        EventLogger eventLogger = providesFlurryEventLogger;
        $jacocoInit[3] = true;
        return eventLogger;
    }

    public static C13181b<EventLogger> create(ApplicationModule module2, Provider<FlurryEventLogger> eventLoggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesFlurryEventLoggerFactory applicationModule_ProvidesFlurryEventLoggerFactory = new ApplicationModule_ProvidesFlurryEventLoggerFactory(module2, eventLoggerProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesFlurryEventLoggerFactory;
    }

    public static EventLogger proxyProvidesFlurryEventLogger(ApplicationModule instance, FlurryEventLogger eventLogger) {
        boolean[] $jacocoInit = $jacocoInit();
        EventLogger providesFlurryEventLogger = instance.providesFlurryEventLogger(eventLogger);
        $jacocoInit[5] = true;
        return providesFlurryEventLogger;
    }
}
