package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesBaseSecondaryHostFactory */
public final class ApplicationModule_ProvidesBaseSecondaryHostFactory implements C13181b<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2822756287844152782L, "cm/aptoide/pt/ApplicationModule_ProvidesBaseSecondaryHostFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesBaseSecondaryHostFactory(ApplicationModule module2, Provider<SharedPreferences> sharedPreferencesProvider2) {
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
        String providesBaseSecondaryHost = applicationModule.providesBaseSecondaryHost((SharedPreferences) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesBaseSecondaryHost, "Cannot return null from a non-@Nullable @Provides method");
        String str = providesBaseSecondaryHost;
        $jacocoInit[3] = true;
        return str;
    }

    public static C13181b<String> create(ApplicationModule module2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesBaseSecondaryHostFactory applicationModule_ProvidesBaseSecondaryHostFactory = new ApplicationModule_ProvidesBaseSecondaryHostFactory(module2, sharedPreferencesProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesBaseSecondaryHostFactory;
    }

    public static String proxyProvidesBaseSecondaryHost(ApplicationModule instance, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        String providesBaseSecondaryHost = instance.providesBaseSecondaryHost(sharedPreferences);
        $jacocoInit[5] = true;
        return providesBaseSecondaryHost;
    }
}
