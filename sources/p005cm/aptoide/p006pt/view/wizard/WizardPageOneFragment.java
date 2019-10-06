package p005cm.aptoide.p006pt.view.wizard;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.BackButton.ClickHandler;
import p005cm.aptoide.p006pt.view.BackButtonFragment;

/* renamed from: cm.aptoide.pt.view.wizard.WizardPageOneFragment */
public class WizardPageOneFragment extends BackButtonFragment {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ClickHandler clickHandler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5884598668894369706L, "cm/aptoide/pt/view/wizard/WizardPageOneFragment", 11);
        $jacocoData = probes;
        return probes;
    }

    public WizardPageOneFragment() {
        $jacocoInit()[0] = true;
    }

    public static Fragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        WizardPageOneFragment wizardPageOneFragment = new WizardPageOneFragment();
        $jacocoInit[1] = true;
        return wizardPageOneFragment;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[2] = true;
        this.clickHandler = new ClickHandler(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ WizardPageOneFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(7518545641773827978L, "cm/aptoide/pt/view/wizard/WizardPageOneFragment$1", 2);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public boolean handle() {
                $jacocoInit()[1] = true;
                return false;
            }
        };
        $jacocoInit[3] = true;
        registerClickHandler(this.clickHandler);
        $jacocoInit[4] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[5] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[6] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[7] = true;
        return build;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View inflate = inflater.inflate(C1375R.layout.fragment_wizard_model_page, container, false);
        $jacocoInit[8] = true;
        return inflate;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        unregisterClickHandler(this.clickHandler);
        $jacocoInit[9] = true;
        super.onDestroyView();
        $jacocoInit[10] = true;
    }
}
