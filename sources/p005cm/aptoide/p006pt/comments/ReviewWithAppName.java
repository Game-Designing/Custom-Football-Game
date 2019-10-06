package p005cm.aptoide.p006pt.comments;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Review;

/* renamed from: cm.aptoide.pt.comments.ReviewWithAppName */
public final class ReviewWithAppName {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String appName;
    private final Review review;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3503969042488301259L, "cm/aptoide/pt/comments/ReviewWithAppName", 3);
        $jacocoData = probes;
        return probes;
    }

    public ReviewWithAppName(String appName2, Review review2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appName = appName2;
        this.review = review2;
        $jacocoInit[0] = true;
    }

    public String getAppName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appName;
        $jacocoInit[1] = true;
        return str;
    }

    public Review getReview() {
        boolean[] $jacocoInit = $jacocoInit();
        Review review2 = this.review;
        $jacocoInit[2] = true;
        return review2;
    }
}
