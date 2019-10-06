package p005cm.aptoide.p006pt.promotions;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.promotions.ClaimPromotionsSubmitWrapper */
public class ClaimPromotionsSubmitWrapper extends ClaimPromotionsWrapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String captcha;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8172236557251292592L, "cm/aptoide/pt/promotions/ClaimPromotionsSubmitWrapper", 2);
        $jacocoData = probes;
        return probes;
    }

    public ClaimPromotionsSubmitWrapper(String captcha2, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        super(packageName);
        this.captcha = captcha2;
        $jacocoInit[0] = true;
    }

    public String getCaptcha() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.captcha;
        $jacocoInit[1] = true;
        return str;
    }
}
