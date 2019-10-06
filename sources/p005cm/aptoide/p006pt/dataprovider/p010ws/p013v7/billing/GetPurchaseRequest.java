package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing;

import android.content.SharedPreferences;
import com.mopub.common.Constants;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p026rx.C0120S;
import retrofit2.Converter.Factory;
import retrofit2.Response;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetPurchaseRequest */
public class GetPurchaseRequest extends C0044V7<Response<ResponseBody>, RequestBody> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetPurchaseRequest$RequestBody */
    public static class RequestBody extends BaseBody {
        private long productId;

        public long getProductId() {
            return this.productId;
        }

        public void setProductId(long productId2) {
            this.productId = productId2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetPurchaseRequest$ResponseBody */
    public static class ResponseBody extends BaseV7Response {
        private PurchaseResponse data;

        public PurchaseResponse getData() {
            return this.data;
        }

        public void setData(PurchaseResponse data2) {
            this.data = data2;
        }
    }

    public GetPurchaseRequest(RequestBody body, String baseHost, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        super(body, baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? Constants.HTTP : "https");
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_WRITE_V7_HOST);
        sb.append("/api/7/");
        return sb.toString();
    }

    /* renamed from: of */
    public static GetPurchaseRequest m7542of(long productId, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        RequestBody body = new RequestBody();
        body.setProductId(productId);
        GetPurchaseRequest getPurchaseRequest = new GetPurchaseRequest(body, getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        return getPurchaseRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<Response<ResponseBody>> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getBillingPurchase((RequestBody) this.body, bypassCache);
    }
}
