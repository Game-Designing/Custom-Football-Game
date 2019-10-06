package p005cm.aptoide.p006pt.editorial;

import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.download.DownloadAnalytics.AppContext;

/* renamed from: cm.aptoide.pt.editorial.EditorialAnalytics */
public class EditorialAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String ACTION = "action";
    private static final String APPLICATION_NAME = "Application Name";
    public static final String CURATION_CARD_INSTALL = "Curation_Card_Install";
    private static final String CURATION_DETAIL = "curation_detail";
    public static final String EDITORIAL_BN_CURATION_CARD_INSTALL = "Editorial_BN_Curation_Card_Install";
    public static final String REACTION_INTERACT = "Reaction_Interact";
    private static final String TYPE = "type";
    private static final String WHERE = "where";
    private final AnalyticsManager analyticsManager;
    private final DownloadAnalytics downloadAnalytics;
    private final boolean fromHome;
    private final NavigationTracker navigationTracker;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8506222561269501095L, "cm/aptoide/pt/editorial/EditorialAnalytics", 29);
        $jacocoData = probes;
        return probes;
    }

    public EditorialAnalytics(DownloadAnalytics downloadAnalytics2, AnalyticsManager analyticsManager2, NavigationTracker navigationTracker2, boolean fromHome2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadAnalytics = downloadAnalytics2;
        this.analyticsManager = analyticsManager2;
        this.navigationTracker = navigationTracker2;
        this.fromHome = fromHome2;
        $jacocoInit[0] = true;
    }

    public void setupDownloadEvents(Download download, int campaignId, String abTestGroup, Action action, OfferResponseStatus offerResponseStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadAnalytics downloadAnalytics2 = this.downloadAnalytics;
        String md5 = download.getMd5();
        String packageName = download.getPackageName();
        $jacocoInit[1] = true;
        boolean hasAppc = download.hasAppc();
        $jacocoInit[2] = true;
        downloadAnalytics2.installClicked(md5, packageName, action, offerResponseStatus, false, hasAppc);
        $jacocoInit[3] = true;
        this.downloadAnalytics.downloadStartEvent(download, campaignId, abTestGroup, AppContext.EDITORIAL, action, false);
        $jacocoInit[4] = true;
    }

    public void sendDownloadPauseEvent(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadAnalytics.downloadInteractEvent(packageName, "pause");
        $jacocoInit[5] = true;
    }

    public void sendDownloadCancelEvent(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadAnalytics.downloadInteractEvent(packageName, "cancel");
        $jacocoInit[6] = true;
    }

    public void clickOnInstallButton(String packageName, String type) {
        boolean[] $jacocoInit = $jacocoInit();
        String installEvent = CURATION_CARD_INSTALL;
        if (this.fromHome) {
            $jacocoInit[7] = true;
        } else {
            installEvent = EDITORIAL_BN_CURATION_CARD_INSTALL;
            $jacocoInit[8] = true;
        }
        HashMap<String, Object> map = new HashMap<>();
        $jacocoInit[9] = true;
        map.put(APPLICATION_NAME, packageName);
        $jacocoInit[10] = true;
        map.put("type", type);
        $jacocoInit[11] = true;
        this.analyticsManager.logEvent(map, installEvent, Action.CLICK, getViewName(true));
        $jacocoInit[12] = true;
    }

    private String getViewName(boolean isCurrent) {
        boolean[] $jacocoInit = $jacocoInit();
        String viewName = this.navigationTracker.getViewName(isCurrent);
        $jacocoInit[13] = true;
        return viewName;
    }

    public void sendReactionButtonClickEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[14] = true;
        data.put("action", "view_reactions");
        $jacocoInit[15] = true;
        data.put(WHERE, CURATION_DETAIL);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[16] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[17] = true;
        analyticsManager2.logEvent(data, REACTION_INTERACT, action, viewName);
        $jacocoInit[18] = true;
    }

    public void sendReactedEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[19] = true;
        data.put("action", "click_to_react");
        $jacocoInit[20] = true;
        data.put(WHERE, CURATION_DETAIL);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[21] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[22] = true;
        analyticsManager2.logEvent(data, REACTION_INTERACT, action, viewName);
        $jacocoInit[23] = true;
    }

    public void sendDeletedEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[24] = true;
        data.put("action", "delete_reaction");
        $jacocoInit[25] = true;
        data.put(WHERE, CURATION_DETAIL);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[26] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[27] = true;
        analyticsManager2.logEvent(data, REACTION_INTERACT, action, viewName);
        $jacocoInit[28] = true;
    }
}
