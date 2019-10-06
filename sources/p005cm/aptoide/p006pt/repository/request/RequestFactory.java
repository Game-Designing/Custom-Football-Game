package p005cm.aptoide.p006pt.repository.request;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.view.WindowManager;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.AdsApplicationVersionCodeProvider;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.GetRecommendedRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListAppsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListFullReviewsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetRecommendedStoresRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreWidgetsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetUserRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.ListStoresRequest;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import retrofit2.Converter.Factory;

@Deprecated
/* renamed from: cm.aptoide.pt.repository.request.RequestFactory */
public class RequestFactory {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final GetRecommendedRequestFactory getRecommendedRequestFactory;
    private final GetStoreRecommendedRequestFactory getStoreRecommendedRequestFactory;
    private final GetStoreRequestFactory getStoreRequestFactory;
    private final GetStoreWidgetsRequestFactory getStoreWidgetsRequestFactory;
    private final GetUserRequestFactory getUserRequestFactory;
    private final boolean googlePlayServicesAvailable;
    private final ListAppsRequestFactory listAppsRequestFactory;
    private final ListFullReviewsRequestFactory listFullReviewsRequestFactory;
    private final ListStoresRequestFactory listStoresRequestFactory;
    private final StoreCredentialsProvider storeCredentialsProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5089659492469074975L, "cm/aptoide/pt/repository/request/RequestFactory", 20);
        $jacocoData = probes;
        return probes;
    }

    public RequestFactory(StoreCredentialsProvider storeCredentialsProvider2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager, String clientUniqueId, String partnerId, AptoideAccountManager accountManager, String filters, ConnectivityManager connectivityManager, AdsApplicationVersionCodeProvider versionCodeProvider, boolean googlePlayServicesAvailable2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeCredentialsProvider = storeCredentialsProvider2;
        this.googlePlayServicesAvailable = googlePlayServicesAvailable2;
        $jacocoInit[0] = true;
        OkHttpClient okHttpClient = httpClient;
        Factory factory = converterFactory;
        TokenInvalidator tokenInvalidator2 = tokenInvalidator;
        SharedPreferences sharedPreferences2 = sharedPreferences;
        ListStoresRequestFactory listStoresRequestFactory2 = new ListStoresRequestFactory(bodyInterceptor, okHttpClient, factory, tokenInvalidator2, sharedPreferences2);
        this.listStoresRequestFactory = listStoresRequestFactory2;
        $jacocoInit[1] = true;
        Resources resources2 = resources;
        WindowManager windowManager2 = windowManager;
        ListAppsRequestFactory listAppsRequestFactory2 = new ListAppsRequestFactory(bodyInterceptor, storeCredentialsProvider2, okHttpClient, factory, tokenInvalidator2, sharedPreferences2, resources2, windowManager2);
        this.listAppsRequestFactory = listAppsRequestFactory2;
        $jacocoInit[2] = true;
        BodyInterceptor<BaseBody> bodyInterceptor2 = bodyInterceptor;
        ListFullReviewsRequestFactory listFullReviewsRequestFactory2 = new ListFullReviewsRequestFactory(bodyInterceptor2, okHttpClient, factory, tokenInvalidator2, sharedPreferences2);
        this.listFullReviewsRequestFactory = listFullReviewsRequestFactory2;
        $jacocoInit[3] = true;
        StoreCredentialsProvider storeCredentialsProvider3 = storeCredentialsProvider2;
        GetStoreRequestFactory getStoreRequestFactory2 = new GetStoreRequestFactory(storeCredentialsProvider3, bodyInterceptor2, okHttpClient, factory, tokenInvalidator2, sharedPreferences2, resources2, windowManager2);
        this.getStoreRequestFactory = getStoreRequestFactory2;
        $jacocoInit[4] = true;
        String str = clientUniqueId;
        String str2 = partnerId;
        boolean[] zArr = $jacocoInit;
        GetStoreWidgetsRequestFactory getStoreWidgetsRequestFactory2 = r2;
        AptoideAccountManager aptoideAccountManager = accountManager;
        String str3 = filters;
        ConnectivityManager connectivityManager2 = connectivityManager;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = versionCodeProvider;
        GetStoreWidgetsRequestFactory getStoreWidgetsRequestFactory3 = new GetStoreWidgetsRequestFactory(storeCredentialsProvider3, bodyInterceptor2, okHttpClient, factory, tokenInvalidator2, sharedPreferences2, resources2, windowManager2, str, str2, aptoideAccountManager, str3, connectivityManager2, adsApplicationVersionCodeProvider);
        this.getStoreWidgetsRequestFactory = getStoreWidgetsRequestFactory2;
        zArr[5] = true;
        BodyInterceptor<BaseBody> bodyInterceptor3 = bodyInterceptor;
        OkHttpClient okHttpClient2 = httpClient;
        Factory factory2 = converterFactory;
        TokenInvalidator tokenInvalidator3 = tokenInvalidator;
        SharedPreferences sharedPreferences3 = sharedPreferences;
        GetUserRequestFactory getUserRequestFactory2 = new GetUserRequestFactory(bodyInterceptor3, okHttpClient2, factory2, tokenInvalidator3, sharedPreferences3, resources, windowManager, storeCredentialsProvider2, str, str2, aptoideAccountManager, str3, connectivityManager2, adsApplicationVersionCodeProvider);
        this.getUserRequestFactory = getUserRequestFactory2;
        zArr[6] = true;
        GetStoreRecommendedRequestFactory getStoreRecommendedRequestFactory2 = new GetStoreRecommendedRequestFactory(bodyInterceptor3, okHttpClient2, factory2, tokenInvalidator3, sharedPreferences3);
        this.getStoreRecommendedRequestFactory = getStoreRecommendedRequestFactory2;
        zArr[7] = true;
        GetRecommendedRequestFactory getRecommendedRequestFactory2 = new GetRecommendedRequestFactory(bodyInterceptor3, okHttpClient2, factory2, tokenInvalidator3, sharedPreferences3);
        this.getRecommendedRequestFactory = getRecommendedRequestFactory2;
        zArr[8] = true;
    }

    @Deprecated
    public ListStoresRequest newListStoresRequest(int offset, int limit) {
        boolean[] $jacocoInit = $jacocoInit();
        ListStoresRequest newListStoresRequest = this.listStoresRequestFactory.newListStoresRequest(offset, limit);
        $jacocoInit[9] = true;
        return newListStoresRequest;
    }

    @Deprecated
    public ListStoresRequest newListStoresRequest(String url) {
        boolean[] $jacocoInit = $jacocoInit();
        ListStoresRequest newListStoresRequest = this.listStoresRequestFactory.newListStoresRequest(url);
        $jacocoInit[10] = true;
        return newListStoresRequest;
    }

    @Deprecated
    public ListAppsRequest newListAppsRequest(String url) {
        boolean[] $jacocoInit = $jacocoInit();
        ListAppsRequest newListAppsRequest = this.listAppsRequestFactory.newListAppsRequest(url);
        $jacocoInit[11] = true;
        return newListAppsRequest;
    }

    @Deprecated
    public ListFullReviewsRequest newListFullReviews(String url, boolean refresh) {
        boolean[] $jacocoInit = $jacocoInit();
        ListFullReviewsRequestFactory listFullReviewsRequestFactory2 = this.listFullReviewsRequestFactory;
        StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
        $jacocoInit[12] = true;
        StoreCredentials fromUrl = storeCredentialsProvider2.fromUrl(url);
        $jacocoInit[13] = true;
        ListFullReviewsRequest newListFullReviews = listFullReviewsRequestFactory2.newListFullReviews(url, refresh, fromUrl);
        $jacocoInit[14] = true;
        return newListFullReviews;
    }

    @Deprecated
    public GetStoreRequest newStore(String url) {
        boolean[] $jacocoInit = $jacocoInit();
        GetStoreRequest newStore = this.getStoreRequestFactory.newStore(url);
        $jacocoInit[15] = true;
        return newStore;
    }

    @Deprecated
    public GetStoreWidgetsRequest newStoreWidgets(String url) {
        boolean[] $jacocoInit = $jacocoInit();
        GetStoreWidgetsRequest newStoreWidgets = this.getStoreWidgetsRequestFactory.newStoreWidgets(url, this.googlePlayServicesAvailable);
        $jacocoInit[16] = true;
        return newStoreWidgets;
    }

    @Deprecated
    public GetUserRequest newGetUser(String url) {
        boolean[] $jacocoInit = $jacocoInit();
        GetUserRequest newGetUser = this.getUserRequestFactory.newGetUser(url, this.googlePlayServicesAvailable);
        $jacocoInit[17] = true;
        return newGetUser;
    }

    @Deprecated
    public GetRecommendedStoresRequest newGetRecommendedStores(String url) {
        boolean[] $jacocoInit = $jacocoInit();
        GetRecommendedStoresRequest newRecommendedStore = this.getStoreRecommendedRequestFactory.newRecommendedStore(url);
        $jacocoInit[18] = true;
        return newRecommendedStore;
    }

    @Deprecated
    public GetRecommendedRequest newGetRecommendedRequest(int limit, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        GetRecommendedRequest newGetRecommendedRequest = this.getRecommendedRequestFactory.newGetRecommendedRequest(limit, packageName);
        $jacocoInit[19] = true;
        return newGetRecommendedRequest;
    }
}
