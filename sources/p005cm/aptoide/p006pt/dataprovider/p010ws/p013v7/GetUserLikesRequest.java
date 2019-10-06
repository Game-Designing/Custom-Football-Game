package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetFollowers;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetUserLikesRequest */
public class GetUserLikesRequest extends C0044V7<GetFollowers, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetUserLikesRequest$Body */
    public static class Body extends BaseBody implements Endless {
        private String cardUid;
        private int limit = 25;
        private int offset;

        public Body(String cardUid2) {
            this.cardUid = cardUid2;
        }

        public String getCardUid() {
            return this.cardUid;
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

    protected GetUserLikesRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static GetUserLikesRequest m7468of(String cardUid, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetUserLikesRequest getUserLikesRequest = new GetUserLikesRequest(new Body(cardUid), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getUserLikesRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetFollowers> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getCardUserLikes((Body) this.body, bypassCache);
    }
}
