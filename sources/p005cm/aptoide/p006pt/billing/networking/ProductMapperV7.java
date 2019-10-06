package p005cm.aptoide.p006pt.billing.networking;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingIdManager;
import p005cm.aptoide.p006pt.billing.product.InAppProduct;
import p005cm.aptoide.p006pt.billing.product.Product;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetProductsRequest.ResponseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetProductsRequest.ResponseBody.Product.Price;

/* renamed from: cm.aptoide.pt.billing.networking.ProductMapperV7 */
public class ProductMapperV7 {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BillingIdManager billingIdManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5701095613358221518L, "cm/aptoide/pt/billing/networking/ProductMapperV7", 12);
        $jacocoData = probes;
        return probes;
    }

    public ProductMapperV7(BillingIdManager billingIdManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.billingIdManager = billingIdManager2;
        $jacocoInit[0] = true;
    }

    public List<Product> map(String packageName, List<ResponseBody.Product> responseList, int packageVersionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        List<Product> products = new ArrayList<>(responseList.size());
        $jacocoInit[1] = true;
        $jacocoInit[2] = true;
        for (ResponseBody.Product response : responseList) {
            $jacocoInit[3] = true;
            products.add(map(packageName, packageVersionCode, response));
            $jacocoInit[4] = true;
        }
        $jacocoInit[5] = true;
        return products;
    }

    public Product map(String packageName, int packageVersionCode, ResponseBody.Product response) {
        boolean[] $jacocoInit = $jacocoInit();
        String generateProductId = this.billingIdManager.generateProductId(response.getId());
        String sku = response.getSku();
        $jacocoInit[6] = true;
        String icon = response.getIcon();
        String title = response.getTitle();
        String description = response.getDescription();
        $jacocoInit[7] = true;
        Price price = response.getPrice();
        $jacocoInit[8] = true;
        double amount = price.getAmount();
        Price price2 = response.getPrice();
        $jacocoInit[9] = true;
        String currency = price2.getCurrency();
        Price price3 = response.getPrice();
        $jacocoInit[10] = true;
        InAppProduct inAppProduct = new InAppProduct(generateProductId, sku, icon, title, description, packageName, new p005cm.aptoide.p006pt.billing.Price(amount, currency, price3.getSign()), packageVersionCode);
        $jacocoInit[11] = true;
        return inAppProduct;
    }
}
