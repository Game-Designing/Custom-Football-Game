package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.file.CacheHelper;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideCacheHelperFactory */
public final class ApplicationModule_ProvideCacheHelperFactory implements C13181b<CacheHelper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> cachePathProvider;
    private final Provider<SharedPreferences> defaultSharedPreferencesProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6530657033440974471L, "cm/aptoide/pt/ApplicationModule_ProvideCacheHelperFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideCacheHelperFactory(ApplicationModule module2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<String> cachePathProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.defaultSharedPreferencesProvider = defaultSharedPreferencesProvider2;
        this.cachePathProvider = cachePathProvider2;
        $jacocoInit[0] = true;
    }

    public CacheHelper get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<SharedPreferences> provider = this.defaultSharedPreferencesProvider;
        $jacocoInit[1] = true;
        CacheHelper provideCacheHelper = applicationModule.provideCacheHelper((SharedPreferences) provider.get(), (String) this.cachePathProvider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideCacheHelper, "Cannot return null from a non-@Nullable @Provides method");
        CacheHelper cacheHelper = provideCacheHelper;
        $jacocoInit[3] = true;
        return cacheHelper;
    }

    public static C13181b<CacheHelper> create(ApplicationModule module2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<String> cachePathProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideCacheHelperFactory applicationModule_ProvideCacheHelperFactory = new ApplicationModule_ProvideCacheHelperFactory(module2, defaultSharedPreferencesProvider2, cachePathProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideCacheHelperFactory;
    }

    public static CacheHelper proxyProvideCacheHelper(ApplicationModule instance, SharedPreferences defaultSharedPreferences, String cachePath) {
        boolean[] $jacocoInit = $jacocoInit();
        CacheHelper provideCacheHelper = instance.provideCacheHelper(defaultSharedPreferences, cachePath);
        $jacocoInit[5] = true;
        return provideCacheHelper;
    }
}
