package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.splashscreen.SplashScreenNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideSplashScreenNavigatorFactory */
public final class ActivityModule_ProvideSplashScreenNavigatorFactory implements C13181b<SplashScreenNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1787265394454015941L, "cm/aptoide/pt/view/ActivityModule_ProvideSplashScreenNavigatorFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideSplashScreenNavigatorFactory(ActivityModule module2, Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider2, Provider<FragmentNavigator> fragmentNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.bottomNavigationNavigatorProvider = bottomNavigationNavigatorProvider2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public SplashScreenNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<BottomNavigationNavigator> provider = this.bottomNavigationNavigatorProvider;
        $jacocoInit[1] = true;
        BottomNavigationNavigator bottomNavigationNavigator = (BottomNavigationNavigator) provider.get();
        FragmentNavigator fragmentNavigator = (FragmentNavigator) this.fragmentNavigatorProvider.get();
        $jacocoInit[2] = true;
        SplashScreenNavigator provideSplashScreenNavigator = activityModule.provideSplashScreenNavigator(bottomNavigationNavigator, fragmentNavigator);
        $jacocoInit[3] = true;
        C13182c.m43111a(provideSplashScreenNavigator, "Cannot return null from a non-@Nullable @Provides method");
        SplashScreenNavigator splashScreenNavigator = provideSplashScreenNavigator;
        $jacocoInit[4] = true;
        return splashScreenNavigator;
    }

    public static C13181b<SplashScreenNavigator> create(ActivityModule module2, Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider2, Provider<FragmentNavigator> fragmentNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideSplashScreenNavigatorFactory activityModule_ProvideSplashScreenNavigatorFactory = new ActivityModule_ProvideSplashScreenNavigatorFactory(module2, bottomNavigationNavigatorProvider2, fragmentNavigatorProvider2);
        $jacocoInit[5] = true;
        return activityModule_ProvideSplashScreenNavigatorFactory;
    }

    public static SplashScreenNavigator proxyProvideSplashScreenNavigator(ActivityModule instance, BottomNavigationNavigator bottomNavigationNavigator, FragmentNavigator fragmentNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        SplashScreenNavigator provideSplashScreenNavigator = instance.provideSplashScreenNavigator(bottomNavigationNavigator, fragmentNavigator);
        $jacocoInit[6] = true;
        return provideSplashScreenNavigator;
    }
}
