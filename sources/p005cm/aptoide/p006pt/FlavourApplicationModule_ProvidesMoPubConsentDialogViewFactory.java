package p005cm.aptoide.p006pt;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.MoPubConsentDialogView;
import p005cm.aptoide.p006pt.ads.MoPubConsentManager;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.FlavourApplicationModule_ProvidesMoPubConsentDialogViewFactory */
public final class FlavourApplicationModule_ProvidesMoPubConsentDialogViewFactory implements C13181b<MoPubConsentDialogView> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<MoPubConsentManager> moPubConsentManagerProvider;
    private final FlavourApplicationModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6217797183304140997L, "cm/aptoide/pt/FlavourApplicationModule_ProvidesMoPubConsentDialogViewFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FlavourApplicationModule_ProvidesMoPubConsentDialogViewFactory(FlavourApplicationModule module2, Provider<MoPubConsentManager> moPubConsentManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.moPubConsentManagerProvider = moPubConsentManagerProvider2;
        $jacocoInit[0] = true;
    }

    public MoPubConsentDialogView get() {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule flavourApplicationModule = this.module;
        Provider<MoPubConsentManager> provider = this.moPubConsentManagerProvider;
        $jacocoInit[1] = true;
        MoPubConsentDialogView providesMoPubConsentDialogView = flavourApplicationModule.providesMoPubConsentDialogView((MoPubConsentManager) provider.get());
        $jacocoInit[2] = true;
        C13182c.m43111a(providesMoPubConsentDialogView, "Cannot return null from a non-@Nullable @Provides method");
        MoPubConsentDialogView moPubConsentDialogView = providesMoPubConsentDialogView;
        $jacocoInit[3] = true;
        return moPubConsentDialogView;
    }

    public static C13181b<MoPubConsentDialogView> create(FlavourApplicationModule module2, Provider<MoPubConsentManager> moPubConsentManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourApplicationModule_ProvidesMoPubConsentDialogViewFactory flavourApplicationModule_ProvidesMoPubConsentDialogViewFactory = new FlavourApplicationModule_ProvidesMoPubConsentDialogViewFactory(module2, moPubConsentManagerProvider2);
        $jacocoInit[4] = true;
        return flavourApplicationModule_ProvidesMoPubConsentDialogViewFactory;
    }

    public static MoPubConsentDialogView proxyProvidesMoPubConsentDialogView(FlavourApplicationModule instance, MoPubConsentManager moPubConsentManager) {
        boolean[] $jacocoInit = $jacocoInit();
        MoPubConsentDialogView providesMoPubConsentDialogView = instance.providesMoPubConsentDialogView(moPubConsentManager);
        $jacocoInit[5] = true;
        return providesMoPubConsentDialogView;
    }
}
