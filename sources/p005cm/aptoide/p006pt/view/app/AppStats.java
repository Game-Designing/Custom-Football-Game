package p005cm.aptoide.p006pt.view.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.app.AppStats */
public class AppStats {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final int downloads;
    private final AppRating globalRating;
    private final int packageDownloads;
    private final AppRating rating;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-881966755224263737L, "cm/aptoide/pt/view/app/AppStats", 5);
        $jacocoData = probes;
        return probes;
    }

    public AppStats(AppRating rating2, AppRating globalRating2, int downloads2, int packageDownloads2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.rating = rating2;
        this.globalRating = globalRating2;
        this.downloads = downloads2;
        this.packageDownloads = packageDownloads2;
        $jacocoInit[0] = true;
    }

    public AppRating getRating() {
        boolean[] $jacocoInit = $jacocoInit();
        AppRating appRating = this.rating;
        $jacocoInit[1] = true;
        return appRating;
    }

    public AppRating getGlobalRating() {
        boolean[] $jacocoInit = $jacocoInit();
        AppRating appRating = this.globalRating;
        $jacocoInit[2] = true;
        return appRating;
    }

    public int getDownloads() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.downloads;
        $jacocoInit[3] = true;
        return i;
    }

    public int getPackageDownloads() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.packageDownloads;
        $jacocoInit[4] = true;
        return i;
    }
}
