package p005cm.aptoide.p006pt.search.model;

import java.util.LinkedList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.search.view.SearchResultView.Model;

/* renamed from: cm.aptoide.pt.search.model.SearchViewModel */
public class SearchViewModel implements Model {
    private static transient /* synthetic */ boolean[] $jacocoData;
    int allStoresOffset;
    List<SearchAdResult> allStoresSearchAdResults;
    List<SearchAppResult> allStoresSearchAppResults;
    boolean allStoresSelected;
    String currentQuery;
    int followedStoresOffset;
    List<SearchAdResult> followedStoresSearchAdResults;
    List<SearchAppResult> followedStoresSearchAppResults;
    boolean loadedAds;
    boolean onlyTrustedApps;
    boolean reachedBottomAllStores;
    boolean reachedBottomFollowedStores;
    String storeName;
    private String storeTheme;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3792129020119003372L, "cm/aptoide/pt/search/model/SearchViewModel", 48);
        $jacocoData = probes;
        return probes;
    }

    public SearchViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        this.allStoresOffset = 0;
        this.followedStoresOffset = 0;
        this.reachedBottomAllStores = false;
        this.reachedBottomFollowedStores = false;
        this.loadedAds = false;
        $jacocoInit[0] = true;
        this.allStoresSearchAppResults = new LinkedList();
        $jacocoInit[1] = true;
        this.allStoresSearchAdResults = new LinkedList();
        $jacocoInit[2] = true;
        this.followedStoresSearchAppResults = new LinkedList();
        $jacocoInit[3] = true;
        this.followedStoresSearchAdResults = new LinkedList();
        $jacocoInit[4] = true;
    }

    public SearchViewModel(String currentQuery2, String storeName2, boolean onlyTrustedApps2, boolean allStoresSelected2, List<SearchAppResult> allStoresSearchAppResults2, List<SearchAdResult> allStoresSearchAdResults2, List<SearchAppResult> followedStoresSearchAppResults2, List<SearchAdResult> followedStoresSearchAdResults2, String storeTheme2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.allStoresOffset = 0;
        this.followedStoresOffset = 0;
        this.reachedBottomAllStores = false;
        this.reachedBottomFollowedStores = false;
        this.loadedAds = false;
        this.currentQuery = currentQuery2;
        this.storeName = storeName2;
        this.onlyTrustedApps = onlyTrustedApps2;
        this.allStoresSelected = allStoresSelected2;
        this.allStoresSearchAppResults = allStoresSearchAppResults2;
        this.allStoresSearchAdResults = allStoresSearchAdResults2;
        this.followedStoresSearchAppResults = followedStoresSearchAppResults2;
        this.followedStoresSearchAdResults = followedStoresSearchAdResults2;
        this.storeTheme = storeTheme2;
        $jacocoInit[5] = true;
    }

    public SearchViewModel(String currentQuery2, boolean onlyTrustedApps2) {
        boolean[] $jacocoInit = $jacocoInit();
        this(currentQuery2, null, onlyTrustedApps2, true, new LinkedList(), new LinkedList(), new LinkedList(), new LinkedList(), "");
        $jacocoInit[6] = true;
    }

    public SearchViewModel(String currentQuery2, String storeName2, String storeTheme2) {
        boolean[] $jacocoInit = $jacocoInit();
        this(currentQuery2, storeName2, true, true, new LinkedList(), new LinkedList(), new LinkedList(), new LinkedList(), storeTheme2);
        $jacocoInit[7] = true;
    }

    public List<SearchAppResult> getFollowedStoresSearchAppResults() {
        boolean[] $jacocoInit = $jacocoInit();
        List<SearchAppResult> list = this.followedStoresSearchAppResults;
        $jacocoInit[8] = true;
        return list;
    }

    public List<SearchAdResult> getFollowedStoresSearchAdResults() {
        boolean[] $jacocoInit = $jacocoInit();
        List<SearchAdResult> list = this.followedStoresSearchAdResults;
        $jacocoInit[9] = true;
        return list;
    }

    public String getCurrentQuery() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.currentQuery;
        $jacocoInit[10] = true;
        return str;
    }

    public String getStoreName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeName;
        $jacocoInit[11] = true;
        return str;
    }

    public String getStoreTheme() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeTheme;
        $jacocoInit[12] = true;
        return str;
    }

    public boolean isOnlyTrustedApps() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.onlyTrustedApps;
        $jacocoInit[13] = true;
        return z;
    }

    public boolean isAllStoresSelected() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.allStoresSelected;
        $jacocoInit[14] = true;
        return z;
    }

    public void setAllStoresSelected(boolean allStoresSelected2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.allStoresSelected = allStoresSelected2;
        $jacocoInit[15] = true;
    }

    public int getAllStoresOffset() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.allStoresOffset;
        $jacocoInit[16] = true;
        return i;
    }

    public int getFollowedStoresOffset() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.followedStoresOffset;
        $jacocoInit[17] = true;
        return i;
    }

    public boolean hasReachedBottomOfAllStores() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.reachedBottomAllStores;
        $jacocoInit[18] = true;
        return z;
    }

    public boolean hasReachedBottomOfFollowedStores() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.reachedBottomFollowedStores;
        $jacocoInit[19] = true;
        return z;
    }

    public void incrementOffsetAndCheckIfReachedBottomOfFollowedStores(int offset) {
        boolean[] $jacocoInit = $jacocoInit();
        this.followedStoresOffset += offset;
        if (offset != 0) {
            $jacocoInit[20] = true;
        } else {
            this.reachedBottomFollowedStores = true;
            $jacocoInit[21] = true;
        }
        $jacocoInit[22] = true;
    }

    public void incrementOffsetAndCheckIfReachedBottomOfAllStores(int offset) {
        boolean[] $jacocoInit = $jacocoInit();
        this.allStoresOffset += offset;
        if (offset != 0) {
            $jacocoInit[23] = true;
        } else {
            this.reachedBottomAllStores = true;
            $jacocoInit[24] = true;
        }
        $jacocoInit[25] = true;
    }

    public boolean hasLoadedAds() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.loadedAds;
        $jacocoInit[26] = true;
        return z;
    }

    public void setHasLoadedAds() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loadedAds = true;
        $jacocoInit[27] = true;
    }

    public List<SearchAppResult> getAllStoresSearchAppResults() {
        boolean[] $jacocoInit = $jacocoInit();
        List<SearchAppResult> list = this.allStoresSearchAppResults;
        $jacocoInit[28] = true;
        return list;
    }

    public List<SearchAdResult> getAllStoresSearchAdResults() {
        boolean[] $jacocoInit = $jacocoInit();
        List<SearchAdResult> list = this.allStoresSearchAdResults;
        $jacocoInit[29] = true;
        return list;
    }

    public boolean hasData() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        List<SearchAppResult> list = this.allStoresSearchAppResults;
        if (list == null) {
            $jacocoInit[30] = true;
        } else if (list.size() > 0) {
            $jacocoInit[31] = true;
            $jacocoInit[37] = true;
            z = true;
            $jacocoInit[39] = true;
            return z;
        } else {
            $jacocoInit[32] = true;
        }
        List<SearchAppResult> list2 = this.followedStoresSearchAppResults;
        if (list2 == null) {
            $jacocoInit[33] = true;
        } else {
            $jacocoInit[34] = true;
            if (list2.size() <= 0) {
                $jacocoInit[35] = true;
            } else {
                $jacocoInit[36] = true;
                $jacocoInit[37] = true;
                z = true;
                $jacocoInit[39] = true;
                return z;
            }
        }
        z = false;
        $jacocoInit[38] = true;
        $jacocoInit[39] = true;
        return z;
    }

    public void clearListData() {
        boolean[] $jacocoInit = $jacocoInit();
        this.allStoresSearchAdResults.clear();
        $jacocoInit[40] = true;
        this.allStoresSearchAppResults.clear();
        $jacocoInit[41] = true;
        this.followedStoresSearchAdResults.clear();
        $jacocoInit[42] = true;
        this.followedStoresSearchAppResults.clear();
        $jacocoInit[43] = true;
    }

    public void addAllStoresSearchAdResults(List<SearchAdResult> allStoresSearchAdResults2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.allStoresSearchAdResults.addAll(allStoresSearchAdResults2);
        $jacocoInit[44] = true;
    }

    public void addFollowedStoresSearchAppResults(List<SearchAppResult> followedStoresSearchAppResults2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.followedStoresSearchAppResults.addAll(followedStoresSearchAppResults2);
        $jacocoInit[45] = true;
    }

    public void addFollowedStoresSearchAdResults(List<SearchAdResult> followedStoresSearchAdResults2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.followedStoresSearchAdResults.addAll(followedStoresSearchAdResults2);
        $jacocoInit[46] = true;
    }

    public void addAllStoresSearchAppResults(List<SearchAppResult> allStoresSearchAppResults2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.allStoresSearchAppResults.addAll(allStoresSearchAppResults2);
        $jacocoInit[47] = true;
    }
}
