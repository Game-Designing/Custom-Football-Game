package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.p006pt.app.CampaignAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesCampaignAnalyticsFactory */
public final class ApplicationModule_ProvidesCampaignAnalyticsFactory implements C13181b<CampaignAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(332997403680580137L, "cm/aptoide/pt/ApplicationModule_ProvidesCampaignAnalyticsFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesCampaignAnalyticsFactory(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        $jacocoInit[0] = true;
    }

    public CampaignAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AnalyticsManager> provider = this.analyticsManagerProvider;
        $jacocoInit[1] = true;
        CampaignAnalytics providesCampaignAnalytics = applicationModule.providesCampaignAnalytics((AnalyticsManager) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesCampaignAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        CampaignAnalytics campaignAnalytics = providesCampaignAnalytics;
        $jacocoInit[3] = true;
        return campaignAnalytics;
    }

    public static C13181b<CampaignAnalytics> create(ApplicationModule module2, Provider<AnalyticsManager> analyticsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesCampaignAnalyticsFactory applicationModule_ProvidesCampaignAnalyticsFactory = new ApplicationModule_ProvidesCampaignAnalyticsFactory(module2, analyticsManagerProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesCampaignAnalyticsFactory;
    }

    public static CampaignAnalytics proxyProvidesCampaignAnalytics(ApplicationModule instance, AnalyticsManager analyticsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        CampaignAnalytics providesCampaignAnalytics = instance.providesCampaignAnalytics(analyticsManager);
        $jacocoInit[5] = true;
        return providesCampaignAnalytics;
    }
}
