package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferCardManager;
import p005cm.aptoide.p006pt.blacklist.BlacklistManager;
import p005cm.aptoide.p006pt.home.BundlesResponseMapper;
import p005cm.aptoide.p006pt.install.InstallManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesBundlesMapperFactory */
public final class ApplicationModule_ProvidesBundlesMapperFactory implements C13181b<BundlesResponseMapper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BlacklistManager> blacklistManagerProvider;
    private final Provider<InstallManager> installManagerProvider;
    private final Provider<String> marketNameProvider;
    private final ApplicationModule module;
    private final Provider<WalletAdsOfferCardManager> walletAdsOfferCardManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7153939974483166267L, "cm/aptoide/pt/ApplicationModule_ProvidesBundlesMapperFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesBundlesMapperFactory(ApplicationModule module2, Provider<String> marketNameProvider2, Provider<InstallManager> installManagerProvider2, Provider<WalletAdsOfferCardManager> walletAdsOfferCardManagerProvider2, Provider<BlacklistManager> blacklistManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.marketNameProvider = marketNameProvider2;
        this.installManagerProvider = installManagerProvider2;
        this.walletAdsOfferCardManagerProvider = walletAdsOfferCardManagerProvider2;
        this.blacklistManagerProvider = blacklistManagerProvider2;
        $jacocoInit[0] = true;
    }

    public BundlesResponseMapper get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<String> provider = this.marketNameProvider;
        $jacocoInit[1] = true;
        String str = (String) provider.get();
        Provider<InstallManager> provider2 = this.installManagerProvider;
        $jacocoInit[2] = true;
        InstallManager installManager = (InstallManager) provider2.get();
        Provider<WalletAdsOfferCardManager> provider3 = this.walletAdsOfferCardManagerProvider;
        $jacocoInit[3] = true;
        WalletAdsOfferCardManager walletAdsOfferCardManager = (WalletAdsOfferCardManager) provider3.get();
        Provider<BlacklistManager> provider4 = this.blacklistManagerProvider;
        $jacocoInit[4] = true;
        BlacklistManager blacklistManager = (BlacklistManager) provider4.get();
        $jacocoInit[5] = true;
        BundlesResponseMapper providesBundlesMapper = applicationModule.providesBundlesMapper(str, installManager, walletAdsOfferCardManager, blacklistManager);
        $jacocoInit[6] = true;
        C13182c.m43111a(providesBundlesMapper, "Cannot return null from a non-@Nullable @Provides method");
        BundlesResponseMapper bundlesResponseMapper = providesBundlesMapper;
        $jacocoInit[7] = true;
        return bundlesResponseMapper;
    }

    public static C13181b<BundlesResponseMapper> create(ApplicationModule module2, Provider<String> marketNameProvider2, Provider<InstallManager> installManagerProvider2, Provider<WalletAdsOfferCardManager> walletAdsOfferCardManagerProvider2, Provider<BlacklistManager> blacklistManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesBundlesMapperFactory applicationModule_ProvidesBundlesMapperFactory = new ApplicationModule_ProvidesBundlesMapperFactory(module2, marketNameProvider2, installManagerProvider2, walletAdsOfferCardManagerProvider2, blacklistManagerProvider2);
        $jacocoInit[8] = true;
        return applicationModule_ProvidesBundlesMapperFactory;
    }

    public static BundlesResponseMapper proxyProvidesBundlesMapper(ApplicationModule instance, String marketName, InstallManager installManager, WalletAdsOfferCardManager walletAdsOfferCardManager, BlacklistManager blacklistManager) {
        boolean[] $jacocoInit = $jacocoInit();
        BundlesResponseMapper providesBundlesMapper = instance.providesBundlesMapper(marketName, installManager, walletAdsOfferCardManager, blacklistManager);
        $jacocoInit[9] = true;
        return providesBundlesMapper;
    }
}
