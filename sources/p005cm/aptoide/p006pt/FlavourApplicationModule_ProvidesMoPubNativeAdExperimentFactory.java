package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.abtesting.ABTestManager;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubNativeAdExperiment;
import p005cm.aptoide.p006pt.ads.MoPubAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.FlavourApplicationModule_ProvidesMoPubNativeAdExperimentFactory */
public final class FlavourApplicationModule_ProvidesMoPubNativeAdExperimentFactory implements C13181b<MoPubNativeAdExperiment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<ABTestManager> abTestManagerProvider;
    private final Provider<MoPubAnalytics> moPubAnalyticsProvider;
    private final FlavourApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1410668009557390739L, "cm/aptoide/pt/FlavourApplicationModule_ProvidesMoPubNativeAdExperimentFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public FlavourApplicationModule_ProvidesMoPubNativeAdExperimentFactory(FlavourApplicationModule module2, Provider<ABTestManager> abTestManagerProvider2, Provider<MoPubAnalytics> moPubAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.abTestManagerProvider = abTestManagerProvider2;
        this.moPubAnalyticsProvider = moPubAnalyticsProvider2;
        $jacocoInit[0] = true;
    }

    public MoPubNativeAdExperiment get() {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule flavourApplicationModule = this.module;
        Provider<ABTestManager> provider = this.abTestManagerProvider;
        $jacocoInit[1] = true;
        ABTestManager aBTestManager = (ABTestManager) provider.get();
        MoPubAnalytics moPubAnalytics = (MoPubAnalytics) this.moPubAnalyticsProvider.get();
        $jacocoInit[2] = true;
        MoPubNativeAdExperiment providesMoPubNativeAdExperiment = flavourApplicationModule.providesMoPubNativeAdExperiment(aBTestManager, moPubAnalytics);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesMoPubNativeAdExperiment, "Cannot return null from a non-@Nullable @Provides method");
        MoPubNativeAdExperiment moPubNativeAdExperiment = providesMoPubNativeAdExperiment;
        $jacocoInit[4] = true;
        return moPubNativeAdExperiment;
    }

    public static C13181b<MoPubNativeAdExperiment> create(FlavourApplicationModule module2, Provider<ABTestManager> abTestManagerProvider2, Provider<MoPubAnalytics> moPubAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule_ProvidesMoPubNativeAdExperimentFactory flavourApplicationModule_ProvidesMoPubNativeAdExperimentFactory = new FlavourApplicationModule_ProvidesMoPubNativeAdExperimentFactory(module2, abTestManagerProvider2, moPubAnalyticsProvider2);
        $jacocoInit[5] = true;
        return flavourApplicationModule_ProvidesMoPubNativeAdExperimentFactory;
    }

    public static MoPubNativeAdExperiment proxyProvidesMoPubNativeAdExperiment(FlavourApplicationModule instance, ABTestManager abTestManager, MoPubAnalytics moPubAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        MoPubNativeAdExperiment providesMoPubNativeAdExperiment = instance.providesMoPubNativeAdExperiment(abTestManager, moPubAnalytics);
        $jacocoInit[6] = true;
        return providesMoPubNativeAdExperiment;
    }
}
