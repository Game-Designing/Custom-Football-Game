package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.view.donations.WalletService.ServiceV7;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;
import retrofit2.Retrofit;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesWalletServiceV8Factory */
public final class ApplicationModule_ProvidesWalletServiceV8Factory implements C13181b<ServiceV7> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;
    private final Provider<Retrofit> retrofitProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1670959931087134552L, "cm/aptoide/pt/ApplicationModule_ProvidesWalletServiceV8Factory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesWalletServiceV8Factory(ApplicationModule module2, Provider<Retrofit> retrofitProvider2) {
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
        ServiceV7 providesWalletServiceV8 = applicationModule.providesWalletServiceV8((Retrofit) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesWalletServiceV8, "Cannot return null from a non-@Nullable @Provides method");
        ServiceV7 serviceV7 = providesWalletServiceV8;
        $jacocoInit[3] = true;
        return serviceV7;
    }

    public static C13181b<ServiceV7> create(ApplicationModule module2, Provider<Retrofit> retrofitProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesWalletServiceV8Factory applicationModule_ProvidesWalletServiceV8Factory = new ApplicationModule_ProvidesWalletServiceV8Factory(module2, retrofitProvider2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesWalletServiceV8Factory;
    }

    public static ServiceV7 proxyProvidesWalletServiceV8(ApplicationModule instance, Retrofit retrofit) {
        boolean[] $jacocoInit = $jacocoInit();
        ServiceV7 providesWalletServiceV8 = instance.providesWalletServiceV8(retrofit);
        $jacocoInit[5] = true;
        return providesWalletServiceV8;
    }
}
