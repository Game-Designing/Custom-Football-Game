package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.view.WindowManager;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.AdsApplicationVersionCodeProvider;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.home.BundleDataSource;
import p005cm.aptoide.p006pt.home.BundlesResponseMapper;
import p005cm.aptoide.p006pt.install.PackageRepository;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesRemoteBundleDataSourceFactory */
public final class ApplicationModule_ProvidesRemoteBundleDataSourceFactory implements C13181b<BundleDataSource> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<AdsApplicationVersionCodeProvider> adsApplicationVersionCodeProvider;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider;
    private final Provider<ConnectivityManager> connectivityManagerProvider;
    private final Provider<Factory> converterProvider;
    private final Provider<Database> databaseProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final Provider<BundlesResponseMapper> mapperProvider;
    private final ApplicationModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<PackageRepository> packageRepositoryProvider;
    private final Provider<QManager> qManagerProvider;
    private final Provider<Resources> resourcesProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;
    private final Provider<WindowManager> windowManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4068041524761640239L, "cm/aptoide/pt/ApplicationModule_ProvidesRemoteBundleDataSourceFactory", 22);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesRemoteBundleDataSourceFactory(ApplicationModule module2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<Factory> converterProvider2, Provider<BundlesResponseMapper> mapperProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<PackageRepository> packageRepositoryProvider2, Provider<Database> databaseProvider2, Provider<IdsRepository> idsRepositoryProvider2, Provider<QManager> qManagerProvider2, Provider<Resources> resourcesProvider2, Provider<WindowManager> windowManagerProvider2, Provider<ConnectivityManager> connectivityManagerProvider2, Provider<AdsApplicationVersionCodeProvider> adsApplicationVersionCodeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.bodyInterceptorPoolV7Provider = bodyInterceptorPoolV7Provider2;
        this.okHttpClientProvider = okHttpClientProvider2;
        this.converterProvider = converterProvider2;
        this.mapperProvider = mapperProvider2;
        this.tokenInvalidatorProvider = tokenInvalidatorProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.accountManagerProvider = accountManagerProvider2;
        this.packageRepositoryProvider = packageRepositoryProvider2;
        this.databaseProvider = databaseProvider2;
        this.idsRepositoryProvider = idsRepositoryProvider2;
        this.qManagerProvider = qManagerProvider2;
        this.resourcesProvider = resourcesProvider2;
        this.windowManagerProvider = windowManagerProvider2;
        this.connectivityManagerProvider = connectivityManagerProvider2;
        this.adsApplicationVersionCodeProvider = adsApplicationVersionCodeProvider2;
        $jacocoInit[0] = true;
    }

    public BundleDataSource get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<BodyInterceptor<BaseBody>> provider = this.bodyInterceptorPoolV7Provider;
        $jacocoInit[1] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider.get();
        Provider<OkHttpClient> provider2 = this.okHttpClientProvider;
        $jacocoInit[2] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider2.get();
        Provider<Factory> provider3 = this.converterProvider;
        $jacocoInit[3] = true;
        Factory factory = (Factory) provider3.get();
        Provider<BundlesResponseMapper> provider4 = this.mapperProvider;
        $jacocoInit[4] = true;
        BundlesResponseMapper bundlesResponseMapper = (BundlesResponseMapper) provider4.get();
        Provider<TokenInvalidator> provider5 = this.tokenInvalidatorProvider;
        $jacocoInit[5] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider5.get();
        Provider<SharedPreferences> provider6 = this.sharedPreferencesProvider;
        $jacocoInit[6] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider6.get();
        Provider<AptoideAccountManager> provider7 = this.accountManagerProvider;
        $jacocoInit[7] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider7.get();
        Provider<PackageRepository> provider8 = this.packageRepositoryProvider;
        $jacocoInit[8] = true;
        PackageRepository packageRepository = (PackageRepository) provider8.get();
        Provider<Database> provider9 = this.databaseProvider;
        $jacocoInit[9] = true;
        Database database = (Database) provider9.get();
        Provider<IdsRepository> provider10 = this.idsRepositoryProvider;
        $jacocoInit[10] = true;
        IdsRepository idsRepository = (IdsRepository) provider10.get();
        Provider<QManager> provider11 = this.qManagerProvider;
        $jacocoInit[11] = true;
        QManager qManager = (QManager) provider11.get();
        Provider<Resources> provider12 = this.resourcesProvider;
        $jacocoInit[12] = true;
        Resources resources = (Resources) provider12.get();
        Provider<WindowManager> provider13 = this.windowManagerProvider;
        $jacocoInit[13] = true;
        WindowManager windowManager = (WindowManager) provider13.get();
        Provider<ConnectivityManager> provider14 = this.connectivityManagerProvider;
        $jacocoInit[14] = true;
        ConnectivityManager connectivityManager = (ConnectivityManager) provider14.get();
        Provider<AdsApplicationVersionCodeProvider> provider15 = this.adsApplicationVersionCodeProvider;
        $jacocoInit[15] = true;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider2 = (AdsApplicationVersionCodeProvider) provider15.get();
        $jacocoInit[16] = true;
        BundleDataSource providesRemoteBundleDataSource = applicationModule.providesRemoteBundleDataSource(bodyInterceptor, okHttpClient, factory, bundlesResponseMapper, tokenInvalidator, sharedPreferences, aptoideAccountManager, packageRepository, database, idsRepository, qManager, resources, windowManager, connectivityManager, adsApplicationVersionCodeProvider2);
        $jacocoInit[17] = true;
        C13182c.m43111a(providesRemoteBundleDataSource, "Cannot return null from a non-@Nullable @Provides method");
        BundleDataSource bundleDataSource = providesRemoteBundleDataSource;
        $jacocoInit[18] = true;
        return bundleDataSource;
    }

    public static C13181b<BundleDataSource> create(ApplicationModule module2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<Factory> converterProvider2, Provider<BundlesResponseMapper> mapperProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<PackageRepository> packageRepositoryProvider2, Provider<Database> databaseProvider2, Provider<IdsRepository> idsRepositoryProvider2, Provider<QManager> qManagerProvider2, Provider<Resources> resourcesProvider2, Provider<WindowManager> windowManagerProvider2, Provider<ConnectivityManager> connectivityManagerProvider2, Provider<AdsApplicationVersionCodeProvider> adsApplicationVersionCodeProvider2) {
        ApplicationModule applicationModule = module2;
        Provider<BodyInterceptor<BaseBody>> provider = bodyInterceptorPoolV7Provider2;
        Provider<OkHttpClient> provider2 = okHttpClientProvider2;
        Provider<Factory> provider3 = converterProvider2;
        Provider<BundlesResponseMapper> provider4 = mapperProvider2;
        Provider<TokenInvalidator> provider5 = tokenInvalidatorProvider2;
        Provider<SharedPreferences> provider6 = sharedPreferencesProvider2;
        Provider<AptoideAccountManager> provider7 = accountManagerProvider2;
        Provider<PackageRepository> provider8 = packageRepositoryProvider2;
        Provider<Database> provider9 = databaseProvider2;
        Provider<IdsRepository> provider10 = idsRepositoryProvider2;
        Provider<QManager> provider11 = qManagerProvider2;
        Provider<Resources> provider12 = resourcesProvider2;
        Provider<WindowManager> provider13 = windowManagerProvider2;
        Provider<ConnectivityManager> provider14 = connectivityManagerProvider2;
        Provider<AdsApplicationVersionCodeProvider> provider15 = adsApplicationVersionCodeProvider2;
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesRemoteBundleDataSourceFactory applicationModule_ProvidesRemoteBundleDataSourceFactory = new ApplicationModule_ProvidesRemoteBundleDataSourceFactory(applicationModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
        $jacocoInit[19] = true;
        return applicationModule_ProvidesRemoteBundleDataSourceFactory;
    }

    public static BundleDataSource proxyProvidesRemoteBundleDataSource(ApplicationModule instance, BodyInterceptor<BaseBody> bodyInterceptorPoolV7, OkHttpClient okHttpClient, Factory converter, BundlesResponseMapper mapper, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, AptoideAccountManager accountManager, PackageRepository packageRepository, Database database, IdsRepository idsRepository, QManager qManager, Resources resources, WindowManager windowManager, ConnectivityManager connectivityManager, AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        BundleDataSource providesRemoteBundleDataSource = instance.providesRemoteBundleDataSource(bodyInterceptorPoolV7, okHttpClient, converter, mapper, tokenInvalidator, sharedPreferences, accountManager, packageRepository, database, idsRepository, qManager, resources, windowManager, connectivityManager, adsApplicationVersionCodeProvider2);
        $jacocoInit[20] = true;
        return providesRemoteBundleDataSource;
    }
}
