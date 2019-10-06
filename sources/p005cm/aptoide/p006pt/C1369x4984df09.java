package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.abtesting.ABTestManager;
import p005cm.aptoide.p006pt.abtesting.experiments.MoPubInterstitialAdExperiment;
import p005cm.aptoide.p006pt.ads.MoPubAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.FlavourApplicationModule_ProvidesMoPubInterstitialAdExperimentFactory */
public final class C1369x4984df09 implements C13181b<MoPubInterstitialAdExperiment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<ABTestManager> abTestManagerProvider;
    private final Provider<MoPubAnalytics> moPubAnalyticsProvider;
    private final FlavourApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4389033334920876118L, "cm/aptoide/pt/FlavourApplicationModule_ProvidesMoPubInterstitialAdExperimentFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public C1369x4984df09(FlavourApplicationModule module2, Provider<ABTestManager> abTestManagerProvider2, Provider<MoPubAnalytics> moPubAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.abTestManagerProvider = abTestManagerProvider2;
        this.moPubAnalyticsProvider = moPubAnalyticsProvider2;
        $jacocoInit[0] = true;
    }

    public MoPubInterstitialAdExperiment get() {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule flavourApplicationModule = this.module;
        Provider<ABTestManager> provider = this.abTestManagerProvider;
        $jacocoInit[1] = true;
        ABTestManager aBTestManager = (ABTestManager) provider.get();
        MoPubAnalytics moPubAnalytics = (MoPubAnalytics) this.moPubAnalyticsProvider.get();
        $jacocoInit[2] = true;
        MoPubInterstitialAdExperiment providesMoPubInterstitialAdExperiment = flavourApplicationModule.providesMoPubInterstitialAdExperiment(aBTestManager, moPubAnalytics);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesMoPubInterstitialAdExperiment, "Cannot return null from a non-@Nullable @Provides method");
        MoPubInterstitialAdExperiment moPubInterstitialAdExperiment = providesMoPubInterstitialAdExperiment;
        $jacocoInit[4] = true;
        return moPubInterstitialAdExperiment;
    }

    public static C13181b<MoPubInterstitialAdExperiment> create(FlavourApplicationModule module2, Provider<ABTestManager> abTestManagerProvider2, Provider<MoPubAnalytics> moPubAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        C1369x4984df09 flavourApplicationModule_ProvidesMoPubInterstitialAdExperimentFactory = new C1369x4984df09(module2, abTestManagerProvider2, moPubAnalyticsProvider2);
        $jacocoInit[5] = true;
        return flavourApplicationModule_ProvidesMoPubInterstitialAdExperimentFactory;
    }

    public static MoPubInterstitialAdExperiment proxyProvidesMoPubInterstitialAdExperiment(FlavourApplicationModule instance, ABTestManager abTestManager, MoPubAnalytics moPubAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        MoPubInterstitialAdExperiment providesMoPubInterstitialAdExperiment = instance.providesMoPubInterstitialAdExperiment(abTestManager, moPubAnalytics);
        $jacocoInit[6] = true;
        return providesMoPubInterstitialAdExperiment;
    }
}
