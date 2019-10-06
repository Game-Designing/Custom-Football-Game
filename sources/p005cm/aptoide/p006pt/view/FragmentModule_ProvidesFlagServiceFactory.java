package p005cm.aptoide.p006pt.view;

import android.content.SharedPreferences;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.FlagService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesFlagServiceFactory */
public final class FragmentModule_ProvidesFlagServiceFactory implements C13181b<FlagService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorV3Provider;
    private final FragmentModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7563293629790162864L, "cm/aptoide/pt/view/FragmentModule_ProvidesFlagServiceFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesFlagServiceFactory(FragmentModule module2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorV3Provider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.bodyInterceptorV3Provider = bodyInterceptorV3Provider2;
        this.okHttpClientProvider = okHttpClientProvider2;
        this.tokenInvalidatorProvider = tokenInvalidatorProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public FlagService get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<BodyInterceptor<BaseBody>> provider = this.bodyInterceptorV3Provider;
        $jacocoInit[1] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider.get();
        Provider<OkHttpClient> provider2 = this.okHttpClientProvider;
        $jacocoInit[2] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider2.get();
        Provider<TokenInvalidator> provider3 = this.tokenInvalidatorProvider;
        $jacocoInit[3] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider3.get();
        Provider<SharedPreferences> provider4 = this.sharedPreferencesProvider;
        $jacocoInit[4] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider4.get();
        $jacocoInit[5] = true;
        FlagService providesFlagService = fragmentModule.providesFlagService(bodyInterceptor, okHttpClient, tokenInvalidator, sharedPreferences);
        $jacocoInit[6] = true;
        C13182c.m43111a(providesFlagService, "Cannot return null from a non-@Nullable @Provides method");
        FlagService flagService = providesFlagService;
        $jacocoInit[7] = true;
        return flagService;
    }

    public static C13181b<FlagService> create(FragmentModule module2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorV3Provider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesFlagServiceFactory fragmentModule_ProvidesFlagServiceFactory = new FragmentModule_ProvidesFlagServiceFactory(module2, bodyInterceptorV3Provider2, okHttpClientProvider2, tokenInvalidatorProvider2, sharedPreferencesProvider2);
        $jacocoInit[8] = true;
        return fragmentModule_ProvidesFlagServiceFactory;
    }

    public static FlagService proxyProvidesFlagService(FragmentModule instance, BodyInterceptor<BaseBody> bodyInterceptorV3, OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        FlagService providesFlagService = instance.providesFlagService(bodyInterceptorV3, okHttpClient, tokenInvalidator, sharedPreferences);
        $jacocoInit[9] = true;
        return providesFlagService;
    }
}
