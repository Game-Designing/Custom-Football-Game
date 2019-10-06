package p005cm.aptoide.p006pt.account.view.store;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.navigator.Result;

/* renamed from: cm.aptoide.pt.account.view.store.ManageStoreNavigator */
public class ManageStoreNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BottomNavigationNavigator bottomNavigationNavigator;
    private final FragmentNavigator fragmentNavigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6293918084886327355L, "cm/aptoide/pt/account/view/store/ManageStoreNavigator", 5);
        $jacocoData = probes;
        return probes;
    }

    public ManageStoreNavigator(FragmentNavigator fragmentNavigator2, BottomNavigationNavigator bottomNavigationNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator = fragmentNavigator2;
        this.bottomNavigationNavigator = bottomNavigationNavigator2;
        $jacocoInit[0] = true;
    }

    public void goToHome() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationNavigator.navigateToHome();
        $jacocoInit[1] = true;
    }

    public void popViewWithResult(int requestCode, boolean success) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator2 = this.fragmentNavigator;
        if (success) {
            i = -1;
            $jacocoInit[2] = true;
        } else {
            i = 0;
            $jacocoInit[3] = true;
        }
        fragmentNavigator2.popWithResult(new Result(requestCode, i, null));
        $jacocoInit[4] = true;
    }
}
