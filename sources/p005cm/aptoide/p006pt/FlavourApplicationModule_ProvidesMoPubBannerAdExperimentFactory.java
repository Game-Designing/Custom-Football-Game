package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.abtesting.ABTestManager;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubBannerAdExperiment;
import p005cm.aptoide.p006pt.ads.MoPubAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.FlavourApplicationModule_ProvidesMoPubBannerAdExperimentFactory */
public final class FlavourApplicationModule_ProvidesMoPubBannerAdExperimentFactory implements C13181b<MoPubBannerAdExperiment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<ABTestManager> abTestManagerProvider;
    private final Provider<MoPubAnalytics> moPubAnalyticsProvider;
    private final FlavourApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1612458783650322544L, "cm/aptoide/pt/FlavourApplicationModule_ProvidesMoPubBannerAdExperimentFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public FlavourApplicationModule_ProvidesMoPubBannerAdExperimentFactory(FlavourApplicationModule module2, Provider<ABTestManager> abTestManagerProvider2, Provider<MoPubAnalytics> moPubAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.abTestManagerProvider = abTestManagerProvider2;
        this.moPubAnalyticsProvider = moPubAnalyticsProvider2;
        $jacocoInit[0] = true;
    }

    public MoPubBannerAdExperiment get() {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule flavourApplicationModule = this.module;
        Provider<ABTestManager> provider = this.abTestManagerProvider;
        $jacocoInit[1] = true;
        ABTestManager aBTestManager = (ABTestManager) provider.get();
        MoPubAnalytics moPubAnalytics = (MoPubAnalytics) this.moPubAnalyticsProvider.get();
        $jacocoInit[2] = true;
        MoPubBannerAdExperiment providesMoPubBannerAdExperiment = flavourApplicationModule.providesMoPubBannerAdExperiment(aBTestManager, moPubAnalytics);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesMoPubBannerAdExperiment, "Cannot return null from a non-@Nullable @Provides method");
        MoPubBannerAdExperiment moPubBannerAdExperiment = providesMoPubBannerAdExperiment;
        $jacocoInit[4] = true;
        return moPubBannerAdExperiment;
    }

    public static C13181b<MoPubBannerAdExperiment> create(FlavourApplicationModule module2, Provider<ABTestManager> abTestManagerProvider2, Provider<MoPubAnalytics> moPubAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule_ProvidesMoPubBannerAdExperimentFactory flavourApplicationModule_ProvidesMoPubBannerAdExperimentFactory = new FlavourApplicationModule_ProvidesMoPubBannerAdExperimentFactory(module2, abTestManagerProvider2, moPubAnalyticsProvider2);
        $jacocoInit[5] = true;
        return flavourApplicationModule_ProvidesMoPubBannerAdExperimentFactory;
    }

    public static MoPubBannerAdExperiment proxyProvidesMoPubBannerAdExperiment(FlavourApplicationModule instance, ABTestManager abTestManager, MoPubAnalytics moPubAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        MoPubBannerAdExperiment providesMoPubBannerAdExperiment = instance.providesMoPubBannerAdExperiment(abTestManager, moPubAnalytics);
        $jacocoInit[6] = true;
        return providesMoPubBannerAdExperiment;
    }
}
