package p005cm.aptoide.p006pt.reactions;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.reactions.ReactionEvent */
public class ReactionEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String cardId;
    private final String groupId;
    private final String reactionType;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7546370584199615990L, "cm/aptoide/pt/reactions/ReactionEvent", 4);
        $jacocoData = probes;
        return probes;
    }

    public ReactionEvent(String cardId2, String reactionType2, String groupId2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.cardId = cardId2;
        this.reactionType = reactionType2;
        this.groupId = groupId2;
        $jacocoInit[0] = true;
    }

    public String getCardId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.cardId;
        $jacocoInit[1] = true;
        return str;
    }

    public String getReactionType() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.reactionType;
        $jacocoInit[2] = true;
        return str;
    }

    public String getGroupId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.groupId;
        $jacocoInit[3] = true;
        return str;
    }
}
