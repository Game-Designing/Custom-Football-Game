package p005cm.aptoide.p006pt.reactions;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.reactions.UserReaction */
class UserReaction {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String reaction;
    private final String userId;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2055815753877798584L, "cm/aptoide/pt/reactions/UserReaction", 3);
        $jacocoData = probes;
        return probes;
    }

    public UserReaction(String userId2, String reaction2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.userId = userId2;
        this.reaction = reaction2;
        $jacocoInit[0] = true;
    }

    public String getUserId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.userId;
        $jacocoInit[1] = true;
        return str;
    }

    public String getReaction() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.reaction;
        $jacocoInit[2] = true;
        return str;
    }
}
