package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.search.SearchManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesSearchManagerFactory */
public final class ApplicationModule_ProvidesSearchManagerFactory implements C13181b<SearchManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<AdsRepository> adsRepositoryProvider;
    private final Provider<BodyInterceptor<BaseBody>> baseBodyBodyInterceptorProvider;
    private final Provider<Factory> converterFactoryProvider;
    private final Provider<Database> databaseProvider;
    private final Provider<MoPubAdsManager> moPubAdsManagerProvider;
    private final ApplicationModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2053176154458058186L, "cm/aptoide/pt/ApplicationModule_ProvidesSearchManagerFactory", 16);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesSearchManagerFactory(ApplicationModule module2, Provider<BodyInterceptor<BaseBody>> baseBodyBodyInterceptorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<Database> databaseProvider2, Provider<AdsRepository> adsRepositoryProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<MoPubAdsManager> moPubAdsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.baseBodyBodyInterceptorProvider = baseBodyBodyInterceptorProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.tokenInvalidatorProvider = tokenInvalidatorProvider2;
        this.okHttpClientProvider = okHttpClientProvider2;
        this.converterFactoryProvider = converterFactoryProvider2;
        this.databaseProvider = databaseProvider2;
        this.adsRepositoryProvider = adsRepositoryProvider2;
        this.accountManagerProvider = accountManagerProvider2;
        this.moPubAdsManagerProvider = moPubAdsManagerProvider2;
        $jacocoInit[0] = true;
    }

    public SearchManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<BodyInterceptor<BaseBody>> provider = this.baseBodyBodyInterceptorProvider;
        $jacocoInit[1] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider.get();
        Provider<SharedPreferences> provider2 = this.sharedPreferencesProvider;
        $jacocoInit[2] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider2.get();
        Provider<TokenInvalidator> provider3 = this.tokenInvalidatorProvider;
        $jacocoInit[3] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider3.get();
        Provider<OkHttpClient> provider4 = this.okHttpClientProvider;
        $jacocoInit[4] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider4.get();
        Provider<Factory> provider5 = this.converterFactoryProvider;
        $jacocoInit[5] = true;
        Factory factory = (Factory) provider5.get();
        Provider<Database> provider6 = this.databaseProvider;
        $jacocoInit[6] = true;
        Database database = (Database) provider6.get();
        Provider<AdsRepository> provider7 = this.adsRepositoryProvider;
        $jacocoInit[7] = true;
        AdsRepository adsRepository = (AdsRepository) provider7.get();
        Provider<AptoideAccountManager> provider8 = this.accountManagerProvider;
        $jacocoInit[8] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider8.get();
        Provider<MoPubAdsManager> provider9 = this.moPubAdsManagerProvider;
        $jacocoInit[9] = true;
        MoPubAdsManager moPubAdsManager = (MoPubAdsManager) provider9.get();
        $jacocoInit[10] = true;
        SearchManager providesSearchManager = applicationModule.providesSearchManager(bodyInterceptor, sharedPreferences, tokenInvalidator, okHttpClient, factory, database, adsRepository, aptoideAccountManager, moPubAdsManager);
        $jacocoInit[11] = true;
        C13182c.m43111a(providesSearchManager, "Cannot return null from a non-@Nullable @Provides method");
        SearchManager searchManager = providesSearchManager;
        $jacocoInit[12] = true;
        return searchManager;
    }

    public static C13181b<SearchManager> create(ApplicationModule module2, Provider<BodyInterceptor<BaseBody>> baseBodyBodyInterceptorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<Database> databaseProvider2, Provider<AdsRepository> adsRepositoryProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<MoPubAdsManager> moPubAdsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesSearchManagerFactory applicationModule_ProvidesSearchManagerFactory = new ApplicationModule_ProvidesSearchManagerFactory(module2, baseBodyBodyInterceptorProvider2, sharedPreferencesProvider2, tokenInvalidatorProvider2, okHttpClientProvider2, converterFactoryProvider2, databaseProvider2, adsRepositoryProvider2, accountManagerProvider2, moPubAdsManagerProvider2);
        $jacocoInit[13] = true;
        return applicationModule_ProvidesSearchManagerFactory;
    }

    public static SearchManager proxyProvidesSearchManager(ApplicationModule instance, BodyInterceptor<BaseBody> baseBodyBodyInterceptor, SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator, OkHttpClient okHttpClient, Factory converterFactory, Database database, AdsRepository adsRepository, AptoideAccountManager accountManager, MoPubAdsManager moPubAdsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchManager providesSearchManager = instance.providesSearchManager(baseBodyBodyInterceptor, sharedPreferences, tokenInvalidator, okHttpClient, converterFactory, database, adsRepository, accountManager, moPubAdsManager);
        $jacocoInit[14] = true;
        return providesSearchManager;
    }
}
