package p005cm.aptoide.p006pt.home;

import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd.Network;
import p005cm.aptoide.p006pt.editorial.EditorialAnalytics;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;

/* renamed from: cm.aptoide.pt.home.HomeAnalytics */
public class HomeAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String ACTION = "action";
    private static final String BUNDLE_TAG = "bundle_tag";
    static final String CHIP_CLICK = "chip";
    static final String CHIP_TAG = "chip_tag";
    private static final String CURATION_CARD = "curation_card";
    public static final String CURATION_CARD_CLICK = "Curation_Card_Click";
    public static final String CURATION_CARD_IMPRESSION = "Curation_Card_Impression";
    public static final String HOME_CHIP_INTERACT = "Home_Chip_Interact";
    public static final String HOME_INTERACT = "Home_Interact";
    static final String IMPRESSION = "impression";
    private static final String PACKAGE_NAME = "package_name";
    private static final String PROMOTION_DIALOG = "promotion-dialog";
    private static final String PROMOTION_ICON = "promotion-icon";
    static final String PULL_REFRESH = "pull refresh";
    static final String PUSH_LOAD_MORE = "push load more";
    static final String SCROLL_RIGHT = "scroll right";
    static final String TAP = "tap";
    static final String TAP_ON_APP = "tap on app";
    static final String TAP_ON_CARD = "tap on card";
    static final String TAP_ON_CARD_DISMISS = "tap on card dismiss";
    private static final String TAP_ON_CHIP = "tap on chip";
    static final String TAP_ON_MORE = "tap on more";
    static final String VIEW_CARD = "view card";
    private static final String WHERE = "where";
    private final AnalyticsManager analyticsManager;
    private final NavigationTracker navigationTracker;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3432780139510892093L, "cm/aptoide/pt/home/HomeAnalytics", Opcodes.IF_ICMPEQ);
        $jacocoData = probes;
        return probes;
    }

    public HomeAnalytics(NavigationTracker navigationTracker2, AnalyticsManager analyticsManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigationTracker = navigationTracker2;
        this.analyticsManager = analyticsManager2;
        $jacocoInit[0] = true;
    }

    public void sendTapOnMoreInteractEvent(int bundlePosition, String bundleTag, int itemsInBundle) {
        boolean[] $jacocoInit = $jacocoInit();
        sendTapOnMoreInteractEvent(bundlePosition, bundleTag, itemsInBundle, null);
        $jacocoInit[1] = true;
    }

    public void sendTapOnMoreInteractEvent(int bundlePosition, String bundleTag, int itemsInBundle, String chipTag) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[2] = true;
        data.put("action", TAP_ON_MORE);
        $jacocoInit[3] = true;
        data.put(BUNDLE_TAG, bundleTag);
        $jacocoInit[4] = true;
        data.put("bundle_position", Integer.valueOf(bundlePosition));
        $jacocoInit[5] = true;
        data.put("bundle_total_items", Integer.valueOf(itemsInBundle));
        if (chipTag == null) {
            $jacocoInit[6] = true;
        } else {
            $jacocoInit[7] = true;
            data.put(CHIP_TAG, chipTag);
            $jacocoInit[8] = true;
        }
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[9] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[10] = true;
        analyticsManager2.logEvent(data, HOME_INTERACT, action, viewName);
        $jacocoInit[11] = true;
    }

    public void sendScrollRightInteractEvent(int bundlePosition, String bundleTag, int itemsInBundle) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[12] = true;
        data.put("action", SCROLL_RIGHT);
        $jacocoInit[13] = true;
        data.put(BUNDLE_TAG, bundleTag);
        $jacocoInit[14] = true;
        data.put("bundle_position", Integer.valueOf(bundlePosition));
        $jacocoInit[15] = true;
        data.put("bundle_total_items", Integer.valueOf(itemsInBundle));
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.SCROLL;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[16] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[17] = true;
        analyticsManager2.logEvent(data, HOME_INTERACT, action, viewName);
        $jacocoInit[18] = true;
    }

    public void sendLoadMoreInteractEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[19] = true;
        data.put("action", PUSH_LOAD_MORE);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.ENDLESS_SCROLL;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[20] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[21] = true;
        analyticsManager2.logEvent(data, HOME_INTERACT, action, viewName);
        $jacocoInit[22] = true;
    }

    public void sendPullRefreshInteractEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[23] = true;
        data.put("action", PULL_REFRESH);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.PULL_REFRESH;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[24] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[25] = true;
        analyticsManager2.logEvent(data, HOME_INTERACT, action, viewName);
        $jacocoInit[26] = true;
    }

    public void sendTapOnAppInteractEvent(double appRating, String packageName, int appPosition, int bundlePosition, String bundleTag, int itemsInBundle) {
        boolean[] $jacocoInit = $jacocoInit();
        sendTapOnAppInteractEvent(appRating, packageName, appPosition, bundlePosition, bundleTag, itemsInBundle, null);
        $jacocoInit[27] = true;
    }

    public void sendTapOnAppInteractEvent(double appRating, String packageName, int appPosition, int bundlePosition, String bundleTag, int itemsInBundle, String chipTag) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[28] = true;
        data.put("action", TAP_ON_APP);
        $jacocoInit[29] = true;
        data.put("app_rating", Double.valueOf(appRating));
        $jacocoInit[30] = true;
        data.put("package_name", packageName);
        $jacocoInit[31] = true;
        data.put("app_position", Integer.valueOf(appPosition));
        $jacocoInit[32] = true;
        data.put(BUNDLE_TAG, bundleTag);
        $jacocoInit[33] = true;
        data.put("bundle_position", Integer.valueOf(bundlePosition));
        $jacocoInit[34] = true;
        data.put("bundle_total_items", Integer.valueOf(itemsInBundle));
        if (chipTag == null) {
            $jacocoInit[35] = true;
        } else {
            $jacocoInit[36] = true;
            data.put(CHIP_TAG, chipTag);
            $jacocoInit[37] = true;
        }
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[38] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[39] = true;
        analyticsManager2.logEvent(data, HOME_INTERACT, action, viewName);
        $jacocoInit[40] = true;
    }

    private void sendAdInteractEvent(String actionType, int appRating, String packageName, int bundlePosition, String bundleTag, Type type, Network network) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[41] = true;
        data.put("action", actionType);
        $jacocoInit[42] = true;
        data.put("app_rating", Integer.valueOf(appRating));
        $jacocoInit[43] = true;
        data.put("package_name", packageName);
        $jacocoInit[44] = true;
        data.put(BUNDLE_TAG, bundleTag);
        $jacocoInit[45] = true;
        data.put("bundle_position", Integer.valueOf(bundlePosition));
        $jacocoInit[46] = true;
        data.put("network", network.getName());
        $jacocoInit[47] = true;
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action parseAction = parseAction(type);
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[48] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[49] = true;
        analyticsManager2.logEvent(data, HOME_INTERACT, parseAction, viewName);
        $jacocoInit[50] = true;
    }

    public void sendAdClickEvent(int appRating, String packageName, int bundlePosition, String bundleTag, Type type, Network network) {
        boolean[] $jacocoInit = $jacocoInit();
        sendAdInteractEvent(TAP_ON_APP, appRating, packageName, bundlePosition, bundleTag, type, network);
        $jacocoInit[51] = true;
    }

    public void sendActionItemTapOnCardInteractEvent(String bundleTag, int bundlePosition) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[52] = true;
        data.put("action", TAP_ON_CARD);
        $jacocoInit[53] = true;
        data.put(BUNDLE_TAG, bundleTag);
        $jacocoInit[54] = true;
        data.put("bundle_position", Integer.valueOf(bundlePosition));
        $jacocoInit[55] = true;
        this.analyticsManager.logEvent(data, HOME_INTERACT, Action.OPEN, this.navigationTracker.getViewName(true));
        $jacocoInit[56] = true;
    }

    public void sendActionItemEditorialTapOnCardInteractEvent(String bundleTag, int bundlePosition, String cardId) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[57] = true;
        data.put("action", TAP_ON_CARD);
        $jacocoInit[58] = true;
        data.put(BUNDLE_TAG, bundleTag);
        $jacocoInit[59] = true;
        data.put("bundle_position", Integer.valueOf(bundlePosition));
        $jacocoInit[60] = true;
        data.put("card_id", cardId);
        $jacocoInit[61] = true;
        this.analyticsManager.logEvent(data, HOME_INTERACT, Action.OPEN, this.navigationTracker.getViewName(true));
        $jacocoInit[62] = true;
    }

    public void sendActionItemDismissInteractEvent(String bundleTag, int bundlePosition) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[63] = true;
        data.put("action", TAP_ON_CARD_DISMISS);
        $jacocoInit[64] = true;
        data.put(BUNDLE_TAG, bundleTag);
        $jacocoInit[65] = true;
        data.put("bundle_position", Integer.valueOf(bundlePosition));
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.DISMISS;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[66] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[67] = true;
        analyticsManager2.logEvent(data, HOME_INTERACT, action, viewName);
        $jacocoInit[68] = true;
    }

    public void sendActionItemImpressionEvent(String bundleTag, int bundlePosition) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[69] = true;
        data.put("action", VIEW_CARD);
        $jacocoInit[70] = true;
        data.put(BUNDLE_TAG, bundleTag);
        $jacocoInit[71] = true;
        data.put("bundle_position", Integer.valueOf(bundlePosition));
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.IMPRESSION;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[72] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[73] = true;
        analyticsManager2.logEvent(data, HOME_INTERACT, action, viewName);
        $jacocoInit[74] = true;
    }

    public void sendEditorialInteractEvent(String bundleTag, int bundlePosition, String cardId) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[75] = true;
        data.put("action", TAP_ON_CARD);
        $jacocoInit[76] = true;
        data.put(BUNDLE_TAG, bundleTag);
        $jacocoInit[77] = true;
        data.put("card_id", cardId);
        $jacocoInit[78] = true;
        data.put("bundle_position", Integer.valueOf(bundlePosition));
        $jacocoInit[79] = true;
        this.analyticsManager.logEvent(data, CURATION_CARD_CLICK, Action.OPEN, this.navigationTracker.getViewName(true));
        $jacocoInit[80] = true;
    }

    public void sendEditorialImpressionEvent(String bundleTag, int bundlePosition, String cardId) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[81] = true;
        data.put("action", IMPRESSION);
        $jacocoInit[82] = true;
        data.put(BUNDLE_TAG, bundleTag);
        $jacocoInit[83] = true;
        data.put("card_id", cardId);
        $jacocoInit[84] = true;
        data.put("bundle_position", Integer.valueOf(bundlePosition));
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.IMPRESSION;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[85] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[86] = true;
        analyticsManager2.logEvent(data, CURATION_CARD_IMPRESSION, action, viewName);
        $jacocoInit[87] = true;
    }

    public void sendActionItemEditorialImpressionEvent(String bundleTag, int bundlePosition, String cardId) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[88] = true;
        data.put("action", VIEW_CARD);
        $jacocoInit[89] = true;
        data.put(BUNDLE_TAG, bundleTag);
        $jacocoInit[90] = true;
        data.put("bundle_position", Integer.valueOf(bundlePosition));
        $jacocoInit[91] = true;
        data.put("card_id", cardId);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.IMPRESSION;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[92] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[93] = true;
        analyticsManager2.logEvent(data, HOME_INTERACT, action, viewName);
        $jacocoInit[94] = true;
    }

    public void sendPromotionsIconClickEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[95] = true;
        data.put("action", TAP);
        $jacocoInit[96] = true;
        data.put(BUNDLE_TAG, PROMOTION_ICON);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[97] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[98] = true;
        analyticsManager2.logEvent(data, HOME_INTERACT, action, viewName);
        $jacocoInit[99] = true;
    }

    public void sendPromotionsDialogImpressionEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[100] = true;
        data.put("action", IMPRESSION);
        $jacocoInit[101] = true;
        data.put(BUNDLE_TAG, PROMOTION_DIALOG);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.IMPRESSION;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[102] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[103] = true;
        analyticsManager2.logEvent(data, HOME_INTERACT, action, viewName);
        $jacocoInit[104] = true;
    }

    public void sendPromotionsDialogDismissEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[105] = true;
        data.put("action", TAP_ON_CARD_DISMISS);
        $jacocoInit[106] = true;
        data.put(BUNDLE_TAG, PROMOTION_DIALOG);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.DISMISS;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[107] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[108] = true;
        analyticsManager2.logEvent(data, HOME_INTERACT, action, viewName);
        $jacocoInit[109] = true;
    }

    public void sendPromotionsDialogNavigateEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[110] = true;
        data.put("action", TAP_ON_CARD);
        $jacocoInit[111] = true;
        data.put(BUNDLE_TAG, PROMOTION_DIALOG);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[112] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[113] = true;
        analyticsManager2.logEvent(data, HOME_INTERACT, action, viewName);
        $jacocoInit[114] = true;
    }

    public void sendPromotionsImpressionEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[115] = true;
        data.put("action", IMPRESSION);
        $jacocoInit[116] = true;
        data.put(BUNDLE_TAG, PROMOTION_ICON);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.IMPRESSION;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[117] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[118] = true;
        analyticsManager2.logEvent(data, HOME_INTERACT, action, viewName);
        $jacocoInit[119] = true;
    }

    public void sendChipHomeInteractEvent(String chipTag) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[120] = true;
        data.put("action", CHIP_CLICK);
        $jacocoInit[121] = true;
        data.put(BUNDLE_TAG, chipTag);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[122] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[123] = true;
        analyticsManager2.logEvent(data, HOME_INTERACT, action, viewName);
        $jacocoInit[124] = true;
    }

    public void sendChipInteractEvent(String chipTag) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[125] = true;
        data.put("action", TAP_ON_CHIP);
        $jacocoInit[126] = true;
        data.put(CHIP_TAG, chipTag);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[127] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[128] = true;
        analyticsManager2.logEvent(data, HOME_CHIP_INTERACT, action, viewName);
        $jacocoInit[129] = true;
    }

    public void sendChipTapOnMore(String bundleTag, String chipTag) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createChipTapInteractMap = createChipTapInteractMap(TAP_ON_MORE, bundleTag, chipTag);
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[130] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[131] = true;
        analyticsManager2.logEvent(createChipTapInteractMap, HOME_CHIP_INTERACT, action, viewName);
        $jacocoInit[132] = true;
    }

    public void sendChipTapOnApp(String bundleTag, String packageName, String chipTag) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = createChipTapInteractMap(TAP_ON_APP, bundleTag, chipTag);
        $jacocoInit[133] = true;
        data.put("package_name", packageName);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[134] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[135] = true;
        analyticsManager2.logEvent(data, HOME_CHIP_INTERACT, action, viewName);
        $jacocoInit[136] = true;
    }

    public Map<String, Object> createChipTapInteractMap(String action, String bundleTag, String chipTag) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[137] = true;
        data.put("action", action);
        $jacocoInit[138] = true;
        data.put(BUNDLE_TAG, bundleTag);
        $jacocoInit[139] = true;
        data.put(CHIP_TAG, chipTag);
        $jacocoInit[140] = true;
        return data;
    }

    public void convertAppcAdClick(String clickUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManager.logEvent(clickUrl);
        $jacocoInit[141] = true;
    }

    private Action parseAction(Type type) {
        boolean[] $jacocoInit = $jacocoInit();
        if (type.equals(Type.AD)) {
            Action action = Action.OPEN;
            $jacocoInit[142] = true;
            return action;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("TYPE ");
        sb.append(type.name());
        sb.append(" NOT VALID");
        IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
        $jacocoInit[143] = true;
        throw illegalStateException;
    }

    public void sendReactionButtonClickEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[144] = true;
        data.put("action", "view_reactions");
        $jacocoInit[145] = true;
        data.put(WHERE, CURATION_CARD);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[146] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[147] = true;
        analyticsManager2.logEvent(data, EditorialAnalytics.REACTION_INTERACT, action, viewName);
        $jacocoInit[148] = true;
    }

    public void sendReactedEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[149] = true;
        data.put("action", "click_to_react");
        $jacocoInit[150] = true;
        data.put(WHERE, CURATION_CARD);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[151] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[152] = true;
        analyticsManager2.logEvent(data, EditorialAnalytics.REACTION_INTERACT, action, viewName);
        $jacocoInit[153] = true;
    }

    public void sendDeleteEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[154] = true;
        data.put("action", "delete_reaction");
        $jacocoInit[155] = true;
        data.put(WHERE, CURATION_CARD);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[156] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[157] = true;
        analyticsManager2.logEvent(data, EditorialAnalytics.REACTION_INTERACT, action, viewName);
        $jacocoInit[158] = true;
    }
}
