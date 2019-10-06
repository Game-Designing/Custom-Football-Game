package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetHomeMeta;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBodyWithStore;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.V7Url;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetHomeMetaRequest */
public class GetHomeMetaRequest extends BaseRequestWithStore<GetHomeMeta, Body> {
    private final String url;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetHomeMetaRequest$Body */
    public static class Body extends BaseBodyWithStore {
        public Body(StoreCredentials storeCredentials) {
            super(storeCredentials);
        }
    }

    private GetHomeMetaRequest(Body body, String url2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        this.url = url2;
    }

    public static GetHomeMetaRequest ofAction(String url2, StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetHomeMetaRequest getHomeMetaRequest = new GetHomeMetaRequest(new Body(storeCredentials), new V7Url(url2).remove("home/getMeta").get(), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getHomeMetaRequest;
    }

    /* renamed from: of */
    public static GetHomeMetaRequest m7578of(StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptorV7, OkHttpClient client, Factory converter, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetHomeMetaRequest getHomeMetaRequest = new GetHomeMetaRequest(new Body(storeCredentials), null, bodyInterceptorV7, client, converter, tokenInvalidator, sharedPreferences);
        return getHomeMetaRequest;
    }

    public String getUrl() {
        return this.url;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetHomeMeta> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        String str = this.url;
        if (str == null) {
            str = "";
        }
        return interfaces.getHomeMeta(str, (Body) this.body, bypassCache);
    }
}
