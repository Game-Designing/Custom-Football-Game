package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.FragmentScope;
import p005cm.aptoide.p006pt.view.wizard.WizardFragmentProvider;

/* renamed from: cm.aptoide.pt.FlavourFragmentModule */
public class FlavourFragmentModule {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6470250106735316309L, "cm/aptoide/pt/FlavourFragmentModule", 2);
        $jacocoData = probes;
        return probes;
    }

    public FlavourFragmentModule() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: 0000 */
    @FragmentScope
    public WizardFragmentProvider providesWizardFragmentProvider() {
        boolean[] $jacocoInit = $jacocoInit();
        WizardFragmentProvider wizardFragmentProvider = new WizardFragmentProvider();
        $jacocoInit[1] = true;
        return wizardFragmentProvider;
    }
}
