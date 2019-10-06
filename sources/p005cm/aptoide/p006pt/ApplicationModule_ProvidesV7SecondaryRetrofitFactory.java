package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.CallAdapter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesV7SecondaryRetrofitFactory */
public final class ApplicationModule_ProvidesV7SecondaryRetrofitFactory implements C13181b<Retrofit> {
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
        boolean[] probes = Offline.getProbes(-7594416069295677919L, "cm/aptoide/pt/ApplicationModule_ProvidesV7SecondaryRetrofitFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesV7SecondaryRetrofitFactory(ApplicationModule module2, Provider<OkHttpClient> httpClientProvider2, Provider<String> baseHostProvider2, Provider<Factory> converterFactoryProvider2, Provider<CallAdapter.Factory> rxCallAdapterFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.httpClientProvider = httpClientProvider2;
        this.baseHostProvider = baseHostProvider2;
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
        Provider<String> provider2 = this.baseHostProvider;
        $jacocoInit[2] = true;
        String str = (String) provider2.get();
        Provider<Factory> provider3 = this.converterFactoryProvider;
        $jacocoInit[3] = true;
        Factory factory = (Factory) provider3.get();
        Provider<CallAdapter.Factory> provider4 = this.rxCallAdapterFactoryProvider;
        $jacocoInit[4] = true;
        CallAdapter.Factory factory2 = (CallAdapter.Factory) provider4.get();
        $jacocoInit[5] = true;
        Retrofit providesV7SecondaryRetrofit = applicationModule.providesV7SecondaryRetrofit(okHttpClient, str, factory, factory2);
        $jacocoInit[6] = true;
        C13182c.m43111a(providesV7SecondaryRetrofit, "Cannot return null from a non-@Nullable @Provides method");
        Retrofit retrofit = providesV7SecondaryRetrofit;
        $jacocoInit[7] = true;
        return retrofit;
    }

    public static C13181b<Retrofit> create(ApplicationModule module2, Provider<OkHttpClient> httpClientProvider2, Provider<String> baseHostProvider2, Provider<Factory> converterFactoryProvider2, Provider<CallAdapter.Factory> rxCallAdapterFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesV7SecondaryRetrofitFactory applicationModule_ProvidesV7SecondaryRetrofitFactory = new ApplicationModule_ProvidesV7SecondaryRetrofitFactory(module2, httpClientProvider2, baseHostProvider2, converterFactoryProvider2, rxCallAdapterFactoryProvider2);
        $jacocoInit[8] = true;
        return applicationModule_ProvidesV7SecondaryRetrofitFactory;
    }

    public static Retrofit proxyProvidesV7SecondaryRetrofit(ApplicationModule instance, OkHttpClient httpClient, String baseHost, Factory converterFactory, CallAdapter.Factory rxCallAdapterFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        Retrofit providesV7SecondaryRetrofit = instance.providesV7SecondaryRetrofit(httpClient, baseHost, converterFactory, rxCallAdapterFactory);
        $jacocoInit[9] = true;
        return providesV7SecondaryRetrofit;
    }
}
