package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.promotions.PromotionsAnalytics;
import p005cm.aptoide.p006pt.promotions.PromotionsManager;
import p005cm.aptoide.p006pt.promotions.PromotionsNavigator;
import p005cm.aptoide.p006pt.promotions.PromotionsPresenter;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesPromotionsPresenterFactory */
public final class FragmentModule_ProvidesPromotionsPresenterFactory implements C13181b<PromotionsPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FragmentModule module;
    private final Provider<PromotionsAnalytics> promotionsAnalyticsProvider;
    private final Provider<PromotionsManager> promotionsManagerProvider;
    private final Provider<PromotionsNavigator> promotionsNavigatorProvider;
    private final Provider<String> promotionsTypeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4508168930184617185L, "cm/aptoide/pt/view/FragmentModule_ProvidesPromotionsPresenterFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesPromotionsPresenterFactory(FragmentModule module2, Provider<PromotionsManager> promotionsManagerProvider2, Provider<PromotionsAnalytics> promotionsAnalyticsProvider2, Provider<PromotionsNavigator> promotionsNavigatorProvider2, Provider<String> promotionsTypeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.promotionsManagerProvider = promotionsManagerProvider2;
        this.promotionsAnalyticsProvider = promotionsAnalyticsProvider2;
        this.promotionsNavigatorProvider = promotionsNavigatorProvider2;
        this.promotionsTypeProvider = promotionsTypeProvider2;
        $jacocoInit[0] = true;
    }

    public PromotionsPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<PromotionsManager> provider = this.promotionsManagerProvider;
        $jacocoInit[1] = true;
        PromotionsManager promotionsManager = (PromotionsManager) provider.get();
        Provider<PromotionsAnalytics> provider2 = this.promotionsAnalyticsProvider;
        $jacocoInit[2] = true;
        PromotionsAnalytics promotionsAnalytics = (PromotionsAnalytics) provider2.get();
        Provider<PromotionsNavigator> provider3 = this.promotionsNavigatorProvider;
        $jacocoInit[3] = true;
        PromotionsNavigator promotionsNavigator = (PromotionsNavigator) provider3.get();
        Provider<String> provider4 = this.promotionsTypeProvider;
        $jacocoInit[4] = true;
        String str = (String) provider4.get();
        $jacocoInit[5] = true;
        PromotionsPresenter providesPromotionsPresenter = fragmentModule.providesPromotionsPresenter(promotionsManager, promotionsAnalytics, promotionsNavigator, str);
        $jacocoInit[6] = true;
        C13182c.m43111a(providesPromotionsPresenter, "Cannot return null from a non-@Nullable @Provides method");
        PromotionsPresenter promotionsPresenter = providesPromotionsPresenter;
        $jacocoInit[7] = true;
        return promotionsPresenter;
    }

    public static C13181b<PromotionsPresenter> create(FragmentModule module2, Provider<PromotionsManager> promotionsManagerProvider2, Provider<PromotionsAnalytics> promotionsAnalyticsProvider2, Provider<PromotionsNavigator> promotionsNavigatorProvider2, Provider<String> promotionsTypeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesPromotionsPresenterFactory fragmentModule_ProvidesPromotionsPresenterFactory = new FragmentModule_ProvidesPromotionsPresenterFactory(module2, promotionsManagerProvider2, promotionsAnalyticsProvider2, promotionsNavigatorProvider2, promotionsTypeProvider2);
        $jacocoInit[8] = true;
        return fragmentModule_ProvidesPromotionsPresenterFactory;
    }

    public static PromotionsPresenter proxyProvidesPromotionsPresenter(FragmentModule instance, PromotionsManager promotionsManager, PromotionsAnalytics promotionsAnalytics, PromotionsNavigator promotionsNavigator, String promotionsType) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsPresenter providesPromotionsPresenter = instance.providesPromotionsPresenter(promotionsManager, promotionsAnalytics, promotionsNavigator, promotionsType);
        $jacocoInit[9] = true;
        return providesPromotionsPresenter;
    }
}
