package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.blacklist.BlacklistManager;
import p005cm.aptoide.p006pt.home.BannerRepository;
import p005cm.aptoide.p006pt.home.BundlesRepository;
import p005cm.aptoide.p006pt.home.Home;
import p005cm.aptoide.p006pt.promotions.PromotionsManager;
import p005cm.aptoide.p006pt.promotions.PromotionsPreferencesManager;
import p005cm.aptoide.p006pt.reactions.ReactionsManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesHomeFactory */
public final class FragmentModule_ProvidesHomeFactory implements C13181b<Home> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BannerRepository> bannerRepositoryProvider;
    private final Provider<BlacklistManager> blacklistManagerProvider;
    private final Provider<BundlesRepository> bundlesRepositoryProvider;
    private final Provider<MoPubAdsManager> moPubAdsManagerProvider;
    private final FragmentModule module;
    private final Provider<PromotionsManager> promotionsManagerProvider;
    private final Provider<PromotionsPreferencesManager> promotionsPreferencesManagerProvider;
    private final Provider<String> promotionsTypeProvider;
    private final Provider<ReactionsManager> reactionsManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7749169442311045685L, "cm/aptoide/pt/view/FragmentModule_ProvidesHomeFactory", 15);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesHomeFactory(FragmentModule module2, Provider<BundlesRepository> bundlesRepositoryProvider2, Provider<PromotionsManager> promotionsManagerProvider2, Provider<PromotionsPreferencesManager> promotionsPreferencesManagerProvider2, Provider<BannerRepository> bannerRepositoryProvider2, Provider<MoPubAdsManager> moPubAdsManagerProvider2, Provider<BlacklistManager> blacklistManagerProvider2, Provider<String> promotionsTypeProvider2, Provider<ReactionsManager> reactionsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.bundlesRepositoryProvider = bundlesRepositoryProvider2;
        this.promotionsManagerProvider = promotionsManagerProvider2;
        this.promotionsPreferencesManagerProvider = promotionsPreferencesManagerProvider2;
        this.bannerRepositoryProvider = bannerRepositoryProvider2;
        this.moPubAdsManagerProvider = moPubAdsManagerProvider2;
        this.blacklistManagerProvider = blacklistManagerProvider2;
        this.promotionsTypeProvider = promotionsTypeProvider2;
        this.reactionsManagerProvider = reactionsManagerProvider2;
        $jacocoInit[0] = true;
    }

    public Home get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<BundlesRepository> provider = this.bundlesRepositoryProvider;
        $jacocoInit[1] = true;
        BundlesRepository bundlesRepository = (BundlesRepository) provider.get();
        Provider<PromotionsManager> provider2 = this.promotionsManagerProvider;
        $jacocoInit[2] = true;
        PromotionsManager promotionsManager = (PromotionsManager) provider2.get();
        Provider<PromotionsPreferencesManager> provider3 = this.promotionsPreferencesManagerProvider;
        $jacocoInit[3] = true;
        PromotionsPreferencesManager promotionsPreferencesManager = (PromotionsPreferencesManager) provider3.get();
        Provider<BannerRepository> provider4 = this.bannerRepositoryProvider;
        $jacocoInit[4] = true;
        BannerRepository bannerRepository = (BannerRepository) provider4.get();
        Provider<MoPubAdsManager> provider5 = this.moPubAdsManagerProvider;
        $jacocoInit[5] = true;
        MoPubAdsManager moPubAdsManager = (MoPubAdsManager) provider5.get();
        Provider<BlacklistManager> provider6 = this.blacklistManagerProvider;
        $jacocoInit[6] = true;
        BlacklistManager blacklistManager = (BlacklistManager) provider6.get();
        Provider<String> provider7 = this.promotionsTypeProvider;
        $jacocoInit[7] = true;
        String str = (String) provider7.get();
        Provider<ReactionsManager> provider8 = this.reactionsManagerProvider;
        $jacocoInit[8] = true;
        ReactionsManager reactionsManager = (ReactionsManager) provider8.get();
        $jacocoInit[9] = true;
        Home providesHome = fragmentModule.providesHome(bundlesRepository, promotionsManager, promotionsPreferencesManager, bannerRepository, moPubAdsManager, blacklistManager, str, reactionsManager);
        $jacocoInit[10] = true;
        C13182c.m43111a(providesHome, "Cannot return null from a non-@Nullable @Provides method");
        Home home = providesHome;
        $jacocoInit[11] = true;
        return home;
    }

    public static C13181b<Home> create(FragmentModule module2, Provider<BundlesRepository> bundlesRepositoryProvider2, Provider<PromotionsManager> promotionsManagerProvider2, Provider<PromotionsPreferencesManager> promotionsPreferencesManagerProvider2, Provider<BannerRepository> bannerRepositoryProvider2, Provider<MoPubAdsManager> moPubAdsManagerProvider2, Provider<BlacklistManager> blacklistManagerProvider2, Provider<String> promotionsTypeProvider2, Provider<ReactionsManager> reactionsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesHomeFactory fragmentModule_ProvidesHomeFactory = new FragmentModule_ProvidesHomeFactory(module2, bundlesRepositoryProvider2, promotionsManagerProvider2, promotionsPreferencesManagerProvider2, bannerRepositoryProvider2, moPubAdsManagerProvider2, blacklistManagerProvider2, promotionsTypeProvider2, reactionsManagerProvider2);
        $jacocoInit[12] = true;
        return fragmentModule_ProvidesHomeFactory;
    }

    public static Home proxyProvidesHome(FragmentModule instance, BundlesRepository bundlesRepository, PromotionsManager promotionsManager, PromotionsPreferencesManager promotionsPreferencesManager, BannerRepository bannerRepository, MoPubAdsManager moPubAdsManager, BlacklistManager blacklistManager, String promotionsType, ReactionsManager reactionsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        Home providesHome = instance.providesHome(bundlesRepository, promotionsManager, promotionsPreferencesManager, bannerRepository, moPubAdsManager, blacklistManager, promotionsType, reactionsManager);
        $jacocoInit[13] = true;
        return providesHome;
    }
}
