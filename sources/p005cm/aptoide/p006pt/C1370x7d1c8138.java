package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferCardManager;
import p005cm.aptoide.p006pt.blacklist.BlacklistManager;
import p005cm.aptoide.p006pt.install.PackageRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.FlavourApplicationModule_ProvidesWalletAdsOfferCardManagerFactory */
public final class C1370x7d1c8138 implements C13181b<WalletAdsOfferCardManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BlacklistManager> blacklistManagerProvider;
    private final FlavourApplicationModule module;
    private final Provider<PackageRepository> packageRepositoryProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4599282828464722230L, "cm/aptoide/pt/FlavourApplicationModule_ProvidesWalletAdsOfferCardManagerFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public C1370x7d1c8138(FlavourApplicationModule module2, Provider<BlacklistManager> blacklistManagerProvider2, Provider<PackageRepository> packageRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.blacklistManagerProvider = blacklistManagerProvider2;
        this.packageRepositoryProvider = packageRepositoryProvider2;
        $jacocoInit[0] = true;
    }

    public WalletAdsOfferCardManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule flavourApplicationModule = this.module;
        Provider<BlacklistManager> provider = this.blacklistManagerProvider;
        $jacocoInit[1] = true;
        BlacklistManager blacklistManager = (BlacklistManager) provider.get();
        PackageRepository packageRepository = (PackageRepository) this.packageRepositoryProvider.get();
        $jacocoInit[2] = true;
        WalletAdsOfferCardManager providesWalletAdsOfferCardManager = flavourApplicationModule.providesWalletAdsOfferCardManager(blacklistManager, packageRepository);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesWalletAdsOfferCardManager, "Cannot return null from a non-@Nullable @Provides method");
        WalletAdsOfferCardManager walletAdsOfferCardManager = providesWalletAdsOfferCardManager;
        $jacocoInit[4] = true;
        return walletAdsOfferCardManager;
    }

    public static C13181b<WalletAdsOfferCardManager> create(FlavourApplicationModule module2, Provider<BlacklistManager> blacklistManagerProvider2, Provider<PackageRepository> packageRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        C1370x7d1c8138 flavourApplicationModule_ProvidesWalletAdsOfferCardManagerFactory = new C1370x7d1c8138(module2, blacklistManagerProvider2, packageRepositoryProvider2);
        $jacocoInit[5] = true;
        return flavourApplicationModule_ProvidesWalletAdsOfferCardManagerFactory;
    }

    public static WalletAdsOfferCardManager proxyProvidesWalletAdsOfferCardManager(FlavourApplicationModule instance, BlacklistManager blacklistManager, PackageRepository packageRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletAdsOfferCardManager providesWalletAdsOfferCardManager = instance.providesWalletAdsOfferCardManager(blacklistManager, packageRepository);
        $jacocoInit[6] = true;
        return providesWalletAdsOfferCardManager;
    }
}
