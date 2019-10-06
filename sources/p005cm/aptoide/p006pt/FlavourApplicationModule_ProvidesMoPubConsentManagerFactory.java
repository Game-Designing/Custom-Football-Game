package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.MoPubConsentManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.FlavourApplicationModule_ProvidesMoPubConsentManagerFactory */
public final class FlavourApplicationModule_ProvidesMoPubConsentManagerFactory implements C13181b<MoPubConsentManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FlavourApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2975948362121750335L, "cm/aptoide/pt/FlavourApplicationModule_ProvidesMoPubConsentManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FlavourApplicationModule_ProvidesMoPubConsentManagerFactory(FlavourApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public MoPubConsentManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule flavourApplicationModule = this.module;
        $jacocoInit[1] = true;
        MoPubConsentManager providesMoPubConsentManager = flavourApplicationModule.providesMoPubConsentManager();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesMoPubConsentManager, "Cannot return null from a non-@Nullable @Provides method");
        MoPubConsentManager moPubConsentManager = providesMoPubConsentManager;
        $jacocoInit[3] = true;
        return moPubConsentManager;
    }

    public static C13181b<MoPubConsentManager> create(FlavourApplicationModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule_ProvidesMoPubConsentManagerFactory flavourApplicationModule_ProvidesMoPubConsentManagerFactory = new FlavourApplicationModule_ProvidesMoPubConsentManagerFactory(module2);
        $jacocoInit[4] = true;
        return flavourApplicationModule_ProvidesMoPubConsentManagerFactory;
    }

    public static MoPubConsentManager proxyProvidesMoPubConsentManager(FlavourApplicationModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        MoPubConsentManager providesMoPubConsentManager = instance.providesMoPubConsentManager();
        $jacocoInit[5] = true;
        return providesMoPubConsentManager;
    }
}
