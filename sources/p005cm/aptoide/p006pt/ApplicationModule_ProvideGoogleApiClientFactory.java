package p005cm.aptoide.p006pt;

import com.google.android.gms.common.api.GoogleApiClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideGoogleApiClientFactory */
public final class ApplicationModule_ProvideGoogleApiClientFactory implements C13181b<GoogleApiClient> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(360161482390579986L, "cm/aptoide/pt/ApplicationModule_ProvideGoogleApiClientFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideGoogleApiClientFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public GoogleApiClient get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        GoogleApiClient provideGoogleApiClient = applicationModule.provideGoogleApiClient();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideGoogleApiClient, "Cannot return null from a non-@Nullable @Provides method");
        GoogleApiClient googleApiClient = provideGoogleApiClient;
        $jacocoInit[3] = true;
        return googleApiClient;
    }

    public static C13181b<GoogleApiClient> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideGoogleApiClientFactory applicationModule_ProvideGoogleApiClientFactory = new ApplicationModule_ProvideGoogleApiClientFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideGoogleApiClientFactory;
    }

    public static GoogleApiClient proxyProvideGoogleApiClient(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        GoogleApiClient provideGoogleApiClient = instance.provideGoogleApiClient();
        $jacocoInit[5] = true;
        return provideGoogleApiClient;
    }
}
