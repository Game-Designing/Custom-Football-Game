package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.preferences.Preferences;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideDefaultPreferencesFactory */
public final class ApplicationModule_ProvideDefaultPreferencesFactory implements C13181b<Preferences> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9024120802414069158L, "cm/aptoide/pt/ApplicationModule_ProvideDefaultPreferencesFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideDefaultPreferencesFactory(ApplicationModule module2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public Preferences get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<SharedPreferences> provider = this.sharedPreferencesProvider;
        $jacocoInit[1] = true;
        Preferences provideDefaultPreferences = applicationModule.provideDefaultPreferences((SharedPreferences) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideDefaultPreferences, "Cannot return null from a non-@Nullable @Provides method");
        Preferences preferences = provideDefaultPreferences;
        $jacocoInit[3] = true;
        return preferences;
    }

    public static C13181b<Preferences> create(ApplicationModule module2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideDefaultPreferencesFactory applicationModule_ProvideDefaultPreferencesFactory = new ApplicationModule_ProvideDefaultPreferencesFactory(module2, sharedPreferencesProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideDefaultPreferencesFactory;
    }

    public static Preferences proxyProvideDefaultPreferences(ApplicationModule instance, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        Preferences provideDefaultPreferences = instance.provideDefaultPreferences(sharedPreferences);
        $jacocoInit[5] = true;
        return provideDefaultPreferences;
    }
}
