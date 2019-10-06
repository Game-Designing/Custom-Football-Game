package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.cache.L2Cache;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideOkHttpClientFactory */
public final class ApplicationModule_ProvideOkHttpClientFactory implements C13181b<OkHttpClient> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<L2Cache> httpClientCacheProvider;
    private final ApplicationModule module;
    private final Provider<Interceptor> retrofitLogInterceptorProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<Interceptor> userAgentInterceptorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(346049487347760816L, "cm/aptoide/pt/ApplicationModule_ProvideOkHttpClientFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideOkHttpClientFactory(ApplicationModule module2, Provider<L2Cache> httpClientCacheProvider2, Provider<Interceptor> userAgentInterceptorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<Interceptor> retrofitLogInterceptorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.httpClientCacheProvider = httpClientCacheProvider2;
        this.userAgentInterceptorProvider = userAgentInterceptorProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.retrofitLogInterceptorProvider = retrofitLogInterceptorProvider2;
        $jacocoInit[0] = true;
    }

    public OkHttpClient get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<L2Cache> provider = this.httpClientCacheProvider;
        $jacocoInit[1] = true;
        L2Cache l2Cache = (L2Cache) provider.get();
        Provider<Interceptor> provider2 = this.userAgentInterceptorProvider;
        $jacocoInit[2] = true;
        Interceptor interceptor = (Interceptor) provider2.get();
        Provider<SharedPreferences> provider3 = this.sharedPreferencesProvider;
        $jacocoInit[3] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider3.get();
        Provider<Interceptor> provider4 = this.retrofitLogInterceptorProvider;
        $jacocoInit[4] = true;
        Interceptor interceptor2 = (Interceptor) provider4.get();
        $jacocoInit[5] = true;
        OkHttpClient provideOkHttpClient = applicationModule.provideOkHttpClient(l2Cache, interceptor, sharedPreferences, interceptor2);
        $jacocoInit[6] = true;
        C13182c.m43111a(provideOkHttpClient, "Cannot return null from a non-@Nullable @Provides method");
        OkHttpClient okHttpClient = provideOkHttpClient;
        $jacocoInit[7] = true;
        return okHttpClient;
    }

    public static C13181b<OkHttpClient> create(ApplicationModule module2, Provider<L2Cache> httpClientCacheProvider2, Provider<Interceptor> userAgentInterceptorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<Interceptor> retrofitLogInterceptorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideOkHttpClientFactory applicationModule_ProvideOkHttpClientFactory = new ApplicationModule_ProvideOkHttpClientFactory(module2, httpClientCacheProvider2, userAgentInterceptorProvider2, sharedPreferencesProvider2, retrofitLogInterceptorProvider2);
        $jacocoInit[8] = true;
        return applicationModule_ProvideOkHttpClientFactory;
    }

    public static OkHttpClient proxyProvideOkHttpClient(ApplicationModule instance, L2Cache httpClientCache, Interceptor userAgentInterceptor, SharedPreferences sharedPreferences, Interceptor retrofitLogInterceptor) {
        boolean[] $jacocoInit = $jacocoInit();
        OkHttpClient provideOkHttpClient = instance.provideOkHttpClient(httpClientCache, userAgentInterceptor, sharedPreferences, retrofitLogInterceptor);
        $jacocoInit[9] = true;
        return provideOkHttpClient;
    }
}
