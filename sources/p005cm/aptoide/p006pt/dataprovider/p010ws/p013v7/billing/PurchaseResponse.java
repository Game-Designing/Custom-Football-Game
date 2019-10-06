package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.PurchaseResponse */
public class PurchaseResponse {
    private Data data;

    /* renamed from: id */
    private long f6141id;
    private Product product;
    private String signature;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.PurchaseResponse$Data */
    public static class Data {
        private DeveloperPurchase developerPurchase;

        @JsonInclude(Include.NON_NULL)
        @JsonPropertyOrder({"orderId", "packageName", "productId", "purchaseTime", "purchaseToken", "purchaseState", "developerPayload"})
        /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.PurchaseResponse$Data$DeveloperPurchase */
        public static class DeveloperPurchase {
            @JsonProperty("developerPayload")
            private String developerPayload;
            @JsonProperty("orderId")
            private String orderId;
            @JsonProperty("packageName")
            private String packageName;
            @JsonProperty("productId")
            private String productId;
            @JsonProperty("purchaseState")
            private int purchaseState;
            @JsonProperty("purchaseTime")
            private long purchaseTime;
            @JsonProperty("purchaseToken")
            private String purchaseToken;

            public String getOrderId() {
                return this.orderId;
            }

            public void setOrderId(String orderId2) {
                this.orderId = orderId2;
            }

            public String getPackageName() {
                return this.packageName;
            }

            public void setPackageName(String packageName2) {
                this.packageName = packageName2;
            }

            public String getProductId() {
                return this.productId;
            }

            public void setProductId(String productId2) {
                this.productId = productId2;
            }

            public long getPurchaseTime() {
                return this.purchaseTime;
            }

            public void setPurchaseTime(long purchaseTime2) {
                this.purchaseTime = purchaseTime2;
            }

            public String getPurchaseToken() {
                return this.purchaseToken;
            }

            public void setPurchaseToken(String purchaseToken2) {
                this.purchaseToken = purchaseToken2;
            }

            public int getPurchaseState() {
                return this.purchaseState;
            }

            public void setPurchaseState(int purchaseState2) {
                this.purchaseState = purchaseState2;
            }

            public String getDeveloperPayload() {
                return this.developerPayload;
            }

            public void setDeveloperPayload(String developerPayload2) {
                this.developerPayload = developerPayload2;
            }
        }

        public DeveloperPurchase getDeveloperPurchase() {
            return this.developerPurchase;
        }

        public void setDeveloperPurchase(DeveloperPurchase developerPurchase2) {
            this.developerPurchase = developerPurchase2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.billing.PurchaseResponse$Product */
    public static class Product {

        /* renamed from: id */
        private long f6142id;
        private String sku;

        public long getId() {
            return this.f6142id;
        }

        public void setId(long id) {
            this.f6142id = id;
        }

        public String getSku() {
            return this.sku;
        }

        public void setSku(String sku2) {
            this.sku = sku2;
        }
    }

    public long getId() {
        return this.f6141id;
    }

    public void setId(long id) {
        this.f6141id = id;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String signature2) {
        this.signature = signature2;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product2) {
        this.product = product2;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data2) {
        this.data = data2;
    }
}
