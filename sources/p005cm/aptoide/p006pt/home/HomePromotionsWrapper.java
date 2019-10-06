package p005cm.aptoide.p006pt.home;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.home.HomePromotionsWrapper */
public class HomePromotionsWrapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String featureGraphic;
    private final boolean hasPromotions;
    private final int promotions;
    private final boolean showDialog;
    private final String title;
    private final float totalAppcValue;
    private final float totalUnclaimedAppcValue;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3665609614517079341L, "cm/aptoide/pt/home/HomePromotionsWrapper", 8);
        $jacocoData = probes;
        return probes;
    }

    public HomePromotionsWrapper(String title2, String featureGraphic2, boolean hasPromotions2, int promotions2, float totalUnclaimedAppcValue2, boolean showDialog2, float totalAppcValue2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.title = title2;
        this.featureGraphic = featureGraphic2;
        this.hasPromotions = hasPromotions2;
        this.promotions = promotions2;
        this.totalUnclaimedAppcValue = totalUnclaimedAppcValue2;
        this.showDialog = showDialog2;
        this.totalAppcValue = totalAppcValue2;
        $jacocoInit[0] = true;
    }

    public boolean hasPromotions() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.hasPromotions;
        $jacocoInit[1] = true;
        return z;
    }

    public int getPromotions() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.promotions;
        $jacocoInit[2] = true;
        return i;
    }

    public float getTotalUnclaimedAppcValue() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.totalUnclaimedAppcValue;
        $jacocoInit[3] = true;
        return f;
    }

    public boolean shouldShowDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.showDialog;
        $jacocoInit[4] = true;
        return z;
    }

    public float getTotalAppcValue() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.totalAppcValue;
        $jacocoInit[5] = true;
        return f;
    }

    public String getTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        $jacocoInit[6] = true;
        return str;
    }

    public String getFeatureGraphic() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.featureGraphic;
        $jacocoInit[7] = true;
        return str;
    }
}
