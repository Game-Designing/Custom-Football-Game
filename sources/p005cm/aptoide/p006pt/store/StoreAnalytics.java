package p005cm.aptoide.p006pt.store;

import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;

/* renamed from: cm.aptoide.pt.store.StoreAnalytics */
public class StoreAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String ACTION = "action";
    private static final String FOLLOW_STORE_APPS = "follow_store_apps";
    private static final String FOLLOW_STORE_FOLLOWERS = "follow_store_followers";
    private static final String SOURCE = "source";
    public static final String STORES_INTERACT = "Store_Interact";
    public static final String STORES_OPEN = "Store_Open";
    public static final String STORES_TAB_INTERACT = "Stores_Tab_Interact";
    private static final String STORE_NAME = "store_name";
    private static final String TAB = "tab_name";
    private final AnalyticsManager analyticsManager;
    private final NavigationTracker navigationTracker;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8236632245664601273L, "cm/aptoide/pt/store/StoreAnalytics", 36);
        $jacocoData = probes;
        return probes;
    }

    public StoreAnalytics(AnalyticsManager analyticsManager2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManager = analyticsManager2;
        this.navigationTracker = navigationTracker2;
        $jacocoInit[0] = true;
    }

    public void sendStoreTabInteractEvent(String action, boolean isCurrent) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createStoreInteractMap = createStoreInteractMap(action);
        Action action2 = Action.CLICK;
        $jacocoInit[1] = true;
        String viewName = getViewName(isCurrent);
        $jacocoInit[2] = true;
        analyticsManager2.logEvent(createStoreInteractMap, STORES_TAB_INTERACT, action2, viewName);
        $jacocoInit[3] = true;
    }

    public void sendStoreTabInteractEvent(String action, int storeAppsNumber, int storeFollowers) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        $jacocoInit[4] = true;
        Map createStoreTabInteractDataMap = createStoreTabInteractDataMap(action, storeAppsNumber, storeFollowers);
        Action action2 = Action.CLICK;
        $jacocoInit[5] = true;
        String viewName = getViewName(true);
        $jacocoInit[6] = true;
        analyticsManager2.logEvent(createStoreTabInteractDataMap, STORES_TAB_INTERACT, action2, viewName);
        $jacocoInit[7] = true;
    }

    public void sendFollowersStoresInteractEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[8] = true;
        map.put("action", "Open Followers");
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        $jacocoInit[9] = true;
        String viewName = getViewName(true);
        $jacocoInit[10] = true;
        analyticsManager2.logEvent(map, STORES_TAB_INTERACT, action, viewName);
        $jacocoInit[11] = true;
    }

    public void sendFollowingStoresInteractEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[12] = true;
        map.put("action", "Open Following");
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        $jacocoInit[13] = true;
        String viewName = getViewName(true);
        $jacocoInit[14] = true;
        analyticsManager2.logEvent(map, STORES_TAB_INTERACT, action, viewName);
        $jacocoInit[15] = true;
    }

    public void sendStoreOpenEvent(String source, String storeName, boolean isCurrent) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createStoreOpenDataMap = createStoreOpenDataMap(source, storeName);
        Action action = Action.CLICK;
        $jacocoInit[16] = true;
        String viewName = getViewName(isCurrent);
        $jacocoInit[17] = true;
        analyticsManager2.logEvent(createStoreOpenDataMap, STORES_OPEN, action, viewName);
        $jacocoInit[18] = true;
    }

    public void sendStoreInteractEvent(String action, String tab, String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createStoreInteractDataMap = createStoreInteractDataMap(action, tab, storeName);
        Action action2 = Action.CLICK;
        $jacocoInit[19] = true;
        String viewName = getViewName(true);
        $jacocoInit[20] = true;
        analyticsManager2.logEvent(createStoreInteractDataMap, STORES_INTERACT, action2, viewName);
        $jacocoInit[21] = true;
    }

    private Map<String, Object> createStoreInteractDataMap(String action, String tab, String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[22] = true;
        map.put("action", action);
        $jacocoInit[23] = true;
        map.put(TAB, tab);
        $jacocoInit[24] = true;
        map.put("store_name", storeName);
        $jacocoInit[25] = true;
        return map;
    }

    private Map<String, Object> createStoreInteractMap(String action) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[26] = true;
        map.put("action", action);
        $jacocoInit[27] = true;
        return map;
    }

    private Map<String, Object> createStoreOpenDataMap(String source, String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[28] = true;
        map.put(SOURCE, source);
        $jacocoInit[29] = true;
        map.put("store_name", storeName);
        $jacocoInit[30] = true;
        return map;
    }

    private Map<String, Object> createStoreTabInteractDataMap(String action, int storeAppsNumber, int storeFollowers) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[31] = true;
        map.put("action", action);
        $jacocoInit[32] = true;
        map.put(FOLLOW_STORE_APPS, StringU.toString(Integer.valueOf(storeAppsNumber)));
        $jacocoInit[33] = true;
        map.put(FOLLOW_STORE_FOLLOWERS, StringU.toString(Integer.valueOf(storeFollowers)));
        $jacocoInit[34] = true;
        return map;
    }

    private String getViewName(boolean isCurrent) {
        boolean[] $jacocoInit = $jacocoInit();
        String viewName = this.navigationTracker.getViewName(isCurrent);
        $jacocoInit[35] = true;
        return viewName;
    }
}
