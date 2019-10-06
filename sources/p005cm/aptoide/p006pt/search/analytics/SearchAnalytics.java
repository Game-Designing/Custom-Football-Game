package p005cm.aptoide.p006pt.search.analytics;

import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;

/* renamed from: cm.aptoide.pt.search.analytics.SearchAnalytics */
public class SearchAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String AB_SEARCH_ACTION = "AB_Search_Action";
    public static final String AB_SEARCH_IMPRESSION = "AB_Search_Impression";
    public static final String APP_CLICK = "Search_Results_App_View_Click";
    private static final String FROM_AUTOCOMPLETE = "autocomplete";
    private static final String FROM_TRENDING = "trending";
    private static final String MANUAL = "manual";
    public static final String NO_RESULTS = "Search_No_Results";
    public static final String SEARCH = "Search";
    public static final String SEARCH_START = "Search_Start";
    private final AnalyticsManager analyticsManager;
    private final NavigationTracker navigationTracker;

    /* renamed from: cm.aptoide.pt.search.analytics.SearchAnalytics$AttributeKey */
    private static final class AttributeKey {
        private static transient /* synthetic */ boolean[] $jacocoData = null;
        private static final String AB_TEST_GROUP = "ab_test_group";
        private static final String AB_TEST_ID = "ab_test_uid";
        private static final String IS_AD = "is_ad";
        private static final String KEYWORD_INPUT = "inserted_keyword";
        private static final String PACKAGE_NAME = "package_name";
        private static final String POSITION = "position";
        private static final String QUERY = "search_term";
        private static final String SEARCH_TERM_POSITION = "search_term_position";
        private static final String SEARCH_TERM_SOURCE = "search_term_source";
        private static final String SOURCE = "source";

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-8249718980726306503L, "cm/aptoide/pt/search/analytics/SearchAnalytics$AttributeKey", 1);
            $jacocoData = probes;
            return probes;
        }

        private AttributeKey() {
            $jacocoInit()[0] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3380952128357800651L, "cm/aptoide/pt/search/analytics/SearchAnalytics", 35);
        $jacocoData = probes;
        return probes;
    }

    public SearchAnalytics(AnalyticsManager analyticsManager2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManager = analyticsManager2;
        this.navigationTracker = navigationTracker2;
        $jacocoInit[0] = true;
    }

    public void searchFromSuggestion(String query, int suggestionPosition, String inputQuery) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[1] = true;
        if (inputQuery.isEmpty()) {
            $jacocoInit[2] = true;
            str = FROM_TRENDING;
        } else {
            $jacocoInit[3] = true;
            str = FROM_AUTOCOMPLETE;
        }
        String str2 = str;
        $jacocoInit[4] = true;
        search(query, true, suggestionPosition, str2, inputQuery);
        $jacocoInit[5] = true;
    }

    public void search(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        search(query, false, 0, MANUAL, query);
        $jacocoInit[6] = true;
    }

    private void search(String query, boolean isSuggestion, int suggestionPosition, String source, String inputQuery) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[7] = true;
        map.put("search_term", query);
        $jacocoInit[8] = true;
        map.put("search_term_source", source);
        $jacocoInit[9] = true;
        map.put("inserted_keyword", inputQuery);
        if (!isSuggestion) {
            $jacocoInit[10] = true;
        } else {
            $jacocoInit[11] = true;
            map.put("search_term_position", Integer.toString(suggestionPosition));
            $jacocoInit[12] = true;
        }
        this.analyticsManager.logEvent(map, SEARCH, Action.CLICK, getViewName(false));
        $jacocoInit[13] = true;
    }

    public void searchNoResults(String query) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData("search_term", query);
        Action action = Action.CLICK;
        $jacocoInit[14] = true;
        String viewName = getViewName(false);
        $jacocoInit[15] = true;
        analyticsManager2.logEvent(createMapData, NO_RESULTS, action, viewName);
        $jacocoInit[16] = true;
    }

    public void searchAppClick(String query, String packageName, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[17] = true;
        map.put("search_term", query);
        $jacocoInit[18] = true;
        map.put("package_name", packageName);
        $jacocoInit[19] = true;
        map.put("is_ad", Boolean.valueOf(false));
        $jacocoInit[20] = true;
        map.put("position", Integer.valueOf(position));
        $jacocoInit[21] = true;
        this.analyticsManager.logEvent(map, APP_CLICK, Action.CLICK, getViewName(true));
        $jacocoInit[22] = true;
    }

    public void searchAdClick(String query, String packageName, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[23] = true;
        map.put("search_term", query);
        $jacocoInit[24] = true;
        map.put("package_name", packageName);
        $jacocoInit[25] = true;
        map.put("is_ad", Boolean.valueOf(true));
        $jacocoInit[26] = true;
        map.put("position", Integer.valueOf(position));
        $jacocoInit[27] = true;
        this.analyticsManager.logEvent(map, APP_CLICK, Action.CLICK, getViewName(true));
        $jacocoInit[28] = true;
    }

    public void searchStart(SearchSource source, boolean isCurrent) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData("source", source.getIdentifier());
        Action action = Action.CLICK;
        $jacocoInit[29] = true;
        String viewName = getViewName(isCurrent);
        $jacocoInit[30] = true;
        analyticsManager2.logEvent(createMapData, SEARCH_START, action, viewName);
        $jacocoInit[31] = true;
    }

    private Map<String, Object> createMapData(String key, String value) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[32] = true;
        data.put(key, value);
        $jacocoInit[33] = true;
        return data;
    }

    private String getViewName(boolean isCurrent) {
        boolean[] $jacocoInit = $jacocoInit();
        String viewName = this.navigationTracker.getViewName(isCurrent);
        $jacocoInit[34] = true;
        return viewName;
    }
}
