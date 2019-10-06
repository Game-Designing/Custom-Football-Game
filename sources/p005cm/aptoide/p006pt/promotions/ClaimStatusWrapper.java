package p005cm.aptoide.p006pt.promotions;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.promotions.ClaimStatusWrapper */
public class ClaimStatusWrapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final List<Error> errors;
    private final Status status;

    /* renamed from: cm.aptoide.pt.promotions.ClaimStatusWrapper$Error */
    public enum Error {
        PROMOTION_CLAIMED,
        WRONG_ADDRESS,
        WRONG_CAPTCHA,
        GENERIC;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.promotions.ClaimStatusWrapper$Status */
    public enum Status {
        OK,
        FAIL;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8227751648898838127L, "cm/aptoide/pt/promotions/ClaimStatusWrapper", 3);
        $jacocoData = probes;
        return probes;
    }

    public ClaimStatusWrapper(Status status2, List<Error> errors2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.status = status2;
        this.errors = errors2;
        $jacocoInit[0] = true;
    }

    public Status getStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        Status status2 = this.status;
        $jacocoInit[1] = true;
        return status2;
    }

    public List<Error> getErrors() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Error> list = this.errors;
        $jacocoInit[2] = true;
        return list;
    }
}
