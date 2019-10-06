package p005cm.aptoide.p006pt.home.apps;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.database.realm.Update;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.download.DownloadAnalytics.AppContext;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.download.Origin;
import p005cm.aptoide.p006pt.install.Install;
import p005cm.aptoide.p006pt.install.Install.InstallationStatus;
import p005cm.aptoide.p006pt.install.Install.InstallationType;
import p005cm.aptoide.p006pt.install.InstallAnalytics;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.updates.UpdatesAnalytics;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.home.apps.AppsManager */
public class AppsManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AppMapper appMapper;
    private final Context context;
    private final DownloadAnalytics downloadAnalytics;
    private final DownloadFactory downloadFactory;
    private final InstallAnalytics installAnalytics;
    private final InstallManager installManager;
    private final MoPubAdsManager moPubAdsManager;
    private final PackageManager packageManager;
    private final UpdatesAnalytics updatesAnalytics;
    private final UpdatesManager updatesManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2163008123912164273L, "cm/aptoide/pt/home/apps/AppsManager", Opcodes.INVOKEINTERFACE);
        $jacocoData = probes;
        return probes;
    }

    public AppsManager(UpdatesManager updatesManager2, InstallManager installManager2, AppMapper appMapper2, DownloadAnalytics downloadAnalytics2, InstallAnalytics installAnalytics2, UpdatesAnalytics updatesAnalytics2, PackageManager packageManager2, Context context2, DownloadFactory downloadFactory2, MoPubAdsManager moPubAdsManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.updatesManager = updatesManager2;
        this.installManager = installManager2;
        this.appMapper = appMapper2;
        this.downloadAnalytics = downloadAnalytics2;
        this.installAnalytics = installAnalytics2;
        this.updatesAnalytics = updatesAnalytics2;
        this.packageManager = packageManager2;
        this.context = context2;
        this.downloadFactory = downloadFactory2;
        this.moPubAdsManager = moPubAdsManager2;
        $jacocoInit[0] = true;
    }

    public C0120S<List<App>> getUpdatesList(boolean isExcluded) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S updatesList = this.updatesManager.getUpdatesList(isExcluded, true);
        $jacocoInit[1] = true;
        C0120S b = updatesList.mo3628b();
        C3547J j = new C3547J(this);
        $jacocoInit[2] = true;
        C0120S<List<App>> j2 = b.mo3669j(j);
        $jacocoInit[3] = true;
        return j2;
    }

    /* renamed from: i */
    public /* synthetic */ List mo14692i(List updates) {
        boolean[] $jacocoInit = $jacocoInit();
        List mapUpdateToUpdateAppList = this.appMapper.mapUpdateToUpdateAppList(updates);
        $jacocoInit[184] = true;
        return mapUpdateToUpdateAppList;
    }

    public C0120S<List<App>> getAppcUpgradesList(boolean isExcluded) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S appcUpgradesList = this.updatesManager.getAppcUpgradesList(isExcluded);
        $jacocoInit[4] = true;
        C0120S b = appcUpgradesList.mo3628b();
        C3642Z z = new C3642Z(this);
        $jacocoInit[5] = true;
        C0120S<List<App>> j = b.mo3669j(z);
        $jacocoInit[6] = true;
        return j;
    }

    /* renamed from: b */
    public /* synthetic */ List mo14666b(List updates) {
        boolean[] $jacocoInit = $jacocoInit();
        List mapUpdateToUpdateAppList = this.appMapper.mapUpdateToUpdateAppList(updates);
        $jacocoInit[183] = true;
        return mapUpdateToUpdateAppList;
    }

    public C0120S<List<App>> getUpdateDownloadsList() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installations = this.installManager.getInstallations();
        $jacocoInit[7] = true;
        C0120S b = installations.mo3628b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        $jacocoInit[8] = true;
        C0120S e = b.mo3655e(200, timeUnit);
        C3553K k = new C3553K(this);
        $jacocoInit[9] = true;
        C0120S<List<App>> f = e.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) k);
        $jacocoInit[10] = true;
        return f;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo14691h(List installations) {
        boolean[] $jacocoInit = $jacocoInit();
        if (installations == null) {
            $jacocoInit[168] = true;
        } else if (installations.isEmpty()) {
            $jacocoInit[169] = true;
        } else {
            C0120S c = C0120S.m652c(installations);
            C3491Aa aa = C3491Aa.f6871a;
            $jacocoInit[171] = true;
            C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) aa);
            C3796va vaVar = C3796va.f7208a;
            $jacocoInit[172] = true;
            C0120S d = h.mo3653d((C0132p<? super T, Boolean>) vaVar);
            C3738ma maVar = new C3738ma(this);
            $jacocoInit[173] = true;
            C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) maVar);
            $jacocoInit[174] = true;
            C0120S m = f.mo3675m();
            C3802wa waVar = new C3802wa(this);
            $jacocoInit[175] = true;
            C0120S j = m.mo3669j(waVar);
            $jacocoInit[176] = true;
            return j;
        }
        C0120S c2 = C0120S.m651c();
        $jacocoInit[170] = true;
        return c2;
    }

    /* renamed from: l */
    static /* synthetic */ Iterable m8247l(List installs) {
        $jacocoInit()[182] = true;
        return installs;
    }

    /* renamed from: f */
    static /* synthetic */ Boolean m8244f(Install install) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (install.getType() == InstallationType.UPDATE) {
            $jacocoInit[179] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[180] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[181] = true;
        return valueOf;
    }

    /* renamed from: g */
    public /* synthetic */ C0120S mo14682g(Install install) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S filterAppcUpgrade = this.updatesManager.filterAppcUpgrade(install);
        $jacocoInit[178] = true;
        return filterAppcUpgrade;
    }

    /* renamed from: p */
    public /* synthetic */ List mo14695p(List updatesList) {
        boolean[] $jacocoInit = $jacocoInit();
        List updatesList2 = this.appMapper.getUpdatesList(updatesList);
        $jacocoInit[177] = true;
        return updatesList2;
    }

    public C0120S<List<App>> getAppcUpgradeDownloadsList() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installations = this.installManager.getInstallations();
        $jacocoInit[11] = true;
        C0120S b = installations.mo3628b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        $jacocoInit[12] = true;
        C0120S e = b.mo3655e(200, timeUnit);
        C3541I i = new C3541I(this);
        $jacocoInit[13] = true;
        C0120S<List<App>> f = e.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) i);
        $jacocoInit[14] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo14660a(List installations) {
        boolean[] $jacocoInit = $jacocoInit();
        if (installations == null) {
            $jacocoInit[157] = true;
        } else if (installations.isEmpty()) {
            $jacocoInit[158] = true;
        } else {
            C0120S c = C0120S.m652c(installations);
            C3571N n = C3571N.f6954a;
            $jacocoInit[160] = true;
            C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) n);
            C3577O o = new C3577O(this);
            $jacocoInit[161] = true;
            C0120S f = h.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) o);
            $jacocoInit[162] = true;
            C0120S m = f.mo3675m();
            C3766qa qaVar = new C3766qa(this);
            $jacocoInit[163] = true;
            C0120S j = m.mo3669j(qaVar);
            $jacocoInit[164] = true;
            return j;
        }
        C0120S c2 = C0120S.m651c();
        $jacocoInit[159] = true;
        return c2;
    }

    /* renamed from: q */
    static /* synthetic */ Iterable m8250q(List installs) {
        $jacocoInit()[167] = true;
        return installs;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo14690h(Install install) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S filterNonAppcUpgrade = this.updatesManager.filterNonAppcUpgrade(install);
        $jacocoInit[166] = true;
        return filterNonAppcUpgrade;
    }

    /* renamed from: r */
    public /* synthetic */ List mo14698r(List updatesList) {
        boolean[] $jacocoInit = $jacocoInit();
        List updatesList2 = this.appMapper.getUpdatesList(updatesList);
        $jacocoInit[165] = true;
        return updatesList2;
    }

    public C0120S<List<App>> getInstalledApps() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S fetchInstalled = this.installManager.fetchInstalled();
        $jacocoInit[15] = true;
        C0120S b = fetchInstalled.mo3628b();
        C3745na naVar = C3745na.f7154a;
        $jacocoInit[16] = true;
        C0120S h = b.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) naVar);
        C3565M m = new C3565M(this);
        $jacocoInit[17] = true;
        C0120S f = h.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) m);
        $jacocoInit[18] = true;
        C0120S m2 = f.mo3675m();
        C3778sa saVar = new C3778sa(this);
        $jacocoInit[19] = true;
        C0120S<List<App>> j = m2.mo3669j(saVar);
        $jacocoInit[20] = true;
        return j;
    }

    /* renamed from: e */
    static /* synthetic */ Iterable m8242e(List list) {
        $jacocoInit()[156] = true;
        return list;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo14659a(Installed item) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S filterUpdates = this.updatesManager.filterUpdates(item);
        $jacocoInit[155] = true;
        return filterUpdates;
    }

    /* renamed from: f */
    public /* synthetic */ List mo14680f(List installeds) {
        boolean[] $jacocoInit = $jacocoInit();
        List mapInstalledToInstalledApps = this.appMapper.mapInstalledToInstalledApps(installeds);
        $jacocoInit[154] = true;
        return mapInstalledToInstalledApps;
    }

    public C0120S<List<App>> getDownloadApps() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installations = this.installManager.getInstallations();
        C3600S s = C3600S.f6986a;
        $jacocoInit[21] = true;
        C0120S b = installations.mo3636b((C0129b<? super T>) s);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        $jacocoInit[22] = true;
        C0120S e = b.mo3655e(200, timeUnit);
        C3814ya yaVar = new C3814ya(this);
        $jacocoInit[23] = true;
        C0120S<List<App>> f = e.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) yaVar);
        $jacocoInit[24] = true;
        return f;
    }

    /* renamed from: c */
    static /* synthetic */ void m8240c(List installs) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[152] = true;
        instance.mo2136d("Apps", "emit list of installs from getDownloadApps - before throttle");
        $jacocoInit[153] = true;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo14676d(List installations) {
        boolean[] $jacocoInit = $jacocoInit();
        if (installations == null) {
            $jacocoInit[123] = true;
        } else if (installations.isEmpty()) {
            $jacocoInit[124] = true;
        } else {
            C0120S c = C0120S.m652c(installations);
            C3668ca caVar = C3668ca.f7068a;
            $jacocoInit[126] = true;
            C0120S b = c.mo3636b((C0129b<? super T>) caVar);
            C3710ia iaVar = C3710ia.f7116a;
            $jacocoInit[127] = true;
            C0120S h = b.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) iaVar);
            C3654aa aaVar = C3654aa.f7052a;
            $jacocoInit[128] = true;
            C0120S d = h.mo3653d((C0132p<? super T, Boolean>) aaVar);
            C3624W w = new C3624W(this);
            $jacocoInit[129] = true;
            C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) w);
            C3752oa oaVar = C3752oa.f7162a;
            $jacocoInit[130] = true;
            C0120S b2 = f.mo3636b((C0129b<? super T>) oaVar);
            C3618V v = new C3618V(this);
            $jacocoInit[131] = true;
            C0120S f2 = b2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) v);
            C3500Ba ba = C3500Ba.f6878a;
            $jacocoInit[132] = true;
            C0120S b3 = f2.mo3636b((C0129b<? super T>) ba);
            $jacocoInit[133] = true;
            C0120S m = b3.mo3675m();
            C3589Q q = C3589Q.f6973a;
            $jacocoInit[134] = true;
            C0120S b4 = m.mo3636b((C0129b<? super T>) q);
            C3790ua uaVar = new C3790ua(this);
            $jacocoInit[135] = true;
            C0120S j = b4.mo3669j(uaVar);
            $jacocoInit[136] = true;
            return j;
        }
        C0120S c2 = C0120S.m652c(Collections.emptyList());
        $jacocoInit[125] = true;
        return c2;
    }

    /* renamed from: j */
    static /* synthetic */ void m8245j(List __) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[150] = true;
        instance.mo2136d("Apps", "emit list of installs from getDownloadApps - after throttle");
        $jacocoInit[151] = true;
    }

    /* renamed from: k */
    static /* synthetic */ Iterable m8246k(List installs) {
        $jacocoInit()[149] = true;
        return installs;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8236a(Install install) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (install.getType() != InstallationType.UPDATE) {
            $jacocoInit[146] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[147] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[148] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo14668b(Install item) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S filterInstalled = this.installManager.filterInstalled(item);
        $jacocoInit[145] = true;
        return filterInstalled;
    }

    /* renamed from: c */
    static /* synthetic */ void m8239c(Install item) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("filtered installed - is not installed -> ");
        $jacocoInit[143] = true;
        sb.append(item.getPackageName());
        instance.mo2136d("Apps", sb.toString());
        $jacocoInit[144] = true;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo14675d(Install item) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S filterAppcUpgrade = this.updatesManager.filterAppcUpgrade(item);
        $jacocoInit[142] = true;
        return filterAppcUpgrade;
    }

    /* renamed from: e */
    static /* synthetic */ void m8243e(Install item) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("filtered upgrades - is not upgrade -> ");
        $jacocoInit[140] = true;
        sb.append(item.getPackageName());
        instance.mo2136d("Apps", sb.toString());
        $jacocoInit[141] = true;
    }

    /* renamed from: m */
    static /* synthetic */ void m8248m(List __) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[138] = true;
        instance.mo2136d("Apps", "emit list of installs from getDownloadApps - after toList");
        $jacocoInit[139] = true;
    }

    /* renamed from: n */
    public /* synthetic */ List mo14694n(List installedApps) {
        boolean[] $jacocoInit = $jacocoInit();
        List downloadApps = this.appMapper.getDownloadApps(installedApps);
        $jacocoInit[137] = true;
        return downloadApps;
    }

    public C0117M installApp(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallManager installManager2 = this.installManager;
        String md5 = ((DownloadApp) app).getMd5();
        DownloadApp downloadApp = (DownloadApp) app;
        $jacocoInit[25] = true;
        String packageName = downloadApp.getPackageName();
        int versionCode = ((DownloadApp) app).getVersionCode();
        $jacocoInit[26] = true;
        C0120S install = installManager2.getInstall(md5, packageName, versionCode);
        $jacocoInit[27] = true;
        C0120S d = install.mo3647d();
        C3759pa paVar = new C3759pa(this, app);
        $jacocoInit[28] = true;
        C0120S g = d.mo3663g((C0132p<? super T, ? extends C0117M>) paVar);
        $jacocoInit[29] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[30] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo14657a(App app, Install installationProgress) {
        boolean[] $jacocoInit = $jacocoInit();
        if (installationProgress.getState() == InstallationStatus.INSTALLED) {
            $jacocoInit[119] = true;
            SystemU.openApp(((DownloadApp) app).getPackageName(), this.packageManager, this.context);
            $jacocoInit[120] = true;
            C0117M c = C0117M.m596c();
            $jacocoInit[121] = true;
            return c;
        }
        C0117M resumeDownload = resumeDownload(app);
        $jacocoInit[122] = true;
        return resumeDownload;
    }

    public void cancelDownload(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallManager installManager2 = this.installManager;
        String md5 = ((DownloadApp) app).getMd5();
        DownloadApp downloadApp = (DownloadApp) app;
        $jacocoInit[31] = true;
        String packageName = downloadApp.getPackageName();
        int versionCode = ((DownloadApp) app).getVersionCode();
        $jacocoInit[32] = true;
        installManager2.removeInstallationFile(md5, packageName, versionCode);
        $jacocoInit[33] = true;
    }

    public C0117M resumeDownload(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        Single download = this.installManager.getDownload(((DownloadApp) app).getMd5());
        C3682ea eaVar = new C3682ea(this);
        $jacocoInit[34] = true;
        Single a = download.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) eaVar);
        C3784ta taVar = new C3784ta(this);
        $jacocoInit[35] = true;
        C0117M b = a.mo3693b((C0132p<? super T, ? extends C0117M>) taVar);
        $jacocoInit[36] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo14662a(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Single adsVisibilityStatus = this.moPubAdsManager.getAdsVisibilityStatus();
        C3717ja jaVar = new C3717ja(this, download);
        $jacocoInit[114] = true;
        Single b = adsVisibilityStatus.mo3695b((C0129b<? super T>) jaVar);
        C3689fa faVar = new C3689fa(download);
        $jacocoInit[115] = true;
        Single d = b.mo3698d(faVar);
        $jacocoInit[116] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14664a(Download download, OfferResponseStatus status) {
        boolean[] $jacocoInit = $jacocoInit();
        setupDownloadEvents(download, status);
        $jacocoInit[118] = true;
    }

    /* renamed from: b */
    static /* synthetic */ Download m8238b(Download download, OfferResponseStatus __) {
        $jacocoInit()[117] = true;
        return download;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo14667b(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M install = this.installManager.install(download);
        $jacocoInit[113] = true;
        return install;
    }

    private void setupDownloadEvents(Download download, OfferResponseStatus offerResponseStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadAnalytics downloadAnalytics2 = this.downloadAnalytics;
        Action action = Action.CLICK;
        AppContext appContext = AppContext.APPS_FRAGMENT;
        $jacocoInit[37] = true;
        Boolean valueOf = Boolean.valueOf(false);
        $jacocoInit[38] = true;
        downloadAnalytics2.downloadStartEvent(download, action, appContext, valueOf);
        $jacocoInit[39] = true;
        DownloadAnalytics downloadAnalytics3 = this.downloadAnalytics;
        String md5 = download.getMd5();
        String packageName = download.getPackageName();
        Action action2 = Action.INSTALL;
        $jacocoInit[40] = true;
        boolean hasAppc = download.hasAppc();
        $jacocoInit[41] = true;
        downloadAnalytics3.installClicked(md5, packageName, action2, offerResponseStatus, false, hasAppc);
        $jacocoInit[42] = true;
        InstallAnalytics installAnalytics2 = this.installAnalytics;
        String packageName2 = download.getPackageName();
        int versionCode = download.getVersionCode();
        Action action3 = Action.INSTALL;
        p005cm.aptoide.p006pt.download.AppContext appContext2 = p005cm.aptoide.p006pt.download.AppContext.APPS_FRAGMENT;
        $jacocoInit[43] = true;
        Origin origin = getOrigin(download.getAction());
        $jacocoInit[44] = true;
        boolean hasAppc2 = download.hasAppc();
        $jacocoInit[45] = true;
        installAnalytics2.installStarted(packageName2, versionCode, action3, appContext2, origin, false, hasAppc2);
        $jacocoInit[46] = true;
    }

    private void setupUpdateEvents(Download download, Origin origin, OfferResponseStatus offerResponseStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadAnalytics downloadAnalytics2 = this.downloadAnalytics;
        Action action = Action.CLICK;
        AppContext appContext = AppContext.APPS_FRAGMENT;
        $jacocoInit[47] = true;
        Boolean valueOf = Boolean.valueOf(false);
        $jacocoInit[48] = true;
        downloadAnalytics2.downloadStartEvent(download, action, appContext, valueOf);
        $jacocoInit[49] = true;
        DownloadAnalytics downloadAnalytics3 = this.downloadAnalytics;
        String md5 = download.getMd5();
        String packageName = download.getPackageName();
        Action action2 = Action.INSTALL;
        $jacocoInit[50] = true;
        boolean hasAppc = download.hasAppc();
        $jacocoInit[51] = true;
        downloadAnalytics3.installClicked(md5, packageName, action2, offerResponseStatus, false, hasAppc);
        $jacocoInit[52] = true;
        InstallAnalytics installAnalytics2 = this.installAnalytics;
        String packageName2 = download.getPackageName();
        int versionCode = download.getVersionCode();
        Action action3 = Action.INSTALL;
        p005cm.aptoide.p006pt.download.AppContext appContext2 = p005cm.aptoide.p006pt.download.AppContext.APPS_FRAGMENT;
        $jacocoInit[53] = true;
        boolean hasAppc2 = download.hasAppc();
        $jacocoInit[54] = true;
        installAnalytics2.installStarted(packageName2, versionCode, action3, appContext2, origin, false, hasAppc2);
        $jacocoInit[55] = true;
    }

    private Origin getOrigin(int action) {
        boolean[] $jacocoInit = $jacocoInit();
        if (action == 1) {
            Origin origin = Origin.UPDATE;
            $jacocoInit[57] = true;
            return origin;
        } else if (action != 2) {
            Origin origin2 = Origin.INSTALL;
            $jacocoInit[56] = true;
            return origin2;
        } else {
            Origin origin3 = Origin.DOWNGRADE;
            $jacocoInit[58] = true;
            return origin3;
        }
    }

    public C0117M pauseDownload(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C3606T(this, app));
        $jacocoInit[59] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14665a(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.stopInstallation(((DownloadApp) app).getMd5());
        $jacocoInit[112] = true;
    }

    public C0117M resumeUpdate(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        Single download = this.installManager.getDownload(((UpdateApp) app).getMd5());
        C3630X x = new C3630X(this);
        $jacocoInit[60] = true;
        C0117M b = download.mo3693b((C0132p<? super T, ? extends C0117M>) x);
        $jacocoInit[61] = true;
        return b;
    }

    /* renamed from: c */
    public /* synthetic */ C0117M mo14671c(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M install = this.installManager.install(download);
        $jacocoInit[111] = true;
        return install;
    }

    public void cancelUpdate(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallManager installManager2 = this.installManager;
        String md5 = ((UpdateApp) app).getMd5();
        UpdateApp updateApp = (UpdateApp) app;
        $jacocoInit[62] = true;
        String packageName = updateApp.getPackageName();
        int versionCode = ((UpdateApp) app).getVersionCode();
        $jacocoInit[63] = true;
        installManager2.removeInstallationFile(md5, packageName, versionCode);
        $jacocoInit[64] = true;
    }

    public C0117M pauseUpdate(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C3820za(this, app));
        $jacocoInit[65] = true;
        return c;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14670b(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.stopInstallation(((UpdateApp) app).getMd5());
        $jacocoInit[110] = true;
    }

    public C0117M updateApp(App app, boolean isAppcUpdate) {
        boolean[] $jacocoInit = $jacocoInit();
        String packageName = ((UpdateApp) app).getPackageName();
        $jacocoInit[66] = true;
        C0120S update = this.updatesManager.getUpdate(packageName);
        C3675da daVar = new C3675da(this, isAppcUpdate);
        $jacocoInit[67] = true;
        C0120S f = update.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) daVar);
        C3696ga gaVar = new C3696ga(this);
        $jacocoInit[68] = true;
        C0120S i = f.mo3668i(gaVar);
        C3731la laVar = new C3731la(this);
        $jacocoInit[69] = true;
        C0120S g = i.mo3663g((C0132p<? super T, ? extends C0117M>) laVar);
        $jacocoInit[70] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[71] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo14661a(boolean isAppcUpdate, Update update) {
        boolean[] $jacocoInit = $jacocoInit();
        Download value = this.downloadFactory.create(update, isAppcUpdate);
        $jacocoInit[108] = true;
        C0120S c = C0120S.m652c(value);
        $jacocoInit[109] = true;
        return c;
    }

    /* renamed from: d */
    public /* synthetic */ Single mo14677d(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Single adsVisibilityStatus = this.moPubAdsManager.getAdsVisibilityStatus();
        C3559L l = new C3559L(this, download);
        $jacocoInit[103] = true;
        Single b = adsVisibilityStatus.mo3695b((C0129b<? super T>) l);
        C3724ka kaVar = new C3724ka(download);
        $jacocoInit[104] = true;
        Single d = b.mo3698d(kaVar);
        $jacocoInit[105] = true;
        return d;
    }

    /* renamed from: c */
    public /* synthetic */ void mo14672c(Download download, OfferResponseStatus status) {
        boolean[] $jacocoInit = $jacocoInit();
        setupUpdateEvents(download, Origin.UPDATE, status);
        $jacocoInit[107] = true;
    }

    /* renamed from: d */
    static /* synthetic */ Download m8241d(Download download, OfferResponseStatus __) {
        $jacocoInit()[106] = true;
        return download;
    }

    /* renamed from: e */
    public /* synthetic */ C0117M mo14678e(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M install = this.installManager.install(download);
        $jacocoInit[102] = true;
        return install;
    }

    public boolean showWarning() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean showWarning = this.installManager.showWarning();
        $jacocoInit[72] = true;
        return showWarning;
    }

    public void storeRootAnswer(boolean answer) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.rootInstallAllowed(answer);
        $jacocoInit[73] = true;
    }

    public C0117M updateAll() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S allUpdates = this.updatesManager.getAllUpdates();
        $jacocoInit[74] = true;
        C0120S d = allUpdates.mo3647d();
        C3506Ca ca = C3506Ca.f6885a;
        $jacocoInit[75] = true;
        C0120S d2 = d.mo3653d((C0132p<? super T, Boolean>) ca);
        C3636Y y = new C3636Y(this);
        $jacocoInit[76] = true;
        C0120S f = d2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) y);
        $jacocoInit[77] = true;
        C0117M l = f.mo3673l();
        $jacocoInit[78] = true;
        return l;
    }

    /* renamed from: s */
    static /* synthetic */ Boolean m8251s(List updatesList) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!updatesList.isEmpty()) {
            $jacocoInit[99] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[100] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[101] = true;
        return valueOf;
    }

    /* renamed from: t */
    public /* synthetic */ C0120S mo14705t(List updates) {
        boolean[] $jacocoInit = $jacocoInit();
        Single adsVisibilityStatus = this.moPubAdsManager.getAdsVisibilityStatus();
        C3583P p = new C3583P(this, updates);
        $jacocoInit[86] = true;
        C0120S c = adsVisibilityStatus.mo3697c(p);
        $jacocoInit[87] = true;
        return c;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo14669b(List updates, OfferResponseStatus offerResponseStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(offerResponseStatus);
        C3772ra raVar = new C3772ra(updates);
        $jacocoInit[88] = true;
        C0120S j = c.mo3669j(raVar);
        C3808xa xaVar = C3808xa.f7220a;
        $jacocoInit[89] = true;
        C0120S h = j.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) xaVar);
        C3612U u = new C3612U(this, offerResponseStatus);
        $jacocoInit[90] = true;
        C0120S f = h.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) u);
        $jacocoInit[91] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ List m8237a(List updates, OfferResponseStatus showAds1) {
        $jacocoInit()[98] = true;
        return updates;
    }

    /* renamed from: o */
    static /* synthetic */ Iterable m8249o(List updatesList) {
        $jacocoInit()[97] = true;
        return updatesList;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo14658a(OfferResponseStatus offerResponseStatus, Update update) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(this.downloadFactory.create(update, false));
        C3703ha haVar = new C3703ha(this, offerResponseStatus);
        $jacocoInit[92] = true;
        C0120S b = c.mo3636b((C0129b<? super T>) haVar);
        $jacocoInit[93] = true;
        C0120S m = b.mo3675m();
        InstallManager installManager2 = this.installManager;
        installManager2.getClass();
        C3764pf pfVar = new C3764pf(installManager2);
        $jacocoInit[94] = true;
        C0120S f = m.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) pfVar);
        $jacocoInit[95] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14663a(OfferResponseStatus offerResponseStatus, Download download1) {
        boolean[] $jacocoInit = $jacocoInit();
        setupUpdateEvents(download1, Origin.UPDATE_ALL, offerResponseStatus);
        $jacocoInit[96] = true;
    }

    public C0120S<Void> excludeUpdate(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> excludeUpdate = this.updatesManager.excludeUpdate(((UpdateApp) app).getPackageName());
        $jacocoInit[79] = true;
        return excludeUpdate;
    }

    public void setAppViewAnalyticsEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        this.updatesAnalytics.updates(UpdatesAnalytics.OPEN_APP_VIEW);
        $jacocoInit[80] = true;
    }

    public C0120S<List<App>> getInstalledDownloads() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installedApps = this.installManager.getInstalledApps();
        $jacocoInit[81] = true;
        C0120S b = installedApps.mo3628b();
        C3661ba baVar = new C3661ba(this);
        $jacocoInit[82] = true;
        C0120S<List<App>> j = b.mo3669j(baVar);
        $jacocoInit[83] = true;
        return j;
    }

    /* renamed from: g */
    public /* synthetic */ List mo14681g(List installedDownloads) {
        boolean[] $jacocoInit = $jacocoInit();
        List downloadApps = this.appMapper.getDownloadApps(installedDownloads);
        $jacocoInit[85] = true;
        return downloadApps;
    }

    public C0117M refreshAllUpdates() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M refreshUpdates = this.updatesManager.refreshUpdates();
        $jacocoInit[84] = true;
        return refreshUpdates;
    }
}
