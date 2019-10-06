package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionAppsRequest */
public class GetPromotionAppsRequest extends C0044V7<GetPromotionAppsResponse, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionAppsRequest$Body */
    public static class Body extends BaseBody {
        private String promotionId;

        public Body(String promotionId2) {
            this.promotionId = promotionId2;
        }

        public String getPromotionId() {
            return this.promotionId;
        }
    }

    public GetPromotionAppsRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static GetPromotionAppsRequest m7575of(String promotionId, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetPromotionAppsRequest getPromotionAppsRequest = new GetPromotionAppsRequest(new Body(promotionId), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getPromotionAppsRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetPromotionAppsResponse> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getPromotionApps(30, (Body) this.body, bypassCache);
    }
}
