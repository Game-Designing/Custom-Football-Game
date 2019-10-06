package p005cm.aptoide.p006pt.home.apps;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.home.apps.AppClickEventWrapper */
public class AppClickEventWrapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private App app;
    private boolean isAppcUpgrade;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2637024766243109962L, "cm/aptoide/pt/home/apps/AppClickEventWrapper", 3);
        $jacocoData = probes;
        return probes;
    }

    public AppClickEventWrapper(boolean isAppcUpgrade2, App app2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.isAppcUpgrade = isAppcUpgrade2;
        this.app = app2;
        $jacocoInit[0] = true;
    }

    public boolean isAppcUpgrade() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isAppcUpgrade;
        $jacocoInit[1] = true;
        return z;
    }

    public App getApp() {
        boolean[] $jacocoInit = $jacocoInit();
        App app2 = this.app;
        $jacocoInit[2] = true;
        return app2;
    }
}
