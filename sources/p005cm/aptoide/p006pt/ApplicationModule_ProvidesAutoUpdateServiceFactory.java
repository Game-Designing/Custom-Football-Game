package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.autoupdate.Service;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.Retrofit;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesAutoUpdateServiceFactory */
public final class ApplicationModule_ProvidesAutoUpdateServiceFactory implements C13181b<Service> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<Retrofit> retrofitProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2048649980497471405L, "cm/aptoide/pt/ApplicationModule_ProvidesAutoUpdateServiceFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesAutoUpdateServiceFactory(ApplicationModule module2, Provider<Retrofit> retrofitProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.retrofitProvider = retrofitProvider2;
        $jacocoInit[0] = true;
    }

    public Service get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Retrofit> provider = this.retrofitProvider;
        $jacocoInit[1] = true;
        Service providesAutoUpdateService = applicationModule.providesAutoUpdateService((Retrofit) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesAutoUpdateService, "Cannot return null from a non-@Nullable @Provides method");
        Service service = providesAutoUpdateService;
        $jacocoInit[3] = true;
        return service;
    }

    public static C13181b<Service> create(ApplicationModule module2, Provider<Retrofit> retrofitProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesAutoUpdateServiceFactory applicationModule_ProvidesAutoUpdateServiceFactory = new ApplicationModule_ProvidesAutoUpdateServiceFactory(module2, retrofitProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesAutoUpdateServiceFactory;
    }

    public static Service proxyProvidesAutoUpdateService(ApplicationModule instance, Retrofit retrofit) {
        boolean[] $jacocoInit = $jacocoInit();
        Service providesAutoUpdateService = instance.providesAutoUpdateService(retrofit);
        $jacocoInit[5] = true;
        return providesAutoUpdateService;
    }
}
