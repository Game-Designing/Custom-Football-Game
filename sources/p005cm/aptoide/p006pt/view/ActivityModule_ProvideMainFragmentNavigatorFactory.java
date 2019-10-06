package p005cm.aptoide.p006pt.view;

import android.support.p000v4.app.C0486t;
import java.util.Map;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.navigator.Result;
import p019d.p022i.p023b.C0099b;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvideMainFragmentNavigatorFactory */
public final class ActivityModule_ProvideMainFragmentNavigatorFactory implements C13181b<FragmentNavigator> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<C0486t> fragmentManagerProvider;
    private final Provider<Map<Integer, Result>> fragmentResultMapProvider;
    private final Provider<C0099b<Map<Integer, Result>>> fragmentResultRelayProvider;
    private final ActivityModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7778626122587463718L, "cm/aptoide/pt/view/ActivityModule_ProvideMainFragmentNavigatorFactory", 10);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvideMainFragmentNavigatorFactory(ActivityModule module2, Provider<Map<Integer, Result>> fragmentResultMapProvider2, Provider<C0099b<Map<Integer, Result>>> fragmentResultRelayProvider2, Provider<C0486t> fragmentManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.fragmentResultMapProvider = fragmentResultMapProvider2;
        this.fragmentResultRelayProvider = fragmentResultRelayProvider2;
        this.fragmentManagerProvider = fragmentManagerProvider2;
        $jacocoInit[0] = true;
    }

    public FragmentNavigator get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<Map<Integer, Result>> provider = this.fragmentResultMapProvider;
        $jacocoInit[1] = true;
        Map map = (Map) provider.get();
        Provider<C0099b<Map<Integer, Result>>> provider2 = this.fragmentResultRelayProvider;
        $jacocoInit[2] = true;
        C0099b bVar = (C0099b) provider2.get();
        Provider<C0486t> provider3 = this.fragmentManagerProvider;
        $jacocoInit[3] = true;
        C0486t tVar = (C0486t) provider3.get();
        $jacocoInit[4] = true;
        FragmentNavigator provideMainFragmentNavigator = activityModule.provideMainFragmentNavigator(map, bVar, tVar);
        $jacocoInit[5] = true;
        C13182c.m43111a(provideMainFragmentNavigator, "Cannot return null from a non-@Nullable @Provides method");
        FragmentNavigator fragmentNavigator = provideMainFragmentNavigator;
        $jacocoInit[6] = true;
        return fragmentNavigator;
    }

    public static C13181b<FragmentNavigator> create(ActivityModule module2, Provider<Map<Integer, Result>> fragmentResultMapProvider2, Provider<C0099b<Map<Integer, Result>>> fragmentResultRelayProvider2, Provider<C0486t> fragmentManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvideMainFragmentNavigatorFactory activityModule_ProvideMainFragmentNavigatorFactory = new ActivityModule_ProvideMainFragmentNavigatorFactory(module2, fragmentResultMapProvider2, fragmentResultRelayProvider2, fragmentManagerProvider2);
        $jacocoInit[7] = true;
        return activityModule_ProvideMainFragmentNavigatorFactory;
    }

    public static FragmentNavigator proxyProvideMainFragmentNavigator(ActivityModule instance, Map<Integer, Result> fragmentResultMap, C0099b<Map<Integer, Result>> fragmentResultRelay, C0486t fragmentManager) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator provideMainFragmentNavigator = instance.provideMainFragmentNavigator(fragmentResultMap, fragmentResultRelay, fragmentManager);
        $jacocoInit[8] = true;
        return provideMainFragmentNavigator;
    }
}
