package p005cm.aptoide.p006pt.billing.purchase;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.purchase.Purchase.Status;

/* renamed from: cm.aptoide.pt.billing.purchase.PurchaseFactory */
public class PurchaseFactory {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String IN_APP = "IN_APP";
    public static final String PAID_APP = "PAID_APP";

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-733692918866516133L, "cm/aptoide/pt/billing/purchase/PurchaseFactory", 11);
        $jacocoData = probes;
        return probes;
    }

    public PurchaseFactory() {
        $jacocoInit()[0] = true;
    }

    public Purchase create(String productId, String signature, String signatureData, Status status, String sku, String type, String apkPath, String transactionId) {
        String str = productId;
        Status status2 = status;
        String str2 = type;
        String str3 = transactionId;
        boolean[] $jacocoInit = $jacocoInit();
        if (str2 == null) {
            $jacocoInit[1] = true;
            Purchase purchase = new Purchase(status2, str, str3);
            $jacocoInit[2] = true;
            return purchase;
        }
        char c = 65535;
        int hashCode = type.hashCode();
        if (hashCode != -2130109465) {
            if (hashCode != 1699693070) {
                $jacocoInit[3] = true;
            } else if (!str2.equals(PAID_APP)) {
                $jacocoInit[6] = true;
            } else {
                $jacocoInit[7] = true;
                c = 1;
            }
        } else if (!str2.equals(IN_APP)) {
            $jacocoInit[4] = true;
        } else {
            c = 0;
            $jacocoInit[5] = true;
        }
        if (c == 0) {
            String str4 = apkPath;
            InAppPurchase inAppPurchase = new InAppPurchase(productId, signature, signatureData, status, sku, transactionId);
            $jacocoInit[8] = true;
            return inAppPurchase;
        } else if (c != 1) {
            Purchase purchase2 = new Purchase(status2, str, str3);
            $jacocoInit[10] = true;
            return purchase2;
        } else {
            PaidAppPurchase paidAppPurchase = new PaidAppPurchase(apkPath, status2, str, str3);
            $jacocoInit[9] = true;
            return paidAppPurchase;
        }
    }
}
