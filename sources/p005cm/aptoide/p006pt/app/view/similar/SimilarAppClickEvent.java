package p005cm.aptoide.p006pt.app.view.similar;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.AppViewSimilarApp;
import p005cm.aptoide.p006pt.app.view.AppViewSimilarAppsAdapter.SimilarAppType;

/* renamed from: cm.aptoide.pt.app.view.similar.SimilarAppClickEvent */
public class SimilarAppClickEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private int position;
    private AppViewSimilarApp similar;
    private SimilarAppType type;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6027882810916325831L, "cm/aptoide/pt/app/view/similar/SimilarAppClickEvent", 4);
        $jacocoData = probes;
        return probes;
    }

    public SimilarAppClickEvent(AppViewSimilarApp similar2, SimilarAppType type2, int position2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.similar = similar2;
        this.type = type2;
        this.position = position2;
        $jacocoInit[0] = true;
    }

    public AppViewSimilarApp getSimilar() {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewSimilarApp appViewSimilarApp = this.similar;
        $jacocoInit[1] = true;
        return appViewSimilarApp;
    }

    public SimilarAppType getType() {
        boolean[] $jacocoInit = $jacocoInit();
        SimilarAppType similarAppType = this.type;
        $jacocoInit[2] = true;
        return similarAppType;
    }

    public int getPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.position;
        $jacocoInit[3] = true;
        return i;
    }
}
