package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.blacklist.BlacklistPersistence;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesBlacklistPersistenceFactory */
public final class ApplicationModule_ProvidesBlacklistPersistenceFactory implements C13181b<BlacklistPersistence> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-938369430146824028L, "cm/aptoide/pt/ApplicationModule_ProvidesBlacklistPersistenceFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesBlacklistPersistenceFactory(ApplicationModule module2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public BlacklistPersistence get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<SharedPreferences> provider = this.sharedPreferencesProvider;
        $jacocoInit[1] = true;
        BlacklistPersistence providesBlacklistPersistence = applicationModule.providesBlacklistPersistence((SharedPreferences) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesBlacklistPersistence, "Cannot return null from a non-@Nullable @Provides method");
        BlacklistPersistence blacklistPersistence = providesBlacklistPersistence;
        $jacocoInit[3] = true;
        return blacklistPersistence;
    }

    public static C13181b<BlacklistPersistence> create(ApplicationModule module2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesBlacklistPersistenceFactory applicationModule_ProvidesBlacklistPersistenceFactory = new ApplicationModule_ProvidesBlacklistPersistenceFactory(module2, sharedPreferencesProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesBlacklistPersistenceFactory;
    }

    public static BlacklistPersistence proxyProvidesBlacklistPersistence(ApplicationModule instance, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        BlacklistPersistence providesBlacklistPersistence = instance.providesBlacklistPersistence(sharedPreferences);
        $jacocoInit[5] = true;
        return providesBlacklistPersistence;
    }
}
