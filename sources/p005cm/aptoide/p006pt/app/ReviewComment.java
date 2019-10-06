package p005cm.aptoide.p006pt.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.app.ReviewComment */
public class ReviewComment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final long total;
    private final String view;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1021874431278942457L, "cm/aptoide/pt/app/ReviewComment", 3);
        $jacocoData = probes;
        return probes;
    }

    public ReviewComment(String view2, long total2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.total = total2;
        $jacocoInit[0] = true;
    }

    public String getView() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.view;
        $jacocoInit[1] = true;
        return str;
    }

    public long getTotal() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.total;
        $jacocoInit[2] = true;
        return j;
    }
}
