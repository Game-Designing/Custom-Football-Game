package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.MoPubAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesMoPubAnalyticsFactory */
public final class ApplicationModule_ProvidesMoPubAnalyticsFactory implements C13181b<MoPubAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7719194535889198447L, "cm/aptoide/pt/ApplicationModule_ProvidesMoPubAnalyticsFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesMoPubAnalyticsFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public MoPubAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        MoPubAnalytics providesMoPubAnalytics = applicationModule.providesMoPubAnalytics();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesMoPubAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        MoPubAnalytics moPubAnalytics = providesMoPubAnalytics;
        $jacocoInit[3] = true;
        return moPubAnalytics;
    }

    public static C13181b<MoPubAnalytics> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesMoPubAnalyticsFactory applicationModule_ProvidesMoPubAnalyticsFactory = new ApplicationModule_ProvidesMoPubAnalyticsFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesMoPubAnalyticsFactory;
    }

    public static MoPubAnalytics proxyProvidesMoPubAnalytics(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        MoPubAnalytics providesMoPubAnalytics = instance.providesMoPubAnalytics();
        $jacocoInit[5] = true;
        return providesMoPubAnalytics;
    }
}
