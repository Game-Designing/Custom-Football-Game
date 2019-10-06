package p005cm.aptoide.p006pt.home;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;

/* renamed from: cm.aptoide.pt.home.EditorialHomeEvent */
public class EditorialHomeEvent extends HomeEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String cardId;
    private final String groupId;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1367781709676517334L, "cm/aptoide/pt/home/EditorialHomeEvent", 3);
        $jacocoData = probes;
        return probes;
    }

    public EditorialHomeEvent(String cardId2, String groupId2, HomeBundle bundle, int bundlePosition, Type clickType) {
        boolean[] $jacocoInit = $jacocoInit();
        super(bundle, bundlePosition, clickType);
        this.cardId = cardId2;
        this.groupId = groupId2;
        $jacocoInit[0] = true;
    }

    public String getCardId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.cardId;
        $jacocoInit[1] = true;
        return str;
    }

    public String getGroupId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.groupId;
        $jacocoInit[2] = true;
        return str;
    }
}
