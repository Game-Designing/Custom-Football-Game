package p005cm.aptoide.p006pt.view.wizard;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.view.LoginSignUpFragment;
import p005cm.aptoide.p006pt.view.fragment.NavigationTrackFragment;

/* renamed from: cm.aptoide.pt.view.wizard.WizardFragmentProvider */
public class WizardFragmentProvider {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int WIZARD_LOGIN_POSITION = 2;
    private static final int WIZARD_STEP_ONE_POSITION = 0;
    private static final int WIZARD_STEP_TWO_POSITION = 1;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4467289161140066579L, "cm/aptoide/pt/view/wizard/WizardFragmentProvider", 15);
        $jacocoData = probes;
        return probes;
    }

    public WizardFragmentProvider() {
        $jacocoInit()[0] = true;
    }

    public Fragment getItem(int position) {
        Fragment fragment;
        boolean[] $jacocoInit = $jacocoInit();
        if (position == 0) {
            fragment = WizardPageOneFragment.newInstance();
            $jacocoInit[1] = true;
        } else if (position == 1) {
            Fragment fragment2 = WizardPageTwoFragment.newInstance();
            $jacocoInit[2] = true;
            fragment = fragment2;
        } else if (position == 2) {
            fragment = LoginSignUpFragment.newInstance(true, false, true, true);
            $jacocoInit[3] = true;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid wizard fragment position: ");
            sb.append(position);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sb.toString());
            $jacocoInit[4] = true;
            throw illegalArgumentException;
        }
        Fragment fragment3 = setFragmentLogFlag(fragment);
        $jacocoInit[5] = true;
        return fragment3;
    }

    public int getCount(Boolean isLoggedIn) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isLoggedIn.booleanValue()) {
            $jacocoInit[6] = true;
            return 2;
        }
        $jacocoInit[7] = true;
        return 3;
    }

    private Fragment setFragmentLogFlag(Fragment fragment) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle bundle = fragment.getArguments();
        if (bundle != null) {
            $jacocoInit[8] = true;
        } else {
            $jacocoInit[9] = true;
            bundle = new Bundle();
            $jacocoInit[10] = true;
        }
        bundle.putBoolean(NavigationTrackFragment.SHOULD_REGISTER_VIEW, false);
        $jacocoInit[11] = true;
        fragment.setArguments(bundle);
        $jacocoInit[12] = true;
        return fragment;
    }

    public Integer[] getTransitionColors() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[13] = true;
        Integer[] numArr = {Integer.valueOf(C1375R.color.wizard_color_1_blue), Integer.valueOf(C1375R.color.wizard_color_2_green), Integer.valueOf(C1375R.color.wizard_color_3_orange)};
        $jacocoInit[14] = true;
        return numArr;
    }
}
