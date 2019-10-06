package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.AdsApplicationVersionCodeProvider;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideAdsRepositoryFactory */
public final class ApplicationModule_ProvideAdsRepositoryFactory implements C13181b<AdsRepository> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<AdsApplicationVersionCodeProvider> adsApplicationVersionCodeProvider;
    private final Provider<ConnectivityManager> connectivityManagerProvider;
    private final Provider<SharedPreferences> defaultSharedPreferencesProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final ApplicationModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<QManager> qManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5510778912648149891L, "cm/aptoide/pt/ApplicationModule_ProvideAdsRepositoryFactory", 14);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideAdsRepositoryFactory(ApplicationModule module2, Provider<IdsRepository> idsRepositoryProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<QManager> qManagerProvider2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<AdsApplicationVersionCodeProvider> adsApplicationVersionCodeProvider2, Provider<ConnectivityManager> connectivityManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.idsRepositoryProvider = idsRepositoryProvider2;
        this.accountManagerProvider = accountManagerProvider2;
        this.okHttpClientProvider = okHttpClientProvider2;
        this.qManagerProvider = qManagerProvider2;
        this.defaultSharedPreferencesProvider = defaultSharedPreferencesProvider2;
        this.adsApplicationVersionCodeProvider = adsApplicationVersionCodeProvider2;
        this.connectivityManagerProvider = connectivityManagerProvider2;
        $jacocoInit[0] = true;
    }

    public AdsRepository get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<IdsRepository> provider = this.idsRepositoryProvider;
        $jacocoInit[1] = true;
        IdsRepository idsRepository = (IdsRepository) provider.get();
        Provider<AptoideAccountManager> provider2 = this.accountManagerProvider;
        $jacocoInit[2] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider2.get();
        Provider<OkHttpClient> provider3 = this.okHttpClientProvider;
        $jacocoInit[3] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider3.get();
        Provider<QManager> provider4 = this.qManagerProvider;
        $jacocoInit[4] = true;
        QManager qManager = (QManager) provider4.get();
        Provider<SharedPreferences> provider5 = this.defaultSharedPreferencesProvider;
        $jacocoInit[5] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider5.get();
        Provider<AdsApplicationVersionCodeProvider> provider6 = this.adsApplicationVersionCodeProvider;
        $jacocoInit[6] = true;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider2 = (AdsApplicationVersionCodeProvider) provider6.get();
        Provider<ConnectivityManager> provider7 = this.connectivityManagerProvider;
        $jacocoInit[7] = true;
        ConnectivityManager connectivityManager = (ConnectivityManager) provider7.get();
        $jacocoInit[8] = true;
        AdsRepository provideAdsRepository = applicationModule.provideAdsRepository(idsRepository, aptoideAccountManager, okHttpClient, qManager, sharedPreferences, adsApplicationVersionCodeProvider2, connectivityManager);
        $jacocoInit[9] = true;
        C13182c.m43111a(provideAdsRepository, "Cannot return null from a non-@Nullable @Provides method");
        AdsRepository adsRepository = provideAdsRepository;
        $jacocoInit[10] = true;
        return adsRepository;
    }

    public static C13181b<AdsRepository> create(ApplicationModule module2, Provider<IdsRepository> idsRepositoryProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<QManager> qManagerProvider2, Provider<SharedPreferences> defaultSharedPreferencesProvider2, Provider<AdsApplicationVersionCodeProvider> adsApplicationVersionCodeProvider2, Provider<ConnectivityManager> connectivityManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideAdsRepositoryFactory applicationModule_ProvideAdsRepositoryFactory = new ApplicationModule_ProvideAdsRepositoryFactory(module2, idsRepositoryProvider2, accountManagerProvider2, okHttpClientProvider2, qManagerProvider2, defaultSharedPreferencesProvider2, adsApplicationVersionCodeProvider2, connectivityManagerProvider2);
        $jacocoInit[11] = true;
        return applicationModule_ProvideAdsRepositoryFactory;
    }

    public static AdsRepository proxyProvideAdsRepository(ApplicationModule instance, IdsRepository idsRepository, AptoideAccountManager accountManager, OkHttpClient okHttpClient, QManager qManager, SharedPreferences defaultSharedPreferences, AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider2, ConnectivityManager connectivityManager) {
        boolean[] $jacocoInit = $jacocoInit();
        AdsRepository provideAdsRepository = instance.provideAdsRepository(idsRepository, accountManager, okHttpClient, qManager, defaultSharedPreferences, adsApplicationVersionCodeProvider2, connectivityManager);
        $jacocoInit[12] = true;
        return provideAdsRepository;
    }
}
