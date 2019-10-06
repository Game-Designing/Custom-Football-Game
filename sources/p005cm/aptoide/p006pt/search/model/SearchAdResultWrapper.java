package p005cm.aptoide.p006pt.search.model;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.search.model.SearchAdResultWrapper */
public class SearchAdResultWrapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private int position;
    private SearchAdResult searchAdResult;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1507718496021448486L, "cm/aptoide/pt/search/model/SearchAdResultWrapper", 3);
        $jacocoData = probes;
        return probes;
    }

    public SearchAdResultWrapper(SearchAdResult searchAdResult2, int position2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.searchAdResult = searchAdResult2;
        this.position = position2;
        $jacocoInit[0] = true;
    }

    public SearchAdResult getSearchAdResult() {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAdResult searchAdResult2 = this.searchAdResult;
        $jacocoInit[1] = true;
        return searchAdResult2;
    }

    public int getPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.position;
        $jacocoInit[2] = true;
        return i;
    }
}
