package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.abtesting.ABTestService.ServiceV7;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.Retrofit;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesABTestServiceV7Factory */
public final class ApplicationModule_ProvidesABTestServiceV7Factory implements C13181b<ServiceV7> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<Retrofit> retrofitProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2116205674811603637L, "cm/aptoide/pt/ApplicationModule_ProvidesABTestServiceV7Factory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesABTestServiceV7Factory(ApplicationModule module2, Provider<Retrofit> retrofitProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.retrofitProvider = retrofitProvider2;
        $jacocoInit[0] = true;
    }

    public ServiceV7 get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Retrofit> provider = this.retrofitProvider;
        $jacocoInit[1] = true;
        ServiceV7 providesABTestServiceV7 = applicationModule.providesABTestServiceV7((Retrofit) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesABTestServiceV7, "Cannot return null from a non-@Nullable @Provides method");
        ServiceV7 serviceV7 = providesABTestServiceV7;
        $jacocoInit[3] = true;
        return serviceV7;
    }

    public static C13181b<ServiceV7> create(ApplicationModule module2, Provider<Retrofit> retrofitProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesABTestServiceV7Factory applicationModule_ProvidesABTestServiceV7Factory = new ApplicationModule_ProvidesABTestServiceV7Factory(module2, retrofitProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesABTestServiceV7Factory;
    }

    public static ServiceV7 proxyProvidesABTestServiceV7(ApplicationModule instance, Retrofit retrofit) {
        boolean[] $jacocoInit = $jacocoInit();
        ServiceV7 providesABTestServiceV7 = instance.providesABTestServiceV7(retrofit);
        $jacocoInit[5] = true;
        return providesABTestServiceV7;
    }
}
