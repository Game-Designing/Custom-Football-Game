package p005cm.aptoide.p006pt;

import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;

/* renamed from: cm.aptoide.pt.AppShortcutsAnalytics */
public class AppShortcutsAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String APPS_SHORTCUTS = "Apps_Shortcuts";
    private static final String DESTINATION = "destination";
    private final AnalyticsManager analyticsManager;
    private final NavigationTracker navigationTracker;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6709632839689098277L, "cm/aptoide/pt/AppShortcutsAnalytics", 6);
        $jacocoData = probes;
        return probes;
    }

    public AppShortcutsAnalytics(AnalyticsManager analyticsManager2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManager = analyticsManager2;
        this.navigationTracker = navigationTracker2;
        $jacocoInit[0] = true;
    }

    public void shortcutNavigation(String destination) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[1] = true;
        map.put(DESTINATION, destination);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        $jacocoInit[2] = true;
        String viewName = getViewName(true);
        $jacocoInit[3] = true;
        analyticsManager2.logEvent(map, APPS_SHORTCUTS, action, viewName);
        $jacocoInit[4] = true;
    }

    private String getViewName(boolean isCurrent) {
        boolean[] $jacocoInit = $jacocoInit();
        String viewName = this.navigationTracker.getViewName(isCurrent);
        $jacocoInit[5] = true;
        return viewName;
    }
}
