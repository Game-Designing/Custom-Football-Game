package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.AptoideBiEventService;
import p005cm.aptoide.analytics.implementation.network.RetrofitAptoideBiService.ServiceV7;
import p005cm.aptoide.p006pt.analytics.analytics.AnalyticsBodyInterceptorV7;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesRetrofitAptoideBiServiceFactory */
public final class ApplicationModule_ProvidesRetrofitAptoideBiServiceFactory implements C13181b<AptoideBiEventService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AnalyticsBodyInterceptorV7> bodyInterceptorProvider;
    private final ApplicationModule module;
    private final Provider<ServiceV7> serviceV7Provider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1034985433062175274L, "cm/aptoide/pt/ApplicationModule_ProvidesRetrofitAptoideBiServiceFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesRetrofitAptoideBiServiceFactory(ApplicationModule module2, Provider<ServiceV7> serviceV7Provider2, Provider<AnalyticsBodyInterceptorV7> bodyInterceptorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.serviceV7Provider = serviceV7Provider2;
        this.bodyInterceptorProvider = bodyInterceptorProvider2;
        $jacocoInit[0] = true;
    }

    public AptoideBiEventService get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<ServiceV7> provider = this.serviceV7Provider;
        $jacocoInit[1] = true;
        ServiceV7 serviceV7 = (ServiceV7) provider.get();
        AnalyticsBodyInterceptorV7 analyticsBodyInterceptorV7 = (AnalyticsBodyInterceptorV7) this.bodyInterceptorProvider.get();
        $jacocoInit[2] = true;
        AptoideBiEventService providesRetrofitAptoideBiService = applicationModule.providesRetrofitAptoideBiService(serviceV7, analyticsBodyInterceptorV7);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesRetrofitAptoideBiService, "Cannot return null from a non-@Nullable @Provides method");
        AptoideBiEventService aptoideBiEventService = providesRetrofitAptoideBiService;
        $jacocoInit[4] = true;
        return aptoideBiEventService;
    }

    public static C13181b<AptoideBiEventService> create(ApplicationModule module2, Provider<ServiceV7> serviceV7Provider2, Provider<AnalyticsBodyInterceptorV7> bodyInterceptorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesRetrofitAptoideBiServiceFactory applicationModule_ProvidesRetrofitAptoideBiServiceFactory = new ApplicationModule_ProvidesRetrofitAptoideBiServiceFactory(module2, serviceV7Provider2, bodyInterceptorProvider2);
        $jacocoInit[5] = true;
        return applicationModule_ProvidesRetrofitAptoideBiServiceFactory;
    }

    public static AptoideBiEventService proxyProvidesRetrofitAptoideBiService(ApplicationModule instance, ServiceV7 serviceV7, AnalyticsBodyInterceptorV7 bodyInterceptor) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideBiEventService providesRetrofitAptoideBiService = instance.providesRetrofitAptoideBiService(serviceV7, bodyInterceptor);
        $jacocoInit[6] = true;
        return providesRetrofitAptoideBiService;
    }
}
