package p005cm.aptoide.p006pt.billing.product;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.Price;

/* renamed from: cm.aptoide.pt.billing.product.Product */
public class Product {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String description;
    private final String icon;

    /* renamed from: id */
    private final String f5519id;
    private final int packageVersionCode;
    private final Price price;
    private final String title;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9184765650512737805L, "cm/aptoide/pt/billing/product/Product", 7);
        $jacocoData = probes;
        return probes;
    }

    public Product(String id, String icon2, String title2, String description2, Price price2, int packageVersionCode2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.f5519id = id;
        this.icon = icon2;
        this.title = title2;
        this.description = description2;
        this.price = price2;
        this.packageVersionCode = packageVersionCode2;
        $jacocoInit[0] = true;
    }

    public String getId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.f5519id;
        $jacocoInit[1] = true;
        return str;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[2] = true;
        return str;
    }

    public String getTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        $jacocoInit[3] = true;
        return str;
    }

    public Price getPrice() {
        boolean[] $jacocoInit = $jacocoInit();
        Price price2 = this.price;
        $jacocoInit[4] = true;
        return price2;
    }

    public String getDescription() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.description;
        $jacocoInit[5] = true;
        return str;
    }

    public int getPackageVersionCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.packageVersionCode;
        $jacocoInit[6] = true;
        return i;
    }
}
