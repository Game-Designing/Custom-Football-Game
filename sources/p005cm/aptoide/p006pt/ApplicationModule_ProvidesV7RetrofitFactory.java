package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.CallAdapter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesV7RetrofitFactory */
public final class ApplicationModule_ProvidesV7RetrofitFactory implements C13181b<Retrofit> {
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
        boolean[] probes = Offline.getProbes(-4840156091078947486L, "cm/aptoide/pt/ApplicationModule_ProvidesV7RetrofitFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesV7RetrofitFactory(ApplicationModule module2, Provider<String> baseHostProvider2, Provider<OkHttpClient> httpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<CallAdapter.Factory> rxCallAdapterFactoryProvider2) {
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
        Retrofit providesV7Retrofit = applicationModule.providesV7Retrofit(str, okHttpClient, factory, factory2);
        $jacocoInit[6] = true;
        C13182c.m43111a(providesV7Retrofit, "Cannot return null from a non-@Nullable @Provides method");
        Retrofit retrofit = providesV7Retrofit;
        $jacocoInit[7] = true;
        return retrofit;
    }

    public static C13181b<Retrofit> create(ApplicationModule module2, Provider<String> baseHostProvider2, Provider<OkHttpClient> httpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<CallAdapter.Factory> rxCallAdapterFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesV7RetrofitFactory applicationModule_ProvidesV7RetrofitFactory = new ApplicationModule_ProvidesV7RetrofitFactory(module2, baseHostProvider2, httpClientProvider2, converterFactoryProvider2, rxCallAdapterFactoryProvider2);
        $jacocoInit[8] = true;
        return applicationModule_ProvidesV7RetrofitFactory;
    }

    public static Retrofit proxyProvidesV7Retrofit(ApplicationModule instance, String baseHost, OkHttpClient httpClient, Factory converterFactory, CallAdapter.Factory rxCallAdapterFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        Retrofit providesV7Retrofit = instance.providesV7Retrofit(baseHost, httpClient, converterFactory, rxCallAdapterFactory);
        $jacocoInit[9] = true;
        return providesV7Retrofit;
    }
}
