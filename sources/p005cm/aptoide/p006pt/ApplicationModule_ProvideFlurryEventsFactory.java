package p005cm.aptoide.p006pt;

import java.util.Collection;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideFlurryEventsFactory */
public final class ApplicationModule_ProvideFlurryEventsFactory implements C13181b<Collection<String>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1748843735234038226L, "cm/aptoide/pt/ApplicationModule_ProvideFlurryEventsFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideFlurryEventsFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public Collection<String> get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        Collection<String> provideFlurryEvents = applicationModule.provideFlurryEvents();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideFlurryEvents, "Cannot return null from a non-@Nullable @Provides method");
        Collection<String> collection = provideFlurryEvents;
        $jacocoInit[3] = true;
        return collection;
    }

    public static C13181b<Collection<String>> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideFlurryEventsFactory applicationModule_ProvideFlurryEventsFactory = new ApplicationModule_ProvideFlurryEventsFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideFlurryEventsFactory;
    }

    public static Collection<String> proxyProvideFlurryEvents(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Collection<String> provideFlurryEvents = instance.provideFlurryEvents();
        $jacocoInit[5] = true;
        return provideFlurryEvents;
    }
}
