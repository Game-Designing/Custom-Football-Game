package p005cm.aptoide.p006pt.blacklist;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.blacklist.BlacklistUnit */
public class BlacklistUnit {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: id */
    private String f5809id;
    private int maxImpressions;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7693616372783635160L, "cm/aptoide/pt/blacklist/BlacklistUnit", 3);
        $jacocoData = probes;
        return probes;
    }

    public BlacklistUnit(String id, int maxImpressions2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.f5809id = id;
        this.maxImpressions = maxImpressions2;
        $jacocoInit[0] = true;
    }

    public String getId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.f5809id;
        $jacocoInit[1] = true;
        return str;
    }

    public int getMaxImpressions() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.maxImpressions;
        $jacocoInit[2] = true;
        return i;
    }
}
