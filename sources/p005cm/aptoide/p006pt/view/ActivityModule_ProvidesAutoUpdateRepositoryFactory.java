package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.autoupdate.AutoUpdateRepository;
import p005cm.aptoide.p006pt.autoupdate.AutoUpdateService;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesAutoUpdateRepositoryFactory */
public final class ActivityModule_ProvidesAutoUpdateRepositoryFactory implements C13181b<AutoUpdateRepository> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AutoUpdateService> autoUpdateServiceProvider;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8427946424123067425L, "cm/aptoide/pt/view/ActivityModule_ProvidesAutoUpdateRepositoryFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesAutoUpdateRepositoryFactory(ActivityModule module2, Provider<AutoUpdateService> autoUpdateServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.autoUpdateServiceProvider = autoUpdateServiceProvider2;
        $jacocoInit[0] = true;
    }

    public AutoUpdateRepository get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<AutoUpdateService> provider = this.autoUpdateServiceProvider;
        $jacocoInit[1] = true;
        AutoUpdateRepository providesAutoUpdateRepository = activityModule.providesAutoUpdateRepository((AutoUpdateService) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAutoUpdateRepository, "Cannot return null from a non-@Nullable @Provides method");
        AutoUpdateRepository autoUpdateRepository = providesAutoUpdateRepository;
        $jacocoInit[3] = true;
        return autoUpdateRepository;
    }

    public static C13181b<AutoUpdateRepository> create(ActivityModule module2, Provider<AutoUpdateService> autoUpdateServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesAutoUpdateRepositoryFactory activityModule_ProvidesAutoUpdateRepositoryFactory = new ActivityModule_ProvidesAutoUpdateRepositoryFactory(module2, autoUpdateServiceProvider2);
        $jacocoInit[4] = true;
        return activityModule_ProvidesAutoUpdateRepositoryFactory;
    }

    public static AutoUpdateRepository proxyProvidesAutoUpdateRepository(ActivityModule instance, AutoUpdateService autoUpdateService) {
        boolean[] $jacocoInit = $jacocoInit();
        AutoUpdateRepository providesAutoUpdateRepository = instance.providesAutoUpdateRepository(autoUpdateService);
        $jacocoInit[5] = true;
        return providesAutoUpdateRepository;
    }
}
