package p005cm.aptoide.p006pt.editorialList;

import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.editorial.EditorialAnalytics;

/* renamed from: cm.aptoide.pt.editorialList.EditorialListAnalytics */
public class EditorialListAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String ACTION = "action";
    private static final String CARD_ID = "card_id";
    private static final String CURATION_CARD = "curation_card";
    public static final String EDITORIAL_BN_CURATION_CARD_CLICK = "Editorial_BN_Curation_Card_Click";
    public static final String EDITORIAL_BN_CURATION_CARD_IMPRESSION = "Editorial_BN_Curation_Card_Impression";
    static final String IMPRESSION = "impression";
    private static final String POSITION = "position";
    static final String TAP_ON_CARD = "tap on card";
    private static final String WHERE = "where";
    private final AnalyticsManager analyticsManager;
    private final NavigationTracker navigationTracker;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3794969557735885721L, "cm/aptoide/pt/editorialList/EditorialListAnalytics", 28);
        $jacocoData = probes;
        return probes;
    }

    public EditorialListAnalytics(NavigationTracker navigationTracker2, AnalyticsManager analyticsManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigationTracker = navigationTracker2;
        this.analyticsManager = analyticsManager2;
        $jacocoInit[0] = true;
    }

    public void sendEditorialInteractEvent(String cardId, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[1] = true;
        data.put("action", TAP_ON_CARD);
        $jacocoInit[2] = true;
        data.put(CARD_ID, cardId);
        $jacocoInit[3] = true;
        data.put(POSITION, Integer.valueOf(position));
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.OPEN;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[4] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[5] = true;
        analyticsManager2.logEvent(data, EDITORIAL_BN_CURATION_CARD_CLICK, action, viewName);
        $jacocoInit[6] = true;
    }

    public void sendEditorialImpressionEvent(String cardId, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[7] = true;
        data.put("action", IMPRESSION);
        $jacocoInit[8] = true;
        data.put(CARD_ID, cardId);
        $jacocoInit[9] = true;
        data.put(POSITION, Integer.valueOf(position));
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.IMPRESSION;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[10] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[11] = true;
        analyticsManager2.logEvent(data, EDITORIAL_BN_CURATION_CARD_IMPRESSION, action, viewName);
        $jacocoInit[12] = true;
    }

    public void sendReactionButtonClickEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[13] = true;
        data.put("action", "view_reactions");
        $jacocoInit[14] = true;
        data.put(WHERE, CURATION_CARD);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[15] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[16] = true;
        analyticsManager2.logEvent(data, EditorialAnalytics.REACTION_INTERACT, action, viewName);
        $jacocoInit[17] = true;
    }

    public void sendReactedEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[18] = true;
        data.put("action", "click_to_react");
        $jacocoInit[19] = true;
        data.put(WHERE, CURATION_CARD);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[20] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[21] = true;
        analyticsManager2.logEvent(data, EditorialAnalytics.REACTION_INTERACT, action, viewName);
        $jacocoInit[22] = true;
    }

    public void sendDeleteEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[23] = true;
        data.put("action", "delete_reaction");
        $jacocoInit[24] = true;
        data.put(WHERE, CURATION_CARD);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[25] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[26] = true;
        analyticsManager2.logEvent(data, EditorialAnalytics.REACTION_INTERACT, action, viewName);
        $jacocoInit[27] = true;
    }
}
