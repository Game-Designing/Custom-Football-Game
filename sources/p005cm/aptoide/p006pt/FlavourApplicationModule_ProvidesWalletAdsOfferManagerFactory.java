package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferService;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.FlavourApplicationModule_ProvidesWalletAdsOfferManagerFactory */
public final class FlavourApplicationModule_ProvidesWalletAdsOfferManagerFactory implements C13181b<WalletAdsOfferManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FlavourApplicationModule module;
    private final Provider<WalletAdsOfferService> walletAdsOfferServiceProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-793176460475020965L, "cm/aptoide/pt/FlavourApplicationModule_ProvidesWalletAdsOfferManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FlavourApplicationModule_ProvidesWalletAdsOfferManagerFactory(FlavourApplicationModule module2, Provider<WalletAdsOfferService> walletAdsOfferServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.walletAdsOfferServiceProvider = walletAdsOfferServiceProvider2;
        $jacocoInit[0] = true;
    }

    public WalletAdsOfferManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule flavourApplicationModule = this.module;
        Provider<WalletAdsOfferService> provider = this.walletAdsOfferServiceProvider;
        $jacocoInit[1] = true;
        WalletAdsOfferManager providesWalletAdsOfferManager = flavourApplicationModule.providesWalletAdsOfferManager((WalletAdsOfferService) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesWalletAdsOfferManager, "Cannot return null from a non-@Nullable @Provides method");
        WalletAdsOfferManager walletAdsOfferManager = providesWalletAdsOfferManager;
        $jacocoInit[3] = true;
        return walletAdsOfferManager;
    }

    public static C13181b<WalletAdsOfferManager> create(FlavourApplicationModule module2, Provider<WalletAdsOfferService> walletAdsOfferServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule_ProvidesWalletAdsOfferManagerFactory flavourApplicationModule_ProvidesWalletAdsOfferManagerFactory = new FlavourApplicationModule_ProvidesWalletAdsOfferManagerFactory(module2, walletAdsOfferServiceProvider2);
        $jacocoInit[4] = true;
        return flavourApplicationModule_ProvidesWalletAdsOfferManagerFactory;
    }

    public static WalletAdsOfferManager proxyProvidesWalletAdsOfferManager(FlavourApplicationModule instance, WalletAdsOfferService walletAdsOfferService) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletAdsOfferManager providesWalletAdsOfferManager = instance.providesWalletAdsOfferManager(walletAdsOfferService);
        $jacocoInit[5] = true;
        return providesWalletAdsOfferManager;
    }
}
