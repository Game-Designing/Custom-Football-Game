package p005cm.aptoide.p006pt.splashscreen;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.splashscreen.SplashScreenManager */
public class SplashScreenManager {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3690957314962947894L, "cm/aptoide/pt/splashscreen/SplashScreenManager", 2);
        $jacocoData = probes;
        return probes;
    }

    public SplashScreenManager() {
        $jacocoInit()[0] = true;
    }

    public boolean shouldShowSplashScreen() {
        $jacocoInit()[1] = true;
        return false;
    }
}
