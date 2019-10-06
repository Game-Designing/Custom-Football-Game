package p005cm.aptoide.p006pt.promotions;

import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.promotions.PromotionsModel */
public class PromotionsModel {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final List<PromotionApp> appsList;
    private final String featureGraphic;
    private final boolean isError;
    private final boolean isWalletInstalled;
    private final String promotionId;
    private final String title;
    private final int totalAppcValue;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2200556671208163016L, "cm/aptoide/pt/promotions/PromotionsModel", 9);
        $jacocoData = probes;
        return probes;
    }

    public PromotionsModel(String promotionId2, List<PromotionApp> appsList2, int totalAppcValue2, String title2, String featureGraphic2, boolean isWalletInstalled2, boolean isError2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionId = promotionId2;
        this.appsList = appsList2;
        this.totalAppcValue = totalAppcValue2;
        this.title = title2;
        this.featureGraphic = featureGraphic2;
        this.isWalletInstalled = isWalletInstalled2;
        this.isError = isError2;
        $jacocoInit[0] = true;
    }

    public static PromotionsModel ofError() {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsModel promotionsModel = new PromotionsModel("n/a", Collections.emptyList(), -1, "", "", false, true);
        $jacocoInit[1] = true;
        return promotionsModel;
    }

    public List<PromotionApp> getAppsList() {
        boolean[] $jacocoInit = $jacocoInit();
        List<PromotionApp> list = this.appsList;
        $jacocoInit[2] = true;
        return list;
    }

    public int getTotalAppcValue() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.totalAppcValue;
        $jacocoInit[3] = true;
        return i;
    }

    public boolean isWalletInstalled() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isWalletInstalled;
        $jacocoInit[4] = true;
        return z;
    }

    public String getTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        $jacocoInit[5] = true;
        return str;
    }

    public String getFeatureGraphic() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.featureGraphic;
        $jacocoInit[6] = true;
        return str;
    }

    public boolean isError() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isError;
        $jacocoInit[7] = true;
        return z;
    }

    public String getPromotionId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.promotionId;
        $jacocoInit[8] = true;
        return str;
    }
}
