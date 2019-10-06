package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.reactions.network.ReactionsRemoteService.ServiceV8;
import p005cm.aptoide.p006pt.reactions.network.ReactionsService;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesReactionsServiceFactory */
public final class ApplicationModule_ProvidesReactionsServiceFactory implements C13181b<ReactionsService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<ServiceV8> reactionServiceV8Provider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7006086263294623805L, "cm/aptoide/pt/ApplicationModule_ProvidesReactionsServiceFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesReactionsServiceFactory(ApplicationModule module2, Provider<ServiceV8> reactionServiceV8Provider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.reactionServiceV8Provider = reactionServiceV8Provider2;
        $jacocoInit[0] = true;
    }

    public ReactionsService get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<ServiceV8> provider = this.reactionServiceV8Provider;
        $jacocoInit[1] = true;
        ReactionsService providesReactionsService = applicationModule.providesReactionsService((ServiceV8) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesReactionsService, "Cannot return null from a non-@Nullable @Provides method");
        ReactionsService reactionsService = providesReactionsService;
        $jacocoInit[3] = true;
        return reactionsService;
    }

    public static C13181b<ReactionsService> create(ApplicationModule module2, Provider<ServiceV8> reactionServiceV8Provider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesReactionsServiceFactory applicationModule_ProvidesReactionsServiceFactory = new ApplicationModule_ProvidesReactionsServiceFactory(module2, reactionServiceV8Provider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesReactionsServiceFactory;
    }

    public static ReactionsService proxyProvidesReactionsService(ApplicationModule instance, ServiceV8 reactionServiceV8) {
        boolean[] $jacocoInit = $jacocoInit();
        ReactionsService providesReactionsService = instance.providesReactionsService(reactionServiceV8);
        $jacocoInit[5] = true;
        return providesReactionsService;
    }
}
