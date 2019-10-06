package p005cm.aptoide.p006pt.autoupdate;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.autoupdate.AbSearchGroupResponse */
public class AbSearchGroupResponse {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String abSearchId;
    private int items;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(978945804589428199L, "cm/aptoide/pt/autoupdate/AbSearchGroupResponse", 5);
        $jacocoData = probes;
        return probes;
    }

    public AbSearchGroupResponse() {
        $jacocoInit()[0] = true;
    }

    public String getAbSearchId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.abSearchId;
        $jacocoInit[1] = true;
        return str;
    }

    public void setAbSearchId(String abSearchId2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.abSearchId = abSearchId2;
        $jacocoInit[2] = true;
    }

    public int getItems() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.items;
        $jacocoInit[3] = true;
        return i;
    }

    public void setItems(int items2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.items = items2;
        $jacocoInit[4] = true;
    }
}
