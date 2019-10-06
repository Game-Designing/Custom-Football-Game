package p005cm.aptoide.p006pt.app.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.app.view.ReadMoreClickEvent */
public class ReadMoreClickEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String description;
    private String storeName;
    private String storeTheme;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6228256136089909845L, "cm/aptoide/pt/app/view/ReadMoreClickEvent", 4);
        $jacocoData = probes;
        return probes;
    }

    public ReadMoreClickEvent(String storeName2, String description2, String storeTheme2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeName = storeName2;
        this.description = description2;
        this.storeTheme = storeTheme2;
        $jacocoInit[0] = true;
    }

    public String getStoreName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeName;
        $jacocoInit[1] = true;
        return str;
    }

    public String getDescription() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.description;
        $jacocoInit[2] = true;
        return str;
    }

    public String getStoreTheme() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeTheme;
        $jacocoInit[3] = true;
        return str;
    }
}
