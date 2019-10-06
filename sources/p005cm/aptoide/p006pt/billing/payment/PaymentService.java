package p005cm.aptoide.p006pt.billing.payment;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.billing.payment.PaymentService */
public class PaymentService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String description;
    private final String icon;

    /* renamed from: id */
    private final String f5470id;
    private final String name;
    private final String type;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3548151823201993836L, "cm/aptoide/pt/billing/payment/PaymentService", 6);
        $jacocoData = probes;
        return probes;
    }

    public PaymentService(String id, String type2, String name2, String description2, String icon2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.f5470id = id;
        this.type = type2;
        this.name = name2;
        this.description = description2;
        this.icon = icon2;
        $jacocoInit[0] = true;
    }

    public String getId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.f5470id;
        $jacocoInit[1] = true;
        return str;
    }

    public String getName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.name;
        $jacocoInit[2] = true;
        return str;
    }

    public String getType() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.type;
        $jacocoInit[3] = true;
        return str;
    }

    public String getDescription() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.description;
        $jacocoInit[4] = true;
        return str;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[5] = true;
        return str;
    }
}
