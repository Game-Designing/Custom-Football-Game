package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetAppMetaRequest */
public class GetAppMetaRequest extends C0044V7<GetAppMeta, BaseBody> {
    private final String url;

    public GetAppMetaRequest(String baseHost, BaseBody body, String url2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator) {
        super(body, baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        this.url = url2;
    }

    public static GetAppMetaRequest ofAction(String url2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetAppMetaRequest getAppMetaRequest = new GetAppMetaRequest(C0044V7.getHost(sharedPreferences), new BaseBody(), url2.replace("getAppMeta", ""), bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
        return getAppMetaRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetAppMeta> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getAppMeta(bypassCache, this.url);
    }
}
