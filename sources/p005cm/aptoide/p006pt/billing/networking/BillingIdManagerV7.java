package p005cm.aptoide.p006pt.billing.networking;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingIdManager;
import p005cm.aptoide.p006pt.billing.authorization.LocalIdGenerator;

/* renamed from: cm.aptoide.pt.billing.networking.BillingIdManagerV7 */
public class BillingIdManagerV7 implements BillingIdManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final LocalIdGenerator idGenerator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6188014429443271046L, "cm/aptoide/pt/billing/networking/BillingIdManagerV7", 13);
        $jacocoData = probes;
        return probes;
    }

    public BillingIdManagerV7(LocalIdGenerator idGenerator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.idGenerator = idGenerator2;
        $jacocoInit[0] = true;
    }

    public String generateAuthorizationId(long authorizationId) {
        boolean[] $jacocoInit = $jacocoInit();
        String valueOf = String.valueOf(authorizationId);
        $jacocoInit[1] = true;
        return valueOf;
    }

    public String generateTransactionId(long transactionId) {
        boolean[] $jacocoInit = $jacocoInit();
        String valueOf = String.valueOf(transactionId);
        $jacocoInit[2] = true;
        return valueOf;
    }

    public String generateProductId(long productId) {
        boolean[] $jacocoInit = $jacocoInit();
        String valueOf = String.valueOf(productId);
        $jacocoInit[3] = true;
        return valueOf;
    }

    public String generateServiceId(long serviceId) {
        boolean[] $jacocoInit = $jacocoInit();
        String valueOf = String.valueOf(serviceId);
        $jacocoInit[4] = true;
        return valueOf;
    }

    public String generatePurchaseId(long purchaseId) {
        boolean[] $jacocoInit = $jacocoInit();
        String valueOf = String.valueOf(purchaseId);
        $jacocoInit[5] = true;
        return valueOf;
    }

    public long resolveProductId(String productId) {
        boolean[] $jacocoInit = $jacocoInit();
        long longValue = Long.valueOf(productId).longValue();
        $jacocoInit[6] = true;
        return longValue;
    }

    public long resolveServiceId(String serviceId) {
        boolean[] $jacocoInit = $jacocoInit();
        long longValue = Long.valueOf(serviceId).longValue();
        $jacocoInit[7] = true;
        return longValue;
    }

    public long resolvePurchaseId(String purchaseId) {
        boolean[] $jacocoInit = $jacocoInit();
        long longValue = Long.valueOf(purchaseId).longValue();
        $jacocoInit[8] = true;
        return longValue;
    }

    public long resolveTransactionId(String transactionId) {
        boolean[] $jacocoInit = $jacocoInit();
        long longValue = Long.valueOf(transactionId).longValue();
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
