package p005cm.aptoide.p006pt.billing.exception;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.billing.exception.PurchaseNotFoundException */
public class PurchaseNotFoundException extends BillingException {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7137261094250402371L, "cm/aptoide/pt/billing/exception/PurchaseNotFoundException", 2);
        $jacocoData = probes;
        return probes;
    }

    public PurchaseNotFoundException(String message) {
        boolean[] $jacocoInit = $jacocoInit();
        super(message);
        $jacocoInit[0] = true;
    }

    public PurchaseNotFoundException() {
        $jacocoInit()[1] = true;
    }
}
