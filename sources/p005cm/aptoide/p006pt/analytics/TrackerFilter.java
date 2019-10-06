package p005cm.aptoide.p006pt.analytics;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ViewNameFilter;
import p005cm.aptoide.p006pt.account.view.LoginSignUpCredentialsFragment;
import p005cm.aptoide.p006pt.store.view.StoreFragment;
import p005cm.aptoide.p006pt.view.wizard.WizardFragment;

/* renamed from: cm.aptoide.pt.analytics.TrackerFilter */
public class TrackerFilter implements ViewNameFilter {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4886750176821270689L, "cm/aptoide/pt/analytics/TrackerFilter", 5);
        $jacocoData = probes;
        return probes;
    }

    public TrackerFilter() {
        $jacocoInit()[0] = true;
    }

    public boolean filter(String viewName) {
        boolean[] $jacocoInit = $jacocoInit();
        if (viewName.equals(WizardFragment.class.getSimpleName())) {
            $jacocoInit[1] = true;
            return false;
        } else if (viewName.equals(LoginSignUpCredentialsFragment.class.getSimpleName())) {
            $jacocoInit[2] = true;
            return false;
        } else if (viewName.equals(StoreFragment.class.getSimpleName())) {
            $jacocoInit[3] = true;
            return false;
        } else {
            $jacocoInit[4] = true;
            return true;
        }
    }
}
