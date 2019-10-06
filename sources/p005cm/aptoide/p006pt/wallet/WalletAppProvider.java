package p005cm.aptoide.p006pt.wallet;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.app.DownloadModel.DownloadState;
import p005cm.aptoide.p006pt.app.DownloadStateParser;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.install.Install;
import p005cm.aptoide.p006pt.install.Install.InstallationStatus;
import p005cm.aptoide.p006pt.install.Install.InstallationType;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p005cm.aptoide.p006pt.view.app.AppCenter;
import p005cm.aptoide.p006pt.view.app.AppDeveloper;
import p005cm.aptoide.p006pt.view.app.DetailedApp;
import p005cm.aptoide.p006pt.view.app.DetailedAppRequestResult;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.wallet.WalletAppProvider */
/* compiled from: WalletAppProvider.kt */
public final class WalletAppProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AppCenter appCenter;
    private final DownloadStateParser downloadStateParser;
    private final InstallManager installManager;
    private final InstalledRepository installedRepository;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-642001476231975791L, "cm/aptoide/pt/wallet/WalletAppProvider", 27);
        $jacocoData = probes;
        return probes;
    }

    public WalletAppProvider(AppCenter appCenter2, InstalledRepository installedRepository2, InstallManager installManager2, DownloadStateParser downloadStateParser2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(appCenter2, "appCenter");
        C14281f.m45916b(installedRepository2, "installedRepository");
        C14281f.m45916b(installManager2, "installManager");
        C14281f.m45916b(downloadStateParser2, "downloadStateParser");
        $jacocoInit[23] = true;
        this.appCenter = appCenter2;
        this.installedRepository = installedRepository2;
        this.installManager = installManager2;
        this.downloadStateParser = downloadStateParser2;
        $jacocoInit[24] = true;
    }

    public static final /* synthetic */ WalletApp access$mapToWalletApp(WalletAppProvider $this, DetailedAppRequestResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletApp mapToWalletApp = $this.mapToWalletApp(result);
        $jacocoInit[25] = true;
        return mapToWalletApp;
    }

    public static final /* synthetic */ WalletApp access$mergeToWalletApp(WalletAppProvider $this, WalletApp walletApp, boolean isInstalled, Install walletDownload) {
        boolean[] $jacocoInit = $jacocoInit();
        $this.mergeToWalletApp(walletApp, isInstalled, walletDownload);
        $jacocoInit[26] = true;
        return walletApp;
    }

    public final AppCenter getAppCenter() {
        boolean[] $jacocoInit = $jacocoInit();
        AppCenter appCenter2 = this.appCenter;
        $jacocoInit[19] = true;
        return appCenter2;
    }

    public final InstalledRepository getInstalledRepository() {
        boolean[] $jacocoInit = $jacocoInit();
        InstalledRepository installedRepository2 = this.installedRepository;
        $jacocoInit[20] = true;
        return installedRepository2;
    }

    public final InstallManager getInstallManager() {
        boolean[] $jacocoInit = $jacocoInit();
        InstallManager installManager2 = this.installManager;
        $jacocoInit[21] = true;
        return installManager2;
    }

    public final DownloadStateParser getDownloadStateParser() {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadStateParser downloadStateParser2 = this.downloadStateParser;
        $jacocoInit[22] = true;
        return downloadStateParser2;
    }

    public final C0120S<WalletApp> getWalletApp() {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadDetailedApp = this.appCenter.loadDetailedApp("com.appcoins.wallet", "catappult");
        $jacocoInit[0] = true;
        C0120S c = loadDetailedApp.mo3696c();
        $jacocoInit[1] = true;
        C0120S<WalletApp> f = c.mo3669j(new WalletAppProvider$getWalletApp$1(this)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new WalletAppProvider$getWalletApp$2<Object,Object>(this));
        C14281f.m45913a((Object) f, "appCenter.loadDetailedAp…ad)\n          }\n        }");
        $jacocoInit[2] = true;
        return f;
    }

    private final WalletApp mergeToWalletApp(WalletApp walletApp, boolean isInstalled, Install walletDownload) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallationType type = walletDownload.getType();
        C14281f.m45913a((Object) type, "walletDownload.type");
        int progress = walletDownload.getProgress();
        $jacocoInit[3] = true;
        InstallationStatus state = walletDownload.getState();
        C14281f.m45913a((Object) state, "walletDownload.state");
        $jacocoInit[4] = true;
        DownloadModel downloadModel = mapToDownloadModel(type, progress, state);
        $jacocoInit[5] = true;
        walletApp.setDownloadModel(downloadModel);
        $jacocoInit[6] = true;
        walletApp.setInstalled(isInstalled);
        $jacocoInit[7] = true;
        return walletApp;
    }

    private final DownloadModel mapToDownloadModel(InstallationType type, int progress, InstallationStatus state) {
        boolean[] $jacocoInit = $jacocoInit();
        Action parseDownloadType = this.downloadStateParser.parseDownloadType(type, false, false, false);
        $jacocoInit[8] = true;
        DownloadState parseDownloadState = this.downloadStateParser.parseDownloadState(state);
        $jacocoInit[9] = true;
        DownloadModel downloadModel = new DownloadModel(parseDownloadType, progress, parseDownloadState, null);
        $jacocoInit[10] = true;
        return downloadModel;
    }

    private final WalletApp mapToWalletApp(DetailedAppRequestResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        if (result.hasError()) {
            $jacocoInit[11] = true;
        } else if (result.isLoading()) {
            $jacocoInit[12] = true;
        } else {
            DetailedApp app = result.getDetailedApp();
            $jacocoInit[14] = true;
            C14281f.m45913a((Object) app, "app");
            String name = app.getName();
            String str = name;
            C14281f.m45913a((Object) name, "app.name");
            String icon = app.getIcon();
            String str2 = icon;
            C14281f.m45913a((Object) icon, "app.icon");
            long id = app.getId();
            $jacocoInit[15] = true;
            String packageName = app.getPackageName();
            String str3 = packageName;
            C14281f.m45913a((Object) packageName, "app.packageName");
            String md5 = app.getMd5();
            int versionCode = app.getVersionCode();
            String versionName = app.getVersionName();
            $jacocoInit[16] = true;
            String path = app.getPath();
            String pathAlt = app.getPathAlt();
            Obb obb = app.getObb();
            long size = app.getSize();
            AppDeveloper developer = app.getDeveloper();
            C14281f.m45913a((Object) developer, "app.developer");
            String name2 = developer.getName();
            String str4 = name2;
            C14281f.m45913a((Object) name2, "app.developer.name");
            $jacocoInit[17] = true;
            WalletApp walletApp = new WalletApp(null, false, str, str2, id, str3, md5, versionCode, versionName, path, pathAlt, obb, size, str4);
            $jacocoInit[18] = true;
            return walletApp;
        }
        WalletApp walletApp2 = new WalletApp(null, false, null, null, 0, null, null, 0, null, null, null, null, 0, null, 16383, null);
        $jacocoInit[13] = true;
        return walletApp2;
    }
}
