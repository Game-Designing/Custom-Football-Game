package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.installer.RootInstallationRetryHandler;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideRootInstallationRetryHandlerFactory */
public final class ApplicationModule_ProvideRootInstallationRetryHandlerFactory implements C13181b<RootInstallationRetryHandler> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<InstallManager> installManagerProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4242147634116658469L, "cm/aptoide/pt/ApplicationModule_ProvideRootInstallationRetryHandlerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideRootInstallationRetryHandlerFactory(ApplicationModule module2, Provider<InstallManager> installManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.installManagerProvider = installManagerProvider2;
        $jacocoInit[0] = true;
    }

    public RootInstallationRetryHandler get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<InstallManager> provider = this.installManagerProvider;
        $jacocoInit[1] = true;
        RootInstallationRetryHandler provideRootInstallationRetryHandler = applicationModule.provideRootInstallationRetryHandler((InstallManager) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideRootInstallationRetryHandler, "Cannot return null from a non-@Nullable @Provides method");
        RootInstallationRetryHandler rootInstallationRetryHandler = provideRootInstallationRetryHandler;
        $jacocoInit[3] = true;
        return rootInstallationRetryHandler;
    }

    public static C13181b<RootInstallationRetryHandler> create(ApplicationModule module2, Provider<InstallManager> installManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideRootInstallationRetryHandlerFactory applicationModule_ProvideRootInstallationRetryHandlerFactory = new ApplicationModule_ProvideRootInstallationRetryHandlerFactory(module2, installManagerProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideRootInstallationRetryHandlerFactory;
    }

    public static RootInstallationRetryHandler proxyProvideRootInstallationRetryHandler(ApplicationModule instance, InstallManager installManager) {
        boolean[] $jacocoInit = $jacocoInit();
        RootInstallationRetryHandler provideRootInstallationRetryHandler = instance.provideRootInstallationRetryHandler(installManager);
        $jacocoInit[5] = true;
        return provideRootInstallationRetryHandler;
    }
}
