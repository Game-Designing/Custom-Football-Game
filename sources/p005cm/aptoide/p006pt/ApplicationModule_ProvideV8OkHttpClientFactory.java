package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.cache.L2Cache;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideV8OkHttpClientFactory */
public final class ApplicationModule_ProvideV8OkHttpClientFactory implements C13181b<OkHttpClient> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<L2Cache> httpClientCacheProvider;
    private final ApplicationModule module;
    private final Provider<Interceptor> retrofitLogInterceptorProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<Interceptor> userAgentInterceptorV8Provider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5267673059451843143L, "cm/aptoide/pt/ApplicationModule_ProvideV8OkHttpClientFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideV8OkHttpClientFactory(ApplicationModule module2, Provider<L2Cache> httpClientCacheProvider2, Provider<Interceptor> userAgentInterceptorV8Provider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<Interceptor> retrofitLogInterceptorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.httpClientCacheProvider = httpClientCacheProvider2;
        this.userAgentInterceptorV8Provider = userAgentInterceptorV8Provider2;
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
        Provider<Interceptor> provider2 = this.userAgentInterceptorV8Provider;
        $jacocoInit[2] = true;
        Interceptor interceptor = (Interceptor) provider2.get();
        Provider<SharedPreferences> provider3 = this.sharedPreferencesProvider;
        $jacocoInit[3] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider3.get();
        Provider<Interceptor> provider4 = this.retrofitLogInterceptorProvider;
        $jacocoInit[4] = true;
        Interceptor interceptor2 = (Interceptor) provider4.get();
        $jacocoInit[5] = true;
        OkHttpClient provideV8OkHttpClient = applicationModule.provideV8OkHttpClient(l2Cache, interceptor, sharedPreferences, interceptor2);
        $jacocoInit[6] = true;
        C13182c.m43111a(provideV8OkHttpClient, "Cannot return null from a non-@Nullable @Provides method");
        OkHttpClient okHttpClient = provideV8OkHttpClient;
        $jacocoInit[7] = true;
        return okHttpClient;
    }

    public static C13181b<OkHttpClient> create(ApplicationModule module2, Provider<L2Cache> httpClientCacheProvider2, Provider<Interceptor> userAgentInterceptorV8Provider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<Interceptor> retrofitLogInterceptorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideV8OkHttpClientFactory applicationModule_ProvideV8OkHttpClientFactory = new ApplicationModule_ProvideV8OkHttpClientFactory(module2, httpClientCacheProvider2, userAgentInterceptorV8Provider2, sharedPreferencesProvider2, retrofitLogInterceptorProvider2);
        $jacocoInit[8] = true;
        return applicationModule_ProvideV8OkHttpClientFactory;
    }

    public static OkHttpClient proxyProvideV8OkHttpClient(ApplicationModule instance, L2Cache httpClientCache, Interceptor userAgentInterceptorV8, SharedPreferences sharedPreferences, Interceptor retrofitLogInterceptor) {
        boolean[] $jacocoInit = $jacocoInit();
        OkHttpClient provideV8OkHttpClient = instance.provideV8OkHttpClient(httpClientCache, userAgentInterceptorV8, sharedPreferences, retrofitLogInterceptor);
        $jacocoInit[9] = true;
        return provideV8OkHttpClient;
    }
}
