package p005cm.aptoide.p006pt.repository.exception;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.utils.BaseException;

/* renamed from: cm.aptoide.pt.repository.exception.RepositoryItemNotFoundException */
public class RepositoryItemNotFoundException extends BaseException {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8991707502777482308L, "cm/aptoide/pt/repository/exception/RepositoryItemNotFoundException", 1);
        $jacocoData = probes;
        return probes;
    }

    public RepositoryItemNotFoundException(String detailMessage) {
        boolean[] $jacocoInit = $jacocoInit();
        super(detailMessage);
        $jacocoInit[0] = true;
    }
}
