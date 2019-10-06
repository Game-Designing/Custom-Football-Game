package p005cm.aptoide.p006pt.billing.purchase;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.purchase.Purchase.Status;

/* renamed from: cm.aptoide.pt.billing.purchase.InAppPurchase */
public class InAppPurchase extends Purchase {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String signature;
    private final String signatureData;
    private final String sku;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5070606590362198542L, "cm/aptoide/pt/billing/purchase/InAppPurchase", 4);
        $jacocoData = probes;
        return probes;
    }

    public InAppPurchase(String productId, String signature2, String signatureData2, Status status, String sku2, String transactionId) {
        boolean[] $jacocoInit = $jacocoInit();
        super(status, productId, transactionId);
        this.signature = signature2;
        this.signatureData = signatureData2;
        this.sku = sku2;
        $jacocoInit[0] = true;
    }

    public String getSku() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.sku;
        $jacocoInit[1] = true;
        return str;
    }

    public String getSignature() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.signature;
        $jacocoInit[2] = true;
        return str;
    }

    public String getSignatureData() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.signatureData;
        $jacocoInit[3] = true;
        return str;
    }
}
