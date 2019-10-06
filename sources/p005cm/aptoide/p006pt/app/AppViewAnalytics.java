package p005cm.aptoide.p006pt.app;

import com.mopub.common.AdType;
import com.mopub.common.logging.MoPubLog;
import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd.Network;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.app.view.AppViewSimilarAppsAdapter.SimilarAppType;
import p005cm.aptoide.p006pt.billing.BillingAnalytics;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Developer;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.download.DownloadAnalytics.AppContext;
import p005cm.aptoide.p006pt.download.InstallType;
import p005cm.aptoide.p006pt.downloadmanager.Constants;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment.BundleCons;

/* renamed from: cm.aptoide.pt.app.AppViewAnalytics */
public class AppViewAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String ACTION = "Action";
    public static final String ADS_BLOCK_BY_OFFER = "Ads_Block_By_Offer";
    public static final String APPC_SIMILAR_APP_INTERACT = "Appc_Similar_App_Interact";
    private static final String APPLICATION_NAME = "Application Name";
    private static final String APPLICATION_PUBLISHER = "Application Publisher";
    private static final String APP_SHORTCUT = "App_Shortcut";
    public static final String APP_VIEW_INTERACT = "App_View_Interact";
    public static final String APP_VIEW_OPEN_FROM = "App_Viewed_Open_From";
    public static final String BONUS_GAME_WALLET_OFFER_19 = "Bonus_Game_Wallet_Offer_19_App_View";
    public static final String BONUS_MIGRATION_APPVIEW = "Bonus_Migration_19_App_View";
    public static final String CLICK_INSTALL = "Clicked on install button";
    public static final String DONATIONS_IMPRESSION = "Donations_Impression";
    public static final String EDITORS_CHOICE_CLICKS = "Editors_Choice_Clicks";
    public static final String HOME_PAGE_EDITORS_CHOICE_FLURRY = "Home_Page_Editors_Choice";
    private static final String IMPRESSION = "impression";
    private static final String IS_AD = "Is_ad";
    private static final String NETWORK = "network";
    public static final String OPEN_APP_VIEW = "OPEN_APP_VIEW";
    private static final String PACKAGE_NAME = "Package_name";
    private static final String POSITION = "Position";
    public static final String SIMILAR_APP_INTERACT = "Similar_App_Interact";
    private static final String TAP_ON_APP = "tap_on_app";
    private static final String TYPE = "type";
    private final String INTERSTITIAL_NETWORK_MOPUB = MoPubLog.LOGTAG;
    private AnalyticsManager analyticsManager;
    private BillingAnalytics billingAnalytics;
    private final DownloadAnalytics downloadAnalytics;
    private NavigationTracker navigationTracker;
    private StoreAnalytics storeAnalytics;

    /* renamed from: cm.aptoide.pt.app.AppViewAnalytics$1 */
    static /* synthetic */ class C16941 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action = new int[Action.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-7996855862154470885L, "cm/aptoide/pt/app/AppViewAnalytics$1", 14);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.DOWNGRADE.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            try {
                                $jacocoInit[8] = true;
                            } catch (NoSuchFieldError e5) {
                                try {
                                    $jacocoInit[10] = true;
                                } catch (NoSuchFieldError e6) {
                                    $jacocoInit[12] = true;
                                }
                            }
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.INSTALL.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.UPDATE.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.PAY.ordinal()] = 4;
            $jacocoInit[7] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.MIGRATE.ordinal()] = 5;
            $jacocoInit[9] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.OPEN.ordinal()] = 6;
            $jacocoInit[11] = true;
            $jacocoInit[13] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3130311737670584104L, "cm/aptoide/pt/app/AppViewAnalytics", 252);
        $jacocoData = probes;
        return probes;
    }

    public AppViewAnalytics(DownloadAnalytics downloadAnalytics2, AnalyticsManager analyticsManager2, NavigationTracker navigationTracker2, BillingAnalytics billingAnalytics2, StoreAnalytics storeAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadAnalytics = downloadAnalytics2;
        this.analyticsManager = analyticsManager2;
        this.navigationTracker = navigationTracker2;
        this.billingAnalytics = billingAnalytics2;
        this.storeAnalytics = storeAnalytics2;
        $jacocoInit[0] = true;
    }

    public void sendEditorsChoiceClickEvent(String packageName, String editorsBrickPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[1] = true;
        Map createEditorsChoiceClickEventMap = createEditorsChoiceClickEventMap(navigationTracker2.getPreviousScreen(), packageName, editorsBrickPosition);
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[2] = true;
        String viewName = getViewName(false);
        $jacocoInit[3] = true;
        analyticsManager2.logEvent(createEditorsChoiceClickEventMap, EDITORS_CHOICE_CLICKS, action, viewName);
        AnalyticsManager analyticsManager3 = this.analyticsManager;
        NavigationTracker navigationTracker3 = this.navigationTracker;
        $jacocoInit[4] = true;
        Map createEditorsClickEventMap = createEditorsClickEventMap(navigationTracker3.getPreviousScreen(), packageName, editorsBrickPosition);
        AnalyticsManager.Action action2 = AnalyticsManager.Action.CLICK;
        $jacocoInit[5] = true;
        String viewName2 = getViewName(false);
        $jacocoInit[6] = true;
        analyticsManager3.logEvent(createEditorsClickEventMap, HOME_PAGE_EDITORS_CHOICE_FLURRY, action2, viewName2);
        $jacocoInit[7] = true;
    }

    private Map<String, Object> createEditorsClickEventMap(ScreenTagHistory previousScreen, String packageName, String editorsBrickPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[8] = true;
        map.put(APPLICATION_NAME, packageName);
        $jacocoInit[9] = true;
        map.put("Search Position", editorsBrickPosition);
        $jacocoInit[10] = true;
        if (previousScreen == null) {
            $jacocoInit[11] = true;
        } else if (previousScreen.getFragment() == null) {
            $jacocoInit[12] = true;
        } else {
            $jacocoInit[13] = true;
            map.put("fragment", previousScreen.getFragment());
            $jacocoInit[14] = true;
        }
        $jacocoInit[15] = true;
        return map;
    }

    private Map<String, Object> createEditorsChoiceClickEventMap(ScreenTagHistory previousScreen, String packageName, String editorsBrickPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[16] = true;
        if (previousScreen == null) {
            $jacocoInit[17] = true;
        } else if (previousScreen.getFragment() == null) {
            $jacocoInit[18] = true;
        } else {
            $jacocoInit[19] = true;
            map.put("fragment", previousScreen.getFragment());
            $jacocoInit[20] = true;
        }
        map.put("package_name", packageName);
        $jacocoInit[21] = true;
        map.put("position", editorsBrickPosition);
        $jacocoInit[22] = true;
        return map;
    }

    public void sendAppViewOpenedFromEvent(String packageName, String appPublisher, String badge, boolean hasBilling, boolean hasAdvertising) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        ScreenTagHistory previousScreen = this.navigationTracker.getPreviousScreen();
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[23] = true;
        ScreenTagHistory currentScreen = navigationTracker2.getCurrentScreen();
        $jacocoInit[24] = true;
        HashMap createAppViewedFromMap = createAppViewedFromMap(previousScreen, currentScreen, packageName, appPublisher, badge, hasBilling, hasAdvertising);
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[25] = true;
        String viewName = getViewName(false);
        $jacocoInit[26] = true;
        analyticsManager2.logEvent(createAppViewedFromMap, APP_VIEW_OPEN_FROM, action, viewName);
        $jacocoInit[27] = true;
        AnalyticsManager analyticsManager3 = this.analyticsManager;
        ScreenTagHistory previousScreen2 = this.navigationTracker.getPreviousScreen();
        NavigationTracker navigationTracker3 = this.navigationTracker;
        $jacocoInit[28] = true;
        ScreenTagHistory currentScreen2 = navigationTracker3.getCurrentScreen();
        $jacocoInit[29] = true;
        Map createAppViewDataMap = createAppViewDataMap(previousScreen2, currentScreen2, packageName, hasBilling, hasAdvertising);
        AnalyticsManager.Action action2 = AnalyticsManager.Action.CLICK;
        $jacocoInit[30] = true;
        String viewName2 = getViewName(false);
        $jacocoInit[31] = true;
        analyticsManager3.logEvent(createAppViewDataMap, "OPEN_APP_VIEW", action2, viewName2);
        $jacocoInit[32] = true;
    }

    private Map<String, Object> createAppViewDataMap(ScreenTagHistory previousScreen, ScreenTagHistory currentScreen, String packageName, boolean hasBilling, boolean hasAdvertising) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, String> packageMap = new HashMap<>();
        $jacocoInit[33] = true;
        packageMap.put(Constants.PACKAGE, packageName);
        $jacocoInit[34] = true;
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[35] = true;
        data.put("app", packageMap);
        String str = APP_SHORTCUT;
        String str2 = "previous_store";
        if (previousScreen != null) {
            $jacocoInit[36] = true;
            data.put(str2, previousScreen.getStore());
            $jacocoInit[37] = true;
        } else {
            data.put(str2, str);
            $jacocoInit[38] = true;
        }
        String str3 = "previous_tag";
        if (currentScreen != null) {
            $jacocoInit[39] = true;
            data.put(str3, currentScreen.getTag());
            $jacocoInit[40] = true;
        } else {
            data.put(str3, str);
            $jacocoInit[41] = true;
        }
        data.put("appcoins_type", mapAppCoinsInfo(hasBilling, hasAdvertising));
        $jacocoInit[42] = true;
        return data;
    }

    private String mapAppCoinsInfo(boolean hasBilling, boolean hasAdvertising) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!hasBilling) {
            $jacocoInit[43] = true;
        } else if (!hasAdvertising) {
            $jacocoInit[44] = true;
        } else {
            $jacocoInit[45] = true;
            return "AppCoins Ads IAB";
        }
        if (hasBilling) {
            $jacocoInit[46] = true;
            return "AppCoins IAB";
        } else if (hasAdvertising) {
            $jacocoInit[47] = true;
            return "AppCoins Ads";
        } else {
            $jacocoInit[48] = true;
            return "None";
        }
    }

    private HashMap<String, Object> createAppViewedFromMap(ScreenTagHistory previousScreen, ScreenTagHistory currentScreen, String packageName, String appPublisher, String badge, boolean hasBilling, boolean hasAdvertising) throws NullPointerException {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, Object> map = new HashMap<>();
        if (previousScreen == null) {
            $jacocoInit[49] = true;
        } else {
            $jacocoInit[50] = true;
            if (previousScreen.getFragment() == null) {
                $jacocoInit[51] = true;
            } else {
                $jacocoInit[52] = true;
                map.put("fragment", previousScreen.getFragment());
                $jacocoInit[53] = true;
            }
            if (previousScreen.getStore() == null) {
                $jacocoInit[54] = true;
            } else {
                $jacocoInit[55] = true;
                map.put("store", previousScreen.getStore());
                $jacocoInit[56] = true;
            }
        }
        if (currentScreen == null) {
            $jacocoInit[57] = true;
        } else {
            $jacocoInit[58] = true;
            if (currentScreen.getTag() == null) {
                $jacocoInit[59] = true;
            } else {
                $jacocoInit[60] = true;
                map.put(BundleCons.TAG, currentScreen.getTag());
                $jacocoInit[61] = true;
            }
        }
        map.put("appcoins_type", mapAppCoinsInfo(hasBilling, hasAdvertising));
        $jacocoInit[62] = true;
        map.put("package_name", packageName);
        $jacocoInit[63] = true;
        map.put("application_publisher", appPublisher);
        $jacocoInit[64] = true;
        map.put("trusted_badge", badge);
        $jacocoInit[65] = true;
        return map;
    }

    public void sendOpenScreenshotEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData(ACTION, "Open Screenshot");
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[66] = true;
        String viewName = getViewName(true);
        $jacocoInit[67] = true;
        analyticsManager2.logEvent(createMapData, APP_VIEW_INTERACT, action, viewName);
        $jacocoInit[68] = true;
    }

    public void sendOpenVideoEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData(ACTION, "Open Video");
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[69] = true;
        String viewName = getViewName(true);
        $jacocoInit[70] = true;
        analyticsManager2.logEvent(createMapData, APP_VIEW_INTERACT, action, viewName);
        $jacocoInit[71] = true;
    }

    public void sendRateThisAppEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData(ACTION, "Rate This App");
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[72] = true;
        String viewName = getViewName(true);
        $jacocoInit[73] = true;
        analyticsManager2.logEvent(createMapData, APP_VIEW_INTERACT, action, viewName);
        $jacocoInit[74] = true;
    }

    public void sendReadAllEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData(ACTION, "Read All");
        AnalyticsManager.Action action = AnalyticsManager.Action.VIEW;
        $jacocoInit[75] = true;
        String viewName = getViewName(true);
        $jacocoInit[76] = true;
        analyticsManager2.logEvent(createMapData, APP_VIEW_INTERACT, action, viewName);
        $jacocoInit[77] = true;
    }

    public void sendFollowStoreEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData(ACTION, "Follow Store");
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[78] = true;
        String viewName = getViewName(true);
        $jacocoInit[79] = true;
        analyticsManager2.logEvent(createMapData, APP_VIEW_INTERACT, action, viewName);
        $jacocoInit[80] = true;
    }

    public void sendOpenStoreEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData(ACTION, "Open Store");
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[81] = true;
        String viewName = getViewName(true);
        $jacocoInit[82] = true;
        analyticsManager2.logEvent(createMapData, APP_VIEW_INTERACT, action, viewName);
        $jacocoInit[83] = true;
    }

    public void sendOtherVersionsEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData(ACTION, "Other Versions");
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[84] = true;
        String viewName = getViewName(true);
        $jacocoInit[85] = true;
        analyticsManager2.logEvent(createMapData, APP_VIEW_INTERACT, action, viewName);
        $jacocoInit[86] = true;
    }

    public void sendReadMoreEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData(ACTION, "Read More");
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[87] = true;
        String viewName = getViewName(true);
        $jacocoInit[88] = true;
        analyticsManager2.logEvent(createMapData, APP_VIEW_INTERACT, action, viewName);
        $jacocoInit[89] = true;
    }

    public void sendFlagAppEvent(String flagDetail) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createFlagAppEventData = createFlagAppEventData("Flag App", flagDetail);
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[90] = true;
        String viewName = getViewName(true);
        $jacocoInit[91] = true;
        analyticsManager2.logEvent(createFlagAppEventData, APP_VIEW_INTERACT, action, viewName);
        $jacocoInit[92] = true;
    }

    public void sendSimilarAppsInteractEvent(String type) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createSimilarAppsEventData = createSimilarAppsEventData(type);
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[93] = true;
        String viewName = getViewName(true);
        $jacocoInit[94] = true;
        analyticsManager2.logEvent(createSimilarAppsEventData, APP_VIEW_INTERACT, action, viewName);
        $jacocoInit[95] = true;
    }

    public void sendAppcInfoInteractEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData(ACTION, "AppCoins Info View");
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[96] = true;
        String viewName = getViewName(true);
        $jacocoInit[97] = true;
        analyticsManager2.logEvent(createMapData, APP_VIEW_INTERACT, action, viewName);
        $jacocoInit[98] = true;
    }

    public void sendDonateClickAfterInstall() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData(ACTION, "donate_click_after_install");
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[99] = true;
        String viewName = getViewName(true);
        $jacocoInit[100] = true;
        analyticsManager2.logEvent(createMapData, APP_VIEW_INTERACT, action, viewName);
        $jacocoInit[101] = true;
    }

    public void sendDonateClickTopDonors() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData(ACTION, "donate_click_top");
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[102] = true;
        String viewName = getViewName(true);
        $jacocoInit[103] = true;
        analyticsManager2.logEvent(createMapData, APP_VIEW_INTERACT, action, viewName);
        $jacocoInit[104] = true;
    }

    public void sendDonateImpressionAfterInstall(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData(PACKAGE_NAME, packageName);
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[105] = true;
        String viewName = getViewName(true);
        $jacocoInit[106] = true;
        analyticsManager2.logEvent(createMapData, DONATIONS_IMPRESSION, action, viewName);
        $jacocoInit[107] = true;
    }

    private Map<String, Object> createFlagAppEventData(String action, String flagDetail) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[108] = true;
        map.put(ACTION, action);
        $jacocoInit[109] = true;
        map.put("flag_details", flagDetail);
        $jacocoInit[110] = true;
        return map;
    }

    private Map<String, Object> createSimilarAppsEventData(String type) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[111] = true;
        map.put(ACTION, "Open App on Recommended for you");
        $jacocoInit[112] = true;
        map.put("bundle_tag", type);
        $jacocoInit[113] = true;
        return map;
    }

    public void sendBadgeClickEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData(ACTION, "Open Badge");
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[114] = true;
        String viewName = getViewName(true);
        $jacocoInit[115] = true;
        analyticsManager2.logEvent(createMapData, APP_VIEW_INTERACT, action, viewName);
        $jacocoInit[116] = true;
    }

    public void sendAppShareEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData(ACTION, "App Share");
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        $jacocoInit[117] = true;
        String viewName = getViewName(true);
        $jacocoInit[118] = true;
        analyticsManager2.logEvent(createMapData, APP_VIEW_INTERACT, action, viewName);
        $jacocoInit[119] = true;
    }

    public void sendRemoteInstallEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createMapData = createMapData(ACTION, "Install on TV");
        AnalyticsManager.Action action = AnalyticsManager.Action.INSTALL;
        $jacocoInit[120] = true;
        String viewName = getViewName(true);
        $jacocoInit[121] = true;
        analyticsManager2.logEvent(createMapData, APP_VIEW_INTERACT, action, viewName);
        $jacocoInit[122] = true;
    }

    public void clickOnInstallButton(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            HashMap<String, Object> map = new HashMap<>();
            $jacocoInit[123] = true;
            map.put(APPLICATION_NAME, app.getPackageName());
            $jacocoInit[124] = true;
            String str = APPLICATION_PUBLISHER;
            Developer developer = app.getDeveloper();
            $jacocoInit[125] = true;
            String name = developer.getName();
            $jacocoInit[126] = true;
            map.put(str, name);
            AnalyticsManager analyticsManager2 = this.analyticsManager;
            String str2 = CLICK_INSTALL;
            AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
            $jacocoInit[127] = true;
            String viewName = getViewName(true);
            $jacocoInit[128] = true;
            analyticsManager2.logEvent(map, str2, action, viewName);
            $jacocoInit[129] = true;
        } catch (Exception e) {
            $jacocoInit[130] = true;
            e.printStackTrace();
            $jacocoInit[131] = true;
        }
        $jacocoInit[132] = true;
    }

    public void clickOnInstallButton(String packageName, String developerName, String type) {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, Object> map = new HashMap<>();
        $jacocoInit[133] = true;
        map.put("type", type);
        $jacocoInit[134] = true;
        map.put(APPLICATION_NAME, packageName);
        $jacocoInit[135] = true;
        map.put(APPLICATION_PUBLISHER, developerName);
        $jacocoInit[136] = true;
        this.analyticsManager.logEvent(map, CLICK_INSTALL, AnalyticsManager.Action.CLICK, getViewName(true));
        $jacocoInit[137] = true;
    }

    private Map<String, Object> createMapData(String key, String value) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[138] = true;
        data.put(key, value);
        $jacocoInit[139] = true;
        return data;
    }

    private String getViewName(boolean isCurrent) {
        boolean[] $jacocoInit = $jacocoInit();
        String viewName = this.navigationTracker.getViewName(isCurrent);
        $jacocoInit[140] = true;
        return viewName;
    }

    public void setupDownloadEvents(Download download, int campaignId, String abTestGroup, Action downloadAction, AnalyticsManager.Action action, String trustedValue, String editorsChoice, OfferResponseStatus offerResponseStatus) {
        Action action2 = downloadAction;
        boolean[] $jacocoInit = $jacocoInit();
        if (Action.MIGRATE.equals(action2)) {
            $jacocoInit[141] = true;
            DownloadAnalytics downloadAnalytics2 = this.downloadAnalytics;
            String md5 = download.getMd5();
            String packageName = download.getPackageName();
            InstallType installType = InstallType.UPDATE_TO_APPC;
            $jacocoInit[142] = true;
            boolean hasAppc = download.hasAppc();
            $jacocoInit[143] = true;
            downloadAnalytics2.migrationClicked(md5, packageName, trustedValue, editorsChoice, installType, action, offerResponseStatus, hasAppc);
            $jacocoInit[144] = true;
            this.downloadAnalytics.downloadStartEvent(download, campaignId, abTestGroup, AppContext.APPVIEW, action, true);
            $jacocoInit[145] = true;
        } else {
            DownloadAnalytics downloadAnalytics3 = this.downloadAnalytics;
            String md52 = download.getMd5();
            String packageName2 = download.getPackageName();
            $jacocoInit[146] = true;
            InstallType mapDownloadAction = mapDownloadAction(action2);
            $jacocoInit[147] = true;
            boolean hasAppc2 = download.hasAppc();
            $jacocoInit[148] = true;
            downloadAnalytics3.installClicked(md52, packageName2, trustedValue, editorsChoice, mapDownloadAction, action, offerResponseStatus, hasAppc2);
            $jacocoInit[149] = true;
            this.downloadAnalytics.downloadStartEvent(download, campaignId, abTestGroup, AppContext.APPVIEW, action, false);
            $jacocoInit[150] = true;
        }
        $jacocoInit[151] = true;
    }

    private InstallType mapDownloadAction(Action downloadAction) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallType installType = InstallType.INSTALL;
        $jacocoInit[152] = true;
        switch (C16941.$SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[downloadAction.ordinal()]) {
            case 1:
                installType = InstallType.DOWNGRADE;
                $jacocoInit[154] = true;
                break;
            case 2:
                installType = InstallType.INSTALL;
                $jacocoInit[155] = true;
                break;
            case 3:
                installType = InstallType.UPDATE;
                $jacocoInit[156] = true;
                break;
            case 4:
            case 5:
            case 6:
                StringBuilder sb = new StringBuilder();
                sb.append("Mapping an invalid download action ");
                $jacocoInit[157] = true;
                sb.append(downloadAction.name());
                IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
                $jacocoInit[158] = true;
                throw illegalStateException;
            default:
                $jacocoInit[153] = true;
                break;
        }
        $jacocoInit[159] = true;
        return installType;
    }

    public void sendDownloadPauseEvent(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadAnalytics.downloadInteractEvent(packageName, "pause");
        $jacocoInit[160] = true;
    }

    public void sendDownloadCancelEvent(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadAnalytics.downloadInteractEvent(packageName, "cancel");
        $jacocoInit[161] = true;
    }

    public void sendPaymentViewShowEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        this.billingAnalytics.sendPaymentViewShowEvent();
        $jacocoInit[162] = true;
    }

    public void sendStoreOpenEvent(Store store) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeAnalytics.sendStoreOpenEvent("App View", store.getName(), true);
        $jacocoInit[163] = true;
    }

    public void similarAppBundleImpression(Network network, boolean isAd) {
        boolean[] $jacocoInit = $jacocoInit();
        similarAppInteract(network, IMPRESSION, null, -1, isAd);
        $jacocoInit[164] = true;
    }

    public void similarAppClick(SimilarAppType type, Network network, String packageName, int position, boolean isAd) {
        boolean[] $jacocoInit = $jacocoInit();
        if (type.equals(SimilarAppType.APPC_SIMILAR_APPS)) {
            $jacocoInit[165] = true;
            similarAppcAppClick(position, packageName);
            $jacocoInit[166] = true;
        } else if (!type.equals(SimilarAppType.SIMILAR_APPS)) {
            $jacocoInit[167] = true;
        } else {
            $jacocoInit[168] = true;
            similarAppInteract(network, TAP_ON_APP, packageName, position, isAd);
            $jacocoInit[169] = true;
        }
        $jacocoInit[170] = true;
    }

    private void similarAppcAppClick(int position, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[171] = true;
        data.put(ACTION, TAP_ON_APP);
        $jacocoInit[172] = true;
        data.put(PACKAGE_NAME, packageName);
        $jacocoInit[173] = true;
        data.put(POSITION, Integer.valueOf(position));
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[174] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[175] = true;
        analyticsManager2.logEvent(data, APPC_SIMILAR_APP_INTERACT, action, viewName);
        $jacocoInit[176] = true;
    }

    private void similarAppInteract(Network network, String action, String packageName, int position, boolean isAd) {
        String str;
        AnalyticsManager.Action action2;
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[177] = true;
        if (!isAd) {
            $jacocoInit[178] = true;
        } else {
            data.put(NETWORK, network.getName());
            $jacocoInit[179] = true;
        }
        data.put(ACTION, action);
        $jacocoInit[180] = true;
        if (isAd) {
            $jacocoInit[181] = true;
            str = "true";
        } else {
            $jacocoInit[182] = true;
            str = AdultContentAnalytics.UNLOCK;
        }
        data.put(IS_AD, str);
        $jacocoInit[183] = true;
        if (!action.equals(TAP_ON_APP)) {
            $jacocoInit[184] = true;
        } else {
            $jacocoInit[185] = true;
            data.put(PACKAGE_NAME, packageName);
            $jacocoInit[186] = true;
            data.put(POSITION, Integer.valueOf(position));
            $jacocoInit[187] = true;
        }
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        $jacocoInit[188] = true;
        if (action.equals(IMPRESSION)) {
            action2 = AnalyticsManager.Action.IMPRESSION;
            $jacocoInit[189] = true;
        } else {
            action2 = AnalyticsManager.Action.CLICK;
            $jacocoInit[190] = true;
        }
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[191] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[192] = true;
        analyticsManager2.logEvent(data, SIMILAR_APP_INTERACT, action2, viewName);
        $jacocoInit[193] = true;
    }

    public void installInterstitialImpression() {
        boolean[] $jacocoInit = $jacocoInit();
        installInterstitialInteract(IMPRESSION, MoPubLog.LOGTAG);
        $jacocoInit[194] = true;
    }

    public void installInterstitialClick() {
        boolean[] $jacocoInit = $jacocoInit();
        installInterstitialInteract(TAP_ON_APP, MoPubLog.LOGTAG);
        $jacocoInit[195] = true;
    }

    private void installInterstitialInteract(String action, String network) {
        AnalyticsManager.Action action2;
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[196] = true;
        data.put(ACTION, action);
        $jacocoInit[197] = true;
        data.put("bundle_tag", AdType.INTERSTITIAL);
        $jacocoInit[198] = true;
        data.put(NETWORK, network);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        $jacocoInit[199] = true;
        if (action.equals(IMPRESSION)) {
            action2 = AnalyticsManager.Action.IMPRESSION;
            $jacocoInit[200] = true;
        } else {
            action2 = AnalyticsManager.Action.CLICK;
            $jacocoInit[201] = true;
        }
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[202] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[203] = true;
        analyticsManager2.logEvent(data, APP_VIEW_INTERACT, action2, viewName);
        $jacocoInit[204] = true;
    }

    public void sendAdsBlockByOfferEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[205] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[206] = true;
        analyticsManager2.logEvent(null, ADS_BLOCK_BY_OFFER, action, viewName);
        $jacocoInit[207] = true;
    }

    public void similarAppcAppBundleImpression() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[208] = true;
        data.put(IS_AD, Boolean.valueOf(false));
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        AnalyticsManager.Action action = AnalyticsManager.Action.IMPRESSION;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[209] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[210] = true;
        analyticsManager2.logEvent(data, APPC_SIMILAR_APP_INTERACT, action, viewName);
        $jacocoInit[211] = true;
    }

    public void sendAppcMigrationAppOpen() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[212] = true;
        data.put(ACTION, "open");
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        AnalyticsManager.Action action = AnalyticsManager.Action.OPEN;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[213] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[214] = true;
        analyticsManager2.logEvent(data, BONUS_MIGRATION_APPVIEW, action, viewName);
        $jacocoInit[215] = true;
    }

    private void sendPromotionImpressionEvent(String promotion) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[216] = true;
        data.put(ACTION, IMPRESSION);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        AnalyticsManager.Action action = AnalyticsManager.Action.IMPRESSION;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[217] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[218] = true;
        analyticsManager2.logEvent(data, promotion, action, viewName);
        $jacocoInit[219] = true;
    }

    public void sendPromotionImpression(String promotionId) {
        boolean[] $jacocoInit = $jacocoInit();
        if (promotionId.equals("BONUS_MIGRATION_19")) {
            $jacocoInit[220] = true;
            sendPromotionImpressionEvent(BONUS_MIGRATION_APPVIEW);
            $jacocoInit[221] = true;
        } else if (!promotionId.equals("BONUS_GAME_WALLET_OFFER_19")) {
            $jacocoInit[222] = true;
        } else {
            $jacocoInit[223] = true;
            sendPromotionImpressionEvent(BONUS_GAME_WALLET_OFFER_19);
            $jacocoInit[224] = true;
        }
        $jacocoInit[225] = true;
    }

    public void sendAppcMigrationUpdateClick() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[226] = true;
        data.put(ACTION, "update to appc");
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[227] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[228] = true;
        analyticsManager2.logEvent(data, BONUS_MIGRATION_APPVIEW, action, viewName);
        $jacocoInit[229] = true;
    }

    public void sendInstallPromotionApp() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[230] = true;
        data.put(ACTION, "install appc app");
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[231] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[232] = true;
        analyticsManager2.logEvent(data, BONUS_GAME_WALLET_OFFER_19, action, viewName);
        $jacocoInit[233] = true;
    }

    private void sendInstallAppcWalletEvent(String promotion) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[234] = true;
        data.put(ACTION, "install wallet");
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[235] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[236] = true;
        analyticsManager2.logEvent(data, promotion, action, viewName);
        $jacocoInit[237] = true;
    }

    public void sendInstallAppcWallet(String promotionId) {
        boolean[] $jacocoInit = $jacocoInit();
        sendInstallAppcWalletEvent(mapToPromotionOffer(promotionId));
        $jacocoInit[238] = true;
    }

    private void sendClickOnNoThanksWalletInstall(String promotion) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[239] = true;
        data.put(ACTION, "no thanks");
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[240] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[241] = true;
        analyticsManager2.logEvent(data, promotion, action, viewName);
        $jacocoInit[242] = true;
    }

    public void sendClickOnNoThanksWallet(String promotionId) {
        boolean[] $jacocoInit = $jacocoInit();
        sendClickOnNoThanksWalletInstall(mapToPromotionOffer(promotionId));
        $jacocoInit[243] = true;
    }

    private void sendClickOnClaimAppcWalletPromotion(String promotion) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[244] = true;
        data.put(ACTION, "claim");
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[245] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[246] = true;
        analyticsManager2.logEvent(data, promotion, action, viewName);
        $jacocoInit[247] = true;
    }

    public void sendClickOnClaimAppViewPromotion(String promotionId) {
        boolean[] $jacocoInit = $jacocoInit();
        sendClickOnClaimAppcWalletPromotion(mapToPromotionOffer(promotionId));
        $jacocoInit[248] = true;
    }

    private String mapToPromotionOffer(String promotionId) {
        boolean[] $jacocoInit = $jacocoInit();
        if (promotionId.equals("BONUS_MIGRATION_19")) {
            $jacocoInit[249] = true;
            return BONUS_MIGRATION_APPVIEW;
        } else if (promotionId.equals("BONUS_GAME_WALLET_OFFER_19")) {
            $jacocoInit[250] = true;
            return BONUS_GAME_WALLET_OFFER_19;
        } else {
            $jacocoInit[251] = true;
            return "N/A";
        }
    }
}
