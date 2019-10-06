package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing;

import android.content.SharedPreferences;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mopub.common.Constants;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetAuthorizationRequest.ResponseBody.Authorization;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.UpdateAuthorizationRequest */
public class UpdateAuthorizationRequest extends C0044V7<ResponseBody, RequestBody> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.UpdateAuthorizationRequest$RequestBody */
    public static class RequestBody extends BaseBody {
        private Data serviceData;
        private long transactionId;

        /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.UpdateAuthorizationRequest$RequestBody$Data */
        public static class Data {
            @JsonProperty("paykey")
            private String payKey;

            public String getPayKey() {
                return this.payKey;
            }

            public void setPayKey(String payKey2) {
                this.payKey = payKey2;
            }
        }

        public Data getServiceData() {
            return this.serviceData;
        }

        public void setServiceData(Data serviceData2) {
            this.serviceData = serviceData2;
        }

        public long getTransactionId() {
            return this.transactionId;
        }

        public void setTransactionId(long transactionId2) {
            this.transactionId = transactionId2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.UpdateAuthorizationRequest$ResponseBody */
    public static class ResponseBody extends BaseV7Response {
        private Authorization data;

        public Authorization getData() {
            return this.data;
        }

        public void setData(Authorization data2) {
            this.data = data2;
        }
    }

    private UpdateAuthorizationRequest(RequestBody body, String baseHost, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
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
    public static UpdateAuthorizationRequest m7546of(long transactionId, String metadata, SharedPreferences sharedPreferences, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor<BaseBody> bodyInterceptorV7, TokenInvalidator tokenInvalidator) {
        RequestBody requestBody = new RequestBody();
        long j = transactionId;
        requestBody.setTransactionId(transactionId);
        Data data = new Data();
        String str = metadata;
        data.setPayKey(metadata);
        requestBody.setServiceData(data);
        UpdateAuthorizationRequest updateAuthorizationRequest = new UpdateAuthorizationRequest(requestBody, getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptorV7, tokenInvalidator);
        return updateAuthorizationRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<ResponseBody> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.updateBillingAuthorization((RequestBody) this.body, bypassCache);
    }
}
