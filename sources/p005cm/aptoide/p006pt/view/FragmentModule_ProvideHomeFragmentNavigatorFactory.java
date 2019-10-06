package p005cm.aptoide.p006pt.view;

import java.util.Map;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.navigator.Result;
import p019d.p022i.p023b.C0099b;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvideHomeFragmentNavigatorFactory */
public final class FragmentModule_ProvideHomeFragmentNavigatorFactory implements C13181b<FragmentNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<Map<Integer, Result>> fragmentResultMapProvider;
    private final Provider<C0099b<Map<Integer, Result>>> fragmentResultRelayProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4541447263455564395L, "cm/aptoide/pt/view/FragmentModule_ProvideHomeFragmentNavigatorFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvideHomeFragmentNavigatorFactory(FragmentModule module2, Provider<Map<Integer, Result>> fragmentResultMapProvider2, Provider<C0099b<Map<Integer, Result>>> fragmentResultRelayProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentResultMapProvider = fragmentResultMapProvider2;
        this.fragmentResultRelayProvider = fragmentResultRelayProvider2;
        $jacocoInit[0] = true;
    }

    public FragmentNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<Map<Integer, Result>> provider = this.fragmentResultMapProvider;
        $jacocoInit[1] = true;
        Map map = (Map) provider.get();
        C0099b bVar = (C0099b) this.fragmentResultRelayProvider.get();
        $jacocoInit[2] = true;
        FragmentNavigator provideHomeFragmentNavigator = fragmentModule.provideHomeFragmentNavigator(map, bVar);
        $jacocoInit[3] = true;
        C13182c.m43111a(provideHomeFragmentNavigator, "Cannot return null from a non-@Nullable @Provides method");
        FragmentNavigator fragmentNavigator = provideHomeFragmentNavigator;
        $jacocoInit[4] = true;
        return fragmentNavigator;
    }

    public static C13181b<FragmentNavigator> create(FragmentModule module2, Provider<Map<Integer, Result>> fragmentResultMapProvider2, Provider<C0099b<Map<Integer, Result>>> fragmentResultRelayProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvideHomeFragmentNavigatorFactory fragmentModule_ProvideHomeFragmentNavigatorFactory = new FragmentModule_ProvideHomeFragmentNavigatorFactory(module2, fragmentResultMapProvider2, fragmentResultRelayProvider2);
        $jacocoInit[5] = true;
        return fragmentModule_ProvideHomeFragmentNavigatorFactory;
    }

    public static FragmentNavigator proxyProvideHomeFragmentNavigator(FragmentModule instance, Map<Integer, Result> fragmentResultMap, C0099b<Map<Integer, Result>> fragmentResultRelay) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator provideHomeFragmentNavigator = instance.provideHomeFragmentNavigator(fragmentResultMap, fragmentResultRelay);
        $jacocoInit[6] = true;
        return provideHomeFragmentNavigator;
    }
}
