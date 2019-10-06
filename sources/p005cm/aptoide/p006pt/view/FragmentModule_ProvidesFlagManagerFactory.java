package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.FlagManager;
import p005cm.aptoide.p006pt.app.FlagService;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesFlagManagerFactory */
public final class FragmentModule_ProvidesFlagManagerFactory implements C13181b<FlagManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<FlagService> flagServiceProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7422539548447917283L, "cm/aptoide/pt/view/FragmentModule_ProvidesFlagManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesFlagManagerFactory(FragmentModule module2, Provider<FlagService> flagServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.flagServiceProvider = flagServiceProvider2;
        $jacocoInit[0] = true;
    }

    public FlagManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<FlagService> provider = this.flagServiceProvider;
        $jacocoInit[1] = true;
        FlagManager providesFlagManager = fragmentModule.providesFlagManager((FlagService) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesFlagManager, "Cannot return null from a non-@Nullable @Provides method");
        FlagManager flagManager = providesFlagManager;
        $jacocoInit[3] = true;
        return flagManager;
    }

    public static C13181b<FlagManager> create(FragmentModule module2, Provider<FlagService> flagServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesFlagManagerFactory fragmentModule_ProvidesFlagManagerFactory = new FragmentModule_ProvidesFlagManagerFactory(module2, flagServiceProvider2);
        $jacocoInit[4] = true;
        return fragmentModule_ProvidesFlagManagerFactory;
    }

    public static FlagManager proxyProvidesFlagManager(FragmentModule instance, FlagService flagService) {
        boolean[] $jacocoInit = $jacocoInit();
        FlagManager providesFlagManager = instance.providesFlagManager(flagService);
        $jacocoInit[5] = true;
        return providesFlagManager;
    }
}
