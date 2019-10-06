package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing;

import android.content.SharedPreferences;
import com.mopub.common.Constants;
import java.util.List;
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

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetPurchasesRequest */
public class GetPurchasesRequest extends C0044V7<Response<ResponseBody>, RequestBody> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetPurchasesRequest$RequestBody */
    public static class RequestBody extends BaseBody {
        private String packageName;

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String packageName2) {
            this.packageName = packageName2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetPurchasesRequest$ResponseBody */
    public static class ResponseBody extends BaseV7Response {
        private List<PurchaseResponse> list;

        public List<PurchaseResponse> getList() {
            return this.list;
        }

        public void setList(List<PurchaseResponse> list2) {
            this.list = list2;
        }
    }

    public GetPurchasesRequest(RequestBody body, String baseHost, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        super(body, baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? Constants.HTTP : "https");
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_READ_V7_HOST);
        sb.append("/api/7/");
        return sb.toString();
    }

    /* renamed from: of */
    public static GetPurchasesRequest m7543of(String merchantName, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        RequestBody body = new RequestBody();
        body.setPackageName(merchantName);
        GetPurchasesRequest getPurchasesRequest = new GetPurchasesRequest(body, getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        return getPurchasesRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<Response<ResponseBody>> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getBillingPurchases((RequestBody) this.body, bypassCache);
    }
}
