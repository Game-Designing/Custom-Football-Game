package p005cm.aptoide.p006pt.view.app;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.app.AppFlags */
public class AppFlags {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String review;
    private final List<FlagsVote> votes;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8044457540654365718L, "cm/aptoide/pt/view/app/AppFlags", 3);
        $jacocoData = probes;
        return probes;
    }

    public AppFlags(String review2, List<FlagsVote> votes2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.review = review2;
        this.votes = votes2;
        $jacocoInit[0] = true;
    }

    public List<FlagsVote> getVotes() {
        boolean[] $jacocoInit = $jacocoInit();
        List<FlagsVote> list = this.votes;
        $jacocoInit[1] = true;
        return list;
    }

    public String getReview() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.review;
        $jacocoInit[2] = true;
        return str;
    }
}
