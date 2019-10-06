package p005cm.aptoide.p006pt.view.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.app.FlagsVote */
public class FlagsVote {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final int count;
    private final VoteType voteType;

    /* renamed from: cm.aptoide.pt.view.app.FlagsVote$VoteType */
    public enum VoteType {
        FAKE,
        FREEZE,
        GOOD,
        LICENSE,
        VIRUS;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8538197271589477056L, "cm/aptoide/pt/view/app/FlagsVote", 3);
        $jacocoData = probes;
        return probes;
    }

    public FlagsVote(int count2, VoteType voteType2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.count = count2;
        this.voteType = voteType2;
        $jacocoInit[0] = true;
    }

    public int getCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.count;
        $jacocoInit[1] = true;
        return i;
    }

    public VoteType getVoteType() {
        boolean[] $jacocoInit = $jacocoInit();
        VoteType voteType2 = this.voteType;
        $jacocoInit[2] = true;
        return voteType2;
    }
}
