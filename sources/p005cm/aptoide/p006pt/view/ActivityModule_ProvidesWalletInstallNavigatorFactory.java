package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.wallet.WalletInstallNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesWalletInstallNavigatorFactory */
public final class ActivityModule_ProvidesWalletInstallNavigatorFactory implements C13181b<WalletInstallNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4334018913053758484L, "cm/aptoide/pt/view/ActivityModule_ProvidesWalletInstallNavigatorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesWalletInstallNavigatorFactory(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public WalletInstallNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<FragmentNavigator> provider = this.fragmentNavigatorProvider;
        $jacocoInit[1] = true;
        WalletInstallNavigator providesWalletInstallNavigator = activityModule.providesWalletInstallNavigator((FragmentNavigator) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesWalletInstallNavigator, "Cannot return null from a non-@Nullable @Provides method");
        WalletInstallNavigator walletInstallNavigator = providesWalletInstallNavigator;
        $jacocoInit[3] = true;
        return walletInstallNavigator;
    }

    public static C13181b<WalletInstallNavigator> create(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesWalletInstallNavigatorFactory activityModule_ProvidesWalletInstallNavigatorFactory = new ActivityModule_ProvidesWalletInstallNavigatorFactory(module2, fragmentNavigatorProvider2);
        $jacocoInit[4] = true;
        return activityModule_ProvidesWalletInstallNavigatorFactory;
    }

    public static WalletInstallNavigator proxyProvidesWalletInstallNavigator(ActivityModule instance, FragmentNavigator fragmentNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallNavigator providesWalletInstallNavigator = instance.providesWalletInstallNavigator(fragmentNavigator);
        $jacocoInit[5] = true;
        return providesWalletInstallNavigator;
    }
}
