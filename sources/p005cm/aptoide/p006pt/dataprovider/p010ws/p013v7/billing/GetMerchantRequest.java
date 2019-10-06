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

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetMerchantRequest */
public class GetMerchantRequest extends C0044V7<ResponseBody, RequestBody> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetMerchantRequest$RequestBody */
    public static class RequestBody extends BaseBody {
        private String packageName;

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String packageName2) {
            this.packageName = packageName2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetMerchantRequest$ResponseBody */
    public static class ResponseBody extends BaseV7Response {
        private Merchant data;

        /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetMerchantRequest$ResponseBody$Merchant */
        public static class Merchant {

            /* renamed from: id */
            private long f6134id;
            private String name;

            public long getId() {
                return this.f6134id;
            }

            public void setId(long id) {
                this.f6134id = id;
            }

            public String getName() {
                return this.name;
            }

            public void setName(String name2) {
                this.name = name2;
            }
        }

        public Merchant getData() {
            return this.data;
        }

        public void setData(Merchant data2) {
            this.data = data2;
        }
    }

    private GetMerchantRequest(RequestBody baseBody, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(baseBody, getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
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
    public static GetMerchantRequest m7539of(String merchantName, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        RequestBody body = new RequestBody();
        body.setPackageName(merchantName);
        GetMerchantRequest getMerchantRequest = new GetMerchantRequest(body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getMerchantRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<ResponseBody> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getBillingMerchant((RequestBody) this.body, bypassCache);
    }
}
