package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.appview.PreferencesPersister;
import p005cm.aptoide.p006pt.promotions.PromotionsPreferencesManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesPromotionsPreferencesManagerFactory */
public final class ApplicationModule_ProvidesPromotionsPreferencesManagerFactory implements C13181b<PromotionsPreferencesManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<PreferencesPersister> persisterProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7801273708456472392L, "cm/aptoide/pt/ApplicationModule_ProvidesPromotionsPreferencesManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesPromotionsPreferencesManagerFactory(ApplicationModule module2, Provider<PreferencesPersister> persisterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.persisterProvider = persisterProvider2;
        $jacocoInit[0] = true;
    }

    public PromotionsPreferencesManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<PreferencesPersister> provider = this.persisterProvider;
        $jacocoInit[1] = true;
        PromotionsPreferencesManager providesPromotionsPreferencesManager = applicationModule.providesPromotionsPreferencesManager((PreferencesPersister) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesPromotionsPreferencesManager, "Cannot return null from a non-@Nullable @Provides method");
        PromotionsPreferencesManager promotionsPreferencesManager = providesPromotionsPreferencesManager;
        $jacocoInit[3] = true;
        return promotionsPreferencesManager;
    }

    public static C13181b<PromotionsPreferencesManager> create(ApplicationModule module2, Provider<PreferencesPersister> persisterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesPromotionsPreferencesManagerFactory applicationModule_ProvidesPromotionsPreferencesManagerFactory = new ApplicationModule_ProvidesPromotionsPreferencesManagerFactory(module2, persisterProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesPromotionsPreferencesManagerFactory;
    }

    public static PromotionsPreferencesManager proxyProvidesPromotionsPreferencesManager(ApplicationModule instance, PreferencesPersister persister) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsPreferencesManager providesPromotionsPreferencesManager = instance.providesPromotionsPreferencesManager(persister);
        $jacocoInit[5] = true;
        return providesPromotionsPreferencesManager;
    }
}
