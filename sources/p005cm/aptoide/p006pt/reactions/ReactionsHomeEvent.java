package p005cm.aptoide.p006pt.reactions;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.EditorialHomeEvent;
import p005cm.aptoide.p006pt.home.HomeBundle;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;

/* renamed from: cm.aptoide.pt.reactions.ReactionsHomeEvent */
public class ReactionsHomeEvent extends EditorialHomeEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String reaction;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8435109500579499036L, "cm/aptoide/pt/reactions/ReactionsHomeEvent", 2);
        $jacocoData = probes;
        return probes;
    }

    public ReactionsHomeEvent(String cardId, String groupId, HomeBundle bundle, int bundlePosition, Type clickType, String reaction2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(cardId, groupId, bundle, bundlePosition, clickType);
        this.reaction = reaction2;
        $jacocoInit[0] = true;
    }

    public String getReaction() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.reaction;
        $jacocoInit[1] = true;
        return str;
    }
}
