package p005cm.aptoide.p006pt.search.suggestions;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.search.suggestions.SearchQueryEvent */
public class SearchQueryEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final boolean isSubmitted;
    private final boolean isSuggestion;
    private final int position;
    private final String query;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6700117616352284843L, "cm/aptoide/pt/search/suggestions/SearchQueryEvent", 11);
        $jacocoData = probes;
        return probes;
    }

    public SearchQueryEvent(String query2, boolean isSubmitted2) {
        boolean[] $jacocoInit = $jacocoInit();
        this(query2, 0, isSubmitted2, false);
        $jacocoInit[0] = true;
    }

    public SearchQueryEvent(String query2, int position2, boolean isSubmitted2, boolean isSuggestion2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.query = query2;
        this.position = position2;
        this.isSubmitted = isSubmitted2;
        this.isSuggestion = isSuggestion2;
        $jacocoInit[1] = true;
    }

    public String getQuery() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.query;
        $jacocoInit[2] = true;
        return str;
    }

    public boolean hasQuery() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.query;
        if (str == null) {
            $jacocoInit[3] = true;
        } else if (str.isEmpty()) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            z = true;
            $jacocoInit[7] = true;
            return z;
        }
        z = false;
        $jacocoInit[6] = true;
        $jacocoInit[7] = true;
        return z;
    }

    public int getPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.position;
        $jacocoInit[8] = true;
        return i;
    }

    public boolean isSubmitted() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isSubmitted;
        $jacocoInit[9] = true;
        return z;
    }

    public boolean isSuggestion() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isSuggestion;
        $jacocoInit[10] = true;
        return z;
    }
}
