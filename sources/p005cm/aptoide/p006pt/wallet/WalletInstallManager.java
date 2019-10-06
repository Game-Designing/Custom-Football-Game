package p005cm.aptoide.p006pt.wallet;

import android.content.pm.PackageManager;
import java.util.concurrent.Callable;
import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.MoPubAdsManager;
import p005cm.aptoide.p006pt.ads.WalletAdsOfferManager.OfferResponseStatus;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.install.AppInstallerStatusReceiver;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallManager */
/* compiled from: WalletInstallManager.kt */
public final class WalletInstallManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AppInstallerStatusReceiver appInstallerStatusReceiver;
    private final WalletInstallConfiguration configuration;
    private final DownloadFactory downloadFactory;
    private final DownloadStateParser downloadStateParser;
    private final InstallManager installManager;
    private final InstalledRepository installedRepository;
    private final MoPubAdsManager moPubAdsManager;
    private final PackageManager packageManager;
    private final WalletAppProvider walletAppProvider;
    private final WalletInstallAnalytics walletInstallAnalytics;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7761698458149300057L, "cm/aptoide/pt/wallet/WalletInstallManager", 42);
        $jacocoData = probes;
        return probes;
    }

    public WalletInstallManager(WalletInstallConfiguration configuration2, PackageManager packageManager2, InstallManager installManager2, DownloadFactory downloadFactory2, DownloadStateParser downloadStateParser2, MoPubAdsManager moPubAdsManager2, WalletInstallAnalytics walletInstallAnalytics2, InstalledRepository installedRepository2, WalletAppProvider walletAppProvider2, AppInstallerStatusReceiver appInstallerStatusReceiver2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(configuration2, "configuration");
        C14281f.m45916b(packageManager2, "packageManager");
        C14281f.m45916b(installManager2, "installManager");
        C14281f.m45916b(downloadFactory2, "downloadFactory");
        C14281f.m45916b(downloadStateParser2, "downloadStateParser");
        C14281f.m45916b(moPubAdsManager2, "moPubAdsManager");
        C14281f.m45916b(walletInstallAnalytics2, "walletInstallAnalytics");
        C14281f.m45916b(installedRepository2, "installedRepository");
        C14281f.m45916b(walletAppProvider2, "walletAppProvider");
        C14281f.m45916b(appInstallerStatusReceiver2, "appInstallerStatusReceiver");
        $jacocoInit[39] = true;
        this.configuration = configuration2;
        this.packageManager = packageManager2;
        this.installManager = installManager2;
        this.downloadFactory = downloadFactory2;
        this.downloadStateParser = downloadStateParser2;
        this.moPubAdsManager = moPubAdsManager2;
        this.walletInstallAnalytics = walletInstallAnalytics2;
        this.installedRepository = installedRepository2;
        this.walletAppProvider = walletAppProvider2;
        this.appInstallerStatusReceiver = appInstallerStatusReceiver2;
        $jacocoInit[40] = true;
    }

    public static final /* synthetic */ void access$setupDownloadEvents(WalletInstallManager $this, Download download, Action downloadAction, long appId, OfferResponseStatus offerResponseStatus, String packageName, String developer) {
        boolean[] $jacocoInit = $jacocoInit();
        $this.setupDownloadEvents(download, downloadAction, appId, offerResponseStatus, packageName, developer);
        $jacocoInit[41] = true;
    }

    public final WalletInstallConfiguration getConfiguration() {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallConfiguration walletInstallConfiguration = this.configuration;
        $jacocoInit[29] = true;
        return walletInstallConfiguration;
    }

    public final InstallManager getInstallManager() {
        boolean[] $jacocoInit = $jacocoInit();
        InstallManager installManager2 = this.installManager;
        $jacocoInit[31] = true;
        return installManager2;
    }

    public final PackageManager getPackageManager() {
        boolean[] $jacocoInit = $jacocoInit();
        PackageManager packageManager2 = this.packageManager;
        $jacocoInit[30] = true;
        return packageManager2;
    }

    public final DownloadFactory getDownloadFactory() {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadFactory downloadFactory2 = this.downloadFactory;
        $jacocoInit[32] = true;
        return downloadFactory2;
    }

    public final DownloadStateParser getDownloadStateParser() {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadStateParser downloadStateParser2 = this.downloadStateParser;
        $jacocoInit[33] = true;
        return downloadStateParser2;
    }

    public final MoPubAdsManager getMoPubAdsManager() {
        boolean[] $jacocoInit = $jacocoInit();
        MoPubAdsManager moPubAdsManager2 = this.moPubAdsManager;
        $jacocoInit[34] = true;
        return moPubAdsManager2;
    }

    public final WalletInstallAnalytics getWalletInstallAnalytics() {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallAnalytics walletInstallAnalytics2 = this.walletInstallAnalytics;
        $jacocoInit[35] = true;
        return walletInstallAnalytics2;
    }

    public final InstalledRepository getInstalledRepository() {
        boolean[] $jacocoInit = $jacocoInit();
        InstalledRepository installedRepository2 = this.installedRepository;
        $jacocoInit[36] = true;
        return installedRepository2;
    }

    public final WalletAppProvider getWalletAppProvider() {
        boolean[] $jacocoInit = $jacocoInit();
        WalletAppProvider walletAppProvider2 = this.walletAppProvider;
        $jacocoInit[37] = true;
        return walletAppProvider2;
    }

    public final AppInstallerStatusReceiver getAppInstallerStatusReceiver() {
        boolean[] $jacocoInit = $jacocoInit();
        AppInstallerStatusReceiver appInstallerStatusReceiver2 = this.appInstallerStatusReceiver;
        $jacocoInit[38] = true;
        return appInstallerStatusReceiver2;
    }

    public final C0120S<String> getAppIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m633a((Callable<? extends T>) new WalletInstallManager$getAppIcon$1<Object>(this));
        $jacocoInit[0] = true;
        C0120S<String> l = a.mo3674l(WalletInstallManager$getAppIcon$2.INSTANCE);
        C14281f.m45913a((Object) l, "Observable.fromCallable … }.onErrorReturn { null }");
        $jacocoInit[1] = true;
        return l;
    }

    public final boolean shouldShowRootInstallWarningPopup() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean showWarning = this.installManager.showWarning();
        $jacocoInit[2] = true;
        return showWarning;
    }

    public final void allowRootInstall(boolean answer) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installManager.rootInstallAllowed(answer);
        $jacocoInit[3] = true;
    }

    public final C0117M downloadApp(WalletApp walletApp) {
        WalletApp walletApp2 = walletApp;
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(walletApp2, "walletApp");
        DownloadFactory downloadFactory2 = this.downloadFactory;
        $jacocoInit[4] = true;
        int parseDownloadAction = this.downloadStateParser.parseDownloadAction(Action.INSTALL);
        $jacocoInit[5] = true;
        String appName = walletApp.getAppName();
        $jacocoInit[6] = true;
        String packageName = walletApp.getPackageName();
        $jacocoInit[7] = true;
        String md5sum = walletApp.getMd5sum();
        String icon = walletApp.getIcon();
        String versionName = walletApp.getVersionName();
        int versionCode = walletApp.getVersionCode();
        $jacocoInit[8] = true;
        String path = walletApp.getPath();
        String pathAlt = walletApp.getPathAlt();
        Obb obb = walletApp.getObb();
        $jacocoInit[9] = true;
        long size = walletApp.getSize();
        $jacocoInit[10] = true;
        Download create = downloadFactory2.create(parseDownloadAction, appName, packageName, md5sum, icon, versionName, versionCode, path, pathAlt, obb, false, size);
        $jacocoInit[11] = true;
        C0120S c = C0120S.m652c(create);
        $jacocoInit[12] = true;
        C0120S i = c.mo3668i(new WalletInstallManager$downloadApp$1(this, walletApp2));
        $jacocoInit[13] = true;
        C0120S g = i.mo3663g((C0132p<? super T, ? extends C0117M>) new WalletInstallManager$downloadApp$2<Object,Object>(this));
        $jacocoInit[14] = true;
        C0117M l = g.mo3673l();
        C14281f.m45913a((Object) l, "Observable.just(\n       …\n        .toCompletable()");
        $jacocoInit[15] = true;
        return l;
    }

    private final void setupDownloadEvents(Download download, Action downloadAction, long appId, OfferResponseStatus offerResponseStatus, String packageName, String developer) {
        boolean[] $jacocoInit = $jacocoInit();
        this.walletInstallAnalytics.setupDownloadEvents(download, downloadAction, appId, offerResponseStatus);
        $jacocoInit[16] = true;
        this.walletInstallAnalytics.sendClickOnInstallButtonEvent(packageName, developer);
        $jacocoInit[17] = true;
    }

    public final C0120S<Boolean> onWalletInstalled() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> d = this.installedRepository.isInstalled("com.appcoins.wallet").mo3653d((C0132p<? super T, Boolean>) WalletInstallManager$onWalletInstalled$1.INSTANCE);
        C14281f.m45913a((Object) d, "installedRepository.isIn…>\n      isInstalled\n    }");
        $jacocoInit[18] = true;
        return d;
    }

    public final C0120S<WalletApp> getWallet() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<WalletApp> walletApp = this.walletAppProvider.getWalletApp();
        $jacocoInit[19] = true;
        return walletApp;
    }

    public final void removeDownload(WalletApp app) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(app, "app");
        $jacocoInit[20] = true;
        this.installManager.removeInstallationFile(app.getMd5sum(), app.getPackageName(), app.getVersionCode());
        $jacocoInit[21] = true;
    }

    public final C0120S<DownloadModel> loadDownloadModel(WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(walletApp, "walletApp");
        $jacocoInit[22] = true;
        C0120S install = this.installManager.getInstall(walletApp.getMd5sum(), walletApp.getPackageName(), walletApp.getVersionCode());
        $jacocoInit[23] = true;
        C0120S<DownloadModel> j = install.mo3669j(new WalletInstallManager$loadDownloadModel$1(this));
        C14281f.m45913a((Object) j, "installManager.getInstal…l.state), null)\n        }");
        $jacocoInit[24] = true;
        return j;
    }

    public final C0120S<Boolean> onWalletInstallationCanceled() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installerInstallStatus = this.appInstallerStatusReceiver.getInstallerInstallStatus();
        $jacocoInit[25] = true;
        C0120S j = installerInstallStatus.mo3669j(WalletInstallManager$onWalletInstallationCanceled$1.INSTANCE);
        $jacocoInit[26] = true;
        C0120S<Boolean> d = j.mo3653d((C0132p<? super T, Boolean>) WalletInstallManager$onWalletInstallationCanceled$2.INSTANCE);
        C14281f.m45913a((Object) d, "appInstallerStatusReceiv…sCanceled -> isCanceled }");
        $jacocoInit[27] = true;
        return d;
    }

    public final void setupAnalyticsHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        this.walletInstallAnalytics.setupHistoryTracker();
        $jacocoInit[28] = true;
    }
}
