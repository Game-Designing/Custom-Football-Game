package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.NetworkOperatorManager;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesBodyInterceptorV3Factory */
public final class ApplicationModule_ProvidesBodyInterceptorV3Factory implements C13181b<BodyInterceptor<BaseBody>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> aptoidePackageProvider;
    private final Provider<AuthenticationPersistence> authenticationPersistenceProvider;
    private final Provider<SharedPreferences> defaultSharedPreferencesProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final ApplicationModule module;
    private final Provider<NetworkOperatorManager> networkOperatorManagerProvider;
    private final Provider<QManager> qManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2234472014020834461L, "cm/aptoide/pt/ApplicationModule_ProvidesBodyInterceptorV3Factory", 13);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesBodyInterceptorV3Factory(ApplicationModule module2, Provider<IdsRepository> idsRepositoryProvider2, Provider<QManager> qManagerProvider2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<NetworkOperatorManager> networkOperatorManagerProvider2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<String> aptoidePackageProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.idsRepositoryProvider = idsRepositoryProvider2;
        this.qManagerProvider = qManagerProvider2;
        this.defaultSharedPreferencesProvider = defaultSharedPreferencesProvider2;
        this.networkOperatorManagerProvider = networkOperatorManagerProvider2;
        this.authenticationPersistenceProvider = authenticationPersistenceProvider2;
        this.aptoidePackageProvider = aptoidePackageProvider2;
        $jacocoInit[0] = true;
    }

    public BodyInterceptor<BaseBody> get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<IdsRepository> provider = this.idsRepositoryProvider;
        $jacocoInit[1] = true;
        IdsRepository idsRepository = (IdsRepository) provider.get();
        Provider<QManager> provider2 = this.qManagerProvider;
        $jacocoInit[2] = true;
        QManager qManager = (QManager) provider2.get();
        Provider<SharedPreferences> provider3 = this.defaultSharedPreferencesProvider;
        $jacocoInit[3] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider3.get();
        Provider<NetworkOperatorManager> provider4 = this.networkOperatorManagerProvider;
        $jacocoInit[4] = true;
        NetworkOperatorManager networkOperatorManager = (NetworkOperatorManager) provider4.get();
        Provider<AuthenticationPersistence> provider5 = this.authenticationPersistenceProvider;
        $jacocoInit[5] = true;
        AuthenticationPersistence authenticationPersistence = (AuthenticationPersistence) provider5.get();
        Provider<String> provider6 = this.aptoidePackageProvider;
        $jacocoInit[6] = true;
        String str = (String) provider6.get();
        $jacocoInit[7] = true;
        BodyInterceptor<BaseBody> providesBodyInterceptorV3 = applicationModule.providesBodyInterceptorV3(idsRepository, qManager, sharedPreferences, networkOperatorManager, authenticationPersistence, str);
        $jacocoInit[8] = true;
        C13182c.m43111a(providesBodyInterceptorV3, "Cannot return null from a non-@Nullable @Provides method");
        BodyInterceptor<BaseBody> bodyInterceptor = providesBodyInterceptorV3;
        $jacocoInit[9] = true;
        return bodyInterceptor;
    }

    public static C13181b<BodyInterceptor<BaseBody>> create(ApplicationModule module2, Provider<IdsRepository> idsRepositoryProvider2, Provider<QManager> qManagerProvider2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<NetworkOperatorManager> networkOperatorManagerProvider2, Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<String> aptoidePackageProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesBodyInterceptorV3Factory applicationModule_ProvidesBodyInterceptorV3Factory = new ApplicationModule_ProvidesBodyInterceptorV3Factory(module2, idsRepositoryProvider2, qManagerProvider2, defaultSharedPreferencesProvider2, networkOperatorManagerProvider2, authenticationPersistenceProvider2, aptoidePackageProvider2);
        $jacocoInit[10] = true;
        return applicationModule_ProvidesBodyInterceptorV3Factory;
    }

    public static BodyInterceptor<BaseBody> proxyProvidesBodyInterceptorV3(ApplicationModule instance, IdsRepository idsRepository, QManager qManager, SharedPreferences defaultSharedPreferences, NetworkOperatorManager networkOperatorManager, AuthenticationPersistence authenticationPersistence, String aptoidePackage) {
        boolean[] $jacocoInit = $jacocoInit();
        BodyInterceptor<BaseBody> providesBodyInterceptorV3 = instance.providesBodyInterceptorV3(idsRepository, qManager, defaultSharedPreferences, networkOperatorManager, authenticationPersistence, aptoidePackage);
        $jacocoInit[11] = true;
        return providesBodyInterceptorV3;
    }
}
