package p005cm.aptoide.p006pt;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;

/* renamed from: cm.aptoide.pt.DeepLinkAnalytics */
public class DeepLinkAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String APPCOINS_WALLET_DEEPLINK = "AppCoins_Wallet_Deeplink";
    public static final String APP_LAUNCH = "Application Launch";
    private static final String DOWNLOADING_UPDATES = "Downloading Updates";
    public static final String FACEBOOK_APP_LAUNCH = "Aptoide Launch";
    private static final String HOSTNAME = "Hostname";
    private static final String LAUNCHER = "Launcher";
    private static final String NEW_REPO = "New Repository";
    private static final String NEW_UPDATES_NOTIFICATION = "New Updates Available";
    private static final String SOURCE = "Source";
    private static final String SOURCE_GROUP_ATTRIBUTE = "source_group";
    private static final String SOURCE_GROUP_OPTION_APP_VIEW = "aptoide app view";
    private static final String SOURCE_GROUP_OPTION_BUNDLES = "aptoide bundle";
    private static final String SOURCE_GROUP_OPTION_HOME = "aptoide homepage";
    private static final String SOURCE_GROUP_OPTION_STORE = "aptoide store";
    private static final String SOURCE_GROUP_OPTION_THANK_YOU = "aptoide thank you page";
    private static final String URI = "Uri";
    private static final String WEBSITE = "Website";
    private AnalyticsManager analyticsManager;
    private HashMap<String, Object> map = new HashMap<>();
    private NavigationTracker navigationTracker;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3875368470005496944L, "cm/aptoide/pt/DeepLinkAnalytics", 43);
        $jacocoData = probes;
        return probes;
    }

    public DeepLinkAnalytics(AnalyticsManager analyticsManager2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.analyticsManager = analyticsManager2;
        this.navigationTracker = navigationTracker2;
        $jacocoInit[1] = true;
    }

    public void launcher() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMap = createMap("Source", LAUNCHER);
        Action action = Action.AUTO;
        $jacocoInit[2] = true;
        String viewName = getViewName(true);
        $jacocoInit[3] = true;
        analyticsManager2.logEvent(createMap, FACEBOOK_APP_LAUNCH, action, viewName);
        $jacocoInit[4] = true;
    }

    public void website(String uri) {
        boolean[] $jacocoInit = $jacocoInit();
        this.map = new HashMap<>();
        $jacocoInit[5] = true;
        this.map.put("Source", WEBSITE);
        if (uri == null) {
            $jacocoInit[6] = true;
        } else {
            $jacocoInit[7] = true;
            this.map.put(URI, uri.substring(0, uri.indexOf(":")));
            $jacocoInit[8] = true;
            HashMap<String, Object> hashMap = this.map;
            Uri parse = Uri.parse(uri);
            $jacocoInit[9] = true;
            String host = parse.getHost();
            $jacocoInit[10] = true;
            hashMap.put(HOSTNAME, host);
            $jacocoInit[11] = true;
        }
        $jacocoInit[12] = true;
    }

    public void sendWebsite() {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, Object> hashMap = this.map;
        if (hashMap == null) {
            $jacocoInit[13] = true;
        } else if (hashMap.isEmpty()) {
            $jacocoInit[14] = true;
        } else {
            AnalyticsManager analyticsManager2 = this.analyticsManager;
            HashMap<String, Object> hashMap2 = this.map;
            Action action = Action.AUTO;
            $jacocoInit[15] = true;
            String viewName = getViewName(true);
            $jacocoInit[16] = true;
            analyticsManager2.logEvent(hashMap2, FACEBOOK_APP_LAUNCH, action, viewName);
            $jacocoInit[17] = true;
            this.analyticsManager.logEvent(this.map, APP_LAUNCH, Action.AUTO, getViewName(true));
            $jacocoInit[18] = true;
        }
        this.map = null;
        $jacocoInit[19] = true;
    }

    private void websiteSourceGroup(String sourceGroupValue) {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, Object> hashMap = this.map;
        if (hashMap == null) {
            $jacocoInit[20] = true;
        } else if (hashMap.isEmpty()) {
            $jacocoInit[21] = true;
        } else {
            $jacocoInit[22] = true;
            this.map.put(SOURCE_GROUP_ATTRIBUTE, sourceGroupValue);
            $jacocoInit[23] = true;
        }
        $jacocoInit[24] = true;
    }

    public void websiteFromHomeWebPage() {
        boolean[] $jacocoInit = $jacocoInit();
        websiteSourceGroup(SOURCE_GROUP_OPTION_HOME);
        $jacocoInit[25] = true;
    }

    public void websiteFromAppViewWebPage() {
        boolean[] $jacocoInit = $jacocoInit();
        websiteSourceGroup(SOURCE_GROUP_OPTION_APP_VIEW);
        $jacocoInit[26] = true;
    }

    public void websiteFromBundlesWebPage() {
        boolean[] $jacocoInit = $jacocoInit();
        websiteSourceGroup(SOURCE_GROUP_OPTION_BUNDLES);
        $jacocoInit[27] = true;
    }

    public void websiteFromStoreWebPage() {
        boolean[] $jacocoInit = $jacocoInit();
        websiteSourceGroup(SOURCE_GROUP_OPTION_STORE);
        $jacocoInit[28] = true;
    }

    public void websiteFromThankYouWebPage() {
        boolean[] $jacocoInit = $jacocoInit();
        websiteSourceGroup(SOURCE_GROUP_OPTION_THANK_YOU);
        $jacocoInit[29] = true;
    }

    public void newUpdatesNotification() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMap = createMap("Source", NEW_UPDATES_NOTIFICATION);
        Action action = Action.AUTO;
        $jacocoInit[30] = true;
        String viewName = getViewName(true);
        $jacocoInit[31] = true;
        analyticsManager2.logEvent(createMap, APP_LAUNCH, action, viewName);
        $jacocoInit[32] = true;
    }

    public void downloadingUpdates() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMap = createMap("Source", DOWNLOADING_UPDATES);
        Action action = Action.AUTO;
        $jacocoInit[33] = true;
        String viewName = getViewName(true);
        $jacocoInit[34] = true;
        analyticsManager2.logEvent(createMap, APP_LAUNCH, action, viewName);
        $jacocoInit[35] = true;
    }

    public void newRepo() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMap = createMap("Source", NEW_REPO);
        Action action = Action.AUTO;
        $jacocoInit[36] = true;
        String viewName = getViewName(true);
        $jacocoInit[37] = true;
        analyticsManager2.logEvent(createMap, APP_LAUNCH, action, viewName);
        $jacocoInit[38] = true;
    }

    private Map<String, Object> createMap(String key, String value) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map2 = new HashMap<>();
        $jacocoInit[39] = true;
        map2.put(key, value);
        $jacocoInit[40] = true;
        return map2;
    }

    private String getViewName(boolean isCurrent) {
        boolean[] $jacocoInit = $jacocoInit();
        String viewName = this.navigationTracker.getViewName(isCurrent);
        $jacocoInit[41] = true;
        return viewName;
    }

    public void sendWalletDeepLinkEvent(String utmSource) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManager.logEvent(createMap("Source", utmSource), APPCOINS_WALLET_DEEPLINK, Action.CLICK, "Application");
        $jacocoInit[42] = true;
    }
}
