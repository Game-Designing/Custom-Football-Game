package p005cm.aptoide.p006pt.install;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.ads.MinimalAdMapper;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.DownloadAccessor;
import p005cm.aptoide.p006pt.database.accessors.StoredMinimalAdAccessor;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.StoredMinimalAd;
import p005cm.aptoide.p006pt.download.DownloadInstallationProvider;
import p005cm.aptoide.p006pt.downloadmanager.AptoideDownloadManager;
import p005cm.aptoide.p006pt.install.installer.DefaultInstaller;
import p005cm.aptoide.p006pt.packageinstaller.AppInstaller;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p005cm.aptoide.p006pt.repository.RepositoryFactory;
import p005cm.aptoide.p006pt.root.RootAvailabilityManager;
import p005cm.aptoide.p006pt.utils.FileUtils;

/* renamed from: cm.aptoide.pt.install.InstallerFactory */
public class InstallerFactory {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static final int DEFAULT = 0;
    private final MinimalAdMapper adMapper;
    private final AppInstaller appInstaller;
    private final AppInstallerStatusReceiver appInstallerStatusReceiver;
    private final InstallerAnalytics installerAnalytics;
    private final int installingStateTimeout;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7421494353130043532L, "cm/aptoide/pt/install/InstallerFactory", 22);
        $jacocoData = probes;
        return probes;
    }

    public InstallerFactory(MinimalAdMapper adMapper2, InstallerAnalytics installerAnalytics2, AppInstaller appInstaller2, int installingStateTimeout2, AppInstallerStatusReceiver appInstallerStatusReceiver2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adMapper = adMapper2;
        this.installerAnalytics = installerAnalytics2;
        this.appInstaller = appInstaller2;
        this.installingStateTimeout = installingStateTimeout2;
        this.appInstallerStatusReceiver = appInstallerStatusReceiver2;
        $jacocoInit[0] = true;
    }

    public Installer create(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        DefaultInstaller defaultInstaller = getDefaultInstaller(context);
        $jacocoInit[1] = true;
        return defaultInstaller;
    }

    private DefaultInstaller getDefaultInstaller(Context context) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        PackageManager packageManager = context.getPackageManager();
        $jacocoInit[2] = true;
        AptoideDownloadManager downloadManager = ((AptoideApplication) context.getApplicationContext()).getDownloadManager();
        $jacocoInit[3] = true;
        Context applicationContext = context.getApplicationContext();
        $jacocoInit[4] = true;
        DownloadInstallationProvider installationProvider = getInstallationProvider(downloadManager, applicationContext);
        AppInstaller appInstaller2 = this.appInstaller;
        FileUtils fileUtils = new FileUtils();
        $jacocoInit[5] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) context.getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[6] = true;
        if (ToolboxManager.isDebug(defaultSharedPreferences)) {
            $jacocoInit[7] = true;
        } else if (BuildConfig.DEBUG) {
            $jacocoInit[8] = true;
        } else {
            $jacocoInit[10] = true;
            z = false;
            $jacocoInit[11] = true;
            InstalledRepository installedRepository = RepositoryFactory.getInstalledRepository(context.getApplicationContext());
            $jacocoInit[12] = true;
            RootAvailabilityManager rootAvailabilityManager = ((AptoideApplication) context.getApplicationContext()).getRootAvailabilityManager();
            $jacocoInit[13] = true;
            DefaultInstaller defaultInstaller = new DefaultInstaller(packageManager, installationProvider, appInstaller2, fileUtils, z, installedRepository, BuildConfig.ROOT_TIMEOUT, rootAvailabilityManager, ((AptoideApplication) context.getApplicationContext()).getDefaultSharedPreferences(), this.installerAnalytics, this.installingStateTimeout, this.appInstallerStatusReceiver);
            $jacocoInit[14] = true;
            return defaultInstaller;
        }
        $jacocoInit[9] = true;
        z = true;
        $jacocoInit[11] = true;
        InstalledRepository installedRepository2 = RepositoryFactory.getInstalledRepository(context.getApplicationContext());
        $jacocoInit[12] = true;
        RootAvailabilityManager rootAvailabilityManager2 = ((AptoideApplication) context.getApplicationContext()).getRootAvailabilityManager();
        $jacocoInit[13] = true;
        DefaultInstaller defaultInstaller2 = new DefaultInstaller(packageManager, installationProvider, appInstaller2, fileUtils, z, installedRepository2, BuildConfig.ROOT_TIMEOUT, rootAvailabilityManager2, ((AptoideApplication) context.getApplicationContext()).getDefaultSharedPreferences(), this.installerAnalytics, this.installingStateTimeout, this.appInstallerStatusReceiver);
        $jacocoInit[14] = true;
        return defaultInstaller2;
    }

    private DownloadInstallationProvider getInstallationProvider(AptoideDownloadManager downloadManager, Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[15] = true;
        $jacocoInit[16] = true;
        DownloadAccessor downloadAccessor = (DownloadAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) context.getApplicationContext()).getDatabase(), Download.class);
        $jacocoInit[17] = true;
        InstalledRepository installedRepository = RepositoryFactory.getInstalledRepository(context);
        MinimalAdMapper minimalAdMapper = this.adMapper;
        $jacocoInit[18] = true;
        Context applicationContext = context.getApplicationContext();
        $jacocoInit[19] = true;
        $jacocoInit[20] = true;
        DownloadInstallationProvider downloadInstallationProvider = new DownloadInstallationProvider(downloadManager, downloadAccessor, installedRepository, minimalAdMapper, (StoredMinimalAdAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), StoredMinimalAd.class));
        $jacocoInit[21] = true;
        return downloadInstallationProvider;
    }
}
