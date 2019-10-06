package p005cm.aptoide.p006pt;

import java.util.Collection;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsLogger;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.EventLogger;
import p005cm.aptoide.analytics.SessionLogger;
import p005cm.aptoide.analytics.implementation.loggers.HttpKnockEventLogger;
import p005cm.aptoide.analytics.implementation.utils.AnalyticsEventParametersNormalizer;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAnalyticsManagerFactory */
public final class ApplicationModule_ProvidesAnalyticsManagerFactory implements C13181b<AnalyticsManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsEventParametersNormalizer> analyticsNormalizerProvider;
    private final Provider<EventLogger> aptoideBiEventLoggerProvider;
    private final Provider<Collection<String>> aptoideEventsProvider;
    private final Provider<SessionLogger> aptoideSessionLoggerProvider;
    private final Provider<EventLogger> fabricEventLoggerProvider;
    private final Provider<Collection<String>> fabricEventsProvider;
    private final Provider<EventLogger> facebookEventLoggerProvider;
    private final Provider<Collection<String>> facebookEventsProvider;
    private final Provider<EventLogger> flurryEventLoggerProvider;
    private final Provider<Collection<String>> flurryEventsProvider;
    private final Provider<SessionLogger> flurrySessionLoggerProvider;
    private final Provider<HttpKnockEventLogger> knockEventLoggerProvider;
    private final Provider<AnalyticsLogger> loggerProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7821080762389643510L, "cm/aptoide/pt/ApplicationModule_ProvidesAnalyticsManagerFactory", 20);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAnalyticsManagerFactory(ApplicationModule module2, Provider<EventLogger> aptoideBiEventLoggerProvider2, Provider<EventLogger> facebookEventLoggerProvider2, Provider<EventLogger> fabricEventLoggerProvider2, Provider<EventLogger> flurryEventLoggerProvider2, Provider<HttpKnockEventLogger> knockEventLoggerProvider2, Provider<Collection<String>> aptoideEventsProvider2, Provider<Collection<String>> facebookEventsProvider2, Provider<Collection<String>> fabricEventsProvider2, Provider<Collection<String>> flurryEventsProvider2, Provider<SessionLogger> flurrySessionLoggerProvider2, Provider<SessionLogger> aptoideSessionLoggerProvider2, Provider<AnalyticsEventParametersNormalizer> analyticsNormalizerProvider2, Provider<AnalyticsLogger> loggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.aptoideBiEventLoggerProvider = aptoideBiEventLoggerProvider2;
        this.facebookEventLoggerProvider = facebookEventLoggerProvider2;
        this.fabricEventLoggerProvider = fabricEventLoggerProvider2;
        this.flurryEventLoggerProvider = flurryEventLoggerProvider2;
        this.knockEventLoggerProvider = knockEventLoggerProvider2;
        this.aptoideEventsProvider = aptoideEventsProvider2;
        this.facebookEventsProvider = facebookEventsProvider2;
        this.fabricEventsProvider = fabricEventsProvider2;
        this.flurryEventsProvider = flurryEventsProvider2;
        this.flurrySessionLoggerProvider = flurrySessionLoggerProvider2;
        this.aptoideSessionLoggerProvider = aptoideSessionLoggerProvider2;
        this.analyticsNormalizerProvider = analyticsNormalizerProvider2;
        this.loggerProvider = loggerProvider2;
        $jacocoInit[0] = true;
    }

    public AnalyticsManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<EventLogger> provider = this.aptoideBiEventLoggerProvider;
        $jacocoInit[1] = true;
        EventLogger eventLogger = (EventLogger) provider.get();
        Provider<EventLogger> provider2 = this.facebookEventLoggerProvider;
        $jacocoInit[2] = true;
        EventLogger eventLogger2 = (EventLogger) provider2.get();
        Provider<EventLogger> provider3 = this.fabricEventLoggerProvider;
        $jacocoInit[3] = true;
        EventLogger eventLogger3 = (EventLogger) provider3.get();
        Provider<EventLogger> provider4 = this.flurryEventLoggerProvider;
        $jacocoInit[4] = true;
        EventLogger eventLogger4 = (EventLogger) provider4.get();
        Provider<HttpKnockEventLogger> provider5 = this.knockEventLoggerProvider;
        $jacocoInit[5] = true;
        HttpKnockEventLogger httpKnockEventLogger = (HttpKnockEventLogger) provider5.get();
        Provider<Collection<String>> provider6 = this.aptoideEventsProvider;
        $jacocoInit[6] = true;
        Collection collection = (Collection) provider6.get();
        Provider<Collection<String>> provider7 = this.facebookEventsProvider;
        $jacocoInit[7] = true;
        Collection collection2 = (Collection) provider7.get();
        Provider<Collection<String>> provider8 = this.fabricEventsProvider;
        $jacocoInit[8] = true;
        Collection collection3 = (Collection) provider8.get();
        Provider<Collection<String>> provider9 = this.flurryEventsProvider;
        $jacocoInit[9] = true;
        Collection collection4 = (Collection) provider9.get();
        Provider<SessionLogger> provider10 = this.flurrySessionLoggerProvider;
        $jacocoInit[10] = true;
        SessionLogger sessionLogger = (SessionLogger) provider10.get();
        Provider<SessionLogger> provider11 = this.aptoideSessionLoggerProvider;
        $jacocoInit[11] = true;
        SessionLogger sessionLogger2 = (SessionLogger) provider11.get();
        Provider<AnalyticsEventParametersNormalizer> provider12 = this.analyticsNormalizerProvider;
        $jacocoInit[12] = true;
        AnalyticsEventParametersNormalizer analyticsEventParametersNormalizer = (AnalyticsEventParametersNormalizer) provider12.get();
        Provider<AnalyticsLogger> provider13 = this.loggerProvider;
        $jacocoInit[13] = true;
        AnalyticsLogger analyticsLogger = (AnalyticsLogger) provider13.get();
        $jacocoInit[14] = true;
        AnalyticsManager providesAnalyticsManager = applicationModule.providesAnalyticsManager(eventLogger, eventLogger2, eventLogger3, eventLogger4, httpKnockEventLogger, collection, collection2, collection3, collection4, sessionLogger, sessionLogger2, analyticsEventParametersNormalizer, analyticsLogger);
        $jacocoInit[15] = true;
        C13182c.m43111a(providesAnalyticsManager, "Cannot return null from a non-@Nullable @Provides method");
        AnalyticsManager analyticsManager = providesAnalyticsManager;
        $jacocoInit[16] = true;
        return analyticsManager;
    }

    public static C13181b<AnalyticsManager> create(ApplicationModule module2, Provider<EventLogger> aptoideBiEventLoggerProvider2, Provider<EventLogger> facebookEventLoggerProvider2, Provider<EventLogger> fabricEventLoggerProvider2, Provider<EventLogger> flurryEventLoggerProvider2, Provider<HttpKnockEventLogger> knockEventLoggerProvider2, Provider<Collection<String>> aptoideEventsProvider2, Provider<Collection<String>> facebookEventsProvider2, Provider<Collection<String>> fabricEventsProvider2, Provider<Collection<String>> flurryEventsProvider2, Provider<SessionLogger> flurrySessionLoggerProvider2, Provider<SessionLogger> aptoideSessionLoggerProvider2, Provider<AnalyticsEventParametersNormalizer> analyticsNormalizerProvider2, Provider<AnalyticsLogger> loggerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAnalyticsManagerFactory applicationModule_ProvidesAnalyticsManagerFactory = new ApplicationModule_ProvidesAnalyticsManagerFactory(module2, aptoideBiEventLoggerProvider2, facebookEventLoggerProvider2, fabricEventLoggerProvider2, flurryEventLoggerProvider2, knockEventLoggerProvider2, aptoideEventsProvider2, facebookEventsProvider2, fabricEventsProvider2, flurryEventsProvider2, flurrySessionLoggerProvider2, aptoideSessionLoggerProvider2, analyticsNormalizerProvider2, loggerProvider2);
        $jacocoInit[17] = true;
        return applicationModule_ProvidesAnalyticsManagerFactory;
    }

    public static AnalyticsManager proxyProvidesAnalyticsManager(ApplicationModule instance, EventLogger aptoideBiEventLogger, EventLogger facebookEventLogger, EventLogger fabricEventLogger, EventLogger flurryEventLogger, HttpKnockEventLogger knockEventLogger, Collection<String> aptoideEvents, Collection<String> facebookEvents, Collection<String> fabricEvents, Collection<String> flurryEvents, SessionLogger flurrySessionLogger, SessionLogger aptoideSessionLogger, AnalyticsEventParametersNormalizer analyticsNormalizer, AnalyticsLogger logger) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager providesAnalyticsManager = instance.providesAnalyticsManager(aptoideBiEventLogger, facebookEventLogger, fabricEventLogger, flurryEventLogger, knockEventLogger, aptoideEvents, facebookEvents, fabricEvents, flurryEvents, flurrySessionLogger, aptoideSessionLogger, analyticsNormalizer, logger);
        $jacocoInit[18] = true;
        return providesAnalyticsManager;
    }
}
