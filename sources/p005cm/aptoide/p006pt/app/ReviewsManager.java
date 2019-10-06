package p005cm.aptoide.p006pt.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.app.ReviewsManager */
public class ReviewsManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ReviewsRepository reviewsRepository;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5695361698857386365L, "cm/aptoide/pt/app/ReviewsManager", 2);
        $jacocoData = probes;
        return probes;
    }

    public ReviewsManager(ReviewsRepository reviewsRepository2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.reviewsRepository = reviewsRepository2;
        $jacocoInit[0] = true;
    }

    public Single<ReviewRequestResult> loadReviews(String storeName, String packageName, int maxReviews, String languagesFilterSort) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<ReviewRequestResult> loadReviews = this.reviewsRepository.loadReviews(storeName, packageName, maxReviews, languagesFilterSort);
        $jacocoInit[1] = true;
        return loadReviews;
    }
}
