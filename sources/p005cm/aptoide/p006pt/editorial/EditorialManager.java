package p005cm.aptoide.p006pt.editorial;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Pay;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.download.AppContext;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.download.Origin;
import p005cm.aptoide.p006pt.install.Install;
import p005cm.aptoide.p006pt.install.Install.InstallationType;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;
import p005cm.aptoide.p006pt.reactions.ReactionsManager;
import p005cm.aptoide.p006pt.reactions.network.LoadReactionModel;
import p005cm.aptoide.p006pt.reactions.network.ReactionsResponse;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.editorial.EditorialManager */
public class EditorialManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String cardId;
    private final DownloadFactory downloadFactory;
    private DownloadStateParser downloadStateParser;
    private final EditorialAnalytics editorialAnalytics;
    private final EditorialRepository editorialRepository;
    private final InstallAnalytics installAnalytics;
    private final InstallManager installManager;
    private final MoPubAdsManager moPubAdsManager;
    private final NotificationAnalytics notificationAnalytics;
    private final ReactionsManager reactionsManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(497786903344987596L, "cm/aptoide/pt/editorial/EditorialManager", 59);
        $jacocoData = probes;
        return probes;
    }

    public EditorialManager(EditorialRepository editorialRepository2, String cardId2, InstallManager installManager2, DownloadFactory downloadFactory2, DownloadStateParser downloadStateParser2, NotificationAnalytics notificationAnalytics2, InstallAnalytics installAnalytics2, EditorialAnalytics editorialAnalytics2, ReactionsManager reactionsManager2, MoPubAdsManager moPubAdsManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editorialRepository = editorialRepository2;
        this.cardId = cardId2;
        this.installManager = installManager2;
        this.downloadFactory = downloadFactory2;
        this.downloadStateParser = downloadStateParser2;
        this.notificationAnalytics = notificationAnalytics2;
        this.installAnalytics = installAnalytics2;
        this.editorialAnalytics = editorialAnalytics2;
        this.reactionsManager = reactionsManager2;
        this.moPubAdsManager = moPubAdsManager2;
        $jacocoInit[0] = true;
    }

    public Single<EditorialViewModel> loadEditorialViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<EditorialViewModel> loadEditorialViewModel = this.editorialRepository.loadEditorialViewModel(this.cardId);
        $jacocoInit[1] = true;
        return loadEditorialViewModel;
    }

    public boolean shouldShowRootInstallWarningPopup() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean showWarning = this.installManager.showWarning();
        $jacocoInit[2] = true;
        return showWarning;
    }

    public void allowRootInstall(Boolean answer) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.rootInstallAllowed(answer.booleanValue());
        $jacocoInit[3] = true;
    }

    public C0117M downloadApp(EditorialDownloadEvent editorialDownloadEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadFactory downloadFactory2 = this.downloadFactory;
        DownloadStateParser downloadStateParser2 = this.downloadStateParser;
        $jacocoInit[4] = true;
        int parseDownloadAction = downloadStateParser2.parseDownloadAction(editorialDownloadEvent.getAction());
        $jacocoInit[5] = true;
        String appName = editorialDownloadEvent.getAppName();
        String packageName = editorialDownloadEvent.getPackageName();
        $jacocoInit[6] = true;
        String md5 = editorialDownloadEvent.getMd5();
        String icon = editorialDownloadEvent.getIcon();
        $jacocoInit[7] = true;
        String verName = editorialDownloadEvent.getVerName();
        int verCode = editorialDownloadEvent.getVerCode();
        $jacocoInit[8] = true;
        String path = editorialDownloadEvent.getPath();
        String pathAlt = editorialDownloadEvent.getPathAlt();
        $jacocoInit[9] = true;
        Obb obb = editorialDownloadEvent.getObb();
        long size = editorialDownloadEvent.getSize();
        $jacocoInit[10] = true;
        C0120S c = C0120S.m652c(downloadFactory2.create(parseDownloadAction, appName, packageName, md5, icon, verName, verCode, path, pathAlt, obb, false, size));
        C3093L l = new C3093L(this, editorialDownloadEvent);
        $jacocoInit[11] = true;
        C0120S i = c.mo3668i(l);
        C3081H h = new C3081H(this);
        $jacocoInit[12] = true;
        C0120S g = i.mo3663g((C0132p<? super T, ? extends C0117M>) h);
        $jacocoInit[13] = true;
        C0117M l2 = g.mo3673l();
        $jacocoInit[14] = true;
        return l2;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo13858a(EditorialDownloadEvent editorialDownloadEvent, Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Single adsVisibilityStatus = this.moPubAdsManager.getAdsVisibilityStatus();
        C3099N n = new C3099N(this, download, editorialDownloadEvent);
        $jacocoInit[52] = true;
        Single b = adsVisibilityStatus.mo3695b((C0129b<? super T>) n);
        C3078G g = new C3078G(download);
        $jacocoInit[53] = true;
        Single d = b.mo3698d(g);
        $jacocoInit[54] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13860a(Download download, EditorialDownloadEvent editorialDownloadEvent, OfferResponseStatus offerResponseStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[56] = true;
        String packageName = editorialDownloadEvent.getPackageName();
        long appId = editorialDownloadEvent.getAppId();
        $jacocoInit[57] = true;
        setupDownloadEvents(download, packageName, appId, offerResponseStatus);
        $jacocoInit[58] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Download m7699a(Download download, OfferResponseStatus __) {
        $jacocoInit()[55] = true;
        return download;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo13857a(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M install = this.installManager.install(download);
        $jacocoInit[51] = true;
        return install;
    }

    private void setupDownloadEvents(Download download, String packageName, long appId, OfferResponseStatus offerResponseStatus) {
        String str = packageName;
        long j = appId;
        boolean[] $jacocoInit = $jacocoInit();
        int campaignId = this.notificationAnalytics.getCampaignId(str, j);
        $jacocoInit[15] = true;
        String abTestGroup = this.notificationAnalytics.getAbTestingGroup(str, j);
        $jacocoInit[16] = true;
        this.editorialAnalytics.setupDownloadEvents(download, campaignId, abTestGroup, Action.CLICK, offerResponseStatus);
        $jacocoInit[17] = true;
        InstallAnalytics installAnalytics2 = this.installAnalytics;
        String packageName2 = download.getPackageName();
        int versionCode = download.getVersionCode();
        Action action = Action.INSTALL;
        AppContext appContext = AppContext.EDITORIAL;
        DownloadStateParser downloadStateParser2 = this.downloadStateParser;
        $jacocoInit[18] = true;
        Origin origin = downloadStateParser2.getOrigin(download.getAction());
        $jacocoInit[19] = true;
        boolean hasAppc = download.hasAppc();
        $jacocoInit[20] = true;
        installAnalytics2.installStarted(packageName2, versionCode, action, appContext, origin, campaignId, abTestGroup, false, hasAppc);
        $jacocoInit[21] = true;
    }

    public C0120S<EditorialDownloadModel> loadDownloadModel(String md5, String packageName, int versionCode, boolean paidApp, Pay pay, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S install = this.installManager.getInstall(md5, packageName, versionCode);
        C3087J j = new C3087J(this, paidApp, pay, position);
        $jacocoInit[22] = true;
        C0120S<EditorialDownloadModel> j2 = install.mo3669j(j);
        $jacocoInit[23] = true;
        return j2;
    }

    /* renamed from: a */
    public /* synthetic */ EditorialDownloadModel mo13856a(boolean paidApp, Pay pay, int position, Install install) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        DownloadStateParser downloadStateParser2 = this.downloadStateParser;
        $jacocoInit[41] = true;
        InstallationType type = install.getType();
        if (pay == null) {
            $jacocoInit[42] = true;
        } else {
            $jacocoInit[43] = true;
            if (!pay.isPaid()) {
                $jacocoInit[44] = true;
            } else {
                $jacocoInit[45] = true;
                z = true;
                $jacocoInit[47] = true;
                DownloadModel.Action parseDownloadType = downloadStateParser2.parseDownloadType(type, paidApp, z, false);
                $jacocoInit[48] = true;
                int progress = install.getProgress();
                DownloadStateParser downloadStateParser3 = this.downloadStateParser;
                $jacocoInit[49] = true;
                EditorialDownloadModel editorialDownloadModel = new EditorialDownloadModel(parseDownloadType, progress, downloadStateParser3.parseDownloadState(install.getState()), pay, position);
                $jacocoInit[50] = true;
                return editorialDownloadModel;
            }
        }
        $jacocoInit[46] = true;
        z = false;
        $jacocoInit[47] = true;
        DownloadModel.Action parseDownloadType2 = downloadStateParser2.parseDownloadType(type, paidApp, z, false);
        $jacocoInit[48] = true;
        int progress2 = install.getProgress();
        DownloadStateParser downloadStateParser32 = this.downloadStateParser;
        $jacocoInit[49] = true;
        EditorialDownloadModel editorialDownloadModel2 = new EditorialDownloadModel(parseDownloadType2, progress2, downloadStateParser32.parseDownloadState(install.getState()), pay, position);
        $jacocoInit[50] = true;
        return editorialDownloadModel2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13862a(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.stopInstallation(md5);
        $jacocoInit[40] = true;
    }

    public C0117M pauseDownload(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C3108Q(this, md5));
        $jacocoInit[24] = true;
        return c;
    }

    public C0117M resumeDownload(String md5, String packageName, long appId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single download = this.installManager.getDownload(md5);
        C3102O o = new C3102O(this, packageName, appId);
        $jacocoInit[25] = true;
        Single a = download.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) o);
        C3105P p = new C3105P(this);
        $jacocoInit[26] = true;
        C0117M b = a.mo3693b((C0132p<? super T, ? extends C0117M>) p);
        $jacocoInit[27] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo13859a(String packageName, long appId, Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Single adsVisibilityStatus = this.moPubAdsManager.getAdsVisibilityStatus();
        C3096M m = new C3096M(this, download, packageName, appId);
        $jacocoInit[35] = true;
        Single b = adsVisibilityStatus.mo3695b((C0129b<? super T>) m);
        C3090K k = new C3090K(download);
        $jacocoInit[36] = true;
        Single d = b.mo3698d(k);
        $jacocoInit[37] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13861a(Download download, String packageName, long appId, OfferResponseStatus offerResponseStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        setupDownloadEvents(download, packageName, appId, offerResponseStatus);
        $jacocoInit[39] = true;
    }

    /* renamed from: b */
    static /* synthetic */ Download m7700b(Download download, OfferResponseStatus __) {
        $jacocoInit()[38] = true;
        return download;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo13865b(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M install = this.installManager.install(download);
        $jacocoInit[34] = true;
        return install;
    }

    public C0117M cancelDownload(String md5, String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C3084I(this, md5, packageName, versionCode));
        $jacocoInit[28] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13863a(String md5, String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.removeInstallationFile(md5, packageName, versionCode);
        $jacocoInit[33] = true;
    }

    public Single<LoadReactionModel> loadReactionModel(String cardId2, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<LoadReactionModel> loadReactionModel = this.reactionsManager.loadReactionModel(cardId2, groupId);
        $jacocoInit[29] = true;
        return loadReactionModel;
    }

    public Single<ReactionsResponse> setReaction(String cardId2, String groupId, String reaction) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<ReactionsResponse> reaction2 = this.reactionsManager.setReaction(cardId2, groupId, reaction);
        $jacocoInit[30] = true;
        return reaction2;
    }

    public Single<ReactionsResponse> deleteReaction(String cardId2, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<ReactionsResponse> deleteReaction = this.reactionsManager.deleteReaction(cardId2, groupId);
        $jacocoInit[31] = true;
        return deleteReaction;
    }

    public Single<Boolean> isFirstReaction(String cardId2, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> isFirstReaction = this.reactionsManager.isFirstReaction(cardId2, groupId);
        $jacocoInit[32] = true;
        return isFirstReaction;
    }
}
