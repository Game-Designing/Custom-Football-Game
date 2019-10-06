package p005cm.aptoide.p006pt.app.view.similar;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.SimilarAppsViewModel;

/* renamed from: cm.aptoide.pt.app.view.similar.SimilarAppsBundle */
public class SimilarAppsBundle {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BundleType bundleType;
    private final SimilarAppsViewModel model;

    /* renamed from: cm.aptoide.pt.app.view.similar.SimilarAppsBundle$BundleType */
    public enum BundleType {
        APPS,
        APPC_APPS;

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
        boolean[] probes = Offline.getProbes(2706651014528727906L, "cm/aptoide/pt/app/view/similar/SimilarAppsBundle", 3);
        $jacocoData = probes;
        return probes;
    }

    public SimilarAppsBundle(SimilarAppsViewModel model2, BundleType bundleType2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.model = model2;
        this.bundleType = bundleType2;
        $jacocoInit[0] = true;
    }

    public SimilarAppsViewModel getContent() {
        boolean[] $jacocoInit = $jacocoInit();
        SimilarAppsViewModel similarAppsViewModel = this.model;
        $jacocoInit[1] = true;
        return similarAppsViewModel;
    }

    public BundleType getType() {
        boolean[] $jacocoInit = $jacocoInit();
        BundleType bundleType2 = this.bundleType;
        $jacocoInit[2] = true;
        return bundleType2;
    }
}
