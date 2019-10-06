package p005cm.aptoide.p006pt.billing.authorization;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.billing.authorization.Authorization */
public class Authorization {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String customerId;

    /* renamed from: id */
    private final String f5358id;
    private final Status status;
    private final String transactionId;

    /* renamed from: cm.aptoide.pt.billing.authorization.Authorization$Status */
    public enum Status {
        NEW,
        PENDING,
        PENDING_SYNC,
        PROCESSING,
        REDEEMED,
        ACTIVE,
        FAILED,
        EXPIRED;

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
        boolean[] probes = Offline.getProbes(8826999821430850469L, "cm/aptoide/pt/billing/authorization/Authorization", 23);
        $jacocoData = probes;
        return probes;
    }

    public Authorization(String id, String customerId2, Status status2, String transactionId2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.f5358id = id;
        this.customerId = customerId2;
        this.status = status2;
        this.transactionId = transactionId2;
        $jacocoInit[0] = true;
    }

    public String getId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.f5358id;
        $jacocoInit[1] = true;
        return str;
    }

    public String getCustomerId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.customerId;
        $jacocoInit[2] = true;
        return str;
    }

    public boolean isPending() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean equals = Status.PENDING.equals(this.status);
        $jacocoInit[3] = true;
        return equals;
    }

    public boolean isProcessing() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (Status.PENDING_SYNC.equals(this.status)) {
            $jacocoInit[4] = true;
        } else if (Status.PROCESSING.equals(this.status)) {
            $jacocoInit[5] = true;
        } else {
            z = false;
            $jacocoInit[7] = true;
            $jacocoInit[8] = true;
            return z;
        }
        $jacocoInit[6] = true;
        z = true;
        $jacocoInit[8] = true;
        return z;
    }

    public boolean isPendingSync() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean equals = Status.PENDING_SYNC.equals(this.status);
        $jacocoInit[9] = true;
        return equals;
    }

    public boolean isFailed() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (Status.FAILED.equals(this.status)) {
            $jacocoInit[10] = true;
        } else if (Status.EXPIRED.equals(this.status)) {
            $jacocoInit[11] = true;
        } else {
            z = false;
            $jacocoInit[13] = true;
            $jacocoInit[14] = true;
            return z;
        }
        $jacocoInit[12] = true;
        z = true;
        $jacocoInit[14] = true;
        return z;
    }

    public boolean isActive() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (Status.ACTIVE.equals(this.status)) {
            $jacocoInit[15] = true;
        } else if (Status.REDEEMED.equals(this.status)) {
            $jacocoInit[16] = true;
        } else {
            z = false;
            $jacocoInit[18] = true;
            $jacocoInit[19] = true;
            return z;
        }
        $jacocoInit[17] = true;
        z = true;
        $jacocoInit[19] = true;
        return z;
    }

    public boolean isRedeemed() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean equals = Status.REDEEMED.equals(this.status);
        $jacocoInit[20] = true;
        return equals;
    }

    public Status getStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        Status status2 = this.status;
        $jacocoInit[21] = true;
        return status2;
    }

    public String getTransactionId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.transactionId;
        $jacocoInit[22] = true;
        return str;
    }
}
