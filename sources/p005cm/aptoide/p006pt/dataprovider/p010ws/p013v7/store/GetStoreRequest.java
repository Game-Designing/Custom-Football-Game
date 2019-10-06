package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.WindowManager;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStore;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.V7Url;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreRequest */
public class GetStoreRequest extends BaseRequestWithStore<GetStore, GetStoreBody> {
    private final String url;

    private GetStoreRequest(String url2, GetStoreBody body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        this.url = url2;
    }

    /* renamed from: of */
    public static GetStoreRequest m7583of(StoreCredentials storeCredentials, StoreContext storeContext, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager) {
        StoreCredentials storeCredentials2 = storeCredentials;
        GetStoreBody body = new GetStoreBody(storeCredentials, WidgetsArgs.createDefault(resources, windowManager));
        StoreContext storeContext2 = storeContext;
        body.setContext(storeContext);
        GetStoreRequest getStoreRequest = new GetStoreRequest("", body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getStoreRequest;
    }

    public static GetStoreRequest ofAction(String url2, StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager) {
        StoreCredentials storeCredentials2 = storeCredentials;
        String str = url2;
        GetStoreRequest getStoreRequest = new GetStoreRequest(new V7Url(url2).remove("getStore").get(), new GetStoreBody(storeCredentials, WidgetsArgs.createDefault(resources, windowManager)), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getStoreRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetStore> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getStore(this.url, (GetStoreBody) this.body, bypassCache);
    }
}
