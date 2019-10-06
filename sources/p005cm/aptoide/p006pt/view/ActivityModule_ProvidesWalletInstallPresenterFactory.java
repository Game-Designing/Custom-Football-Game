package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.wallet.WalletInstallManager;
import p005cm.aptoide.p006pt.wallet.WalletInstallNavigator;
import p005cm.aptoide.p006pt.wallet.WalletInstallPresenter;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesWalletInstallPresenterFactory */
public final class ActivityModule_ProvidesWalletInstallPresenterFactory implements C13181b<WalletInstallPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityModule module;
    private final Provider<WalletInstallManager> walletInstallManagerProvider;
    private final Provider<WalletInstallNavigator> walletInstallNavigatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8711642865750792896L, "cm/aptoide/pt/view/ActivityModule_ProvidesWalletInstallPresenterFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesWalletInstallPresenterFactory(ActivityModule module2, Provider<WalletInstallNavigator> walletInstallNavigatorProvider2, Provider<WalletInstallManager> walletInstallManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.walletInstallNavigatorProvider = walletInstallNavigatorProvider2;
        this.walletInstallManagerProvider = walletInstallManagerProvider2;
        $jacocoInit[0] = true;
    }

    public WalletInstallPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<WalletInstallNavigator> provider = this.walletInstallNavigatorProvider;
        $jacocoInit[1] = true;
        WalletInstallNavigator walletInstallNavigator = (WalletInstallNavigator) provider.get();
        WalletInstallManager walletInstallManager = (WalletInstallManager) this.walletInstallManagerProvider.get();
        $jacocoInit[2] = true;
        WalletInstallPresenter providesWalletInstallPresenter = activityModule.providesWalletInstallPresenter(walletInstallNavigator, walletInstallManager);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesWalletInstallPresenter, "Cannot return null from a non-@Nullable @Provides method");
        WalletInstallPresenter walletInstallPresenter = providesWalletInstallPresenter;
        $jacocoInit[4] = true;
        return walletInstallPresenter;
    }

    public static C13181b<WalletInstallPresenter> create(ActivityModule module2, Provider<WalletInstallNavigator> walletInstallNavigatorProvider2, Provider<WalletInstallManager> walletInstallManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesWalletInstallPresenterFactory activityModule_ProvidesWalletInstallPresenterFactory = new ActivityModule_ProvidesWalletInstallPresenterFactory(module2, walletInstallNavigatorProvider2, walletInstallManagerProvider2);
        $jacocoInit[5] = true;
        return activityModule_ProvidesWalletInstallPresenterFactory;
    }

    public static WalletInstallPresenter proxyProvidesWalletInstallPresenter(ActivityModule instance, WalletInstallNavigator walletInstallNavigator, WalletInstallManager walletInstallManager) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallPresenter providesWalletInstallPresenter = instance.providesWalletInstallPresenter(walletInstallNavigator, walletInstallManager);
        $jacocoInit[6] = true;
        return providesWalletInstallPresenter;
    }
}
