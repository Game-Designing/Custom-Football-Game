package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.MoPubConsentDialogManager;
import p005cm.aptoide.p006pt.ads.MoPubConsentManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.FlavourApplicationModule_ProvidesMoPubConsentDialogManagerFactory */
public final class C1368x7c0fea2a implements C13181b<MoPubConsentDialogManager> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<MoPubConsentManager> moPubConsentManagerProvider;
    private final FlavourApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2101339294231058361L, "cm/aptoide/pt/FlavourApplicationModule_ProvidesMoPubConsentDialogManagerFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public C1368x7c0fea2a(FlavourApplicationModule module2, Provider<MoPubConsentManager> moPubConsentManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.moPubConsentManagerProvider = moPubConsentManagerProvider2;
        $jacocoInit[0] = true;
    }

    public MoPubConsentDialogManager get() {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule flavourApplicationModule = this.module;
        Provider<MoPubConsentManager> provider = this.moPubConsentManagerProvider;
        $jacocoInit[1] = true;
        MoPubConsentDialogManager providesMoPubConsentDialogManager = flavourApplicationModule.providesMoPubConsentDialogManager((MoPubConsentManager) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesMoPubConsentDialogManager, "Cannot return null from a non-@Nullable @Provides method");
        MoPubConsentDialogManager moPubConsentDialogManager = providesMoPubConsentDialogManager;
        $jacocoInit[3] = true;
        return moPubConsentDialogManager;
    }

    public static C13181b<MoPubConsentDialogManager> create(FlavourApplicationModule module2, Provider<MoPubConsentManager> moPubConsentManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        C1368x7c0fea2a flavourApplicationModule_ProvidesMoPubConsentDialogManagerFactory = new C1368x7c0fea2a(module2, moPubConsentManagerProvider2);
        $jacocoInit[4] = true;
        return flavourApplicationModule_ProvidesMoPubConsentDialogManagerFactory;
    }

    public static MoPubConsentDialogManager proxyProvidesMoPubConsentDialogManager(FlavourApplicationModule instance, MoPubConsentManager moPubConsentManager) {
        boolean[] $jacocoInit = $jacocoInit();
        MoPubConsentDialogManager providesMoPubConsentDialogManager = instance.providesMoPubConsentDialogManager(moPubConsentManager);
        $jacocoInit[5] = true;
        return providesMoPubConsentDialogManager;
    }
}
