package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.autoupdate.AutoUpdateService;
import p005cm.aptoide.p006pt.autoupdate.Service;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.ActivityModule_ProvidesRetrofitAptoideBiServiceFactory */
public final class ActivityModule_ProvidesRetrofitAptoideBiServiceFactory implements C13181b<AutoUpdateService> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ActivityModule module;
    private final Provider<String> packageNameProvider;
    private final Provider<Service> serviceProvider;
    private final Provider<String> storeNameProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9053988833837658480L, "cm/aptoide/pt/view/ActivityModule_ProvidesRetrofitAptoideBiServiceFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public ActivityModule_ProvidesRetrofitAptoideBiServiceFactory(ActivityModule module2, Provider<Service> serviceProvider2, Provider<String> packageNameProvider2, Provider<String> storeNameProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.serviceProvider = serviceProvider2;
        this.packageNameProvider = packageNameProvider2;
        this.storeNameProvider = storeNameProvider2;
        $jacocoInit[0] = true;
    }

    public AutoUpdateService get() {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule activityModule = this.module;
        Provider<Service> provider = this.serviceProvider;
        $jacocoInit[1] = true;
        Service service = (Service) provider.get();
        String str = (String) this.packageNameProvider.get();
        String str2 = (String) this.storeNameProvider.get();
        $jacocoInit[2] = true;
        AutoUpdateService providesRetrofitAptoideBiService = activityModule.providesRetrofitAptoideBiService(service, str, str2);
        $jacocoInit[3] = true;
        C13182c.m43111a(providesRetrofitAptoideBiService, "Cannot return null from a non-@Nullable @Provides method");
        AutoUpdateService autoUpdateService = providesRetrofitAptoideBiService;
        $jacocoInit[4] = true;
        return autoUpdateService;
    }

    public static C13181b<AutoUpdateService> create(ActivityModule module2, Provider<Service> serviceProvider2, Provider<String> packageNameProvider2, Provider<String> storeNameProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ActivityModule_ProvidesRetrofitAptoideBiServiceFactory activityModule_ProvidesRetrofitAptoideBiServiceFactory = new ActivityModule_ProvidesRetrofitAptoideBiServiceFactory(module2, serviceProvider2, packageNameProvider2, storeNameProvider2);
        $jacocoInit[5] = true;
        return activityModule_ProvidesRetrofitAptoideBiServiceFactory;
    }

    public static AutoUpdateService proxyProvidesRetrofitAptoideBiService(ActivityModule instance, Service service, String packageName, String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        AutoUpdateService providesRetrofitAptoideBiService = instance.providesRetrofitAptoideBiService(service, packageName, storeName);
        $jacocoInit[6] = true;
        return providesRetrofitAptoideBiService;
    }
}
