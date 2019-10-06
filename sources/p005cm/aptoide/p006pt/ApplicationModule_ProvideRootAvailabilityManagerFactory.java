package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.preferences.SecurePreferences;
import p005cm.aptoide.p006pt.root.RootAvailabilityManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideRootAvailabilityManagerFactory */
public final class ApplicationModule_ProvideRootAvailabilityManagerFactory implements C13181b<RootAvailabilityManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<SecurePreferences> securePreferencesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3108363494969414520L, "cm/aptoide/pt/ApplicationModule_ProvideRootAvailabilityManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideRootAvailabilityManagerFactory(ApplicationModule module2, Provider<SecurePreferences> securePreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.securePreferencesProvider = securePreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public RootAvailabilityManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<SecurePreferences> provider = this.securePreferencesProvider;
        $jacocoInit[1] = true;
        RootAvailabilityManager provideRootAvailabilityManager = applicationModule.provideRootAvailabilityManager((SecurePreferences) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideRootAvailabilityManager, "Cannot return null from a non-@Nullable @Provides method");
        RootAvailabilityManager rootAvailabilityManager = provideRootAvailabilityManager;
        $jacocoInit[3] = true;
        return rootAvailabilityManager;
    }

    public static C13181b<RootAvailabilityManager> create(ApplicationModule module2, Provider<SecurePreferences> securePreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideRootAvailabilityManagerFactory applicationModule_ProvideRootAvailabilityManagerFactory = new ApplicationModule_ProvideRootAvailabilityManagerFactory(module2, securePreferencesProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideRootAvailabilityManagerFactory;
    }

    public static RootAvailabilityManager proxyProvideRootAvailabilityManager(ApplicationModule instance, SecurePreferences securePreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        RootAvailabilityManager provideRootAvailabilityManager = instance.provideRootAvailabilityManager(securePreferences);
        $jacocoInit[5] = true;
        return provideRootAvailabilityManager;
    }
}
