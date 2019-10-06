package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetFollowers;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetFollowersRequest */
public class GetFollowersRequest extends C0044V7<GetFollowers, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetFollowersRequest$Body */
    public static class Body extends BaseBody implements Endless {
        private int limit = 25;
        private int offset;
        private Long storeId;
        private Long userId;

        public Long getUserId() {
            return this.userId;
        }

        public void setUserId(Long userId2) {
            this.userId = userId2;
        }

        public Long getStoreId() {
            return this.storeId;
        }

        public void setStoreId(Long storeId2) {
            this.storeId = storeId2;
        }

        public int getOffset() {
            return this.offset;
        }

        public void setOffset(int offset2) {
            this.offset = offset2;
        }

        public Integer getLimit() {
            return Integer.valueOf(this.limit);
        }
    }

    protected GetFollowersRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static GetFollowersRequest m7464of(BodyInterceptor<BaseBody> bodyInterceptor, Long userId, Long storeId, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        Body body = new Body();
        body.setUserId(userId);
        body.setStoreId(storeId);
        GetFollowersRequest getFollowersRequest = new GetFollowersRequest(body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getFollowersRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetFollowers> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getTimelineFollowers((Body) this.body, bypassCache);
    }
}
