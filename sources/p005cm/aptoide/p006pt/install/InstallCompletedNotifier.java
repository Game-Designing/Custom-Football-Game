package p005cm.aptoide.p006pt.install;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.install.Install.InstallationStatus;
import p019d.p022i.p023b.C0100e;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.install.InstallCompletedNotifier */
public class InstallCompletedNotifier {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final List<App> appToCheck = new ArrayList();
    private final CrashReport crashReport;
    private final InstallManager installManager;
    private final C0100e<Void> watcher;

    /* renamed from: cm.aptoide.pt.install.InstallCompletedNotifier$App */
    private class App {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private String md5;
        private String packageName;
        final /* synthetic */ InstallCompletedNotifier this$0;
        private int versionCode;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(2929889446161102813L, "cm/aptoide/pt/install/InstallCompletedNotifier$App", 10);
            $jacocoData = probes;
            return probes;
        }

        public App(InstallCompletedNotifier installCompletedNotifier, String packageName2, int versionCode2, String md52) {
            boolean[] $jacocoInit = $jacocoInit();
            this.this$0 = installCompletedNotifier;
            this.packageName = packageName2;
            this.versionCode = versionCode2;
            this.md5 = md52;
            $jacocoInit[0] = true;
        }

        public int hashCode() {
            boolean[] $jacocoInit = $jacocoInit();
            int result = (this.packageName.hashCode() * 31) + this.versionCode;
            $jacocoInit[1] = true;
            int result2 = (result * 31) + this.md5.hashCode();
            $jacocoInit[2] = true;
            return result2;
        }

        public boolean equals(Object o) {
            boolean[] $jacocoInit = $jacocoInit();
            if (this == o) {
                $jacocoInit[3] = true;
                return true;
            }
            if (o == null) {
                $jacocoInit[4] = true;
            } else if (getClass() != o.getClass()) {
                $jacocoInit[5] = true;
            } else {
                App app = (App) o;
                if (this.versionCode != app.versionCode) {
                    $jacocoInit[7] = true;
                    return false;
                } else if (!this.packageName.equals(app.packageName)) {
                    $jacocoInit[8] = true;
                    return false;
                } else {
                    boolean equals = this.md5.equals(app.md5);
                    $jacocoInit[9] = true;
                    return equals;
                }
            }
            $jacocoInit[6] = true;
            return false;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4219111272730309323L, "cm/aptoide/pt/install/InstallCompletedNotifier", 22);
        $jacocoData = probes;
        return probes;
    }

    public InstallCompletedNotifier(C0100e<Void> watcher2, InstallManager installManager2, CrashReport crashReport2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport = crashReport2;
        $jacocoInit[0] = true;
        this.watcher = watcher2;
        this.installManager = installManager2;
        $jacocoInit[1] = true;
    }

    public void add(String packageName, int versionCode, String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        App app = new App(this, packageName, versionCode, md5);
        $jacocoInit[2] = true;
        if (this.appToCheck.contains(app)) {
            $jacocoInit[3] = true;
        } else {
            $jacocoInit[4] = true;
            this.appToCheck.add(app);
            $jacocoInit[5] = true;
            C0120S install = this.installManager.getInstall(md5, packageName, versionCode);
            C4051i iVar = C4051i.f7557a;
            $jacocoInit[6] = true;
            C0120S d = install.mo3653d((C0132p<? super T, Boolean>) iVar);
            $jacocoInit[7] = true;
            C0120S d2 = d.mo3647d();
            C4048h hVar = new C4048h(this, app);
            C4045g gVar = new C4045g(this);
            $jacocoInit[8] = true;
            d2.mo3626a((C0129b<? super T>) hVar, (C0129b<Throwable>) gVar);
            $jacocoInit[9] = true;
        }
        $jacocoInit[10] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8539a(Install installationProgress) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallationStatus state = installationProgress.getState();
        InstallationStatus installationStatus = InstallationStatus.INSTALLED;
        $jacocoInit[19] = true;
        boolean equals = state.equals(installationStatus);
        $jacocoInit[20] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[21] = true;
        return valueOf;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15016a(App app, Install installationProgress) {
        boolean[] $jacocoInit = $jacocoInit();
        installFinished(app);
        $jacocoInit[18] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15017a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[17] = true;
    }

    private void installFinished(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appToCheck.remove(app);
        $jacocoInit[11] = true;
        if (!this.appToCheck.isEmpty()) {
            $jacocoInit[12] = true;
        } else {
            $jacocoInit[13] = true;
            this.watcher.call(null);
            $jacocoInit[14] = true;
        }
        $jacocoInit[15] = true;
    }

    public C0100e<Void> getWatcher() {
        boolean[] $jacocoInit = $jacocoInit();
        C0100e<Void> eVar = this.watcher;
        $jacocoInit[16] = true;
        return eVar;
    }
}
