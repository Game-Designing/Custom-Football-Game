package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions;

import android.content.SharedPreferences;
import com.mopub.common.Constants;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionsRequest */
public class GetPromotionsRequest extends C0044V7<GetPromotionsResponse, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionsRequest$Body */
    public static class Body extends BaseBody {
        private String type;

        public Body(String type2) {
            this.type = type2;
        }

        public String getType() {
            return this.type;
        }
    }

    public GetPromotionsRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? Constants.HTTP : "https");
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_V7_HOST);
        sb.append("/api/7.20190625/");
        return sb.toString();
    }

    /* renamed from: of */
    public static GetPromotionsRequest m7576of(String type, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetPromotionsRequest getPromotionsRequest = new GetPromotionsRequest(new Body(type), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getPromotionsRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetPromotionsResponse> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getPromotions((Body) this.body, bypassCache);
    }
}
