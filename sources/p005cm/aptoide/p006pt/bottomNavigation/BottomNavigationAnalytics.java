package p005cm.aptoide.p006pt.bottomNavigation;

import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;

/* renamed from: cm.aptoide.pt.bottomNavigation.BottomNavigationAnalytics */
public class BottomNavigationAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String BOTTOM_NAVIGATION_INTERACT = "Bottom_Navigation_Interact";
    private static final String VIEW = "view";
    private final AnalyticsManager analyticsManager;
    private final NavigationTracker navigationTracker;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1196702144283204764L, "cm/aptoide/pt/bottomNavigation/BottomNavigationAnalytics", 19);
        $jacocoData = probes;
        return probes;
    }

    public BottomNavigationAnalytics(AnalyticsManager analyticsManager2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManager = analyticsManager2;
        this.navigationTracker = navigationTracker2;
        $jacocoInit[0] = true;
    }

    public void sendNavigateToHomeClickEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createBottomNavData = createBottomNavData("home");
        Action action = Action.CLICK;
        $jacocoInit[1] = true;
        String viewName = getViewName(true);
        $jacocoInit[2] = true;
        analyticsManager2.logEvent(createBottomNavData, BOTTOM_NAVIGATION_INTERACT, action, viewName);
        $jacocoInit[3] = true;
    }

    public void sendNavigateToSearchClickEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createBottomNavData = createBottomNavData("search");
        Action action = Action.CLICK;
        $jacocoInit[4] = true;
        String viewName = getViewName(true);
        $jacocoInit[5] = true;
        analyticsManager2.logEvent(createBottomNavData, BOTTOM_NAVIGATION_INTERACT, action, viewName);
        $jacocoInit[6] = true;
    }

    public void sendNavigateToStoresClickEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createBottomNavData = createBottomNavData("stores");
        Action action = Action.CLICK;
        $jacocoInit[7] = true;
        String viewName = getViewName(true);
        $jacocoInit[8] = true;
        analyticsManager2.logEvent(createBottomNavData, BOTTOM_NAVIGATION_INTERACT, action, viewName);
        $jacocoInit[9] = true;
    }

    public void sendNavigateToAppsClickEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createBottomNavData = createBottomNavData("apps");
        Action action = Action.CLICK;
        $jacocoInit[10] = true;
        String viewName = getViewName(true);
        $jacocoInit[11] = true;
        analyticsManager2.logEvent(createBottomNavData, BOTTOM_NAVIGATION_INTERACT, action, viewName);
        $jacocoInit[12] = true;
    }

    public void sendNavigateToCurationClickEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createBottomNavData = createBottomNavData("curation");
        Action action = Action.CLICK;
        $jacocoInit[13] = true;
        String viewName = getViewName(true);
        $jacocoInit[14] = true;
        analyticsManager2.logEvent(createBottomNavData, BOTTOM_NAVIGATION_INTERACT, action, viewName);
        $jacocoInit[15] = true;
    }

    private Map<String, Object> createBottomNavData(String view) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[16] = true;
        map.put(VIEW, view);
        $jacocoInit[17] = true;
        return map;
    }

    private String getViewName(boolean isCurrent) {
        boolean[] $jacocoInit = $jacocoInit();
        String viewName = this.navigationTracker.getViewName(isCurrent);
        $jacocoInit[18] = true;
        return viewName;
    }
}
