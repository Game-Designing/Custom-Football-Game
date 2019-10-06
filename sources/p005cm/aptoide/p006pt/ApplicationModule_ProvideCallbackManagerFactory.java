package p005cm.aptoide.p006pt;

import com.facebook.C6666i;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.ApplicationModule_ProvideCallbackManagerFactory */
public final class ApplicationModule_ProvideCallbackManagerFactory implements C13181b<C6666i> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3863180124904620720L, "cm/aptoide/pt/ApplicationModule_ProvideCallbackManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationModule_ProvideCallbackManagerFactory(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public C6666i get() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule applicationModule = this.module;
        $jacocoInit[1] = true;
        C6666i provideCallbackManager = applicationModule.provideCallbackManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(provideCallbackManager, "Cannot return null from a non-@Nullable @Provides method");
        C6666i iVar = provideCallbackManager;
        $jacocoInit[3] = true;
        return iVar;
    }

    public static C13181b<C6666i> create(ApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationModule_ProvideCallbackManagerFactory applicationModule_ProvideCallbackManagerFactory = new ApplicationModule_ProvideCallbackManagerFactory(module2);
        $jacocoInit[4] = true;
        return applicationModule_ProvideCallbackManagerFactory;
    }

    public static C6666i proxyProvideCallbackManager(ApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        C6666i provideCallbackManager = instance.provideCallbackManager();
        $jacocoInit[5] = true;
        return provideCallbackManager;
    }
}
