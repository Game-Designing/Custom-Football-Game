package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.CallAdapter.Factory;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesCallAdapterFactoryFactory */
public final class ApplicationModule_ProvidesCallAdapterFactoryFactory implements C13181b<Factory> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5666892691314246558L, "cm/aptoide/pt/ApplicationModule_ProvidesCallAdapterFactoryFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesCallAdapterFactoryFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public Factory get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        Factory providesCallAdapterFactory = applicationModule.providesCallAdapterFactory();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesCallAdapterFactory, "Cannot return null from a non-@Nullable @Provides method");
        Factory factory = providesCallAdapterFactory;
        $jacocoInit[3] = true;
        return factory;
    }

    public static C13181b<Factory> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesCallAdapterFactoryFactory applicationModule_ProvidesCallAdapterFactoryFactory = new ApplicationModule_ProvidesCallAdapterFactoryFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesCallAdapterFactoryFactory;
    }

    public static Factory proxyProvidesCallAdapterFactory(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Factory providesCallAdapterFactory = instance.providesCallAdapterFactory();
        $jacocoInit[5] = true;
        return providesCallAdapterFactory;
    }
}
