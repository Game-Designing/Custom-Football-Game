package p005cm.aptoide.p006pt.install;

import android.util.Log;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.install.DownloadsNotificationsPresenter */
public class DownloadsNotificationsPresenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = DownloadsNotificationsPresenter.class.getSimpleName();
    private InstallManager installManager;
    private DownloadsNotification service;
    private C0136c subscriptions = new C0136c();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8752629176338436941L, "cm/aptoide/pt/install/DownloadsNotificationsPresenter", 29);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[28] = true;
    }

    public DownloadsNotificationsPresenter(DownloadsNotification service2, InstallManager installManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.service = service2;
        this.installManager = installManager2;
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
    }

    public void setupSubscriptions() {
        boolean[] $jacocoInit = $jacocoInit();
        handleOpenAppView();
        $jacocoInit[2] = true;
        handleOpenDownloadManager();
        $jacocoInit[3] = true;
        handleCurrentInstallation();
        $jacocoInit[4] = true;
    }

    private void handleOpenAppView() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S handleOpenAppView = this.service.handleOpenAppView();
        C4039e eVar = new C4039e(this);
        $jacocoInit[5] = true;
        C0120S b = handleOpenAppView.mo3636b((C0129b<? super T>) eVar);
        $jacocoInit[6] = true;
        C0137ja j = b.mo3670j();
        $jacocoInit[7] = true;
        cVar.mo3713a(j);
        $jacocoInit[8] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14983a(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        this.service.openAppView(md5);
        $jacocoInit[27] = true;
    }

    private void handleOpenDownloadManager() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S handleOpenDownloadManager = this.service.handleOpenDownloadManager();
        C4036d dVar = new C4036d(this);
        $jacocoInit[9] = true;
        C0120S b = handleOpenDownloadManager.mo3636b((C0129b<? super T>) dVar);
        $jacocoInit[10] = true;
        C0137ja j = b.mo3670j();
        $jacocoInit[11] = true;
        cVar.mo3713a(j);
        $jacocoInit[12] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14985a(Void openDownloadManagerView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.service.openDownloadManager();
        $jacocoInit[26] = true;
    }

    private void handleCurrentInstallation() {
        boolean[] $jacocoInit = $jacocoInit();
        C0136c cVar = this.subscriptions;
        C0120S currentInstallation = this.installManager.getCurrentInstallation();
        C4042f fVar = new C4042f(this);
        C4033c cVar2 = new C4033c(this);
        $jacocoInit[13] = true;
        C0137ja a = currentInstallation.mo3626a((C0129b<? super T>) fVar, (C0129b<Throwable>) cVar2);
        $jacocoInit[14] = true;
        cVar.mo3713a(a);
        $jacocoInit[15] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14982a(Install installation) {
        boolean[] $jacocoInit = $jacocoInit();
        if (installation.isIndeterminate()) {
            $jacocoInit[19] = true;
        } else {
            $jacocoInit[20] = true;
            String md5 = installation.getMd5();
            $jacocoInit[21] = true;
            DownloadsNotification downloadsNotification = this.service;
            String appName = installation.getAppName();
            int progress = installation.getProgress();
            $jacocoInit[22] = true;
            boolean isIndeterminate = installation.isIndeterminate();
            $jacocoInit[23] = true;
            downloadsNotification.setupNotification(md5, appName, progress, isIndeterminate);
            $jacocoInit[24] = true;
        }
        $jacocoInit[25] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14984a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        Log.e(TAG, "Error on handleOpenDownloadManager");
        $jacocoInit[17] = true;
        this.service.removeNotificationAndStop();
        $jacocoInit[18] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        this.subscriptions.unsubscribe();
        $jacocoInit[16] = true;
    }
}
