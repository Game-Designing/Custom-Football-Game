package p005cm.aptoide.p006pt.reactions.network;

import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.reactions.data.TopReaction;

/* renamed from: cm.aptoide.pt.reactions.network.LoadReactionModel */
public class LoadReactionModel {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String myReaction;
    private final List<TopReaction> topReactionList;
    private final int total;
    private final String userId;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(622794905291182962L, "cm/aptoide/pt/reactions/network/LoadReactionModel", 7);
        $jacocoData = probes;
        return probes;
    }

    public LoadReactionModel(int total2, String myReaction2, String userId2, List<TopReaction> topReactionList2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.userId = userId2;
        this.topReactionList = topReactionList2;
        this.total = total2;
        this.myReaction = myReaction2;
        $jacocoInit[0] = true;
    }

    public LoadReactionModel() {
        boolean[] $jacocoInit = $jacocoInit();
        this.total = -1;
        String str = "";
        this.myReaction = str;
        this.userId = str;
        $jacocoInit[1] = true;
        this.topReactionList = Collections.emptyList();
        $jacocoInit[2] = true;
    }

    public List<TopReaction> getTopReactionList() {
        boolean[] $jacocoInit = $jacocoInit();
        List<TopReaction> list = this.topReactionList;
        $jacocoInit[3] = true;
        return list;
    }

    public int getTotal() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.total;
        $jacocoInit[4] = true;
        return i;
    }

    public String getMyReaction() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.myReaction;
        $jacocoInit[5] = true;
        return str;
    }

    public String getUserId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.userId;
        $jacocoInit[6] = true;
        return str;
    }
}
