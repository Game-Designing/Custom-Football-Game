package p005cm.aptoide.p006pt.billing.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.Price;
import p005cm.aptoide.p006pt.billing.product.InAppProduct;
import p005cm.aptoide.p006pt.billing.product.Product;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.PurchaseResponse.Data.DeveloperPurchase;

/* renamed from: cm.aptoide.pt.billing.external.ExternalBillingSerializer */
public class ExternalBillingSerializer {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: cm.aptoide.pt.billing.external.ExternalBillingSerializer$SKU */
    private static class SKU {
        private static transient /* synthetic */ boolean[] $jacocoData;
        @JsonProperty("price_amount_micros")
        private long amount;
        @JsonProperty("price_currency_code")
        private String currency;
        private String description;
        private String price;
        private String productId;
        private String title;
        private String type;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-8462822558848165021L, "cm/aptoide/pt/billing/external/ExternalBillingSerializer$SKU", 8);
            $jacocoData = probes;
            return probes;
        }

        public SKU(String productId2, String type2, String price2, String currency2, long amount2, String title2, String description2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.productId = productId2;
            this.type = type2;
            this.price = price2;
            this.currency = currency2;
            this.amount = amount2;
            this.title = title2;
            this.description = description2;
            $jacocoInit[0] = true;
        }

        public String getProductId() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.productId;
            $jacocoInit[1] = true;
            return str;
        }

        public String getType() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.type;
            $jacocoInit[2] = true;
            return str;
        }

        public String getPrice() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.price;
            $jacocoInit[3] = true;
            return str;
        }

        public String getCurrency() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.currency;
            $jacocoInit[4] = true;
            return str;
        }

        public long getAmount() {
            boolean[] $jacocoInit = $jacocoInit();
            long j = this.amount;
            $jacocoInit[5] = true;
            return j;
        }

        public String getTitle() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.title;
            $jacocoInit[6] = true;
            return str;
        }

        public String getDescription() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.description;
            $jacocoInit[7] = true;
            return str;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8942985296421004727L, "cm/aptoide/pt/billing/external/ExternalBillingSerializer", 16);
        $jacocoData = probes;
        return probes;
    }

    public ExternalBillingSerializer() {
        $jacocoInit()[0] = true;
    }

    public List<String> serializeProducts(List<Product> products) throws IOException {
        boolean[] $jacocoInit = $jacocoInit();
        List<String> serializedProducts = new ArrayList<>();
        $jacocoInit[1] = true;
        $jacocoInit[2] = true;
        for (Product product : products) {
            $jacocoInit[3] = true;
            ObjectMapper objectMapper = new ObjectMapper();
            InAppProduct inAppProduct = (InAppProduct) product;
            $jacocoInit[4] = true;
            String sku = inAppProduct.getSku();
            String price = getPrice(product);
            Price price2 = product.getPrice();
            $jacocoInit[5] = true;
            String currency = price2.getCurrency();
            Price price3 = product.getPrice();
            $jacocoInit[6] = true;
            SKU sku2 = new SKU(sku, ExternalBillingBinder.ITEM_TYPE_INAPP, price, currency, (long) (price3.getAmount() * 1000000.0d), product.getTitle(), product.getDescription());
            $jacocoInit[7] = true;
            serializedProducts.add(objectMapper.writeValueAsString(sku2));
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
        return serializedProducts;
    }

    public String serializePurchase(DeveloperPurchase purchase) throws JsonProcessingException {
        boolean[] $jacocoInit = $jacocoInit();
        String writeValueAsString = new ObjectMapper().writeValueAsString(purchase);
        $jacocoInit[10] = true;
        return writeValueAsString;
    }

    private String getPrice(Product product) {
        boolean[] $jacocoInit = $jacocoInit();
        Locale locale = Locale.US;
        Price price = product.getPrice();
        $jacocoInit[11] = true;
        Price price2 = product.getPrice();
        $jacocoInit[12] = true;
        double amount = price2.getAmount();
        $jacocoInit[13] = true;
        Object[] objArr = {price.getCurrencySymbol(), Double.valueOf(amount)};
        $jacocoInit[14] = true;
        String format = String.format(locale, "%s %.2f", objArr);
        $jacocoInit[15] = true;
        return format;
    }
}
