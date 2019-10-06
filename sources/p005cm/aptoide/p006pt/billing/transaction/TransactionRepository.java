package p005cm.aptoide.p006pt.billing.transaction;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingSyncScheduler;
import p005cm.aptoide.p006pt.billing.Customer;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.transaction.TransactionRepository */
public class TransactionRepository {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Customer customer;
    private final BillingSyncScheduler syncScheduler;
    private final TransactionPersistence transactionPersistence;
    private final TransactionService transactionService;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3005656424310809562L, "cm/aptoide/pt/billing/transaction/TransactionRepository", 14);
        $jacocoData = probes;
        return probes;
    }

    public TransactionRepository(TransactionPersistence transactionPersistence2, BillingSyncScheduler syncScheduler2, Customer customer2, TransactionService transactionService2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.transactionPersistence = transactionPersistence2;
        this.syncScheduler = syncScheduler2;
        this.customer = customer2;
        this.transactionService = transactionService2;
        $jacocoInit[0] = true;
    }

    public Single<Transaction> createTransaction(String productId, String serviceId, String payload) {
        boolean[] $jacocoInit = $jacocoInit();
        Single id = this.customer.getId();
        C2379b bVar = new C2379b(this, productId, serviceId, payload);
        $jacocoInit[1] = true;
        Single<Transaction> a = id.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) bVar);
        $jacocoInit[2] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11260a(String productId, String serviceId, String payload, String customerId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single createTransaction = this.transactionService.createTransaction(customerId, productId, serviceId, payload);
        $jacocoInit[13] = true;
        return createTransaction;
    }

    public Single<Transaction> createTransaction(String productId, String serviceId, String payload, String token) {
        boolean[] $jacocoInit = $jacocoInit();
        Single id = this.customer.getId();
        C2380c cVar = new C2380c(this, productId, serviceId, payload, token);
        $jacocoInit[3] = true;
        Single<Transaction> a = id.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) cVar);
        $jacocoInit[4] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11261a(String productId, String serviceId, String payload, String token, String customerId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single createTransaction = this.transactionService.createTransaction(customerId, productId, serviceId, payload, token);
        $jacocoInit[12] = true;
        return createTransaction;
    }

    public C0120S<Transaction> getTransaction(String productId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single id = this.customer.getId();
        C2378a aVar = new C2378a(this, productId);
        $jacocoInit[5] = true;
        Single b = id.mo3695b((C0129b<? super T>) aVar);
        C2381d dVar = new C2381d(this, productId);
        $jacocoInit[6] = true;
        C0120S<Transaction> c = b.mo3697c(dVar);
        $jacocoInit[7] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11262a(String productId, String __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.syncScheduler.syncTransaction(productId);
        $jacocoInit[11] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo11263b(String productId, String customerId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S transaction = this.transactionPersistence.getTransaction(customerId, productId);
        $jacocoInit[10] = true;
        return transaction;
    }

    public Single<List<Transaction>> getOtherTransactions(String customerId, String productId, String transactionId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<List<Transaction>> otherTransactions = this.transactionPersistence.getOtherTransactions(transactionId, productId, customerId);
        $jacocoInit[8] = true;
        return otherTransactions;
    }

    public C0117M removeTransaction(String transactionId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M removeTransaction = this.transactionPersistence.removeTransaction(transactionId);
        $jacocoInit[9] = true;
        return removeTransaction;
    }
}
