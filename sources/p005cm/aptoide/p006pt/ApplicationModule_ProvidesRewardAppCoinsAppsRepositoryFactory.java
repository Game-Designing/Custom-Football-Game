package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.repository.request.RewardAppCoinsAppsRepository;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesRewardAppCoinsAppsRepositoryFactory */
public final class ApplicationModule_ProvidesRewardAppCoinsAppsRepositoryFactory implements C13181b<RewardAppCoinsAppsRepository> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BodyInterceptor<BaseBody>> baseBodyBodyInterceptorProvider;
    private final Provider<InstallManager> installManagerProvider;
    private final ApplicationModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2475576440661722001L, "cm/aptoide/pt/ApplicationModule_ProvidesRewardAppCoinsAppsRepositoryFactory", 12);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesRewardAppCoinsAppsRepositoryFactory(ApplicationModule module2, Provider<OkHttpClient> okHttpClientProvider2, Provider<BodyInterceptor<BaseBody>> baseBodyBodyInterceptorProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<InstallManager> installManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.okHttpClientProvider = okHttpClientProvider2;
        this.baseBodyBodyInterceptorProvider = baseBodyBodyInterceptorProvider2;
        this.tokenInvalidatorProvider = tokenInvalidatorProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.installManagerProvider = installManagerProvider2;
        $jacocoInit[0] = true;
    }

    public RewardAppCoinsAppsRepository get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<OkHttpClient> provider = this.okHttpClientProvider;
        $jacocoInit[1] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider.get();
        Provider<BodyInterceptor<BaseBody>> provider2 = this.baseBodyBodyInterceptorProvider;
        $jacocoInit[2] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider2.get();
        Provider<TokenInvalidator> provider3 = this.tokenInvalidatorProvider;
        $jacocoInit[3] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider3.get();
        Provider<SharedPreferences> provider4 = this.sharedPreferencesProvider;
        $jacocoInit[4] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider4.get();
        Provider<InstallManager> provider5 = this.installManagerProvider;
        $jacocoInit[5] = true;
        InstallManager installManager = (InstallManager) provider5.get();
        $jacocoInit[6] = true;
        RewardAppCoinsAppsRepository providesRewardAppCoinsAppsRepository = applicationModule.providesRewardAppCoinsAppsRepository(okHttpClient, bodyInterceptor, tokenInvalidator, sharedPreferences, installManager);
        $jacocoInit[7] = true;
        C13182c.m43111a(providesRewardAppCoinsAppsRepository, "Cannot return null from a non-@Nullable @Provides method");
        RewardAppCoinsAppsRepository rewardAppCoinsAppsRepository = providesRewardAppCoinsAppsRepository;
        $jacocoInit[8] = true;
        return rewardAppCoinsAppsRepository;
    }

    public static C13181b<RewardAppCoinsAppsRepository> create(ApplicationModule module2, Provider<OkHttpClient> okHttpClientProvider2, Provider<BodyInterceptor<BaseBody>> baseBodyBodyInterceptorProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<InstallManager> installManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesRewardAppCoinsAppsRepositoryFactory applicationModule_ProvidesRewardAppCoinsAppsRepositoryFactory = new ApplicationModule_ProvidesRewardAppCoinsAppsRepositoryFactory(module2, okHttpClientProvider2, baseBodyBodyInterceptorProvider2, tokenInvalidatorProvider2, sharedPreferencesProvider2, installManagerProvider2);
        $jacocoInit[9] = true;
        return applicationModule_ProvidesRewardAppCoinsAppsRepositoryFactory;
    }

    public static RewardAppCoinsAppsRepository proxyProvidesRewardAppCoinsAppsRepository(ApplicationModule instance, OkHttpClient okHttpClient, BodyInterceptor<BaseBody> baseBodyBodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, InstallManager installManager) {
        boolean[] $jacocoInit = $jacocoInit();
        RewardAppCoinsAppsRepository providesRewardAppCoinsAppsRepository = instance.providesRewardAppCoinsAppsRepository(okHttpClient, baseBodyBodyInterceptor, tokenInvalidator, sharedPreferences, installManager);
        $jacocoInit[10] = true;
        return providesRewardAppCoinsAppsRepository;
    }
}
