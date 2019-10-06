package p005cm.aptoide.p006pt.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.app.ReviewsRepository */
public class ReviewsRepository {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ReviewsService reviewsService;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3840552088382459781L, "cm/aptoide/pt/app/ReviewsRepository", 2);
        $jacocoData = probes;
        return probes;
    }

    public ReviewsRepository(ReviewsService reviewsService2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.reviewsService = reviewsService2;
        $jacocoInit[0] = true;
    }

    public Single<ReviewRequestResult> loadReviews(String storeName, String packageName, int maxReviews, String languagesFilterSort) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<ReviewRequestResult> loadReviews = this.reviewsService.loadReviews(storeName, packageName, maxReviews, languagesFilterSort);
        $jacocoInit[1] = true;
        return loadReviews;
    }
}
