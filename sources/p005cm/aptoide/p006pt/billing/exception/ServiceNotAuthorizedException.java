package p005cm.aptoide.p006pt.billing.exception;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.billing.exception.ServiceNotAuthorizedException */
public class ServiceNotAuthorizedException extends BillingException {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(937375700921814632L, "cm/aptoide/pt/billing/exception/ServiceNotAuthorizedException", 1);
        $jacocoData = probes;
        return probes;
    }

    public ServiceNotAuthorizedException(String message) {
        boolean[] $jacocoInit = $jacocoInit();
        super(message);
        $jacocoInit[0] = true;
    }
}
