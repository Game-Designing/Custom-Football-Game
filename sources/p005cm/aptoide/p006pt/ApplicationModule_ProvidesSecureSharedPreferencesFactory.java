package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesSecureSharedPreferencesFactory */
public final class ApplicationModule_ProvidesSecureSharedPreferencesFactory implements C13181b<SharedPreferences> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<SharedPreferences> defaultSharedPreferencesProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-496562613996881239L, "cm/aptoide/pt/ApplicationModule_ProvidesSecureSharedPreferencesFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesSecureSharedPreferencesFactory(ApplicationModule module2, Provider<SharedPreferences> defaultSharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.defaultSharedPreferencesProvider = defaultSharedPreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public SharedPreferences get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<SharedPreferences> provider = this.defaultSharedPreferencesProvider;
        $jacocoInit[1] = true;
        SharedPreferences providesSecureSharedPreferences = applicationModule.providesSecureSharedPreferences((SharedPreferences) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesSecureSharedPreferences, "Cannot return null from a non-@Nullable @Provides method");
        SharedPreferences sharedPreferences = providesSecureSharedPreferences;
        $jacocoInit[3] = true;
        return sharedPreferences;
    }

    public static C13181b<SharedPreferences> create(ApplicationModule module2, Provider<SharedPreferences> defaultSharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesSecureSharedPreferencesFactory applicationModule_ProvidesSecureSharedPreferencesFactory = new ApplicationModule_ProvidesSecureSharedPreferencesFactory(module2, defaultSharedPreferencesProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesSecureSharedPreferencesFactory;
    }

    public static SharedPreferences proxyProvidesSecureSharedPreferences(ApplicationModule instance, SharedPreferences defaultSharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        SharedPreferences providesSecureSharedPreferences = instance.providesSecureSharedPreferences(defaultSharedPreferences);
        $jacocoInit[5] = true;
        return providesSecureSharedPreferences;
    }
}
