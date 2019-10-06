package p005cm.aptoide.p006pt.editorialList;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.editorialList.EditorialListEvent */
class EditorialListEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String cardId;
    private final int position;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7823203077082047256L, "cm/aptoide/pt/editorialList/EditorialListEvent", 3);
        $jacocoData = probes;
        return probes;
    }

    public EditorialListEvent(String cardId2, int position2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.cardId = cardId2;
        this.position = position2;
        $jacocoInit[0] = true;
    }

    public String getCardId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.cardId;
        $jacocoInit[1] = true;
        return str;
    }

    public int getPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.position;
        $jacocoInit[2] = true;
        return i;
    }
}
