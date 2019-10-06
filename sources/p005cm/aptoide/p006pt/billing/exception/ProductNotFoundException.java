package p005cm.aptoide.p006pt.billing.exception;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.billing.exception.ProductNotFoundException */
public class ProductNotFoundException extends BillingException {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4895752845416350218L, "cm/aptoide/pt/billing/exception/ProductNotFoundException", 2);
        $jacocoData = probes;
        return probes;
    }

    public ProductNotFoundException(String message) {
        boolean[] $jacocoInit = $jacocoInit();
        super(message);
        $jacocoInit[0] = true;
    }

    public ProductNotFoundException() {
        $jacocoInit()[1] = true;
    }
}
