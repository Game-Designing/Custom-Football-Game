package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesAppCoinsInfoNavigatorFactory */
public final class ActivityModule_ProvidesAppCoinsInfoNavigatorFactory implements C13181b<AppCoinsInfoNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4345131924402064362L, "cm/aptoide/pt/view/ActivityModule_ProvidesAppCoinsInfoNavigatorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesAppCoinsInfoNavigatorFactory(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public AppCoinsInfoNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<FragmentNavigator> provider = this.fragmentNavigatorProvider;
        $jacocoInit[1] = true;
        AppCoinsInfoNavigator providesAppCoinsInfoNavigator = activityModule.providesAppCoinsInfoNavigator((FragmentNavigator) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAppCoinsInfoNavigator, "Cannot return null from a non-@Nullable @Provides method");
        AppCoinsInfoNavigator appCoinsInfoNavigator = providesAppCoinsInfoNavigator;
        $jacocoInit[3] = true;
        return appCoinsInfoNavigator;
    }

    public static C13181b<AppCoinsInfoNavigator> create(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesAppCoinsInfoNavigatorFactory activityModule_ProvidesAppCoinsInfoNavigatorFactory = new ActivityModule_ProvidesAppCoinsInfoNavigatorFactory(module2, fragmentNavigatorProvider2);
        $jacocoInit[4] = true;
        return activityModule_ProvidesAppCoinsInfoNavigatorFactory;
    }

    public static AppCoinsInfoNavigator proxyProvidesAppCoinsInfoNavigator(ActivityModule instance, FragmentNavigator fragmentNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        AppCoinsInfoNavigator providesAppCoinsInfoNavigator = instance.providesAppCoinsInfoNavigator(fragmentNavigator);
        $jacocoInit[5] = true;
        return providesAppCoinsInfoNavigator;
    }
}
