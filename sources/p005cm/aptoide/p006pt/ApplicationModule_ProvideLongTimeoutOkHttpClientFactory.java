package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideLongTimeoutOkHttpClientFactory */
public final class ApplicationModule_ProvideLongTimeoutOkHttpClientFactory implements C13181b<OkHttpClient> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<Interceptor> retrofitLogInterceptorProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<Interceptor> userAgentInterceptorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8573294454057097785L, "cm/aptoide/pt/ApplicationModule_ProvideLongTimeoutOkHttpClientFactory", 10);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideLongTimeoutOkHttpClientFactory(ApplicationModule module2, Provider<Interceptor> userAgentInterceptorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<Interceptor> retrofitLogInterceptorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.userAgentInterceptorProvider = userAgentInterceptorProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.retrofitLogInterceptorProvider = retrofitLogInterceptorProvider2;
        $jacocoInit[0] = true;
    }

    public OkHttpClient get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Interceptor> provider = this.userAgentInterceptorProvider;
        $jacocoInit[1] = true;
        Interceptor interceptor = (Interceptor) provider.get();
        Provider<SharedPreferences> provider2 = this.sharedPreferencesProvider;
        $jacocoInit[2] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider2.get();
        Provider<Interceptor> provider3 = this.retrofitLogInterceptorProvider;
        $jacocoInit[3] = true;
        Interceptor interceptor2 = (Interceptor) provider3.get();
        $jacocoInit[4] = true;
        OkHttpClient provideLongTimeoutOkHttpClient = applicationModule.provideLongTimeoutOkHttpClient(interceptor, sharedPreferences, interceptor2);
        $jacocoInit[5] = true;
        C13182c.m43111a(provideLongTimeoutOkHttpClient, "Cannot return null from a non-@Nullable @Provides method");
        OkHttpClient okHttpClient = provideLongTimeoutOkHttpClient;
        $jacocoInit[6] = true;
        return okHttpClient;
    }

    public static C13181b<OkHttpClient> create(ApplicationModule module2, Provider<Interceptor> userAgentInterceptorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<Interceptor> retrofitLogInterceptorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideLongTimeoutOkHttpClientFactory applicationModule_ProvideLongTimeoutOkHttpClientFactory = new ApplicationModule_ProvideLongTimeoutOkHttpClientFactory(module2, userAgentInterceptorProvider2, sharedPreferencesProvider2, retrofitLogInterceptorProvider2);
        $jacocoInit[7] = true;
        return applicationModule_ProvideLongTimeoutOkHttpClientFactory;
    }

    public static OkHttpClient proxyProvideLongTimeoutOkHttpClient(ApplicationModule instance, Interceptor userAgentInterceptor, SharedPreferences sharedPreferences, Interceptor retrofitLogInterceptor) {
        boolean[] $jacocoInit = $jacocoInit();
        OkHttpClient provideLongTimeoutOkHttpClient = instance.provideLongTimeoutOkHttpClient(userAgentInterceptor, sharedPreferences, retrofitLogInterceptor);
        $jacocoInit[8] = true;
        return provideLongTimeoutOkHttpClient;
    }
}
