package p005cm.aptoide.p006pt.repository.exception;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.utils.BaseException;

/* renamed from: cm.aptoide.pt.repository.exception.RepositoryIllegalArgumentException */
public class RepositoryIllegalArgumentException extends BaseException {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2477191047070450219L, "cm/aptoide/pt/repository/exception/RepositoryIllegalArgumentException", 1);
        $jacocoData = probes;
        return probes;
    }

    public RepositoryIllegalArgumentException(String detailMessage) {
        boolean[] $jacocoInit = $jacocoInit();
        super(detailMessage);
        $jacocoInit[0] = true;
    }
}
