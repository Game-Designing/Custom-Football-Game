package p005cm.aptoide.p006pt.account.view.user;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;

/* renamed from: cm.aptoide.pt.account.view.user.ManageUserNavigator */
public class ManageUserNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BottomNavigationNavigator bottomNavigationNavigator;
    private final FragmentNavigator navigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3147232407412016495L, "cm/aptoide/pt/account/view/user/ManageUserNavigator", 5);
        $jacocoData = probes;
        return probes;
    }

    public ManageUserNavigator(FragmentNavigator navigator2, BottomNavigationNavigator bottomNavigationNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator = navigator2;
        this.bottomNavigationNavigator = bottomNavigationNavigator2;
        $jacocoInit[0] = true;
    }

    public void toProfileStepOne() {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.cleanBackStack();
        $jacocoInit[1] = true;
        this.navigator.navigateTo(ProfileStepOneFragment.newInstance(), true);
        $jacocoInit[2] = true;
    }

    public void goToHome() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationNavigator.navigateToHome();
        $jacocoInit[3] = true;
    }

    public void goBack() {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigator.popBackStack();
        $jacocoInit[4] = true;
    }
}
