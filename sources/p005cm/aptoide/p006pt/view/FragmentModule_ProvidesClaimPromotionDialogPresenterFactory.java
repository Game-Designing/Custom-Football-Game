package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionDialogPresenter;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionsManager;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionsNavigator;
import p005cm.aptoide.p006pt.promotions.PromotionsAnalytics;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesClaimPromotionDialogPresenterFactory */
public final class FragmentModule_ProvidesClaimPromotionDialogPresenterFactory implements C13181b<ClaimPromotionDialogPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<ClaimPromotionsManager> claimPromotionsManagerProvider;
    private final FragmentModule module;
    private final Provider<ClaimPromotionsNavigator> navigatorProvider;
    private final Provider<PromotionsAnalytics> promotionsAnalyticsProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-26095012918184950L, "cm/aptoide/pt/view/FragmentModule_ProvidesClaimPromotionDialogPresenterFactory", 10);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesClaimPromotionDialogPresenterFactory(FragmentModule module2, Provider<ClaimPromotionsManager> claimPromotionsManagerProvider2, Provider<PromotionsAnalytics> promotionsAnalyticsProvider2, Provider<ClaimPromotionsNavigator> navigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.claimPromotionsManagerProvider = claimPromotionsManagerProvider2;
        this.promotionsAnalyticsProvider = promotionsAnalyticsProvider2;
        this.navigatorProvider = navigatorProvider2;
        $jacocoInit[0] = true;
    }

    public ClaimPromotionDialogPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<ClaimPromotionsManager> provider = this.claimPromotionsManagerProvider;
        $jacocoInit[1] = true;
        ClaimPromotionsManager claimPromotionsManager = (ClaimPromotionsManager) provider.get();
        Provider<PromotionsAnalytics> provider2 = this.promotionsAnalyticsProvider;
        $jacocoInit[2] = true;
        PromotionsAnalytics promotionsAnalytics = (PromotionsAnalytics) provider2.get();
        Provider<ClaimPromotionsNavigator> provider3 = this.navigatorProvider;
        $jacocoInit[3] = true;
        ClaimPromotionsNavigator claimPromotionsNavigator = (ClaimPromotionsNavigator) provider3.get();
        $jacocoInit[4] = true;
        ClaimPromotionDialogPresenter providesClaimPromotionDialogPresenter = fragmentModule.providesClaimPromotionDialogPresenter(claimPromotionsManager, promotionsAnalytics, claimPromotionsNavigator);
        $jacocoInit[5] = true;
        C13182c.m43111a(providesClaimPromotionDialogPresenter, "Cannot return null from a non-@Nullable @Provides method");
        ClaimPromotionDialogPresenter claimPromotionDialogPresenter = providesClaimPromotionDialogPresenter;
        $jacocoInit[6] = true;
        return claimPromotionDialogPresenter;
    }

    public static C13181b<ClaimPromotionDialogPresenter> create(FragmentModule module2, Provider<ClaimPromotionsManager> claimPromotionsManagerProvider2, Provider<PromotionsAnalytics> promotionsAnalyticsProvider2, Provider<ClaimPromotionsNavigator> navigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesClaimPromotionDialogPresenterFactory fragmentModule_ProvidesClaimPromotionDialogPresenterFactory = new FragmentModule_ProvidesClaimPromotionDialogPresenterFactory(module2, claimPromotionsManagerProvider2, promotionsAnalyticsProvider2, navigatorProvider2);
        $jacocoInit[7] = true;
        return fragmentModule_ProvidesClaimPromotionDialogPresenterFactory;
    }

    public static ClaimPromotionDialogPresenter proxyProvidesClaimPromotionDialogPresenter(FragmentModule instance, ClaimPromotionsManager claimPromotionsManager, PromotionsAnalytics promotionsAnalytics, ClaimPromotionsNavigator navigator) {
        boolean[] $jacocoInit = $jacocoInit();
        ClaimPromotionDialogPresenter providesClaimPromotionDialogPresenter = instance.providesClaimPromotionDialogPresenter(claimPromotionsManager, promotionsAnalytics, navigator);
        $jacocoInit[8] = true;
        return providesClaimPromotionDialogPresenter;
    }
}
