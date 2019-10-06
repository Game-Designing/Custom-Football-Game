package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.utils.AnalyticsEventParametersNormalizer;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAnalyticsNormalizerFactory */
public final class ApplicationModule_ProvidesAnalyticsNormalizerFactory implements C13181b<AnalyticsEventParametersNormalizer> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5515550542490440648L, "cm/aptoide/pt/ApplicationModule_ProvidesAnalyticsNormalizerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAnalyticsNormalizerFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public AnalyticsEventParametersNormalizer get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        AnalyticsEventParametersNormalizer providesAnalyticsNormalizer = applicationModule.providesAnalyticsNormalizer();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAnalyticsNormalizer, "Cannot return null from a non-@Nullable @Provides method");
        AnalyticsEventParametersNormalizer analyticsEventParametersNormalizer = providesAnalyticsNormalizer;
        $jacocoInit[3] = true;
        return analyticsEventParametersNormalizer;
    }

    public static C13181b<AnalyticsEventParametersNormalizer> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAnalyticsNormalizerFactory applicationModule_ProvidesAnalyticsNormalizerFactory = new ApplicationModule_ProvidesAnalyticsNormalizerFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAnalyticsNormalizerFactory;
    }

    public static AnalyticsEventParametersNormalizer proxyProvidesAnalyticsNormalizer(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsEventParametersNormalizer providesAnalyticsNormalizer = instance.providesAnalyticsNormalizer();
        $jacocoInit[5] = true;
        return providesAnalyticsNormalizer;
    }
}
