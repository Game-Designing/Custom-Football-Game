package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.install.PackageInstallerManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesPackageInstallerManagerFactory */
public final class ApplicationModule_ProvidesPackageInstallerManagerFactory implements C13181b<PackageInstallerManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4332549333842155926L, "cm/aptoide/pt/ApplicationModule_ProvidesPackageInstallerManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesPackageInstallerManagerFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public PackageInstallerManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        PackageInstallerManager providesPackageInstallerManager = applicationModule.providesPackageInstallerManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesPackageInstallerManager, "Cannot return null from a non-@Nullable @Provides method");
        PackageInstallerManager packageInstallerManager = providesPackageInstallerManager;
        $jacocoInit[3] = true;
        return packageInstallerManager;
    }

    public static C13181b<PackageInstallerManager> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesPackageInstallerManagerFactory applicationModule_ProvidesPackageInstallerManagerFactory = new ApplicationModule_ProvidesPackageInstallerManagerFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesPackageInstallerManagerFactory;
    }

    public static PackageInstallerManager proxyProvidesPackageInstallerManager(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        PackageInstallerManager providesPackageInstallerManager = instance.providesPackageInstallerManager();
        $jacocoInit[5] = true;
        return providesPackageInstallerManager;
    }
}
