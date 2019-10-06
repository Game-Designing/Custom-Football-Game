package p005cm.aptoide.p006pt.view.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.app.DetailedAppRequestResult */
public class DetailedAppRequestResult {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final DetailedApp detailedApp;
    private final Error error;
    private final boolean loading;

    /* renamed from: cm.aptoide.pt.view.app.DetailedAppRequestResult$Error */
    public enum Error {
        NETWORK,
        GENERIC;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4970503163314381335L, "cm/aptoide/pt/view/app/DetailedAppRequestResult", 9);
        $jacocoData = probes;
        return probes;
    }

    public DetailedAppRequestResult(Error error2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.detailedApp = null;
        this.loading = false;
        this.error = error2;
        $jacocoInit[0] = true;
    }

    public DetailedAppRequestResult(DetailedApp detailedApp2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.detailedApp = detailedApp2;
        this.loading = false;
        this.error = null;
        $jacocoInit[1] = true;
    }

    public DetailedAppRequestResult(boolean loading2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.detailedApp = null;
        this.loading = loading2;
        this.error = null;
        $jacocoInit[2] = true;
    }

    public DetailedApp getDetailedApp() {
        boolean[] $jacocoInit = $jacocoInit();
        DetailedApp detailedApp2 = this.detailedApp;
        $jacocoInit[3] = true;
        return detailedApp2;
    }

    public boolean isLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.loading;
        $jacocoInit[4] = true;
        return z;
    }

    public boolean hasError() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.error != null) {
            $jacocoInit[5] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[6] = true;
        }
        $jacocoInit[7] = true;
        return z;
    }

    public Error getError() {
        boolean[] $jacocoInit = $jacocoInit();
        Error error2 = this.error;
        $jacocoInit[8] = true;
        return error2;
    }
}
