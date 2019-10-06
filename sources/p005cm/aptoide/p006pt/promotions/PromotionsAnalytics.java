package p005cm.aptoide.p006pt.promotions;

import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.download.DownloadAnalytics.AppContext;

/* renamed from: cm.aptoide.pt.promotions.PromotionsAnalytics */
public class PromotionsAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String ACTION = "action";
    private static final String ACTION_CLAIM = "claim";
    private static final String ACTION_INSTALL = "install";
    private static final String ACTION_UPDATE = "update";
    private static final String AMOUNT = "amount";
    private static final String PACKAGE = "package";
    public static final String PROMOTIONS_INTERACT = "Promotions_Interact";
    public static final String PROMOTION_DIALOG = "Promotion_Dialog";
    private static final String RELOAD = "reload";
    public static final String VALENTINE_MIGRATOR = "Valentine_Migrator";
    private static final String VIEW = "view";
    private final String ACTION_OPEN = "open";
    private final String CANCEL = "cancel";
    private final String CAPTCHA_DIALOG = "captcha dialog";
    private final String CLAIM = ACTION_CLAIM;
    private final String NEXT = "next";
    private final String OPEN_WALLET = "open wallet";
    private final String SIGNATURE = "signature";
    private final String WALLET_DIALOG = "wallet dialog";
    private final AnalyticsManager analyticsManager;
    private final DownloadAnalytics downloadAnalytics;
    private final NavigationTracker navigationTracker;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5848806934273092001L, "cm/aptoide/pt/promotions/PromotionsAnalytics", 68);
        $jacocoData = probes;
        return probes;
    }

    public PromotionsAnalytics(AnalyticsManager analyticsManager2, NavigationTracker navigationTracker2, DownloadAnalytics downloadAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManager = analyticsManager2;
        this.navigationTracker = navigationTracker2;
        this.downloadAnalytics = downloadAnalytics2;
        $jacocoInit[0] = true;
    }

    public void setupDownloadEvents(Download download, int campaignId, String abTestGroup, Action action, OfferResponseStatus offerResponseStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        Action action2 = action;
        this.downloadAnalytics.downloadStartEvent(download, campaignId, abTestGroup, AppContext.PROMOTIONS, action2, false);
        $jacocoInit[1] = true;
        this.downloadAnalytics.downloadCompleteEvent(download.getMd5(), download.getPackageName(), "", action2, offerResponseStatus);
        $jacocoInit[2] = true;
    }

    public void sendOpenPromotionsFragmentEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        HashMap hashMap = new HashMap();
        putPromotionAppAction("open", hashMap);
        Action action = Action.CLICK;
        $jacocoInit[3] = true;
        String viewName = getViewName(false);
        $jacocoInit[4] = true;
        analyticsManager2.logEvent(hashMap, PROMOTIONS_INTERACT, action, viewName);
        $jacocoInit[5] = true;
    }

    private String getViewName(boolean isCurrent) {
        boolean[] $jacocoInit = $jacocoInit();
        String viewName = this.navigationTracker.getViewName(isCurrent);
        $jacocoInit[6] = true;
        return viewName;
    }

    private HashMap<String, Object> putPromotionAppAction(String action, HashMap<String, Object> map) {
        boolean[] $jacocoInit = $jacocoInit();
        map.put("action", action);
        $jacocoInit[7] = true;
        return map;
    }

    private HashMap<String, Object> createPromotionsInteractMap(String action, String packageName, float appcValue) {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, Object> map = new HashMap<>();
        $jacocoInit[8] = true;
        HashMap<String, Object> map2 = putPromotionAppAction(action, map);
        $jacocoInit[9] = true;
        map2.put("package", packageName);
        $jacocoInit[10] = true;
        map2.put(AMOUNT, Float.valueOf(appcValue));
        $jacocoInit[11] = true;
        return map2;
    }

    public void sendClickOnWalletDialogNext(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[12] = true;
        data.put("action", "next");
        $jacocoInit[13] = true;
        data.put("package", packageName);
        $jacocoInit[14] = true;
        data.put(VIEW, "wallet dialog");
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[15] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[16] = true;
        analyticsManager2.logEvent(data, PROMOTION_DIALOG, action, viewName);
        $jacocoInit[17] = true;
    }

    public void sendClickOnWalletDialogCancel(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[18] = true;
        data.put("action", "cancel");
        $jacocoInit[19] = true;
        data.put("package", packageName);
        $jacocoInit[20] = true;
        data.put(VIEW, "wallet dialog");
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[21] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[22] = true;
        analyticsManager2.logEvent(data, PROMOTION_DIALOG, action, viewName);
        $jacocoInit[23] = true;
    }

    public void sendClickOnWalletDialogFindWallet(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[24] = true;
        data.put("action", "open wallet");
        $jacocoInit[25] = true;
        data.put("package", packageName);
        $jacocoInit[26] = true;
        data.put(VIEW, "wallet dialog");
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[27] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[28] = true;
        analyticsManager2.logEvent(data, PROMOTION_DIALOG, action, viewName);
        $jacocoInit[29] = true;
    }

    public void sendClickOnCaptchaDialogClaim(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[30] = true;
        data.put("action", ACTION_CLAIM);
        $jacocoInit[31] = true;
        data.put("package", packageName);
        $jacocoInit[32] = true;
        data.put(VIEW, "captcha dialog");
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[33] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[34] = true;
        analyticsManager2.logEvent(data, PROMOTION_DIALOG, action, viewName);
        $jacocoInit[35] = true;
    }

    public void sendClickOnCaptchaDialogCancel(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[36] = true;
        data.put("action", "cancel");
        $jacocoInit[37] = true;
        data.put("package", packageName);
        $jacocoInit[38] = true;
        data.put(VIEW, "captcha dialog");
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[39] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[40] = true;
        analyticsManager2.logEvent(data, PROMOTION_DIALOG, action, viewName);
        $jacocoInit[41] = true;
    }

    public void sendPromotionsAppInteractClaimEvent(String packageName, float appcValue) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        HashMap createPromotionsInteractMap = createPromotionsInteractMap(ACTION_CLAIM, packageName, appcValue);
        Action action = Action.CLICK;
        $jacocoInit[42] = true;
        String viewName = getViewName(true);
        $jacocoInit[43] = true;
        analyticsManager2.logEvent(createPromotionsInteractMap, PROMOTIONS_INTERACT, action, viewName);
        $jacocoInit[44] = true;
    }

    public void sendPromotionsAppInteractInstallEvent(String packageName, float appcValue, DownloadModel.Action action) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel.Action action2 = DownloadModel.Action.INSTALL;
        String str = PROMOTIONS_INTERACT;
        if (action == action2) {
            $jacocoInit[45] = true;
            AnalyticsManager analyticsManager2 = this.analyticsManager;
            HashMap createPromotionsInteractMap = createPromotionsInteractMap(ACTION_INSTALL, packageName, appcValue);
            Action action3 = Action.CLICK;
            $jacocoInit[46] = true;
            String viewName = getViewName(true);
            $jacocoInit[47] = true;
            analyticsManager2.logEvent(createPromotionsInteractMap, str, action3, viewName);
            $jacocoInit[48] = true;
        } else if (action != DownloadModel.Action.UPDATE) {
            $jacocoInit[49] = true;
        } else {
            $jacocoInit[50] = true;
            AnalyticsManager analyticsManager3 = this.analyticsManager;
            HashMap createPromotionsInteractMap2 = createPromotionsInteractMap(ACTION_UPDATE, packageName, appcValue);
            Action action4 = Action.CLICK;
            $jacocoInit[51] = true;
            String viewName2 = getViewName(true);
            $jacocoInit[52] = true;
            analyticsManager3.logEvent(createPromotionsInteractMap2, str, action4, viewName2);
            $jacocoInit[53] = true;
        }
        $jacocoInit[54] = true;
    }

    public void sendRefreshCaptchaEvent(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[55] = true;
        data.put("action", RELOAD);
        $jacocoInit[56] = true;
        data.put("package", packageName);
        $jacocoInit[57] = true;
        data.put(VIEW, "captcha dialog");
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[58] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[59] = true;
        analyticsManager2.logEvent(data, PROMOTION_DIALOG, action, viewName);
        $jacocoInit[60] = true;
    }

    public void sendValentineMigratorEvent(String packageName, Boolean signatureMatch) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[61] = true;
        data.put("package", packageName);
        $jacocoInit[62] = true;
        if (signatureMatch.booleanValue()) {
            $jacocoInit[63] = true;
            str = "same";
        } else {
            $jacocoInit[64] = true;
            str = "different";
        }
        data.put("signature", str);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[65] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[66] = true;
        analyticsManager2.logEvent(data, VALENTINE_MIGRATOR, action, viewName);
        $jacocoInit[67] = true;
    }
}
