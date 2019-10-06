package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListComments;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.util.CommentType;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.ListCommentsRequest */
public class ListCommentsRequest extends C0044V7<ListComments, Body> {
    private static String url;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.ListCommentsRequest$Body */
    public static class Body extends BaseBody implements Endless {
        private String commentType = CommentType.REVIEW.name();
        private Integer limit;
        private int offset;
        private Order order;
        private boolean refresh;
        private Long reviewId;
        private Long storeId;
        @JsonProperty("store_pass_sha1")
        private String storePassSha1;
        @JsonProperty("store_user")
        private String storeUser;
        private long subLimit = 5;
        @JsonProperty("card_uid")
        private String timelineCardId;

        public Body(boolean refresh2, Order order2) {
            this.refresh = refresh2;
            this.order = order2;
        }

        public Body(int limit2, boolean refresh2, Order order2) {
            this.limit = Integer.valueOf(limit2);
            this.refresh = refresh2;
            this.order = order2;
        }

        public Body(int limit2, boolean refresh2, Order order2, String username, String password) {
            this.limit = Integer.valueOf(limit2);
            this.refresh = refresh2;
            this.order = order2;
            this.storeUser = username;
            this.storePassSha1 = password;
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

        public void setRefresh(boolean refresh2) {
            this.refresh = refresh2;
        }

        public Order getOrder() {
            return this.order;
        }

        public void setOrder(Order order2) {
            this.order = order2;
        }

        public String getCommentType() {
            return this.commentType;
        }

        public void setCommentType(CommentType commentType2) {
            if (commentType2 == null) {
                this.commentType = null;
            } else {
                this.commentType = commentType2.name();
            }
        }

        public Long getReviewId() {
            return this.reviewId;
        }

        public void setReviewId(Long reviewId2) {
            this.reviewId = reviewId2;
            this.commentType = CommentType.REVIEW.name();
        }

        public Long getStoreId() {
            return this.storeId;
        }

        public void setStoreId(Long storeId2) {
            this.storeId = storeId2;
            this.commentType = CommentType.STORE.name();
        }

        public String getStoreUser() {
            return this.storeUser;
        }

        public void setStoreUser(String storeUser2) {
            this.storeUser = storeUser2;
        }

        public String getStorePassSha1() {
            return this.storePassSha1;
        }

        public void setStorePassSha1(String storePassSha12) {
            this.storePassSha1 = storePassSha12;
        }

        public long getSubLimit() {
            return this.subLimit;
        }

        public void setSubLimit(long subLimit2) {
            this.subLimit = subLimit2;
        }

        public String getTimelineCardId() {
            return this.timelineCardId;
        }

        public void setTimelineCardId(String timelineCardId2) {
            this.timelineCardId = timelineCardId2;
        }
    }

    private ListCommentsRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    public static ListCommentsRequest ofStoreAction(String url2, boolean refresh, StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        url = url2;
        boolean z = refresh;
        Body body = new Body(refresh, Order.desc);
        if (storeCredentials != null) {
            body.setStoreUser(storeCredentials.getUsername());
            body.setStorePassSha1(storeCredentials.getPasswordSha1());
            body.setStoreId(storeCredentials.getId());
        }
        ListCommentsRequest listCommentsRequest = new ListCommentsRequest(body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return listCommentsRequest;
    }

    /* renamed from: of */
    public static ListCommentsRequest m7472of(String url2, long resourceId, int limit, StoreCredentials storeCredentials, boolean isReview, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        url = url2;
        int i = limit;
        Body body = new Body(i, ManagerPreferences.getAndResetForceServerRefresh(sharedPreferences), Order.desc, storeCredentials.getUsername(), storeCredentials.getPasswordSha1());
        if (isReview) {
            body.setReviewId(Long.valueOf(resourceId));
        } else {
            body.setStoreId(Long.valueOf(resourceId));
        }
        ListCommentsRequest listCommentsRequest = new ListCommentsRequest(body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return listCommentsRequest;
    }

    /* renamed from: of */
    public static ListCommentsRequest m7470of(long resourceId, int offset, int limit, boolean isReview, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        Body body = getBody(resourceId, limit, isReview, sharedPreferences);
        body.setOffset(offset);
        ListCommentsRequest listCommentsRequest = new ListCommentsRequest(body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return listCommentsRequest;
    }

    /* renamed from: of */
    public static ListCommentsRequest m7471of(long resourceId, int limit, boolean isReview, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        long j = resourceId;
        ListCommentsRequest listCommentsRequest = new ListCommentsRequest(getBody(resourceId, limit, isReview, sharedPreferences), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return listCommentsRequest;
    }

    public static ListCommentsRequest ofTimeline(String url2, int offset, int limit, boolean refresh, String timelineArticleId, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        url = url2;
        int i = limit;
        Body body = new Body(limit, refresh, Order.desc);
        body.setCommentType(null);
        int i2 = offset;
        body.setOffset(offset);
        body.setTimelineCardId(timelineArticleId);
        ListCommentsRequest listCommentsRequest = new ListCommentsRequest(body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return listCommentsRequest;
    }

    private static Body getBody(long resourceId, int limit, boolean isReview, SharedPreferences sharedPreferences) {
        Body body = new Body(limit, ManagerPreferences.getAndResetForceServerRefresh(sharedPreferences), Order.desc);
        if (isReview) {
            body.setReviewId(Long.valueOf(resourceId));
        } else {
            body.setStoreId(Long.valueOf(resourceId));
        }
        return body;
    }

    /* access modifiers changed from: protected */
    public C0120S<ListComments> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        if (TextUtils.isEmpty(url)) {
            return interfaces.listComments((Body) this.body, true);
        }
        return interfaces.listComments(url, (Body) this.body, true);
    }
}
