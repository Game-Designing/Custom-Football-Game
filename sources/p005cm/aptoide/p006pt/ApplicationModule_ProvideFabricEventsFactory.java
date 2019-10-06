package p005cm.aptoide.p006pt;

import java.util.Collection;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideFabricEventsFactory */
public final class ApplicationModule_ProvideFabricEventsFactory implements C13181b<Collection<String>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4716540320505804636L, "cm/aptoide/pt/ApplicationModule_ProvideFabricEventsFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideFabricEventsFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public Collection<String> get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        Collection<String> provideFabricEvents = applicationModule.provideFabricEvents();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideFabricEvents, "Cannot return null from a non-@Nullable @Provides method");
        Collection<String> collection = provideFabricEvents;
        $jacocoInit[3] = true;
        return collection;
    }

    public static C13181b<Collection<String>> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideFabricEventsFactory applicationModule_ProvideFabricEventsFactory = new ApplicationModule_ProvideFabricEventsFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideFabricEventsFactory;
    }

    public static Collection<String> proxyProvideFabricEvents(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Collection<String> provideFabricEvents = instance.provideFabricEvents();
        $jacocoInit[5] = true;
        return provideFabricEvents;
    }
}
