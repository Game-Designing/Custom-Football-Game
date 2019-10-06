package p005cm.aptoide.p006pt.search;

import android.support.p000v4.app.Fragment;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.search.view.SearchResultFragment;

/* renamed from: cm.aptoide.pt.search.SearchNavigator */
public class SearchNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AppNavigator appNavigator;
    private final FragmentNavigator navigator;
    private final String storeName;
    private final String storeTheme;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7130600306229737355L, "cm/aptoide/pt/search/SearchNavigator", 12);
        $jacocoData = probes;
        return probes;
    }

    public SearchNavigator(FragmentNavigator navigator2, AppNavigator appNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = "";
        this(navigator2, str, str, appNavigator2);
        $jacocoInit[0] = true;
    }

    public SearchNavigator(FragmentNavigator navigator2, String storeName2, String storeTheme2, AppNavigator appNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator = navigator2;
        this.storeName = storeName2;
        this.storeTheme = storeTheme2;
        this.appNavigator = appNavigator2;
        $jacocoInit[1] = true;
    }

    public void navigate(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.navigateTo(resolveFragment(query), true);
        $jacocoInit[2] = true;
    }

    public SearchResultFragment resolveFragment(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeName;
        if (str == null) {
            $jacocoInit[3] = true;
        } else if (str.length() <= 0) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            SearchResultFragment newInstance = SearchResultFragment.newInstance(query, this.storeName, this.storeTheme);
            $jacocoInit[6] = true;
            return newInstance;
        }
        SearchResultFragment newInstance2 = SearchResultFragment.newInstance(query);
        $jacocoInit[7] = true;
        return newInstance2;
    }

    public void goToAppView(long appId, String packageName, String storeTheme2, String storeName2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithStore(appId, packageName, storeTheme2, storeName2);
        $jacocoInit[8] = true;
    }

    public void goToAppView(SearchAdResult searchAdResult) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appNavigator.navigateWithAd(searchAdResult, null);
        $jacocoInit[9] = true;
    }

    public void goToSearchFragment(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        Fragment fragment = SearchResultFragment.newInstance(query);
        $jacocoInit[10] = true;
        this.navigator.navigateTo(fragment, true);
        $jacocoInit[11] = true;
    }
}
