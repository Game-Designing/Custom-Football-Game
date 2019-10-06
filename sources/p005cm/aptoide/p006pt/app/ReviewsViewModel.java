package p005cm.aptoide.p006pt.app;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.ReviewRequestResult.Error;

/* renamed from: cm.aptoide.pt.app.ReviewsViewModel */
public class ReviewsViewModel {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Error error;
    private final boolean loading;
    private final List<AppReview> reviewsList;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1536077000693228262L, "cm/aptoide/pt/app/ReviewsViewModel", 7);
        $jacocoData = probes;
        return probes;
    }

    public ReviewsViewModel(List<AppReview> reviewsList2, boolean loading2, Error error2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.reviewsList = reviewsList2;
        this.loading = loading2;
        this.error = error2;
        $jacocoInit[0] = true;
    }

    public List<AppReview> getReviewsList() {
        boolean[] $jacocoInit = $jacocoInit();
        List<AppReview> list = this.reviewsList;
        $jacocoInit[1] = true;
        return list;
    }

    public boolean isLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.loading;
        $jacocoInit[2] = true;
        return z;
    }

    public Error getError() {
        boolean[] $jacocoInit = $jacocoInit();
        Error error2 = this.error;
        $jacocoInit[3] = true;
        return error2;
    }

    public boolean hasError() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.error != null) {
            $jacocoInit[4] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[5] = true;
        }
        $jacocoInit[6] = true;
        return z;
    }
}
