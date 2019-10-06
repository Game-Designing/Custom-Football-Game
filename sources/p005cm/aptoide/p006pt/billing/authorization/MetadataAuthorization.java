package p005cm.aptoide.p006pt.billing.authorization;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.authorization.Authorization.Status;

/* renamed from: cm.aptoide.pt.billing.authorization.MetadataAuthorization */
public class MetadataAuthorization extends Authorization {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String metadata;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3789240462610826454L, "cm/aptoide/pt/billing/authorization/MetadataAuthorization", 2);
        $jacocoData = probes;
        return probes;
    }

    public MetadataAuthorization(String id, String customerId, Status status, String transactionId, String metadata2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(id, customerId, status, transactionId);
        this.metadata = metadata2;
        $jacocoInit[0] = true;
    }

    public String getMetadata() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.metadata;
        $jacocoInit[1] = true;
        return str;
    }
}
