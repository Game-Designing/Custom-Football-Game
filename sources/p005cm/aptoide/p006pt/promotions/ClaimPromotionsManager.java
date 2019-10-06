package p005cm.aptoide.p006pt.promotions;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.promotions.ClaimPromotionsManager */
public class ClaimPromotionsManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private CaptchaService captchaService;
    private PromotionsManager promotionsManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4636931780659443710L, "cm/aptoide/pt/promotions/ClaimPromotionsManager", 6);
        $jacocoData = probes;
        return probes;
    }

    public ClaimPromotionsManager(PromotionsManager promotionsManager2, CaptchaService captchaService2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsManager = promotionsManager2;
        this.captchaService = captchaService2;
        $jacocoInit[0] = true;
    }

    public Single<String> getCaptcha() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<String> captcha = this.captchaService.getCaptcha();
        $jacocoInit[1] = true;
        return captcha;
    }

    public void saveWalletAddress(String walletAddress) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsManager.saveWalletAddress(walletAddress);
        $jacocoInit[2] = true;
    }

    public Single<ClaimStatusWrapper> claimPromotion(String packageName, String captcha, String promotionId) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsManager promotionsManager2 = this.promotionsManager;
        Single<ClaimStatusWrapper> claimPromotion = promotionsManager2.claimPromotion(promotionsManager2.getWalletAddress(), packageName, captcha, promotionId);
        $jacocoInit[3] = true;
        return claimPromotion;
    }

    public void saveCaptchaUrl(String captchaUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        this.captchaService.saveCaptchaUrl(captchaUrl);
        $jacocoInit[4] = true;
    }

    public String getCaptchaUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String captchaUrl = this.captchaService.getCaptchaUrl();
        $jacocoInit[5] = true;
        return captchaUrl;
    }
}
