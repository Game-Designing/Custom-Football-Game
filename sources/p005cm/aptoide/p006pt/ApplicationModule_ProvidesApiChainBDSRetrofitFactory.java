package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.CallAdapter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesApiChainBDSRetrofitFactory */
public final class ApplicationModule_ProvidesApiChainBDSRetrofitFactory implements C13181b<Retrofit> {
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
        boolean[] probes = Offline.getProbes(6637457016669218499L, "cm/aptoide/pt/ApplicationModule_ProvidesApiChainBDSRetrofitFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesApiChainBDSRetrofitFactory(ApplicationModule module2, Provider<OkHttpClient> httpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<CallAdapter.Factory> rxCallAdapterFactoryProvider2, Provider<String> baseHostProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.httpClientProvider = httpClientProvider2;
        this.converterFactoryProvider = converterFactoryProvider2;
        this.rxCallAdapterFactoryProvider = rxCallAdapterFactoryProvider2;
        this.baseHostProvider = baseHostProvider2;
        $jacocoInit[0] = true;
    }

    public Retrofit get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<OkHttpClient> provider = this.httpClientProvider;
        $jacocoInit[1] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider.get();
        Provider<Factory> provider2 = this.converterFactoryProvider;
        $jacocoInit[2] = true;
        Factory factory = (Factory) provider2.get();
        Provider<CallAdapter.Factory> provider3 = this.rxCallAdapterFactoryProvider;
        $jacocoInit[3] = true;
        CallAdapter.Factory factory2 = (CallAdapter.Factory) provider3.get();
        Provider<String> provider4 = this.baseHostProvider;
        $jacocoInit[4] = true;
        String str = (String) provider4.get();
        $jacocoInit[5] = true;
        Retrofit providesApiChainBDSRetrofit = applicationModule.providesApiChainBDSRetrofit(okHttpClient, factory, factory2, str);
        $jacocoInit[6] = true;
        C13182c.m43111a(providesApiChainBDSRetrofit, "Cannot return null from a non-@Nullable @Provides method");
        Retrofit retrofit = providesApiChainBDSRetrofit;
        $jacocoInit[7] = true;
        return retrofit;
    }

    public static C13181b<Retrofit> create(ApplicationModule module2, Provider<OkHttpClient> httpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<CallAdapter.Factory> rxCallAdapterFactoryProvider2, Provider<String> baseHostProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesApiChainBDSRetrofitFactory applicationModule_ProvidesApiChainBDSRetrofitFactory = new ApplicationModule_ProvidesApiChainBDSRetrofitFactory(module2, httpClientProvider2, converterFactoryProvider2, rxCallAdapterFactoryProvider2, baseHostProvider2);
        $jacocoInit[8] = true;
        return applicationModule_ProvidesApiChainBDSRetrofitFactory;
    }

    public static Retrofit proxyProvidesApiChainBDSRetrofit(ApplicationModule instance, OkHttpClient httpClient, Factory converterFactory, CallAdapter.Factory rxCallAdapterFactory, String baseHost) {
        boolean[] $jacocoInit = $jacocoInit();
        Retrofit providesApiChainBDSRetrofit = instance.providesApiChainBDSRetrofit(httpClient, converterFactory, rxCallAdapterFactory, baseHost);
        $jacocoInit[9] = true;
        return providesApiChainBDSRetrofit;
    }
}
