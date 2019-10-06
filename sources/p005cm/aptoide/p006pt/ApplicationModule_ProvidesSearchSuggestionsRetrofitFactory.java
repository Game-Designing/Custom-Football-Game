package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.CallAdapter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesSearchSuggestionsRetrofitFactory */
public final class ApplicationModule_ProvidesSearchSuggestionsRetrofitFactory implements C13181b<Retrofit> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> baseUrlProvider;
    private final Provider<Factory> converterFactoryProvider;
    private final Provider<OkHttpClient> httpClientProvider;
    private final ApplicationModule module;
    private final Provider<CallAdapter.Factory> rxCallAdapterFactoryProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1099655166065088006L, "cm/aptoide/pt/ApplicationModule_ProvidesSearchSuggestionsRetrofitFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesSearchSuggestionsRetrofitFactory(ApplicationModule module2, Provider<String> baseUrlProvider2, Provider<OkHttpClient> httpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<CallAdapter.Factory> rxCallAdapterFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.baseUrlProvider = baseUrlProvider2;
        this.httpClientProvider = httpClientProvider2;
        this.converterFactoryProvider = converterFactoryProvider2;
        this.rxCallAdapterFactoryProvider = rxCallAdapterFactoryProvider2;
        $jacocoInit[0] = true;
    }

    public Retrofit get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<String> provider = this.baseUrlProvider;
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
        Retrofit providesSearchSuggestionsRetrofit = applicationModule.providesSearchSuggestionsRetrofit(str, okHttpClient, factory, factory2);
        $jacocoInit[6] = true;
        C13182c.m43111a(providesSearchSuggestionsRetrofit, "Cannot return null from a non-@Nullable @Provides method");
        Retrofit retrofit = providesSearchSuggestionsRetrofit;
        $jacocoInit[7] = true;
        return retrofit;
    }

    public static C13181b<Retrofit> create(ApplicationModule module2, Provider<String> baseUrlProvider2, Provider<OkHttpClient> httpClientProvider2, Provider<Factory> converterFactoryProvider2, Provider<CallAdapter.Factory> rxCallAdapterFactoryProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesSearchSuggestionsRetrofitFactory applicationModule_ProvidesSearchSuggestionsRetrofitFactory = new ApplicationModule_ProvidesSearchSuggestionsRetrofitFactory(module2, baseUrlProvider2, httpClientProvider2, converterFactoryProvider2, rxCallAdapterFactoryProvider2);
        $jacocoInit[8] = true;
        return applicationModule_ProvidesSearchSuggestionsRetrofitFactory;
    }

    public static Retrofit proxyProvidesSearchSuggestionsRetrofit(ApplicationModule instance, String baseUrl, OkHttpClient httpClient, Factory converterFactory, CallAdapter.Factory rxCallAdapterFactory) {
        boolean[] $jacocoInit = $jacocoInit();
        Retrofit providesSearchSuggestionsRetrofit = instance.providesSearchSuggestionsRetrofit(baseUrl, httpClient, converterFactory, rxCallAdapterFactory);
        $jacocoInit[9] = true;
        return providesSearchSuggestionsRetrofit;
    }
}
