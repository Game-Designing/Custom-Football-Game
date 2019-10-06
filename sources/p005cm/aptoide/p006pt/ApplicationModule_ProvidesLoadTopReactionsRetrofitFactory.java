package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.CallAdapter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesLoadTopReactionsRetrofitFactory */
public final class ApplicationModule_ProvidesLoadTopReactionsRetrofitFactory implements C13181b<Retrofit> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> baseHostProvider;
    private final Provider<Factory> converterFactoryProvider;
    private final Provider<OkHttpClient> httpClientProvider;
    private final ApplicationModule module;
    private final Provider<CallAdapter.Factory> rxCallAdapterFactoryProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8474799005857412962L, "cm/aptoide/pt/ApplicationModule_ProvidesLoadTopReactionsRetrofitFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesLoadTopReactionsRetrofitFactory(ApplicationModule module2, Provider<String> baseHostProvider2, Provider<OkHttpClient> httpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<CallAdapter.Factory> rxCallAdapterFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.baseHostProvider = baseHostProvider2;
        this.httpClientProvider = httpClientProvider2;
        this.converterFactoryProvider = converterFactoryProvider2;
        this.rxCallAdapterFactoryProvider = rxCallAdapterFactoryProvider2;
        $jacocoInit[0] = true;
    }

    public Retrofit get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<String> provider = this.baseHostProvider;
        $jacocoInit[1] = true;
        String str = (String) provider.get();
        Provider<OkHttpClient> provider2 = this.httpClientProvider;
        $jacocoInit[2] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider2.get();
        Provider<Factory> provider3 = this.converterFactoryProvider;
        $jacocoInit[3] = true;
        Factory factory = (Factory) provider3.get();
        Provider<CallAdapter.Factory> provider4 = this.rxCallAdapterFactoryProvider;
        $jacocoInit[4] = true;
        CallAdapter.Factory factory2 = (CallAdapter.Factory) provider4.get();
        $jacocoInit[5] = true;
        Retrofit providesLoadTopReactionsRetrofit = applicationModule.providesLoadTopReactionsRetrofit(str, okHttpClient, factory, factory2);
        $jacocoInit[6] = true;
        C13182c.m43111a(providesLoadTopReactionsRetrofit, "Cannot return null from a non-@Nullable @Provides method");
        Retrofit retrofit = providesLoadTopReactionsRetrofit;
        $jacocoInit[7] = true;
        return retrofit;
    }

    public static C13181b<Retrofit> create(ApplicationModule module2, Provider<String> baseHostProvider2, Provider<OkHttpClient> httpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<CallAdapter.Factory> rxCallAdapterFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesLoadTopReactionsRetrofitFactory applicationModule_ProvidesLoadTopReactionsRetrofitFactory = new ApplicationModule_ProvidesLoadTopReactionsRetrofitFactory(module2, baseHostProvider2, httpClientProvider2, converterFactoryProvider2, rxCallAdapterFactoryProvider2);
        $jacocoInit[8] = true;
        return applicationModule_ProvidesLoadTopReactionsRetrofitFactory;
    }

    public static Retrofit proxyProvidesLoadTopReactionsRetrofit(ApplicationModule instance, String baseHost, OkHttpClient httpClient, Factory converterFactory, CallAdapter.Factory rxCallAdapterFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        Retrofit providesLoadTopReactionsRetrofit = instance.providesLoadTopReactionsRetrofit(baseHost, httpClient, converterFactory, rxCallAdapterFactory);
        $jacocoInit[9] = true;
        return providesLoadTopReactionsRetrofit;
    }
}
