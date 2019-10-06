package p005cm.aptoide.p006pt.search.model;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.search.model.Suggestion */
public class Suggestion {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String icon;
    private String name;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7500836867599249262L, "cm/aptoide/pt/search/model/Suggestion", 3);
        $jacocoData = probes;
        return probes;
    }

    public Suggestion(String name2, String icon2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.name = name2;
        this.icon = icon2;
        $jacocoInit[0] = true;
    }

    public String getName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.name;
        $jacocoInit[1] = true;
        return str;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[2] = true;
        return str;
    }
}
