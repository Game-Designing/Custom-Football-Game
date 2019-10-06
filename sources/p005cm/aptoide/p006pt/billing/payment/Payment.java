package p005cm.aptoide.p006pt.billing.payment;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p005cm.aptoide.p006pt.billing.product.Product;
import p005cm.aptoide.p006pt.billing.purchase.Purchase;
import p005cm.aptoide.p006pt.billing.transaction.AuthorizedTransaction;
import p005cm.aptoide.p006pt.billing.transaction.Transaction;

/* renamed from: cm.aptoide.pt.billing.payment.Payment */
public class Payment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final List<PaymentService> paymentServices;
    private final Product product;
    private final Purchase purchase;
    private final PaymentService selectedPaymentService;
    private final Transaction transaction;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-598435645519100698L, "cm/aptoide/pt/billing/payment/Payment", 22);
        $jacocoData = probes;
        return probes;
    }

    public Payment(Product product2, PaymentService selectedPaymentService2, Transaction transaction2, Purchase purchase2, List<PaymentService> paymentServices2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.product = product2;
        this.selectedPaymentService = selectedPaymentService2;
        this.transaction = transaction2;
        this.purchase = purchase2;
        this.paymentServices = paymentServices2;
        $jacocoInit[0] = true;
    }

    public Product getProduct() {
        boolean[] $jacocoInit = $jacocoInit();
        Product product2 = this.product;
        $jacocoInit[1] = true;
        return product2;
    }

    public PaymentService getSelectedPaymentService() {
        boolean[] $jacocoInit = $jacocoInit();
        PaymentService paymentService = this.selectedPaymentService;
        $jacocoInit[2] = true;
        return paymentService;
    }

    public Purchase getPurchase() {
        boolean[] $jacocoInit = $jacocoInit();
        Purchase purchase2 = this.purchase;
        $jacocoInit[3] = true;
        return purchase2;
    }

    public Transaction getTransaction() {
        boolean[] $jacocoInit = $jacocoInit();
        Transaction transaction2 = this.transaction;
        $jacocoInit[4] = true;
        return transaction2;
    }

    public List<PaymentService> getPaymentServices() {
        boolean[] $jacocoInit = $jacocoInit();
        List<PaymentService> list = this.paymentServices;
        $jacocoInit[5] = true;
        return list;
    }

    public boolean isNew() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.transaction.isNew()) {
            $jacocoInit[6] = true;
        } else if (this.purchase.isCompleted()) {
            $jacocoInit[7] = true;
        } else {
            $jacocoInit[8] = true;
            return true;
        }
        if (!this.transaction.isCompleted()) {
            $jacocoInit[9] = true;
        } else if (this.purchase.isCompleted()) {
            $jacocoInit[10] = true;
        } else {
            $jacocoInit[11] = true;
            return true;
        }
        $jacocoInit[12] = true;
        return false;
    }

    public Authorization getAuthorization() {
        boolean[] $jacocoInit = $jacocoInit();
        Transaction transaction2 = this.transaction;
        if (transaction2 instanceof AuthorizedTransaction) {
            $jacocoInit[13] = true;
            Authorization authorization = ((AuthorizedTransaction) transaction2).getAuthorization();
            $jacocoInit[14] = true;
            return authorization;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Payment does not require authorization.");
        $jacocoInit[15] = true;
        throw illegalStateException;
    }

    public boolean isPendingAuthorization() {
        boolean[] $jacocoInit = $jacocoInit();
        Transaction transaction2 = this.transaction;
        if (transaction2 instanceof AuthorizedTransaction) {
            $jacocoInit[16] = true;
            boolean isPendingAuthorization = transaction2.isPendingAuthorization();
            $jacocoInit[17] = true;
            return isPendingAuthorization;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Payment does not require authorization.");
        $jacocoInit[18] = true;
        throw illegalStateException;
    }

    public boolean isProcessing() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean isProcessing = this.transaction.isProcessing();
        $jacocoInit[19] = true;
        return isProcessing;
    }

    public boolean isFailed() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean isFailed = this.transaction.isFailed();
        $jacocoInit[20] = true;
        return isFailed;
    }

    public boolean isCompleted() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean isCompleted = this.purchase.isCompleted();
        $jacocoInit[21] = true;
        return isCompleted;
    }
}
