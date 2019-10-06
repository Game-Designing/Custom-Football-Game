package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.app.AppCenter;
import p005cm.aptoide.p006pt.view.app.AppCenterRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAppCenterFactory */
public final class ApplicationModule_ProvidesAppCenterFactory implements C13181b<AppCenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppCenterRepository> appCenterRepositoryProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1335091938714579528L, "cm/aptoide/pt/ApplicationModule_ProvidesAppCenterFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAppCenterFactory(ApplicationModule module2, Provider<AppCenterRepository> appCenterRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.appCenterRepositoryProvider = appCenterRepositoryProvider2;
        $jacocoInit[0] = true;
    }

    public AppCenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AppCenterRepository> provider = this.appCenterRepositoryProvider;
        $jacocoInit[1] = true;
        AppCenter providesAppCenter = applicationModule.providesAppCenter((AppCenterRepository) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAppCenter, "Cannot return null from a non-@Nullable @Provides method");
        AppCenter appCenter = providesAppCenter;
        $jacocoInit[3] = true;
        return appCenter;
    }

    public static C13181b<AppCenter> create(ApplicationModule module2, Provider<AppCenterRepository> appCenterRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAppCenterFactory applicationModule_ProvidesAppCenterFactory = new ApplicationModule_ProvidesAppCenterFactory(module2, appCenterRepositoryProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAppCenterFactory;
    }

    public static AppCenter proxyProvidesAppCenter(ApplicationModule instance, AppCenterRepository appCenterRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        AppCenter providesAppCenter = instance.providesAppCenter(appCenterRepository);
        $jacocoInit[5] = true;
        return providesAppCenter;
    }
}
