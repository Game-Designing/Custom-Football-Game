package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.install.AppInstallerStatusReceiver;
import p005cm.aptoide.p006pt.packageinstaller.AppInstaller;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAppInstallerFactory */
public final class ApplicationModule_ProvidesAppInstallerFactory implements C13181b<AppInstaller> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppInstallerStatusReceiver> appInstallerStatusReceiverProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8622482762769346146L, "cm/aptoide/pt/ApplicationModule_ProvidesAppInstallerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAppInstallerFactory(ApplicationModule module2, Provider<AppInstallerStatusReceiver> appInstallerStatusReceiverProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.appInstallerStatusReceiverProvider = appInstallerStatusReceiverProvider2;
        $jacocoInit[0] = true;
    }

    public AppInstaller get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AppInstallerStatusReceiver> provider = this.appInstallerStatusReceiverProvider;
        $jacocoInit[1] = true;
        AppInstaller providesAppInstaller = applicationModule.providesAppInstaller((AppInstallerStatusReceiver) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAppInstaller, "Cannot return null from a non-@Nullable @Provides method");
        AppInstaller appInstaller = providesAppInstaller;
        $jacocoInit[3] = true;
        return appInstaller;
    }

    public static C13181b<AppInstaller> create(ApplicationModule module2, Provider<AppInstallerStatusReceiver> appInstallerStatusReceiverProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAppInstallerFactory applicationModule_ProvidesAppInstallerFactory = new ApplicationModule_ProvidesAppInstallerFactory(module2, appInstallerStatusReceiverProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAppInstallerFactory;
    }

    public static AppInstaller proxyProvidesAppInstaller(ApplicationModule instance, AppInstallerStatusReceiver appInstallerStatusReceiver) {
        boolean[] $jacocoInit = $jacocoInit();
        AppInstaller providesAppInstaller = instance.providesAppInstaller(appInstallerStatusReceiver);
        $jacocoInit[5] = true;
        return providesAppInstaller;
    }
}
