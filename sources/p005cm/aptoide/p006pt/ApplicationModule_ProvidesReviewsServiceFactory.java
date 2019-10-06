package p005cm.aptoide.p006pt;

import android.content.SharedPreferences;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.ReviewsService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesReviewsServiceFactory */
public final class ApplicationModule_ProvidesReviewsServiceFactory implements C13181b<ReviewsService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider;
    private final ApplicationModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<StoreCredentialsProvider> storeCredentialsProvider;
    private final Provider<TokenInvalidator> tokenInvalidatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4452977167795422829L, "cm/aptoide/pt/ApplicationModule_ProvidesReviewsServiceFactory", 12);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesReviewsServiceFactory(ApplicationModule module2, Provider<StoreCredentialsProvider> storeCredentialsProvider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.storeCredentialsProvider = storeCredentialsProvider2;
        this.bodyInterceptorPoolV7Provider = bodyInterceptorPoolV7Provider2;
        this.okHttpClientProvider = okHttpClientProvider2;
        this.tokenInvalidatorProvider = tokenInvalidatorProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        $jacocoInit[0] = true;
    }

    public ReviewsService get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<StoreCredentialsProvider> provider = this.storeCredentialsProvider;
        $jacocoInit[1] = true;
        StoreCredentialsProvider storeCredentialsProvider2 = (StoreCredentialsProvider) provider.get();
        Provider<BodyInterceptor<BaseBody>> provider2 = this.bodyInterceptorPoolV7Provider;
        $jacocoInit[2] = true;
        BodyInterceptor bodyInterceptor = (BodyInterceptor) provider2.get();
        Provider<OkHttpClient> provider3 = this.okHttpClientProvider;
        $jacocoInit[3] = true;
        OkHttpClient okHttpClient = (OkHttpClient) provider3.get();
        Provider<TokenInvalidator> provider4 = this.tokenInvalidatorProvider;
        $jacocoInit[4] = true;
        TokenInvalidator tokenInvalidator = (TokenInvalidator) provider4.get();
        Provider<SharedPreferences> provider5 = this.sharedPreferencesProvider;
        $jacocoInit[5] = true;
        SharedPreferences sharedPreferences = (SharedPreferences) provider5.get();
        $jacocoInit[6] = true;
        ReviewsService providesReviewsService = applicationModule.providesReviewsService(storeCredentialsProvider2, bodyInterceptor, okHttpClient, tokenInvalidator, sharedPreferences);
        $jacocoInit[7] = true;
        C13182c.m43111a(providesReviewsService, "Cannot return null from a non-@Nullable @Provides method");
        ReviewsService reviewsService = providesReviewsService;
        $jacocoInit[8] = true;
        return reviewsService;
    }

    public static C13181b<ReviewsService> create(ApplicationModule module2, Provider<StoreCredentialsProvider> storeCredentialsProvider2, Provider<BodyInterceptor<BaseBody>> bodyInterceptorPoolV7Provider2, Provider<OkHttpClient> okHttpClientProvider2, Provider<TokenInvalidator> tokenInvalidatorProvider2, Provider<SharedPreferences> sharedPreferencesProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesReviewsServiceFactory applicationModule_ProvidesReviewsServiceFactory = new ApplicationModule_ProvidesReviewsServiceFactory(module2, storeCredentialsProvider2, bodyInterceptorPoolV7Provider2, okHttpClientProvider2, tokenInvalidatorProvider2, sharedPreferencesProvider2);
        $jacocoInit[9] = true;
        return applicationModule_ProvidesReviewsServiceFactory;
    }

    public static ReviewsService proxyProvidesReviewsService(ApplicationModule instance, StoreCredentialsProvider storeCredentialsProvider2, BodyInterceptor<BaseBody> bodyInterceptorPoolV7, OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        ReviewsService providesReviewsService = instance.providesReviewsService(storeCredentialsProvider2, bodyInterceptorPoolV7, okHttpClient, tokenInvalidator, sharedPreferences);
        $jacocoInit[10] = true;
        return providesReviewsService;
    }
}
