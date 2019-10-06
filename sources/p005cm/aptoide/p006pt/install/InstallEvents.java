package p005cm.aptoide.p006pt.install;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;
import p005cm.aptoide.p006pt.packageinstaller.InstallStatus.Status;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.root.RootAvailabilityManager;
import p026rx.Single;
import p026rx.p401g.C14959b;

/* renamed from: cm.aptoide.pt.install.InstallEvents */
public class InstallEvents implements InstallerAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String CONCAT = "CONCAT";
    private static final String INSTALLFABRICCONTEXT = "Install_Fabric_Event";
    public static final String IS_INSTALLATION_TYPE_EVENT_NAME = "INSTALLATION_TYPE";
    private static final String IS_ROOT = "IS_ROOT";
    public static final String MIUI_INSTALLATION_ABOVE_20_EVENT_NAME = "MIUI_Installation_Above_20";
    public static final String ROOT_V2_COMPLETE = "Root_v2_Complete";
    public static final String ROOT_V2_START = "Root_v2_Start";
    private static final String SETTING_ROOT = "SETTING_ROOT";
    private final AnalyticsManager analyticsManager;
    private final InstallAnalytics installAnalytics;
    private final NavigationTracker navigationTracker;
    private final RootAvailabilityManager rootAvailabilityManager;
    private final SharedPreferences sharedPreferences;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2674276114496718048L, "cm/aptoide/pt/install/InstallEvents", 36);
        $jacocoData = probes;
        return probes;
    }

    public InstallEvents(AnalyticsManager analyticsManager2, InstallAnalytics installAnalytics2, SharedPreferences sharedPreferences2, RootAvailabilityManager rootAvailabilityManager2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManager = analyticsManager2;
        this.installAnalytics = installAnalytics2;
        this.sharedPreferences = sharedPreferences2;
        this.rootAvailabilityManager = rootAvailabilityManager2;
        this.navigationTracker = navigationTracker2;
        $jacocoInit[0] = true;
    }

    public void rootInstallCompleted(int exitcode) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> attributes = new HashMap<>();
        $jacocoInit[1] = true;
        attributes.put("Result", RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION);
        $jacocoInit[2] = true;
        attributes.put("Exit_Code", String.valueOf(exitcode));
        $jacocoInit[3] = true;
        this.analyticsManager.logEvent(attributes, ROOT_V2_COMPLETE, Action.ROOT, INSTALLFABRICCONTEXT);
        $jacocoInit[4] = true;
    }

    public void rootInstallTimeout() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> attributes = new HashMap<>();
        $jacocoInit[5] = true;
        attributes.put("Result", "timeout");
        $jacocoInit[6] = true;
        this.analyticsManager.logEvent(attributes, ROOT_V2_COMPLETE, Action.ROOT, INSTALLFABRICCONTEXT);
        $jacocoInit[7] = true;
    }

    public void rootInstallFail(Exception e) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> attributes = new HashMap<>();
        $jacocoInit[8] = true;
        attributes.put("Result", "fail");
        $jacocoInit[9] = true;
        attributes.put("Error", e.getMessage());
        $jacocoInit[10] = true;
        this.analyticsManager.logEvent(attributes, ROOT_V2_COMPLETE, Action.ROOT, INSTALLFABRICCONTEXT);
        $jacocoInit[11] = true;
    }

    public void rootInstallCancelled() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> attributes = new HashMap<>();
        $jacocoInit[12] = true;
        attributes.put("Result", "cancel");
        $jacocoInit[13] = true;
        this.analyticsManager.logEvent(attributes, ROOT_V2_COMPLETE, Action.ROOT, INSTALLFABRICCONTEXT);
        $jacocoInit[14] = true;
    }

    public void rootInstallStart() {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManager.logEvent(null, ROOT_V2_START, Action.ROOT, INSTALLFABRICCONTEXT);
        $jacocoInit[15] = true;
    }

    public void installationType(boolean isRootAllowed, boolean isRoot) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[16] = true;
        map.put(IS_ROOT, String.valueOf(isRoot));
        $jacocoInit[17] = true;
        map.put(SETTING_ROOT, String.valueOf(isRootAllowed));
        $jacocoInit[18] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(isRootAllowed);
        sb.append("_");
        sb.append(isRoot);
        map.put(CONCAT, sb.toString());
        $jacocoInit[19] = true;
        this.analyticsManager.logEvent(map, IS_INSTALLATION_TYPE_EVENT_NAME, Action.ROOT, INSTALLFABRICCONTEXT);
        $jacocoInit[20] = true;
    }

    public void logInstallErrorEvent(String packageName, int versionCode, Exception e) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallAnalytics installAnalytics2 = this.installAnalytics;
        RootAvailabilityManager rootAvailabilityManager2 = this.rootAvailabilityManager;
        $jacocoInit[21] = true;
        Single isRootAvailable = rootAvailabilityManager2.isRootAvailable();
        $jacocoInit[22] = true;
        C14959b a = isRootAvailable.mo3689a();
        $jacocoInit[23] = true;
        boolean booleanValue = ((Boolean) a.mo46175a()).booleanValue();
        boolean allowRootInstallation = ManagerPreferences.allowRootInstallation(this.sharedPreferences);
        $jacocoInit[24] = true;
        installAnalytics2.logInstallErrorEvent(packageName, versionCode, e, booleanValue, allowRootInstallation);
        $jacocoInit[25] = true;
    }

    public void logInstallCancelEvent(String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        this.installAnalytics.logInstallCancelEvent(packageName, versionCode);
        $jacocoInit[26] = true;
    }

    public void sendMiuiInstallResultEvent(Status status) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> parameters = new HashMap<>();
        String key = "successful_installation_type";
        $jacocoInit[27] = true;
        if (status.equals(Status.SUCCESS)) {
            $jacocoInit[28] = true;
            parameters.put(key, "split_install");
            $jacocoInit[29] = true;
        } else if (!status.equals(Status.FAIL)) {
            $jacocoInit[30] = true;
        } else {
            $jacocoInit[31] = true;
            parameters.put(key, "default_install");
            $jacocoInit[32] = true;
        }
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = Action.INSTALL;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[33] = true;
        String viewName = navigationTracker2.getViewName(false);
        $jacocoInit[34] = true;
        analyticsManager2.logEvent(parameters, MIUI_INSTALLATION_ABOVE_20_EVENT_NAME, action, viewName);
        $jacocoInit[35] = true;
    }
}
