package p005cm.aptoide.p006pt.wallet;

import java.util.HashMap;
import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.app.AppViewAnalytics;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.download.DownloadAnalytics.AppContext;
import p005cm.aptoide.p006pt.download.Origin;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallAnalytics */
/* compiled from: WalletInstallAnalytics.kt */
public final class WalletInstallAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String APPLICATION_NAME = "Application Name";
    private final String APPLICATION_PUBLISHER = "Application Publisher";
    private final String CLICK_INSTALL = AppViewAnalytics.CLICK_INSTALL;
    private final String TYPE = "type";
    private final String VIEW_CONTEXT = "WalletInstallActivity";
    private final AnalyticsManager analyticsManager;
    private final DownloadAnalytics downloadAnalytics;
    private final DownloadStateParser downloadStateParser;
    private final InstallAnalytics installAnalytics;
    private final NavigationTracker navigationTracker;
    private final NotificationAnalytics notificationAnalytics;
    private boolean shouldRegister = true;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6947433076706400440L, "cm/aptoide/pt/wallet/WalletInstallAnalytics", 45);
        $jacocoData = probes;
        return probes;
    }

    public WalletInstallAnalytics(DownloadAnalytics downloadAnalytics2, NotificationAnalytics notificationAnalytics2, InstallAnalytics installAnalytics2, DownloadStateParser downloadStateParser2, AnalyticsManager analyticsManager2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(downloadAnalytics2, "downloadAnalytics");
        C14281f.m45916b(notificationAnalytics2, "notificationAnalytics");
        C14281f.m45916b(installAnalytics2, "installAnalytics");
        C14281f.m45916b(downloadStateParser2, "downloadStateParser");
        C14281f.m45916b(analyticsManager2, "analyticsManager");
        C14281f.m45916b(navigationTracker2, "navigationTracker");
        $jacocoInit[43] = true;
        this.downloadAnalytics = downloadAnalytics2;
        this.notificationAnalytics = notificationAnalytics2;
        this.installAnalytics = installAnalytics2;
        this.downloadStateParser = downloadStateParser2;
        this.analyticsManager = analyticsManager2;
        this.navigationTracker = navigationTracker2;
        $jacocoInit[44] = true;
    }

    public final DownloadAnalytics getDownloadAnalytics() {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadAnalytics downloadAnalytics2 = this.downloadAnalytics;
        $jacocoInit[37] = true;
        return downloadAnalytics2;
    }

    public final NotificationAnalytics getNotificationAnalytics() {
        boolean[] $jacocoInit = $jacocoInit();
        NotificationAnalytics notificationAnalytics2 = this.notificationAnalytics;
        $jacocoInit[38] = true;
        return notificationAnalytics2;
    }

    public final InstallAnalytics getInstallAnalytics() {
        boolean[] $jacocoInit = $jacocoInit();
        InstallAnalytics installAnalytics2 = this.installAnalytics;
        $jacocoInit[39] = true;
        return installAnalytics2;
    }

    public final DownloadStateParser getDownloadStateParser() {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadStateParser downloadStateParser2 = this.downloadStateParser;
        $jacocoInit[40] = true;
        return downloadStateParser2;
    }

    public final AnalyticsManager getAnalyticsManager() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        $jacocoInit[41] = true;
        return analyticsManager2;
    }

    public final NavigationTracker getNavigationTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[42] = true;
        return navigationTracker2;
    }

    private final void setupDownloadAnalyticsEvents(Download download, int campaignId, String abTestGroup, Action downloadAction, AnalyticsManager.Action action, OfferResponseStatus offerResponseStatus) {
        Action action2 = downloadAction;
        boolean[] $jacocoInit = $jacocoInit();
        DownloadAnalytics downloadAnalytics2 = this.downloadAnalytics;
        AppContext appContext = AppContext.WALLET_INSTALL_ACTIVITY;
        $jacocoInit[0] = true;
        downloadAnalytics2.downloadStartEvent(download, campaignId, abTestGroup, appContext, action, false);
        if (action2 != Action.INSTALL) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            DownloadAnalytics downloadAnalytics3 = this.downloadAnalytics;
            String md5 = download.getMd5();
            String packageName = download.getPackageName();
            $jacocoInit[3] = true;
            boolean hasAppc = download.hasAppc();
            $jacocoInit[4] = true;
            downloadAnalytics3.installClicked(md5, packageName, action, offerResponseStatus, false, hasAppc);
            $jacocoInit[5] = true;
        }
        if (Action.MIGRATE != action2) {
            $jacocoInit[6] = true;
            AnalyticsManager.Action action3 = action;
            OfferResponseStatus offerResponseStatus2 = offerResponseStatus;
        } else {
            $jacocoInit[7] = true;
            DownloadAnalytics downloadAnalytics4 = this.downloadAnalytics;
            String md52 = download.getMd5();
            String packageName2 = download.getPackageName();
            $jacocoInit[8] = true;
            downloadAnalytics4.migrationClicked(md52, packageName2, action, offerResponseStatus);
            $jacocoInit[9] = true;
        }
        $jacocoInit[10] = true;
    }

    public final void setupDownloadEvents(Download download, Action downloadAction, long appId, OfferResponseStatus offerResponseStatus) {
        boolean z;
        Action action = downloadAction;
        long j = appId;
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(download, "download");
        C14281f.m45916b(offerResponseStatus, "offerResponseStatus");
        $jacocoInit[11] = true;
        int campaignId = this.notificationAnalytics.getCampaignId(download.getPackageName(), j);
        $jacocoInit[12] = true;
        String abTestGroup = this.notificationAnalytics.getAbTestingGroup(download.getPackageName(), j);
        $jacocoInit[13] = true;
        C14281f.m45913a((Object) abTestGroup, "abTestGroup");
        AnalyticsManager.Action action2 = AnalyticsManager.Action.CLICK;
        $jacocoInit[14] = true;
        setupDownloadAnalyticsEvents(download, campaignId, abTestGroup, downloadAction, action2, offerResponseStatus);
        $jacocoInit[15] = true;
        InstallAnalytics installAnalytics2 = this.installAnalytics;
        String packageName = download.getPackageName();
        int versionCode = download.getVersionCode();
        AnalyticsManager.Action action3 = AnalyticsManager.Action.INSTALL;
        p005cm.aptoide.p006pt.download.AppContext appContext = p005cm.aptoide.p006pt.download.AppContext.WALLET_INSTALL_ACTIVITY;
        $jacocoInit[16] = true;
        Origin origin = this.downloadStateParser.getOrigin(download.getAction());
        if (action == null) {
            $jacocoInit[17] = true;
        } else if (action != Action.MIGRATE) {
            $jacocoInit[18] = true;
        } else {
            $jacocoInit[19] = true;
            z = true;
            boolean hasAppc = download.hasAppc();
            $jacocoInit[21] = true;
            installAnalytics2.installStarted(packageName, versionCode, action3, appContext, origin, campaignId, abTestGroup, z, hasAppc);
            $jacocoInit[22] = true;
        }
        $jacocoInit[20] = true;
        z = false;
        boolean hasAppc2 = download.hasAppc();
        $jacocoInit[21] = true;
        installAnalytics2.installStarted(packageName, versionCode, action3, appContext, origin, campaignId, abTestGroup, z, hasAppc2);
        $jacocoInit[22] = true;
    }

    public final void sendClickOnInstallButtonEvent(String packageName, String applicationPublisher) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(packageName, "packageName");
        C14281f.m45916b(applicationPublisher, "applicationPublisher");
        $jacocoInit[23] = true;
        HashMap map = new HashMap();
        $jacocoInit[24] = true;
        map.put(this.TYPE, "Install");
        $jacocoInit[25] = true;
        map.put(this.APPLICATION_NAME, packageName);
        $jacocoInit[26] = true;
        map.put(this.APPLICATION_PUBLISHER, applicationPublisher);
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        String str = this.CLICK_INSTALL;
        AnalyticsManager.Action action = AnalyticsManager.Action.CLICK;
        String str2 = this.VIEW_CONTEXT;
        $jacocoInit[27] = true;
        analyticsManager2.logEvent(map, str, action, str2);
        $jacocoInit[28] = true;
    }

    public final void setupHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        ScreenTagHistory historyTracker = getHistoryTracker();
        if (!this.shouldRegister) {
            $jacocoInit[29] = true;
        } else if (historyTracker != null) {
            this.navigationTracker.registerScreen(historyTracker);
            $jacocoInit[34] = true;
        } else {
            $jacocoInit[30] = true;
            StringBuilder sb = new StringBuilder();
            sb.append("If ");
            $jacocoInit[31] = true;
            sb.append(getClass().getSimpleName());
            sb.append(" should be logged to screen history, it has to return a value on method NavigationTrackFragment#getHistoryTracker");
            String sb2 = sb.toString();
            $jacocoInit[32] = true;
            RuntimeException runtimeException = new RuntimeException(sb2);
            $jacocoInit[33] = true;
            throw runtimeException;
        }
        this.shouldRegister = false;
        $jacocoInit[35] = true;
    }

    private final ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        ScreenTagHistory build = Builder.build(this.VIEW_CONTEXT);
        $jacocoInit[36] = true;
        return build;
    }
}
