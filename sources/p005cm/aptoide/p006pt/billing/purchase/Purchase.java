package p005cm.aptoide.p006pt.billing.purchase;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.billing.purchase.Purchase */
public class Purchase {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String productId;
    private final Status status;
    private final String transactionId;

    /* renamed from: cm.aptoide.pt.billing.purchase.Purchase$Status */
    public enum Status {
        COMPLETED,
        FAILED,
        NEW;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4900155733275077466L, "cm/aptoide/pt/billing/purchase/Purchase", 6);
        $jacocoData = probes;
        return probes;
    }

    public Purchase(Status status2, String productId2, String transactionId2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.status = status2;
        this.productId = productId2;
        this.transactionId = transactionId2;
        $jacocoInit[0] = true;
    }

    public String getTransactionId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.transactionId;
        $jacocoInit[1] = true;
        return str;
    }

    public Status getStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        Status status2 = this.status;
        $jacocoInit[2] = true;
        return status2;
    }

    public String getProductId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.productId;
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
}
