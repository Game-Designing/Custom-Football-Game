package p005cm.aptoide.p006pt.billing.networking;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.purchase.Purchase;
import p005cm.aptoide.p006pt.billing.purchase.Purchase.Status;
import p005cm.aptoide.p006pt.billing.purchase.PurchaseFactory;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp.Path;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp.Payment;

/* renamed from: cm.aptoide.pt.billing.networking.PurchaseMapperV3 */
public class PurchaseMapperV3 {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final PurchaseFactory purchaseFactory;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2403019538032207145L, "cm/aptoide/pt/billing/networking/PurchaseMapperV3", 10);
        $jacocoData = probes;
        return probes;
    }

    public PurchaseMapperV3(PurchaseFactory purchaseFactory2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.purchaseFactory = purchaseFactory2;
        $jacocoInit[0] = true;
    }

    public Purchase map(PaidApp response, String productId) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!response.isOk()) {
            $jacocoInit[1] = true;
        } else if (!response.isPaid()) {
            $jacocoInit[2] = true;
        } else {
            Payment payment = response.getPayment();
            $jacocoInit[3] = true;
            if (!payment.isPaid()) {
                $jacocoInit[4] = true;
            } else {
                PurchaseFactory purchaseFactory2 = this.purchaseFactory;
                Status status = Status.COMPLETED;
                $jacocoInit[5] = true;
                Path path = response.getPath();
                $jacocoInit[6] = true;
                String stringPath = path.getStringPath();
                $jacocoInit[7] = true;
                Purchase create = purchaseFactory2.create(productId, null, null, status, null, PurchaseFactory.PAID_APP, stringPath, null);
                $jacocoInit[8] = true;
                return create;
            }
        }
        Purchase create2 = this.purchaseFactory.create(productId, null, null, Status.FAILED, null, PurchaseFactory.PAID_APP, null, null);
        $jacocoInit[9] = true;
        return create2;
    }
}
