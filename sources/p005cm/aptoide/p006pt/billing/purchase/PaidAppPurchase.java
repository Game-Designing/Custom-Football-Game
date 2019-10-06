package p005cm.aptoide.p006pt.billing.purchase;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.purchase.Purchase.Status;

/* renamed from: cm.aptoide.pt.billing.purchase.PaidAppPurchase */
public class PaidAppPurchase extends Purchase {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String apkPath;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6863424283731571264L, "cm/aptoide/pt/billing/purchase/PaidAppPurchase", 2);
        $jacocoData = probes;
        return probes;
    }

    public PaidAppPurchase(String apkPath2, Status status, String productId, String transactionId) {
        boolean[] $jacocoInit = $jacocoInit();
        super(status, productId, transactionId);
        this.apkPath = apkPath2;
        $jacocoInit[0] = true;
    }

    public String getApkPath() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.apkPath;
        $jacocoInit[1] = true;
        return str;
    }
}
