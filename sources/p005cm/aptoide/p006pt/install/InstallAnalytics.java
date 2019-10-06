package p005cm.aptoide.p006pt.install;

import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.p006pt.app.AppViewAnalytics;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.download.AppContext;
import p005cm.aptoide.p006pt.download.Origin;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;

/* renamed from: cm.aptoide.pt.install.InstallAnalytics */
public class InstallAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String AB_TEST_GROUP = "ab_test_group";
    private static final String ACTION = "action";
    private static final String APP = "app";
    private static final String APPC = "appc";
    public static final String APPLICATION_INSTALL = "Application Install";
    private static final String CAMPAIGN_ID = "campaign_id";
    private static final String CANCEL = "CANCEL";
    public static final String EDITORS_APPLICATION_INSTALL = "Editors_Choice_Application_Install";
    private static final String EDITORS_CHOICE = "apps-group-editors-choice";
    private static final String FAIL = "FAIL";
    public static final String INSTALL_EVENT_NAME = "INSTALL";
    private static final String MAIN = "MAIN";
    private static final String MESSAGE = "message";
    private static final int MIGRATION_UNINSTALL_KEY = 8726;
    private static final String MIGRATOR = "migrator";
    private static final String NETWORK = "network";
    public static final String NOTIFICATION_APPLICATION_INSTALL = "Aptoide_Push_Notification_Application_Install";
    private static final String NO_PREVIOUS_SCREEN_ERROR = "No_Previous_Screen";
    private static final String OBB = "obb";
    private static final String ORIGIN = "origin";
    private static final String PACKAGE = "package";
    private static final String PATCH = "PATCH";
    private static final String PHONE = "phone";
    private static final String PREVIOUS_CONTEXT = "previous_context";
    private static final String PREVIOUS_TAG = "previous_tag";
    private static final String RESULT = "result";
    private static final String ROOT = "root";
    private static final String SETTINGS = "aptoide_settings";
    private static final String STATUS = "status";
    private static final String STORE = "store";
    private static final String SUCCESS = "SUCC";
    private static final String TELECO = "teleco";
    private static final String TYPE = "type";
    private static final String UPDATE_TO_APPC = "UPDATE TO APPC";
    private static final String URL = "url";
    private final AnalyticsManager analyticsManager;
    private final Map<String, InstallEvent> cache;
    private final ConnectivityManager connectivityManager;
    private final CrashReport crashReport;
    private final NavigationTracker navigationTracker;
    private final TelephonyManager telephonyManager;

    /* renamed from: cm.aptoide.pt.install.InstallAnalytics$1 */
    static /* synthetic */ class C39921 {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(717522410040694020L, "cm/aptoide/pt/install/InstallAnalytics$1", 0);
            $jacocoData = probes;
            return probes;
        }
    }

    /* renamed from: cm.aptoide.pt.install.InstallAnalytics$InstallEvent */
    private static class InstallEvent {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final Action action;
        private final String context;
        private final Map<String, Object> data;
        private final String eventName;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(7686691458834373908L, "cm/aptoide/pt/install/InstallAnalytics$InstallEvent", 6);
            $jacocoData = probes;
            return probes;
        }

        /* synthetic */ InstallEvent(Map x0, String x1, String x2, Action x3, C39921 x4) {
            boolean[] $jacocoInit = $jacocoInit();
            this(x0, x1, x2, x3);
            $jacocoInit[5] = true;
        }

        private InstallEvent(Map<String, Object> data2, String eventName2, String context2, Action action2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.data = data2;
            this.eventName = eventName2;
            this.context = context2;
            this.action = action2;
            $jacocoInit[0] = true;
        }

        public Map<String, Object> getData() {
            boolean[] $jacocoInit = $jacocoInit();
            Map<String, Object> map = this.data;
            $jacocoInit[1] = true;
            return map;
        }

        public String getEventName() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.eventName;
            $jacocoInit[2] = true;
            return str;
        }

        public String getContext() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.context;
            $jacocoInit[3] = true;
            return str;
        }

        public Action getAction() {
            boolean[] $jacocoInit = $jacocoInit();
            Action action2 = this.action;
            $jacocoInit[4] = true;
            return action2;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8486342538208207397L, "cm/aptoide/pt/install/InstallAnalytics", Opcodes.INVOKESTATIC);
        $jacocoData = probes;
        return probes;
    }

    public InstallAnalytics(CrashReport crashReport2, AnalyticsManager analyticsManager2, NavigationTracker navigationTracker2, Map<String, InstallEvent> cache2, ConnectivityManager connectivityManager2, TelephonyManager telephonyManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport = crashReport2;
        this.analyticsManager = analyticsManager2;
        this.navigationTracker = navigationTracker2;
        this.cache = cache2;
        this.connectivityManager = connectivityManager2;
        this.telephonyManager = telephonyManager2;
        $jacocoInit[0] = true;
    }

    public void installCompleted(String packageName, int installingVersion, boolean isRoot, boolean aptoideSettings) {
        boolean[] $jacocoInit = $jacocoInit();
        sendEvent(getKey(packageName, installingVersion, NOTIFICATION_APPLICATION_INSTALL));
        $jacocoInit[1] = true;
        sendEvent(getKey(packageName, installingVersion, EDITORS_APPLICATION_INSTALL));
        $jacocoInit[2] = true;
        sendEvent(getKey(packageName, installingVersion, APPLICATION_INSTALL));
        $jacocoInit[3] = true;
        sendEvent(getKey(packageName, installingVersion, AppViewAnalytics.BONUS_MIGRATION_APPVIEW));
        $jacocoInit[4] = true;
        sendInstallEvents(packageName, installingVersion, isRoot, aptoideSettings);
        $jacocoInit[5] = true;
    }

    public void uninstallCompleted(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[6] = true;
        String key = getKey(packageName, MIGRATION_UNINSTALL_KEY, AppViewAnalytics.BONUS_MIGRATION_APPVIEW);
        $jacocoInit[7] = true;
        sendEvent(key);
        $jacocoInit[8] = true;
    }

    private void sendInstallEvents(String packageName, int installingVersion, boolean isPhoneRoot, boolean aptoideSettings) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, InstallEvent> map = this.cache;
        $jacocoInit[9] = true;
        InstallEvent installEvent = (InstallEvent) map.get(getKey(packageName, installingVersion, INSTALL_EVENT_NAME));
        if (installEvent == null) {
            $jacocoInit[10] = true;
        } else {
            $jacocoInit[11] = true;
            sendInstallEvent(installEvent, isPhoneRoot, aptoideSettings, packageName, installingVersion);
            $jacocoInit[12] = true;
        }
        Map<String, InstallEvent> map2 = this.cache;
        $jacocoInit[13] = true;
        InstallEvent applicationInstallEvent = (InstallEvent) map2.get(getKey(packageName, installingVersion, APPLICATION_INSTALL));
        if (applicationInstallEvent == null) {
            $jacocoInit[14] = true;
        } else {
            $jacocoInit[15] = true;
            sendApplicationInstallEvent(applicationInstallEvent, isPhoneRoot, aptoideSettings, packageName, installingVersion);
            $jacocoInit[16] = true;
        }
        $jacocoInit[17] = true;
    }

    private void sendInstallEvent(InstallEvent installEvent, boolean isPhoneRoot, boolean aptoideSettings, String packageName, int installingVersion) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = installEvent.getData();
        $jacocoInit[18] = true;
        data.put(ROOT, createRoot(isPhoneRoot, aptoideSettings));
        $jacocoInit[19] = true;
        data.put(RESULT, createResult());
        $jacocoInit[20] = true;
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = installEvent.getAction();
        $jacocoInit[21] = true;
        String context = installEvent.getContext();
        $jacocoInit[22] = true;
        String str = INSTALL_EVENT_NAME;
        analyticsManager2.logEvent(data, str, action, context);
        $jacocoInit[23] = true;
        this.cache.remove(getKey(packageName, installingVersion, str));
        $jacocoInit[24] = true;
    }

    private void sendApplicationInstallEvent(InstallEvent installEvent, boolean isPhoneRoot, boolean aptoideSettings, String packageName, int installingVersion) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> data = installEvent.getData();
        $jacocoInit[25] = true;
        data.put(ROOT, createRoot(isPhoneRoot, aptoideSettings));
        $jacocoInit[26] = true;
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Action action = installEvent.getAction();
        $jacocoInit[27] = true;
        String context = installEvent.getContext();
        $jacocoInit[28] = true;
        String str = APPLICATION_INSTALL;
        analyticsManager2.logEvent(data, str, action, context);
        $jacocoInit[29] = true;
        this.cache.remove(getKey(packageName, installingVersion, str));
        $jacocoInit[30] = true;
    }

    private Map<String, Object> createResult() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> result = new HashMap<>();
        $jacocoInit[31] = true;
        result.put(STATUS, SUCCESS);
        $jacocoInit[32] = true;
        return result;
    }

    private String getKey(String packageName, int installingVersion, String eventName) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(installingVersion);
        sb.append(eventName);
        String sb2 = sb.toString();
        $jacocoInit[33] = true;
        return sb2;
    }

    private void sendEvent(String key) {
        boolean[] $jacocoInit = $jacocoInit();
        InstallEvent installEvent = (InstallEvent) this.cache.get(key);
        if (installEvent == null) {
            $jacocoInit[34] = true;
        } else {
            $jacocoInit[35] = true;
            AnalyticsManager analyticsManager2 = this.analyticsManager;
            Map data = installEvent.getData();
            String eventName = installEvent.getEventName();
            $jacocoInit[36] = true;
            Action action = installEvent.getAction();
            String context = installEvent.getContext();
            $jacocoInit[37] = true;
            analyticsManager2.logEvent(data, eventName, action, context);
            $jacocoInit[38] = true;
        }
        this.cache.remove(key);
        $jacocoInit[39] = true;
    }

    public void installStarted(String packageName, int versionCode, Action action, AppContext context, Origin origin, boolean isMigration, boolean hasAppc) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[40] = true;
        List emptyList = Collections.emptyList();
        $jacocoInit[41] = true;
        Action action2 = action;
        AppContext appContext = context;
        Origin origin2 = origin;
        String str = packageName;
        int i = versionCode;
        createApplicationInstallEvent(action2, appContext, origin2, str, i, -1, null, emptyList, isMigration, hasAppc);
        $jacocoInit[42] = true;
        createInstallEvent(action2, appContext, origin2, str, i, -1, null, isMigration, hasAppc);
        $jacocoInit[43] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void createApplicationInstallEvent(p005cm.aptoide.analytics.AnalyticsManager.Action r27, p005cm.aptoide.p006pt.download.AppContext r28, p005cm.aptoide.p006pt.download.Origin r29, java.lang.String r30, int r31, int r32, java.lang.String r33, java.util.List<java.lang.String> r34, boolean r35, boolean r36) {
        /*
            r26 = this;
            r0 = r26
            r1 = r30
            r2 = r31
            boolean[] r3 = $jacocoInit()
            r4 = 1
            r5 = 44
            r3[r5] = r4
            r5 = r32
            r6 = r33
            r7 = r36
            java.util.Map r14 = r0.getInstallEventsBaseBundle(r1, r5, r6, r7)
            r8 = 45
            r3[r8] = r4
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r35)
            java.lang.String r9 = "migrator"
            r14.put(r9, r8)
            r8 = 46
            r3[r8] = r4
            java.lang.String r8 = "origin"
            r15 = r29
            r14.put(r8, r15)
            java.lang.String r8 = ""
            r9 = 47
            r3[r9] = r4
            cm.aptoide.analytics.implementation.navigation.NavigationTracker r9 = r0.navigationTracker
            cm.aptoide.analytics.implementation.navigation.ScreenTagHistory r16 = r9.getPreviousScreen()
            r9 = 48
            r3[r9] = r4
            cm.aptoide.analytics.implementation.navigation.NavigationTracker r9 = r0.navigationTracker
            cm.aptoide.analytics.implementation.navigation.ScreenTagHistory r17 = r9.getCurrentScreen()
            r9 = 49
            r3[r9] = r4
            java.lang.String r9 = r17.getTag()
            if (r9 != 0) goto L_0x0056
            r9 = 50
            r3[r9] = r4
            goto L_0x006a
        L_0x0056:
            java.lang.String r9 = r17.getTag()
            r10 = 51
            r3[r10] = r4
            java.lang.String r10 = "apps-group-editors-choice"
            boolean r9 = r9.contains(r10)
            if (r9 != 0) goto L_0x00b8
            r9 = 52
            r3[r9] = r4
        L_0x006a:
            if (r16 != 0) goto L_0x008f
            r9 = 54
            r3[r9] = r4
            boolean r9 = r34.isEmpty()
            if (r9 == 0) goto L_0x007b
            r9 = 55
            r3[r9] = r4
            goto L_0x00ae
        L_0x007b:
            r9 = 56
            r3[r9] = r4
            cm.aptoide.pt.crashreports.CrashReport r9 = r0.crashReport
            java.lang.String r10 = r34.toString()
            java.lang.String r11 = "No_Previous_Screen"
            r9.log(r11, r10)
            r9 = 57
            r3[r9] = r4
            goto L_0x00ae
        L_0x008f:
            java.lang.String r9 = r17.getTag()
            if (r9 != 0) goto L_0x009a
            r9 = 58
            r3[r9] = r4
            goto L_0x00ae
        L_0x009a:
            java.lang.String r9 = r16.getFragment()
            r10 = 59
            r3[r10] = r4
            java.lang.String r10 = "Deeplink"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x00b0
            r9 = 60
            r3[r9] = r4
        L_0x00ae:
            r13 = r8
            goto L_0x00bf
        L_0x00b0:
            java.lang.String r8 = "Aptoide_Push_Notification_Application_Install"
            r9 = 61
            r3[r9] = r4
            r13 = r8
            goto L_0x00bf
        L_0x00b8:
            java.lang.String r8 = "Editors_Choice_Application_Install"
            r9 = 53
            r3[r9] = r4
            r13 = r8
        L_0x00bf:
            java.lang.String r8 = ""
            boolean r8 = r13.equals(r8)
            if (r8 == 0) goto L_0x00ce
            r8 = 62
            r3[r8] = r4
            r18 = r13
            goto L_0x0109
        L_0x00ce:
            r8 = 63
            r3[r8] = r4
            java.util.Map<java.lang.String, cm.aptoide.pt.install.InstallAnalytics$InstallEvent> r12 = r0.cache
            java.lang.String r11 = r0.getKey(r1, r2, r13)
            cm.aptoide.pt.install.InstallAnalytics$InstallEvent r10 = new cm.aptoide.pt.install.InstallAnalytics$InstallEvent
            r8 = 64
            r3[r8] = r4
            java.lang.String r18 = r28.name()
            r19 = 0
            r8 = r10
            r9 = r14
            r20 = r10
            r10 = r13
            r21 = r11
            r11 = r18
            r22 = r12
            r12 = r27
            r18 = r13
            r13 = r19
            r8.<init>(r9, r10, r11, r12, r13)
            r8 = 65
            r3[r8] = r4
            r10 = r20
            r9 = r21
            r8 = r22
            r8.put(r9, r10)
            r8 = 66
            r3[r8] = r4
        L_0x0109:
            java.util.Map<java.lang.String, cm.aptoide.pt.install.InstallAnalytics$InstallEvent> r13 = r0.cache
            java.lang.String r8 = "Application Install"
            java.lang.String r12 = r0.getKey(r1, r2, r8)
            cm.aptoide.pt.install.InstallAnalytics$InstallEvent r11 = new cm.aptoide.pt.install.InstallAnalytics$InstallEvent
            r8 = 67
            r3[r8] = r4
            java.lang.String r19 = r28.name()
            r20 = 0
            java.lang.String r10 = "Application Install"
            r8 = r11
            r9 = r14
            r23 = r11
            r11 = r19
            r24 = r12
            r12 = r27
            r25 = r13
            r13 = r20
            r8.<init>(r9, r10, r11, r12, r13)
            r8 = 68
            r3[r8] = r4
            r10 = r23
            r9 = r24
            r8 = r25
            r8.put(r9, r10)
            r8 = 69
            r3[r8] = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.install.InstallAnalytics.createApplicationInstallEvent(cm.aptoide.analytics.AnalyticsManager$Action, cm.aptoide.pt.download.AppContext, cm.aptoide.pt.download.Origin, java.lang.String, int, int, java.lang.String, java.util.List, boolean, boolean):void");
    }

    private void createMigrationInstallEvent(Action action, AppContext context, String packageName, int installingVersion) {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap hashMap = new HashMap();
        $jacocoInit[70] = true;
        hashMap.put("action", "install appc app");
        $jacocoInit[71] = true;
        Map<String, InstallEvent> map = this.cache;
        String key = getKey(packageName, installingVersion, AppViewAnalytics.BONUS_MIGRATION_APPVIEW);
        $jacocoInit[72] = true;
        HashMap hashMap2 = hashMap;
        InstallEvent installEvent = new InstallEvent(hashMap2, AppViewAnalytics.BONUS_MIGRATION_APPVIEW, context.name(), action, null);
        $jacocoInit[73] = true;
        map.put(key, installEvent);
        $jacocoInit[74] = true;
    }

    public void installStarted(String packageName, int versionCode, Action action, AppContext context, Origin origin, int campaignId, String abTestingGroup, boolean isMigration, boolean hasAppc) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!isMigration) {
            $jacocoInit[75] = true;
            String str = packageName;
            int i = versionCode;
            Action action2 = action;
            AppContext appContext = context;
        } else {
            createMigrationInstallEvent(action, context, packageName, versionCode);
            $jacocoInit[76] = true;
        }
        $jacocoInit[77] = true;
        List emptyList = Collections.emptyList();
        $jacocoInit[78] = true;
        Action action3 = action;
        AppContext appContext2 = context;
        Origin origin2 = origin;
        String str2 = packageName;
        int i2 = versionCode;
        int i3 = campaignId;
        String str3 = abTestingGroup;
        createApplicationInstallEvent(action3, appContext2, origin2, str2, i2, i3, str3, emptyList, isMigration, hasAppc);
        $jacocoInit[79] = true;
        createInstallEvent(action3, appContext2, origin2, str2, i2, i3, str3, isMigration, hasAppc);
        $jacocoInit[80] = true;
    }

    public void uninstallStarted(String packageName, Action action, AppContext context) {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap hashMap = new HashMap();
        $jacocoInit[81] = true;
        hashMap.put("action", "uninstall");
        Map<String, InstallEvent> map = this.cache;
        $jacocoInit[82] = true;
        String key = getKey(packageName, MIGRATION_UNINSTALL_KEY, AppViewAnalytics.BONUS_MIGRATION_APPVIEW);
        $jacocoInit[83] = true;
        HashMap hashMap2 = hashMap;
        InstallEvent installEvent = new InstallEvent(hashMap2, AppViewAnalytics.BONUS_MIGRATION_APPVIEW, context.name(), action, null);
        $jacocoInit[84] = true;
        map.put(key, installEvent);
        $jacocoInit[85] = true;
    }

    private void createInstallEvent(Action action, AppContext context, Origin origin, String packageName, int installingVersion, int campaignId, String abTestingGroup, boolean isMigration, boolean hasAppc) {
        String str = packageName;
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[86] = true;
        Map<String, Object> data = getInstallEventsBaseBundle(str, campaignId, abTestingGroup, hasAppc);
        String str2 = ORIGIN;
        if (isMigration) {
            $jacocoInit[87] = true;
            data.put(str2, UPDATE_TO_APPC);
            $jacocoInit[88] = true;
            Origin origin2 = origin;
        } else {
            data.put(str2, origin);
            $jacocoInit[89] = true;
        }
        Map<String, InstallEvent> map = this.cache;
        String key = getKey(str, installingVersion, INSTALL_EVENT_NAME);
        $jacocoInit[90] = true;
        Map map2 = data;
        InstallEvent installEvent = r7;
        String str3 = key;
        InstallEvent installEvent2 = new InstallEvent(map2, INSTALL_EVENT_NAME, context.name(), action, null);
        $jacocoInit[91] = true;
        map.put(str3, installEvent);
        $jacocoInit[92] = true;
    }

    private Map<String, Object> getInstallEventsBaseBundle(String packageName, int campaignId, String abTestingGroup, boolean hasAppc) {
        boolean[] $jacocoInit = $jacocoInit();
        ScreenTagHistory screenTagHistory = this.navigationTracker.getPreviousScreen();
        $jacocoInit[93] = true;
        Map<String, Object> data = new HashMap<>();
        $jacocoInit[94] = true;
        data.put(APP, createApp(packageName, hasAppc));
        $jacocoInit[95] = true;
        String connectionType = SystemU.getConnectionType(this.connectivityManager);
        $jacocoInit[96] = true;
        String upperCase = connectionType.toUpperCase();
        $jacocoInit[97] = true;
        data.put(NETWORK, upperCase);
        $jacocoInit[98] = true;
        data.put(PREVIOUS_CONTEXT, screenTagHistory.getFragment());
        $jacocoInit[99] = true;
        data.put(PREVIOUS_TAG, screenTagHistory.getTag());
        if (campaignId < 0) {
            $jacocoInit[100] = true;
        } else {
            $jacocoInit[101] = true;
            data.put(CAMPAIGN_ID, Integer.valueOf(campaignId));
            $jacocoInit[102] = true;
        }
        if (abTestingGroup == null) {
            $jacocoInit[103] = true;
        } else {
            $jacocoInit[104] = true;
            data.put(AB_TEST_GROUP, abTestingGroup);
            $jacocoInit[105] = true;
        }
        ScreenTagHistory currentScreen = this.navigationTracker.getCurrentScreen();
        $jacocoInit[106] = true;
        String store = currentScreen.getStore();
        $jacocoInit[107] = true;
        data.put("store", store);
        $jacocoInit[108] = true;
        data.put(TELECO, SystemU.getCarrierName(this.telephonyManager));
        $jacocoInit[109] = true;
        return data;
    }

    private Map<String, Object> createRoot(boolean isPhoneRooted, boolean aptoideSettings) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> root = new HashMap<>();
        $jacocoInit[110] = true;
        root.put(PHONE, Boolean.valueOf(isPhoneRooted));
        $jacocoInit[111] = true;
        root.put(SETTINGS, Boolean.valueOf(aptoideSettings));
        $jacocoInit[112] = true;
        return root;
    }

    private Map<String, Object> createApp(String packageName, boolean hasAppc) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> app = new HashMap<>();
        $jacocoInit[113] = true;
        app.put("package", packageName);
        $jacocoInit[114] = true;
        app.put(APPC, Boolean.valueOf(hasAppc));
        $jacocoInit[115] = true;
        return app;
    }

    public void updateInstallEvents(int versionCode, String packageName, int fileType, String url) {
        int i = versionCode;
        String str = packageName;
        boolean[] $jacocoInit = $jacocoInit();
        InstallEvent installEvent = (InstallEvent) this.cache.get(getKey(str, versionCode, INSTALL_EVENT_NAME));
        Map<String, InstallEvent> map = this.cache;
        $jacocoInit[116] = true;
        InstallEvent applicationInstallEvent = (InstallEvent) map.get(getKey(str, versionCode, APPLICATION_INSTALL));
        if (installEvent == null) {
            $jacocoInit[117] = true;
        } else {
            $jacocoInit[118] = true;
            int i2 = versionCode;
            String str2 = packageName;
            int i3 = fileType;
            String str3 = url;
            InstallEvent installEvent2 = installEvent;
            updateApp(i2, str2, i3, str3, installEvent2, INSTALL_EVENT_NAME);
            $jacocoInit[119] = true;
            updateObb(i2, str2, i3, str3, installEvent2, INSTALL_EVENT_NAME);
            $jacocoInit[120] = true;
        }
        if (applicationInstallEvent == null) {
            $jacocoInit[121] = true;
        } else {
            $jacocoInit[122] = true;
            int i4 = versionCode;
            String str4 = packageName;
            int i5 = fileType;
            String str5 = url;
            InstallEvent installEvent3 = applicationInstallEvent;
            updateApp(i4, str4, i5, str5, installEvent3, APPLICATION_INSTALL);
            $jacocoInit[123] = true;
            updateObb(i4, str4, i5, str5, installEvent3, APPLICATION_INSTALL);
            $jacocoInit[124] = true;
        }
        $jacocoInit[125] = true;
    }

    private void updateObb(int versionCode, String packageName, int fileType, String url, InstallEvent installEvent, String installEventName) {
        List<Map<String, Object>> obb;
        int i = fileType;
        boolean[] $jacocoInit = $jacocoInit();
        if (i == 1) {
            $jacocoInit[126] = true;
        } else if (i != 2) {
            $jacocoInit[127] = true;
            int i2 = versionCode;
            String str = packageName;
            String str2 = url;
            $jacocoInit[139] = true;
        } else {
            $jacocoInit[128] = true;
        }
        Map<String, Object> data = installEvent.getData();
        $jacocoInit[129] = true;
        String str3 = OBB;
        List<Map<String, Object>> obb2 = (List) data.get(str3);
        if (obb2 != null) {
            $jacocoInit[130] = true;
            obb = obb2;
        } else {
            $jacocoInit[131] = true;
            List<Map<String, Object>> obb3 = new ArrayList<>();
            $jacocoInit[132] = true;
            obb = obb3;
        }
        obb.add(createObbData(i, url));
        $jacocoInit[133] = true;
        data.put(str3, obb);
        $jacocoInit[134] = true;
        Map<String, InstallEvent> map = this.cache;
        String key = getKey(packageName, versionCode, installEventName);
        $jacocoInit[135] = true;
        String eventName = installEvent.getEventName();
        String context = installEvent.getContext();
        $jacocoInit[136] = true;
        InstallEvent installEvent2 = r5;
        String str4 = key;
        InstallEvent installEvent3 = new InstallEvent(data, eventName, context, installEvent.getAction(), null);
        $jacocoInit[137] = true;
        map.put(str4, installEvent2);
        $jacocoInit[138] = true;
        $jacocoInit[139] = true;
    }

    private Map<String, Object> createObbData(int fileType, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> obb = new HashMap<>();
        String str = "type";
        if (fileType == 1) {
            $jacocoInit[140] = true;
            obb.put(str, MAIN);
            $jacocoInit[141] = true;
        } else if (fileType != 2) {
            $jacocoInit[142] = true;
        } else {
            $jacocoInit[143] = true;
            obb.put(str, PATCH);
            $jacocoInit[144] = true;
        }
        obb.put("url", url);
        $jacocoInit[145] = true;
        return obb;
    }

    private void updateApp(int versionCode, String packageName, int fileType, String url, InstallEvent installEvent, String installEventName) {
        boolean[] $jacocoInit = $jacocoInit();
        if (fileType != 0) {
            $jacocoInit[146] = true;
            int i = versionCode;
            String str = packageName;
            String str2 = url;
            String str3 = installEventName;
        } else {
            $jacocoInit[147] = true;
            Map<String, Object> data = installEvent.getData();
            $jacocoInit[148] = true;
            String str4 = APP;
            Map<String, Object> app = (Map) data.get(str4);
            $jacocoInit[149] = true;
            app.put("url", url);
            $jacocoInit[150] = true;
            data.put(str4, app);
            $jacocoInit[151] = true;
            Map<String, InstallEvent> map = this.cache;
            String key = getKey(packageName, versionCode, installEventName);
            $jacocoInit[152] = true;
            String context = installEvent.getContext();
            $jacocoInit[153] = true;
            InstallEvent installEvent2 = r4;
            String str5 = key;
            InstallEvent installEvent3 = new InstallEvent(data, installEventName, context, installEvent.getAction(), null);
            $jacocoInit[154] = true;
            map.put(str5, installEvent2);
            $jacocoInit[155] = true;
        }
        $jacocoInit[156] = true;
    }

    public void logInstallErrorEvent(String packageName, int versionCode, Exception exception, boolean isPhoneRoot, boolean aptoideSettings) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, InstallEvent> map = this.cache;
        String str = INSTALL_EVENT_NAME;
        InstallEvent installEvent = (InstallEvent) map.get(getKey(packageName, versionCode, str));
        if (installEvent == null) {
            $jacocoInit[157] = true;
        } else {
            $jacocoInit[158] = true;
            Map<String, Object> data = installEvent.getData();
            $jacocoInit[159] = true;
            data.put(ROOT, createRoot(isPhoneRoot, aptoideSettings));
            $jacocoInit[160] = true;
            data.put(RESULT, createFailResult(exception));
            $jacocoInit[161] = true;
            AnalyticsManager analyticsManager2 = this.analyticsManager;
            Action action = installEvent.getAction();
            $jacocoInit[162] = true;
            String context = installEvent.getContext();
            $jacocoInit[163] = true;
            analyticsManager2.logEvent(data, str, action, context);
            $jacocoInit[164] = true;
            this.cache.remove(getKey(packageName, versionCode, str));
            $jacocoInit[165] = true;
        }
        $jacocoInit[166] = true;
    }

    private Map<String, Object> createFailResult(Exception exception) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> result = new HashMap<>();
        $jacocoInit[167] = true;
        result.put(STATUS, FAIL);
        $jacocoInit[168] = true;
        Class cls = exception.getClass();
        $jacocoInit[169] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[170] = true;
        result.put("type", simpleName);
        $jacocoInit[171] = true;
        result.put("message", exception.getMessage());
        $jacocoInit[172] = true;
        return result;
    }

    public void logInstallCancelEvent(String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, InstallEvent> map = this.cache;
        String str = INSTALL_EVENT_NAME;
        InstallEvent installEvent = (InstallEvent) map.get(getKey(packageName, versionCode, str));
        if (installEvent == null) {
            $jacocoInit[173] = true;
        } else {
            $jacocoInit[174] = true;
            Map<String, Object> data = installEvent.getData();
            $jacocoInit[175] = true;
            data.put(RESULT, createCancelResult());
            $jacocoInit[176] = true;
            AnalyticsManager analyticsManager2 = this.analyticsManager;
            Action action = installEvent.getAction();
            $jacocoInit[177] = true;
            String context = installEvent.getContext();
            $jacocoInit[178] = true;
            analyticsManager2.logEvent(data, str, action, context);
            $jacocoInit[179] = true;
            this.cache.remove(getKey(packageName, versionCode, str));
            $jacocoInit[180] = true;
        }
        $jacocoInit[181] = true;
    }

    private Map<String, Object> createCancelResult() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> result = new HashMap<>();
        $jacocoInit[182] = true;
        result.put(STATUS, CANCEL);
        $jacocoInit[183] = true;
        return result;
    }
}
