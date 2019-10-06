package p005cm.aptoide.p006pt.billing.authorization;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.authorization.Authorization.Status;

/* renamed from: cm.aptoide.pt.billing.authorization.AdyenAuthorization */
public class AdyenAuthorization extends MetadataAuthorization {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String session;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-275107976048819929L, "cm/aptoide/pt/billing/authorization/AdyenAuthorization", 2);
        $jacocoData = probes;
        return probes;
    }

    public AdyenAuthorization(String id, String customerId, Status status, String transactionId, String session2, String metadata) {
        boolean[] $jacocoInit = $jacocoInit();
        super(id, customerId, status, transactionId, metadata);
        this.session = session2;
        $jacocoInit[0] = true;
    }

    public String getSession() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.session;
        $jacocoInit[1] = true;
        return str;
    }
}
