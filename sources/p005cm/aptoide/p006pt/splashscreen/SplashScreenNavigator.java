package p005cm.aptoide.p006pt.splashscreen;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationNavigator;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.view.splashscreen.SplashScreenFragment;

/* renamed from: cm.aptoide.pt.splashscreen.SplashScreenNavigator */
public class SplashScreenNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private BottomNavigationNavigator bottomNavigationNavigator;
    private FragmentNavigator fragmentNavigator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1335368718208266041L, "cm/aptoide/pt/splashscreen/SplashScreenNavigator", 3);
        $jacocoData = probes;
        return probes;
    }

    public SplashScreenNavigator(BottomNavigationNavigator bottomNavigationNavigator2, FragmentNavigator fragmentNavigator2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationNavigator = bottomNavigationNavigator2;
        this.fragmentNavigator = fragmentNavigator2;
        $jacocoInit[0] = true;
    }

    public void navigateToSplashScreen() {
        boolean[] $jacocoInit = $jacocoInit();
        this.fragmentNavigator.navigateTo(new SplashScreenFragment(), true);
        $jacocoInit[1] = true;
    }

    public void navigateToHome() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationNavigator.navigateToHome();
        $jacocoInit[2] = true;
    }
}
