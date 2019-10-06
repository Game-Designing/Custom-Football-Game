package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.accounts.NetworkErrorException;
import android.content.SharedPreferences;
import com.mopub.common.Constants;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.exception.AptoideWsV7Exception;
import p005cm.aptoide.p006pt.dataprovider.exception.NoNetworkConnectionException;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Error;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Info.Status;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.EditorialCard;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetApp;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetFollowers;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetMySubscribedStoresResponse;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetUserInfo;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListAppCoinsCampaigns;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListApps;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListComments;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListFullReviews;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListReviews;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.SetComment;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.TimelineStats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.ListAppVersions;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.ListAppsUpdates;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.search.ListSearchApps;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetHome;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetHomeMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStore;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreDisplays;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.ListStores;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.RefreshBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.analyticsbody.DownloadInstallAnalyticsBaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.CreateTransactionRequest.RequestBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.CreateTransactionRequest.ResponseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.DeletePurchaseRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetAuthorizationRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetMerchantRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetProductsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetPurchaseRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetPurchasesRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetServicesRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetTransactionRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.UpdateAuthorizationRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.ActionItemResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.GetActionItemRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.GetHomeBundlesRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.WalletAdsOfferResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.listapps.ListAppVersionsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.listapps.ListAppcAppsUpgradesRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.listapps.ListAppsUpdatesRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.post.CardPreviewRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.post.CardPreviewResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.post.PostInTimelineResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.post.PostRequest.PostRequestBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.post.RelatedAppRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.post.RelatedAppResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.ClaimPromotionRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.GetPackagePromotionsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.GetPackagePromotionsResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.GetPromotionAppsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.GetPromotionAppsResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.GetPromotionsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.GetPromotionsResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.ChangeStoreSubscriptionRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetHomeBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetHomeMetaRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetMyStoreListRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetMyStoreListRequest.EndlessBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetRecommendedStoresRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreDisplaysRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreWidgetsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetUserRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.ListStoresRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.PostCommentForStore;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p005cm.aptoide.p006pt.dataprovider.util.ToRetryThrowable;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14541q;
import p026rx.schedulers.Schedulers;
import retrofit2.Converter.Factory;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.V7 */
public abstract class C0044V7<U, B extends RefreshBody> extends WebService<Interfaces, U> {
    private final String INVALID_ACCESS_TOKEN_CODE = "AUTH-2";
    private final int MAX_RETRY_COUNT = 3;
    private boolean accessTokenRetry = false;
    protected final B body;
    protected final BodyInterceptor bodyInterceptor;
    private final TokenInvalidator tokenInvalidator;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.V7$Interfaces */
    public interface Interfaces {
        @POST("user/addEvent/name={name}/action={action}/context={context}")
        C0120S<BaseV7Response> addEvent(@Path("name") String str, @Path("action") String str2, @Path("context") String str3, @Body BiUtmAnalyticsRequestBody biUtmAnalyticsRequestBody);

        @POST("user/addEvent/name={name}/action={action}/context={context}")
        C0120S<BaseV7Response> addEvent(@Path("name") String str, @Path("action") String str2, @Path("context") String str3, @Body DownloadInstallAnalyticsBaseBody downloadInstallAnalyticsBaseBody);

        @POST("store/subscription/set")
        C0120S<ChangeStoreSubscriptionResponse> changeStoreSubscription(@Header("X-Bypass-Cache") boolean z, @Body ChangeStoreSubscriptionRequest.Body body);

        @POST("appcoins/promotions/claim")
        C0120S<BaseV7Response> claimPromotion(@Body ClaimPromotionRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("inapp/bank/transaction/set")
        C0120S<ResponseBody> createBillingTransaction(@Body RequestBody requestBody, @Header("X-Bypass-Cache") boolean z);

        @POST("inapp/purchase/consume")
        C0120S<BaseV7Response> deleteBillingPurchase(@Body DeletePurchaseRequest.RequestBody requestBody, @Header("X-Bypass-Cache") boolean z);

        @POST("user/timeline/card/del")
        C0120S<BaseV7Response> deletePost(@Body PostDeleteRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("store/set")
        C0120S<BaseV7Response> editStore(@Body SimpleSetStoreRequest.Body body);

        @POST("store/set")
        @Multipart
        C0120S<BaseV7Response> editStore(@Part MultipartBody.Part part, @PartMap HashMapNotNull<String, okhttp3.RequestBody> hashMapNotNull);

        @POST("user/set")
        @Multipart
        C0120S<BaseV7Response> editUser(@Part MultipartBody.Part part, @PartMap HashMapNotNull<String, okhttp3.RequestBody> hashMapNotNull);

        @POST("{url}")
        C0120S<ActionItemResponse> getActionItem(@Path(encoded = true, value = "url") String str, @Body GetActionItemRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("getApp")
        C0120S<GetApp> getApp(@Body GetAppRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("appcoins/catappult/campaigns/get/limit={limit}")
        C0120S<ListAppCoinsCampaigns> getAppCoinsAds(@Body GetAppCoinsCampaignsRequest.Body body, @Header("X-Bypass-Cache") boolean z, @Path("limit") int i);

        @POST("getAppMeta{url}")
        C0120S<GetAppMeta> getAppMeta(@Header("X-Bypass-Cache") boolean z, @Path(encoded = true, value = "url") String str);

        @GET("inapp/bank/authorization/getMeta")
        C0120S<Response<GetAuthorizationRequest.ResponseBody>> getBillingAuthorization(@Query("transaction_id") long j, @Header("Authorization") String str, @Query("user_id") String str2);

        @POST("inapp/getPackage")
        C0120S<GetMerchantRequest.ResponseBody> getBillingMerchant(@Body GetMerchantRequest.RequestBody requestBody, @Header("X-Bypass-Cache") boolean z);

        @POST("inapp/product/getMeta")
        C0120S<GetProductsRequest.ResponseBody> getBillingProduct(@Body GetProductsRequest.RequestBody requestBody, @Header("X-Bypass-Cache") boolean z);

        @POST("inapp/products/get")
        C0120S<GetProductsRequest.ResponseBody> getBillingProducts(@Body GetProductsRequest.RequestBody requestBody, @Header("X-Bypass-Cache") boolean z);

        @POST("inapp/purchase/getMeta")
        C0120S<Response<GetPurchaseRequest.ResponseBody>> getBillingPurchase(@Body GetPurchaseRequest.RequestBody requestBody, @Header("X-Bypass-Cache") boolean z);

        @POST("inapp/purchases/get")
        C0120S<Response<GetPurchasesRequest.ResponseBody>> getBillingPurchases(@Body GetPurchasesRequest.RequestBody requestBody, @Header("X-Bypass-Cache") boolean z);

        @POST("inapp/bank/services/get")
        C0120S<GetServicesRequest.ResponseBody> getBillingServices(@Body BaseBody baseBody, @Header("X-Bypass-Cache") boolean z);

        @GET("inapp/bank/transaction/getMeta")
        C0120S<Response<GetTransactionRequest.ResponseBody>> getBillingTransaction(@Query("product_id") long j, @Header("Authorization") String str, @Query("user_id") String str2);

        @POST("user/timeline/card/preview/get")
        C0120S<CardPreviewResponse> getCardPreview(@Header("X-Bypass-Cache") boolean z, @Body CardPreviewRequest.Body body);

        @POST("user/timeline/card/getLikes")
        C0120S<GetFollowers> getCardUserLikes(@Body GetUserLikesRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("user/action/item/card/get/id={cardId}")
        C0120S<EditorialCard> getEditorial(@Path("cardId") String str, @Body BaseBody baseBody);

        @POST("user/action/item/cards/get/type=CURATION_1/limit={limit}")
        C0120S<EditorialListResponse> getEditorialList(@Path("limit") int i, @Body EditorialListRequest.Body body);

        @POST("home/get")
        C0120S<GetHome> getHome(@Body GetHomeBody getHomeBody, @Header("X-Bypass-Cache") boolean z);

        @POST("getStoreWidgets/")
        C0120S<GetStoreWidgets> getHomeBundles(@Body GetHomeBundlesRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("home/getMeta{url}")
        C0120S<GetHomeMeta> getHomeMeta(@Path(encoded = true, value = "url") String str, @Body GetHomeMetaRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("my/stores/getSubscribed")
        C0120S<ListStores> getMyStoreList(@Body GetMyStoreListRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("{url}")
        C0120S<ListStores> getMyStoreList(@Path(encoded = true, value = "url") String str, @Body GetMyStoreListRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("{url}")
        C0120S<ListStores> getMyStoreListEndless(@Path(encoded = true, value = "url") String str, @Body EndlessBody endlessBody, @Header("X-Bypass-Cache") boolean z);

        @POST("my/store/getMeta")
        C0120S<GetStoreMeta> getMyStoreMeta(@Body BaseBody baseBody, @Header("X-Bypass-Cache") boolean z);

        @POST("my/stores/getSubscribed/")
        C0120S<GetMySubscribedStoresResponse> getMySubscribedStores(@Header("X-Bypass-Cache") boolean z, @Body GetMySubscribedStoresRequest.Body body);

        @POST("appcoins/promotions/promotion/get/limit={limit}")
        C0120S<GetPromotionAppsResponse> getPromotionApps(@Path("limit") int i, @Body GetPromotionAppsRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("appcoins/promotions/get")
        C0120S<GetPromotionsResponse> getPromotions(@Body GetPromotionsRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("appcoins/promotions/packages/getPromotions")
        C0120S<GetPackagePromotionsResponse> getPromotionsForPackage(@Body GetPackagePromotionsRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("apps/getRecommended")
        C0120S<ListApps> getRecommended(@Body GetRecommendedRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("{url}")
        C0120S<ListStores> getRecommendedStore(@Path(encoded = true, value = "url") String str, @Body GetRecommendedStoresRequest.EndlessBody endlessBody, @Header("X-Bypass-Cache") boolean z);

        @POST("user/timeline/card/apps/get")
        C0120S<RelatedAppResponse> getRelatedApps(@Header("X-Bypass-Cache") boolean z, @Body RelatedAppRequest.Body body);

        @POST("getStore{url}")
        C0120S<GetStore> getStore(@Path(encoded = true, value = "url") String str, @Body GetStoreBody getStoreBody, @Header("X-Bypass-Cache") boolean z);

        @POST("getStoreDisplays{url}")
        C0120S<GetStoreDisplays> getStoreDisplays(@Path(encoded = true, value = "url") String str, @Body GetStoreDisplaysRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("store/getMeta")
        C0120S<GetStoreMeta> getStoreMeta(@Body GetHomeMetaRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("{url}")
        C0120S<GetStoreMeta> getStoreMeta(@Path(encoded = true, value = "url") String str, @Body GetHomeMetaRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("getStoreWidgets{url}")
        C0120S<GetStoreWidgets> getStoreWidgets(@Path(encoded = true, value = "url") String str, @Body GetStoreWidgetsRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("user/getFollowers")
        C0120S<GetFollowers> getTimelineFollowers(@Body GetFollowersRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("user/getFollowing")
        C0120S<GetFollowers> getTimelineGetFollowing(@Body GetFollowersRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("user/getTimelineStats")
        C0120S<TimelineStats> getTimelineStats(@Body GetTimelineStatsRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("user/get{url}")
        C0120S<GetStore> getUser(@Path(encoded = true, value = "url") String str, @Body GetUserRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("user/get")
        C0120S<GetUserInfo> getUserInfo(@Body GetUserInfoRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("appcoins/promotions/ads/get")
        C0120S<WalletAdsOfferResponse> isWalletOfferActive(@Body BaseBody baseBody, @Header("X-Bypass-Cache") boolean z);

        @POST("listAppVersions")
        C0120S<ListAppVersions> listAppVersions(@Body ListAppVersionsRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("listAppcAppsUpgrades")
        C0120S<ListAppsUpdates> listAppcAppssUpgrades(@Body ListAppcAppsUpgradesRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("listApps{url}")
        C0120S<ListApps> listApps(@Path(encoded = true, value = "url") String str, @Body ListAppsRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("listAppsUpdates")
        C0120S<ListAppsUpdates> listAppsUpdates(@Body ListAppsUpdatesRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("listComments")
        C0120S<ListComments> listComments(@Body ListCommentsRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST
        C0120S<ListComments> listComments(@Url String str, @Body ListCommentsRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("listFullReviews")
        C0120S<ListFullReviews> listFullReviews(@Body ListFullReviewsRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("listFullReviews{url}")
        C0120S<ListFullReviews> listFullReviews(@Path(encoded = true, value = "url") String str, @Body ListFullReviewsRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("listReviews")
        C0120S<ListReviews> listReviews(@Body ListReviewsRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("listSearchApps")
        C0120S<ListSearchApps> listSearchApps(@Body ListSearchAppsRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("listStores{url}")
        C0120S<ListStores> listStores(@Path(encoded = true, value = "url") String str, @Body ListStoresRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("listStores/sort/{sort}/limit/{limit}")
        C0120S<ListStores> listTopStores(@Path(encoded = true, value = "sort") String str, @Path(encoded = true, value = "limit") int i, @Body ListStoresRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("user/timeline/card/set")
        C0120S<PostInTimelineResponse> postInTimeline(@Header("X-Bypass-Cache") boolean z, @Body PostRequestBody postRequestBody);

        @POST("setReview")
        C0120S<BaseV7Response> postReview(@Body PostReviewRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("setComment")
        C0120S<BaseV7Response> postReviewComment(@Body PostCommentForReview.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("setComment")
        C0120S<SetComment> postStoreComment(@Body PostCommentForStore.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("review/set/access_token={accessToken}/card_uid={cardUid}/rating={rating}")
        C0120S<BaseV7Response> setReview(@Body BaseBody baseBody, @Path("cardUid") String str, @Path("accessToken") String str2, @Path("rating") String str3, @Header("X-Bypass-Cache") boolean z);

        @POST("setReviewVote")
        C0120S<BaseV7Response> setReviewVote(@Body SetReviewRatingRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("user/set")
        C0120S<BaseV7Response> setUser(@Body SetUserRequest.Body body);

        @POST("user/settings/set")
        C0120S<BaseV7Response> setUserSettings(@Body SetUserSettings.Body body);

        @POST("user/follower/set/")
        C0120S<BaseV7Response> unfollowUser(@Body UnfollowUserRequest.Body body, @Header("X-Bypass-Cache") boolean z);

        @POST("inapp/bank/authorization/set")
        C0120S<UpdateAuthorizationRequest.ResponseBody> updateBillingAuthorization(@Body UpdateAuthorizationRequest.RequestBody requestBody, @Header("X-Bypass-Cache") boolean z);
    }

    protected C0044V7(B body2, String baseHost, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor2, TokenInvalidator tokenInvalidator2) {
        super(Interfaces.class, httpClient, converterFactory, baseHost);
        this.body = body2;
        this.bodyInterceptor = bodyInterceptor2;
        this.tokenInvalidator = tokenInvalidator2;
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? Constants.HTTP : "https");
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_V7_HOST);
        sb.append("/api/7/");
        return sb.toString();
    }

    public static String getErrorMessage(BaseV7Response response) {
        StringBuilder builder = new StringBuilder();
        if (response == null || response.getErrors() == null) {
            builder.append("Server returned null response.");
        } else {
            for (Error error : response.getErrors()) {
                builder.append(error.getDescription());
                builder.append(". ");
            }
            if (builder.length() == 0) {
                builder.append("Server failed with empty error list.");
            }
        }
        return builder.toString();
    }

    /* access modifiers changed from: protected */
    public TokenInvalidator getTokenInvalidator() {
        return this.tokenInvalidator;
    }

    public B getBody() {
        return this.body;
    }

    public C0120S<U> observe(boolean bypassCache, boolean bypassServerCache) {
        B b = this.body;
        if (b != null) {
            b.setRefresh(bypassServerCache);
        }
        return observe(bypassCache);
    }

    public C0120S<U> observe(boolean bypassCache) {
        B b = this.body;
        if (b == null) {
            return handleToken(retryOnTicket(super.observe(bypassCache)), bypassCache);
        }
        return this.bodyInterceptor.intercept(b).mo3697c(new C2878c(this, bypassCache));
    }

    /* renamed from: b */
    public /* synthetic */ Object mo1886b(boolean bypassCache, Object body2) {
        return handleToken(retryOnTicket(super.observe(bypassCache)), bypassCache);
    }

    private C0120S<U> retryOnTicket(C0120S<U> observable) {
        return observable.mo3634b(Schedulers.m776io()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2880e<Object,Object>(this)).mo3676m(new C2876a(this));
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo1883a(Object response) {
        BaseV7Response v7Response;
        if (!(response instanceof Response)) {
            v7Response = (BaseV7Response) response;
        } else if (((Response) response).isSuccessful()) {
            v7Response = (BaseV7Response) ((Response) response).body();
        } else {
            try {
                v7Response = (BaseV7Response) this.retrofit.responseBodyConverter(BaseV7Response.class, new Annotation[0]).convert(((Response) response).errorBody());
                if (((Response) response).code() == 401) {
                    AptoideWsV7Exception exception = new AptoideWsV7Exception();
                    exception.setBaseResponse(v7Response);
                    return C0120S.m631a((Throwable) exception);
                }
            } catch (IOException e) {
                return C0120S.m631a((Throwable) e);
            }
        }
        if (v7Response.getInfo() == null || !Status.QUEUED.equals(v7Response.getInfo().getStatus())) {
            return C0120S.m652c(response);
        }
        return C0120S.m631a((Throwable) new ToRetryThrowable());
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo1884a(C0120S errObservable) {
        return errObservable.mo3615a(C0120S.m626a(1, 3), (C14541q<? super T, ? super T2, ? extends R>) new C2877b<Object,Object,Object>(this)).mo3630b(500, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public /* synthetic */ Object mo1882a(Throwable throwable, Integer i) {
        if ((throwable instanceof ToRetryThrowable) && i.intValue() < 3) {
            return null;
        }
        if (isNoNetworkException(throwable)) {
            throw new NoNetworkConnectionException(throwable);
        } else if (throwable instanceof AptoideWsV7Exception) {
            throw ((AptoideWsV7Exception) throwable);
        } else if (throwable instanceof HttpException) {
            try {
                AptoideWsV7Exception exception = new AptoideWsV7Exception(throwable);
                exception.setBaseResponse((BaseV7Response) this.converterFactory.responseBodyConverter(BaseV7Response.class, null, null).convert(((HttpException) throwable).response().errorBody()));
                throw exception;
            } catch (IOException exception2) {
                throw new RuntimeException(exception2);
            }
        } else {
            throw new RuntimeException(throwable);
        }
    }

    private C0120S<U> handleToken(C0120S<U> observable, boolean bypassCache) {
        return observable.mo3671k(new C2879d(this, bypassCache));
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo1885a(boolean bypassCache, Throwable throwable) {
        if (!(throwable instanceof AptoideWsV7Exception)) {
            return C0120S.m631a(throwable);
        }
        if (!"AUTH-2".equals(((AptoideWsV7Exception) throwable).getBaseResponse().getError().getCode())) {
            return C0120S.m631a(throwable);
        }
        if (this.accessTokenRetry) {
            return C0120S.m631a((Throwable) new NetworkErrorException());
        }
        this.accessTokenRetry = true;
        return this.tokenInvalidator.invalidateAccessToken().mo3578a(500, TimeUnit.MILLISECONDS).mo3586a(observe(bypassCache));
    }
}
