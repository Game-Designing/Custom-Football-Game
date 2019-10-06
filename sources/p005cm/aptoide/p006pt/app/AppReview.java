package p005cm.aptoide.p006pt.app;

import java.util.Date;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.app.AppReview */
public class AppReview {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Date added;
    private final String body;

    /* renamed from: id */
    private final long f4649id;
    private final Date modified;
    private final ReviewComment reviewComment;
    private final ReviewStats reviewStats;
    private final ReviewUser reviewUser;
    private final String title;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-85084187858481318L, "cm/aptoide/pt/app/AppReview", 9);
        $jacocoData = probes;
        return probes;
    }

    public AppReview(long id, String title2, String body2, Date added2, Date modified2, ReviewStats reviewStats2, ReviewComment reviewComment2, ReviewUser reviewUser2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.f4649id = id;
        this.title = title2;
        this.body = body2;
        this.added = added2;
        this.modified = modified2;
        this.reviewStats = reviewStats2;
        this.reviewComment = reviewComment2;
        this.reviewUser = reviewUser2;
        $jacocoInit[0] = true;
    }

    public long getId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.f4649id;
        $jacocoInit[1] = true;
        return j;
    }

    public String getTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        $jacocoInit[2] = true;
        return str;
    }

    public String getBody() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.body;
        $jacocoInit[3] = true;
        return str;
    }

    public Date getAdded() {
        boolean[] $jacocoInit = $jacocoInit();
        Date date = this.added;
        $jacocoInit[4] = true;
        return date;
    }

    public Date getModified() {
        boolean[] $jacocoInit = $jacocoInit();
        Date date = this.modified;
        $jacocoInit[5] = true;
        return date;
    }

    public ReviewStats getReviewStats() {
        boolean[] $jacocoInit = $jacocoInit();
        ReviewStats reviewStats2 = this.reviewStats;
        $jacocoInit[6] = true;
        return reviewStats2;
    }

    public ReviewComment getReviewComment() {
        boolean[] $jacocoInit = $jacocoInit();
        ReviewComment reviewComment2 = this.reviewComment;
        $jacocoInit[7] = true;
        return reviewComment2;
    }

    public ReviewUser getReviewUser() {
        boolean[] $jacocoInit = $jacocoInit();
        ReviewUser reviewUser2 = this.reviewUser;
        $jacocoInit[8] = true;
        return reviewUser2;
    }
}
