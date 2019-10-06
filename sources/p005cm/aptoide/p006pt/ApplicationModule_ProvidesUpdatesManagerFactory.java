package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.apps.UpdatesManager;
import p005cm.aptoide.p006pt.updates.UpdateRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesUpdatesManagerFactory */
public final class ApplicationModule_ProvidesUpdatesManagerFactory implements C13181b<UpdatesManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<UpdateRepository> updateRepositoryProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5592157867107878272L, "cm/aptoide/pt/ApplicationModule_ProvidesUpdatesManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesUpdatesManagerFactory(ApplicationModule module2, Provider<UpdateRepository> updateRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.updateRepositoryProvider = updateRepositoryProvider2;
        $jacocoInit[0] = true;
    }

    public UpdatesManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<UpdateRepository> provider = this.updateRepositoryProvider;
        $jacocoInit[1] = true;
        UpdatesManager providesUpdatesManager = applicationModule.providesUpdatesManager((UpdateRepository) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesUpdatesManager, "Cannot return null from a non-@Nullable @Provides method");
        UpdatesManager updatesManager = providesUpdatesManager;
        $jacocoInit[3] = true;
        return updatesManager;
    }

    public static C13181b<UpdatesManager> create(ApplicationModule module2, Provider<UpdateRepository> updateRepositoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesUpdatesManagerFactory applicationModule_ProvidesUpdatesManagerFactory = new ApplicationModule_ProvidesUpdatesManagerFactory(module2, updateRepositoryProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesUpdatesManagerFactory;
    }

    public static UpdatesManager proxyProvidesUpdatesManager(ApplicationModule instance, UpdateRepository updateRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        UpdatesManager providesUpdatesManager = instance.providesUpdatesManager(updateRepository);
        $jacocoInit[5] = true;
        return providesUpdatesManager;
    }
}
