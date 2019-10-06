package p005cm.aptoide.p006pt.download;

import java.util.HashMap;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;

/* renamed from: cm.aptoide.pt.download.AppValidationAnalytics */
public class AppValidationAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String INVALID_DOWNLOAD_PATH_EVENT = "Invalid_Download_Path";
    private final String FILE_TYPE = "File_Type";
    private final String FILE_TYPE_APK = "apk";
    private final String FILE_TYPE_LEVEL = "File_Type_Level";
    private final String FILE_TYPE_LEVEL_ALTERNATIVE = "alternative_download";
    private final String FILE_TYPE_LEVEL_DOWNLOAD_MAIN = "main_download";
    private final String FILE_TYPE_LEVEL_OBB_MAIN = "main_obb";
    private final String FILE_TYPE_LEVEL_OBB_PATCH = "patch_obb";
    private final String FILE_TYPE_OBB = "obb";
    private final String PACKAGE_NAME = "Package_Name";
    private final AnalyticsManager analyticsManager;
    private final NavigationTracker navigationTracker;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7529940101390132126L, "cm/aptoide/pt/download/AppValidationAnalytics", 13);
        $jacocoData = probes;
        return probes;
    }

    public AppValidationAnalytics(AnalyticsManager analyticsManager2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManager = analyticsManager2;
        this.navigationTracker = navigationTracker2;
        $jacocoInit[0] = true;
    }

    public void sendInvalidDownloadMainPath(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        sendInvalidDownloadPathEvent(packageName, "apk", "main_download");
        $jacocoInit[1] = true;
    }

    private void sendInvalidDownloadPathEvent(String packageName, String fileType, String fileTypeLevel) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        HashMap createInvalidPathMap = createInvalidPathMap(packageName, fileType, fileTypeLevel);
        Action action = Action.CLICK;
        $jacocoInit[2] = true;
        String viewName = getViewName(true);
        $jacocoInit[3] = true;
        analyticsManager2.logEvent(createInvalidPathMap, INVALID_DOWNLOAD_PATH_EVENT, action, viewName);
        $jacocoInit[4] = true;
    }

    private String getViewName(boolean current) {
        boolean[] $jacocoInit = $jacocoInit();
        String viewName = this.navigationTracker.getViewName(current);
        $jacocoInit[5] = true;
        return viewName;
    }

    private HashMap<String, Object> createInvalidPathMap(String packageName, String fileType, String fileTypeLevel) {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap<String, Object> map = new HashMap<>();
        $jacocoInit[6] = true;
        map.put("Package_Name", packageName);
        $jacocoInit[7] = true;
        map.put("File_Type", fileType);
        $jacocoInit[8] = true;
        map.put("File_Type_Level", fileTypeLevel);
        $jacocoInit[9] = true;
        return map;
    }

    public void sendInvalidDownloadAlternativePath(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        sendInvalidDownloadPathEvent(packageName, "apk", "alternative_download");
        $jacocoInit[10] = true;
    }

    public void sendInvalidDownloadObbMainPath(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        sendInvalidDownloadPathEvent(packageName, "obb", "main_obb");
        $jacocoInit[11] = true;
    }

    public void sendInvalidDownloadObbPatchPath(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        sendInvalidDownloadPathEvent(packageName, "obb", "patch_obb");
        $jacocoInit[12] = true;
    }
}
