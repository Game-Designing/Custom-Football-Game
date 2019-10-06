package p005cm.aptoide.p006pt.home.apps;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.Update;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.download.DownloadAnalytics.AppContext;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.download.Origin;
import p005cm.aptoide.p006pt.install.Install;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.install.InstallManager;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.home.apps.SeeMoreAppcManager */
public class SeeMoreAppcManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AppMapper appMapper;
    private final DownloadAnalytics downloadAnalytics;
    private final DownloadFactory downloadFactory;
    private final InstallAnalytics installAnalytics;
    private final InstallManager installManager;
    private final UpdatesManager updatesManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8402555012612205511L, "cm/aptoide/pt/home/apps/SeeMoreAppcManager", 52);
        $jacocoData = probes;
        return probes;
    }

    public SeeMoreAppcManager(UpdatesManager updatesManager2, InstallManager installManager2, AppMapper appMapper2, DownloadFactory downloadFactory2, DownloadAnalytics downloadAnalytics2, InstallAnalytics installAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.updatesManager = updatesManager2;
        this.installManager = installManager2;
        this.appMapper = appMapper2;
        this.downloadFactory = downloadFactory2;
        this.downloadAnalytics = downloadAnalytics2;
        this.installAnalytics = installAnalytics2;
        $jacocoInit[0] = true;
    }

    public C0120S<List<App>> getAppcUpgradesList(boolean isExcluded) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S appcUpgradesList = this.updatesManager.getAppcUpgradesList(isExcluded);
        $jacocoInit[1] = true;
        C0120S b = appcUpgradesList.mo3628b();
        C3640Yd yd = new C3640Yd(this);
        $jacocoInit[2] = true;
        C0120S<List<App>> j = b.mo3669j(yd);
        $jacocoInit[3] = true;
        return j;
    }

    /* renamed from: b */
    public /* synthetic */ List mo14854b(List updates) {
        boolean[] $jacocoInit = $jacocoInit();
        List mapUpdateToUpdateAppList = this.appMapper.mapUpdateToUpdateAppList(updates);
        $jacocoInit[51] = true;
        return mapUpdateToUpdateAppList;
    }

    public C0120S<List<App>> getAppcUpgradeDownloadsList() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installations = this.installManager.getInstallations();
        $jacocoInit[4] = true;
        C0120S b = installations.mo3628b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        $jacocoInit[5] = true;
        C0120S e = b.mo3655e(200, timeUnit);
        C3581Od od = new C3581Od(this);
        $jacocoInit[6] = true;
        C0120S<List<App>> f = e.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) od);
        $jacocoInit[7] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo14852a(List installations) {
        boolean[] $jacocoInit = $jacocoInit();
        if (installations == null) {
            $jacocoInit[40] = true;
        } else if (installations.isEmpty()) {
            $jacocoInit[41] = true;
        } else {
            C0120S c = C0120S.m652c(installations);
            C3628Wd wd = C3628Wd.f7020a;
            $jacocoInit[43] = true;
            C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) wd);
            C3604Sd sd = new C3604Sd(this);
            $jacocoInit[44] = true;
            C0120S f = h.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) sd);
            $jacocoInit[45] = true;
            C0120S m = f.mo3675m();
            C3593Qd qd = new C3593Qd(this);
            $jacocoInit[46] = true;
            C0120S j = m.mo3669j(qd);
            $jacocoInit[47] = true;
            return j;
        }
        C0120S c2 = C0120S.m651c();
        $jacocoInit[42] = true;
        return c2;
    }

    /* renamed from: c */
    static /* synthetic */ Iterable m8452c(List installs) {
        $jacocoInit()[50] = true;
        return installs;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo14851a(Install install) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S filterNonAppcUpgrade = this.updatesManager.filterNonAppcUpgrade(install);
        $jacocoInit[49] = true;
        return filterNonAppcUpgrade;
    }

    /* renamed from: d */
    public /* synthetic */ List mo14859d(List updatesList) {
        boolean[] $jacocoInit = $jacocoInit();
        List updatesList2 = this.appMapper.getUpdatesList(updatesList);
        $jacocoInit[48] = true;
        return updatesList2;
    }

    public C0117M refreshAllUpdates() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M refreshUpdates = this.updatesManager.refreshUpdates();
        $jacocoInit[8] = true;
        return refreshUpdates;
    }

    public boolean showWarning() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean showWarning = this.installManager.showWarning();
        $jacocoInit[9] = true;
        return showWarning;
    }

    public void storeRootAnswer(boolean answer) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.rootInstallAllowed(answer);
        $jacocoInit[10] = true;
    }

    public C0117M pauseDownload(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C3634Xd(this, app));
        $jacocoInit[11] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14853a(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.stopInstallation(((DownloadApp) app).getMd5());
        $jacocoInit[39] = true;
    }

    public C0117M resumeUpdate(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        Single download = this.installManager.getDownload(((UpdateApp) app).getMd5());
        C3616Ud ud = new C3616Ud(this);
        $jacocoInit[12] = true;
        C0117M b = download.mo3693b((C0132p<? super T, ? extends C0117M>) ud);
        $jacocoInit[13] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo14849a(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M install = this.installManager.install(download);
        $jacocoInit[38] = true;
        return install;
    }

    public void cancelUpdate(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallManager installManager2 = this.installManager;
        String md5 = ((UpdateApp) app).getMd5();
        UpdateApp updateApp = (UpdateApp) app;
        $jacocoInit[14] = true;
        String packageName = updateApp.getPackageName();
        int versionCode = ((UpdateApp) app).getVersionCode();
        $jacocoInit[15] = true;
        installManager2.removeInstallationFile(md5, packageName, versionCode);
        $jacocoInit[16] = true;
    }

    public C0117M pauseUpdate(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C3598Rd(this, app));
        $jacocoInit[17] = true;
        return c;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14856b(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.stopInstallation(((UpdateApp) app).getMd5());
        $jacocoInit[37] = true;
    }

    public C0117M updateApp(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        String packageName = ((UpdateApp) app).getPackageName();
        $jacocoInit[18] = true;
        C0120S update = this.updatesManager.getUpdate(packageName);
        C3610Td td = new C3610Td(this);
        $jacocoInit[19] = true;
        C0120S f = update.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) td);
        C3587Pd pd = new C3587Pd(this);
        $jacocoInit[20] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) pd);
        C3622Vd vd = new C3622Vd(this);
        $jacocoInit[21] = true;
        C0120S g = b.mo3663g((C0132p<? super T, ? extends C0117M>) vd);
        $jacocoInit[22] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[23] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo14850a(Update update) {
        boolean[] $jacocoInit = $jacocoInit();
        Download value = this.downloadFactory.create(update, true);
        $jacocoInit[35] = true;
        C0120S c = C0120S.m652c(value);
        $jacocoInit[36] = true;
        return c;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14857c(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        setupUpdateEvents(download, Origin.UPDATE, OfferResponseStatus.NO_ADS);
        $jacocoInit[34] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo14855b(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M install = this.installManager.install(download);
        $jacocoInit[33] = true;
        return install;
    }

    private void setupUpdateEvents(Download download, Origin origin, OfferResponseStatus offerResponseStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadAnalytics downloadAnalytics2 = this.downloadAnalytics;
        Action action = Action.CLICK;
        AppContext appContext = AppContext.APPS_MIGRATOR_SEE_MORE;
        $jacocoInit[24] = true;
        Boolean valueOf = Boolean.valueOf(true);
        $jacocoInit[25] = true;
        downloadAnalytics2.downloadStartEvent(download, action, appContext, valueOf);
        $jacocoInit[26] = true;
        DownloadAnalytics downloadAnalytics3 = this.downloadAnalytics;
        String md5 = download.getMd5();
        String packageName = download.getPackageName();
        Action action2 = Action.INSTALL;
        $jacocoInit[27] = true;
        boolean hasAppc = download.hasAppc();
        $jacocoInit[28] = true;
        downloadAnalytics3.installClicked(md5, packageName, action2, offerResponseStatus, true, hasAppc);
        $jacocoInit[29] = true;
        InstallAnalytics installAnalytics2 = this.installAnalytics;
        String packageName2 = download.getPackageName();
        int versionCode = download.getVersionCode();
        Action action3 = Action.INSTALL;
        p005cm.aptoide.p006pt.download.AppContext appContext2 = p005cm.aptoide.p006pt.download.AppContext.APPS_MIGRATOR_SEE_MORE;
        $jacocoInit[30] = true;
        boolean hasAppc2 = download.hasAppc();
        $jacocoInit[31] = true;
        installAnalytics2.installStarted(packageName2, versionCode, action3, appContext2, origin, true, hasAppc2);
        $jacocoInit[32] = true;
    }
}
