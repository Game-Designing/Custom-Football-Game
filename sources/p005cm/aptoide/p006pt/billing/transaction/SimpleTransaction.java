package p005cm.aptoide.p006pt.billing.transaction;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.transaction.Transaction.Status;

/* renamed from: cm.aptoide.pt.billing.transaction.SimpleTransaction */
public class SimpleTransaction implements Transaction {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String customerId;

    /* renamed from: id */
    private final String f5532id;
    private final String productId;
    private final Status status;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(821435165269214597L, "cm/aptoide/pt/billing/transaction/SimpleTransaction", 9);
        $jacocoData = probes;
        return probes;
    }

    public SimpleTransaction(String id, Status status2, String customerId2, String productId2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.status = status2;
        this.f5532id = id;
        this.customerId = customerId2;
        this.productId = productId2;
        $jacocoInit[0] = true;
    }

    public String getCustomerId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.customerId;
        $jacocoInit[1] = true;
        return str;
    }

    public String getProductId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.productId;
        $jacocoInit[2] = true;
        return str;
    }

    public String getId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.f5532id;
        $jacocoInit[3] = true;
        return str;
    }

    public boolean isNew() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean equals = Status.NEW.equals(this.status);
        $jacocoInit[4] = true;
        return equals;
    }

    public boolean isCompleted() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean equals = Status.COMPLETED.equals(this.status);
        $jacocoInit[5] = true;
        return equals;
    }

    public boolean isPendingAuthorization() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean equals = Status.PENDING_SERVICE_AUTHORIZATION.equals(this.status);
        $jacocoInit[6] = true;
        return equals;
    }

    public boolean isProcessing() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean equals = Status.PROCESSING.equals(this.status);
        $jacocoInit[7] = true;
        return equals;
    }

    public boolean isFailed() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean equals = Status.FAILED.equals(this.status);
        $jacocoInit[8] = true;
        return equals;
    }
}
