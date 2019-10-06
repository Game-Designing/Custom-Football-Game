package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import android.content.res.Resources;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.analytics.analytics.AnalyticsBodyInterceptorV7;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideAnalyticsBodyInterceptorV7Factory */
public final class ApplicationModule_ProvideAnalyticsBodyInterceptorV7Factory implements C13181b<AnalyticsBodyInterceptorV7> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> aptoidePackageProvider;
    private final Provider<AuthenticationPersistence> authenticationPersistenceProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final ApplicationModule module;
    private final Provider<QManager> qManagerProvider;
    private final Provider<Resources> resourcesProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8803313312862585307L, "cm/aptoide/pt/ApplicationModule_ProvideAnalyticsBodyInterceptorV7Factory", 13);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideAnalyticsBodyInterceptorV7Factory(ApplicationModule module2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<IdsRepository> idsRepositoryProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<Resources> resourcesProvider2, Provider<QManager> qManagerProvider2, Provider<String> aptoidePackageProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.authenticationPersistenceProvider = authenticationPersistenceProvider2;
        this.idsRepositoryProvider = idsRepositoryProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.resourcesProvider = resourcesProvider2;
        this.qManagerProvider = qManagerProvider2;
        this.aptoidePackageProvider = aptoidePackageProvider2;
        $jacocoInit[0] = true;
    }

    public AnalyticsBodyInterceptorV7 get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<AuthenticationPersistence> provider = this.authenticationPersistenceProvider;
        $jacocoInit[1] = true;
        AuthenticationPersistence authenticationPersistence = (AuthenticationPersistence) provider.get();
        Provider<IdsRepository> provider2 = this.idsRepositoryProvider;
        $jacocoInit[2] = true;
        IdsRepository idsRepository = (IdsRepository) provider2.get();
        Provider<SharedPreferences> provider3 = this.sharedPreferencesProvider;
        $jacocoInit[3] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider3.get();
        Provider<Resources> provider4 = this.resourcesProvider;
        $jacocoInit[4] = true;
        Resources resources = (Resources) provider4.get();
        Provider<QManager> provider5 = this.qManagerProvider;
        $jacocoInit[5] = true;
        QManager qManager = (QManager) provider5.get();
        Provider<String> provider6 = this.aptoidePackageProvider;
        $jacocoInit[6] = true;
        String str = (String) provider6.get();
        $jacocoInit[7] = true;
        AnalyticsBodyInterceptorV7 provideAnalyticsBodyInterceptorV7 = applicationModule.provideAnalyticsBodyInterceptorV7(authenticationPersistence, idsRepository, sharedPreferences, resources, qManager, str);
        $jacocoInit[8] = true;
        C13182c.m43111a(provideAnalyticsBodyInterceptorV7, "Cannot return null from a non-@Nullable @Provides method");
        AnalyticsBodyInterceptorV7 analyticsBodyInterceptorV7 = provideAnalyticsBodyInterceptorV7;
        $jacocoInit[9] = true;
        return analyticsBodyInterceptorV7;
    }

    public static C13181b<AnalyticsBodyInterceptorV7> create(ApplicationModule module2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<IdsRepository> idsRepositoryProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<Resources> resourcesProvider2, Provider<QManager> qManagerProvider2, Provider<String> aptoidePackageProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideAnalyticsBodyInterceptorV7Factory applicationModule_ProvideAnalyticsBodyInterceptorV7Factory = new ApplicationModule_ProvideAnalyticsBodyInterceptorV7Factory(module2, authenticationPersistenceProvider2, idsRepositoryProvider2, sharedPreferencesProvider2, resourcesProvider2, qManagerProvider2, aptoidePackageProvider2);
        $jacocoInit[10] = true;
        return applicationModule_ProvideAnalyticsBodyInterceptorV7Factory;
    }

    public static AnalyticsBodyInterceptorV7 proxyProvideAnalyticsBodyInterceptorV7(ApplicationModule instance, AuthenticationPersistence authenticationPersistence, IdsRepository idsRepository, SharedPreferences sharedPreferences, Resources resources, QManager qManager, String aptoidePackage) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsBodyInterceptorV7 provideAnalyticsBodyInterceptorV7 = instance.provideAnalyticsBodyInterceptorV7(authenticationPersistence, idsRepository, sharedPreferences, resources, qManager, aptoidePackage);
        $jacocoInit[11] = true;
        return provideAnalyticsBodyInterceptorV7;
    }
}
