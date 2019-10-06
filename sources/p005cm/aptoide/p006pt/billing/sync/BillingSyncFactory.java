package p005cm.aptoide.p006pt.billing.sync;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.Customer;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationPersistence;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationService;
import p005cm.aptoide.p006pt.billing.authorization.LocalIdGenerator;
import p005cm.aptoide.p006pt.billing.transaction.TransactionPersistence;
import p005cm.aptoide.p006pt.billing.transaction.TransactionService;
import p005cm.aptoide.p006pt.sync.Sync;

/* renamed from: cm.aptoide.pt.billing.sync.BillingSyncFactory */
public class BillingSyncFactory {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AuthorizationPersistence authorizationPersistence;
    private final AuthorizationService authorizationService;
    private final Customer customer;
    private final LocalIdGenerator localIdGenerator;
    private final TransactionPersistence transactionPersistence;
    private final TransactionService transactionService;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7245279213944649395L, "cm/aptoide/pt/billing/sync/BillingSyncFactory", 3);
        $jacocoData = probes;
        return probes;
    }

    public BillingSyncFactory(Customer customer2, TransactionService transactionService2, AuthorizationService authorizationService2, TransactionPersistence transactionPersistence2, AuthorizationPersistence authorizationPersistence2, LocalIdGenerator localIdGenerator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.customer = customer2;
        this.transactionService = transactionService2;
        this.authorizationService = authorizationService2;
        this.transactionPersistence = transactionPersistence2;
        this.authorizationPersistence = authorizationPersistence2;
        this.localIdGenerator = localIdGenerator2;
        $jacocoInit[0] = true;
    }

    public Sync createAuthorizationSync(String transactionId) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("authorization");
        sb.append(transactionId);
        AuthorizationSync authorizationSync = new AuthorizationSync(sb.toString(), this.customer, transactionId, this.authorizationService, this.authorizationPersistence, true, true, 10000, 0, this.localIdGenerator);
        $jacocoInit[1] = true;
        return authorizationSync;
    }

    public Sync createTransactionSync(String productId) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("transaction");
        sb.append(productId);
        TransactionsSync transactionsSync = new TransactionsSync(sb.toString(), this.customer, this.transactionPersistence, this.transactionService, true, true, 10000, 0, productId);
        $jacocoInit[2] = true;
        return transactionsSync;
    }
}
