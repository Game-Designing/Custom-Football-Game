package p005cm.aptoide.p006pt.billing.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.transaction.Transaction;
import p005cm.aptoide.p006pt.billing.transaction.TransactionPersistence;
import p019d.p022i.p023b.C0100e;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.persistence.InMemoryTransactionPersistence */
public class InMemoryTransactionPersistence implements TransactionPersistence {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final C0100e<List<Transaction>> transactionRelay;
    private final Map<String, Transaction> transactions;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3591635701985154689L, "cm/aptoide/pt/billing/persistence/InMemoryTransactionPersistence", 30);
        $jacocoData = probes;
        return probes;
    }

    public InMemoryTransactionPersistence(Map<String, Transaction> transactions2, C0100e<List<Transaction>> transactionRelay2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.transactions = transactions2;
        this.transactionRelay = transactionRelay2;
        $jacocoInit[0] = true;
    }

    public C0120S<Transaction> getTransaction(String customerId, String productId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S e = this.transactionRelay.mo3656e(new ArrayList(this.transactions.values()));
        C2356e eVar = new C2356e(customerId, productId);
        $jacocoInit[1] = true;
        C0120S<Transaction> f = e.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) eVar);
        $jacocoInit[2] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m7025a(String customerId, String productId, List transactions2) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) transactions2);
        C2355d dVar = new C2355d(customerId, productId);
        $jacocoInit[21] = true;
        C0120S d = a.mo3653d((C0132p<? super T, Boolean>) dVar);
        $jacocoInit[22] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7023a(String customerId, String productId, Transaction transaction) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String customerId2 = transaction.getCustomerId();
        $jacocoInit[23] = true;
        if (!customerId2.equals(customerId)) {
            $jacocoInit[24] = true;
        } else {
            String productId2 = transaction.getProductId();
            $jacocoInit[25] = true;
            if (!productId2.equals(productId)) {
                $jacocoInit[26] = true;
            } else {
                $jacocoInit[27] = true;
                z = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[29] = true;
                return valueOf;
            }
        }
        z = false;
        $jacocoInit[28] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[29] = true;
        return valueOf2;
    }

    public C0117M saveTransaction(Transaction transaction) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C2353b(this, transaction));
        $jacocoInit[3] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11211a(Transaction transaction) {
        boolean[] $jacocoInit = $jacocoInit();
        this.transactions.put(transaction.getId(), transaction);
        $jacocoInit[19] = true;
        this.transactionRelay.call(new ArrayList(this.transactions.values()));
        $jacocoInit[20] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo11212a(String transactionId) {
        Transaction transaction = (Transaction) this.transactions.remove(transactionId);
        $jacocoInit()[18] = true;
    }

    public C0117M removeTransaction(String transactionId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C2354c(this, transactionId));
        $jacocoInit[4] = true;
        return c;
    }

    public Single<List<Transaction>> getOtherTransactions(String transactionId, String productId, String customerId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) this.transactions.values());
        C2352a aVar = new C2352a(productId, transactionId, customerId);
        $jacocoInit[5] = true;
        C0120S d = a.mo3653d((C0132p<? super T, Boolean>) aVar);
        $jacocoInit[6] = true;
        C0120S m = d.mo3675m();
        $jacocoInit[7] = true;
        Single<List<Transaction>> n = m.mo3678n();
        $jacocoInit[8] = true;
        return n;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7024a(String productId, String transactionId, String customerId, Transaction transaction) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String productId2 = transaction.getProductId();
        $jacocoInit[9] = true;
        if (!productId2.equals(productId)) {
            $jacocoInit[10] = true;
        } else {
            String id = transaction.getId();
            $jacocoInit[11] = true;
            if (id.equals(transactionId)) {
                $jacocoInit[12] = true;
            } else {
                String customerId2 = transaction.getCustomerId();
                $jacocoInit[13] = true;
                if (!customerId2.equals(customerId)) {
                    $jacocoInit[14] = true;
                } else {
                    $jacocoInit[15] = true;
                    z = true;
                    Boolean valueOf = Boolean.valueOf(z);
                    $jacocoInit[17] = true;
                    return valueOf;
                }
            }
        }
        z = false;
        $jacocoInit[16] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[17] = true;
        return valueOf2;
    }
}
