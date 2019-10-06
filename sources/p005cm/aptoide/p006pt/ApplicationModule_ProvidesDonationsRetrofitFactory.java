package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.CallAdapter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesDonationsRetrofitFactory */
public final class ApplicationModule_ProvidesDonationsRetrofitFactory implements C13181b<Retrofit> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<Factory> converterFactoryProvider;
    private final Provider<OkHttpClient> httpClientProvider;
    private final ApplicationModule module;
    private final Provider<CallAdapter.Factory> rxCallAdapterFactoryProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7182879025175474090L, "cm/aptoide/pt/ApplicationModule_ProvidesDonationsRetrofitFactory", 10);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesDonationsRetrofitFactory(ApplicationModule module2, Provider<OkHttpClient> httpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<CallAdapter.Factory> rxCallAdapterFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.httpClientProvider = httpClientProvider2;
        this.converterFactoryProvider = converterFactoryProvider2;
        this.rxCallAdapterFactoryProvider = rxCallAdapterFactoryProvider2;
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
        $jacocoInit[4] = true;
        Retrofit providesDonationsRetrofit = applicationModule.providesDonationsRetrofit(okHttpClient, factory, factory2);
        $jacocoInit[5] = true;
        C13182c.m43111a(providesDonationsRetrofit, "Cannot return null from a non-@Nullable @Provides method");
        Retrofit retrofit = providesDonationsRetrofit;
        $jacocoInit[6] = true;
        return retrofit;
    }

    public static C13181b<Retrofit> create(ApplicationModule module2, Provider<OkHttpClient> httpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<CallAdapter.Factory> rxCallAdapterFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesDonationsRetrofitFactory applicationModule_ProvidesDonationsRetrofitFactory = new ApplicationModule_ProvidesDonationsRetrofitFactory(module2, httpClientProvider2, converterFactoryProvider2, rxCallAdapterFactoryProvider2);
        $jacocoInit[7] = true;
        return applicationModule_ProvidesDonationsRetrofitFactory;
    }

    public static Retrofit proxyProvidesDonationsRetrofit(ApplicationModule instance, OkHttpClient httpClient, Factory converterFactory, CallAdapter.Factory rxCallAdapterFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        Retrofit providesDonationsRetrofit = instance.providesDonationsRetrofit(httpClient, converterFactory, rxCallAdapterFactory);
        $jacocoInit[8] = true;
        return providesDonationsRetrofit;
    }
}
