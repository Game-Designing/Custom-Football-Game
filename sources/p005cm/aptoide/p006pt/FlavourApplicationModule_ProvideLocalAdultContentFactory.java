package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.preferences.LocalPersistenceAdultContent;
import p005cm.aptoide.p006pt.preferences.Preferences;
import p005cm.aptoide.p006pt.preferences.SecurePreferences;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.FlavourApplicationModule_ProvideLocalAdultContentFactory */
public final class FlavourApplicationModule_ProvideLocalAdultContentFactory implements C13181b<LocalPersistenceAdultContent> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FlavourApplicationModule module;
    private final Provider<Preferences> preferencesProvider;
    private final Provider<SecurePreferences> securePreferencesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2153141326722330145L, "cm/aptoide/pt/FlavourApplicationModule_ProvideLocalAdultContentFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FlavourApplicationModule_ProvideLocalAdultContentFactory(FlavourApplicationModule module2, Provider<Preferences> preferencesProvider2, Provider<SecurePreferences> securePreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.preferencesProvider = preferencesProvider2;
        this.securePreferencesProvider = securePreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public LocalPersistenceAdultContent get() {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule flavourApplicationModule = this.module;
        Provider<Preferences> provider = this.preferencesProvider;
        $jacocoInit[1] = true;
        LocalPersistenceAdultContent provideLocalAdultContent = flavourApplicationModule.provideLocalAdultContent((Preferences) provider.get(), (SecurePreferences) this.securePreferencesProvider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(provideLocalAdultContent, "Cannot return null from a non-@Nullable @Provides method");
        LocalPersistenceAdultContent localPersistenceAdultContent = provideLocalAdultContent;
        $jacocoInit[3] = true;
        return localPersistenceAdultContent;
    }

    public static C13181b<LocalPersistenceAdultContent> create(FlavourApplicationModule module2, Provider<Preferences> preferencesProvider2, Provider<SecurePreferences> securePreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule_ProvideLocalAdultContentFactory flavourApplicationModule_ProvideLocalAdultContentFactory = new FlavourApplicationModule_ProvideLocalAdultContentFactory(module2, preferencesProvider2, securePreferencesProvider2);
        $jacocoInit[4] = true;
        return flavourApplicationModule_ProvideLocalAdultContentFactory;
    }

    public static LocalPersistenceAdultContent proxyProvideLocalAdultContent(FlavourApplicationModule instance, Preferences preferences, SecurePreferences securePreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        LocalPersistenceAdultContent provideLocalAdultContent = instance.provideLocalAdultContent(preferences, securePreferences);
        $jacocoInit[5] = true;
        return provideLocalAdultContent;
    }
}
