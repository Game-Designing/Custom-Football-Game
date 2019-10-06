package p005cm.aptoide.p006pt.billing.transaction;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.authorization.Authorization;

/* renamed from: cm.aptoide.pt.billing.transaction.AuthorizedTransaction */
public class AuthorizedTransaction implements Transaction {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Authorization authorization;
    private final Transaction transaction;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7753530646346436390L, "cm/aptoide/pt/billing/transaction/AuthorizedTransaction", 30);
        $jacocoData = probes;
        return probes;
    }

    public AuthorizedTransaction(Transaction transaction2, Authorization authorization2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.transaction = transaction2;
        this.authorization = authorization2;
        $jacocoInit[0] = true;
    }

    public Authorization getAuthorization() {
        boolean[] $jacocoInit = $jacocoInit();
        Authorization authorization2 = this.authorization;
        $jacocoInit[1] = true;
        return authorization2;
    }

    public String getCustomerId() {
        boolean[] $jacocoInit = $jacocoInit();
        String customerId = this.transaction.getCustomerId();
        $jacocoInit[2] = true;
        return customerId;
    }

    public String getProductId() {
        boolean[] $jacocoInit = $jacocoInit();
        String productId = this.transaction.getProductId();
        $jacocoInit[3] = true;
        return productId;
    }

    public String getId() {
        boolean[] $jacocoInit = $jacocoInit();
        String id = this.transaction.getId();
        $jacocoInit[4] = true;
        return id;
    }

    public boolean isNew() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.transaction.isNew()) {
            $jacocoInit[5] = true;
        } else if (this.authorization.isProcessing()) {
            $jacocoInit[6] = true;
        } else if (this.authorization.isFailed()) {
            $jacocoInit[7] = true;
        } else {
            $jacocoInit[8] = true;
            return true;
        }
        $jacocoInit[9] = true;
        return false;
    }

    public boolean isCompleted() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean isCompleted = this.transaction.isCompleted();
        $jacocoInit[10] = true;
        return isCompleted;
    }

    public boolean isPendingAuthorization() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.transaction.isPendingAuthorization()) {
            $jacocoInit[11] = true;
        } else if (!this.authorization.isPending()) {
            $jacocoInit[12] = true;
        } else {
            $jacocoInit[13] = true;
            z = true;
            $jacocoInit[15] = true;
            return z;
        }
        z = false;
        $jacocoInit[14] = true;
        $jacocoInit[15] = true;
        return z;
    }

    public boolean isProcessing() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.transaction.isProcessing()) {
            $jacocoInit[16] = true;
        } else if (this.authorization.isProcessing()) {
            $jacocoInit[17] = true;
        } else {
            if (!this.authorization.isRedeemed()) {
                $jacocoInit[18] = true;
            } else {
                Transaction transaction2 = this.transaction;
                $jacocoInit[19] = true;
                if (transaction2.isCompleted()) {
                    $jacocoInit[20] = true;
                } else {
                    $jacocoInit[21] = true;
                }
            }
            z = false;
            $jacocoInit[23] = true;
            $jacocoInit[24] = true;
            return z;
        }
        $jacocoInit[22] = true;
        z = true;
        $jacocoInit[24] = true;
        return z;
    }

    public boolean isFailed() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.transaction.isFailed()) {
            $jacocoInit[25] = true;
        } else if (this.authorization.isFailed()) {
            $jacocoInit[26] = true;
        } else {
            z = false;
            $jacocoInit[28] = true;
            $jacocoInit[29] = true;
            return z;
        }
        $jacocoInit[27] = true;
        z = true;
        $jacocoInit[29] = true;
        return z;
    }
}
