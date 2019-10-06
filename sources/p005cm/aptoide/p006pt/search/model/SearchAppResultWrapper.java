package p005cm.aptoide.p006pt.search.model;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.search.model.SearchAppResultWrapper */
public class SearchAppResultWrapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private int position;
    private String query;
    private SearchAppResult searchAppResult;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5565109376853317106L, "cm/aptoide/pt/search/model/SearchAppResultWrapper", 6);
        $jacocoData = probes;
        return probes;
    }

    public SearchAppResultWrapper() {
        $jacocoInit()[0] = true;
    }

    public SearchAppResultWrapper(String query2, SearchAppResult result, int position2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.query = query2;
        this.searchAppResult = result;
        this.position = position2;
        $jacocoInit[1] = true;
    }

    public SearchAppResult getSearchAppResult() {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAppResult searchAppResult2 = this.searchAppResult;
        $jacocoInit[2] = true;
        return searchAppResult2;
    }

    public int getPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.position;
        $jacocoInit[3] = true;
        return i;
    }

    public String getQuery() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.query;
        $jacocoInit[4] = true;
        return str;
    }

    public void setQuery(String query2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.query = query2;
        $jacocoInit[5] = true;
    }
}
