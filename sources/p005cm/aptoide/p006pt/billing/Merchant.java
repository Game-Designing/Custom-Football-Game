package p005cm.aptoide.p006pt.billing;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.billing.Merchant */
public class Merchant {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: id */
    private final long f5356id;
    private final String name;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1491562035911442067L, "cm/aptoide/pt/billing/Merchant", 3);
        $jacocoData = probes;
        return probes;
    }

    public Merchant(long id, String name2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.f5356id = id;
        this.name = name2;
        $jacocoInit[0] = true;
    }

    public long getId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.f5356id;
        $jacocoInit[1] = true;
        return j;
    }

    public String getName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.name;
        $jacocoInit[2] = true;
        return str;
    }
}
