package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.search.suggestions.TrendingManager;
import p005cm.aptoide.p006pt.search.suggestions.TrendingService;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesTrendingManagerFactory */
public final class ApplicationModule_ProvidesTrendingManagerFactory implements C13181b<TrendingManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<TrendingService> trendingServiceProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(247891916939008612L, "cm/aptoide/pt/ApplicationModule_ProvidesTrendingManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesTrendingManagerFactory(ApplicationModule module2, Provider<TrendingService> trendingServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.trendingServiceProvider = trendingServiceProvider2;
        $jacocoInit[0] = true;
    }

    public TrendingManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<TrendingService> provider = this.trendingServiceProvider;
        $jacocoInit[1] = true;
        TrendingManager providesTrendingManager = applicationModule.providesTrendingManager((TrendingService) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesTrendingManager, "Cannot return null from a non-@Nullable @Provides method");
        TrendingManager trendingManager = providesTrendingManager;
        $jacocoInit[3] = true;
        return trendingManager;
    }

    public static C13181b<TrendingManager> create(ApplicationModule module2, Provider<TrendingService> trendingServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesTrendingManagerFactory applicationModule_ProvidesTrendingManagerFactory = new ApplicationModule_ProvidesTrendingManagerFactory(module2, trendingServiceProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesTrendingManagerFactory;
    }

    public static TrendingManager proxyProvidesTrendingManager(ApplicationModule instance, TrendingService trendingService) {
        boolean[] $jacocoInit = $jacocoInit();
        TrendingManager providesTrendingManager = instance.providesTrendingManager(trendingService);
        $jacocoInit[5] = true;
        return providesTrendingManager;
    }
}
