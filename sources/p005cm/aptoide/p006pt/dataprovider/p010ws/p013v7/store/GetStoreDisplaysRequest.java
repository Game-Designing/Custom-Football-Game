package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreDisplays;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBodyWithStore;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.V7Url;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreDisplaysRequest */
public class GetStoreDisplaysRequest extends BaseRequestWithStore<GetStoreDisplays, Body> {
    private String url;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreDisplaysRequest$Body */
    public static class Body extends BaseBodyWithStore {
        public Body(StoreCredentials storeCredentials) {
            super(storeCredentials);
        }
    }

    GetStoreDisplaysRequest(String url2, Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        this.url = url2;
    }

    public static GetStoreDisplaysRequest ofAction(String url2, StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetStoreDisplaysRequest getStoreDisplaysRequest = new GetStoreDisplaysRequest(new V7Url(url2).remove("getStoreDisplays").get(), new Body(storeCredentials), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getStoreDisplaysRequest;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url2) {
        this.url = url2;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetStoreDisplays> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getStoreDisplays(this.url, (Body) this.body, bypassCache);
    }
}
