package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationMapper;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.store.view.p079my.MyStoresNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesMyStoreNavigatorFactory */
public final class FragmentModule_ProvidesMyStoreNavigatorFactory implements C13181b<MyStoresNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<BottomNavigationMapper> bottomNavigationMapperProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4658006926372917005L, "cm/aptoide/pt/view/FragmentModule_ProvidesMyStoreNavigatorFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesMyStoreNavigatorFactory(FragmentModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<BottomNavigationMapper> bottomNavigationMapperProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentNavigatorProvider = fragmentNavigatorProvider2;
        this.bottomNavigationMapperProvider = bottomNavigationMapperProvider2;
        $jacocoInit[0] = true;
    }

    public MyStoresNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<FragmentNavigator> provider = this.fragmentNavigatorProvider;
        $jacocoInit[1] = true;
        FragmentNavigator fragmentNavigator = (FragmentNavigator) provider.get();
        BottomNavigationMapper bottomNavigationMapper = (BottomNavigationMapper) this.bottomNavigationMapperProvider.get();
        $jacocoInit[2] = true;
        MyStoresNavigator providesMyStoreNavigator = fragmentModule.providesMyStoreNavigator(fragmentNavigator, bottomNavigationMapper);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesMyStoreNavigator, "Cannot return null from a non-@Nullable @Provides method");
        MyStoresNavigator myStoresNavigator = providesMyStoreNavigator;
        $jacocoInit[4] = true;
        return myStoresNavigator;
    }

    public static C13181b<MyStoresNavigator> create(FragmentModule module2, Provider<FragmentNavigator> fragmentNavigatorProvider2, Provider<BottomNavigationMapper> bottomNavigationMapperProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesMyStoreNavigatorFactory fragmentModule_ProvidesMyStoreNavigatorFactory = new FragmentModule_ProvidesMyStoreNavigatorFactory(module2, fragmentNavigatorProvider2, bottomNavigationMapperProvider2);
        $jacocoInit[5] = true;
        return fragmentModule_ProvidesMyStoreNavigatorFactory;
    }

    public static MyStoresNavigator proxyProvidesMyStoreNavigator(FragmentModule instance, FragmentNavigator fragmentNavigator, BottomNavigationMapper bottomNavigationMapper) {
        boolean[] $jacocoInit = $jacocoInit();
        MyStoresNavigator providesMyStoreNavigator = instance.providesMyStoreNavigator(fragmentNavigator, bottomNavigationMapper);
        $jacocoInit[6] = true;
        return providesMyStoreNavigator;
    }
}
