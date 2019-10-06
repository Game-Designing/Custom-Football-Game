package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.wallet.WalletInstallConfiguration;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesWalletInstallConfigurationFactory */
public final class ActivityModule_ProvidesWalletInstallConfigurationFactory implements C13181b<WalletInstallConfiguration> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1415758779981489192L, "cm/aptoide/pt/view/ActivityModule_ProvidesWalletInstallConfigurationFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesWalletInstallConfigurationFactory(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public WalletInstallConfiguration get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        $jacocoInit[1] = true;
        WalletInstallConfiguration providesWalletInstallConfiguration = activityModule.providesWalletInstallConfiguration();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesWalletInstallConfiguration, "Cannot return null from a non-@Nullable @Provides method");
        WalletInstallConfiguration walletInstallConfiguration = providesWalletInstallConfiguration;
        $jacocoInit[3] = true;
        return walletInstallConfiguration;
    }

    public static C13181b<WalletInstallConfiguration> create(ActivityModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesWalletInstallConfigurationFactory activityModule_ProvidesWalletInstallConfigurationFactory = new ActivityModule_ProvidesWalletInstallConfigurationFactory(module2);
        $jacocoInit[4] = true;
        return activityModule_ProvidesWalletInstallConfigurationFactory;
    }

    public static WalletInstallConfiguration proxyProvidesWalletInstallConfiguration(ActivityModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallConfiguration providesWalletInstallConfiguration = instance.providesWalletInstallConfiguration();
        $jacocoInit[5] = true;
        return providesWalletInstallConfiguration;
    }
}
