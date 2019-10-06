package p005cm.aptoide.p006pt.billing.exception;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.billing.exception.PaymentFailureException */
public class PaymentFailureException extends BillingException {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4437119987193887645L, "cm/aptoide/pt/billing/exception/PaymentFailureException", 1);
        $jacocoData = probes;
        return probes;
    }

    public PaymentFailureException(String message) {
        boolean[] $jacocoInit = $jacocoInit();
        super(message);
        $jacocoInit[0] = true;
    }
}
