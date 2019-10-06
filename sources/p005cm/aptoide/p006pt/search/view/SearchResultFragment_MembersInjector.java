package p005cm.aptoide.p006pt.search.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.search.view.SearchResultFragment_MembersInjector */
public final class SearchResultFragment_MembersInjector implements C13183b<SearchResultFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<SearchResultPresenter> searchResultPresenterProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4742362368186456576L, "cm/aptoide/pt/search/view/SearchResultFragment_MembersInjector", 7);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((SearchResultFragment) obj);
        $jacocoInit[6] = true;
    }

    public SearchResultFragment_MembersInjector(Provider<SearchResultPresenter> searchResultPresenterProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.searchResultPresenterProvider = searchResultPresenterProvider2;
        this.themeProvider = themeProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<SearchResultFragment> create(Provider<SearchResultPresenter> searchResultPresenterProvider2, Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        SearchResultFragment_MembersInjector searchResultFragment_MembersInjector = new SearchResultFragment_MembersInjector(searchResultPresenterProvider2, themeProvider2);
        $jacocoInit[1] = true;
        return searchResultFragment_MembersInjector;
    }

    public void injectMembers(SearchResultFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectSearchResultPresenter(instance, (SearchResultPresenter) this.searchResultPresenterProvider.get());
        $jacocoInit[2] = true;
        injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[3] = true;
    }

    public static void injectSearchResultPresenter(SearchResultFragment instance, SearchResultPresenter searchResultPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.searchResultPresenter = searchResultPresenter;
        $jacocoInit[4] = true;
    }

    public static void injectTheme(SearchResultFragment instance, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.theme = theme;
        $jacocoInit[5] = true;
    }
}
