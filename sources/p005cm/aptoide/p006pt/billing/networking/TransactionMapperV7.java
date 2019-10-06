package p005cm.aptoide.p006pt.billing.networking;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingIdManager;
import p005cm.aptoide.p006pt.billing.transaction.SimpleTransaction;
import p005cm.aptoide.p006pt.billing.transaction.Transaction;
import p005cm.aptoide.p006pt.billing.transaction.Transaction.Status;
import p005cm.aptoide.p006pt.billing.transaction.TransactionFactory;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetTransactionRequest.ResponseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetTransactionRequest.ResponseBody.Transaction.Product;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetTransactionRequest.ResponseBody.Transaction.User;

/* renamed from: cm.aptoide.pt.billing.networking.TransactionMapperV7 */
public class TransactionMapperV7 {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BillingIdManager billingIdManager;
    private final TransactionFactory transactionFactory;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2326176988651310138L, "cm/aptoide/pt/billing/networking/TransactionMapperV7", 10);
        $jacocoData = probes;
        return probes;
    }

    public TransactionMapperV7(TransactionFactory transactionFactory2, BillingIdManager billingIdManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.transactionFactory = transactionFactory2;
        this.billingIdManager = billingIdManager2;
        $jacocoInit[0] = true;
    }

    public Transaction map(ResponseBody.Transaction response) {
        boolean[] $jacocoInit = $jacocoInit();
        TransactionFactory transactionFactory2 = this.transactionFactory;
        String generateTransactionId = this.billingIdManager.generateTransactionId(response.getId());
        $jacocoInit[1] = true;
        User user = response.getUser();
        $jacocoInit[2] = true;
        long id = user.getId();
        $jacocoInit[3] = true;
        String valueOf = String.valueOf(id);
        BillingIdManager billingIdManager2 = this.billingIdManager;
        $jacocoInit[4] = true;
        Product product = response.getProduct();
        $jacocoInit[5] = true;
        long id2 = product.getId();
        $jacocoInit[6] = true;
        String generateProductId = billingIdManager2.generateProductId(id2);
        $jacocoInit[7] = true;
        Status valueOf2 = Status.valueOf(response.getStatus());
        $jacocoInit[8] = true;
        SimpleTransaction create = transactionFactory2.create(generateTransactionId, valueOf, generateProductId, valueOf2);
        $jacocoInit[9] = true;
        return create;
    }
}
