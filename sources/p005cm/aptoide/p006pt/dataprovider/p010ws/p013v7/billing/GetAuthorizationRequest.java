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

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetAuthorizationRequest */
public class GetAuthorizationRequest extends C0044V7<Response<ResponseBody>, BaseBody> {
    private final String accessToken;
    private final String customerId;
    private final long transactionId;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetAuthorizationRequest$ResponseBody */
    public static class ResponseBody extends BaseV7Response {
        private Authorization data;

        /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetAuthorizationRequest$ResponseBody$Authorization */
        public static class Authorization {
            private Metadata data;

            /* renamed from: id */
            private long f6132id;
            private Price price;
            private long serviceId;
            private String status;
            private String type;
            private User user;

            /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetAuthorizationRequest$ResponseBody$Authorization$Metadata */
            public static class Metadata {
                private String description;
                private String redirectUrl;
                private String session;
                private String url;

                public String getUrl() {
                    return this.url;
                }

                public void setUrl(String url2) {
                    this.url = url2;
                }

                public String getRedirectUrl() {
                    return this.redirectUrl;
                }

                public void setRedirectUrl(String redirectUrl2) {
                    this.redirectUrl = redirectUrl2;
                }

                public String getDescription() {
                    return this.description;
                }

                public void setDescription(String description2) {
                    this.description = description2;
                }

                public String getSession() {
                    return this.session;
                }

                public void setSession(String session2) {
                    this.session = session2;
                }
            }

            /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetAuthorizationRequest$ResponseBody$Authorization$Price */
            public static class Price {
                private double amount;
                private String currency;
                private String currencySymbol;

                public double getAmount() {
                    return this.amount;
                }

                public void setAmount(double amount2) {
                    this.amount = amount2;
                }

                public String getCurrency() {
                    return this.currency;
                }

                public void setCurrency(String currency2) {
                    this.currency = currency2;
                }

                public String getCurrencySymbol() {
                    return this.currencySymbol;
                }

                public void setCurrencySymbol(String currencySymbol2) {
                    this.currencySymbol = currencySymbol2;
                }
            }

            /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetAuthorizationRequest$ResponseBody$Authorization$User */
            public static class User {

                /* renamed from: id */
                private long f6133id;

                public long getId() {
                    return this.f6133id;
                }

                public void setId(long id) {
                    this.f6133id = id;
                }
            }

            public long getId() {
                return this.f6132id;
            }

            public void setId(long id) {
                this.f6132id = id;
            }

            public String getType() {
                return this.type;
            }

            public void setType(String type2) {
                this.type = type2;
            }

            public long getServiceId() {
                return this.serviceId;
            }

            public void setServiceId(long serviceId2) {
                this.serviceId = serviceId2;
            }

            public Price getPrice() {
                return this.price;
            }

            public void setPrice(Price price2) {
                this.price = price2;
            }

            public User getUser() {
                return this.user;
            }

            public void setUser(User user2) {
                this.user = user2;
            }

            public String getStatus() {
                return this.status;
            }

            public void setStatus(String status2) {
                this.status = status2;
            }

            public Metadata getData() {
                return this.data;
            }

            public void setData(Metadata data2) {
                this.data = data2;
            }
        }

        public Authorization getData() {
            return this.data;
        }

        public void setData(Authorization data2) {
            this.data = data2;
        }
    }

    private GetAuthorizationRequest(String baseHost, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator, long transactionId2, String accessToken2, String customerId2) {
        super(new BaseBody(), baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        this.transactionId = transactionId2;
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
    public static GetAuthorizationRequest m7538of(long transactionId2, SharedPreferences sharedPreferences, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, String accessToken2, String customerId2) {
        GetAuthorizationRequest getAuthorizationRequest = new GetAuthorizationRequest(getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator, transactionId2, accessToken2, customerId2);
        return getAuthorizationRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<Response<ResponseBody>> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        long j = this.transactionId;
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        sb.append(this.accessToken);
        return interfaces.getBillingAuthorization(j, sb.toString(), this.customerId);
    }
}
