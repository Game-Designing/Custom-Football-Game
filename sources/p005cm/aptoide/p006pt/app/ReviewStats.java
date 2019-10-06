package p005cm.aptoide.p006pt.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.app.ReviewStats */
public class ReviewStats {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final long comments;
    private final long likes;
    private final long points;
    private final float rating;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3928719600331749058L, "cm/aptoide/pt/app/ReviewStats", 5);
        $jacocoData = probes;
        return probes;
    }

    public ReviewStats(long comments2, long likes2, long points2, float rating2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.comments = comments2;
        this.likes = likes2;
        this.points = points2;
        this.rating = rating2;
        $jacocoInit[0] = true;
    }

    public long getComments() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.comments;
        $jacocoInit[1] = true;
        return j;
    }

    public long getLikes() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.likes;
        $jacocoInit[2] = true;
        return j;
    }

    public long getPoints() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.points;
        $jacocoInit[3] = true;
        return j;
    }

    public float getRating() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.rating;
        $jacocoInit[4] = true;
        return f;
    }
}
