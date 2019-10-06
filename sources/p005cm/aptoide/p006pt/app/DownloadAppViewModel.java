package p005cm.aptoide.p006pt.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.view.AppCoinsViewModel;

/* renamed from: cm.aptoide.pt.app.DownloadAppViewModel */
public class DownloadAppViewModel {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AppCoinsViewModel appCoinsViewModel;
    private final DownloadModel downloadModel;
    private SimilarAppsViewModel similarAppcAppsViewModel;
    private SimilarAppsViewModel similarAppsViewModel;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(79296715752157649L, "cm/aptoide/pt/app/DownloadAppViewModel", 14);
        $jacocoData = probes;
        return probes;
    }

    public DownloadAppViewModel(DownloadModel downloadModel2, SimilarAppsViewModel similarAppsViewModel2, SimilarAppsViewModel similarAppcAppsViewModel2, AppCoinsViewModel appCoinsViewModel2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadModel = downloadModel2;
        this.similarAppsViewModel = similarAppsViewModel2;
        this.appCoinsViewModel = appCoinsViewModel2;
        this.similarAppcAppsViewModel = similarAppcAppsViewModel2;
        $jacocoInit[0] = true;
    }

    public AppCoinsViewModel getAppCoinsViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.appCoinsViewModel != null) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            this.appCoinsViewModel = new AppCoinsViewModel();
            $jacocoInit[3] = true;
        }
        AppCoinsViewModel appCoinsViewModel2 = this.appCoinsViewModel;
        $jacocoInit[4] = true;
        return appCoinsViewModel2;
    }

    public SimilarAppsViewModel getSimilarAppsViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.similarAppsViewModel != null) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            this.similarAppsViewModel = new SimilarAppsViewModel();
            $jacocoInit[7] = true;
        }
        SimilarAppsViewModel similarAppsViewModel2 = this.similarAppsViewModel;
        $jacocoInit[8] = true;
        return similarAppsViewModel2;
    }

    public DownloadModel getDownloadModel() {
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel2 = this.downloadModel;
        $jacocoInit[9] = true;
        return downloadModel2;
    }

    public SimilarAppsViewModel getSimilarAppcAppsViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.similarAppcAppsViewModel != null) {
            $jacocoInit[10] = true;
        } else {
            $jacocoInit[11] = true;
            this.similarAppcAppsViewModel = new SimilarAppsViewModel();
            $jacocoInit[12] = true;
        }
        SimilarAppsViewModel similarAppsViewModel2 = this.similarAppcAppsViewModel;
        $jacocoInit[13] = true;
        return similarAppsViewModel2;
    }
}
