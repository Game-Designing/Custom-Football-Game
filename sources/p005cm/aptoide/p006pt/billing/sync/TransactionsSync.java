package p005cm.aptoide.p006pt.billing.sync;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.Customer;
import p005cm.aptoide.p006pt.billing.transaction.Transaction;
import p005cm.aptoide.p006pt.billing.transaction.TransactionPersistence;
import p005cm.aptoide.p006pt.billing.transaction.TransactionService;
import p005cm.aptoide.p006pt.sync.Sync;
import p026rx.C0117M;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.sync.TransactionsSync */
public class TransactionsSync extends Sync {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Customer customer;
    private final String productId;
    private final TransactionPersistence transactionPersistence;
    private final TransactionService transactionService;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3477022899660323717L, "cm/aptoide/pt/billing/sync/TransactionsSync", 6);
        $jacocoData = probes;
        return probes;
    }

    public TransactionsSync(String id, Customer customer2, TransactionPersistence transactionPersistence2, TransactionService transactionService2, boolean periodic, boolean exact, long interval, long trigger, String productId2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(id, periodic, exact, trigger, interval);
        this.customer = customer2;
        this.transactionPersistence = transactionPersistence2;
        this.transactionService = transactionService2;
        this.productId = productId2;
        $jacocoInit[0] = true;
    }

    public C0117M execute() {
        boolean[] $jacocoInit = $jacocoInit();
        Single id = this.customer.getId();
        C2377h hVar = new C2377h(this);
        $jacocoInit[1] = true;
        Single a = id.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) hVar);
        C2376g gVar = new C2376g(this);
        $jacocoInit[2] = true;
        C0117M b = a.mo3693b((C0132p<? super T, ? extends C0117M>) gVar);
        $jacocoInit[3] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11249a(String customerId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single transaction = this.transactionService.getTransaction(customerId, this.productId);
        $jacocoInit[5] = true;
        return transaction;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo11248a(Transaction transaction) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M saveTransaction = this.transactionPersistence.saveTransaction(transaction);
        $jacocoInit[4] = true;
        return saveTransaction;
    }
}
