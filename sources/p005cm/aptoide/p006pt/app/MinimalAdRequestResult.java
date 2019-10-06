package p005cm.aptoide.p006pt.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd;
import p005cm.aptoide.p006pt.ads.data.ApplicationAdError;
import p005cm.aptoide.p006pt.ads.data.AptoideNativeAd;
import p005cm.aptoide.p006pt.database.realm.MinimalAd;
import p005cm.aptoide.p006pt.view.app.AppsList.Error;

/* renamed from: cm.aptoide.pt.app.MinimalAdRequestResult */
public class MinimalAdRequestResult implements ApplicationAdResult {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Error error;
    private final MinimalAd minimalAd;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1165828856233336081L, "cm/aptoide/pt/app/MinimalAdRequestResult", 7);
        $jacocoData = probes;
        return probes;
    }

    public MinimalAdRequestResult(MinimalAd minimalAd2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.minimalAd = minimalAd2;
        this.error = null;
        $jacocoInit[0] = true;
    }

    public MinimalAdRequestResult(Error error2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.minimalAd = null;
        this.error = error2;
        $jacocoInit[1] = true;
    }

    public MinimalAd getMinimalAd() {
        boolean[] $jacocoInit = $jacocoInit();
        MinimalAd minimalAd2 = this.minimalAd;
        $jacocoInit[2] = true;
        return minimalAd2;
    }

    public ApplicationAd getAd() {
        boolean[] $jacocoInit = $jacocoInit();
        MinimalAd minimalAd2 = this.minimalAd;
        if (minimalAd2 == null) {
            $jacocoInit[3] = true;
            return null;
        }
        AptoideNativeAd aptoideNativeAd = new AptoideNativeAd(minimalAd2);
        $jacocoInit[4] = true;
        return aptoideNativeAd;
    }

    public ApplicationAdError getError() {
        boolean[] $jacocoInit = $jacocoInit();
        Error error2 = this.error;
        if (error2 == null) {
            $jacocoInit[5] = true;
            return null;
        }
        ApplicationAdError applicationAdError = new ApplicationAdError(error2);
        $jacocoInit[6] = true;
        return applicationAdError;
    }
}
