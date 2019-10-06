package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.WindowManager;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetHome;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetHomeRequest */
public class GetHomeRequest extends C0044V7<GetHome, GetHomeBody> {
    protected GetHomeRequest(GetHomeBody body, String baseHost, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator) {
        super(body, baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static GetHomeRequest m7579of(StoreCredentials storeCredentials, Long userId, StoreContext storeContext, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager) {
        StoreCredentials storeCredentials2 = storeCredentials;
        Long l = userId;
        GetHomeBody body = new GetHomeBody(storeCredentials, WidgetsArgs.createDefault(resources, windowManager), userId);
        StoreContext storeContext2 = storeContext;
        body.setContext(storeContext);
        GetHomeRequest getHomeRequest = new GetHomeRequest(body, C0044V7.getHost(sharedPreferences), bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
        return getHomeRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetHome> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getHome((GetHomeBody) this.body, bypassCache);
    }
}
