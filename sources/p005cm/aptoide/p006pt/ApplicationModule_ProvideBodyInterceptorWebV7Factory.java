package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import android.content.res.Resources;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideBodyInterceptorWebV7Factory */
public final class ApplicationModule_ProvideBodyInterceptorWebV7Factory implements C13181b<BodyInterceptor<BaseBody>> {
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
        boolean[] probes = Offline.getProbes(-6978234748937960674L, "cm/aptoide/pt/ApplicationModule_ProvideBodyInterceptorWebV7Factory", 13);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideBodyInterceptorWebV7Factory(ApplicationModule module2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<IdsRepository> idsRepositoryProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<Resources> resourcesProvider2, Provider<QManager> qManagerProvider2, Provider<String> aptoidePackageProvider2) {
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

    public BodyInterceptor<BaseBody> get() {
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
        BodyInterceptor<BaseBody> provideBodyInterceptorWebV7 = applicationModule.provideBodyInterceptorWebV7(authenticationPersistence, idsRepository, sharedPreferences, resources, qManager, str);
        $jacocoInit[8] = true;
        C13182c.m43111a(provideBodyInterceptorWebV7, "Cannot return null from a non-@Nullable @Provides method");
        BodyInterceptor<BaseBody> bodyInterceptor = provideBodyInterceptorWebV7;
        $jacocoInit[9] = true;
        return bodyInterceptor;
    }

    public static C13181b<BodyInterceptor<BaseBody>> create(ApplicationModule module2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<IdsRepository> idsRepositoryProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<Resources> resourcesProvider2, Provider<QManager> qManagerProvider2, Provider<String> aptoidePackageProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideBodyInterceptorWebV7Factory applicationModule_ProvideBodyInterceptorWebV7Factory = new ApplicationModule_ProvideBodyInterceptorWebV7Factory(module2, authenticationPersistenceProvider2, idsRepositoryProvider2, sharedPreferencesProvider2, resourcesProvider2, qManagerProvider2, aptoidePackageProvider2);
        $jacocoInit[10] = true;
        return applicationModule_ProvideBodyInterceptorWebV7Factory;
    }

    public static BodyInterceptor<BaseBody> proxyProvideBodyInterceptorWebV7(ApplicationModule instance, AuthenticationPersistence authenticationPersistence, IdsRepository idsRepository, SharedPreferences sharedPreferences, Resources resources, QManager qManager, String aptoidePackage) {
        boolean[] $jacocoInit = $jacocoInit();
        BodyInterceptor<BaseBody> provideBodyInterceptorWebV7 = instance.provideBodyInterceptorWebV7(authenticationPersistence, idsRepository, sharedPreferences, resources, qManager, aptoidePackage);
        $jacocoInit[11] = true;
        return provideBodyInterceptorWebV7;
    }
}
