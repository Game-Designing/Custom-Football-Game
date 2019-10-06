package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideSearchBaseUrlFactory */
public final class ApplicationModule_ProvideSearchBaseUrlFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8614752179206301460L, "cm/aptoide/pt/ApplicationModule_ProvideSearchBaseUrlFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideSearchBaseUrlFactory(ApplicationModule module2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public String get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<SharedPreferences> provider = this.sharedPreferencesProvider;
        $jacocoInit[1] = true;
        String provideSearchBaseUrl = applicationModule.provideSearchBaseUrl((SharedPreferences) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideSearchBaseUrl, "Cannot return null from a non-@Nullable @Provides method");
        String str = provideSearchBaseUrl;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(ApplicationModule module2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideSearchBaseUrlFactory applicationModule_ProvideSearchBaseUrlFactory = new ApplicationModule_ProvideSearchBaseUrlFactory(module2, sharedPreferencesProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideSearchBaseUrlFactory;
    }

    public static String proxyProvideSearchBaseUrl(ApplicationModule instance, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        String provideSearchBaseUrl = instance.provideSearchBaseUrl(sharedPreferences);
        $jacocoInit[5] = true;
        return provideSearchBaseUrl;
    }
}
