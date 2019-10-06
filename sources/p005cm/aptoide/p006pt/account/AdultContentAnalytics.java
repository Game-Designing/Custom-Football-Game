package p005cm.aptoide.p006pt.account;

import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;

/* renamed from: cm.aptoide.pt.account.AdultContentAnalytics */
public class AdultContentAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String ADULT_CONTENT = "Adult Content";
    public static final String LOCK = "true";
    public static final String UNLOCK = "false";
    private AnalyticsManager analyticsManager;
    private NavigationTracker navigationTracker;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-201460259742153825L, "cm/aptoide/pt/account/AdultContentAnalytics", 8);
        $jacocoData = probes;
        return probes;
    }

    public AdultContentAnalytics(AnalyticsManager analyticsManager2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManager = analyticsManager2;
        this.navigationTracker = navigationTracker2;
        $jacocoInit[0] = true;
    }

    public void lock() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[1] = true;
        map.put("Action", "true");
        $jacocoInit[2] = true;
        this.analyticsManager.logEvent(map, ADULT_CONTENT, Action.CLICK, getViewName(true));
        $jacocoInit[3] = true;
    }

    public void unlock() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[4] = true;
        map.put("Action", UNLOCK);
        $jacocoInit[5] = true;
        this.analyticsManager.logEvent(map, ADULT_CONTENT, Action.CLICK, getViewName(true));
        $jacocoInit[6] = true;
    }

    private String getViewName(boolean isCurrent) {
        boolean[] $jacocoInit = $jacocoInit();
        String viewName = this.navigationTracker.getViewName(isCurrent);
        $jacocoInit[7] = true;
        return viewName;
    }
}
