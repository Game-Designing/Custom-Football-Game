package p005cm.aptoide.p006pt.view.app;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.app.AppRating */
public class AppRating {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final float average;
    private final int total;
    private final List<RatingVote> votes;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8192952075472444241L, "cm/aptoide/pt/view/app/AppRating", 4);
        $jacocoData = probes;
        return probes;
    }

    public AppRating(float average2, int total2, List<RatingVote> votes2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.average = average2;
        this.total = total2;
        this.votes = votes2;
        $jacocoInit[0] = true;
    }

    public float getAverage() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.average;
        $jacocoInit[1] = true;
        return f;
    }

    public int getTotal() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.total;
        $jacocoInit[2] = true;
        return i;
    }

    public List<RatingVote> getVotes() {
        boolean[] $jacocoInit = $jacocoInit();
        List<RatingVote> list = this.votes;
        $jacocoInit[3] = true;
        return list;
    }
}
