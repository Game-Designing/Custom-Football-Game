package p005cm.aptoide.p006pt.install;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.FileToDownload;
import p005cm.aptoide.p006pt.database.realm.Installation;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.downloadmanager.AptoideDownloadManager;
import p005cm.aptoide.p006pt.downloadmanager.DownloadNotFoundException;
import p005cm.aptoide.p006pt.downloadmanager.DownloadsRepository;
import p005cm.aptoide.p006pt.install.Install.InstallationStatus;
import p005cm.aptoide.p006pt.install.Install.InstallationType;
import p005cm.aptoide.p006pt.install.installer.DefaultInstaller;
import p005cm.aptoide.p006pt.install.installer.InstallationState;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.preferences.secure.SecurePreferences;
import p005cm.aptoide.p006pt.root.RootAvailabilityManager;
import p005cm.aptoide.p006pt.utils.BroadcastRegisterOnSubscribe;
import p005cm.aptoide.p006pt.utils.FileUtils;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14542r;
import p026rx.p398d.C14906b;
import p026rx.p401g.C14959b;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.install.InstallManager */
public class InstallManager {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String TAG = "InstallManager";
    private final String apkPath;
    private final AptoideDownloadManager aptoideDownloadManager;
    private final String cachePath;
    private final Context context;
    private final DownloadsRepository downloadRepository;
    private final FileUtils fileUtils;
    private final InstalledRepository installedRepository;
    private final Installer installer;
    private final String obbPath;
    private final PackageInstallerManager packageInstallerManager;
    private final RootAvailabilityManager rootAvailabilityManager;
    private final SharedPreferences securePreferences;
    private final SharedPreferences sharedPreferences;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4307885914866915309L, "cm/aptoide/pt/install/InstallManager", 364);
        $jacocoData = probes;
        return probes;
    }

    public InstallManager(Context context2, AptoideDownloadManager aptoideDownloadManager2, Installer installer2, RootAvailabilityManager rootAvailabilityManager2, SharedPreferences sharedPreferences2, SharedPreferences securePreferences2, DownloadsRepository downloadRepository2, InstalledRepository installedRepository2, String cachePath2, String apkPath2, String obbPath2, FileUtils fileUtils2, PackageInstallerManager packageInstallerManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.aptoideDownloadManager = aptoideDownloadManager2;
        this.installer = installer2;
        this.context = context2;
        this.rootAvailabilityManager = rootAvailabilityManager2;
        this.downloadRepository = downloadRepository2;
        this.installedRepository = installedRepository2;
        this.sharedPreferences = sharedPreferences2;
        this.securePreferences = securePreferences2;
        this.cachePath = cachePath2;
        this.apkPath = apkPath2;
        this.obbPath = obbPath2;
        this.fileUtils = fileUtils2;
        this.packageInstallerManager = packageInstallerManager2;
        $jacocoInit[0] = true;
    }

    public void stopAllInstallations() {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this.context, InstallService.class);
        $jacocoInit[1] = true;
        intent.setAction(InstallService.ACTION_STOP_ALL_INSTALLS);
        $jacocoInit[2] = true;
        this.context.startService(intent);
        $jacocoInit[3] = true;
    }

    public void removeInstallationFile(String md5, String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        stopInstallation(md5);
        $jacocoInit[4] = true;
        C0117M remove = this.installedRepository.remove(packageName, versionCode);
        AptoideDownloadManager aptoideDownloadManager2 = this.aptoideDownloadManager;
        $jacocoInit[5] = true;
        C0117M a = remove.mo3580a(aptoideDownloadManager2.removeDownload(md5));
        C4135z zVar = C4135z.f7672a;
        C4031ba baVar = C4031ba.f7530a;
        $jacocoInit[6] = true;
        a.mo3588a((C0128a) zVar, (C0129b<? super Throwable>) baVar);
        $jacocoInit[7] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m323a() {
        $jacocoInit()[363] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m326a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[360] = true;
        instance.log(throwable);
        $jacocoInit[361] = true;
        throwable.printStackTrace();
        $jacocoInit[362] = true;
    }

    public void stopInstallation(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this.context, InstallService.class);
        $jacocoInit[8] = true;
        intent.setAction(InstallService.ACTION_STOP_INSTALL);
        $jacocoInit[9] = true;
        intent.putExtra(InstallService.EXTRA_INSTALLATION_MD5, md5);
        $jacocoInit[10] = true;
        this.context.startService(intent);
        $jacocoInit[11] = true;
    }

    /* renamed from: g */
    static /* synthetic */ C0120S m335g(List installs) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) installs);
        C4106q qVar = C4106q.f7648a;
        $jacocoInit[354] = true;
        C0120S d = a.mo3653d((C0132p<? super T, Boolean>) qVar);
        $jacocoInit[355] = true;
        C0120S m = d.mo3675m();
        $jacocoInit[356] = true;
        return m;
    }

    public C0120S<List<Install>> getTimedOutInstallations() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<List<Install>> f = getInstallations().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) C4124v.f7659a);
        $jacocoInit[12] = true;
        return f;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m333c(Install install) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallationStatus state = install.getState();
        InstallationStatus installationStatus = InstallationStatus.INSTALLATION_TIMEOUT;
        $jacocoInit[357] = true;
        boolean equals = state.equals(installationStatus);
        $jacocoInit[358] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[359] = true;
        return valueOf;
    }

    public C0120S<List<Install>> getInstalledApps() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S allInstalled = this.installedRepository.getAllInstalled();
        C4024Z z = new C4024Z(this);
        $jacocoInit[13] = true;
        C0120S<List<Install>> a = allInstalled.mo3622a((C0132p<? super T, ? extends C0120S<? extends R>>) z);
        $jacocoInit[14] = true;
        return a;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo2088f(List downloadList) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) downloadList);
        C4102o oVar = new C4102o(this);
        $jacocoInit[347] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) oVar);
        $jacocoInit[348] = true;
        C0120S m = f.mo3675m();
        $jacocoInit[349] = true;
        return m;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo2082d(Installed download) {
        boolean[] $jacocoInit = $jacocoInit();
        String packageName = download.getPackageName();
        $jacocoInit[350] = true;
        int versionCode = download.getVersionCode();
        $jacocoInit[351] = true;
        C0120S install = getInstall(packageName, versionCode);
        $jacocoInit[352] = true;
        C0120S d = install.mo3647d();
        $jacocoInit[353] = true;
        return d;
    }

    private C0120S<Install> getInstall(String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = this.installedRepository.get(packageName, versionCode);
        C4016V v = C4016V.f7513a;
        $jacocoInit[15] = true;
        C0120S<Install> j = s.mo3669j(v);
        $jacocoInit[16] = true;
        return j;
    }

    /* renamed from: b */
    static /* synthetic */ Install m327b(Installed installed) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallationStatus installationStatus = InstallationStatus.INSTALLED;
        InstallationType installationType = InstallationType.INSTALLED;
        $jacocoInit[343] = true;
        String packageName = installed.getPackageName();
        $jacocoInit[344] = true;
        int versionCode = installed.getVersionCode();
        String versionName = installed.getVersionName();
        String name = installed.getName();
        $jacocoInit[345] = true;
        Install install = new Install(100, installationStatus, installationType, false, -1, null, packageName, versionCode, versionName, name, installed.getIcon());
        $jacocoInit[346] = true;
        return install;
    }

    public C0120S<List<Install>> getInstallations() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S downloadsList = this.aptoideDownloadManager.getDownloadsList();
        $jacocoInit[17] = true;
        C0120S a = downloadsList.mo3616a(Schedulers.m776io());
        C4046ga gaVar = new C4046ga(this);
        $jacocoInit[18] = true;
        C0120S a2 = a.mo3622a((C0132p<? super T, ? extends C0120S<? extends R>>) gaVar);
        $jacocoInit[19] = true;
        C0120S b = a2.mo3628b();
        C4100n nVar = new C4100n(this);
        $jacocoInit[20] = true;
        C0120S<List<Install>> j = b.mo3669j(nVar);
        $jacocoInit[21] = true;
        return j;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo2084d(List downloadList) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) downloadList);
        C4012T t = new C4012T(this);
        $jacocoInit[336] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) t);
        $jacocoInit[337] = true;
        C0120S m = f.mo3675m();
        $jacocoInit[338] = true;
        return m;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo2076b(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        String md5 = download.getMd5();
        String packageName = download.getPackageName();
        $jacocoInit[339] = true;
        int versionCode = download.getVersionCode();
        $jacocoInit[340] = true;
        C0120S install = getInstall(md5, packageName, versionCode);
        $jacocoInit[341] = true;
        C0120S d = install.mo3647d();
        $jacocoInit[342] = true;
        return d;
    }

    /* renamed from: e */
    public /* synthetic */ List mo2085e(List installs) {
        boolean[] $jacocoInit = $jacocoInit();
        sortList(installs);
        $jacocoInit[335] = true;
        return installs;
    }

    private List<Install> sortList(List<Install> installs) {
        boolean[] $jacocoInit = $jacocoInit();
        Collections.sort(installs, C4020X.f7518a);
        $jacocoInit[22] = true;
        Collections.reverse(installs);
        $jacocoInit[23] = true;
        return installs;
    }

    /* renamed from: a */
    static /* synthetic */ int m314a(Install install, Install t1) {
        int toReturn;
        boolean[] $jacocoInit = $jacocoInit();
        if (install.getState() != InstallationStatus.DOWNLOADING) {
            $jacocoInit[321] = true;
        } else {
            $jacocoInit[322] = true;
            if (install.isIndeterminate()) {
                $jacocoInit[323] = true;
            } else {
                toReturn = 1;
                $jacocoInit[324] = true;
                $jacocoInit[334] = true;
                return toReturn;
            }
        }
        if (t1.getState() != InstallationStatus.DOWNLOADING) {
            $jacocoInit[325] = true;
        } else if (t1.isIndeterminate()) {
            $jacocoInit[326] = true;
        } else {
            toReturn = -1;
            $jacocoInit[327] = true;
            $jacocoInit[334] = true;
            return toReturn;
        }
        InstallationStatus state = install.getState();
        $jacocoInit[328] = true;
        int ordinal = state.ordinal();
        InstallationStatus state2 = t1.getState();
        $jacocoInit[329] = true;
        int diff = ordinal - state2.ordinal();
        if (diff == 0) {
            $jacocoInit[330] = true;
            String packageName = install.getPackageName();
            $jacocoInit[331] = true;
            toReturn = packageName.compareTo(t1.getPackageName());
            $jacocoInit[332] = true;
        } else {
            $jacocoInit[333] = true;
            toReturn = diff;
        }
        $jacocoInit[334] = true;
        return toReturn;
    }

    /* renamed from: c */
    static /* synthetic */ C0120S m334c(List installs) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) installs);
        C4007Q q = C4007Q.f7500a;
        $jacocoInit[316] = true;
        C0120S d = a.mo3653d((C0132p<? super T, Boolean>) q);
        $jacocoInit[317] = true;
        return d;
    }

    public C0120S<Install> getCurrentInstallation() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Install> f = getInstallations().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) C4001N.f7487a);
        $jacocoInit[24] = true;
        return f;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m328b(Install install) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (install.getState() == InstallationStatus.DOWNLOADING) {
            $jacocoInit[318] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[319] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[320] = true;
        return valueOf;
    }

    public C0117M install(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M install = install(download, false, false);
        $jacocoInit[25] = true;
        return install;
    }

    private C0117M defaultInstall(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M install = install(download, true, false);
        $jacocoInit[26] = true;
        return install;
    }

    public C0117M splitInstall(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M install = install(download, false, true);
        $jacocoInit[27] = true;
        return install;
    }

    private C0117M install(Download download, boolean forceDefaultInstall, boolean forceSplitInstall) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S download2 = this.aptoideDownloadManager.getDownload(download.getMd5());
        $jacocoInit[28] = true;
        C0120S d = download2.mo3647d();
        C3988H h = new C3988H(this, download);
        $jacocoInit[29] = true;
        C0120S j = d.mo3669j(h);
        C4037da daVar = new C4037da(this, download);
        $jacocoInit[30] = true;
        C0120S m = j.mo3676m(daVar);
        C4120t tVar = new C4120t(this);
        $jacocoInit[31] = true;
        C0120S b = m.mo3636b((C0129b<? super T>) tVar);
        C4108r rVar = new C4108r(this, download);
        $jacocoInit[32] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) rVar);
        C4014U u = new C4014U(this, forceDefaultInstall, download, forceSplitInstall);
        $jacocoInit[33] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) u);
        $jacocoInit[34] = true;
        C0120S d2 = f2.mo3647d();
        $jacocoInit[35] = true;
        C0117M l = d2.mo3673l();
        $jacocoInit[36] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ Download mo2066a(Download download, Download storedDownload) {
        boolean[] $jacocoInit = $jacocoInit();
        updateDownloadAction(download, storedDownload);
        $jacocoInit[315] = true;
        return storedDownload;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2071a(Download download, C0120S errors) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S createDownloadAndRetry = createDownloadAndRetry(errors, download);
        $jacocoInit[314] = true;
        return createDownloadAndRetry;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2074a(Download storedDownload) {
        boolean[] $jacocoInit = $jacocoInit();
        if (storedDownload.getOverallDownloadStatus() != 9) {
            $jacocoInit[309] = true;
        } else {
            $jacocoInit[310] = true;
            storedDownload.setOverallDownloadStatus(0);
            $jacocoInit[311] = true;
            this.downloadRepository.save(storedDownload);
            $jacocoInit[312] = true;
        }
        $jacocoInit[313] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo2077b(Download download, Download storedDownload) {
        boolean[] $jacocoInit = $jacocoInit();
        String md5 = download.getMd5();
        String packageName = download.getPackageName();
        $jacocoInit[306] = true;
        int versionCode = download.getVersionCode();
        $jacocoInit[307] = true;
        C0120S install = getInstall(md5, packageName, versionCode);
        $jacocoInit[308] = true;
        return install;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2073a(boolean forceDefaultInstall, Download download, boolean forceSplitInstall, Install install) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        PackageInstallerManager packageInstallerManager2 = this.packageInstallerManager;
        $jacocoInit[300] = true;
        if (packageInstallerManager2.shouldSetInstallerPackageName(download)) {
            $jacocoInit[301] = true;
        } else if (forceSplitInstall) {
            $jacocoInit[302] = true;
        } else {
            z = false;
            $jacocoInit[304] = true;
            C0120S installInBackground = installInBackground(install, forceDefaultInstall, z);
            $jacocoInit[305] = true;
            return installInBackground;
        }
        $jacocoInit[303] = true;
        z = true;
        C0120S installInBackground2 = installInBackground(install, forceDefaultInstall, z);
        $jacocoInit[305] = true;
        return installInBackground2;
    }

    public C0120S<Install> getInstall(String md5, String packageName, int versioncode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S downloadsByMd5 = this.aptoideDownloadManager.getDownloadsByMd5(md5);
        Installer installer2 = this.installer;
        $jacocoInit[37] = true;
        C0120S state = installer2.getState(packageName, versioncode);
        C0120S installationType = getInstallationType(packageName, versioncode);
        C4005P p = new C4005P(this, md5, packageName, versioncode);
        $jacocoInit[38] = true;
        C0120S a = C0120S.m640a(downloadsByMd5, state, installationType, (C14542r<? super T1, ? super T2, ? super T3, ? extends R>) p);
        C4118s sVar = C4118s.f7653a;
        $jacocoInit[39] = true;
        C0120S<Install> b = a.mo3636b((C0129b<? super T>) sVar);
        $jacocoInit[40] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ Install mo2067a(String md5, String packageName, int versioncode, Download download, InstallationState installationState, InstallationType installationType) {
        boolean[] $jacocoInit = $jacocoInit();
        Install createInstall = createInstall(download, installationState, md5, packageName, versioncode, installationType);
        $jacocoInit[299] = true;
        return createInstall;
    }

    /* renamed from: a */
    static /* synthetic */ void m325a(Install install) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[297] = true;
        instance.mo2136d(TAG, install.toString());
        $jacocoInit[298] = true;
    }

    private Install createInstall(Download download, InstallationState installationState, String md5, String packageName, int versioncode, InstallationType installationType) {
        boolean[] $jacocoInit = $jacocoInit();
        int mapInstallation = mapInstallation(download);
        $jacocoInit[41] = true;
        InstallationStatus mapInstallationStatus = mapInstallationStatus(download, installationState);
        $jacocoInit[42] = true;
        boolean mapIndeterminateState = mapIndeterminateState(download, installationState);
        int speed = getSpeed(download);
        $jacocoInit[43] = true;
        String versionName = getVersionName(download, installationState);
        $jacocoInit[44] = true;
        Install install = new Install(mapInstallation, mapInstallationStatus, installationType, mapIndeterminateState, speed, md5, packageName, versioncode, versionName, getAppName(download, installationState), getAppIcon(download, installationState));
        $jacocoInit[45] = true;
        return install;
    }

    private String getVersionName(Download download, InstallationState installationState) {
        boolean[] $jacocoInit = $jacocoInit();
        if (download != null) {
            $jacocoInit[46] = true;
            String versionName = download.getVersionName();
            $jacocoInit[47] = true;
            return versionName;
        }
        String versionName2 = installationState.getVersionName();
        $jacocoInit[48] = true;
        return versionName2;
    }

    private String getAppIcon(Download download, InstallationState installationState) {
        boolean[] $jacocoInit = $jacocoInit();
        if (download != null) {
            $jacocoInit[49] = true;
            String icon = download.getIcon();
            $jacocoInit[50] = true;
            return icon;
        }
        String icon2 = installationState.getIcon();
        $jacocoInit[51] = true;
        return icon2;
    }

    private String getAppName(Download download, InstallationState installationState) {
        boolean[] $jacocoInit = $jacocoInit();
        if (download != null) {
            $jacocoInit[52] = true;
            String appName = download.getAppName();
            $jacocoInit[53] = true;
            return appName;
        }
        String name = installationState.getName();
        $jacocoInit[54] = true;
        return name;
    }

    private int getSpeed(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        if (download != null) {
            $jacocoInit[55] = true;
            int downloadSpeed = download.getDownloadSpeed();
            $jacocoInit[56] = true;
            return downloadSpeed;
        }
        $jacocoInit[57] = true;
        return 0;
    }

    private boolean mapIndeterminateState(Download download, InstallationState installationState) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (mapIndeterminate(download)) {
            $jacocoInit[58] = true;
        } else {
            int status = installationState.getStatus();
            $jacocoInit[59] = true;
            int type = installationState.getType();
            $jacocoInit[60] = true;
            if (mapInstallIndeterminate(status, type, download)) {
                $jacocoInit[61] = true;
            } else {
                z = false;
                $jacocoInit[63] = true;
                $jacocoInit[64] = true;
                return z;
            }
        }
        $jacocoInit[62] = true;
        z = true;
        $jacocoInit[64] = true;
        return z;
    }

    private InstallationStatus mapInstallationStatus(Download download, InstallationState installationState) {
        boolean[] $jacocoInit = $jacocoInit();
        if (installationState.getStatus() == 4) {
            InstallationStatus installationStatus = InstallationStatus.INSTALLED;
            $jacocoInit[65] = true;
            return installationStatus;
        }
        if (installationState.getStatus() != 3) {
            $jacocoInit[66] = true;
        } else {
            $jacocoInit[67] = true;
            if (installationState.getType() == 0) {
                $jacocoInit[68] = true;
            } else {
                InstallationStatus installationStatus2 = InstallationStatus.INSTALLING;
                $jacocoInit[69] = true;
                return installationStatus2;
            }
        }
        if (installationState.getStatus() != 2) {
            $jacocoInit[70] = true;
        } else if (download == null) {
            $jacocoInit[71] = true;
        } else {
            $jacocoInit[72] = true;
            if (download.getOverallDownloadStatus() != 1) {
                $jacocoInit[73] = true;
            } else {
                InstallationStatus installationStatus3 = InstallationStatus.DOWNLOADING;
                $jacocoInit[74] = true;
                return installationStatus3;
            }
        }
        if (installationState.getStatus() == 5) {
            InstallationStatus installationStatus4 = InstallationStatus.INSTALLATION_TIMEOUT;
            $jacocoInit[75] = true;
            return installationStatus4;
        }
        InstallationStatus mapDownloadState = mapDownloadState(download);
        $jacocoInit[76] = true;
        return mapDownloadState;
    }

    private int mapInstallation(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        int progress = 0;
        String str = TAG;
        if (download != null) {
            $jacocoInit[77] = true;
            progress = download.getOverallProgress();
            $jacocoInit[78] = true;
            Logger instance = Logger.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(" download is not null ");
            sb.append(progress);
            String sb2 = sb.toString();
            $jacocoInit[79] = true;
            instance.mo2136d(str, sb2);
            $jacocoInit[80] = true;
        } else {
            Logger instance2 = Logger.getInstance();
            $jacocoInit[81] = true;
            instance2.mo2136d(str, " download is null");
            $jacocoInit[82] = true;
        }
        $jacocoInit[83] = true;
        return progress;
    }

    private boolean mapIndeterminate(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean isIndeterminate = false;
        if (download != null) {
            $jacocoInit[85] = true;
            switch (download.getOverallDownloadStatus()) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                    isIndeterminate = false;
                    $jacocoInit[87] = true;
                    break;
                case 13:
                    isIndeterminate = true;
                    $jacocoInit[86] = true;
                    break;
                default:
                    isIndeterminate = false;
                    $jacocoInit[88] = true;
                    break;
            }
        } else {
            $jacocoInit[84] = true;
        }
        $jacocoInit[89] = true;
        return isIndeterminate;
    }

    private InstallationStatus mapDownloadState(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallationStatus status = InstallationStatus.UNINSTALLED;
        if (download != null) {
            $jacocoInit[90] = true;
            switch (download.getOverallDownloadStatus()) {
                case 0:
                    status = InstallationStatus.INITIAL_STATE;
                    $jacocoInit[92] = true;
                    break;
                case 1:
                case 10:
                case 12:
                    status = InstallationStatus.UNINSTALLED;
                    $jacocoInit[93] = true;
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 11:
                    status = InstallationStatus.DOWNLOADING;
                    $jacocoInit[99] = true;
                    break;
                case 6:
                    status = InstallationStatus.PAUSED;
                    $jacocoInit[94] = true;
                    break;
                case 9:
                    int downloadError = download.getDownloadError();
                    if (downloadError == 1) {
                        status = InstallationStatus.GENERIC_ERROR;
                        $jacocoInit[96] = true;
                    } else if (downloadError != 2) {
                        $jacocoInit[95] = true;
                    } else {
                        status = InstallationStatus.NOT_ENOUGH_SPACE_ERROR;
                        $jacocoInit[97] = true;
                    }
                    $jacocoInit[98] = true;
                    break;
                case 13:
                    status = InstallationStatus.IN_QUEUE;
                    $jacocoInit[100] = true;
                    break;
                default:
                    $jacocoInit[91] = true;
                    break;
            }
            $jacocoInit[101] = true;
        } else {
            Logger instance = Logger.getInstance();
            $jacocoInit[102] = true;
            instance.mo2136d(TAG, "mapping a null Download state");
            $jacocoInit[103] = true;
        }
        $jacocoInit[104] = true;
        return status;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean mapInstallIndeterminate(int r6, int r7, p005cm.aptoide.p006pt.database.realm.Download r8) {
        /*
            r5 = this;
            boolean[] r0 = $jacocoInit()
            r1 = 0
            r2 = 1
            if (r6 == r2) goto L_0x0051
            r3 = 2
            r4 = 0
            if (r6 == r3) goto L_0x002c
            r3 = 3
            if (r6 == r3) goto L_0x001a
            r3 = 4
            if (r6 == r3) goto L_0x0051
            r3 = 5
            if (r6 == r3) goto L_0x001a
            r3 = 105(0x69, float:1.47E-43)
            r0[r3] = r2
            goto L_0x0056
        L_0x001a:
            if (r7 == 0) goto L_0x0022
            r3 = 107(0x6b, float:1.5E-43)
            r0[r3] = r2
            r4 = 1
            goto L_0x0026
        L_0x0022:
            r3 = 108(0x6c, float:1.51E-43)
            r0[r3] = r2
        L_0x0026:
            r1 = r4
            r3 = 109(0x6d, float:1.53E-43)
            r0[r3] = r2
            goto L_0x0056
        L_0x002c:
            if (r8 != 0) goto L_0x0033
            r3 = 110(0x6e, float:1.54E-43)
            r0[r3] = r2
            goto L_0x0041
        L_0x0033:
            r3 = 111(0x6f, float:1.56E-43)
            r0[r3] = r2
            int r3 = r8.getOverallDownloadStatus()
            if (r3 == r2) goto L_0x0046
            r3 = 112(0x70, float:1.57E-43)
            r0[r3] = r2
        L_0x0041:
            r3 = 114(0x72, float:1.6E-43)
            r0[r3] = r2
            goto L_0x004b
        L_0x0046:
            r3 = 113(0x71, float:1.58E-43)
            r0[r3] = r2
            r4 = 1
        L_0x004b:
            r1 = r4
            r3 = 115(0x73, float:1.61E-43)
            r0[r3] = r2
            goto L_0x0056
        L_0x0051:
            r1 = 0
            r3 = 106(0x6a, float:1.49E-43)
            r0[r3] = r2
        L_0x0056:
            if (r8 != 0) goto L_0x005d
            r3 = 116(0x74, float:1.63E-43)
            r0[r3] = r2
            goto L_0x006d
        L_0x005d:
            int r3 = r8.getOverallDownloadStatus()
            if (r3 == 0) goto L_0x0068
            r3 = 117(0x75, float:1.64E-43)
            r0[r3] = r2
            goto L_0x006d
        L_0x0068:
            r1 = 1
            r3 = 118(0x76, float:1.65E-43)
            r0[r3] = r2
        L_0x006d:
            r3 = 119(0x77, float:1.67E-43)
            r0[r3] = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.install.InstallManager.mapInstallIndeterminate(int, int, cm.aptoide.pt.database.realm.Download):boolean");
    }

    private Download updateDownloadAction(Download download, Download storedDownload) {
        boolean[] $jacocoInit = $jacocoInit();
        if (storedDownload.getAction() == download.getAction()) {
            $jacocoInit[120] = true;
        } else {
            $jacocoInit[121] = true;
            storedDownload.setAction(download.getAction());
            $jacocoInit[122] = true;
            this.downloadRepository.save(storedDownload);
            $jacocoInit[123] = true;
        }
        $jacocoInit[124] = true;
        return storedDownload;
    }

    private C0120S<Throwable> createDownloadAndRetry(C0120S<? extends Throwable> errors, Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Throwable> f = errors.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C3993J<Object,Object>(this, download));
        $jacocoInit[125] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2070a(Download download, Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof DownloadNotFoundException) {
            $jacocoInit[293] = true;
            this.downloadRepository.save(download);
            $jacocoInit[294] = true;
            C0120S c = C0120S.m652c(throwable);
            $jacocoInit[295] = true;
            return c;
        }
        C0120S a = C0120S.m631a(throwable);
        $jacocoInit[296] = true;
        return a;
    }

    private C0120S<Install> installInBackground(Install install, boolean forceDefaultInstall, boolean shouldSetPackageInstaller) {
        boolean[] $jacocoInit = $jacocoInit();
        String md5 = install.getMd5();
        String packageName = install.getPackageName();
        $jacocoInit[126] = true;
        int versionCode = install.getVersionCode();
        $jacocoInit[127] = true;
        C0120S install2 = getInstall(md5, packageName, versionCode);
        $jacocoInit[128] = true;
        C0120S startBackgroundInstallationAndWait = startBackgroundInstallationAndWait(install, forceDefaultInstall, shouldSetPackageInstaller);
        $jacocoInit[129] = true;
        C0120S<Install> d = install2.mo3651d(startBackgroundInstallationAndWait);
        $jacocoInit[130] = true;
        return d;
    }

    private C0120S<Install> startBackgroundInstallationAndWait(Install install, boolean forceDefaultInstall, boolean shouldSetPackageInstaller) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = waitBackgroundInstallationResult(install.getMd5()).mo3635b((C0128a) new C4034ca(this, install, forceDefaultInstall, shouldSetPackageInstaller));
        C3978C c = new C3978C(install);
        $jacocoInit[131] = true;
        C0120S<Install> j = b.mo3669j(c);
        $jacocoInit[132] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2075a(Install install, boolean forceDefaultInstall, boolean shouldSetPackageInstaller) {
        boolean[] $jacocoInit = $jacocoInit();
        startBackgroundInstallation(install.getMd5(), forceDefaultInstall, shouldSetPackageInstaller);
        $jacocoInit[292] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Install m316a(Install install, Void aVoid) {
        $jacocoInit()[291] = true;
        return install;
    }

    private C0120S<Void> waitBackgroundInstallationResult(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m634a((C0122a<T>) new BroadcastRegisterOnSubscribe<T>(this.context, new IntentFilter(InstallService.ACTION_INSTALL_FINISHED), null, null));
        C4129w wVar = C4129w.f7662a;
        $jacocoInit[133] = true;
        C0120S d = a.mo3653d((C0132p<? super T, Boolean>) wVar);
        C4094k kVar = new C4094k(md5);
        $jacocoInit[134] = true;
        C0120S e = d.mo3658e((C0132p<? super T, Boolean>) kVar);
        C4049ha haVar = C4049ha.f7555a;
        $jacocoInit[135] = true;
        C0120S<Void> j = e.mo3669j(haVar);
        $jacocoInit[136] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m317a(Intent intent) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (intent == null) {
            $jacocoInit[284] = true;
        } else {
            $jacocoInit[285] = true;
            String action = intent.getAction();
            $jacocoInit[286] = true;
            if (!InstallService.ACTION_INSTALL_FINISHED.equals(action)) {
                $jacocoInit[287] = true;
            } else {
                $jacocoInit[288] = true;
                z = true;
                Boolean valueOf = Boolean.valueOf(z);
                $jacocoInit[290] = true;
                return valueOf;
            }
        }
        z = false;
        $jacocoInit[289] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[290] = true;
        return valueOf2;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m319a(String md5, Intent intent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(md5.equals(intent.getStringExtra(InstallService.EXTRA_INSTALLATION_MD5)));
        $jacocoInit[283] = true;
        return valueOf;
    }

    /* renamed from: b */
    static /* synthetic */ Void m331b(Intent intent) {
        $jacocoInit()[282] = true;
        return null;
    }

    private void startBackgroundInstallation(String md5, boolean forceDefaultInstall, boolean shouldSetPackageInstaller) {
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent(this.context, InstallService.class);
        $jacocoInit[137] = true;
        intent.setAction(InstallService.ACTION_START_INSTALL);
        $jacocoInit[138] = true;
        intent.putExtra(InstallService.EXTRA_INSTALLATION_MD5, md5);
        $jacocoInit[139] = true;
        intent.putExtra(InstallService.EXTRA_FORCE_DEFAULT_INSTALL, forceDefaultInstall);
        $jacocoInit[140] = true;
        intent.putExtra(InstallService.EXTRA_SET_PACKAGE_INSTALLER, shouldSetPackageInstaller);
        if (!(this.installer instanceof DefaultInstaller)) {
            $jacocoInit[141] = true;
        } else {
            $jacocoInit[142] = true;
            intent.putExtra(InstallService.EXTRA_INSTALLER_TYPE, 0);
            $jacocoInit[143] = true;
        }
        this.context.startService(intent);
        $jacocoInit[144] = true;
    }

    public boolean showWarning() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        boolean wasRootDialogShowed = SecurePreferences.isRootDialogShowed(this.securePreferences);
        $jacocoInit[145] = true;
        Single isRootAvailable = this.rootAvailabilityManager.isRootAvailable();
        $jacocoInit[146] = true;
        C14959b a = isRootAvailable.mo3689a();
        $jacocoInit[147] = true;
        boolean isRooted = ((Boolean) a.mo46175a()).booleanValue();
        $jacocoInit[148] = true;
        boolean canGiveRoot = ManagerPreferences.allowRootInstallation(this.securePreferences);
        if (!isRooted) {
            $jacocoInit[149] = true;
        } else if (wasRootDialogShowed) {
            $jacocoInit[150] = true;
        } else if (canGiveRoot) {
            $jacocoInit[151] = true;
        } else {
            $jacocoInit[152] = true;
            z = true;
            $jacocoInit[154] = true;
            return z;
        }
        z = false;
        $jacocoInit[153] = true;
        $jacocoInit[154] = true;
        return z;
    }

    public void rootInstallAllowed(boolean allowRoot) {
        boolean[] $jacocoInit = $jacocoInit();
        SecurePreferences.setRootDialogShowed(true, this.securePreferences);
        $jacocoInit[155] = true;
        ManagerPreferences.setAllowRootInstallation(allowRoot, this.sharedPreferences);
        $jacocoInit[156] = true;
    }

    public C0120S<Boolean> startInstalls(List<Download> downloads) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) downloads);
        C4092j jVar = new C4092j(this);
        $jacocoInit[157] = true;
        C0120S j = a.mo3669j(jVar);
        $jacocoInit[158] = true;
        C0120S m = j.mo3675m();
        C3976B b = C3976B.f7458a;
        $jacocoInit[159] = true;
        C0120S f = m.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) b);
        $jacocoInit[160] = true;
        C0120S m2 = f.mo3675m();
        C4096l lVar = C4096l.f7637a;
        $jacocoInit[161] = true;
        C0120S j2 = m2.mo3669j(lVar);
        C3997L l = C3997L.f7481a;
        $jacocoInit[162] = true;
        C0120S<Boolean> l2 = j2.mo3674l(l);
        $jacocoInit[163] = true;
        return l2;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo2081d(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S f = install(download).mo3604f();
        $jacocoInit[281] = true;
        return f;
    }

    /* renamed from: j */
    static /* synthetic */ C0120S m338j(List observables) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = C0120S.m647b((Iterable<? extends C0120S<? extends T>>) observables);
        $jacocoInit[280] = true;
        return b;
    }

    /* renamed from: k */
    static /* synthetic */ Boolean m339k(List installs) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(true);
        $jacocoInit[279] = true;
        return valueOf;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m329b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(false);
        $jacocoInit[278] = true;
        return valueOf;
    }

    public C0117M onAppInstalled(Installed installed) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S asList = this.installedRepository.getAsList(installed.getPackageName());
        $jacocoInit[164] = true;
        C0120S d = asList.mo3647d();
        C4018W w = new C4018W(installed);
        $jacocoInit[165] = true;
        C0120S h = d.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) w);
        C4133y yVar = new C4133y(this, installed);
        $jacocoInit[166] = true;
        C0120S g = h.mo3663g((C0132p<? super T, ? extends C0117M>) yVar);
        $jacocoInit[167] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[168] = true;
        return l;
    }

    /* renamed from: a */
    static /* synthetic */ Iterable m321a(Installed installed, List installeds) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!installeds.isEmpty()) {
            $jacocoInit[274] = true;
        } else {
            $jacocoInit[275] = true;
            installeds.add(installed);
            $jacocoInit[276] = true;
        }
        $jacocoInit[277] = true;
        return installeds;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo2068a(Installed installed, Installed databaseInstalled) {
        boolean[] $jacocoInit = $jacocoInit();
        if (databaseInstalled.getVersionCode() == installed.getVersionCode()) {
            $jacocoInit[266] = true;
            installed.setType(databaseInstalled.getType());
            $jacocoInit[267] = true;
            installed.setStatus(4);
            $jacocoInit[268] = true;
            C0117M c = C0117M.m597c((C0128a) new C4003O(this, installed));
            $jacocoInit[269] = true;
            return c;
        }
        InstalledRepository installedRepository2 = this.installedRepository;
        String packageName = databaseInstalled.getPackageName();
        $jacocoInit[270] = true;
        int versionCode = databaseInstalled.getVersionCode();
        $jacocoInit[271] = true;
        C0117M remove = installedRepository2.remove(packageName, versionCode);
        $jacocoInit[272] = true;
        return remove;
    }

    /* renamed from: c */
    public /* synthetic */ void mo2079c(Installed installed) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installedRepository.save(installed);
        $jacocoInit[273] = true;
    }

    public C0117M onAppRemoved(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S asList = this.installedRepository.getAsList(packageName);
        $jacocoInit[169] = true;
        C0120S d = asList.mo3647d();
        C3982E e = C3982E.f7464a;
        $jacocoInit[170] = true;
        C0120S h = d.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) e);
        C4040ea eaVar = new C4040ea(this, packageName);
        $jacocoInit[171] = true;
        C0120S g = h.mo3663g((C0132p<? super T, ? extends C0117M>) eaVar);
        $jacocoInit[172] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[173] = true;
        return l;
    }

    /* renamed from: h */
    static /* synthetic */ Iterable m336h(List installeds) {
        $jacocoInit()[265] = true;
        return installeds;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo2069a(String packageName, Installed installed) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M remove = this.installedRepository.remove(packageName, installed.getVersionCode());
        $jacocoInit[264] = true;
        return remove;
    }

    private C0120S<InstallationType> getInstallationType(String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installed = this.installedRepository.getInstalled(packageName);
        C4010S s = new C4010S(versionCode);
        $jacocoInit[174] = true;
        C0120S j = installed.mo3669j(s);
        C3999M m = C3999M.f7485a;
        $jacocoInit[175] = true;
        C0120S<InstallationType> b = j.mo3636b((C0129b<? super T>) m);
        $jacocoInit[176] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ InstallationType m315a(int versionCode, Installed installed) {
        boolean[] $jacocoInit = $jacocoInit();
        if (installed == null) {
            InstallationType installationType = InstallationType.INSTALL;
            $jacocoInit[260] = true;
            return installationType;
        } else if (installed.getVersionCode() == versionCode) {
            InstallationType installationType2 = InstallationType.INSTALLED;
            $jacocoInit[261] = true;
            return installationType2;
        } else if (installed.getVersionCode() > versionCode) {
            InstallationType installationType3 = InstallationType.DOWNGRADE;
            $jacocoInit[262] = true;
            return installationType3;
        } else {
            InstallationType installationType4 = InstallationType.UPDATE;
            $jacocoInit[263] = true;
            return installationType4;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m324a(InstallationType installationType) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        $jacocoInit[258] = true;
        instance.mo2136d("AptoideDownloadManager", " emiting installation type");
        $jacocoInit[259] = true;
    }

    public C0117M onUpdateConfirmed(Installed installed) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M onAppInstalled = onAppInstalled(installed);
        $jacocoInit[177] = true;
        return onAppInstalled;
    }

    public Single<Download> getDownload(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S download = this.downloadRepository.getDownload(md5);
        $jacocoInit[178] = true;
        C0120S d = download.mo3647d();
        $jacocoInit[179] = true;
        Single<Download> n = d.mo3678n();
        $jacocoInit[180] = true;
        return n;
    }

    public C0117M retryTimedOutInstallations() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getTimedOutInstallations().mo3647d();
        C3986G g = C3986G.f7468a;
        $jacocoInit[181] = true;
        C0120S h = d.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) g);
        C4104p pVar = new C4104p(this);
        $jacocoInit[182] = true;
        C0120S i = h.mo3668i(pVar);
        C4028aa aaVar = new C4028aa(this);
        $jacocoInit[183] = true;
        C0120S g2 = i.mo3663g((C0132p<? super T, ? extends C0117M>) aaVar);
        $jacocoInit[184] = true;
        C0117M l = g2.mo3673l();
        $jacocoInit[185] = true;
        return l;
    }

    /* renamed from: i */
    static /* synthetic */ Iterable m337i(List installs) {
        $jacocoInit()[257] = true;
        return installs;
    }

    /* renamed from: e */
    public /* synthetic */ Single mo2086e(Install install) {
        boolean[] $jacocoInit = $jacocoInit();
        Single download = getDownload(install.getMd5());
        $jacocoInit[256] = true;
        return download;
    }

    /* renamed from: c */
    public /* synthetic */ C0117M mo2078c(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M defaultInstall = defaultInstall(download);
        $jacocoInit[255] = true;
        return defaultInstall;
    }

    public C0117M cleanTimedOutInstalls() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getTimedOutInstallations().mo3647d();
        C3984F f = new C3984F(this);
        $jacocoInit[186] = true;
        C0120S f2 = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) f);
        $jacocoInit[187] = true;
        C0120S m = f2.mo3675m();
        $jacocoInit[188] = true;
        C0117M l = m.mo3673l();
        $jacocoInit[189] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2072a(List installs) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) installs);
        C4131x xVar = new C4131x(this);
        $jacocoInit[246] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) xVar);
        $jacocoInit[247] = true;
        return f;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo2083d(Install install) {
        boolean[] $jacocoInit = $jacocoInit();
        InstalledRepository installedRepository2 = this.installedRepository;
        String packageName = install.getPackageName();
        $jacocoInit[248] = true;
        int versionCode = install.getVersionCode();
        $jacocoInit[249] = true;
        C0120S s = installedRepository2.get(packageName, versionCode);
        $jacocoInit[250] = true;
        C0120S d = s.mo3647d();
        C3980D d2 = new C3980D(this);
        $jacocoInit[251] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) d2);
        $jacocoInit[252] = true;
        return b;
    }

    /* renamed from: e */
    public /* synthetic */ void mo2087e(Installed installed) {
        boolean[] $jacocoInit = $jacocoInit();
        installed.setStatus(1);
        $jacocoInit[253] = true;
        this.installedRepository.save(installed);
        $jacocoInit[254] = true;
    }

    public C0120S<List<Installed>> fetchInstalled() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S allInstalledSorted = this.installedRepository.getAllInstalledSorted();
        $jacocoInit[190] = true;
        C0120S d = allInstalledSorted.mo3647d();
        C4043fa faVar = C4043fa.f7548a;
        $jacocoInit[191] = true;
        C0120S h = d.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) faVar);
        C4022Y y = C4022Y.f7521a;
        $jacocoInit[192] = true;
        C0120S d2 = h.mo3653d((C0132p<? super T, Boolean>) y);
        $jacocoInit[193] = true;
        C0120S<List<Installed>> m = d2.mo3675m();
        $jacocoInit[194] = true;
        return m;
    }

    /* renamed from: b */
    static /* synthetic */ Iterable m330b(List list) {
        $jacocoInit()[245] = true;
        return list;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m318a(Installed item) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!item.isSystemApp()) {
            $jacocoInit[242] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[243] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[244] = true;
        return valueOf;
    }

    public C0120S<Boolean> isInstalled(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isInstalled = this.installedRepository.isInstalled(packageName);
        $jacocoInit[195] = true;
        C0120S<Boolean> d = isInstalled.mo3647d();
        $jacocoInit[196] = true;
        return d;
    }

    public C0120S<Install> filterInstalled(Install item) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isInstalled = this.installedRepository.isInstalled(item.getPackageName());
        $jacocoInit[197] = true;
        C0120S d = isInstalled.mo3647d();
        C3974A a = new C3974A(item);
        $jacocoInit[198] = true;
        C0120S<Install> f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) a);
        $jacocoInit[199] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m322a(Install item, Boolean isInstalled) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isInstalled.booleanValue()) {
            $jacocoInit[239] = true;
            C0120S c = C0120S.m651c();
            $jacocoInit[240] = true;
            return c;
        }
        C0120S c2 = C0120S.m652c(item);
        $jacocoInit[241] = true;
        return c2;
    }

    public C0120S<Install> filterNonInstalled(Install item) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isInstalled = this.installedRepository.isInstalled(item.getPackageName());
        $jacocoInit[200] = true;
        C0120S d = isInstalled.mo3647d();
        C4122u uVar = new C4122u(item);
        $jacocoInit[201] = true;
        C0120S<Install> f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) uVar);
        $jacocoInit[202] = true;
        return f;
    }

    /* renamed from: b */
    static /* synthetic */ C0120S m332b(Install item, Boolean isInstalled) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isInstalled.booleanValue()) {
            $jacocoInit[236] = true;
            C0120S c = C0120S.m652c(item);
            $jacocoInit[237] = true;
            return c;
        }
        C0120S c2 = C0120S.m651c();
        $jacocoInit[238] = true;
        return c2;
    }

    public boolean wasAppEverInstalled(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installationsHistory = this.installedRepository.getInstallationsHistory();
        $jacocoInit[203] = true;
        C0120S d = installationsHistory.mo3647d();
        C3995K k = C3995K.f7478a;
        $jacocoInit[204] = true;
        C0120S h = d.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) k);
        C4098m mVar = new C4098m(packageName);
        $jacocoInit[205] = true;
        C0120S d2 = h.mo3653d((C0132p<? super T, Boolean>) mVar);
        $jacocoInit[206] = true;
        C0120S m = d2.mo3675m();
        C3990I i = C3990I.f7473a;
        $jacocoInit[207] = true;
        C0120S f = m.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) i);
        $jacocoInit[208] = true;
        C14906b k2 = f.mo3672k();
        $jacocoInit[209] = true;
        boolean booleanValue = ((Boolean) k2.mo46110a()).booleanValue();
        $jacocoInit[210] = true;
        return booleanValue;
    }

    /* renamed from: l */
    static /* synthetic */ Iterable m340l(List installation) {
        $jacocoInit()[235] = true;
        return installation;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m320a(String packageName, Installation installation) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(packageName.equals(installation.getPackageName()));
        $jacocoInit[234] = true;
        return valueOf;
    }

    /* renamed from: m */
    static /* synthetic */ C0120S m341m(List installations) {
        boolean[] $jacocoInit = $jacocoInit();
        if (installations.isEmpty()) {
            $jacocoInit[231] = true;
            C0120S c = C0120S.m652c(Boolean.FALSE);
            $jacocoInit[232] = true;
            return c;
        }
        C0120S c2 = C0120S.m652c(Boolean.TRUE);
        $jacocoInit[233] = true;
        return c2;
    }

    public void moveCompletedDownloadFiles(Download download) {
        boolean[] $jacocoInit = $jacocoInit();
        Iterator it = download.getFilesToDownload().iterator();
        $jacocoInit[211] = true;
        while (it.hasNext()) {
            FileToDownload fileToDownload = (FileToDownload) it.next();
            $jacocoInit[212] = true;
            boolean fileExists = FileUtils.fileExists(getFilePathFromFileType(fileToDownload));
            String str = " ";
            String str2 = TAG;
            if (!fileExists) {
                $jacocoInit[213] = true;
                Logger instance = Logger.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("trying to move file : ");
                $jacocoInit[214] = true;
                sb.append(fileToDownload.getFileName());
                sb.append(str);
                $jacocoInit[215] = true;
                sb.append(fileToDownload.getPackageName());
                String sb2 = sb.toString();
                $jacocoInit[216] = true;
                instance.mo2136d(str2, sb2);
                $jacocoInit[217] = true;
                String newFilePath = getFilePathFromFileType(fileToDownload);
                $jacocoInit[218] = true;
                this.fileUtils.copyFile(fileToDownload.getPath(), newFilePath, fileToDownload.getFileName());
                $jacocoInit[219] = true;
                fileToDownload.setPath(newFilePath);
                $jacocoInit[220] = true;
            } else {
                Logger instance2 = Logger.getInstance();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("tried moving file: ");
                $jacocoInit[221] = true;
                sb3.append(fileToDownload.getFileName());
                sb3.append(str);
                $jacocoInit[222] = true;
                sb3.append(fileToDownload.getPackageName());
                sb3.append(" but it was already moved");
                String sb4 = sb3.toString();
                $jacocoInit[223] = true;
                instance2.mo2136d(str2, sb4);
                $jacocoInit[224] = true;
            }
            $jacocoInit[225] = true;
        }
        this.downloadRepository.save(download);
        $jacocoInit[226] = true;
    }

    private String getFilePathFromFileType(FileToDownload fileToDownload) {
        String path;
        boolean[] $jacocoInit = $jacocoInit();
        int fileType = fileToDownload.getFileType();
        if (fileType == 0) {
            path = this.apkPath;
            $jacocoInit[227] = true;
        } else if (fileType != 1) {
            path = this.cachePath;
            $jacocoInit[229] = true;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(this.obbPath);
            sb.append(fileToDownload.getPackageName());
            sb.append("/");
            path = sb.toString();
            $jacocoInit[228] = true;
        }
        $jacocoInit[230] = true;
        return path;
    }
}
