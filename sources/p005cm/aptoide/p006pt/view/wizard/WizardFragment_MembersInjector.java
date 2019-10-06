package p005cm.aptoide.p006pt.view.wizard;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.view.wizard.WizardFragment_MembersInjector */
public final class WizardFragment_MembersInjector implements C13183b<WizardFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<WizardFragmentProvider> wizardFragmentProvider;
    private final Provider<WizardPresenter> wizardPresenterProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3054354657062116991L, "cm/aptoide/pt/view/wizard/WizardFragment_MembersInjector", 7);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((WizardFragment) obj);
        $jacocoInit[6] = true;
    }

    public WizardFragment_MembersInjector(Provider<WizardPresenter> wizardPresenterProvider2, Provider<WizardFragmentProvider> wizardFragmentProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.wizardPresenterProvider = wizardPresenterProvider2;
        this.wizardFragmentProvider = wizardFragmentProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<WizardFragment> create(Provider<WizardPresenter> wizardPresenterProvider2, Provider<WizardFragmentProvider> wizardFragmentProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        WizardFragment_MembersInjector wizardFragment_MembersInjector = new WizardFragment_MembersInjector(wizardPresenterProvider2, wizardFragmentProvider2);
        $jacocoInit[1] = true;
        return wizardFragment_MembersInjector;
    }

    public void injectMembers(WizardFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectWizardPresenter(instance, (WizardPresenter) this.wizardPresenterProvider.get());
        $jacocoInit[2] = true;
        injectWizardFragmentProvider(instance, (WizardFragmentProvider) this.wizardFragmentProvider.get());
        $jacocoInit[3] = true;
    }

    public static void injectWizardPresenter(WizardFragment instance, WizardPresenter wizardPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.wizardPresenter = wizardPresenter;
        $jacocoInit[4] = true;
    }

    public static void injectWizardFragmentProvider(WizardFragment instance, WizardFragmentProvider wizardFragmentProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.wizardFragmentProvider = wizardFragmentProvider2;
        $jacocoInit[5] = true;
    }
}
