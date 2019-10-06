package p005cm.aptoide.p006pt.account.view.exception;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.account.view.exception.StoreCreationException */
public class StoreCreationException extends Exception {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String errorCode;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4050975700142588847L, "cm/aptoide/pt/account/view/exception/StoreCreationException", 6);
        $jacocoData = probes;
        return probes;
    }

    public StoreCreationException() {
        boolean[] $jacocoInit = $jacocoInit();
        this.errorCode = null;
        $jacocoInit[0] = true;
    }

    public StoreCreationException(String errorCode2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.errorCode = errorCode2;
        $jacocoInit[1] = true;
    }

    public String getErrorCode() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.errorCode;
        $jacocoInit[2] = true;
        return str;
    }

    public boolean hasErrorCode() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.errorCode != null) {
            $jacocoInit[3] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[4] = true;
        }
        $jacocoInit[5] = true;
        return z;
    }
}
