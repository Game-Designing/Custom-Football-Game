package p005cm.aptoide.p006pt.billing.authorization;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.billing.authorization.LocalIdGenerator */
public class LocalIdGenerator {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3140268111854375117L, "cm/aptoide/pt/billing/authorization/LocalIdGenerator", 3);
        $jacocoData = probes;
        return probes;
    }

    public LocalIdGenerator() {
        $jacocoInit()[0] = true;
    }

    public String generate() {
        $jacocoInit()[1] = true;
        return "-1";
    }

    public boolean isLocal(String id) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean equals = id.equals("-1");
        $jacocoInit[2] = true;
        return equals;
    }
}
