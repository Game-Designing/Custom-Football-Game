package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetFollowers;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.GetFollowersRequest.Body;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetFollowingRequest */
public class GetFollowingRequest extends C0044V7<GetFollowers, Body> {
    protected GetFollowingRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static GetFollowingRequest m7465of(BodyInterceptor<BaseBody> bodyInterceptor, Long userId, Long storeId, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        Body body = new Body();
        body.setUserId(userId);
        body.setStoreId(storeId);
        GetFollowingRequest getFollowingRequest = new GetFollowingRequest(body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getFollowingRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetFollowers> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getTimelineGetFollowing((Body) this.body, bypassCache);
    }
}
