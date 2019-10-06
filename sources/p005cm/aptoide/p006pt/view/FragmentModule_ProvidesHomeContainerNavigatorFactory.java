package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.HomeContainerNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesHomeContainerNavigatorFactory */
public final class FragmentModule_ProvidesHomeContainerNavigatorFactory implements C13181b<HomeContainerNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<FragmentNavigator> childFragmentNavigatorProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4269999312686141114L, "cm/aptoide/pt/view/FragmentModule_ProvidesHomeContainerNavigatorFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesHomeContainerNavigatorFactory(FragmentModule module2, Provider<FragmentNavigator> childFragmentNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.childFragmentNavigatorProvider = childFragmentNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public HomeContainerNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<FragmentNavigator> provider = this.childFragmentNavigatorProvider;
        $jacocoInit[1] = true;
        HomeContainerNavigator providesHomeContainerNavigator = fragmentModule.providesHomeContainerNavigator((FragmentNavigator) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesHomeContainerNavigator, "Cannot return null from a non-@Nullable @Provides method");
        HomeContainerNavigator homeContainerNavigator = providesHomeContainerNavigator;
        $jacocoInit[3] = true;
        return homeContainerNavigator;
    }

    public static C13181b<HomeContainerNavigator> create(FragmentModule module2, Provider<FragmentNavigator> childFragmentNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesHomeContainerNavigatorFactory fragmentModule_ProvidesHomeContainerNavigatorFactory = new FragmentModule_ProvidesHomeContainerNavigatorFactory(module2, childFragmentNavigatorProvider2);
        $jacocoInit[4] = true;
        return fragmentModule_ProvidesHomeContainerNavigatorFactory;
    }

    public static HomeContainerNavigator proxyProvidesHomeContainerNavigator(FragmentModule instance, FragmentNavigator childFragmentNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeContainerNavigator providesHomeContainerNavigator = instance.providesHomeContainerNavigator(childFragmentNavigator);
        $jacocoInit[5] = true;
        return providesHomeContainerNavigator;
    }
}
