package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import android.text.TextUtils;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListFullReviews;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.ListFullReviewsRequest */
public class ListFullReviewsRequest extends C0044V7<ListFullReviews, Body> {
    private static final int MAX_COMMENTS = 10;
    private static final int MAX_REVIEWS = 10;
    private String url;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.ListFullReviewsRequest$Body */
    public static class Body extends BaseBodyWithStore implements Endless {
        private String lang;
        private Integer limit;
        private boolean mature;
        private int offset;
        private Order order;
        private String packageName;
        private boolean refresh;
        private Long reviewId;
        private Sort sort;
        private Long storeId;
        private String storeName;
        private Integer subLimit;

        /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.ListFullReviewsRequest$Body$Sort */
        public enum Sort {
            latest,
            points
        }

        public Body(boolean refresh2, StoreCredentials storeCredentials) {
            super(storeCredentials);
            this.refresh = refresh2;
        }

        public Body(long storeId2, int limit2, int offset2, boolean refresh2, StoreCredentials storeCredentials) {
            super(storeCredentials);
            this.storeId = Long.valueOf(storeId2);
            this.limit = Integer.valueOf(limit2);
            this.offset = offset2;
            this.refresh = refresh2;
        }

        public Body(String storeName2, String packageName2, int limit2, int subLimit2, boolean refresh2) {
            this.packageName = packageName2;
            this.storeName = storeName2;
            this.limit = Integer.valueOf(limit2);
            this.subLimit = Integer.valueOf(subLimit2);
            this.refresh = refresh2;
        }

        public int getOffset() {
            return this.offset;
        }

        public void setOffset(int offset2) {
            this.offset = offset2;
        }

        public Integer getLimit() {
            return this.limit;
        }
    }

    protected ListFullReviewsRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    public ListFullReviewsRequest(String url2, Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        this(body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        this.url = url2;
    }

    /* renamed from: of */
    public static ListFullReviewsRequest m7473of(long storeId, int limit, int offset, StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        Body body = new Body(storeId, limit, offset, ManagerPreferences.getAndResetForceServerRefresh(sharedPreferences), storeCredentials);
        ListFullReviewsRequest listFullReviewsRequest = new ListFullReviewsRequest(body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return listFullReviewsRequest;
    }

    public static ListFullReviewsRequest ofAction(String url2, boolean refresh, StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        String str = url2;
        boolean z = refresh;
        StoreCredentials storeCredentials2 = storeCredentials;
        ListFullReviewsRequest listFullReviewsRequest = new ListFullReviewsRequest(url2.replace("listFullReviews", ""), new Body(refresh, storeCredentials), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return listFullReviewsRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<ListFullReviews> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        if (TextUtils.isEmpty(this.url)) {
            return interfaces.listFullReviews((Body) this.body, bypassCache);
        }
        return interfaces.listFullReviews(this.url, (Body) this.body, bypassCache);
    }
}
