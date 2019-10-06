package p005cm.aptoide.p006pt.autoupdate;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.actions.PermissionManager;
import p005cm.aptoide.p006pt.actions.PermissionService;
import p005cm.aptoide.p006pt.download.DownloadAnalytics;
import p005cm.aptoide.p006pt.download.DownloadFactory;
import p005cm.aptoide.p006pt.install.Install;
import p005cm.aptoide.p006pt.install.InstallManager;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.autoupdate.AutoUpdateManager */
/* compiled from: AutoUpdateManager.kt */
public class AutoUpdateManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AutoUpdateRepository autoUpdateRepository;
    private final DownloadAnalytics downloadAnalytics;
    private final DownloadFactory downloadFactory;
    private final InstallManager installManager;
    private final int localVersionCode;
    private final int localVersionSdk;
    private final PermissionManager permissionManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(31220074211281878L, "cm/aptoide/pt/autoupdate/AutoUpdateManager", 24);
        $jacocoData = probes;
        return probes;
    }

    public AutoUpdateManager(DownloadFactory downloadFactory2, PermissionManager permissionManager2, InstallManager installManager2, DownloadAnalytics downloadAnalytics2, int localVersionCode2, AutoUpdateRepository autoUpdateRepository2, int localVersionSdk2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(downloadFactory2, "downloadFactory");
        C14281f.m45916b(permissionManager2, "permissionManager");
        C14281f.m45916b(installManager2, "installManager");
        C14281f.m45916b(downloadAnalytics2, "downloadAnalytics");
        C14281f.m45916b(autoUpdateRepository2, "autoUpdateRepository");
        $jacocoInit[16] = true;
        this.downloadFactory = downloadFactory2;
        this.permissionManager = permissionManager2;
        this.installManager = installManager2;
        this.downloadAnalytics = downloadAnalytics2;
        this.localVersionCode = localVersionCode2;
        this.autoUpdateRepository = autoUpdateRepository2;
        this.localVersionSdk = localVersionSdk2;
        $jacocoInit[17] = true;
    }

    public static final /* synthetic */ DownloadAnalytics access$getDownloadAnalytics$p(AutoUpdateManager $this) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadAnalytics downloadAnalytics2 = $this.downloadAnalytics;
        $jacocoInit[21] = true;
        return downloadAnalytics2;
    }

    public static final /* synthetic */ DownloadFactory access$getDownloadFactory$p(AutoUpdateManager $this) {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadFactory downloadFactory2 = $this.downloadFactory;
        $jacocoInit[19] = true;
        return downloadFactory2;
    }

    public static final /* synthetic */ C0120S access$getInstall(AutoUpdateManager $this) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S install = $this.getInstall();
        $jacocoInit[22] = true;
        return install;
    }

    public static final /* synthetic */ InstallManager access$getInstallManager$p(AutoUpdateManager $this) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallManager installManager2 = $this.installManager;
        $jacocoInit[20] = true;
        return installManager2;
    }

    public static final /* synthetic */ PermissionManager access$getPermissionManager$p(AutoUpdateManager $this) {
        boolean[] $jacocoInit = $jacocoInit();
        PermissionManager permissionManager2 = $this.permissionManager;
        $jacocoInit[18] = true;
        return permissionManager2;
    }

    public static final /* synthetic */ boolean access$shouldUpdate(AutoUpdateManager $this, AutoUpdateModel autoUpdateModel) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean shouldUpdate = $this.shouldUpdate(autoUpdateModel);
        $jacocoInit[23] = true;
        return shouldUpdate;
    }

    public final C0120S<Boolean> shouldUpdate() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> j = loadAutoUpdateModel().mo3696c().mo3669j(AutoUpdateManager$shouldUpdate$1.INSTANCE);
        C14281f.m45913a((Object) j, "loadAutoUpdateModel().to…).map { it.shouldUpdate }");
        $jacocoInit[0] = true;
        return j;
    }

    public final C0120S<Void> requestPermissions(PermissionService permissionService) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(permissionService, "permissionService");
        $jacocoInit[1] = true;
        C0120S requestDownloadAccess = this.permissionManager.requestDownloadAccess(permissionService);
        $jacocoInit[2] = true;
        C0120S<Void> f = requestDownloadAccess.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new AutoUpdateManager$requestPermissions$1<Object,Object>(this, permissionService));
        C14281f.m45913a((Object) f, "permissionManager.reques…sion(permissionService) }");
        $jacocoInit[3] = true;
        return f;
    }

    public final C0120S<Install> startUpdate() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Install> f = getAutoUpdateModel().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new AutoUpdateManager$startUpdate$1<Object,Object>(this));
        C14281f.m45913a((Object) f, "getAutoUpdateModel().fla…dThen(getInstall())\n    }");
        $jacocoInit[4] = true;
        return f;
    }

    private final Single<AutoUpdateModel> loadAutoUpdateModel() {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadFreshAutoUpdateModel = this.autoUpdateRepository.loadFreshAutoUpdateModel();
        $jacocoInit[5] = true;
        Single<AutoUpdateModel> a = loadFreshAutoUpdateModel.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) new AutoUpdateManager$loadAutoUpdateModel$1<Object,Object>(this));
        C14281f.m45913a((Object) a, "autoUpdateRepository.loa…utoUpdateModel)\n        }");
        $jacocoInit[6] = true;
        return a;
    }

    private final C0120S<AutoUpdateModel> getAutoUpdateModel() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<AutoUpdateModel> c = this.autoUpdateRepository.loadAutoUpdateModel().mo3696c();
        C14281f.m45913a((Object) c, "autoUpdateRepository.loa…ateModel().toObservable()");
        $jacocoInit[7] = true;
        return c;
    }

    private final C0120S<Install> getInstall() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Install> f = getAutoUpdateModel().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new AutoUpdateManager$getInstall$1<Object,Object>(this));
        C14281f.m45913a((Object) f, "getAutoUpdateModel().fla…DownloadStarted() }\n    }");
        $jacocoInit[8] = true;
        return f;
    }

    private final boolean shouldUpdate(AutoUpdateModel autoUpdateModel) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (autoUpdateModel.getVersionCode() <= this.localVersionCode) {
            $jacocoInit[9] = true;
        } else {
            int i = this.localVersionSdk;
            $jacocoInit[10] = true;
            String minSdk = autoUpdateModel.getMinSdk();
            $jacocoInit[11] = true;
            if (i < Integer.parseInt(minSdk)) {
                $jacocoInit[12] = true;
            } else {
                $jacocoInit[13] = true;
                z = true;
                $jacocoInit[15] = true;
                return z;
            }
        }
        z = false;
        $jacocoInit[14] = true;
        $jacocoInit[15] = true;
        return z;
    }
}
