package p005cm.aptoide.p006pt.billing.transaction;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.transaction.Transaction.Status;

/* renamed from: cm.aptoide.pt.billing.transaction.TransactionFactory */
public class TransactionFactory {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2434891762074837040L, "cm/aptoide/pt/billing/transaction/TransactionFactory", 2);
        $jacocoData = probes;
        return probes;
    }

    public TransactionFactory() {
        $jacocoInit()[0] = true;
    }

    public SimpleTransaction create(String id, String customerId, String productId, Status status) {
        boolean[] $jacocoInit = $jacocoInit();
        SimpleTransaction simpleTransaction = new SimpleTransaction(id, status, customerId, productId);
        $jacocoInit[1] = true;
        return simpleTransaction;
    }
}
