package p005cm.aptoide.p006pt.download;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.utils.BaseException;

/* renamed from: cm.aptoide.pt.download.Md5DownloadComparisonException */
class Md5DownloadComparisonException extends BaseException {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2900874561995164593L, "cm/aptoide/pt/download/Md5DownloadComparisonException", 1);
        $jacocoData = probes;
        return probes;
    }

    Md5DownloadComparisonException(String detailMessage) {
        boolean[] $jacocoInit = $jacocoInit();
        super(detailMessage);
        $jacocoInit[0] = true;
    }
}
