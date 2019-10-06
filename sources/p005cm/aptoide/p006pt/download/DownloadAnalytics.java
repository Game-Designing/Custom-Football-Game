package p005cm.aptoide.p006pt.download;

import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.downloadmanager.Analytics;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p005cm.aptoide.p006pt.view.DeepLinkManager;

/* renamed from: cm.aptoide.pt.download.DownloadAnalytics */
public class DownloadAnalytics implements Analytics, p005cm.aptoide.p006pt.downloadmanager.DownloadAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String AB_TEST_GROUP = "ab_test_group";
    private static final String ACTION = "action";
    private static final String ADS_BLOCK_BY_OFFER = "ads_block_by_offer";
    private static final String APP = "app";
    private static final String APPC = "appc";
    private static final String CAMPAIGN_ID = "campaign_id";
    public static final String DOWNLOAD_COMPLETE_EVENT = "Download Complete";
    public static final String DOWNLOAD_EVENT_NAME = "DOWNLOAD";
    public static final String DOWNLOAD_INTERACT = "Download_Interact";
    public static final String EDITORS_CHOICE_DOWNLOAD_COMPLETE_EVENT_NAME = "Editors Choice_Download_Complete";
    private static final String ERROR = "error";
    private static final String FAIL = "FAIL";
    private static final String FRAGMENT = "fragment";
    private static final String MAIN = "MAIN";
    private static final String MESSAGE = "message";
    private static final String MIGRATOR = "migrator";
    private static final String MIRROR = "mirror";
    private static final String NETWORK = "network";
    public static final String NOTIFICATION_DOWNLOAD_COMPLETE_EVENT_NAME = "Aptoide_Push_Notification_Download_Complete";
    private static final String OBB = "obb";
    private static final String ORIGIN = "origin";
    private static final String PACKAGE = "package";
    private static final String PACKAGENAME = "Package Name";
    private static final String PACKAGE_NAME = "package_name";
    private static final String PATCH = "PATCH";
    private static final String POSITION = "position";
    private static final String PREVIOUS_CONTEXT = "previous_context";
    private static final String PREVIOUS_TAG = "previous_tag";
    private static final String RESULT = "result";
    private static final String STATUS = "status";
    private static final String STORE = "store";
    private static final String SUCCESS = "SUCC";
    private static final String TAG = "tag";
    private static final String TELECO = "teleco";
    private static final String TRUSTED_BADGE = "Trusted Badge";
    private static final String TYPE = "type";
    private static final String UPDATE_TO_APPC = "UPDATE TO APPC";
    private static final String URL = "url";
    private AnalyticsManager analyticsManager;
    private final Map<String, DownloadEvent> cache = new HashMap();
    private final ConnectivityManager connectivityManager;
    private NavigationTracker navigationTracker;
    private final TelephonyManager telephonyManager;

    /* renamed from: cm.aptoide.pt.download.DownloadAnalytics$1 */
    static /* synthetic */ class C29291 {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(481986164287428381L, "cm/aptoide/pt/download/DownloadAnalytics$1", 0);
            $jacocoData = probes;
            return probes;
        }
    }

    /* renamed from: cm.aptoide.pt.download.DownloadAnalytics$AppContext */
    public enum AppContext {
        TIMELINE,
        APPVIEW,
        UPDATE_TAB,
        APPS_FRAGMENT,
        APPS_MIGRATOR_SEE_MORE,
        AUTO_UPDATE,
        DOWNLOADS,
        EDITORIAL,
        PROMOTIONS,
        WALLET_INSTALL_ACTIVITY;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.download.DownloadAnalytics$DownloadEvent */
    public static class DownloadEvent {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final Action action;
        private final String context;
        private final Map<String, Object> data;
        private final String eventName;
        private boolean hadProgress;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-2655829818900455435L, "cm/aptoide/pt/download/DownloadAnalytics$DownloadEvent", 10);
            $jacocoData = probes;
            return probes;
        }

        /* synthetic */ DownloadEvent(String x0, Map x1, AppContext x2, Action x3, C29291 x4) {
            boolean[] $jacocoInit = $jacocoInit();
            this(x0, x1, x2, x3);
            $jacocoInit[9] = true;
        }

        private DownloadEvent(String eventName2, Map<String, Object> data2, AppContext context2, Action action2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.data = data2;
            this.eventName = eventName2;
            this.action = action2;
            $jacocoInit[0] = true;
            this.context = context2.name();
            this.hadProgress = false;
            $jacocoInit[1] = true;
        }

        public DownloadEvent(String eventName2, HashMap<String, Object> data2, String context2, Action action2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.data = data2;
            this.eventName = eventName2;
            this.action = action2;
            this.context = context2;
            this.hadProgress = false;
            $jacocoInit[2] = true;
        }

        public boolean isHadProgress() {
            boolean[] $jacocoInit = $jacocoInit();
            boolean z = this.hadProgress;
            $jacocoInit[3] = true;
            return z;
        }

        public void setHadProgress(boolean hadProgress2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.hadProgress = hadProgress2;
            $jacocoInit[4] = true;
        }

        public Map<String, Object> getData() {
            boolean[] $jacocoInit = $jacocoInit();
            Map<String, Object> map = this.data;
            $jacocoInit[5] = true;
            return map;
        }

        public String getEventName() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.eventName;
            $jacocoInit[6] = true;
            return str;
        }

        public Action getAction() {
            boolean[] $jacocoInit = $jacocoInit();
            Action action2 = this.action;
            $jacocoInit[7] = true;
            return action2;
        }

        public String getContext() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.context;
            $jacocoInit[8] = true;
            return str;
        }
    }

    /* renamed from: cm.aptoide.pt.download.DownloadAnalytics$Origin */
    public enum Origin {
        INSTALL,
        UPDATE,
        DOWNGRADE,
        UPDATE_ALL;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5995047219354261038L, "cm/aptoide/pt/download/DownloadAnalytics", 222);
        $jacocoData = probes;
        return probes;
    }

    public DownloadAnalytics(ConnectivityManager connectivityManager2, TelephonyManager telephonyManager2, NavigationTracker navigationTracker2, AnalyticsManager analyticsManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.connectivityManager = connectivityManager2;
        this.telephonyManager = telephonyManager2;
        this.navigationTracker = navigationTracker2;
        this.analyticsManager = analyticsManager2;
        $jacocoInit[1] = true;
    }

    public void onError(Download download, Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append(download.getPackageName());
        sb.append(download.getVersionCode());
        sb.append(DOWNLOAD_EVENT_NAME);
        String key = sb.toString();
        $jacocoInit[2] = true;
        DownloadEvent downloadEvent = (DownloadEvent) this.cache.get(key);
        if (downloadEvent == null) {
            $jacocoInit[3] = true;
        } else {
            $jacocoInit[4] = true;
            Map<String, Object> data = downloadEvent.getData();
            $jacocoInit[5] = true;
            Map<String, Object> result = new HashMap<>();
            $jacocoInit[6] = true;
            Map<String, Object> error = new HashMap<>();
            $jacocoInit[7] = true;
            result.put(STATUS, FAIL);
            $jacocoInit[8] = true;
            Class cls = throwable.getClass();
            $jacocoInit[9] = true;
            String simpleName = cls.getSimpleName();
            $jacocoInit[10] = true;
            error.put("type", simpleName);
            $jacocoInit[11] = true;
            error.put("message", throwable.getMessage());
            $jacocoInit[12] = true;
            result.put(ERROR, error);
            $jacocoInit[13] = true;
            data.put(RESULT, result);
            $jacocoInit[14] = true;
            AnalyticsManager analyticsManager2 = this.analyticsManager;
            String eventName = downloadEvent.getEventName();
            Action action = downloadEvent.getAction();
            $jacocoInit[15] = true;
            String context = downloadEvent.getContext();
            $jacocoInit[16] = true;
            analyticsManager2.logEvent(data, eventName, action, context);
            $jacocoInit[17] = true;
            this.cache.remove(key);
            $jacocoInit[18] = true;
        }
        $jacocoInit[19] = true;
    }

    public void onDownloadComplete(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        sendDownloadCompletedEvent(download);
        $jacocoInit[20] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(download.getMd5());
        sb.append(EDITORS_CHOICE_DOWNLOAD_COMPLETE_EVENT_NAME);
        sendDownloadEvent(sb.toString());
        $jacocoInit[21] = true;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(download.getMd5());
        sb2.append(DOWNLOAD_COMPLETE_EVENT);
        sendDownloadEvent(sb2.toString());
        $jacocoInit[22] = true;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(download.getMd5());
        sb3.append(NOTIFICATION_DOWNLOAD_COMPLETE_EVENT_NAME);
        sendDownloadEvent(sb3.toString());
        $jacocoInit[23] = true;
    }

    public void onDownloadComplete(String md5, String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        sendDownloadCompletedEvent(packageName, versionCode);
        $jacocoInit[24] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(md5);
        sb.append(EDITORS_CHOICE_DOWNLOAD_COMPLETE_EVENT_NAME);
        sendDownloadEvent(sb.toString());
        $jacocoInit[25] = true;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(md5);
        sb2.append(DOWNLOAD_COMPLETE_EVENT);
        sendDownloadEvent(sb2.toString());
        $jacocoInit[26] = true;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(md5);
        sb3.append(NOTIFICATION_DOWNLOAD_COMPLETE_EVENT_NAME);
        sendDownloadEvent(sb3.toString());
        $jacocoInit[27] = true;
    }

    public void onError(String packageName, int versionCode, Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(versionCode);
        sb.append(DOWNLOAD_EVENT_NAME);
        String key = sb.toString();
        $jacocoInit[28] = true;
        DownloadEvent downloadEvent = (DownloadEvent) this.cache.get(key);
        if (downloadEvent == null) {
            $jacocoInit[29] = true;
        } else {
            $jacocoInit[30] = true;
            Map<String, Object> data = downloadEvent.getData();
            $jacocoInit[31] = true;
            Map<String, Object> result = new HashMap<>();
            $jacocoInit[32] = true;
            Map<String, Object> error = new HashMap<>();
            $jacocoInit[33] = true;
            result.put(STATUS, FAIL);
            $jacocoInit[34] = true;
            Class cls = throwable.getClass();
            $jacocoInit[35] = true;
            String simpleName = cls.getSimpleName();
            $jacocoInit[36] = true;
            error.put("type", simpleName);
            $jacocoInit[37] = true;
            error.put("message", throwable.getMessage());
            $jacocoInit[38] = true;
            result.put(ERROR, error);
            $jacocoInit[39] = true;
            data.put(RESULT, result);
            $jacocoInit[40] = true;
            AnalyticsManager analyticsManager2 = this.analyticsManager;
            String eventName = downloadEvent.getEventName();
            Action action = downloadEvent.getAction();
            $jacocoInit[41] = true;
            String context = downloadEvent.getContext();
            $jacocoInit[42] = true;
            analyticsManager2.logEvent(data, eventName, action, context);
            $jacocoInit[43] = true;
            this.cache.remove(key);
            $jacocoInit[44] = true;
        }
        $jacocoInit[45] = true;
    }

    private void sendDownloadCompletedEvent(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append(download.getPackageName());
        sb.append(download.getVersionCode());
        sb.append(DOWNLOAD_EVENT_NAME);
        String key = sb.toString();
        $jacocoInit[46] = true;
        DownloadEvent downloadEvent = (DownloadEvent) this.cache.get(key);
        $jacocoInit[47] = true;
        if (!downloadEvent.isHadProgress()) {
            $jacocoInit[48] = true;
        } else {
            $jacocoInit[49] = true;
            Map<String, Object> data = downloadEvent.getData();
            $jacocoInit[50] = true;
            Map<String, Object> result = new HashMap<>();
            $jacocoInit[51] = true;
            result.put(STATUS, SUCCESS);
            $jacocoInit[52] = true;
            data.put(RESULT, result);
            $jacocoInit[53] = true;
            AnalyticsManager analyticsManager2 = this.analyticsManager;
            String eventName = downloadEvent.getEventName();
            Action action = downloadEvent.getAction();
            $jacocoInit[54] = true;
            String context = downloadEvent.getContext();
            $jacocoInit[55] = true;
            analyticsManager2.logEvent(data, eventName, action, context);
            $jacocoInit[56] = true;
            this.cache.remove(key);
            $jacocoInit[57] = true;
        }
        $jacocoInit[58] = true;
    }

    private void sendDownloadCompletedEvent(String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(versionCode);
        sb.append(DOWNLOAD_EVENT_NAME);
        String key = sb.toString();
        $jacocoInit[59] = true;
        DownloadEvent downloadEvent = (DownloadEvent) this.cache.get(key);
        $jacocoInit[60] = true;
        if (!downloadEvent.isHadProgress()) {
            $jacocoInit[61] = true;
        } else {
            $jacocoInit[62] = true;
            Map<String, Object> data = downloadEvent.getData();
            $jacocoInit[63] = true;
            Map<String, Object> result = new HashMap<>();
            $jacocoInit[64] = true;
            result.put(STATUS, SUCCESS);
            $jacocoInit[65] = true;
            data.put(RESULT, result);
            $jacocoInit[66] = true;
            AnalyticsManager analyticsManager2 = this.analyticsManager;
            String eventName = downloadEvent.getEventName();
            Action action = downloadEvent.getAction();
            $jacocoInit[67] = true;
            String context = downloadEvent.getContext();
            $jacocoInit[68] = true;
            analyticsManager2.logEvent(data, eventName, action, context);
            $jacocoInit[69] = true;
            this.cache.remove(key);
            $jacocoInit[70] = true;
        }
        $jacocoInit[71] = true;
    }

    private void sendDownloadEvent(String downloadCacheKey) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadEvent downloadEvent = (DownloadEvent) this.cache.get(downloadCacheKey);
        $jacocoInit[72] = true;
        if (downloadEvent == null) {
            $jacocoInit[73] = true;
        } else if (!downloadEvent.isHadProgress()) {
            $jacocoInit[74] = true;
        } else {
            $jacocoInit[75] = true;
            AnalyticsManager analyticsManager2 = this.analyticsManager;
            Map data = downloadEvent.getData();
            String eventName = downloadEvent.getEventName();
            $jacocoInit[76] = true;
            Action action = downloadEvent.getAction();
            String context = downloadEvent.getContext();
            $jacocoInit[77] = true;
            analyticsManager2.logEvent(data, eventName, action, context);
            $jacocoInit[78] = true;
            this.cache.remove(downloadCacheKey);
            $jacocoInit[79] = true;
        }
        $jacocoInit[80] = true;
    }

    public void downloadStartEvent(Download download, Action action, AppContext context, Boolean isMigration) {
        boolean[] $jacocoInit = $jacocoInit();
        downloadStartEvent(download, 0, null, context, action, isMigration.booleanValue());
        $jacocoInit[81] = true;
    }

    public void downloadStartEvent(Download download, int campaignId, String abTestGroup, AppContext context, Action action, boolean isMigration) {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap hashMap = new HashMap();
        $jacocoInit[82] = true;
        ScreenTagHistory screenTagHistory = this.navigationTracker.getPreviousScreen();
        $jacocoInit[83] = true;
        hashMap.put(APP, createAppData(download));
        $jacocoInit[84] = true;
        String connectionType = SystemU.getConnectionType(this.connectivityManager);
        $jacocoInit[85] = true;
        String upperCase = connectionType.toUpperCase();
        $jacocoInit[86] = true;
        hashMap.put(NETWORK, upperCase);
        String str = ORIGIN;
        if (isMigration) {
            $jacocoInit[87] = true;
            hashMap.put(str, UPDATE_TO_APPC);
            $jacocoInit[88] = true;
        } else {
            hashMap.put(str, getOrigin(download));
            $jacocoInit[89] = true;
        }
        hashMap.put(PREVIOUS_CONTEXT, screenTagHistory.getFragment());
        $jacocoInit[90] = true;
        hashMap.put(PREVIOUS_TAG, screenTagHistory.getTag());
        $jacocoInit[91] = true;
        ScreenTagHistory previousScreen = this.navigationTracker.getPreviousScreen();
        $jacocoInit[92] = true;
        String store = previousScreen.getStore();
        $jacocoInit[93] = true;
        hashMap.put("store", store);
        $jacocoInit[94] = true;
        hashMap.put(TELECO, SystemU.getCarrierName(this.telephonyManager));
        if (campaignId <= 0) {
            $jacocoInit[95] = true;
            String str2 = abTestGroup;
        } else {
            $jacocoInit[96] = true;
            hashMap.put(CAMPAIGN_ID, Integer.valueOf(campaignId));
            $jacocoInit[97] = true;
            hashMap.put(AB_TEST_GROUP, abTestGroup);
            $jacocoInit[98] = true;
        }
        Map<String, DownloadEvent> map = this.cache;
        StringBuilder sb = new StringBuilder();
        sb.append(download.getPackageName());
        sb.append(download.getVersionCode());
        sb.append(DOWNLOAD_EVENT_NAME);
        String sb2 = sb.toString();
        DownloadEvent downloadEvent = new DownloadEvent(DOWNLOAD_EVENT_NAME, hashMap, context, action, null);
        map.put(sb2, downloadEvent);
        $jacocoInit[99] = true;
    }

    private Map<String, Object> createAppData(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> app = new HashMap<>();
        $jacocoInit[100] = true;
        app.put("package", download.getPackageName());
        $jacocoInit[101] = true;
        app.put(APPC, Boolean.valueOf(download.hasAppc()));
        $jacocoInit[102] = true;
        return app;
    }

    public Origin getOrigin(Download download) {
        Origin origin;
        boolean[] $jacocoInit = $jacocoInit();
        int action = download.getAction();
        if (action == 0) {
            origin = Origin.INSTALL;
            $jacocoInit[103] = true;
        } else if (action == 1) {
            origin = Origin.UPDATE;
            $jacocoInit[104] = true;
        } else if (action != 2) {
            origin = Origin.INSTALL;
            $jacocoInit[106] = true;
        } else {
            origin = Origin.DOWNGRADE;
            $jacocoInit[105] = true;
        }
        $jacocoInit[107] = true;
        return origin;
    }

    public void updateDownloadEvent(String versionCode, String packageName, int fileType, String mirror, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, DownloadEvent> map = this.cache;
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(versionCode);
        sb.append(DOWNLOAD_EVENT_NAME);
        DownloadEvent downloadEvent = (DownloadEvent) map.get(sb.toString());
        $jacocoInit[108] = true;
        Map<String, Object> event = downloadEvent.getData();
        if (event == null) {
            $jacocoInit[109] = true;
        } else if (fileType == 0) {
            $jacocoInit[110] = true;
            Map<String, Object> app = (Map) event.get(APP);
            $jacocoInit[111] = true;
            app.put(MIRROR, mirror);
            $jacocoInit[112] = true;
            app.put("url", url);
            $jacocoInit[113] = true;
        } else {
            String str = OBB;
            List list = (List) event.get(str);
            if (list != null) {
                $jacocoInit[114] = true;
            } else {
                $jacocoInit[115] = true;
                list = new ArrayList();
                $jacocoInit[116] = true;
            }
            list.add(createObbData(fileType, url, mirror));
            $jacocoInit[117] = true;
            event.put(str, list);
            $jacocoInit[118] = true;
        }
        $jacocoInit[119] = true;
    }

    private Map<String, Object> createObbData(int fileType, String url, String mirror) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> obb = new HashMap<>();
        String str = "type";
        String str2 = MIRROR;
        if (fileType == 1) {
            $jacocoInit[120] = true;
            obb.put(str2, mirror);
            $jacocoInit[121] = true;
            obb.put(str, MAIN);
            $jacocoInit[122] = true;
        } else if (fileType != 2) {
            $jacocoInit[123] = true;
        } else {
            $jacocoInit[124] = true;
            obb.put(str2, mirror);
            $jacocoInit[125] = true;
            obb.put(str, PATCH);
            $jacocoInit[126] = true;
        }
        obb.put("url", url);
        $jacocoInit[127] = true;
        return obb;
    }

    public void startProgress(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        $jacocoInit[128] = true;
        sb.append(download.getPackageName());
        sb.append(download.getVersionCode());
        sb.append(DOWNLOAD_EVENT_NAME);
        String sb2 = sb.toString();
        $jacocoInit[129] = true;
        updateDownloadEventWithHasProgress(sb2);
        $jacocoInit[130] = true;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(download.getMd5());
        sb3.append(DOWNLOAD_COMPLETE_EVENT);
        updateDownloadEventWithHasProgress(sb3.toString());
        $jacocoInit[131] = true;
    }

    private void updateDownloadEventWithHasProgress(String key) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadEvent event = (DownloadEvent) this.cache.get(key);
        if (event != null) {
            $jacocoInit[132] = true;
            event.setHadProgress(true);
            $jacocoInit[133] = true;
        } else {
            Logger instance = Logger.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("Tried setting progress on an event that was not setup ");
            sb.append(key);
            String sb2 = sb.toString();
            $jacocoInit[134] = true;
            instance.mo2136d("DownloadAnalytics", sb2);
            $jacocoInit[135] = true;
        }
        $jacocoInit[136] = true;
    }

    public void installClicked(String md5, String packageName, String trustedValue, String editorsBrickPosition, InstallType installType, Action action, OfferResponseStatus offerResponseStatus, boolean hasAppc) {
        boolean[] $jacocoInit = $jacocoInit();
        setUpInstallEvent(md5, packageName, trustedValue, editorsBrickPosition, installType, action, offerResponseStatus, false, hasAppc);
        $jacocoInit[137] = true;
    }

    public void migrationClicked(String md5, String packageName, String trustedValue, String editorsBrickPosition, InstallType installType, Action action, OfferResponseStatus offerResponseStatus, boolean hasAppc) {
        boolean[] $jacocoInit = $jacocoInit();
        setUpInstallEvent(md5, packageName, trustedValue, editorsBrickPosition, installType, action, offerResponseStatus, true, hasAppc);
        $jacocoInit[138] = true;
    }

    public void migrationClicked(String md5, String packageName, Action action, OfferResponseStatus offerResponseStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        setUpInstallEvent(md5, packageName, action, offerResponseStatus, true, true);
        $jacocoInit[139] = true;
    }

    private void setUpInstallEvent(String md5, String packageName, String trustedValue, String editorsBrickPosition, InstallType installType, Action action, OfferResponseStatus offerResponseStatus, boolean isMigration, boolean hasAppc) {
        OfferResponseStatus offerResponseStatus2 = offerResponseStatus;
        boolean[] $jacocoInit = $jacocoInit();
        String currentContext = this.navigationTracker.getViewName(true);
        $jacocoInit[140] = true;
        String str = currentContext;
        String str2 = md5;
        String str3 = packageName;
        String str4 = currentContext;
        editorsChoiceDownloadCompletedEvent(str, str2, str3, editorsBrickPosition, installType, str4, action);
        $jacocoInit[141] = true;
        pushNotificationDownloadEvent(str, str2, str3, installType, action, str4);
        $jacocoInit[142] = true;
        if (!offerResponseStatus2.equals(OfferResponseStatus.NO_ADS)) {
            $jacocoInit[143] = true;
            ScreenTagHistory previousScreen = this.navigationTracker.getPreviousScreen();
            NavigationTracker navigationTracker2 = this.navigationTracker;
            $jacocoInit[144] = true;
            ScreenTagHistory currentScreen = navigationTracker2.getCurrentScreen();
            OfferResponseStatus offerResponseStatus3 = OfferResponseStatus.ADS_HIDE;
            $jacocoInit[145] = true;
            boolean equals = offerResponseStatus2.equals(offerResponseStatus3);
            $jacocoInit[146] = true;
            downloadCompleteEvent(previousScreen, currentScreen, md5, packageName, trustedValue, action, currentContext, equals, isMigration, hasAppc);
            $jacocoInit[147] = true;
        } else {
            ScreenTagHistory previousScreen2 = this.navigationTracker.getPreviousScreen();
            NavigationTracker navigationTracker3 = this.navigationTracker;
            $jacocoInit[148] = true;
            ScreenTagHistory currentScreen2 = navigationTracker3.getCurrentScreen();
            $jacocoInit[149] = true;
            Boolean valueOf = Boolean.valueOf(hasAppc);
            $jacocoInit[150] = true;
            downloadCompleteEvent(previousScreen2, currentScreen2, md5, packageName, trustedValue, action, currentContext, isMigration, valueOf);
            $jacocoInit[151] = true;
        }
        $jacocoInit[152] = true;
    }

    public void installClicked(String md5, String packageName, Action action, OfferResponseStatus offerResponseStatus, boolean isMigration, boolean hasAppc) {
        boolean[] $jacocoInit = $jacocoInit();
        setUpInstallEvent(md5, packageName, action, offerResponseStatus, isMigration, hasAppc);
        $jacocoInit[153] = true;
    }

    private void setUpInstallEvent(String md5, String packageName, Action action, OfferResponseStatus offerResponseStatus, boolean isMigration, boolean hasAppc) {
        OfferResponseStatus offerResponseStatus2 = offerResponseStatus;
        boolean[] $jacocoInit = $jacocoInit();
        String currentContext = this.navigationTracker.getViewName(true);
        $jacocoInit[154] = true;
        if (!offerResponseStatus2.equals(OfferResponseStatus.NO_ADS)) {
            $jacocoInit[155] = true;
            ScreenTagHistory previousScreen = this.navigationTracker.getPreviousScreen();
            NavigationTracker navigationTracker2 = this.navigationTracker;
            $jacocoInit[156] = true;
            ScreenTagHistory currentScreen = navigationTracker2.getCurrentScreen();
            OfferResponseStatus offerResponseStatus3 = OfferResponseStatus.ADS_HIDE;
            $jacocoInit[157] = true;
            boolean equals = offerResponseStatus2.equals(offerResponseStatus3);
            $jacocoInit[158] = true;
            downloadCompleteEvent(previousScreen, currentScreen, md5, packageName, null, action, currentContext, equals, isMigration, hasAppc);
            $jacocoInit[159] = true;
        } else {
            ScreenTagHistory previousScreen2 = this.navigationTracker.getPreviousScreen();
            NavigationTracker navigationTracker3 = this.navigationTracker;
            $jacocoInit[160] = true;
            ScreenTagHistory currentScreen2 = navigationTracker3.getCurrentScreen();
            $jacocoInit[161] = true;
            Boolean valueOf = Boolean.valueOf(hasAppc);
            $jacocoInit[162] = true;
            downloadCompleteEvent(previousScreen2, currentScreen2, md5, packageName, null, action, currentContext, isMigration, valueOf);
            $jacocoInit[163] = true;
        }
        $jacocoInit[164] = true;
    }

    public void downloadCompleteEvent(ScreenTagHistory previousScreen, ScreenTagHistory currentScreen, String id, String packageName, String trustedValue, Action action, String context, boolean areAdsBlockedByOffer, boolean isMigration, boolean hasAppc) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[165] = true;
        HashMap<String, Object> downloadMap = createDownloadCompleteEventMap(previousScreen, currentScreen, packageName, trustedValue, isMigration, hasAppc);
        $jacocoInit[166] = true;
        downloadMap.put(ADS_BLOCK_BY_OFFER, Boolean.valueOf(areAdsBlockedByOffer));
        $jacocoInit[167] = true;
        String str = DOWNLOAD_COMPLETE_EVENT;
        DownloadEvent downloadEvent = new DownloadEvent(str, downloadMap, context, action);
        $jacocoInit[168] = true;
        Map<String, DownloadEvent> map = this.cache;
        StringBuilder sb = new StringBuilder();
        String str2 = id;
        sb.append(id);
        sb.append(str);
        map.put(sb.toString(), downloadEvent);
        $jacocoInit[169] = true;
    }

    public void downloadCompleteEvent(ScreenTagHistory previousScreen, ScreenTagHistory currentScreen, String id, String packageName, String trustedValue, Action action, String context, boolean isMigration, Boolean hasAppc) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[170] = true;
        boolean booleanValue = hasAppc.booleanValue();
        $jacocoInit[171] = true;
        HashMap createDownloadCompleteEventMap = createDownloadCompleteEventMap(previousScreen, currentScreen, packageName, trustedValue, isMigration, booleanValue);
        String str = DOWNLOAD_COMPLETE_EVENT;
        DownloadEvent downloadEvent = new DownloadEvent(str, createDownloadCompleteEventMap, context, action);
        $jacocoInit[172] = true;
        Map<String, DownloadEvent> map = this.cache;
        StringBuilder sb = new StringBuilder();
        String str2 = id;
        sb.append(id);
        sb.append(str);
        map.put(sb.toString(), downloadEvent);
        $jacocoInit[173] = true;
    }

    private HashMap<String, Object> createDownloadCompleteEventMap(ScreenTagHistory previousScreen, ScreenTagHistory currentScreen, String packageName, String trustedValue, boolean isMigration, boolean hasAppc) {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, Object> downloadMap = new HashMap<>();
        $jacocoInit[174] = true;
        downloadMap.put(PACKAGENAME, packageName);
        $jacocoInit[175] = true;
        downloadMap.put(TRUSTED_BADGE, trustedValue);
        $jacocoInit[176] = true;
        downloadMap.put(APPC, Boolean.valueOf(hasAppc));
        $jacocoInit[177] = true;
        downloadMap.put(MIGRATOR, Boolean.valueOf(isMigration));
        if (previousScreen == null) {
            $jacocoInit[178] = true;
        } else {
            $jacocoInit[179] = true;
            downloadMap.put("tag", currentScreen.getTag());
            $jacocoInit[180] = true;
            if (previousScreen.getFragment() == null) {
                $jacocoInit[181] = true;
            } else {
                $jacocoInit[182] = true;
                downloadMap.put(FRAGMENT, previousScreen.getFragment());
                $jacocoInit[183] = true;
            }
            if (previousScreen.getStore() == null) {
                $jacocoInit[184] = true;
            } else {
                $jacocoInit[185] = true;
                downloadMap.put("store", previousScreen.getStore());
                $jacocoInit[186] = true;
            }
        }
        $jacocoInit[187] = true;
        return downloadMap;
    }

    private void pushNotificationDownloadEvent(String previousScreen, String id, String packageName, InstallType installType, Action action, String currentContext) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!previousScreen.equals(DeepLinkManager.DEEPLINK_KEY)) {
            $jacocoInit[188] = true;
        } else {
            $jacocoInit[189] = true;
            HashMap<String, Object> data = new HashMap<>();
            $jacocoInit[190] = true;
            data.put(PACKAGENAME, packageName);
            $jacocoInit[191] = true;
            data.put("type", installType.name());
            $jacocoInit[192] = true;
            String str = NOTIFICATION_DOWNLOAD_COMPLETE_EVENT_NAME;
            DownloadEvent downloadEvent = new DownloadEvent(str, data, currentContext, action);
            $jacocoInit[193] = true;
            Map<String, DownloadEvent> map = this.cache;
            StringBuilder sb = new StringBuilder();
            sb.append(id);
            sb.append(str);
            map.put(sb.toString(), downloadEvent);
            $jacocoInit[194] = true;
        }
        $jacocoInit[195] = true;
    }

    private void editorsChoiceDownloadCompletedEvent(String previousScreen, String id, String packageName, String editorsBrickPosition, InstallType installType, String context, Action action) {
        boolean[] $jacocoInit = $jacocoInit();
        if (editorsBrickPosition == null) {
            $jacocoInit[196] = true;
        } else if (editorsBrickPosition.isEmpty()) {
            $jacocoInit[197] = true;
        } else {
            $jacocoInit[198] = true;
            HashMap<String, Object> map = new HashMap<>();
            $jacocoInit[199] = true;
            map.put(PACKAGENAME, packageName);
            $jacocoInit[200] = true;
            map.put(FRAGMENT, previousScreen);
            $jacocoInit[201] = true;
            map.put(POSITION, editorsBrickPosition);
            $jacocoInit[202] = true;
            map.put("type", installType.name());
            $jacocoInit[203] = true;
            String str = EDITORS_CHOICE_DOWNLOAD_COMPLETE_EVENT_NAME;
            DownloadEvent downloadEvent = new DownloadEvent(str, map, context, action);
            $jacocoInit[204] = true;
            Map<String, DownloadEvent> map2 = this.cache;
            StringBuilder sb = new StringBuilder();
            sb.append(id);
            sb.append(str);
            map2.put(sb.toString(), downloadEvent);
            $jacocoInit[205] = true;
        }
        $jacocoInit[206] = true;
    }

    public void downloadInteractEvent(String packageName, String action) {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, Object> data = new HashMap<>();
        $jacocoInit[207] = true;
        data.put("package_name", packageName);
        $jacocoInit[208] = true;
        data.put("action", action);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action2 = Action.CLICK;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[209] = true;
        String viewName = navigationTracker2.getViewName(true);
        $jacocoInit[210] = true;
        analyticsManager2.logEvent(data, DOWNLOAD_INTERACT, action2, viewName);
        $jacocoInit[211] = true;
    }

    public void downloadCompleteEvent(String id, String packageName, String trustedValue, Action action, OfferResponseStatus offerResponseStatus) {
        OfferResponseStatus offerResponseStatus2 = offerResponseStatus;
        boolean[] $jacocoInit = $jacocoInit();
        String currentContext = this.navigationTracker.getViewName(true);
        $jacocoInit[212] = true;
        ScreenTagHistory previousScreen = this.navigationTracker.getPreviousScreen();
        $jacocoInit[213] = true;
        ScreenTagHistory currentScreen = this.navigationTracker.getCurrentScreen();
        $jacocoInit[214] = true;
        boolean equals = offerResponseStatus2.equals(OfferResponseStatus.NO_ADS);
        Boolean valueOf = Boolean.valueOf(false);
        if (!equals) {
            OfferResponseStatus offerResponseStatus3 = OfferResponseStatus.ADS_HIDE;
            $jacocoInit[215] = true;
            boolean equals2 = offerResponseStatus2.equals(offerResponseStatus3);
            $jacocoInit[216] = true;
            downloadCompleteEvent(previousScreen, currentScreen, id, packageName, trustedValue, action, currentContext, equals2, valueOf);
            $jacocoInit[217] = true;
        } else {
            $jacocoInit[218] = true;
            $jacocoInit[219] = true;
            downloadCompleteEvent(previousScreen, currentScreen, id, packageName, trustedValue, action, currentContext, false, valueOf);
            $jacocoInit[220] = true;
        }
        $jacocoInit[221] = true;
    }
}
