package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.apps.AppMapper;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesAppMapperFactory */
public final class FragmentModule_ProvidesAppMapperFactory implements C13181b<AppMapper> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5117764052565834193L, "cm/aptoide/pt/view/FragmentModule_ProvidesAppMapperFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesAppMapperFactory(FragmentModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public AppMapper get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        $jacocoInit[1] = true;
        AppMapper providesAppMapper = fragmentModule.providesAppMapper();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAppMapper, "Cannot return null from a non-@Nullable @Provides method");
        AppMapper appMapper = providesAppMapper;
        $jacocoInit[3] = true;
        return appMapper;
    }

    public static C13181b<AppMapper> create(FragmentModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesAppMapperFactory fragmentModule_ProvidesAppMapperFactory = new FragmentModule_ProvidesAppMapperFactory(module2);
        $jacocoInit[4] = true;
        return fragmentModule_ProvidesAppMapperFactory;
    }

    public static AppMapper proxyProvidesAppMapper(FragmentModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        AppMapper providesAppMapper = instance.providesAppMapper();
        $jacocoInit[5] = true;
        return providesAppMapper;
    }
}
