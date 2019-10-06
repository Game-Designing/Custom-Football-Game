package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationMapper;
import p005cm.aptoide.p006pt.home.HomeNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesHomeNavigatorFactory */
public final class FragmentModule_ProvidesHomeNavigatorFactory implements C13181b<HomeNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountNavigator> accountNavigatorProvider;
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<BottomNavigationMapper> bottomNavigationMapperProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final FragmentModule module;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7886817809533691873L, "cm/aptoide/pt/view/FragmentModule_ProvidesHomeNavigatorFactory", 12);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesHomeNavigatorFactory(FragmentModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<BottomNavigationMapper> bottomNavigationMapperProvider2, Provider<AppNavigator> appNavigatorProvider2, Provider<String> themeProvider2, Provider<AccountNavigator> accountNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        this.bottomNavigationMapperProvider = bottomNavigationMapperProvider2;
        this.appNavigatorProvider = appNavigatorProvider2;
        this.themeProvider = themeProvider2;
        this.accountNavigatorProvider = accountNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public HomeNavigator get() {
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
        Provider<String> provider4 = this.themeProvider;
        $jacocoInit[4] = true;
        String str = (String) provider4.get();
        Provider<AccountNavigator> provider5 = this.accountNavigatorProvider;
        $jacocoInit[5] = true;
        AccountNavigator accountNavigator = (AccountNavigator) provider5.get();
        $jacocoInit[6] = true;
        HomeNavigator providesHomeNavigator = fragmentModule.providesHomeNavigator(fragmentNavigator, bottomNavigationMapper, appNavigator, str, accountNavigator);
        $jacocoInit[7] = true;
        C13182c.m43111a(providesHomeNavigator, "Cannot return null from a non-@Nullable @Provides method");
        HomeNavigator homeNavigator = providesHomeNavigator;
        $jacocoInit[8] = true;
        return homeNavigator;
    }

    public static C13181b<HomeNavigator> create(FragmentModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<BottomNavigationMapper> bottomNavigationMapperProvider2, Provider<AppNavigator> appNavigatorProvider2, Provider<String> themeProvider2, Provider<AccountNavigator> accountNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesHomeNavigatorFactory fragmentModule_ProvidesHomeNavigatorFactory = new FragmentModule_ProvidesHomeNavigatorFactory(module2, fragmentNavigatorProvider2, bottomNavigationMapperProvider2, appNavigatorProvider2, themeProvider2, accountNavigatorProvider2);
        $jacocoInit[9] = true;
        return fragmentModule_ProvidesHomeNavigatorFactory;
    }

    public static HomeNavigator proxyProvidesHomeNavigator(FragmentModule instance, FragmentNavigator fragmentNavigator, BottomNavigationMapper bottomNavigationMapper, AppNavigator appNavigator, String theme, AccountNavigator accountNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeNavigator providesHomeNavigator = instance.providesHomeNavigator(fragmentNavigator, bottomNavigationMapper, appNavigator, theme, accountNavigator);
        $jacocoInit[10] = true;
        return providesHomeNavigator;
    }
}
