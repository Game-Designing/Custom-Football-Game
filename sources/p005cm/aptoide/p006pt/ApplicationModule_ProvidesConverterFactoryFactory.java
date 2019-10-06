package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesConverterFactoryFactory */
public final class ApplicationModule_ProvidesConverterFactoryFactory implements C13181b<Factory> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5950508774143461152L, "cm/aptoide/pt/ApplicationModule_ProvidesConverterFactoryFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesConverterFactoryFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public Factory get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        Factory providesConverterFactory = applicationModule.providesConverterFactory();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesConverterFactory, "Cannot return null from a non-@Nullable @Provides method");
        Factory factory = providesConverterFactory;
        $jacocoInit[3] = true;
        return factory;
    }

    public static C13181b<Factory> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesConverterFactoryFactory applicationModule_ProvidesConverterFactoryFactory = new ApplicationModule_ProvidesConverterFactoryFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesConverterFactoryFactory;
    }

    public static Factory proxyProvidesConverterFactory(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Factory providesConverterFactory = instance.providesConverterFactory();
        $jacocoInit[5] = true;
        return providesConverterFactory;
    }
}
