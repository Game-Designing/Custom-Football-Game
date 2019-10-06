package p005cm.aptoide.p006pt.download;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.utils.BaseException;

/* renamed from: cm.aptoide.pt.download.GeneralDownloadErrorException */
class GeneralDownloadErrorException extends BaseException {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5026870233955951179L, "cm/aptoide/pt/download/GeneralDownloadErrorException", 1);
        $jacocoData = probes;
        return probes;
    }

    public GeneralDownloadErrorException(String errorMessage) {
        boolean[] $jacocoInit = $jacocoInit();
        super(errorMessage);
        $jacocoInit[0] = true;
    }
}
