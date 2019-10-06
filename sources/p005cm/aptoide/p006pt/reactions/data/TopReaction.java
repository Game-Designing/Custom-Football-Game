package p005cm.aptoide.p006pt.reactions.data;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.reactions.data.TopReaction */
public class TopReaction {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final int total;
    private final String type;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2226229508543142789L, "cm/aptoide/pt/reactions/data/TopReaction", 3);
        $jacocoData = probes;
        return probes;
    }

    public TopReaction(String type2, int total2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.type = type2;
        this.total = total2;
        $jacocoInit[0] = true;
    }

    public String getType() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.type;
        $jacocoInit[1] = true;
        return str;
    }

    public int getTotal() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.total;
        $jacocoInit[2] = true;
        return i;
    }
}
