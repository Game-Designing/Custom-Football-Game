package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.promotions.CaptchaService;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionsManager;
import p005cm.aptoide.p006pt.promotions.PromotionsManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesClaimPromotionsManagerFactory */
public final class ActivityModule_ProvidesClaimPromotionsManagerFactory implements C13181b<ClaimPromotionsManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<CaptchaService> captchaServiceProvider;
    private final ActivityModule module;
    private final Provider<PromotionsManager> promotionsManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2527088196192170447L, "cm/aptoide/pt/view/ActivityModule_ProvidesClaimPromotionsManagerFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesClaimPromotionsManagerFactory(ActivityModule module2, Provider<CaptchaService> captchaServiceProvider2, Provider<PromotionsManager> promotionsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.captchaServiceProvider = captchaServiceProvider2;
        this.promotionsManagerProvider = promotionsManagerProvider2;
        $jacocoInit[0] = true;
    }

    public ClaimPromotionsManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<CaptchaService> provider = this.captchaServiceProvider;
        $jacocoInit[1] = true;
        CaptchaService captchaService = (CaptchaService) provider.get();
        PromotionsManager promotionsManager = (PromotionsManager) this.promotionsManagerProvider.get();
        $jacocoInit[2] = true;
        ClaimPromotionsManager providesClaimPromotionsManager = activityModule.providesClaimPromotionsManager(captchaService, promotionsManager);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesClaimPromotionsManager, "Cannot return null from a non-@Nullable @Provides method");
        ClaimPromotionsManager claimPromotionsManager = providesClaimPromotionsManager;
        $jacocoInit[4] = true;
        return claimPromotionsManager;
    }

    public static C13181b<ClaimPromotionsManager> create(ActivityModule module2, Provider<CaptchaService> captchaServiceProvider2, Provider<PromotionsManager> promotionsManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesClaimPromotionsManagerFactory activityModule_ProvidesClaimPromotionsManagerFactory = new ActivityModule_ProvidesClaimPromotionsManagerFactory(module2, captchaServiceProvider2, promotionsManagerProvider2);
        $jacocoInit[5] = true;
        return activityModule_ProvidesClaimPromotionsManagerFactory;
    }

    public static ClaimPromotionsManager proxyProvidesClaimPromotionsManager(ActivityModule instance, CaptchaService captchaService, PromotionsManager promotionsManager) {
        boolean[] $jacocoInit = $jacocoInit();
        ClaimPromotionsManager providesClaimPromotionsManager = instance.providesClaimPromotionsManager(captchaService, promotionsManager);
        $jacocoInit[6] = true;
        return providesClaimPromotionsManager;
    }
}
