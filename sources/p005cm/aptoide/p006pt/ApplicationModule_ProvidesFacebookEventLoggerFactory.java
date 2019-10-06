package p005cm.aptoide.p006pt;

import com.facebook.p127a.C6638q;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsLogger;
import p005cm.aptoide.analytics.EventLogger;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesFacebookEventLoggerFactory */
public final class ApplicationModule_ProvidesFacebookEventLoggerFactory implements C13181b<EventLogger> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<C6638q> facebookProvider;
    private final Provider<AnalyticsLogger> loggerProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(141379070442376017L, "cm/aptoide/pt/ApplicationModule_ProvidesFacebookEventLoggerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesFacebookEventLoggerFactory(ApplicationModule module2, Provider<C6638q> facebookProvider2, Provider<AnalyticsLogger> loggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.facebookProvider = facebookProvider2;
        this.loggerProvider = loggerProvider2;
        $jacocoInit[0] = true;
    }

    public EventLogger get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<C6638q> provider = this.facebookProvider;
        $jacocoInit[1] = true;
        EventLogger providesFacebookEventLogger = applicationModule.providesFacebookEventLogger((C6638q) provider.get(), (AnalyticsLogger) this.loggerProvider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesFacebookEventLogger, "Cannot return null from a non-@Nullable @Provides method");
        EventLogger eventLogger = providesFacebookEventLogger;
        $jacocoInit[3] = true;
        return eventLogger;
    }

    public static C13181b<EventLogger> create(ApplicationModule module2, Provider<C6638q> facebookProvider2, Provider<AnalyticsLogger> loggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesFacebookEventLoggerFactory applicationModule_ProvidesFacebookEventLoggerFactory = new ApplicationModule_ProvidesFacebookEventLoggerFactory(module2, facebookProvider2, loggerProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesFacebookEventLoggerFactory;
    }

    public static EventLogger proxyProvidesFacebookEventLogger(ApplicationModule instance, C6638q facebook, AnalyticsLogger logger) {
        boolean[] $jacocoInit = $jacocoInit();
        EventLogger providesFacebookEventLogger = instance.providesFacebookEventLogger(facebook, logger);
        $jacocoInit[5] = true;
        return providesFacebookEventLogger;
    }
}
