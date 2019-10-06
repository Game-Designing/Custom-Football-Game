package p005cm.aptoide.p006pt.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd.Network;
import p005cm.aptoide.p006pt.view.app.Application;

/* renamed from: cm.aptoide.pt.app.AppViewSimilarApp */
public class AppViewSimilarApp {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: ad */
    private ApplicationAd f4650ad;
    private Application app;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4072257264336298087L, "cm/aptoide/pt/app/AppViewSimilarApp", 11);
        $jacocoData = probes;
        return probes;
    }

    public AppViewSimilarApp(Application app2, ApplicationAd ad) {
        boolean[] $jacocoInit = $jacocoInit();
        this.app = app2;
        this.f4650ad = ad;
        $jacocoInit[0] = true;
    }

    public Application getApp() {
        boolean[] $jacocoInit = $jacocoInit();
        Application application = this.app;
        $jacocoInit[1] = true;
        return application;
    }

    public ApplicationAd getAd() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationAd applicationAd = this.f4650ad;
        $jacocoInit[2] = true;
        return applicationAd;
    }

    public boolean isAd() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.app != null) {
            $jacocoInit[3] = true;
        } else if (this.f4650ad == null) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            z = true;
            $jacocoInit[7] = true;
            return z;
        }
        z = false;
        $jacocoInit[6] = true;
        $jacocoInit[7] = true;
        return z;
    }

    public int getNetworkAdType() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationAd applicationAd = this.f4650ad;
        if (applicationAd == null) {
            $jacocoInit[8] = true;
            return 0;
        }
        Network network = applicationAd.getNetwork();
        $jacocoInit[9] = true;
        int ordinal = network.ordinal();
        $jacocoInit[10] = true;
        return ordinal;
    }
}
