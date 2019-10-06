package p005cm.aptoide.p006pt.install.installer;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.p000v4.content.FileProvider;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.realm.FileToDownload;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.downloadmanager.Constants;
import p005cm.aptoide.p006pt.install.AppInstallerStatusReceiver;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.install.Installer;
import p005cm.aptoide.p006pt.install.InstallerAnalytics;
import p005cm.aptoide.p006pt.install.RootCommandTimeoutException;
import p005cm.aptoide.p006pt.install.exception.InstallationException;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.packageinstaller.AppInstaller;
import p005cm.aptoide.p006pt.packageinstaller.InstallStatus;
import p005cm.aptoide.p006pt.packageinstaller.InstallStatus.Status;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.root.RootAvailabilityManager;
import p005cm.aptoide.p006pt.root.RootShell;
import p005cm.aptoide.p006pt.utils.AptoideUtils;
import p005cm.aptoide.p006pt.utils.BroadcastRegisterOnSubscribe;
import p005cm.aptoide.p006pt.utils.FileUtils;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.install.installer.DefaultInstaller */
public class DefaultInstaller implements Installer {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String OBB_FOLDER;
    public static final String ROOT_INSTALL_COMMAND = "pm install -r ";
    private static final String TAG = DefaultInstaller.class.getSimpleName();
    private final AppInstaller appInstaller;
    private final AppInstallerStatusReceiver appInstallerStatusReceiver;
    private FileUtils fileUtils;
    private final InstallationProvider installationProvider;
    private InstalledRepository installedRepository;
    private InstallerAnalytics installerAnalytics;
    private int installingStateTimeout;
    private final PackageManager packageManager;
    private RootAvailabilityManager rootAvailabilityManager;
    private final SharedPreferences sharedPreferences;

    /* renamed from: cm.aptoide.pt.install.installer.DefaultInstaller$1 */
    static /* synthetic */ class C40581 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$packageinstaller$InstallStatus$Status = new int[Status.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(1556985518382858567L, "cm/aptoide/pt/install/installer/DefaultInstaller$1", 12);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$packageinstaller$InstallStatus$Status[Status.INSTALLING.ordinal()] = 1;
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
                                $jacocoInit[10] = true;
                            }
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$packageinstaller$InstallStatus$Status[Status.SUCCESS.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$packageinstaller$InstallStatus$Status[Status.FAIL.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$packageinstaller$InstallStatus$Status[Status.CANCELED.ordinal()] = 4;
            $jacocoInit[7] = true;
            $SwitchMap$cm$aptoide$pt$packageinstaller$InstallStatus$Status[Status.UNKNOWN_ERROR.ordinal()] = 5;
            $jacocoInit[9] = true;
            $jacocoInit[11] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6640294251540048210L, "cm/aptoide/pt/install/installer/DefaultInstaller", 220);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        $jacocoInit[217] = true;
        sb.append(externalStorageDirectory.getAbsolutePath());
        sb.append("/Android/obb/");
        OBB_FOLDER = sb.toString();
        $jacocoInit[218] = true;
        $jacocoInit[219] = true;
    }

    public DefaultInstaller(PackageManager packageManager2, InstallationProvider installationProvider2, AppInstaller appInstaller2, FileUtils fileUtils2, boolean debug, InstalledRepository installedRepository2, int rootTimeout, RootAvailabilityManager rootAvailabilityManager2, SharedPreferences sharedPreferences2, InstallerAnalytics installerAnalytics2, int installingStateTimeout2, AppInstallerStatusReceiver appInstallerStatusReceiver2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.packageManager = packageManager2;
        this.installationProvider = installationProvider2;
        this.appInstaller = appInstaller2;
        this.fileUtils = fileUtils2;
        this.installedRepository = installedRepository2;
        this.installerAnalytics = installerAnalytics2;
        this.appInstallerStatusReceiver = appInstallerStatusReceiver2;
        RootShell.debugMode = debug;
        RootShell.defaultCommandTimeout = rootTimeout;
        this.rootAvailabilityManager = rootAvailabilityManager2;
        this.sharedPreferences = sharedPreferences2;
        this.installingStateTimeout = installingStateTimeout2;
        $jacocoInit[0] = true;
    }

    public PackageManager getPackageManager() {
        boolean[] $jacocoInit = $jacocoInit();
        PackageManager packageManager2 = this.packageManager;
        $jacocoInit[1] = true;
        return packageManager2;
    }

    public C0117M install(Context context, String md5, boolean forceDefaultInstall, boolean shouldSetPackageInstaller) {
        boolean[] $jacocoInit = $jacocoInit();
        Single isRootAvailable = this.rootAvailabilityManager.isRootAvailable();
        C4071f fVar = new C4071f(this);
        $jacocoInit[2] = true;
        Single b = isRootAvailable.mo3695b((C0129b<? super T>) fVar);
        C4081p pVar = new C4081p(this, md5);
        $jacocoInit[3] = true;
        C0120S c = b.mo3697c(pVar);
        $jacocoInit[4] = true;
        C0120S a = c.mo3616a(Schedulers.computation());
        C4055B b2 = new C4055B(this);
        $jacocoInit[5] = true;
        C0120S b3 = a.mo3636b((C0129b<? super T>) b2);
        C4072g gVar = new C4072g(this, forceDefaultInstall, context, shouldSetPackageInstaller);
        $jacocoInit[6] = true;
        C0120S f = b3.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) gVar);
        C4086u uVar = C4086u.f7620a;
        $jacocoInit[7] = true;
        C0120S a2 = f.mo3621a((C0129b<? super Throwable>) uVar);
        $jacocoInit[8] = true;
        C0117M l = a2.mo3673l();
        $jacocoInit[9] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15107a(Boolean isRoot) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallerAnalytics installerAnalytics2 = this.installerAnalytics;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        $jacocoInit[214] = true;
        boolean allowRootInstallation = ManagerPreferences.allowRootInstallation(sharedPreferences2);
        boolean booleanValue = isRoot.booleanValue();
        $jacocoInit[215] = true;
        installerAnalytics2.installationType(allowRootInstallation, booleanValue);
        $jacocoInit[216] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15102a(String md5, Boolean isRoot) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installation = this.installationProvider.getInstallation(md5);
        $jacocoInit[212] = true;
        C0120S d = installation.mo3647d();
        $jacocoInit[213] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15104a(Installation installation) {
        boolean[] $jacocoInit = $jacocoInit();
        installation.setStatus(3);
        $jacocoInit[209] = true;
        installation.setType(-1);
        $jacocoInit[210] = true;
        moveInstallationFiles(installation);
        $jacocoInit[211] = true;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15103a(boolean forceDefaultInstall, Context context, boolean shouldSetPackageInstaller, Installation installation) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[195] = true;
        Boolean valueOf = Boolean.valueOf(isInstalled(installation.getPackageName(), installation.getVersionCode()));
        $jacocoInit[196] = true;
        C0120S c = C0120S.m652c(valueOf);
        C4085t tVar = C4085t.f7619a;
        $jacocoInit[197] = true;
        C0120S l = c.mo3674l(tVar);
        $jacocoInit[198] = true;
        C0120S d = l.mo3647d();
        C4079n nVar = new C4079n(this, installation, forceDefaultInstall, context, shouldSetPackageInstaller);
        $jacocoInit[199] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) nVar);
        $jacocoInit[200] = true;
        return f;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m8589b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(false);
        $jacocoInit[208] = true;
        return valueOf;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15101a(Installation installation, boolean forceDefaultInstall, Context context, boolean shouldSetPackageInstaller, Boolean isInstalled) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isInstalled.booleanValue()) {
            $jacocoInit[201] = true;
            installation.setStatus(4);
            $jacocoInit[202] = true;
            installation.save();
            $jacocoInit[203] = true;
            C0120S c = C0120S.m652c(null);
            $jacocoInit[204] = true;
            return c;
        } else if (forceDefaultInstall) {
            $jacocoInit[205] = true;
            C0120S startDefaultInstallation = startDefaultInstallation(context, installation, shouldSetPackageInstaller);
            $jacocoInit[206] = true;
            return startDefaultInstallation;
        } else {
            C0120S startInstallation = startInstallation(context, installation, shouldSetPackageInstaller);
            $jacocoInit[207] = true;
            return startInstallation;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m8586a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[193] = true;
        instance.log(throwable);
        $jacocoInit[194] = true;
    }

    public C0117M update(Context context, String md5, boolean forceDefaultInstall, boolean shouldSetPackageInstaller) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M install = install(context, md5, forceDefaultInstall, shouldSetPackageInstaller);
        $jacocoInit[10] = true;
        return install;
    }

    public C0117M downgrade(Context context, String md5, boolean forceDefaultInstall, boolean shouldSetPackageInstaller) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installation = this.installationProvider.getInstallation(md5);
        $jacocoInit[11] = true;
        C0120S d = installation.mo3647d();
        C4054A a = new C4054A(this, context);
        $jacocoInit[12] = true;
        C0120S g = d.mo3663g((C0132p<? super T, ? extends C0117M>) a);
        $jacocoInit[13] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[14] = true;
        C0117M a2 = l.mo3580a(install(context, md5, forceDefaultInstall, shouldSetPackageInstaller));
        $jacocoInit[15] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo15096a(Context context, Installation installation) {
        boolean[] $jacocoInit = $jacocoInit();
        String packageName = installation.getPackageName();
        $jacocoInit[190] = true;
        String versionName = installation.getVersionName();
        $jacocoInit[191] = true;
        C0117M uninstall = uninstall(context, packageName, versionName);
        $jacocoInit[192] = true;
        return uninstall;
    }

    public C0117M uninstall(Context context, String packageName, String versionName) {
        boolean[] $jacocoInit = $jacocoInit();
        String str = Constants.PACKAGE;
        Uri uri = Uri.fromParts(str, packageName, null);
        $jacocoInit[16] = true;
        IntentFilter intentFilter = new IntentFilter();
        $jacocoInit[17] = true;
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        $jacocoInit[18] = true;
        intentFilter.addDataScheme(str);
        $jacocoInit[19] = true;
        C0120S a = C0120S.m633a((Callable<? extends T>) new C4078m<Object>(this, context, packageName, uri));
        C4066a aVar = new C4066a(this, context, intentFilter, packageName);
        $jacocoInit[20] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) aVar);
        $jacocoInit[21] = true;
        C0117M l = f.mo3673l();
        $jacocoInit[22] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ Void mo15093a(Context context, String packageName, Uri uri) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        startUninstallIntent(context, packageName, uri);
        $jacocoInit[189] = true;
        return null;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15098a(Context context, IntentFilter intentFilter, String packageName, Void uninstallStarted) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S waitPackageIntent = waitPackageIntent(context, intentFilter, packageName);
        $jacocoInit[188] = true;
        return waitPackageIntent;
    }

    public C0120S<InstallationState> getState(String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S asList = this.installedRepository.getAsList(packageName, versionCode);
        C4075j jVar = new C4075j(packageName, versionCode);
        $jacocoInit[23] = true;
        C0120S j = asList.mo3669j(jVar);
        C4083r rVar = C4083r.f7615a;
        $jacocoInit[24] = true;
        C0120S b = j.mo3636b((C0129b<? super T>) rVar);
        $jacocoInit[25] = true;
        C0120S<InstallationState> b2 = b.mo3628b();
        $jacocoInit[26] = true;
        return b2;
    }

    /* renamed from: a */
    static /* synthetic */ InstallationState m8582a(String packageName, int versionCode, Installed installed) {
        boolean[] $jacocoInit = $jacocoInit();
        if (installed != null) {
            $jacocoInit[183] = true;
            String packageName2 = installed.getPackageName();
            int versionCode2 = installed.getVersionCode();
            $jacocoInit[184] = true;
            String versionName = installed.getVersionName();
            int status = installed.getStatus();
            int type = installed.getType();
            $jacocoInit[185] = true;
            InstallationState installationState = new InstallationState(packageName2, versionCode2, versionName, status, type, installed.getName(), installed.getIcon());
            $jacocoInit[186] = true;
            return installationState;
        }
        InstallationState installationState2 = new InstallationState(packageName, versionCode, 1, -1);
        $jacocoInit[187] = true;
        return installationState2;
    }

    /* renamed from: a */
    static /* synthetic */ void m8585a(InstallationState installationState) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("creating an installation state ");
        $jacocoInit[179] = true;
        sb.append(installationState.getPackageName());
        sb.append(" state is: ");
        $jacocoInit[180] = true;
        sb.append(installationState.getStatus());
        String sb2 = sb.toString();
        $jacocoInit[181] = true;
        instance.mo2136d("AptoideDownloadManager", sb2);
        $jacocoInit[182] = true;
    }

    private C0120S<Installation> startDefaultInstallation(Context context, Installation installation, boolean shouldSetPackageInstaller) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Installation> b = defaultInstall(context, installation, shouldSetPackageInstaller).mo3636b((C0129b<? super T>) C4074i.f7592a);
        $jacocoInit[27] = true;
        return b;
    }

    /* renamed from: b */
    static /* synthetic */ void m8590b(Installation installation1) {
        boolean[] $jacocoInit = $jacocoInit();
        installation1.save();
        $jacocoInit[178] = true;
    }

    private C0120S<Installation> startInstallation(Context context, Installation installation, boolean shouldSetPackageInstaller) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S k = systemInstall(context, installation).mo3671k(new C4082q(this, installation));
        C4077l lVar = new C4077l(this, context, installation, shouldSetPackageInstaller);
        $jacocoInit[28] = true;
        C0120S k2 = k.mo3671k(lVar);
        C4091z zVar = new C4091z(this, installation);
        $jacocoInit[29] = true;
        C0120S a = k2.mo3621a((C0129b<? super Throwable>) zVar);
        C4087v vVar = C4087v.f7621a;
        $jacocoInit[30] = true;
        C0120S<Installation> b = a.mo3636b((C0129b<? super T>) vVar);
        $jacocoInit[31] = true;
        return b;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo15108b(Installation installation, Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S rootInstall = rootInstall(installation);
        $jacocoInit[177] = true;
        return rootInstall;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15099a(Context context, Installation installation, boolean shouldSetPackageInstaller, Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S defaultInstall = defaultInstall(context, installation, shouldSetPackageInstaller);
        $jacocoInit[176] = true;
        return defaultInstall;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15109c(Installation installation, Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        String packageName = installation.getPackageName();
        $jacocoInit[171] = true;
        int versionCode = installation.getVersionCode();
        StringBuilder sb = new StringBuilder();
        sb.append("Installation with root failed for ");
        $jacocoInit[172] = true;
        sb.append(installation.getPackageName());
        sb.append(". Error message: ");
        $jacocoInit[173] = true;
        sb.append(throwable.getMessage());
        InstallationException installationException = new InstallationException(sb.toString());
        $jacocoInit[174] = true;
        sendErrorEvent(packageName, versionCode, installationException);
        $jacocoInit[175] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m8591c(Installation installation1) {
        boolean[] $jacocoInit = $jacocoInit();
        installation1.save();
        $jacocoInit[170] = true;
    }

    private C0120S<Installation> rootInstall(Installation installation) {
        boolean[] $jacocoInit = $jacocoInit();
        if (ManagerPreferences.allowRootInstallation(this.sharedPreferences)) {
            $jacocoInit[32] = true;
            String id = installation.getId();
            $jacocoInit[33] = true;
            int hashCode = id.hashCode();
            StringBuilder sb = new StringBuilder();
            sb.append(ROOT_INSTALL_COMMAND);
            File file = installation.getFile();
            $jacocoInit[34] = true;
            sb.append(file.getAbsolutePath());
            RootCommandOnSubscribe rootCommandOnSubscribe = new RootCommandOnSubscribe(hashCode, sb.toString(), this.installerAnalytics);
            $jacocoInit[35] = true;
            C0120S a = C0120S.m634a((C0122a<T>) rootCommandOnSubscribe);
            $jacocoInit[36] = true;
            C0120S b = a.mo3634b(Schedulers.computation());
            C4076k kVar = new C4076k(installation);
            $jacocoInit[37] = true;
            C0120S j = b.mo3669j(kVar);
            $jacocoInit[38] = true;
            updateInstallation(installation, 1, 3);
            $jacocoInit[39] = true;
            C0120S e = j.mo3656e(installation);
            C4080o oVar = new C4080o(this, installation);
            $jacocoInit[40] = true;
            C0120S<Installation> k = e.mo3671k(oVar);
            $jacocoInit[41] = true;
            return k;
        }
        C0120S<Installation> a2 = C0120S.m631a((Throwable) new InstallationException("User doesn't allow root installation"));
        $jacocoInit[42] = true;
        return a2;
    }

    /* renamed from: a */
    static /* synthetic */ Installation m8581a(Installation installation, Void success) {
        $jacocoInit()[169] = true;
        return installation;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15100a(Installation installation, Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof RootCommandTimeoutException) {
            $jacocoInit[164] = true;
            updateInstallation(installation, 1, 5);
            $jacocoInit[165] = true;
            installation.save();
            $jacocoInit[166] = true;
            C0120S c = C0120S.m651c();
            $jacocoInit[167] = true;
            return c;
        }
        C0120S a = C0120S.m631a(throwable);
        $jacocoInit[168] = true;
        return a;
    }

    private void startUninstallIntent(Context context, String packageName, Uri uri) throws InstallationException {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            this.packageManager.getPackageInfo(packageName, 0);
            $jacocoInit[43] = true;
            Intent intent = new Intent("android.intent.action.DELETE", uri);
            $jacocoInit[44] = true;
            intent.setFlags(268435456);
            $jacocoInit[45] = true;
            context.startActivity(intent);
            $jacocoInit[50] = true;
        } catch (NameNotFoundException e) {
            $jacocoInit[46] = true;
            CrashReport instance = CrashReport.getInstance();
            $jacocoInit[47] = true;
            instance.log(e);
            $jacocoInit[48] = true;
            InstallationException installationException = new InstallationException((Throwable) e);
            $jacocoInit[49] = true;
            throw installationException;
        }
    }

    private void moveInstallationFiles(Installation installation) {
        boolean[] $jacocoInit = $jacocoInit();
        List<FileToDownload> files = installation.getFiles();
        $jacocoInit[51] = true;
        int i = 0;
        $jacocoInit[52] = true;
        while (i < files.size()) {
            $jacocoInit[53] = true;
            FileToDownload file = (FileToDownload) files.get(i);
            $jacocoInit[54] = true;
            if (file == null) {
                $jacocoInit[55] = true;
            } else if (file.getFileType() != 1) {
                $jacocoInit[56] = true;
            } else {
                $jacocoInit[57] = true;
                StringBuilder sb = new StringBuilder();
                sb.append(OBB_FOLDER);
                sb.append(installation.getPackageName());
                sb.append("/");
                String newPath = sb.toString();
                $jacocoInit[58] = true;
                this.fileUtils.copyFile(file.getPath(), newPath, file.getFileName());
                $jacocoInit[59] = true;
                FileUtils.removeFile(file.getPath());
                $jacocoInit[60] = true;
                file.setPath(newPath);
                $jacocoInit[61] = true;
            }
            i++;
            $jacocoInit[62] = true;
        }
        installation.saveFileChanges();
        $jacocoInit[63] = true;
    }

    private C0120S<Installation> systemInstall(Context context, Installation installation) {
        boolean[] $jacocoInit = $jacocoInit();
        PackageManager packageManager2 = this.packageManager;
        $jacocoInit[64] = true;
        SystemInstallOnSubscribe systemInstallOnSubscribe = new SystemInstallOnSubscribe(context, packageManager2, Uri.fromFile(installation.getFile()));
        $jacocoInit[65] = true;
        C0120S a = C0120S.m634a((C0122a<T>) systemInstallOnSubscribe);
        $jacocoInit[66] = true;
        C0120S b = a.mo3634b(Schedulers.computation());
        C4070e eVar = new C4070e(installation);
        $jacocoInit[67] = true;
        C0120S j = b.mo3669j(eVar);
        $jacocoInit[68] = true;
        updateInstallation(installation, 2, 3);
        $jacocoInit[69] = true;
        C0120S<Installation> e = j.mo3656e(installation);
        $jacocoInit[70] = true;
        return e;
    }

    /* renamed from: b */
    static /* synthetic */ Installation m8587b(Installation installation, Void success) {
        $jacocoInit()[163] = true;
        return installation;
    }

    private Installation updateInstallation(Installation installation, int type, int status) {
        boolean[] $jacocoInit = $jacocoInit();
        installation.setType(type);
        $jacocoInit[71] = true;
        installation.setStatus(status);
        $jacocoInit[72] = true;
        return installation;
    }

    private C0120S<Installation> defaultInstall(Context context, Installation installation, boolean shouldSetPackageInstaller) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        IntentFilter intentFilter = new IntentFilter();
        $jacocoInit[73] = true;
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        $jacocoInit[74] = true;
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        $jacocoInit[75] = true;
        intentFilter.addDataScheme(Constants.PACKAGE);
        $jacocoInit[76] = true;
        C0120S a = C0120S.m633a((Callable<? extends T>) new C4089x<Object>(this, shouldSetPackageInstaller, installation, context));
        $jacocoInit[77] = true;
        C0120S b = a.mo3634b(Schedulers.computation());
        C4069d dVar = new C4069d(this, context, intentFilter, installation, shouldSetPackageInstaller);
        $jacocoInit[78] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) dVar);
        C4090y yVar = new C4090y(installation);
        $jacocoInit[79] = true;
        C0120S j = f.mo3669j(yVar);
        if (shouldSetPackageInstaller) {
            $jacocoInit[80] = true;
            i = 3;
        } else {
            i = 0;
            $jacocoInit[81] = true;
        }
        $jacocoInit[82] = true;
        updateInstallation(installation, i, 3);
        C0120S<Installation> e = j.mo3656e(installation);
        $jacocoInit[83] = true;
        return e;
    }

    /* renamed from: a */
    public /* synthetic */ Void mo15095a(boolean shouldSetPackageInstaller, Installation installation, Context context) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        if (shouldSetPackageInstaller) {
            $jacocoInit[159] = true;
            this.appInstaller.install(installation.getFile(), installation.getPackageName());
            $jacocoInit[160] = true;
        } else {
            startInstallIntent(context, installation.getFile());
            $jacocoInit[161] = true;
        }
        $jacocoInit[162] = true;
        return null;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15097a(Context context, IntentFilter intentFilter, Installation installation, boolean shouldSetPackageInstaller, Void isInstallerInstallation) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[114] = true;
        C0120S waitPackageIntent = waitPackageIntent(context, intentFilter, installation.getPackageName());
        long j = (long) this.installingStateTimeout;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        C4084s sVar = new C4084s(this, installation, shouldSetPackageInstaller);
        $jacocoInit[115] = true;
        C0120S a = C0120S.m633a((Callable<? extends T>) sVar);
        $jacocoInit[116] = true;
        C0120S a2 = waitPackageIntent.mo3608a(j, timeUnit, a);
        AppInstallerStatusReceiver appInstallerStatusReceiver2 = this.appInstallerStatusReceiver;
        $jacocoInit[117] = true;
        C0120S installerInstallStatus = appInstallerStatusReceiver2.getInstallerInstallStatus();
        C4073h hVar = new C4073h(this, installation);
        $jacocoInit[118] = true;
        C0120S b = installerInstallStatus.mo3636b((C0129b<? super T>) hVar);
        C4088w wVar = new C4088w(installation);
        $jacocoInit[119] = true;
        C0120S d = b.mo3653d((C0132p<? super T, Boolean>) wVar);
        $jacocoInit[120] = true;
        C0120S b2 = d.mo3628b();
        C4067b bVar = new C4067b(this, installation, shouldSetPackageInstaller, context);
        $jacocoInit[121] = true;
        C0120S b3 = b2.mo3636b((C0129b<? super T>) bVar);
        $jacocoInit[122] = true;
        C0120S b4 = C0120S.m649b(a2, b3);
        $jacocoInit[123] = true;
        return b4;
    }

    /* renamed from: a */
    public /* synthetic */ Void mo15094a(Installation installation, boolean shouldSetPackageInstaller) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        int i = 3;
        if (installation.getStatus() != 3) {
            $jacocoInit[153] = true;
        } else {
            $jacocoInit[154] = true;
            if (shouldSetPackageInstaller) {
                $jacocoInit[155] = true;
            } else {
                i = 0;
                $jacocoInit[156] = true;
            }
            updateInstallation(installation, i, 1);
            $jacocoInit[157] = true;
        }
        $jacocoInit[158] = true;
        return null;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15105a(Installation installation, InstallStatus installStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!Status.CANCELED.equals(installStatus.getStatus())) {
            $jacocoInit[147] = true;
        } else {
            $jacocoInit[148] = true;
            InstallerAnalytics installerAnalytics2 = this.installerAnalytics;
            String packageName = installation.getPackageName();
            $jacocoInit[149] = true;
            int versionCode = installation.getVersionCode();
            $jacocoInit[150] = true;
            installerAnalytics2.logInstallCancelEvent(packageName, versionCode);
            $jacocoInit[151] = true;
        }
        $jacocoInit[152] = true;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m8588b(Installation installation, InstallStatus installStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        String packageName = installation.getPackageName();
        $jacocoInit[144] = true;
        boolean equalsIgnoreCase = packageName.equalsIgnoreCase(installStatus.getPackageName());
        $jacocoInit[145] = true;
        Boolean valueOf = Boolean.valueOf(equalsIgnoreCase);
        $jacocoInit[146] = true;
        return valueOf;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15106a(Installation installation, boolean shouldSetPackageInstaller, Context context, InstallStatus installStatus) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("status: ");
        $jacocoInit[124] = true;
        Status status = installStatus.getStatus();
        $jacocoInit[125] = true;
        sb.append(status.name());
        sb.append(" ");
        sb.append(installation.getPackageName());
        String sb2 = sb.toString();
        $jacocoInit[126] = true;
        instance.mo2136d("Installer", sb2);
        if (shouldSetPackageInstaller) {
            i = 3;
            $jacocoInit[127] = true;
        } else {
            i = 0;
            $jacocoInit[128] = true;
        }
        $jacocoInit[129] = true;
        int map = map(installStatus);
        $jacocoInit[130] = true;
        updateInstallation(installation, i, map);
        $jacocoInit[131] = true;
        Status status2 = installStatus.getStatus();
        Status status3 = Status.FAIL;
        $jacocoInit[132] = true;
        if (!status2.equals(status3)) {
            $jacocoInit[133] = true;
        } else if (!isDeviceMIUI()) {
            $jacocoInit[134] = true;
        } else {
            $jacocoInit[135] = true;
            this.installerAnalytics.sendMiuiInstallResultEvent(Status.FAIL);
            $jacocoInit[136] = true;
            startInstallIntent(context, installation.getFile());
            $jacocoInit[137] = true;
            $jacocoInit[143] = true;
        }
        Status status4 = installStatus.getStatus();
        Status status5 = Status.SUCCESS;
        $jacocoInit[138] = true;
        if (!status4.equals(status5)) {
            $jacocoInit[139] = true;
        } else if (!isDeviceMIUI()) {
            $jacocoInit[140] = true;
        } else {
            $jacocoInit[141] = true;
            this.installerAnalytics.sendMiuiInstallResultEvent(Status.SUCCESS);
            $jacocoInit[142] = true;
        }
        $jacocoInit[143] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Installation m8580a(Installation installation, Object success) {
        $jacocoInit()[113] = true;
        return installation;
    }

    private boolean isDeviceMIUI() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean isDeviceMIUI = AptoideUtils.isDeviceMIUI();
        $jacocoInit[84] = true;
        return isDeviceMIUI;
    }

    private int map(InstallStatus installStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = C40581.$SwitchMap$cm$aptoide$pt$packageinstaller$InstallStatus$Status[installStatus.getStatus().ordinal()];
        if (i == 1) {
            $jacocoInit[85] = true;
            return 3;
        } else if (i != 2) {
            $jacocoInit[87] = true;
            return 1;
        } else {
            $jacocoInit[86] = true;
            return 4;
        }
    }

    private void sendErrorEvent(String packageName, int versionCode, Exception e) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installerAnalytics.logInstallErrorEvent(packageName, versionCode, e);
        $jacocoInit[88] = true;
    }

    private void startInstallIntent(Context context, File file) {
        Uri photoURI;
        boolean[] $jacocoInit = $jacocoInit();
        Intent intent = new Intent("android.intent.action.VIEW");
        if (VERSION.SDK_INT > 23) {
            $jacocoInit[89] = true;
            photoURI = FileProvider.m2499a(context, "cm.aptoide.pt.provider", file);
            $jacocoInit[90] = true;
        } else {
            photoURI = Uri.fromFile(file);
            $jacocoInit[91] = true;
        }
        Logger instance = Logger.getInstance();
        String str = TAG;
        $jacocoInit[92] = true;
        instance.mo2146v(str, photoURI.toString());
        $jacocoInit[93] = true;
        intent.setDataAndType(photoURI, "application/vnd.android.package-archive");
        $jacocoInit[94] = true;
        intent.setFlags(268435459);
        $jacocoInit[95] = true;
        context.startActivity(intent);
        $jacocoInit[96] = true;
    }

    private C0120S<Void> waitPackageIntent(Context context, IntentFilter intentFilter, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m634a((C0122a<T>) new BroadcastRegisterOnSubscribe<T>(context, intentFilter, null, null));
        C4056C c = new C4056C(packageName);
        $jacocoInit[97] = true;
        C0120S e = a.mo3658e((C0132p<? super T, Boolean>) c);
        C4068c cVar = C4068c.f7578a;
        $jacocoInit[98] = true;
        C0120S<Void> j = e.mo3669j(cVar);
        $jacocoInit[99] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8583a(String packageName, Intent intent) {
        boolean[] $jacocoInit = $jacocoInit();
        Uri data = intent.getData();
        $jacocoInit[109] = true;
        String uri = data.toString();
        $jacocoInit[110] = true;
        boolean contains = uri.contains(packageName);
        $jacocoInit[111] = true;
        Boolean valueOf = Boolean.valueOf(contains);
        $jacocoInit[112] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ Void m8584a(Intent intent) {
        $jacocoInit()[108] = true;
        return null;
    }

    private boolean isInstalled(String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = false;
        try {
            PackageInfo info = this.packageManager.getPackageInfo(packageName, 0);
            if (info == null) {
                $jacocoInit[100] = true;
            } else if (info.versionCode != versionCode) {
                $jacocoInit[101] = true;
            } else {
                $jacocoInit[102] = true;
                z = true;
                $jacocoInit[104] = true;
                return z;
            }
            $jacocoInit[103] = true;
            $jacocoInit[104] = true;
            return z;
        } catch (NameNotFoundException e) {
            $jacocoInit[105] = true;
            CrashReport instance = CrashReport.getInstance();
            $jacocoInit[106] = true;
            instance.log(e);
            $jacocoInit[107] = true;
            return false;
        }
    }
}
