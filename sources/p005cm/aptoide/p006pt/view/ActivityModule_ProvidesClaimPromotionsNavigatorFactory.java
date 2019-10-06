package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.promotions.ClaimPromotionsNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesClaimPromotionsNavigatorFactory */
public final class ActivityModule_ProvidesClaimPromotionsNavigatorFactory implements C13181b<ClaimPromotionsNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5888802028020168724L, "cm/aptoide/pt/view/ActivityModule_ProvidesClaimPromotionsNavigatorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesClaimPromotionsNavigatorFactory(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public ClaimPromotionsNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<FragmentNavigator> provider = this.fragmentNavigatorProvider;
        $jacocoInit[1] = true;
        ClaimPromotionsNavigator providesClaimPromotionsNavigator = activityModule.providesClaimPromotionsNavigator((FragmentNavigator) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesClaimPromotionsNavigator, "Cannot return null from a non-@Nullable @Provides method");
        ClaimPromotionsNavigator claimPromotionsNavigator = providesClaimPromotionsNavigator;
        $jacocoInit[3] = true;
        return claimPromotionsNavigator;
    }

    public static C13181b<ClaimPromotionsNavigator> create(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesClaimPromotionsNavigatorFactory activityModule_ProvidesClaimPromotionsNavigatorFactory = new ActivityModule_ProvidesClaimPromotionsNavigatorFactory(module2, fragmentNavigatorProvider2);
        $jacocoInit[4] = true;
        return activityModule_ProvidesClaimPromotionsNavigatorFactory;
    }

    public static ClaimPromotionsNavigator proxyProvidesClaimPromotionsNavigator(ActivityModule instance, FragmentNavigator fragmentNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        ClaimPromotionsNavigator providesClaimPromotionsNavigator = instance.providesClaimPromotionsNavigator(fragmentNavigator);
        $jacocoInit[5] = true;
        return providesClaimPromotionsNavigator;
    }
}
