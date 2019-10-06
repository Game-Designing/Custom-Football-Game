package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.view.donations.DonationsService.ServiceV8;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.Retrofit;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesDonationsServiceV8Factory */
public final class ApplicationModule_ProvidesDonationsServiceV8Factory implements C13181b<ServiceV8> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<Retrofit> retrofitProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-248167738518587713L, "cm/aptoide/pt/ApplicationModule_ProvidesDonationsServiceV8Factory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesDonationsServiceV8Factory(ApplicationModule module2, Provider<Retrofit> retrofitProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.retrofitProvider = retrofitProvider2;
        $jacocoInit[0] = true;
    }

    public ServiceV8 get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        Provider<Retrofit> provider = this.retrofitProvider;
        $jacocoInit[1] = true;
        ServiceV8 providesDonationsServiceV8 = applicationModule.providesDonationsServiceV8((Retrofit) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesDonationsServiceV8, "Cannot return null from a non-@Nullable @Provides method");
        ServiceV8 serviceV8 = providesDonationsServiceV8;
        $jacocoInit[3] = true;
        return serviceV8;
    }

    public static C13181b<ServiceV8> create(ApplicationModule module2, Provider<Retrofit> retrofitProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesDonationsServiceV8Factory applicationModule_ProvidesDonationsServiceV8Factory = new ApplicationModule_ProvidesDonationsServiceV8Factory(module2, retrofitProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesDonationsServiceV8Factory;
    }

    public static ServiceV8 proxyProvidesDonationsServiceV8(ApplicationModule instance, Retrofit retrofit) {
        boolean[] $jacocoInit = $jacocoInit();
        ServiceV8 providesDonationsServiceV8 = instance.providesDonationsServiceV8(retrofit);
        $jacocoInit[5] = true;
        return providesDonationsServiceV8;
    }
}
