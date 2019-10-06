package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.WindowManager;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.ListStores;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.Endless;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetMyStoreListRequest */
public class GetMyStoreListRequest extends C0044V7<ListStores, EndlessBody> {
    private static boolean useEndless;
    private String url;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetMyStoreListRequest$Body */
    public static class Body extends BaseBody {
        private boolean refresh;
        private WidgetsArgs widgetsArgs;

        public Body(WidgetsArgs widgetsArgs2) {
            this.widgetsArgs = widgetsArgs2;
        }

        public void setRefresh(boolean refresh2) {
            this.refresh = refresh2;
        }

        public WidgetsArgs getWidgetsArgs() {
            return this.widgetsArgs;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetMyStoreListRequest$EndlessBody */
    public static class EndlessBody extends Body implements Endless {
        private Integer limit = Integer.valueOf(25);
        private int offset;

        public EndlessBody(WidgetsArgs widgetsArgs) {
            super(widgetsArgs);
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
    }

    public GetMyStoreListRequest(String url2, EndlessBody body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        this.url = url2;
    }

    /* renamed from: of */
    public static GetMyStoreListRequest m7580of(String url2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager) {
        return m7581of(url2, false, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences, resources, windowManager);
    }

    /* renamed from: of */
    public static GetMyStoreListRequest m7581of(String url2, boolean useEndless2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager) {
        useEndless = useEndless2;
        GetMyStoreListRequest getMyStoreListRequest = new GetMyStoreListRequest(url2, new EndlessBody(WidgetsArgs.createDefault(resources, windowManager)), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getMyStoreListRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<ListStores> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        if (this.url.contains("getSubscribed")) {
            ((EndlessBody) this.body).setRefresh(bypassCache);
        }
        if (TextUtils.isEmpty(this.url)) {
            return interfaces.getMyStoreList((Body) this.body, bypassCache);
        }
        if (useEndless) {
            return interfaces.getMyStoreListEndless(this.url, (EndlessBody) this.body, bypassCache);
        }
        return interfaces.getMyStoreList(this.url, (Body) this.body, bypassCache);
    }
}
