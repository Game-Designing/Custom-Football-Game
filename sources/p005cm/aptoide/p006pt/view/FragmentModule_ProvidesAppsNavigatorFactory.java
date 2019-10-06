package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationMapper;
import p005cm.aptoide.p006pt.home.apps.AppsNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesAppsNavigatorFactory */
public final class FragmentModule_ProvidesAppsNavigatorFactory implements C13181b<AppsNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<BottomNavigationMapper> bottomNavigationMapperProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9105025151569261301L, "cm/aptoide/pt/view/FragmentModule_ProvidesAppsNavigatorFactory", 10);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesAppsNavigatorFactory(FragmentModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<BottomNavigationMapper> bottomNavigationMapperProvider2, Provider<AppNavigator> appNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        this.bottomNavigationMapperProvider = bottomNavigationMapperProvider2;
        this.appNavigatorProvider = appNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public AppsNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<FragmentNavigator> provider = this.fragmentNavigatorProvider;
        $jacocoInit[1] = true;
        FragmentNavigator fragmentNavigator = (FragmentNavigator) provider.get();
        Provider<BottomNavigationMapper> provider2 = this.bottomNavigationMapperProvider;
        $jacocoInit[2] = true;
        BottomNavigationMapper bottomNavigationMapper = (BottomNavigationMapper) provider2.get();
        Provider<AppNavigator> provider3 = this.appNavigatorProvider;
        $jacocoInit[3] = true;
        AppNavigator appNavigator = (AppNavigator) provider3.get();
        $jacocoInit[4] = true;
        AppsNavigator providesAppsNavigator = fragmentModule.providesAppsNavigator(fragmentNavigator, bottomNavigationMapper, appNavigator);
        $jacocoInit[5] = true;
        C13182c.m43111a(providesAppsNavigator, "Cannot return null from a non-@Nullable @Provides method");
        AppsNavigator appsNavigator = providesAppsNavigator;
        $jacocoInit[6] = true;
        return appsNavigator;
    }

    public static C13181b<AppsNavigator> create(FragmentModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<BottomNavigationMapper> bottomNavigationMapperProvider2, Provider<AppNavigator> appNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesAppsNavigatorFactory fragmentModule_ProvidesAppsNavigatorFactory = new FragmentModule_ProvidesAppsNavigatorFactory(module2, fragmentNavigatorProvider2, bottomNavigationMapperProvider2, appNavigatorProvider2);
        $jacocoInit[7] = true;
        return fragmentModule_ProvidesAppsNavigatorFactory;
    }

    public static AppsNavigator proxyProvidesAppsNavigator(FragmentModule instance, FragmentNavigator fragmentNavigator, BottomNavigationMapper bottomNavigationMapper, AppNavigator appNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        AppsNavigator providesAppsNavigator = instance.providesAppsNavigator(fragmentNavigator, bottomNavigationMapper, appNavigator);
        $jacocoInit[8] = true;
        return providesAppsNavigator;
    }
}
