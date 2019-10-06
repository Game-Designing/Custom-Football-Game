package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesAppViewConfigurationFactory */
public final class FragmentModule_ProvidesAppViewConfigurationFactory implements C13181b<AppViewConfiguration> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2186503569005282710L, "cm/aptoide/pt/view/FragmentModule_ProvidesAppViewConfigurationFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesAppViewConfigurationFactory(FragmentModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public AppViewConfiguration get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        $jacocoInit[1] = true;
        AppViewConfiguration providesAppViewConfiguration = fragmentModule.providesAppViewConfiguration();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAppViewConfiguration, "Cannot return null from a non-@Nullable @Provides method");
        AppViewConfiguration appViewConfiguration = providesAppViewConfiguration;
        $jacocoInit[3] = true;
        return appViewConfiguration;
    }

    public static C13181b<AppViewConfiguration> create(FragmentModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesAppViewConfigurationFactory fragmentModule_ProvidesAppViewConfigurationFactory = new FragmentModule_ProvidesAppViewConfigurationFactory(module2);
        $jacocoInit[4] = true;
        return fragmentModule_ProvidesAppViewConfigurationFactory;
    }

    public static AppViewConfiguration proxyProvidesAppViewConfiguration(FragmentModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewConfiguration providesAppViewConfiguration = instance.providesAppViewConfiguration();
        $jacocoInit[5] = true;
        return providesAppViewConfiguration;
    }
}
