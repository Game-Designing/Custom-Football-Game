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

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetTransactionRequest */
public class GetTransactionRequest extends C0044V7<Response<ResponseBody>, BaseBody> {
    private final String accessToken;
    private final String customerId;
    private final long productId;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetTransactionRequest$RequestBody */
    public static class RequestBody extends BaseBody {
        private long productId;

        public long getProductId() {
            return this.productId;
        }

        public void setProductId(long productId2) {
            this.productId = productId2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetTransactionRequest$ResponseBody */
    public static class ResponseBody extends BaseV7Response {
        private Transaction data;

        /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetTransactionRequest$ResponseBody$Transaction */
        public static class Transaction {

            /* renamed from: id */
            private long f6137id;
            private Product product;
            private Service service;
            private String status;
            private User user;

            /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetTransactionRequest$ResponseBody$Transaction$Product */
            public static class Product {

                /* renamed from: id */
                private long f6138id;

                public long getId() {
                    return this.f6138id;
                }

                public void setId(long id) {
                    this.f6138id = id;
                }
            }

            /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetTransactionRequest$ResponseBody$Transaction$Service */
            public static class Service {

                /* renamed from: id */
                private long f6139id;

                public long getId() {
                    return this.f6139id;
                }

                public void setId(long id) {
                    this.f6139id = id;
                }
            }

            /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetTransactionRequest$ResponseBody$Transaction$User */
            public static class User {

                /* renamed from: id */
                private long f6140id;

                public long getId() {
                    return this.f6140id;
                }

                public void setId(long id) {
                    this.f6140id = id;
                }
            }

            public long getId() {
                return this.f6137id;
            }

            public void setId(long id) {
                this.f6137id = id;
            }

            public String getStatus() {
                return this.status;
            }

            public void setStatus(String status2) {
                this.status = status2;
            }

            public Service getService() {
                return this.service;
            }

            public void setService(Service service2) {
                this.service = service2;
            }

            public Product getProduct() {
                return this.product;
            }

            public void setProduct(Product product2) {
                this.product = product2;
            }

            public User getUser() {
                return this.user;
            }

            public void setUser(User user2) {
                this.user = user2;
            }
        }

        public Transaction getData() {
            return this.data;
        }

        public void setData(Transaction data2) {
            this.data = data2;
        }
    }

    private GetTransactionRequest(String baseHost, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator, long productId2, String accessToken2, String customerId2) {
        super(new BaseBody(), baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        this.productId = productId2;
        this.accessToken = accessToken2;
        this.customerId = customerId2;
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
    public static GetTransactionRequest m7545of(BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, long productId2, String accessToken2, String customerId2) {
        GetTransactionRequest getTransactionRequest = new GetTransactionRequest(getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator, productId2, accessToken2, customerId2);
        return getTransactionRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<Response<ResponseBody>> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        long j = this.productId;
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        sb.append(this.accessToken);
        return interfaces.getBillingTransaction(j, sb.toString(), this.customerId);
    }
}
