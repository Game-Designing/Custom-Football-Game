package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideAptoideApplicationAnalyticsFactory */
public final class ApplicationModule_ProvideAptoideApplicationAnalyticsFactory implements C13181b<AptoideApplicationAnalytics> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5633979563619508256L, "cm/aptoide/pt/ApplicationModule_ProvideAptoideApplicationAnalyticsFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideAptoideApplicationAnalyticsFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public AptoideApplicationAnalytics get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        AptoideApplicationAnalytics provideAptoideApplicationAnalytics = applicationModule.provideAptoideApplicationAnalytics();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideAptoideApplicationAnalytics, "Cannot return null from a non-@Nullable @Provides method");
        AptoideApplicationAnalytics aptoideApplicationAnalytics = provideAptoideApplicationAnalytics;
        $jacocoInit[3] = true;
        return aptoideApplicationAnalytics;
    }

    public static C13181b<AptoideApplicationAnalytics> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideAptoideApplicationAnalyticsFactory applicationModule_ProvideAptoideApplicationAnalyticsFactory = new ApplicationModule_ProvideAptoideApplicationAnalyticsFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideAptoideApplicationAnalyticsFactory;
    }

    public static AptoideApplicationAnalytics proxyProvideAptoideApplicationAnalytics(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideApplicationAnalytics provideAptoideApplicationAnalytics = instance.provideAptoideApplicationAnalytics();
        $jacocoInit[5] = true;
        return provideAptoideApplicationAnalytics;
    }
}
