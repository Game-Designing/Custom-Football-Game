package p005cm.aptoide.p006pt.billing;

/* renamed from: cm.aptoide.pt.billing.BillingIdManager */
public interface BillingIdManager {
    String generateAuthorizationId();

    String generateAuthorizationId(long j);

    String generateProductId(long j);

    String generatePurchaseId(long j);

    String generateServiceId();

    String generateServiceId(long j);

    String generateTransactionId();

    String generateTransactionId(long j);

    long resolveProductId(String str);

    long resolvePurchaseId(String str);

    long resolveServiceId(String str);

    long resolveTransactionId(String str);
}
