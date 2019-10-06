package p005cm.aptoide.p006pt.install.exception;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.utils.BaseException;

/* renamed from: cm.aptoide.pt.install.exception.InstallationException */
public class InstallationException extends BaseException {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7344550377002028072L, "cm/aptoide/pt/install/exception/InstallationException", 2);
        $jacocoData = probes;
        return probes;
    }

    public InstallationException(String detailMessage) {
        boolean[] $jacocoInit = $jacocoInit();
        super(detailMessage);
        $jacocoInit[0] = true;
    }

    public InstallationException(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        super(throwable);
        $jacocoInit[1] = true;
    }
}
