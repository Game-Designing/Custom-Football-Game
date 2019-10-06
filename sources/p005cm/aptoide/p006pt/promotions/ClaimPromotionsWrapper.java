package p005cm.aptoide.p006pt.promotions;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.promotions.ClaimPromotionsWrapper */
public abstract class ClaimPromotionsWrapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String packageName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4640955007461646916L, "cm/aptoide/pt/promotions/ClaimPromotionsWrapper", 2);
        $jacocoData = probes;
        return probes;
    }

    ClaimPromotionsWrapper(String packageName2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.packageName = packageName2;
        $jacocoInit[0] = true;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[1] = true;
        return str;
    }
}
