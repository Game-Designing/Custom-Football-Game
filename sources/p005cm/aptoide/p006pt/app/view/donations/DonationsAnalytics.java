package p005cm.aptoide.p006pt.app.view.donations;

import java.util.HashMap;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;

/* renamed from: cm.aptoide.pt.app.view.donations.DonationsAnalytics */
public class DonationsAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String ACTION = "action";
    public static final String DONATIONS_INTERACT = "Donations_Dialog_Interact";
    public static final String NAME = "name";
    public static final String PACKAGE_NAME = "package_name";
    public static final String VALUE = "value";
    private AnalyticsManager analyticsManager;
    private NavigationTracker navigationTracker;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4572722022181497731L, "cm/aptoide/pt/app/view/donations/DonationsAnalytics", 13);
        $jacocoData = probes;
        return probes;
    }

    public DonationsAnalytics(AnalyticsManager analyticsManager2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManager = analyticsManager2;
        this.navigationTracker = navigationTracker2;
        $jacocoInit[0] = true;
    }

    public void sendDonateInteractEvent(String packageName, float value, boolean hasNickname) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        HashMap createDonationsInteractMap = createDonationsInteractMap("donate", packageName, value, hasNickname);
        Action action = Action.CLICK;
        $jacocoInit[1] = true;
        String viewName = getViewName(true);
        $jacocoInit[2] = true;
        analyticsManager2.logEvent(createDonationsInteractMap, DONATIONS_INTERACT, action, viewName);
        $jacocoInit[3] = true;
    }

    public void sendCancelInteractEvent(String packageName, float value, boolean hasNickname) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        HashMap createDonationsInteractMap = createDonationsInteractMap("cancel", packageName, value, hasNickname);
        Action action = Action.CLICK;
        $jacocoInit[4] = true;
        String viewName = getViewName(true);
        $jacocoInit[5] = true;
        analyticsManager2.logEvent(createDonationsInteractMap, DONATIONS_INTERACT, action, viewName);
        $jacocoInit[6] = true;
    }

    private HashMap<String, Object> createDonationsInteractMap(String action, String packageName, float value, boolean hasNickname) {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, Object> map = new HashMap<>();
        $jacocoInit[7] = true;
        map.put("action", action);
        $jacocoInit[8] = true;
        map.put("package_name", packageName);
        $jacocoInit[9] = true;
        map.put(VALUE, Float.valueOf(value));
        $jacocoInit[10] = true;
        map.put("name", Boolean.valueOf(hasNickname));
        $jacocoInit[11] = true;
        return map;
    }

    private String getViewName(boolean isCurrent) {
        boolean[] $jacocoInit = $jacocoInit();
        String viewName = this.navigationTracker.getViewName(isCurrent);
        $jacocoInit[12] = true;
        return viewName;
    }
}
