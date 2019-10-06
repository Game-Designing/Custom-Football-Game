package p005cm.aptoide.p006pt.install;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.packageinstaller.InstallStatus;
import p026rx.C0120S;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.install.AppInstallerStatusReceiver */
public class AppInstallerStatusReceiver {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private C14963c<InstallStatus> installStatusPublishSubject;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1216457329526488797L, "cm/aptoide/pt/install/AppInstallerStatusReceiver", 3);
        $jacocoData = probes;
        return probes;
    }

    public AppInstallerStatusReceiver(C14963c<InstallStatus> installStatusPublishSubject2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installStatusPublishSubject = installStatusPublishSubject2;
        $jacocoInit[0] = true;
    }

    public void onStatusReceived(InstallStatus installStatus) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installStatusPublishSubject.onNext(installStatus);
        $jacocoInit[1] = true;
    }

    public C0120S<InstallStatus> getInstallerInstallStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<InstallStatus> cVar = this.installStatusPublishSubject;
        $jacocoInit[2] = true;
        return cVar;
    }
}
