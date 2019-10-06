package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.wizard.WizardFragmentProvider;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.FlavourFragmentModule_ProvidesWizardFragmentProviderFactory */
public final class FlavourFragmentModule_ProvidesWizardFragmentProviderFactory implements C13181b<WizardFragmentProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FlavourFragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3174328823877678250L, "cm/aptoide/pt/FlavourFragmentModule_ProvidesWizardFragmentProviderFactory", 7);
        $jacocoData = probes;
        return probes;
    }

    public FlavourFragmentModule_ProvidesWizardFragmentProviderFactory(FlavourFragmentModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        $jacocoInit[0] = true;
    }

    public WizardFragmentProvider get() {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourFragmentModule flavourFragmentModule = this.module;
        $jacocoInit[1] = true;
        WizardFragmentProvider providesWizardFragmentProvider = flavourFragmentModule.providesWizardFragmentProvider();
        $jacocoInit[2] = true;
        C13182c.m43111a(providesWizardFragmentProvider, "Cannot return null from a non-@Nullable @Provides method");
        WizardFragmentProvider wizardFragmentProvider = providesWizardFragmentProvider;
        $jacocoInit[3] = true;
        return wizardFragmentProvider;
    }

    public static C13181b<WizardFragmentProvider> create(FlavourFragmentModule module2) {
        boolean[] $jacocoInit = $jacocoInit();
        FlavourFragmentModule_ProvidesWizardFragmentProviderFactory flavourFragmentModule_ProvidesWizardFragmentProviderFactory = new FlavourFragmentModule_ProvidesWizardFragmentProviderFactory(module2);
        $jacocoInit[4] = true;
        return flavourFragmentModule_ProvidesWizardFragmentProviderFactory;
    }

    public static WizardFragmentProvider proxyProvidesWizardFragmentProvider(FlavourFragmentModule instance) {
        boolean[] $jacocoInit = $jacocoInit();
        WizardFragmentProvider providesWizardFragmentProvider = instance.providesWizardFragmentProvider();
        $jacocoInit[5] = true;
        return providesWizardFragmentProvider;
    }
}
