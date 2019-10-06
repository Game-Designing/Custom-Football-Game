package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListReviews;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.ListReviewsRequest */
public class ListReviewsRequest extends C0044V7<ListReviews, Body> {
    private static final int MAX_COMMENTS = 10;
    private static final int MAX_REVIEWS = 10;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.ListReviewsRequest$Body */
    public static class Body extends BaseBodyWithStore implements Endless {
        private String lang;
        private String languagesFilterSort;
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

        /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.ListReviewsRequest$Body$Sort */
        public enum Sort {
            latest,
            points
        }

        public Body(long storeId2, int limit2, int subLimit2, boolean refresh2, StoreCredentials storeCredentials) {
            super(storeCredentials);
            this.storeId = Long.valueOf(storeId2);
            this.limit = Integer.valueOf(limit2);
            this.subLimit = Integer.valueOf(subLimit2);
            this.refresh = refresh2;
        }

        public Body(String storeName2, String packageName2, int limit2, int subLimit2, boolean refresh2, StoreCredentials storeCredentials, String languagesFilterSort2) {
            super(storeCredentials);
            this.packageName = packageName2;
            this.storeName = storeName2;
            this.limit = Integer.valueOf(limit2);
            this.subLimit = Integer.valueOf(subLimit2);
            this.refresh = refresh2;
            this.languagesFilterSort = languagesFilterSort2;
        }

        public Order getOrder() {
            return this.order;
        }

        public void setOrder(Order order2) {
            this.order = order2;
        }

        public Sort getSort() {
            return this.sort;
        }

        public void setSort(Sort sort2) {
            this.sort = sort2;
        }

        public Long getStoreId() {
            return this.storeId;
        }

        public void setStoreId(Long storeId2) {
            this.storeId = storeId2;
        }

        public String getStoreName() {
            return this.storeName;
        }

        public void setStoreName(String storeName2) {
            this.storeName = storeName2;
        }

        public Long getReviewId() {
            return this.reviewId;
        }

        public void setReviewId(Long reviewId2) {
            this.reviewId = reviewId2;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String packageName2) {
            this.packageName = packageName2;
        }

        public Integer getSubLimit() {
            return this.subLimit;
        }

        public void setSubLimit(Integer subLimit2) {
            this.subLimit = subLimit2;
        }

        public void setRefresh(boolean refresh2) {
            this.refresh = refresh2;
        }

        public String getLang() {
            return this.lang;
        }

        public void setLang(String lang2) {
            this.lang = lang2;
        }

        public boolean isMature() {
            return this.mature;
        }

        public void setMature(boolean mature2) {
            this.mature = mature2;
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

        public void setLimit(Integer limit2) {
            this.limit = limit2;
        }

        public String getLanguagesFilterSort() {
            return this.languagesFilterSort;
        }

        public void setLanguagesFilterSort(String languagesFilterSort2) {
            this.languagesFilterSort = languagesFilterSort2;
        }
    }

    private ListReviewsRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static ListReviewsRequest m7476of(String storeName, String packageName, StoreCredentials storecredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, String languagesFilterSort) {
        return m7475of(storeName, packageName, 10, 10, storecredentials, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences, languagesFilterSort);
    }

    /* renamed from: of */
    public static ListReviewsRequest m7474of(String storeName, String packageName, int maxReviews, int maxComments, StoreCredentials storecredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        return m7475of(storeName, packageName, maxReviews, maxComments, storecredentials, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences, null);
    }

    /* renamed from: of */
    public static ListReviewsRequest m7475of(String storeName, String packageName, int maxReviews, int maxComments, StoreCredentials storecredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, String languagesFilterSort) {
        Body body = new Body(storeName, packageName, maxReviews, maxComments, ManagerPreferences.getAndResetForceServerRefresh(sharedPreferences), storecredentials, languagesFilterSort);
        ListReviewsRequest listReviewsRequest = new ListReviewsRequest(body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return listReviewsRequest;
    }

    public static ListReviewsRequest ofTopReviews(String storeName, String packageName, int maxReviews, StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, String languagesFilterSort) {
        return m7475of(storeName, packageName, maxReviews, 0, storeCredentials, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences, languagesFilterSort);
    }

    /* access modifiers changed from: protected */
    public C0120S<ListReviews> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.listReviews((Body) this.body, true);
    }
}
