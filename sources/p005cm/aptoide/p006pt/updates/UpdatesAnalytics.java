package p005cm.aptoide.p006pt.updates;

import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;

/* renamed from: cm.aptoide.pt.updates.UpdatesAnalytics */
public class UpdatesAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String OPEN_APP_VIEW = "Open App View";
    public static final String UPDATE_EVENT = "Updates";
    private AnalyticsManager analyticsManager;
    private NavigationTracker navigationTracker;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-19325221149075151L, "cm/aptoide/pt/updates/UpdatesAnalytics", 6);
        $jacocoData = probes;
        return probes;
    }

    public UpdatesAnalytics(AnalyticsManager analyticsManager2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManager = analyticsManager2;
        this.navigationTracker = navigationTracker2;
        $jacocoInit[0] = true;
    }

    public void updates(String action) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData("action", action);
        Action action2 = Action.AUTO;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[1] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[2] = true;
        analyticsManager2.logEvent(createMapData, UPDATE_EVENT, action2, viewName);
        $jacocoInit[3] = true;
    }

    private Map<String, Object> createMapData(String key, String value) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[4] = true;
        data.put(key, value);
        $jacocoInit[5] = true;
        return data;
    }
}
