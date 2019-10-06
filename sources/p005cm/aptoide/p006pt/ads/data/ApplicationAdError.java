package p005cm.aptoide.p006pt.ads.data;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.app.AppsList.Error;

/* renamed from: cm.aptoide.pt.ads.data.ApplicationAdError */
public class ApplicationAdError {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Error minimalAdError;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3692998168152207357L, "cm/aptoide/pt/ads/data/ApplicationAdError", 6);
        $jacocoData = probes;
        return probes;
    }

    public ApplicationAdError(Error minimalAdError2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.minimalAdError = minimalAdError2;
        $jacocoInit[0] = true;
    }

    public boolean hasError() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.minimalAdError != null) {
            $jacocoInit[1] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[2] = true;
        }
        $jacocoInit[3] = true;
        return z;
    }

    public String getErrorMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        Error error = this.minimalAdError;
        if (error != null) {
            String name = error.name();
            $jacocoInit[4] = true;
            return name;
        }
        $jacocoInit[5] = true;
        return null;
    }
}
