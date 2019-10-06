package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.install.AppInstallerStatusReceiver;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAppInstallerStatusReceiverFactory */
public final class ApplicationModule_ProvidesAppInstallerStatusReceiverFactory implements C13181b<AppInstallerStatusReceiver> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3413245974506864758L, "cm/aptoide/pt/ApplicationModule_ProvidesAppInstallerStatusReceiverFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAppInstallerStatusReceiverFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public AppInstallerStatusReceiver get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        AppInstallerStatusReceiver providesAppInstallerStatusReceiver = applicationModule.providesAppInstallerStatusReceiver();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAppInstallerStatusReceiver, "Cannot return null from a non-@Nullable @Provides method");
        AppInstallerStatusReceiver appInstallerStatusReceiver = providesAppInstallerStatusReceiver;
        $jacocoInit[3] = true;
        return appInstallerStatusReceiver;
    }

    public static C13181b<AppInstallerStatusReceiver> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAppInstallerStatusReceiverFactory applicationModule_ProvidesAppInstallerStatusReceiverFactory = new ApplicationModule_ProvidesAppInstallerStatusReceiverFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAppInstallerStatusReceiverFactory;
    }

    public static AppInstallerStatusReceiver proxyProvidesAppInstallerStatusReceiver(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        AppInstallerStatusReceiver providesAppInstallerStatusReceiver = instance.providesAppInstallerStatusReceiver();
        $jacocoInit[5] = true;
        return providesAppInstallerStatusReceiver;
    }
}
