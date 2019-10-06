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
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetTransactionRequest.ResponseBody.Transaction;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.CreateTransactionRequest */
public class CreateTransactionRequest extends C0044V7<ResponseBody, RequestBody> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.CreateTransactionRequest$RequestBody */
    public static class RequestBody extends BaseBody {
        private String payload;
        private long productId;
        private Data serviceData;
        private long serviceId;

        /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.CreateTransactionRequest$RequestBody$Data */
        public static class Data {
            private String token;

            public String getToken() {
                return this.token;
            }

            public void setToken(String token2) {
                this.token = token2;
            }
        }

        public Data getServiceData() {
            return this.serviceData;
        }

        public void setServiceData(Data serviceData2) {
            this.serviceData = serviceData2;
        }

        public long getProductId() {
            return this.productId;
        }

        public void setProductId(long productId2) {
            this.productId = productId2;
        }

        public long getServiceId() {
            return this.serviceId;
        }

        public void setServiceId(long serviceId2) {
            this.serviceId = serviceId2;
        }

        public String getPayload() {
            return this.payload;
        }

        public void setPayload(String payload2) {
            this.payload = payload2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.CreateTransactionRequest$ResponseBody */
    public static class ResponseBody extends BaseV7Response {
        private Transaction data;

        public Transaction getData() {
            return this.data;
        }

        public void setData(Transaction data2) {
            this.data = data2;
        }
    }

    private CreateTransactionRequest(RequestBody body, String baseHost, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
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
    public static CreateTransactionRequest m7535of(long productId, long serviceId, String payload, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        RequestBody body = new RequestBody();
        long j = productId;
        body.setProductId(productId);
        body.setServiceId(serviceId);
        body.setPayload(payload);
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest(body, getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        return createTransactionRequest;
    }

    /* renamed from: of */
    public static CreateTransactionRequest m7536of(long productId, long serviceId, String payload, String token, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        RequestBody body = new RequestBody();
        body.setProductId(productId);
        body.setServiceId(serviceId);
        body.setPayload(payload);
        Data serviceData = new Data();
        serviceData.setToken(token);
        body.setServiceData(serviceData);
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest(body, getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        return createTransactionRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<ResponseBody> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.createBillingTransaction((RequestBody) this.body, bypassCache);
    }
}
