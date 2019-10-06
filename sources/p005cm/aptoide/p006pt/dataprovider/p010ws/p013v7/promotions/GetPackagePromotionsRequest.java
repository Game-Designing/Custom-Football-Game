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

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPackagePromotionsRequest */
public class GetPackagePromotionsRequest extends C0044V7<GetPackagePromotionsResponse, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPackagePromotionsRequest$Body */
    public static class Body extends BaseBody {
        private String packageName;

        public Body(String packageName2) {
            this.packageName = packageName2;
        }

        public String getPackageName() {
            return this.packageName;
        }
    }

    public GetPackagePromotionsRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static GetPackagePromotionsRequest m7574of(String packageName, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetPackagePromotionsRequest getPackagePromotionsRequest = new GetPackagePromotionsRequest(new Body(packageName), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getPackagePromotionsRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetPackagePromotionsResponse> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getPromotionsForPackage((Body) this.body, bypassCache);
    }
}
