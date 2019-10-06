package p005cm.aptoide.p006pt.view.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.view.app.AppCenter */
public class AppCenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AppCenterRepository appCenterRepository;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(429222972578929289L, "cm/aptoide/pt/view/app/AppCenter", 10);
        $jacocoData = probes;
        return probes;
    }

    public AppCenter(AppCenterRepository appRepository) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appCenterRepository = appRepository;
        $jacocoInit[0] = true;
    }

    public Single<AppsList> loadNextApps(long storeId, int limit) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<AppsList> loadNextApps = this.appCenterRepository.loadNextApps(storeId, limit);
        $jacocoInit[1] = true;
        return loadNextApps;
    }

    public Single<AppsList> loadFreshApps(long storeId, int limit) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<AppsList> loadFreshApps = this.appCenterRepository.loadFreshApps(storeId, limit);
        $jacocoInit[2] = true;
        return loadFreshApps;
    }

    public Single<AppsList> getApps(long storeId, int limit) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<AppsList> applications = this.appCenterRepository.getApplications(storeId, limit);
        $jacocoInit[3] = true;
        return applications;
    }

    public Single<DetailedAppRequestResult> loadDetailedApp(long appId, String storeName, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<DetailedAppRequestResult> loadDetailedApp = this.appCenterRepository.loadDetailedApp(appId, storeName, packageName);
        $jacocoInit[4] = true;
        return loadDetailedApp;
    }

    public Single<DetailedAppRequestResult> loadDetailedApp(String packageName, String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<DetailedAppRequestResult> loadDetailedApp = this.appCenterRepository.loadDetailedApp(packageName, storeName);
        $jacocoInit[5] = true;
        return loadDetailedApp;
    }

    public Single<DetailedAppRequestResult> loadDetailedAppFromMd5(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<DetailedAppRequestResult> loadDetailedAppFromMd5 = this.appCenterRepository.loadDetailedAppFromMd5(md5);
        $jacocoInit[6] = true;
        return loadDetailedAppFromMd5;
    }

    public Single<DetailedAppRequestResult> loadDetailedAppFromUniqueName(String uniqueName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<DetailedAppRequestResult> loadDetailedAppFromUniqueName = this.appCenterRepository.loadDetailedAppFromUniqueName(uniqueName);
        $jacocoInit[7] = true;
        return loadDetailedAppFromUniqueName;
    }

    public Single<AppsList> loadRecommendedApps(int limit, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<AppsList> loadRecommendedApps = this.appCenterRepository.loadRecommendedApps(limit, packageName);
        $jacocoInit[8] = true;
        return loadRecommendedApps;
    }

    public Single<AppsList> loadAppcRecommendedApps(int limit, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<AppsList> loadAppcRecommendedApps = this.appCenterRepository.loadAppcRecommendedApps(limit, packageName);
        $jacocoInit[9] = true;
        return loadAppcRecommendedApps;
    }
}
