package p005cm.aptoide.p006pt.view.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.app.RatingVote */
public class RatingVote {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final int count;
    private final int value;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5899568140899172882L, "cm/aptoide/pt/view/app/RatingVote", 3);
        $jacocoData = probes;
        return probes;
    }

    public RatingVote(int count2, int value2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.count = count2;
        this.value = value2;
        $jacocoInit[0] = true;
    }

    public int getCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.count;
        $jacocoInit[1] = true;
        return i;
    }

    public int getValue() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.value;
        $jacocoInit[2] = true;
        return i;
    }
}
