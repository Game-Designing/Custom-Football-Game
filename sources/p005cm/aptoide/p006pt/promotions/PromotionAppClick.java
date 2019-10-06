package p005cm.aptoide.p006pt.promotions;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.promotions.PromotionAppClick */
public class PromotionAppClick {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private PromotionViewApp app;
    private ClickType clickType;

    /* renamed from: cm.aptoide.pt.promotions.PromotionAppClick$ClickType */
    enum ClickType {
        PAUSE_DOWNLOAD,
        CANCEL_DOWNLOAD,
        RESUME_DOWNLOAD,
        INSTALL_APP,
        DOWNLOAD,
        RETRY_DOWNLOAD,
        CLAIM,
        UPDATE,
        DOWNGRADE;

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
        boolean[] probes = Offline.getProbes(2928604352892451857L, "cm/aptoide/pt/promotions/PromotionAppClick", 3);
        $jacocoData = probes;
        return probes;
    }

    public PromotionAppClick(PromotionViewApp app2, ClickType clickType2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.app = app2;
        this.clickType = clickType2;
        $jacocoInit[0] = true;
    }

    public PromotionViewApp getApp() {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionViewApp promotionViewApp = this.app;
        $jacocoInit[1] = true;
        return promotionViewApp;
    }

    public ClickType getClickType() {
        boolean[] $jacocoInit = $jacocoInit();
        ClickType clickType2 = this.clickType;
        $jacocoInit[2] = true;
        return clickType2;
    }
}
