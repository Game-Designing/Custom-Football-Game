package p005cm.aptoide.p006pt.billing.networking;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingIdManager;
import p005cm.aptoide.p006pt.billing.authorization.LocalIdGenerator;

/* renamed from: cm.aptoide.pt.billing.networking.BillingIdManagerV3 */
public class BillingIdManagerV3 implements BillingIdManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final LocalIdGenerator idGenerator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-9118861261740316754L, "cm/aptoide/pt/billing/networking/BillingIdManagerV3", 13);
        $jacocoData = probes;
        return probes;
    }

    public BillingIdManagerV3(LocalIdGenerator idGenerator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.idGenerator = idGenerator2;
        $jacocoInit[0] = true;
    }

    public String generateAuthorizationId(long authorizationId) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("authorization");
        sb.append(authorizationId);
        String sb2 = sb.toString();
        $jacocoInit[1] = true;
        return sb2;
    }

    public String generateTransactionId(long transactionId) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("transaction");
        sb.append(transactionId);
        String sb2 = sb.toString();
        $jacocoInit[2] = true;
        return sb2;
    }

    public String generateProductId(long productId) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("product");
        sb.append(productId);
        String sb2 = sb.toString();
        $jacocoInit[3] = true;
        return sb2;
    }

    public String generateServiceId(long serviceId) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("service");
        sb.append(serviceId);
        String sb2 = sb.toString();
        $jacocoInit[4] = true;
        return sb2;
    }

    public String generatePurchaseId(long purchaseId) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("purchase");
        sb.append(purchaseId);
        String sb2 = sb.toString();
        $jacocoInit[5] = true;
        return sb2;
    }

    public long resolveProductId(String productId) {
        boolean[] $jacocoInit = $jacocoInit();
        long longValue = Long.valueOf(productId.replace("product", "")).longValue();
        $jacocoInit[6] = true;
        return longValue;
    }

    public long resolveServiceId(String serviceId) {
        boolean[] $jacocoInit = $jacocoInit();
        long longValue = Long.valueOf(serviceId.replace("service", "")).longValue();
        $jacocoInit[7] = true;
        return longValue;
    }

    public long resolvePurchaseId(String purchaseId) {
        boolean[] $jacocoInit = $jacocoInit();
        long longValue = Long.valueOf(purchaseId.replace("purchase", "")).longValue();
        $jacocoInit[8] = true;
        return longValue;
    }

    public long resolveTransactionId(String transactionId) {
        boolean[] $jacocoInit = $jacocoInit();
        long longValue = Long.valueOf(transactionId.replace("transaction", "")).longValue();
        $jacocoInit[9] = true;
        return longValue;
    }

    public String generateServiceId() {
        boolean[] $jacocoInit = $jacocoInit();
        String generate = this.idGenerator.generate();
        $jacocoInit[10] = true;
        return generate;
    }

    public String generateTransactionId() {
        boolean[] $jacocoInit = $jacocoInit();
        String generate = this.idGenerator.generate();
        $jacocoInit[11] = true;
        return generate;
    }

    public String generateAuthorizationId() {
        boolean[] $jacocoInit = $jacocoInit();
        String generate = this.idGenerator.generate();
        $jacocoInit[12] = true;
        return generate;
    }
}
