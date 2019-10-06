package p005cm.aptoide.p006pt.app;

import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.app.ReviewRequestResult */
public class ReviewRequestResult {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Error error;
    private final boolean loading;
    private final List<AppReview> reviewList;

    /* renamed from: cm.aptoide.pt.app.ReviewRequestResult$Error */
    public enum Error {
        NETWORK,
        GENERIC;

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
        boolean[] probes = Offline.getProbes(-2012886756605707077L, "cm/aptoide/pt/app/ReviewRequestResult", 11);
        $jacocoData = probes;
        return probes;
    }

    public ReviewRequestResult(boolean loading2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.reviewList = Collections.emptyList();
        this.loading = loading2;
        this.error = null;
        $jacocoInit[1] = true;
    }

    public ReviewRequestResult(Error error2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[2] = true;
        this.reviewList = Collections.emptyList();
        this.loading = false;
        this.error = error2;
        $jacocoInit[3] = true;
    }

    public ReviewRequestResult(List<AppReview> reviewList2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.reviewList = reviewList2;
        this.loading = false;
        this.error = null;
        $jacocoInit[4] = true;
    }

    public boolean hasError() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.error != null) {
            $jacocoInit[5] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[6] = true;
        }
        $jacocoInit[7] = true;
        return z;
    }

    public Error getError() {
        boolean[] $jacocoInit = $jacocoInit();
        Error error2 = this.error;
        $jacocoInit[8] = true;
        return error2;
    }

    public List<AppReview> getReviewList() {
        boolean[] $jacocoInit = $jacocoInit();
        List<AppReview> list = this.reviewList;
        $jacocoInit[9] = true;
        return list;
    }

    public boolean isLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.loading;
        $jacocoInit[10] = true;
        return z;
    }
}
