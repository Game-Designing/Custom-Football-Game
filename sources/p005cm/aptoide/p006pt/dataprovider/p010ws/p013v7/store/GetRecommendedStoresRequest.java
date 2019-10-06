package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import android.content.SharedPreferences;
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

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetRecommendedStoresRequest */
public class GetRecommendedStoresRequest extends C0044V7<ListStores, EndlessBody> {
    private final String url;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetRecommendedStoresRequest$EndlessBody */
    public static class EndlessBody extends BaseBody implements Endless {
        private int limit = 25;
        private int offset;

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

    public GetRecommendedStoresRequest(String url2, EndlessBody body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        this.url = url2;
    }

    public static GetRecommendedStoresRequest ofAction(String url2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetRecommendedStoresRequest getRecommendedStoresRequest = new GetRecommendedStoresRequest(url2, new EndlessBody(), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getRecommendedStoresRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<ListStores> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getRecommendedStore(this.url, (EndlessBody) this.body, bypassCache);
    }
}
