package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.appview.PreferencesPersister;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesUserPreferencesPersisterFactory */
public final class ApplicationModule_ProvidesUserPreferencesPersisterFactory implements C13181b<PreferencesPersister> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2834146857343246077L, "cm/aptoide/pt/ApplicationModule_ProvidesUserPreferencesPersisterFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesUserPreferencesPersisterFactory(ApplicationModule module2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public PreferencesPersister get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<SharedPreferences> provider = this.sharedPreferencesProvider;
        $jacocoInit[1] = true;
        PreferencesPersister providesUserPreferencesPersister = applicationModule.providesUserPreferencesPersister((SharedPreferences) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesUserPreferencesPersister, "Cannot return null from a non-@Nullable @Provides method");
        PreferencesPersister preferencesPersister = providesUserPreferencesPersister;
        $jacocoInit[3] = true;
        return preferencesPersister;
    }

    public static C13181b<PreferencesPersister> create(ApplicationModule module2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesUserPreferencesPersisterFactory applicationModule_ProvidesUserPreferencesPersisterFactory = new ApplicationModule_ProvidesUserPreferencesPersisterFactory(module2, sharedPreferencesProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesUserPreferencesPersisterFactory;
    }

    public static PreferencesPersister proxyProvidesUserPreferencesPersister(ApplicationModule instance, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        PreferencesPersister providesUserPreferencesPersister = instance.providesUserPreferencesPersister(sharedPreferences);
        $jacocoInit[5] = true;
        return providesUserPreferencesPersister;
    }
}
