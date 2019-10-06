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

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetProductsRequest */
public class GetProductsRequest extends C0044V7<ResponseBody, RequestBody> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetProductsRequest$RequestBody */
    public static class RequestBody extends BaseBody {
        private String packageName;
        private String sku;
        private String skus;

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String packageName2) {
            this.packageName = packageName2;
        }

        public String getSkus() {
            return this.skus;
        }

        public void setSkus(String skus2) {
            this.skus = skus2;
        }

        public String getSku() {
            return this.sku;
        }

        public void setSku(String sku2) {
            this.sku = sku2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetProductsRequest$ResponseBody */
    public static class ResponseBody extends BaseV7Response {
        private Product data;
        private List<Product> list;

        /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetProductsRequest$ResponseBody$Product */
        public static class Product {
            private String description;
            private String icon;

            /* renamed from: id */
            private long f6135id;
            private Price price;
            private String sku;
            private String title;

            /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.GetProductsRequest$ResponseBody$Product$Price */
            public static class Price {
                private double amount;
                private String currency;
                private String sign;

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

                public String getSign() {
                    return this.sign;
                }

                public void setSign(String sign2) {
                    this.sign = sign2;
                }
            }

            public long getId() {
                return this.f6135id;
            }

            public void setId(long id) {
                this.f6135id = id;
            }

            public String getSku() {
                return this.sku;
            }

            public void setSku(String sku2) {
                this.sku = sku2;
            }

            public String getTitle() {
                return this.title;
            }

            public void setTitle(String title2) {
                this.title = title2;
            }

            public String getDescription() {
                return this.description;
            }

            public void setDescription(String description2) {
                this.description = description2;
            }

            public String getIcon() {
                return this.icon;
            }

            public void setIcon(String icon2) {
                this.icon = icon2;
            }

            public Price getPrice() {
                return this.price;
            }

            public void setPrice(Price price2) {
                this.price = price2;
            }
        }

        public List<Product> getList() {
            return this.list;
        }

        public void setList(List<Product> list2) {
            this.list = list2;
        }

        public Product getData() {
            return this.data;
        }

        public void setData(Product data2) {
            this.data = data2;
        }
    }

    private GetProductsRequest(RequestBody requestBody, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(requestBody, getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
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
    public static GetProductsRequest m7541of(String packageName, List<String> skuList, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        RequestBody requestBody = new RequestBody();
        requestBody.setPackageName(packageName);
        if (!skuList.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String sku : skuList) {
                stringBuilder.append(sku);
                stringBuilder.append(",");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            requestBody.setSkus(stringBuilder.toString());
        }
        GetProductsRequest getProductsRequest = new GetProductsRequest(requestBody, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getProductsRequest;
    }

    /* renamed from: of */
    public static GetProductsRequest m7540of(String packageName, String sku, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        RequestBody requestBody = new RequestBody();
        requestBody.setPackageName(packageName);
        requestBody.setSku(sku);
        GetProductsRequest getProductsRequest = new GetProductsRequest(requestBody, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getProductsRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<ResponseBody> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        if (((RequestBody) this.body).getSkus() != null) {
            return interfaces.getBillingProducts((RequestBody) this.body, bypassCache);
        }
        return interfaces.getBillingProduct((RequestBody) this.body, bypassCache);
    }
}
