package p005cm.aptoide.p006pt.app.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.promotions.Promotion;
import p005cm.aptoide.p006pt.promotions.WalletApp;

/* renamed from: cm.aptoide.pt.app.view.PromotionEvent */
public class PromotionEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ClickType clickType;
    private Promotion promotion;
    private WalletApp walletApp;

    /* renamed from: cm.aptoide.pt.app.view.PromotionEvent$ClickType */
    enum ClickType {
        PAUSE_DOWNLOAD,
        CANCEL_DOWNLOAD,
        RESUME_DOWNLOAD,
        INSTALL_APP,
        DOWNLOAD,
        RETRY_DOWNLOAD,
        CLAIM,
        UPDATE,
        DOWNGRADE,
        DISMISS;

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
        boolean[] probes = Offline.getProbes(4141171552289742496L, "cm/aptoide/pt/app/view/PromotionEvent", 4);
        $jacocoData = probes;
        return probes;
    }

    public PromotionEvent(Promotion promotion2, WalletApp walletApp2, ClickType clickType2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.walletApp = walletApp2;
        this.clickType = clickType2;
        this.promotion = promotion2;
        $jacocoInit[0] = true;
    }

    public WalletApp getWallet() {
        boolean[] $jacocoInit = $jacocoInit();
        WalletApp walletApp2 = this.walletApp;
        $jacocoInit[1] = true;
        return walletApp2;
    }

    public Promotion getPromotion() {
        boolean[] $jacocoInit = $jacocoInit();
        Promotion promotion2 = this.promotion;
        $jacocoInit[2] = true;
        return promotion2;
    }

    public ClickType getClickType() {
        boolean[] $jacocoInit = $jacocoInit();
        ClickType clickType2 = this.clickType;
        $jacocoInit[3] = true;
        return clickType2;
    }
}
