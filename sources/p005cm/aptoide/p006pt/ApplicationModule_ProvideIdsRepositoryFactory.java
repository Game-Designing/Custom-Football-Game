package p005cm.aptoide.p006pt;

import android.content.ContentResolver;
import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideIdsRepositoryFactory */
public final class ApplicationModule_ProvideIdsRepositoryFactory implements C13181b<IdsRepository> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<ContentResolver> contentResolverProvider;
    private final Provider<SharedPreferences> defaultSharedPreferencesProvider;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7281557491912975414L, "cm/aptoide/pt/ApplicationModule_ProvideIdsRepositoryFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideIdsRepositoryFactory(ApplicationModule module2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<ContentResolver> contentResolverProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.defaultSharedPreferencesProvider = defaultSharedPreferencesProvider2;
        this.contentResolverProvider = contentResolverProvider2;
        $jacocoInit[0] = true;
    }

    public IdsRepository get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<SharedPreferences> provider = this.defaultSharedPreferencesProvider;
        $jacocoInit[1] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider.get();
        ContentResolver contentResolver = (ContentResolver) this.contentResolverProvider.get();
        $jacocoInit[2] = true;
        IdsRepository provideIdsRepository = applicationModule.provideIdsRepository(sharedPreferences, contentResolver);
        $jacocoInit[3] = true;
        C13182c.m43111a(provideIdsRepository, "Cannot return null from a non-@Nullable @Provides method");
        IdsRepository idsRepository = provideIdsRepository;
        $jacocoInit[4] = true;
        return idsRepository;
    }

    public static C13181b<IdsRepository> create(ApplicationModule module2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<ContentResolver> contentResolverProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideIdsRepositoryFactory applicationModule_ProvideIdsRepositoryFactory = new ApplicationModule_ProvideIdsRepositoryFactory(module2, defaultSharedPreferencesProvider2, contentResolverProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvideIdsRepositoryFactory;
    }

    public static IdsRepository proxyProvideIdsRepository(ApplicationModule instance, SharedPreferences defaultSharedPreferences, ContentResolver contentResolver) {
        boolean[] $jacocoInit = $jacocoInit();
        IdsRepository provideIdsRepository = instance.provideIdsRepository(defaultSharedPreferences, contentResolver);
        $jacocoInit[6] = true;
        return provideIdsRepository;
    }
}
