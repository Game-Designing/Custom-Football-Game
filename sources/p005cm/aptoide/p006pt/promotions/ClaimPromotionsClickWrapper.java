package p005cm.aptoide.p006pt.promotions;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.promotions.ClaimPromotionsClickWrapper */
public class ClaimPromotionsClickWrapper extends ClaimPromotionsWrapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String walletAddress;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6232323515132380252L, "cm/aptoide/pt/promotions/ClaimPromotionsClickWrapper", 2);
        $jacocoData = probes;
        return probes;
    }

    public ClaimPromotionsClickWrapper(String walletAddress2, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        super(packageName);
        this.walletAddress = walletAddress2;
        $jacocoInit[0] = true;
    }

    public String getWalletAddress() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.walletAddress;
        $jacocoInit[1] = true;
        return str;
    }
}
