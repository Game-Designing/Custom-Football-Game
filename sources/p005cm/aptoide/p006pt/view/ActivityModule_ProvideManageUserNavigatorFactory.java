package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.user.ManageUserNavigator;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideManageUserNavigatorFactory */
public final class ActivityModule_ProvideManageUserNavigatorFactory implements C13181b<ManageUserNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8011897802328701489L, "cm/aptoide/pt/view/ActivityModule_ProvideManageUserNavigatorFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideManageUserNavigatorFactory(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        this.bottomNavigationNavigatorProvider = bottomNavigationNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public ManageUserNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<FragmentNavigator> provider = this.fragmentNavigatorProvider;
        $jacocoInit[1] = true;
        FragmentNavigator fragmentNavigator = (FragmentNavigator) provider.get();
        BottomNavigationNavigator bottomNavigationNavigator = (BottomNavigationNavigator) this.bottomNavigationNavigatorProvider.get();
        $jacocoInit[2] = true;
        ManageUserNavigator provideManageUserNavigator = activityModule.provideManageUserNavigator(fragmentNavigator, bottomNavigationNavigator);
        $jacocoInit[3] = true;
        C13182c.m43111a(provideManageUserNavigator, "Cannot return null from a non-@Nullable @Provides method");
        ManageUserNavigator manageUserNavigator = provideManageUserNavigator;
        $jacocoInit[4] = true;
        return manageUserNavigator;
    }

    public static C13181b<ManageUserNavigator> create(ActivityModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideManageUserNavigatorFactory activityModule_ProvideManageUserNavigatorFactory = new ActivityModule_ProvideManageUserNavigatorFactory(module2, fragmentNavigatorProvider2, bottomNavigationNavigatorProvider2);
        $jacocoInit[5] = true;
        return activityModule_ProvideManageUserNavigatorFactory;
    }

    public static ManageUserNavigator proxyProvideManageUserNavigator(ActivityModule instance, FragmentNavigator fragmentNavigator, BottomNavigationNavigator bottomNavigationNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        ManageUserNavigator provideManageUserNavigator = instance.provideManageUserNavigator(fragmentNavigator, bottomNavigationNavigator);
        $jacocoInit[6] = true;
        return provideManageUserNavigator;
    }
}
