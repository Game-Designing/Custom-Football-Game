package p005cm.aptoide.p006pt.install;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.p000v4.app.C0448aa.C0449a;
import android.support.p000v4.app.C0448aa.C0451c;
import android.text.TextUtils;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.BaseService;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver.DeepLinksTargets;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.downloadmanager.AptoideDownloadManager;
import p005cm.aptoide.p006pt.downloadmanager.OldAptoideDownloadManager;
import p005cm.aptoide.p006pt.file.CacheHelper;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.repository.RepositoryFactory;
import p005cm.aptoide.p006pt.view.ActivityProvider;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.install.InstallService */
public class InstallService extends BaseService implements DownloadsNotification {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String ACTION_INSTALL_FINISHED = "INSTALL_FINISHED";
    public static final String ACTION_OPEN_APP_VIEW = "OPEN_APP_VIEW";
    public static final String ACTION_OPEN_DOWNLOAD_MANAGER = "OPEN_DOWNLOAD_MANAGER";
    public static final String ACTION_START_INSTALL = "START_INSTALL";
    public static final String ACTION_STOP_ALL_INSTALLS = "STOP_ALL_INSTALLS";
    public static final String ACTION_STOP_INSTALL = "STOP_INSTALL";
    public static final String EXTRA_FORCE_DEFAULT_INSTALL = "EXTRA_FORCE_DEFAULT_INSTALL";
    public static final String EXTRA_INSTALLATION_MD5 = "INSTALLATION_MD5";
    public static final String EXTRA_INSTALLER_TYPE = "INSTALLER_TYPE";
    public static final String EXTRA_SET_PACKAGE_INSTALLER = "EXTRA_SET_PACKAGE_INSTALLER";
    public static final int INSTALLER_TYPE_DEFAULT = 0;
    private static final int NOTIFICATION_ID = 8;
    public static final String TAG = "InstallService";
    @Inject
    CacheHelper cacheManager;
    @Inject
    Installer defaultInstaller;
    @Inject
    DownloadAnalytics downloadAnalytics;
    @Inject
    AptoideDownloadManager downloadManager;
    private InstallManager installManager;
    @Inject
    InstalledRepository installedRepository;
    private Notification notification;
    private C14963c<String> openAppViewAction;
    private C14963c<Void> openDownloadManagerAction;
    private DownloadsNotificationsPresenter presenter;
    private C0136c subscriptions;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2826277352385275375L, "cm/aptoide/pt/install/InstallService", Opcodes.ATHROW);
        $jacocoData = probes;
        return probes;
    }

    public InstallService() {
        $jacocoInit()[0] = true;
    }

    public void onCreate() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate();
        $jacocoInit[1] = true;
        getApplicationComponent().inject(this);
        $jacocoInit[2] = true;
        Logger instance = Logger.getInstance();
        $jacocoInit[3] = true;
        instance.mo2136d(TAG, "Install service is starting");
        $jacocoInit[4] = true;
        AptoideApplication application = (AptoideApplication) getApplicationContext();
        $jacocoInit[5] = true;
        this.installManager = application.getInstallManager();
        $jacocoInit[6] = true;
        this.subscriptions = new C0136c();
        $jacocoInit[7] = true;
        this.openDownloadManagerAction = C14963c.m46753p();
        $jacocoInit[8] = true;
        this.openAppViewAction = C14963c.m46753p();
        $jacocoInit[9] = true;
        this.presenter = new DownloadsNotificationsPresenter(this, this.installManager);
        $jacocoInit[10] = true;
        this.presenter.setupSubscriptions();
        $jacocoInit[11] = true;
        this.installedRepository = RepositoryFactory.getInstalledRepository(getApplicationContext());
        $jacocoInit[12] = true;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = TAG;
        if (intent != null) {
            $jacocoInit[13] = true;
            String md5 = intent.getStringExtra(EXTRA_INSTALLATION_MD5);
            $jacocoInit[14] = true;
            if (ACTION_START_INSTALL.equals(intent.getAction())) {
                $jacocoInit[15] = true;
                Logger instance = Logger.getInstance();
                $jacocoInit[16] = true;
                instance.mo2136d(str, "Observing download and install with an intent");
                $jacocoInit[17] = true;
                C0136c cVar = this.subscriptions;
                Bundle extras = intent.getExtras();
                $jacocoInit[18] = true;
                boolean z = extras.getBoolean(EXTRA_FORCE_DEFAULT_INSTALL, false);
                Bundle extras2 = intent.getExtras();
                $jacocoInit[19] = true;
                boolean z2 = extras2.getBoolean(EXTRA_SET_PACKAGE_INSTALLER, false);
                $jacocoInit[20] = true;
                C0120S downloadAndInstall = downloadAndInstall(this, md5, z, z2);
                C4134ya yaVar = new C4134ya(this);
                C3975Aa aa = new C3975Aa(this);
                $jacocoInit[21] = true;
                C0137ja a = downloadAndInstall.mo3626a((C0129b<? super T>) yaVar, (C0129b<Throwable>) aa);
                $jacocoInit[22] = true;
                cVar.mo3713a(a);
                $jacocoInit[23] = true;
            } else {
                if (ACTION_STOP_INSTALL.equals(intent.getAction())) {
                    $jacocoInit[24] = true;
                    this.subscriptions.mo3713a(stopDownload(md5).mo3626a((C0129b<? super T>) new C4103oa<Object>(this), (C0129b<Throwable>) new C4097la<Throwable>(this)));
                    $jacocoInit[25] = true;
                } else {
                    if ("OPEN_APP_VIEW".equals(intent.getAction())) {
                        $jacocoInit[26] = true;
                        this.openAppViewAction.onNext(md5);
                        $jacocoInit[27] = true;
                    } else {
                        if (ACTION_OPEN_DOWNLOAD_MANAGER.equals(intent.getAction())) {
                            $jacocoInit[28] = true;
                            this.openDownloadManagerAction.onNext(null);
                            $jacocoInit[29] = true;
                        } else {
                            if (!ACTION_STOP_ALL_INSTALLS.equals(intent.getAction())) {
                                $jacocoInit[30] = true;
                            } else {
                                $jacocoInit[31] = true;
                                stopAllDownloads();
                                $jacocoInit[32] = true;
                            }
                        }
                    }
                }
            }
            $jacocoInit[33] = true;
        } else {
            Logger instance2 = Logger.getInstance();
            $jacocoInit[34] = true;
            instance2.mo2136d(str, "Observing current download and installation without an intent");
            $jacocoInit[35] = true;
            this.subscriptions.mo3713a(downloadAndInstallCurrentDownload(this, false, false).mo3626a((C0129b<? super T>) new C4107qa<Object>(this), (C0129b<Throwable>) new C4136za<Throwable>(this)));
            $jacocoInit[36] = true;
        }
        $jacocoInit[37] = true;
        return 1;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15035a(Boolean hasNext) {
        boolean[] $jacocoInit = $jacocoInit();
        treatNext(hasNext.booleanValue());
        $jacocoInit[190] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15036a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        removeNotificationAndStop();
        $jacocoInit[189] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15039b(Boolean hasNext) {
        boolean[] $jacocoInit = $jacocoInit();
        treatNext(hasNext.booleanValue());
        $jacocoInit[188] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15040b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        removeNotificationAndStop();
        $jacocoInit[187] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15041c(Boolean hasNext) {
        boolean[] $jacocoInit = $jacocoInit();
        treatNext(hasNext.booleanValue());
        $jacocoInit[186] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15042c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        removeNotificationAndStop();
        $jacocoInit[185] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[38] = true;
        Class cls = getClass();
        $jacocoInit[39] = true;
        String name = cls.getName();
        $jacocoInit[40] = true;
        instance.mo2136d(name, "InstallService.onDestroy");
        $jacocoInit[41] = true;
        this.subscriptions.unsubscribe();
        $jacocoInit[42] = true;
        this.presenter.onDestroy();
        this.openAppViewAction = null;
        this.openDownloadManagerAction = null;
        $jacocoInit[43] = true;
        super.onDestroy();
        $jacocoInit[44] = true;
    }

    public IBinder onBind(Intent intent) {
        $jacocoInit()[45] = true;
        return null;
    }

    private C0120S<Boolean> stopDownload(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M pauseDownload = this.downloadManager.pauseDownload(md5);
        $jacocoInit[46] = true;
        C0120S<Boolean> a = pauseDownload.mo3586a(hasNextDownload());
        $jacocoInit[47] = true;
        return a;
    }

    private void stopAllDownloads() {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadManager.pauseAllDownloads();
        $jacocoInit[48] = true;
        removeNotificationAndStop();
        $jacocoInit[49] = true;
    }

    private void treatNext(boolean hasNext) {
        boolean[] $jacocoInit = $jacocoInit();
        if (hasNext) {
            $jacocoInit[50] = true;
        } else {
            $jacocoInit[51] = true;
            removeNotificationAndStop();
            $jacocoInit[52] = true;
            C0136c cVar = this.subscriptions;
            C0120S cleanCache = this.cacheManager.cleanCache();
            $jacocoInit[53] = true;
            Single n = cleanCache.mo3678n();
            C4109ra raVar = new C4109ra(this);
            $jacocoInit[54] = true;
            Single a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) raVar);
            C4119sa saVar = C4119sa.f7654a;
            C4099ma maVar = C4099ma.f7640a;
            $jacocoInit[55] = true;
            C0137ja a2 = a.mo3690a((C0129b<? super T>) saVar, (C0129b<Throwable>) maVar);
            $jacocoInit[56] = true;
            cVar.mo3713a(a2);
            $jacocoInit[57] = true;
        }
        $jacocoInit[58] = true;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo15033a(Long cleaned) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M invalidateDatabase = this.downloadManager.invalidateDatabase();
        $jacocoInit[183] = true;
        Single a = invalidateDatabase.mo3587a(Single.m734a(cleaned));
        $jacocoInit[184] = true;
        return a;
    }

    /* renamed from: b */
    static /* synthetic */ void m8543b(Long __) {
        $jacocoInit()[182] = true;
    }

    /* renamed from: d */
    static /* synthetic */ void m8546d(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[180] = true;
        instance.log(throwable);
        $jacocoInit[181] = true;
    }

    private C0120S<Boolean> downloadAndInstallCurrentDownload(Context context, boolean forceDefaultInstall, boolean shouldSetPackageInstaller) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S currentInProgressDownload = this.downloadManager.getCurrentInProgressDownload();
        $jacocoInit[59] = true;
        C0120S d = currentInProgressDownload.mo3647d();
        C4132xa xaVar = new C4132xa(this, context, forceDefaultInstall, shouldSetPackageInstaller);
        $jacocoInit[60] = true;
        C0120S<Boolean> f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) xaVar);
        $jacocoInit[61] = true;
        return f;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo15037b(Context context, boolean forceDefaultInstall, boolean shouldSetPackageInstaller, Download currentDownload) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S downloadAndInstall = downloadAndInstall(context, currentDownload.getMd5(), forceDefaultInstall, shouldSetPackageInstaller);
        $jacocoInit[179] = true;
        return downloadAndInstall;
    }

    private C0120S<Boolean> downloadAndInstall(Context context, String md5, boolean forceDefaultInstall, boolean shouldSetPackageInstaller) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S download = this.downloadManager.getDownload(md5);
        $jacocoInit[62] = true;
        C0120S d = download.mo3647d();
        C4052ia iaVar = new C4052ia(this);
        $jacocoInit[63] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) iaVar);
        C4125va vaVar = new C4125va(this, md5);
        $jacocoInit[64] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) vaVar);
        C4093ja jaVar = new C4093ja(this);
        $jacocoInit[65] = true;
        C0120S b2 = f.mo3636b((C0129b<? super T>) jaVar);
        C4121ta taVar = C4121ta.f7656a;
        $jacocoInit[66] = true;
        C0120S b3 = b2.mo3636b((C0129b<? super T>) taVar);
        C4130wa waVar = C4130wa.f7663a;
        $jacocoInit[67] = true;
        C0120S e = b3.mo3658e((C0132p<? super T, Boolean>) waVar);
        C4123ua uaVar = new C4123ua(this);
        $jacocoInit[68] = true;
        C0120S b4 = e.mo3636b((C0129b<? super T>) uaVar);
        C4095ka kaVar = new C4095ka(this, context, forceDefaultInstall, shouldSetPackageInstaller);
        $jacocoInit[69] = true;
        C0120S<Boolean> f2 = b4.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) kaVar);
        $jacocoInit[70] = true;
        return f2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15034a(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        initInstallationProgress(download);
        $jacocoInit[178] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15032a(String md5, Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M startDownload = this.downloadManager.startDownload(download);
        AptoideDownloadManager aptoideDownloadManager = this.downloadManager;
        $jacocoInit[176] = true;
        C0120S a = startDownload.mo3586a(aptoideDownloadManager.getDownload(md5));
        $jacocoInit[177] = true;
        return a;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15038b(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        stopOnDownloadError(download.getOverallDownloadStatus());
        $jacocoInit[171] = true;
        if (download.getOverallDownloadStatus() != 5) {
            $jacocoInit[172] = true;
        } else {
            $jacocoInit[173] = true;
            this.downloadAnalytics.startProgress(download);
            $jacocoInit[174] = true;
        }
        $jacocoInit[175] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m8544c(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("received download: ");
        $jacocoInit[167] = true;
        sb.append(download.getPackageName());
        sb.append(" state: ");
        $jacocoInit[168] = true;
        sb.append(download.getOverallDownloadStatus());
        String sb2 = sb.toString();
        $jacocoInit[169] = true;
        instance.mo2136d(TAG, sb2);
        $jacocoInit[170] = true;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m8545d(Download download) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (download.getOverallDownloadStatus() == 1) {
            $jacocoInit[164] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[165] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[166] = true;
        return valueOf;
    }

    /* renamed from: e */
    public /* synthetic */ void mo15043e(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.moveCompletedDownloadFiles(download);
        $jacocoInit[163] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15031a(Context context, boolean forceDefaultInstall, boolean shouldSetPackageInstaller, Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M stopForegroundAndInstall = stopForegroundAndInstall(context, download, true, forceDefaultInstall, shouldSetPackageInstaller);
        $jacocoInit[160] = true;
        C0117M a = stopForegroundAndInstall.mo3580a(sendBackgroundInstallFinishedBroadcast(download));
        $jacocoInit[161] = true;
        C0120S a2 = a.mo3586a(hasNextDownload());
        $jacocoInit[162] = true;
        return a2;
    }

    private void initInstallationProgress(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Installed installed = convertDownloadToInstalled(download);
        $jacocoInit[71] = true;
        this.installedRepository.save(installed);
        $jacocoInit[72] = true;
    }

    private void stopOnDownloadError(int downloadStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        if (downloadStatus != 9) {
            $jacocoInit[73] = true;
        } else {
            $jacocoInit[74] = true;
            removeNotificationAndStop();
            $jacocoInit[75] = true;
        }
        $jacocoInit[76] = true;
    }

    private C0120S<Boolean> hasNextDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S currentActiveDownloads = this.downloadManager.getCurrentActiveDownloads();
        $jacocoInit[77] = true;
        C0120S d = currentActiveDownloads.mo3647d();
        C4105pa paVar = C4105pa.f7647a;
        $jacocoInit[78] = true;
        C0120S<Boolean> j = d.mo3669j(paVar);
        $jacocoInit[79] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8542a(List downloads) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (downloads == null) {
            $jacocoInit[155] = true;
        } else if (downloads.isEmpty()) {
            $jacocoInit[156] = true;
        } else {
            $jacocoInit[157] = true;
            z = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[159] = true;
            return valueOf;
        }
        z = false;
        $jacocoInit[158] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[159] = true;
        return valueOf2;
    }

    private C0117M sendBackgroundInstallFinishedBroadcast(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C4101na(this, download));
        $jacocoInit[80] = true;
        return c;
    }

    /* renamed from: f */
    public /* synthetic */ void mo15044f(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(ACTION_INSTALL_FINISHED);
        $jacocoInit[152] = true;
        Intent putExtra = intent.putExtra(EXTRA_INSTALLATION_MD5, download.getMd5());
        $jacocoInit[153] = true;
        sendBroadcast(putExtra);
        $jacocoInit[154] = true;
    }

    private C0117M stopForegroundAndInstall(Context context, Download download, boolean removeNotification, boolean forceDefaultInstall, boolean shouldSetPackageInstaller) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[81] = true;
        instance.mo2136d(TAG, "Stopping download notification and starting installation");
        $jacocoInit[82] = true;
        Installer installer = getInstaller();
        $jacocoInit[83] = true;
        stopForeground(removeNotification);
        $jacocoInit[84] = true;
        int action = download.getAction();
        if (action == 0) {
            C0117M install = installer.install(context, download.getMd5(), forceDefaultInstall, shouldSetPackageInstaller);
            $jacocoInit[85] = true;
            return install;
        } else if (action == 1) {
            C0117M update = installer.update(context, download.getMd5(), forceDefaultInstall, shouldSetPackageInstaller);
            $jacocoInit[86] = true;
            return update;
        } else if (action != 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid download action ");
            $jacocoInit[88] = true;
            sb.append(download.getAction());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sb.toString());
            $jacocoInit[89] = true;
            C0117M b = C0117M.m591b((Throwable) illegalArgumentException);
            $jacocoInit[90] = true;
            return b;
        } else {
            C0117M downgrade = installer.downgrade(context, download.getMd5(), forceDefaultInstall, shouldSetPackageInstaller);
            $jacocoInit[87] = true;
            return downgrade;
        }
    }

    private Installer getInstaller() {
        boolean[] $jacocoInit = $jacocoInit();
        Installer installer = this.defaultInstaller;
        $jacocoInit[91] = true;
        return installer;
    }

    private C0449a getPauseAction(int requestCode, String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle appIdExtras = new Bundle();
        $jacocoInit[92] = true;
        appIdExtras.putString(OldAptoideDownloadManager.FILE_MD5_EXTRA, md5);
        $jacocoInit[93] = true;
        String string = getString(C1375R.string.pause_download);
        $jacocoInit[94] = true;
        C0449a action = getAction(C1375R.drawable.media_pause, string, requestCode, ACTION_STOP_INSTALL, md5);
        $jacocoInit[95] = true;
        return action;
    }

    private C0449a getDownloadManagerAction(int requestCode, String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle appIdExtras = new Bundle();
        $jacocoInit[96] = true;
        appIdExtras.putString(OldAptoideDownloadManager.FILE_MD5_EXTRA, md5);
        $jacocoInit[97] = true;
        C0449a action = getAction(C1375R.drawable.ic_manager, getString(C1375R.string.open_apps_manager), requestCode, ACTION_OPEN_DOWNLOAD_MANAGER, md5);
        $jacocoInit[98] = true;
        return action;
    }

    private Notification buildNotification(String appName, int progress, boolean isIndeterminate, C0449a pauseAction, C0449a openDownloadManager, PendingIntent contentIntent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0451c builder = new C0451c(this);
        $jacocoInit[99] = true;
        builder.mo5120c(17301633);
        Locale locale = Locale.ENGLISH;
        $jacocoInit[100] = true;
        String string = getResources().getString(C1375R.string.aptoide_downloading);
        $jacocoInit[101] = true;
        Object[] objArr = {getString(C1375R.string.app_name)};
        $jacocoInit[102] = true;
        builder.mo5121c((CharSequence) String.format(locale, string, objArr));
        StringBuilder sb = new StringBuilder();
        $jacocoInit[103] = true;
        sb.append(appName);
        $jacocoInit[104] = true;
        sb.append(" - ");
        $jacocoInit[105] = true;
        sb.append(getString(C1375R.string.download_progress));
        $jacocoInit[106] = true;
        builder.mo5118b((CharSequence) sb);
        $jacocoInit[107] = true;
        builder.mo5110a(contentIntent);
        $jacocoInit[108] = true;
        builder.mo5107a(100, progress, isIndeterminate);
        $jacocoInit[109] = true;
        builder.mo5112a(pauseAction);
        $jacocoInit[110] = true;
        builder.mo5112a(openDownloadManager);
        $jacocoInit[111] = true;
        Notification a = builder.mo5105a();
        $jacocoInit[112] = true;
        return a;
    }

    private C0449a getAction(int icon, String title, int requestCode, String action, String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        C0449a aVar = new C0449a(icon, title, getPendingIntent(requestCode, action, md5));
        $jacocoInit[113] = true;
        return aVar;
    }

    private PendingIntent getPendingIntent(int requestCode, String action, String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this, InstallService.class);
        $jacocoInit[114] = true;
        if (TextUtils.isEmpty(md5)) {
            $jacocoInit[115] = true;
        } else {
            $jacocoInit[116] = true;
            Bundle bundle = new Bundle();
            $jacocoInit[117] = true;
            bundle.putString(EXTRA_INSTALLATION_MD5, md5);
            $jacocoInit[118] = true;
            intent.putExtras(bundle);
            $jacocoInit[119] = true;
        }
        PendingIntent service = PendingIntent.getService(this, requestCode, intent.setAction(action), 1073741824);
        $jacocoInit[120] = true;
        return service;
    }

    public C0120S<String> handleOpenAppView() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<String> cVar = this.openAppViewAction;
        $jacocoInit[121] = true;
        return cVar;
    }

    public C0120S<Void> handleOpenDownloadManager() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.openDownloadManagerAction;
        $jacocoInit[122] = true;
        return cVar;
    }

    public void openAppView(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = createDeeplinkingIntent();
        $jacocoInit[123] = true;
        intent.putExtra(DeepLinksTargets.APP_VIEW_FRAGMENT, true);
        $jacocoInit[124] = true;
        intent.putExtra("md5", md5);
        $jacocoInit[125] = true;
        startActivity(intent);
        $jacocoInit[126] = true;
    }

    public void openDownloadManager() {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = createDeeplinkingIntent();
        $jacocoInit[127] = true;
        intent.putExtra(DeepLinksTargets.FROM_DOWNLOAD_NOTIFICATION, true);
        $jacocoInit[128] = true;
        startActivity(intent);
        $jacocoInit[129] = true;
    }

    public void setupNotification(String md5, String appName, int progress, boolean isIndeterminate) {
        String str = md5;
        boolean[] $jacocoInit = $jacocoInit();
        int requestCode = md5.hashCode();
        $jacocoInit[130] = true;
        C0449a downloadManagerAction = getDownloadManagerAction(requestCode, str);
        $jacocoInit[131] = true;
        PendingIntent appViewPendingIntent = getPendingIntent(requestCode, "OPEN_APP_VIEW", str);
        $jacocoInit[132] = true;
        C0449a pauseAction = getPauseAction(requestCode, str);
        Notification notification2 = this.notification;
        if (notification2 == null) {
            $jacocoInit[133] = true;
            this.notification = buildNotification(appName, progress, isIndeterminate, pauseAction, downloadManagerAction, appViewPendingIntent);
            $jacocoInit[134] = true;
            C0449a aVar = pauseAction;
        } else {
            long oldWhen = notification2.when;
            $jacocoInit[135] = true;
            C0449a aVar2 = pauseAction;
            C0449a aVar3 = pauseAction;
            long oldWhen2 = oldWhen;
            this.notification = buildNotification(appName, progress, isIndeterminate, aVar2, downloadManagerAction, appViewPendingIntent);
            this.notification.when = oldWhen2;
            $jacocoInit[136] = true;
        }
        startForeground(8, this.notification);
        $jacocoInit[137] = true;
    }

    public void removeNotificationAndStop() {
        boolean[] $jacocoInit = $jacocoInit();
        stopForeground(true);
        $jacocoInit[138] = true;
        stopSelf();
        $jacocoInit[139] = true;
    }

    private Intent createDeeplinkingIntent() {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent();
        $jacocoInit[140] = true;
        Context applicationContext = getApplicationContext();
        ActivityProvider activityProvider = AptoideApplication.getActivityProvider();
        $jacocoInit[141] = true;
        Class mainActivityFragmentClass = activityProvider.getMainActivityFragmentClass();
        $jacocoInit[142] = true;
        intent.setClass(applicationContext, mainActivityFragmentClass);
        $jacocoInit[143] = true;
        intent.setFlags(276824064);
        $jacocoInit[144] = true;
        return intent;
    }

    private Installed convertDownloadToInstalled(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Installed installed = new Installed();
        $jacocoInit[145] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(download.getPackageName());
        sb.append(download.getVersionCode());
        installed.setPackageAndVersionCode(sb.toString());
        $jacocoInit[146] = true;
        installed.setVersionCode(download.getVersionCode());
        $jacocoInit[147] = true;
        installed.setVersionName(download.getVersionName());
        $jacocoInit[148] = true;
        installed.setStatus(2);
        $jacocoInit[149] = true;
        installed.setType(-1);
        $jacocoInit[150] = true;
        installed.setPackageName(download.getPackageName());
        $jacocoInit[151] = true;
        return installed;
    }
}
