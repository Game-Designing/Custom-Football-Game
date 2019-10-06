package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetHomeMetaRequest.Body;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreMetaRequest */
public class GetStoreMetaRequest extends BaseRequestWithStore<GetStoreMeta, Body> {
    private final String url;

    public GetStoreMetaRequest(String url2, Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        this.url = url2;
    }

    /* renamed from: of */
    public static GetStoreMetaRequest m264of(StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetStoreMetaRequest getStoreMetaRequest = new GetStoreMetaRequest("", new Body(storeCredentials), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getStoreMetaRequest;
    }

    public static GetStoreMetaRequest ofAction(String url2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetStoreMetaRequest getStoreMetaRequest = new GetStoreMetaRequest(url2, new Body(new StoreCredentials()), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getStoreMetaRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetStoreMeta> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        if (!this.url.isEmpty()) {
            return interfaces.getStoreMeta(this.url, (Body) this.body, bypassCache);
        }
        return interfaces.getStoreMeta((Body) this.body, bypassCache);
    }
}
