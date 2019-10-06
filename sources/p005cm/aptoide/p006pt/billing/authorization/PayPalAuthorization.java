package p005cm.aptoide.p006pt.billing.authorization;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.Price;
import p005cm.aptoide.p006pt.billing.authorization.Authorization.Status;

/* renamed from: cm.aptoide.pt.billing.authorization.PayPalAuthorization */
public class PayPalAuthorization extends MetadataAuthorization {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String description;
    private final Price price;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(776699198350477452L, "cm/aptoide/pt/billing/authorization/PayPalAuthorization", 3);
        $jacocoData = probes;
        return probes;
    }

    public PayPalAuthorization(String id, String customerId, Status status, String transactionId, String metadata, Price price2, String description2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(id, customerId, status, transactionId, metadata);
        this.price = price2;
        this.description = description2;
        $jacocoInit[0] = true;
    }

    public Price getPrice() {
        boolean[] $jacocoInit = $jacocoInit();
        Price price2 = this.price;
        $jacocoInit[1] = true;
        return price2;
    }

    public String getDescription() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.description;
        $jacocoInit[2] = true;
        return str;
    }
}
