package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.network.RetrofitAptoideBiService.ServiceV7;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.Retrofit;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAptoideBiServiceFactory */
public final class ApplicationModule_ProvidesAptoideBiServiceFactory implements C13181b<ServiceV7> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<Retrofit> retrofitProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-646387803682473329L, "cm/aptoide/pt/ApplicationModule_ProvidesAptoideBiServiceFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAptoideBiServiceFactory(ApplicationModule module2, Provider<Retrofit> retrofitProvider2) {
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
        ServiceV7 providesAptoideBiService = applicationModule.providesAptoideBiService((Retrofit) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAptoideBiService, "Cannot return null from a non-@Nullable @Provides method");
        ServiceV7 serviceV7 = providesAptoideBiService;
        $jacocoInit[3] = true;
        return serviceV7;
    }

    public static C13181b<ServiceV7> create(ApplicationModule module2, Provider<Retrofit> retrofitProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAptoideBiServiceFactory applicationModule_ProvidesAptoideBiServiceFactory = new ApplicationModule_ProvidesAptoideBiServiceFactory(module2, retrofitProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAptoideBiServiceFactory;
    }

    public static ServiceV7 proxyProvidesAptoideBiService(ApplicationModule instance, Retrofit retrofit) {
        boolean[] $jacocoInit = $jacocoInit();
        ServiceV7 providesAptoideBiService = instance.providesAptoideBiService(retrofit);
        $jacocoInit[5] = true;
        return providesAptoideBiService;
    }
}
