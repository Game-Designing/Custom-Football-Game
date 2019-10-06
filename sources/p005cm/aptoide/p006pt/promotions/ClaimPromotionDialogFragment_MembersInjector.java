package p005cm.aptoide.p006pt.promotions;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.promotions.ClaimPromotionDialogFragment_MembersInjector */
public final class ClaimPromotionDialogFragment_MembersInjector implements C13183b<ClaimPromotionDialogFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<ClaimPromotionsManager> claimPromotionsManagerProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final Provider<ClaimPromotionsNavigator> navigatorProvider;
    private final Provider<ClaimPromotionDialogPresenter> presenterProvider;
    private final Provider<PromotionsAnalytics> promotionsAnalyticsProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4404113369155596922L, "cm/aptoide/pt/promotions/ClaimPromotionDialogFragment_MembersInjector", 13);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((ClaimPromotionDialogFragment) obj);
        $jacocoInit[12] = true;
    }

    public ClaimPromotionDialogFragment_MembersInjector(Provider<ClaimPromotionDialogPresenter> presenterProvider2, Provider<ClaimPromotionsManager> claimPromotionsManagerProvider2, Provider<IdsRepository> idsRepositoryProvider2, Provider<PromotionsAnalytics> promotionsAnalyticsProvider2, Provider<ClaimPromotionsNavigator> navigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.presenterProvider = presenterProvider2;
        this.claimPromotionsManagerProvider = claimPromotionsManagerProvider2;
        this.idsRepositoryProvider = idsRepositoryProvider2;
        this.promotionsAnalyticsProvider = promotionsAnalyticsProvider2;
        this.navigatorProvider = navigatorProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<ClaimPromotionDialogFragment> create(Provider<ClaimPromotionDialogPresenter> presenterProvider2, Provider<ClaimPromotionsManager> claimPromotionsManagerProvider2, Provider<IdsRepository> idsRepositoryProvider2, Provider<PromotionsAnalytics> promotionsAnalyticsProvider2, Provider<ClaimPromotionsNavigator> navigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ClaimPromotionDialogFragment_MembersInjector claimPromotionDialogFragment_MembersInjector = new ClaimPromotionDialogFragment_MembersInjector(presenterProvider2, claimPromotionsManagerProvider2, idsRepositoryProvider2, promotionsAnalyticsProvider2, navigatorProvider2);
        $jacocoInit[1] = true;
        return claimPromotionDialogFragment_MembersInjector;
    }

    public void injectMembers(ClaimPromotionDialogFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectPresenter(instance, (ClaimPromotionDialogPresenter) this.presenterProvider.get());
        $jacocoInit[2] = true;
        injectClaimPromotionsManager(instance, (ClaimPromotionsManager) this.claimPromotionsManagerProvider.get());
        $jacocoInit[3] = true;
        injectIdsRepository(instance, (IdsRepository) this.idsRepositoryProvider.get());
        $jacocoInit[4] = true;
        injectPromotionsAnalytics(instance, (PromotionsAnalytics) this.promotionsAnalyticsProvider.get());
        $jacocoInit[5] = true;
        injectNavigator(instance, (ClaimPromotionsNavigator) this.navigatorProvider.get());
        $jacocoInit[6] = true;
    }

    public static void injectPresenter(ClaimPromotionDialogFragment instance, ClaimPromotionDialogPresenter presenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.presenter = presenter;
        $jacocoInit[7] = true;
    }

    public static void injectClaimPromotionsManager(ClaimPromotionDialogFragment instance, ClaimPromotionsManager claimPromotionsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.claimPromotionsManager = claimPromotionsManager;
        $jacocoInit[8] = true;
    }

    public static void injectIdsRepository(ClaimPromotionDialogFragment instance, IdsRepository idsRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.idsRepository = idsRepository;
        $jacocoInit[9] = true;
    }

    public static void injectPromotionsAnalytics(ClaimPromotionDialogFragment instance, PromotionsAnalytics promotionsAnalytics) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.promotionsAnalytics = promotionsAnalytics;
        $jacocoInit[10] = true;
    }

    public static void injectNavigator(ClaimPromotionDialogFragment instance, ClaimPromotionsNavigator navigator) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.navigator = navigator;
        $jacocoInit[11] = true;
    }
}
