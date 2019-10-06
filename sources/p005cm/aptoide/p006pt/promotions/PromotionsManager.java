package p005cm.aptoide.p006pt.promotions;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.util.Iterator;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.download.AppContext;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.download.Origin;
import p005cm.aptoide.p006pt.install.Install;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;
import p005cm.aptoide.p006pt.promotions.Promotion.ClaimAction;
import p005cm.aptoide.p006pt.wallet.WalletAppProvider;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.promotions.PromotionsManager */
public class PromotionsManager {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String WALLET_PACKAGE_NAME = "com.appcoins.wallet";
    private final DownloadFactory downloadFactory;
    private final DownloadStateParser downloadStateParser;
    private final InstallAnalytics installAnalytics;
    private final InstallManager installManager;
    private final InstalledRepository installedRepository;
    private final MoPubAdsManager moPubAdsManager;
    private final NotificationAnalytics notificationAnalytics;
    private final PackageManager packageManager;
    private final PromotionViewAppMapper promotionViewAppMapper;
    private final PromotionsAnalytics promotionsAnalytics;
    private final PromotionsService promotionsService;
    private final WalletAppProvider walletAppProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8937966209981573134L, "cm/aptoide/pt/promotions/PromotionsManager", 105);
        $jacocoData = probes;
        return probes;
    }

    public PromotionsManager(PromotionViewAppMapper promotionViewAppMapper2, InstallManager installManager2, DownloadFactory downloadFactory2, DownloadStateParser downloadStateParser2, PromotionsAnalytics promotionsAnalytics2, NotificationAnalytics notificationAnalytics2, InstallAnalytics installAnalytics2, PackageManager packageManager2, PromotionsService promotionsService2, InstalledRepository installedRepository2, MoPubAdsManager moPubAdsManager2, WalletAppProvider walletAppProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionViewAppMapper = promotionViewAppMapper2;
        this.installManager = installManager2;
        this.downloadFactory = downloadFactory2;
        this.downloadStateParser = downloadStateParser2;
        this.promotionsAnalytics = promotionsAnalytics2;
        this.notificationAnalytics = notificationAnalytics2;
        this.installAnalytics = installAnalytics2;
        this.packageManager = packageManager2;
        this.promotionsService = promotionsService2;
        this.installedRepository = installedRepository2;
        this.moPubAdsManager = moPubAdsManager2;
        this.walletAppProvider = walletAppProvider2;
        $jacocoInit[0] = true;
    }

    public Single<List<PromotionApp>> getPromotionApps(String promotionId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<List<PromotionApp>> promotionApps = this.promotionsService.getPromotionApps(promotionId);
        $jacocoInit[1] = true;
        return promotionApps;
    }

    public Single<PromotionsModel> getPromotionsModel(String promotionsType) {
        boolean[] $jacocoInit = $jacocoInit();
        Single promotions = this.promotionsService.getPromotions(promotionsType);
        C4488Ua ua = new C4488Ua(this);
        $jacocoInit[2] = true;
        Single<PromotionsModel> a = promotions.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) ua);
        $jacocoInit[3] = true;
        return a;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo15719b(List promotions) {
        boolean[] $jacocoInit = $jacocoInit();
        if (promotions.isEmpty()) {
            $jacocoInit[98] = true;
            Single a = Single.m734a(PromotionsModel.ofError());
            $jacocoInit[99] = true;
            return a;
        }
        PromotionMeta meta = (PromotionMeta) promotions.get(0);
        $jacocoInit[100] = true;
        Single d = getPromotionApps(meta.getPromotionId()).mo3698d(new C4491Va(this, meta));
        $jacocoInit[101] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ PromotionsModel mo15709a(PromotionMeta meta, List appsList) {
        boolean[] $jacocoInit = $jacocoInit();
        String promotionId = meta.getPromotionId();
        $jacocoInit[102] = true;
        int totalAppc = getTotalAppc(appsList);
        String title = meta.getTitle();
        String background = meta.getBackground();
        $jacocoInit[103] = true;
        PromotionsModel promotionsModel = new PromotionsModel(promotionId, appsList, totalAppc, title, background, isWalletInstalled(), false);
        $jacocoInit[104] = true;
        return promotionsModel;
    }

    public C0120S<List<Promotion>> getPromotionsForPackage(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single promotionsForPackage = this.promotionsService.getPromotionsForPackage(packageName);
        $jacocoInit[4] = true;
        C0120S c = promotionsForPackage.mo3696c();
        C4485Ta ta = C4485Ta.f8093a;
        $jacocoInit[5] = true;
        C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) ta);
        C4477Qa qa = new C4477Qa(this);
        $jacocoInit[6] = true;
        C0120S j = h.mo3669j(qa);
        $jacocoInit[7] = true;
        C0120S<List<Promotion>> m = j.mo3675m();
        $jacocoInit[8] = true;
        return m;
    }

    /* renamed from: a */
    static /* synthetic */ Iterable m8879a(List list) {
        $jacocoInit()[97] = true;
        return list;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p005cm.aptoide.p006pt.promotions.Promotion mapPromotionAction(p005cm.aptoide.p006pt.promotions.Promotion r7) {
        /*
            r6 = this;
            boolean[] r0 = $jacocoInit()
            java.lang.String r1 = r7.getPromotionId()
            int r2 = r1.hashCode()
            r3 = 546494617(0x2092d899, float:2.4876694E-19)
            r4 = 0
            r5 = 1
            if (r2 == r3) goto L_0x0030
            r3 = 1299041924(0x4d6dce84, float:2.493584E8)
            if (r2 == r3) goto L_0x001d
            r1 = 9
            r0[r1] = r5
            goto L_0x003c
        L_0x001d:
            java.lang.String r2 = "BONUS_GAME_WALLET_OFFER_19"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x002a
            r1 = 12
            r0[r1] = r5
            goto L_0x003c
        L_0x002a:
            r1 = 13
            r0[r1] = r5
            r1 = 1
            goto L_0x0043
        L_0x0030:
            java.lang.String r2 = "BONUS_MIGRATION_19"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x003e
            r1 = 10
            r0[r1] = r5
        L_0x003c:
            r1 = -1
            goto L_0x0043
        L_0x003e:
            r1 = 11
            r0[r1] = r5
            r1 = 0
        L_0x0043:
            if (r1 == 0) goto L_0x006b
            if (r1 == r5) goto L_0x004c
            r1 = 14
            r0[r1] = r5
            goto L_0x0078
        L_0x004c:
            r1 = 2
            cm.aptoide.pt.promotions.Promotion$ClaimAction[] r1 = new p005cm.aptoide.p006pt.promotions.Promotion.ClaimAction[r1]
            cm.aptoide.pt.promotions.Promotion$ClaimAction r2 = p005cm.aptoide.p006pt.promotions.Promotion.ClaimAction.INSTALL
            r1[r4] = r2
            cm.aptoide.pt.promotions.Promotion$ClaimAction r2 = p005cm.aptoide.p006pt.promotions.Promotion.ClaimAction.MIGRATE
            r1[r5] = r2
            r2 = 16
            r0[r2] = r5
            java.util.List r1 = java.util.Arrays.asList(r1)
            r2 = 17
            r0[r2] = r5
            r7.setClaimActions(r1)
            r1 = 18
            r0[r1] = r5
            goto L_0x0078
        L_0x006b:
            cm.aptoide.pt.promotions.Promotion$ClaimAction r1 = p005cm.aptoide.p006pt.promotions.Promotion.ClaimAction.MIGRATE
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r7.setClaimActions(r1)
            r1 = 15
            r0[r1] = r5
        L_0x0078:
            r1 = 19
            r0[r1] = r5
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.promotions.PromotionsManager.mapPromotionAction(cm.aptoide.pt.promotions.Promotion):cm.aptoide.pt.promotions.Promotion");
    }

    private boolean isWalletInstalled() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[20] = true;
        for (ApplicationInfo applicationInfo : this.packageManager.getInstalledApplications(0)) {
            $jacocoInit[21] = true;
            if (applicationInfo.packageName.equals(WALLET_PACKAGE_NAME)) {
                $jacocoInit[22] = true;
                return true;
            }
            $jacocoInit[23] = true;
        }
        $jacocoInit[24] = true;
        return false;
    }

    private int getTotalAppc(List<PromotionApp> appsList) {
        boolean[] $jacocoInit = $jacocoInit();
        int total = 0;
        $jacocoInit[25] = true;
        $jacocoInit[26] = true;
        for (PromotionApp promotionApp : appsList) {
            $jacocoInit[27] = true;
            total = (int) (((float) total) + promotionApp.getAppcValue());
            $jacocoInit[28] = true;
        }
        $jacocoInit[29] = true;
        return total;
    }

    public C0120S<PromotionViewApp> getDownload(PromotionApp promotionApp) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallManager installManager2 = this.installManager;
        String md5 = promotionApp.getMd5();
        String packageName = promotionApp.getPackageName();
        $jacocoInit[30] = true;
        int versionCode = promotionApp.getVersionCode();
        $jacocoInit[31] = true;
        C0120S install = installManager2.getInstall(md5, packageName, versionCode);
        C4464Na na = new C4464Na(this, promotionApp);
        $jacocoInit[32] = true;
        C0120S<PromotionViewApp> j = install.mo3669j(na);
        $jacocoInit[33] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ PromotionViewApp mo15708a(PromotionApp promotionApp, Install install) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionViewApp mapInstallToPromotionApp = this.promotionViewAppMapper.mapInstallToPromotionApp(install, promotionApp);
        $jacocoInit[96] = true;
        return mapInstallToPromotionApp;
    }

    public boolean shouldShowRootInstallWarningPopup() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean showWarning = this.installManager.showWarning();
        $jacocoInit[34] = true;
        return showWarning;
    }

    public void allowRootInstall(Boolean answer) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.rootInstallAllowed(answer.booleanValue());
        $jacocoInit[35] = true;
    }

    public C0117M downloadApp(PromotionViewApp promotionViewApp) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadFactory downloadFactory2 = this.downloadFactory;
        DownloadStateParser downloadStateParser2 = this.downloadStateParser;
        $jacocoInit[36] = true;
        DownloadModel downloadModel = promotionViewApp.getDownloadModel();
        $jacocoInit[37] = true;
        Action action = downloadModel.getAction();
        $jacocoInit[38] = true;
        int parseDownloadAction = downloadStateParser2.parseDownloadAction(action);
        $jacocoInit[39] = true;
        String name = promotionViewApp.getName();
        String packageName = promotionViewApp.getPackageName();
        $jacocoInit[40] = true;
        String md5 = promotionViewApp.getMd5();
        String appIcon = promotionViewApp.getAppIcon();
        String versionName = promotionViewApp.getVersionName();
        $jacocoInit[41] = true;
        int versionCode = promotionViewApp.getVersionCode();
        String downloadPath = promotionViewApp.getDownloadPath();
        $jacocoInit[42] = true;
        String alternativePath = promotionViewApp.getAlternativePath();
        Obb obb = promotionViewApp.getObb();
        $jacocoInit[43] = true;
        boolean hasAppc = promotionViewApp.hasAppc();
        long size = promotionViewApp.getSize();
        $jacocoInit[44] = true;
        C0120S c = C0120S.m652c(downloadFactory2.create(parseDownloadAction, name, packageName, md5, appIcon, versionName, versionCode, downloadPath, alternativePath, obb, hasAppc, size));
        C4494Wa wa = new C4494Wa(this, promotionViewApp);
        $jacocoInit[45] = true;
        C0120S i = c.mo3668i(wa);
        C4479Ra ra = new C4479Ra(this);
        $jacocoInit[46] = true;
        C0120S g = i.mo3663g((C0132p<? super T, ? extends C0117M>) ra);
        $jacocoInit[47] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[48] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo15711a(PromotionViewApp promotionViewApp, Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Single adsVisibilityStatus = this.moPubAdsManager.getAdsVisibilityStatus();
        C4470Pa pa = new C4470Pa(this, download, promotionViewApp);
        $jacocoInit[89] = true;
        Single b = adsVisibilityStatus.mo3695b((C0129b<? super T>) pa);
        C4458La la = new C4458La(download);
        $jacocoInit[90] = true;
        Single d = b.mo3698d(la);
        $jacocoInit[91] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15713a(Download download, PromotionViewApp promotionViewApp, OfferResponseStatus offerResponseStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[93] = true;
        String packageName = promotionViewApp.getPackageName();
        long appId = promotionViewApp.getAppId();
        $jacocoInit[94] = true;
        setupDownloadEvents(download, packageName, appId, offerResponseStatus);
        $jacocoInit[95] = true;
    }

    /* renamed from: b */
    static /* synthetic */ Download m8881b(Download download, OfferResponseStatus __) {
        $jacocoInit()[92] = true;
        return download;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo15710a(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M install = this.installManager.install(download);
        $jacocoInit[88] = true;
        return install;
    }

    private void setupDownloadEvents(Download download, String packageName, long appId, OfferResponseStatus offerResponseStatus) {
        String str = packageName;
        long j = appId;
        boolean[] $jacocoInit = $jacocoInit();
        int campaignId = this.notificationAnalytics.getCampaignId(str, j);
        $jacocoInit[49] = true;
        String abTestGroup = this.notificationAnalytics.getAbTestingGroup(str, j);
        $jacocoInit[50] = true;
        this.promotionsAnalytics.setupDownloadEvents(download, campaignId, abTestGroup, AnalyticsManager.Action.CLICK, offerResponseStatus);
        $jacocoInit[51] = true;
        InstallAnalytics installAnalytics2 = this.installAnalytics;
        String packageName2 = download.getPackageName();
        int versionCode = download.getVersionCode();
        AnalyticsManager.Action action = AnalyticsManager.Action.INSTALL;
        AppContext appContext = AppContext.PROMOTIONS;
        DownloadStateParser downloadStateParser2 = this.downloadStateParser;
        $jacocoInit[52] = true;
        Origin origin = downloadStateParser2.getOrigin(download.getAction());
        $jacocoInit[53] = true;
        boolean hasAppc = download.hasAppc();
        $jacocoInit[54] = true;
        installAnalytics2.installStarted(packageName2, versionCode, action, appContext, origin, campaignId, abTestGroup, false, hasAppc);
        $jacocoInit[55] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15715a(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.stopInstallation(md5);
        $jacocoInit[87] = true;
    }

    public C0117M pauseDownload(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C4467Oa(this, md5));
        $jacocoInit[56] = true;
        return c;
    }

    public C0117M cancelDownload(String md5, String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C4455Ka(this, md5, packageName, versionCode));
        $jacocoInit[57] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15716a(String md5, String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.removeInstallationFile(md5, packageName, versionCode);
        $jacocoInit[86] = true;
    }

    public C0117M resumeDownload(String md5, String packageName, long appId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single download = this.installManager.getDownload(md5);
        C4500Ya ya = new C4500Ya(this, packageName, appId);
        $jacocoInit[58] = true;
        Single a = download.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) ya);
        C4452Ja ja = new C4452Ja(this);
        $jacocoInit[59] = true;
        C0117M b = a.mo3693b((C0132p<? super T, ? extends C0117M>) ja);
        $jacocoInit[60] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo15712a(String packageName, long appId, Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Single adsVisibilityStatus = this.moPubAdsManager.getAdsVisibilityStatus();
        C4497Xa xa = new C4497Xa(this, download, packageName, appId);
        $jacocoInit[81] = true;
        Single b = adsVisibilityStatus.mo3695b((C0129b<? super T>) xa);
        C4461Ma ma = new C4461Ma(download);
        $jacocoInit[82] = true;
        Single d = b.mo3698d(ma);
        $jacocoInit[83] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15714a(Download download, String packageName, long appId, OfferResponseStatus offerResponseStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        setupDownloadEvents(download, packageName, appId, offerResponseStatus);
        $jacocoInit[85] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Download m8877a(Download download, OfferResponseStatus __) {
        $jacocoInit()[84] = true;
        return download;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo15718b(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M install = this.installManager.install(download);
        $jacocoInit[80] = true;
        return install;
    }

    public void saveWalletAddress(String walletAddress) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsService.saveWalletAddress(walletAddress);
        $jacocoInit[61] = true;
    }

    public String getWalletAddress() {
        boolean[] $jacocoInit = $jacocoInit();
        String walletAddress = this.promotionsService.getWalletAddress();
        $jacocoInit[62] = true;
        return walletAddress;
    }

    public Single<ClaimStatusWrapper> claimPromotion(String walletAddress, String packageName, String captcha, String promotionId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<ClaimStatusWrapper> claimPromotion = this.promotionsService.claimPromotion(walletAddress, packageName, captcha, promotionId);
        $jacocoInit[63] = true;
        return claimPromotion;
    }

    public C0120S<String> getPackageSignature(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installed = this.installedRepository.getInstalled(packageName);
        C4482Sa sa = C4482Sa.f8090a;
        $jacocoInit[64] = true;
        C0120S<String> j = installed.mo3669j(sa);
        $jacocoInit[65] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ String m8880a(Installed installed) {
        boolean[] $jacocoInit = $jacocoInit();
        if (installed != null) {
            $jacocoInit[77] = true;
            String signature = installed.getSignature();
            $jacocoInit[78] = true;
            return signature;
        }
        $jacocoInit[79] = true;
        return "";
    }

    public C0120S<WalletApp> getWalletApp() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<WalletApp> walletApp = this.walletAppProvider.getWalletApp();
        $jacocoInit[66] = true;
        return walletApp;
    }

    public Promotion getClaimablePromotion(List<Promotion> promotions, ClaimAction claimAction) {
        boolean[] $jacocoInit = $jacocoInit();
        Promotion claimablePromotion = null;
        $jacocoInit[67] = true;
        Iterator it = promotions.iterator();
        $jacocoInit[68] = true;
        while (true) {
            if (!it.hasNext()) {
                $jacocoInit[69] = true;
                break;
            }
            Promotion promotion = (Promotion) it.next();
            $jacocoInit[70] = true;
            List claimActions = promotion.getClaimActions();
            $jacocoInit[71] = true;
            if (claimActions.contains(claimAction)) {
                if (promotion.isClaimable()) {
                    claimablePromotion = promotion;
                    $jacocoInit[74] = true;
                    break;
                }
                $jacocoInit[73] = true;
            } else {
                $jacocoInit[72] = true;
            }
            $jacocoInit[75] = true;
        }
        $jacocoInit[76] = true;
        return claimablePromotion;
    }
}
