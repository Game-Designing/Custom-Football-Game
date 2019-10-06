package p005cm.aptoide.p006pt.billing.transaction;

/* renamed from: cm.aptoide.pt.billing.transaction.Transaction */
public interface Transaction {

    /* renamed from: cm.aptoide.pt.billing.transaction.Transaction$Status */
    public enum Status {
        NEW,
        PENDING_SERVICE_AUTHORIZATION,
        PROCESSING,
        COMPLETED,
        FAILED;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    String getCustomerId();

    String getId();

    String getProductId();

    boolean isCompleted();

    boolean isFailed();

    boolean isNew();

    boolean isPendingAuthorization();

    boolean isProcessing();
}
