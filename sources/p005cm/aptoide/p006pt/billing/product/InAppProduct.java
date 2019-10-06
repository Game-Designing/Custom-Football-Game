package p005cm.aptoide.p006pt.billing.product;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.Price;

/* renamed from: cm.aptoide.pt.billing.product.InAppProduct */
public class InAppProduct extends Product {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String packageName;
    private final String sku;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2111237682997144150L, "cm/aptoide/pt/billing/product/InAppProduct", 3);
        $jacocoData = probes;
        return probes;
    }

    public InAppProduct(String id, String sku2, String icon, String title, String description, String packageName2, Price price, int packageVersionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        super(id, icon, title, description, price, packageVersionCode);
        this.sku = sku2;
        this.packageName = packageName2;
        $jacocoInit[0] = true;
    }

    public String getSku() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.sku;
        $jacocoInit[1] = true;
        return str;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[2] = true;
        return str;
    }
}
