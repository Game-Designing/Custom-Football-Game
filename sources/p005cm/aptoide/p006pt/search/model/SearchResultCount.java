package p005cm.aptoide.p006pt.search.model;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.search.view.SearchResultView.Model;

/* renamed from: cm.aptoide.pt.search.model.SearchResultCount */
public class SearchResultCount {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private int resultCount;
    private Model searchResultViewModel;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(688221535044003143L, "cm/aptoide/pt/search/model/SearchResultCount", 5);
        $jacocoData = probes;
        return probes;
    }

    public SearchResultCount(int resultCount2, Model searchResultViewModel2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.resultCount = resultCount2;
        this.searchResultViewModel = searchResultViewModel2;
        $jacocoInit[0] = true;
    }

    public int getResultCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.resultCount;
        $jacocoInit[1] = true;
        return i;
    }

    public void setResultCount(int resultCount2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.resultCount = resultCount2;
        $jacocoInit[2] = true;
    }

    public Model getSearchResultViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        Model model = this.searchResultViewModel;
        $jacocoInit[3] = true;
        return model;
    }

    public void setSearchResultViewModel(Model searchResultViewModel2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.searchResultViewModel = searchResultViewModel2;
        $jacocoInit[4] = true;
    }
}
