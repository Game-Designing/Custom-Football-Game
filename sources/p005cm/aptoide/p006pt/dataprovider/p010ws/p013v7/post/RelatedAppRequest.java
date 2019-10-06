package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.post;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.post.RelatedAppRequest */
public class RelatedAppRequest extends C0044V7<RelatedAppResponse, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.post.RelatedAppRequest$Body */
    public static class Body extends BaseBody {
        private String url;

        public Body(String url2) {
            this.url = url2;
        }

        public String getUrl() {
            return this.url;
        }
    }

    public RelatedAppRequest(Body body, String baseHost, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        super(body, baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static RelatedAppRequest m7572of(String url, SharedPreferences sharedPreferences, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        RelatedAppRequest relatedAppRequest = new RelatedAppRequest(new Body(url), C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        return relatedAppRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<RelatedAppResponse> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getRelatedApps(bypassCache, (Body) this.body);
    }
}
