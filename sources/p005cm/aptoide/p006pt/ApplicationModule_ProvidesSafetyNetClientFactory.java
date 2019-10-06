package p005cm.aptoide.p006pt;

import com.google.android.gms.safetynet.SafetyNetClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvidesSafetyNetClientFactory */
public final class ApplicationModule_ProvidesSafetyNetClientFactory implements C13181b<SafetyNetClient> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5373154171794054744L, "cm/aptoide/pt/ApplicationModule_ProvidesSafetyNetClientFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvidesSafetyNetClientFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public SafetyNetClient get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        SafetyNetClient providesSafetyNetClient = applicationModule.providesSafetyNetClient();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesSafetyNetClient, "Cannot return null from a non-@Nullable @Provides method");
        SafetyNetClient safetyNetClient = providesSafetyNetClient;
        $jacocoInit[3] = true;
        return safetyNetClient;
    }

    public static C13181b<SafetyNetClient> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvidesSafetyNetClientFactory applicationModule_ProvidesSafetyNetClientFactory = new ApplicationModule_ProvidesSafetyNetClientFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvidesSafetyNetClientFactory;
    }

    public static SafetyNetClient proxyProvidesSafetyNetClient(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        SafetyNetClient providesSafetyNetClient = instance.providesSafetyNetClient();
        $jacocoInit[5] = true;
        return providesSafetyNetClient;
    }
}
