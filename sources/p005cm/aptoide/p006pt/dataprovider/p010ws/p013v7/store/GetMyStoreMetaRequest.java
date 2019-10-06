package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetMyStoreMetaRequest */
public class GetMyStoreMetaRequest extends C0044V7<GetStoreMeta, BaseBody> {
    public GetMyStoreMetaRequest(BaseBody body, String baseHost, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator) {
        super(body, baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static GetMyStoreMetaRequest m7582of(BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetMyStoreMetaRequest getMyStoreMetaRequest = new GetMyStoreMetaRequest(new BaseBody(), C0044V7.getHost(sharedPreferences), bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
        return getMyStoreMetaRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetStoreMeta> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getMyStoreMeta((BaseBody) this.body, bypassCache);
    }
}
