package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.reactions.ReactionsManager;
import p005cm.aptoide.p006pt.reactions.network.ReactionsService;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesReactionsManagerFactory */
public final class ApplicationModule_ProvidesReactionsManagerFactory implements C13181b<ReactionsManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<ReactionsService> reactionsServiceProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9093034964161030239L, "cm/aptoide/pt/ApplicationModule_ProvidesReactionsManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesReactionsManagerFactory(ApplicationModule module2, Provider<ReactionsService> reactionsServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.reactionsServiceProvider = reactionsServiceProvider2;
        $jacocoInit[0] = true;
    }

    public ReactionsManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<ReactionsService> provider = this.reactionsServiceProvider;
        $jacocoInit[1] = true;
        ReactionsManager providesReactionsManager = applicationModule.providesReactionsManager((ReactionsService) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesReactionsManager, "Cannot return null from a non-@Nullable @Provides method");
        ReactionsManager reactionsManager = providesReactionsManager;
        $jacocoInit[3] = true;
        return reactionsManager;
    }

    public static C13181b<ReactionsManager> create(ApplicationModule module2, Provider<ReactionsService> reactionsServiceProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesReactionsManagerFactory applicationModule_ProvidesReactionsManagerFactory = new ApplicationModule_ProvidesReactionsManagerFactory(module2, reactionsServiceProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesReactionsManagerFactory;
    }

    public static ReactionsManager proxyProvidesReactionsManager(ApplicationModule instance, ReactionsService reactionsService) {
        boolean[] $jacocoInit = $jacocoInit();
        ReactionsManager providesReactionsManager = instance.providesReactionsManager(reactionsService);
        $jacocoInit[5] = true;
        return providesReactionsManager;
    }
}
