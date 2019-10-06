package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.RequestBodyFactory;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideRequestBodyFactoryFactory */
public final class ApplicationModule_ProvideRequestBodyFactoryFactory implements C13181b<RequestBodyFactory> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1195091028244948266L, "cm/aptoide/pt/ApplicationModule_ProvideRequestBodyFactoryFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideRequestBodyFactoryFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public RequestBodyFactory get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        RequestBodyFactory provideRequestBodyFactory = applicationModule.provideRequestBodyFactory();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideRequestBodyFactory, "Cannot return null from a non-@Nullable @Provides method");
        RequestBodyFactory requestBodyFactory = provideRequestBodyFactory;
        $jacocoInit[3] = true;
        return requestBodyFactory;
    }

    public static C13181b<RequestBodyFactory> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideRequestBodyFactoryFactory applicationModule_ProvideRequestBodyFactoryFactory = new ApplicationModule_ProvideRequestBodyFactoryFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideRequestBodyFactoryFactory;
    }

    public static RequestBodyFactory proxyProvideRequestBodyFactory(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        RequestBodyFactory provideRequestBodyFactory = instance.provideRequestBodyFactory();
        $jacocoInit[5] = true;
        return provideRequestBodyFactory;
    }
}
