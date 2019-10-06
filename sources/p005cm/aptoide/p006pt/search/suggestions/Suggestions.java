package p005cm.aptoide.p006pt.search.suggestions;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.search.suggestions.Suggestions */
public class Suggestions {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private List<String> data;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(351431364413783020L, "cm/aptoide/pt/search/suggestions/Suggestions", 2);
        $jacocoData = probes;
        return probes;
    }

    public Suggestions() {
        $jacocoInit()[0] = true;
    }

    public List<String> getData() {
        boolean[] $jacocoInit = $jacocoInit();
        List<String> list = this.data;
        $jacocoInit[1] = true;
        return list;
    }
}
