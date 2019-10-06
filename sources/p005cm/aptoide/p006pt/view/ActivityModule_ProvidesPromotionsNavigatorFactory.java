package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.promotions.PromotionsNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesPromotionsNavigatorFactory */
public final class ActivityModule_ProvidesPromotionsNavigatorFactory implements C13181b<PromotionsNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2993729016436641331L, "cm/aptoide/pt/view/ActivityModule_ProvidesPromotionsNavigatorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesPromotionsNavigatorFactory(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public PromotionsNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<FragmentNavigator> provider = this.fragmentNavigatorProvider;
        $jacocoInit[1] = true;
        PromotionsNavigator providesPromotionsNavigator = activityModule.providesPromotionsNavigator((FragmentNavigator) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesPromotionsNavigator, "Cannot return null from a non-@Nullable @Provides method");
        PromotionsNavigator promotionsNavigator = providesPromotionsNavigator;
        $jacocoInit[3] = true;
        return promotionsNavigator;
    }

    public static C13181b<PromotionsNavigator> create(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesPromotionsNavigatorFactory activityModule_ProvidesPromotionsNavigatorFactory = new ActivityModule_ProvidesPromotionsNavigatorFactory(module2, fragmentNavigatorProvider2);
        $jacocoInit[4] = true;
        return activityModule_ProvidesPromotionsNavigatorFactory;
    }

    public static PromotionsNavigator proxyProvidesPromotionsNavigator(ActivityModule instance, FragmentNavigator fragmentNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionsNavigator providesPromotionsNavigator = instance.providesPromotionsNavigator(fragmentNavigator);
        $jacocoInit[5] = true;
        return providesPromotionsNavigator;
    }
}
