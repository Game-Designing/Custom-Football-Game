package p005cm.aptoide.p006pt;

import java.util.Collection;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideFacebookEventsFactory */
public final class ApplicationModule_ProvideFacebookEventsFactory implements C13181b<Collection<String>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2323463602970260792L, "cm/aptoide/pt/ApplicationModule_ProvideFacebookEventsFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideFacebookEventsFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public Collection<String> get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        Collection<String> provideFacebookEvents = applicationModule.provideFacebookEvents();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideFacebookEvents, "Cannot return null from a non-@Nullable @Provides method");
        Collection<String> collection = provideFacebookEvents;
        $jacocoInit[3] = true;
        return collection;
    }

    public static C13181b<Collection<String>> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideFacebookEventsFactory applicationModule_ProvideFacebookEventsFactory = new ApplicationModule_ProvideFacebookEventsFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideFacebookEventsFactory;
    }

    public static Collection<String> proxyProvideFacebookEvents(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Collection<String> provideFacebookEvents = instance.provideFacebookEvents();
        $jacocoInit[5] = true;
        return provideFacebookEvents;
    }
}
