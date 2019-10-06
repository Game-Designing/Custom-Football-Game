package p005cm.aptoide.p006pt.home;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.blacklist.BlacklistManager;
import p005cm.aptoide.p006pt.home.HomeBundle.BundleType;
import p005cm.aptoide.p006pt.promotions.PromotionApp;
import p005cm.aptoide.p006pt.promotions.PromotionsManager;
import p005cm.aptoide.p006pt.promotions.PromotionsModel;
import p005cm.aptoide.p006pt.promotions.PromotionsPreferencesManager;
import p005cm.aptoide.p006pt.reactions.ReactionsManager;
import p005cm.aptoide.p006pt.reactions.network.LoadReactionModel;
import p005cm.aptoide.p006pt.reactions.network.ReactionsResponse;
import p026rx.C0117M;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.home.Home */
public class Home {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BannerRepository bannerRepository;
    private final BlacklistManager blacklistManager;
    private final BundlesRepository bundlesRepository;
    private final MoPubAdsManager moPubAdsManager;
    private final String promotionType;
    private final PromotionsManager promotionsManager;
    private PromotionsPreferencesManager promotionsPreferencesManager;
    private final ReactionsManager reactionsManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8653285953076351163L, "cm/aptoide/pt/home/Home", 88);
        $jacocoData = probes;
        return probes;
    }

    public Home(BundlesRepository bundlesRepository2, PromotionsManager promotionsManager2, BannerRepository bannerRepository2, MoPubAdsManager moPubAdsManager2, PromotionsPreferencesManager promotionsPreferencesManager2, BlacklistManager blacklistManager2, String promotionType2, ReactionsManager reactionsManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bundlesRepository = bundlesRepository2;
        this.promotionsManager = promotionsManager2;
        this.bannerRepository = bannerRepository2;
        this.moPubAdsManager = moPubAdsManager2;
        this.promotionsPreferencesManager = promotionsPreferencesManager2;
        this.promotionType = promotionType2;
        this.blacklistManager = blacklistManager2;
        this.reactionsManager = reactionsManager2;
        $jacocoInit[0] = true;
    }

    public Single<HomeBundlesModel> loadHomeBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadHomeBundles = this.bundlesRepository.loadHomeBundles();
        C3354C c = new C3354C(this);
        $jacocoInit[1] = true;
        Single<HomeBundlesModel> a = loadHomeBundles.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) c);
        $jacocoInit[2] = true;
        return a;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo14286b(HomeBundlesModel bundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (bundlesModel.hasErrors()) {
            $jacocoInit[84] = true;
        } else if (bundlesModel.isLoading()) {
            $jacocoInit[85] = true;
        } else {
            Single addAdBundle = addAdBundle(bundlesModel);
            $jacocoInit[87] = true;
            return addAdBundle;
        }
        Single a = Single.m734a(bundlesModel);
        $jacocoInit[86] = true;
        return a;
    }

    public Single<HomeBundlesModel> loadFreshHomeBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadFreshHomeBundles = this.bundlesRepository.loadFreshHomeBundles();
        C3957x xVar = new C3957x(this);
        $jacocoInit[3] = true;
        Single<HomeBundlesModel> a = loadFreshHomeBundles.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) xVar);
        $jacocoInit[4] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo14280a(HomeBundlesModel bundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (bundlesModel.hasErrors()) {
            $jacocoInit[80] = true;
        } else if (bundlesModel.isLoading()) {
            $jacocoInit[81] = true;
        } else {
            Single addAdBundle = addAdBundle(bundlesModel);
            $jacocoInit[83] = true;
            return addAdBundle;
        }
        Single a = Single.m734a(bundlesModel);
        $jacocoInit[82] = true;
        return a;
    }

    private Single<HomeBundlesModel> addAdBundle(HomeBundlesModel bundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        Single shouldLoadBannerAd = this.moPubAdsManager.shouldLoadBannerAd();
        C3364E e = new C3364E(this, bundlesModel);
        $jacocoInit[5] = true;
        Single<HomeBundlesModel> a = shouldLoadBannerAd.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) e);
        $jacocoInit[6] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo14281a(HomeBundlesModel bundlesModel, Boolean shouldLoadBanner) {
        boolean[] $jacocoInit = $jacocoInit();
        if (shouldLoadBanner.booleanValue()) {
            $jacocoInit[75] = true;
            Single bannerBundle = this.bannerRepository.getBannerBundle();
            C3359D d = new C3359D(this, bundlesModel);
            $jacocoInit[76] = true;
            Single d2 = bannerBundle.mo3698d(d);
            $jacocoInit[77] = true;
            return d2;
        }
        Single a = Single.m734a(bundlesModel);
        $jacocoInit[78] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ HomeBundlesModel mo14279a(HomeBundlesModel bundlesModel, HomeBundle banner) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeBundlesModel addBannerToHomeBundleModel = addBannerToHomeBundleModel(bundlesModel, banner);
        $jacocoInit[79] = true;
        return addBannerToHomeBundleModel;
    }

    private HomeBundlesModel addBannerToHomeBundleModel(HomeBundlesModel bundlesModel, HomeBundle banner) {
        boolean[] $jacocoInit = $jacocoInit();
        if (bundlesModel.isLoading()) {
            $jacocoInit[7] = true;
            return bundlesModel;
        } else if (bundlesModel.hasErrors()) {
            $jacocoInit[8] = true;
            return bundlesModel;
        } else {
            List<HomeBundle> bundleList = bundlesModel.getList();
            $jacocoInit[9] = true;
            bundleList.add(1, banner);
            $jacocoInit[10] = true;
            HomeBundlesModel homeBundlesModel = new HomeBundlesModel(bundleList, bundlesModel.isLoading(), bundlesModel.getOffset());
            $jacocoInit[11] = true;
            return homeBundlesModel;
        }
    }

    public Single<HomeBundlesModel> loadNextHomeBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<HomeBundlesModel> loadNextHomeBundles = this.bundlesRepository.loadNextHomeBundles();
        $jacocoInit[12] = true;
        return loadNextHomeBundles;
    }

    public boolean hasMore() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean hasMore = this.bundlesRepository.hasMore();
        $jacocoInit[13] = true;
        return hasMore;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14287b(ActionBundle bundle) {
        boolean[] $jacocoInit = $jacocoInit();
        BlacklistManager blacklistManager2 = this.blacklistManager;
        BundleType type = bundle.getType();
        $jacocoInit[71] = true;
        String str = type.toString();
        ActionItem actionItem = bundle.getActionItem();
        $jacocoInit[72] = true;
        String cardId = actionItem.getCardId();
        $jacocoInit[73] = true;
        blacklistManager2.blacklist(str, cardId);
        $jacocoInit[74] = true;
    }

    public C0117M remove(ActionBundle bundle) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C3963y(this, bundle));
        BundlesRepository bundlesRepository2 = this.bundlesRepository;
        $jacocoInit[14] = true;
        C0117M a = c.mo3580a(bundlesRepository2.remove(bundle));
        $jacocoInit[15] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14284a(ActionBundle bundle) {
        boolean[] $jacocoInit = $jacocoInit();
        BlacklistManager blacklistManager2 = this.blacklistManager;
        BundleType type = bundle.getType();
        $jacocoInit[67] = true;
        String str = type.toString();
        ActionItem actionItem = bundle.getActionItem();
        $jacocoInit[68] = true;
        String cardId = actionItem.getCardId();
        $jacocoInit[69] = true;
        blacklistManager2.addImpression(str, cardId);
        $jacocoInit[70] = true;
    }

    public C0117M actionBundleImpression(ActionBundle bundle) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C3371F(this, bundle));
        $jacocoInit[16] = true;
        return c;
    }

    public Single<HomePromotionsWrapper> hasPromotionApps() {
        boolean[] $jacocoInit = $jacocoInit();
        Single promotionsModel = this.promotionsManager.getPromotionsModel(this.promotionType);
        C3347B b = new C3347B(this);
        $jacocoInit[17] = true;
        Single<HomePromotionsWrapper> d = promotionsModel.mo3698d(b);
        $jacocoInit[18] = true;
        return d;
    }

    public void setPromotionsDialogShown() {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsPreferencesManager.setPromotionsDialogShown();
        $jacocoInit[19] = true;
    }

    /* access modifiers changed from: private */
    public HomePromotionsWrapper mapPromotions(PromotionsModel promotionsModel) {
        boolean z;
        boolean z2;
        boolean[] $jacocoInit = $jacocoInit();
        int unclaimedPromotions = 0;
        $jacocoInit[20] = true;
        List<PromotionApp> apps = promotionsModel.getAppsList();
        float unclaimedAppcValue = 0.0f;
        $jacocoInit[21] = true;
        if (apps.size() <= 0) {
            $jacocoInit[22] = true;
        } else {
            $jacocoInit[23] = true;
            $jacocoInit[24] = true;
            for (PromotionApp app : apps) {
                $jacocoInit[26] = true;
                if (app.isClaimed()) {
                    $jacocoInit[27] = true;
                } else {
                    unclaimedPromotions++;
                    $jacocoInit[28] = true;
                    unclaimedAppcValue += app.getAppcValue();
                    $jacocoInit[29] = true;
                }
                $jacocoInit[30] = true;
            }
            $jacocoInit[25] = true;
        }
        String title = promotionsModel.getTitle();
        $jacocoInit[31] = true;
        String featureGraphic = promotionsModel.getFeatureGraphic();
        if (!apps.isEmpty()) {
            $jacocoInit[32] = true;
            z = true;
        } else {
            $jacocoInit[33] = true;
            z = false;
        }
        PromotionsPreferencesManager promotionsPreferencesManager2 = this.promotionsPreferencesManager;
        $jacocoInit[34] = true;
        if (!promotionsPreferencesManager2.shouldShowPromotionsDialog()) {
            $jacocoInit[35] = true;
        } else if (unclaimedAppcValue <= 0.0f) {
            $jacocoInit[36] = true;
        } else {
            $jacocoInit[37] = true;
            z2 = true;
            $jacocoInit[39] = true;
            HomePromotionsWrapper homePromotionsWrapper = new HomePromotionsWrapper(title, featureGraphic, z, unclaimedPromotions, unclaimedAppcValue, z2, (float) promotionsModel.getTotalAppcValue());
            $jacocoInit[40] = true;
            return homePromotionsWrapper;
        }
        $jacocoInit[38] = true;
        z2 = false;
        $jacocoInit[39] = true;
        HomePromotionsWrapper homePromotionsWrapper2 = new HomePromotionsWrapper(title, featureGraphic, z, unclaimedPromotions, unclaimedAppcValue, z2, (float) promotionsModel.getTotalAppcValue());
        $jacocoInit[40] = true;
        return homePromotionsWrapper2;
    }

    public Single<Boolean> shouldLoadNativeAd() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> shouldLoadNativeAds = this.moPubAdsManager.shouldLoadNativeAds();
        $jacocoInit[41] = true;
        return shouldLoadNativeAds;
    }

    public Single<Boolean> shouldShowConsentDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> shouldShowConsentDialog = this.moPubAdsManager.shouldShowConsentDialog();
        $jacocoInit[42] = true;
        return shouldShowConsentDialog;
    }

    public Single<List<HomeBundle>> loadReactionModel(String cardId, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadReactionModel = this.reactionsManager.loadReactionModel(cardId, groupId);
        C3969z zVar = new C3969z(this, cardId);
        $jacocoInit[43] = true;
        Single<List<HomeBundle>> a = loadReactionModel.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) zVar);
        $jacocoInit[44] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo14283a(String cardId, LoadReactionModel loadReactionModel) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadHomeBundles = this.bundlesRepository.loadHomeBundles();
        C3336A a = new C3336A(this, loadReactionModel, cardId);
        $jacocoInit[64] = true;
        Single a2 = loadHomeBundles.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) a);
        $jacocoInit[65] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo14282a(LoadReactionModel loadReactionModel, String cardId, HomeBundlesModel homeBundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        Single updatedCards = getUpdatedCards(homeBundlesModel, loadReactionModel, cardId);
        $jacocoInit[66] = true;
        return updatedCards;
    }

    private Single<List<HomeBundle>> getUpdatedCards(HomeBundlesModel homeBundlesModel, LoadReactionModel loadReactionModel, String cardId) {
        boolean[] $jacocoInit = $jacocoInit();
        List<HomeBundle> homeBundles = homeBundlesModel.getList();
        $jacocoInit[45] = true;
        $jacocoInit[46] = true;
        for (HomeBundle homeBundle : homeBundles) {
            $jacocoInit[47] = true;
            if (homeBundle.getType() != BundleType.EDITORIAL) {
                $jacocoInit[48] = true;
            } else if (!(homeBundle instanceof ActionBundle)) {
                $jacocoInit[49] = true;
            } else {
                $jacocoInit[50] = true;
                ActionItem actionBundle = ((ActionBundle) homeBundle).getActionItem();
                $jacocoInit[51] = true;
                String cardId2 = actionBundle.getCardId();
                $jacocoInit[52] = true;
                if (!cardId2.equals(cardId)) {
                    $jacocoInit[53] = true;
                } else {
                    $jacocoInit[54] = true;
                    actionBundle.setReactions(loadReactionModel.getTopReactionList());
                    $jacocoInit[55] = true;
                    actionBundle.setNumberOfReactions(loadReactionModel.getTotal());
                    $jacocoInit[56] = true;
                    actionBundle.setUserReaction(loadReactionModel.getMyReaction());
                    $jacocoInit[57] = true;
                }
            }
            $jacocoInit[58] = true;
        }
        this.bundlesRepository.updateCache(homeBundles);
        $jacocoInit[59] = true;
        Single<List<HomeBundle>> a = Single.m734a(homeBundles);
        $jacocoInit[60] = true;
        return a;
    }

    public Single<ReactionsResponse> setReaction(String cardId, String groupId, String reaction) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<ReactionsResponse> reaction2 = this.reactionsManager.setReaction(cardId, groupId, reaction);
        $jacocoInit[61] = true;
        return reaction2;
    }

    public Single<ReactionsResponse> deleteReaction(String cardId, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<ReactionsResponse> deleteReaction = this.reactionsManager.deleteReaction(cardId, groupId);
        $jacocoInit[62] = true;
        return deleteReaction;
    }

    public Single<Boolean> isFirstReaction(String cardId, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> isFirstReaction = this.reactionsManager.isFirstReaction(cardId, groupId);
        $jacocoInit[63] = true;
        return isFirstReaction;
    }
}
