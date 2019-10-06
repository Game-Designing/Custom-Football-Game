package p005cm.aptoide.p006pt.notification;

import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.AnalyticsManager.Action;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.downloadmanager.Constants;
import p005cm.aptoide.p006pt.link.AptoideInstall;
import p005cm.aptoide.p006pt.link.AptoideInstallParser;

/* renamed from: cm.aptoide.pt.notification.NotificationAnalytics */
public class NotificationAnalytics {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String AB_TESTING_GROUP = "ab_testing_group";
    private static final String CAMPAIGN_ID = "campaign_id";
    public static final String NOTIFICATION_EVENT_NAME = "NOTIFICATION";
    public static final String NOTIFICATION_IMPRESSION = "Aptoide_Push_Notification_Impression";
    public static final String NOTIFICATION_PRESSED = "Aptoide_Push_Notification_Click";
    public static final String NOTIFICATION_RECEIVED = "Aptoide_Push_Notification_Received";
    private static final String PACKAGE_NAME = "package_name";
    private static final String TYPE = "type";
    private String abTestingGroup;
    private final AnalyticsManager analyticsManager;
    private AptoideInstall aptoideInstall;
    private final AptoideInstallParser aptoideInstallParser;
    private int campaignId;
    private final NavigationTracker navigationTracker;

    /* renamed from: cm.aptoide.pt.notification.NotificationAnalytics$NotificationTypes */
    private enum NotificationTypes {
        CAMPAIGN,
        LIKE,
        COMMENT,
        POPULAR,
        NEW_FOLLOWER,
        NEW_SHARE,
        NEW_ACTIVITY,
        OTHER,
        UPDATES;

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
        boolean[] probes = Offline.getProbes(-6599556300758514931L, "cm/aptoide/pt/notification/NotificationAnalytics", 94);
        $jacocoData = probes;
        return probes;
    }

    public NotificationAnalytics(AptoideInstallParser aptoideInstallParser2, AnalyticsManager analyticsManager2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.aptoideInstallParser = aptoideInstallParser2;
        this.analyticsManager = analyticsManager2;
        this.navigationTracker = navigationTracker2;
        $jacocoInit[0] = true;
    }

    public void sendNotificationTouchEvent(String url) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManager.logEvent(url);
        $jacocoInit[1] = true;
    }

    public void sendUpdatesNotificationReceivedEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createUpdateNotificationEventsMap = createUpdateNotificationEventsMap();
        Action action = Action.AUTO;
        $jacocoInit[2] = true;
        String viewName = getViewName(true);
        $jacocoInit[3] = true;
        analyticsManager2.logEvent(createUpdateNotificationEventsMap, NOTIFICATION_RECEIVED, action, viewName);
        $jacocoInit[4] = true;
    }

    public void sendUpdatesNotificationImpressionEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createUpdateNotificationEventsMap = createUpdateNotificationEventsMap();
        Action action = Action.IMPRESSION;
        $jacocoInit[5] = true;
        String viewName = getViewName(true);
        $jacocoInit[6] = true;
        analyticsManager2.logEvent(createUpdateNotificationEventsMap, NOTIFICATION_IMPRESSION, action, viewName);
        $jacocoInit[7] = true;
    }

    public void sendUpdatesNotificationClickEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createUpdateNotificationEventsMap = createUpdateNotificationEventsMap();
        Action action = Action.CLICK;
        $jacocoInit[8] = true;
        String viewName = getViewName(true);
        $jacocoInit[9] = true;
        analyticsManager2.logEvent(createUpdateNotificationEventsMap, NOTIFICATION_PRESSED, action, viewName);
        $jacocoInit[10] = true;
    }

    public void sendPushNotificationReceivedEvent(int type, String abTestingGroup2, int campaignId2, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        AnalyticsManager analyticsManager2 = this.analyticsManager;
        Map createPushNotificationEventMap = createPushNotificationEventMap(type, abTestingGroup2, campaignId2, url);
        Action action = Action.VIEW;
        $jacocoInit[11] = true;
        String viewName = getViewName(true);
        $jacocoInit[12] = true;
        analyticsManager2.logEvent(createPushNotificationEventMap, NOTIFICATION_RECEIVED, action, viewName);
        $jacocoInit[13] = true;
    }

    public void sendPushNotficationImpressionEvent(int type, String abTestingGroup2, int campaignId2, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        if (type != 0) {
            $jacocoInit[14] = true;
        } else {
            $jacocoInit[15] = true;
            AnalyticsManager analyticsManager2 = this.analyticsManager;
            Map createCampaignNotificationMap = createCampaignNotificationMap(abTestingGroup2, campaignId2);
            Action action = Action.IMPRESSION;
            $jacocoInit[16] = true;
            String viewName = getViewName(true);
            $jacocoInit[17] = true;
            analyticsManager2.logEvent(createCampaignNotificationMap, NOTIFICATION_EVENT_NAME, action, viewName);
            $jacocoInit[18] = true;
        }
        AnalyticsManager analyticsManager3 = this.analyticsManager;
        Map createPushNotificationEventMap = createPushNotificationEventMap(type, abTestingGroup2, campaignId2, url);
        Action action2 = Action.IMPRESSION;
        $jacocoInit[19] = true;
        String viewName2 = getViewName(true);
        $jacocoInit[20] = true;
        analyticsManager3.logEvent(createPushNotificationEventMap, NOTIFICATION_IMPRESSION, action2, viewName2);
        $jacocoInit[21] = true;
    }

    private Map<String, Object> createCampaignNotificationMap(String abTestingGroup2, int campaignId2) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[22] = true;
        if (campaignId2 != 0) {
            str = String.valueOf(campaignId2);
            $jacocoInit[23] = true;
        } else {
            str = null;
            $jacocoInit[24] = true;
        }
        map.put(CAMPAIGN_ID, str);
        $jacocoInit[25] = true;
        map.put(AB_TESTING_GROUP, abTestingGroup2);
        $jacocoInit[26] = true;
        return map;
    }

    public void sendPushNotificationPressedEvent(int type, String abTestingGroup2, int campaignId2, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        if (type != 0) {
            $jacocoInit[27] = true;
        } else {
            $jacocoInit[28] = true;
            AnalyticsManager analyticsManager2 = this.analyticsManager;
            Map createCampaignNotificationMap = createCampaignNotificationMap(abTestingGroup2, campaignId2);
            Action action = Action.CLICK;
            $jacocoInit[29] = true;
            String viewName = getViewName(true);
            $jacocoInit[30] = true;
            analyticsManager2.logEvent(createCampaignNotificationMap, NOTIFICATION_EVENT_NAME, action, viewName);
            $jacocoInit[31] = true;
        }
        AnalyticsManager analyticsManager3 = this.analyticsManager;
        Map createPushNotificationEventMap = createPushNotificationEventMap(type, abTestingGroup2, campaignId2, url);
        Action action2 = Action.CLICK;
        $jacocoInit[32] = true;
        String viewName2 = getViewName(true);
        $jacocoInit[33] = true;
        analyticsManager3.logEvent(createPushNotificationEventMap, NOTIFICATION_PRESSED, action2, viewName2);
        $jacocoInit[34] = true;
    }

    private Map<String, Object> createUpdateNotificationEventsMap() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[35] = true;
        String str = NotificationTypes.UPDATES.toString();
        $jacocoInit[36] = true;
        String lowerCase = str.toLowerCase();
        $jacocoInit[37] = true;
        map.put("type", lowerCase);
        $jacocoInit[38] = true;
        return map;
    }

    private Map<String, Object> createPushNotificationEventMap(int type, String abTestingGroup2, int campaignId2, String url) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, Object> map = new HashMap<>();
        $jacocoInit[39] = true;
        if (campaignId2 != 0) {
            str = String.valueOf(campaignId2);
            $jacocoInit[40] = true;
        } else {
            str = null;
            $jacocoInit[41] = true;
        }
        map.put(CAMPAIGN_ID, str);
        $jacocoInit[42] = true;
        String str2 = matchNotificationTypeToString(type).toString();
        $jacocoInit[43] = true;
        String lowerCase = str2.toLowerCase();
        $jacocoInit[44] = true;
        map.put("type", lowerCase);
        $jacocoInit[45] = true;
        Map<String, Object> map2 = addToMapIfNotNull(map, abTestingGroup2, getPackageNameFromUrl(url));
        $jacocoInit[46] = true;
        return map2;
    }

    private Map<String, Object> addToMapIfNotNull(Map<String, Object> map, String abTestingGroup2, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        if (abTestingGroup2 == null) {
            $jacocoInit[47] = true;
        } else if (abTestingGroup2.isEmpty()) {
            $jacocoInit[48] = true;
        } else {
            $jacocoInit[49] = true;
            map.put(AB_TESTING_GROUP, abTestingGroup2);
            $jacocoInit[50] = true;
        }
        if (url == null) {
            $jacocoInit[51] = true;
        } else if (url.isEmpty()) {
            $jacocoInit[52] = true;
        } else {
            $jacocoInit[53] = true;
            map.put("package_name", getPackageNameFromUrl(url));
            $jacocoInit[54] = true;
        }
        $jacocoInit[55] = true;
        return map;
    }

    private NotificationTypes matchNotificationTypeToString(int type) {
        boolean[] $jacocoInit = $jacocoInit();
        switch (type) {
            case 0:
                NotificationTypes notificationTypes = NotificationTypes.CAMPAIGN;
                $jacocoInit[56] = true;
                return notificationTypes;
            case 1:
                NotificationTypes notificationTypes2 = NotificationTypes.LIKE;
                $jacocoInit[57] = true;
                return notificationTypes2;
            case 2:
                NotificationTypes notificationTypes3 = NotificationTypes.COMMENT;
                $jacocoInit[58] = true;
                return notificationTypes3;
            case 3:
                NotificationTypes notificationTypes4 = NotificationTypes.POPULAR;
                $jacocoInit[59] = true;
                return notificationTypes4;
            case 4:
                NotificationTypes notificationTypes5 = NotificationTypes.NEW_FOLLOWER;
                $jacocoInit[60] = true;
                return notificationTypes5;
            case 5:
                NotificationTypes notificationTypes6 = NotificationTypes.NEW_SHARE;
                $jacocoInit[61] = true;
                return notificationTypes6;
            case 6:
                NotificationTypes notificationTypes7 = NotificationTypes.NEW_ACTIVITY;
                $jacocoInit[62] = true;
                return notificationTypes7;
            default:
                NotificationTypes notificationTypes8 = NotificationTypes.OTHER;
                $jacocoInit[63] = true;
                return notificationTypes8;
        }
    }

    private String getPackageNameFromUrl(String url) {
        boolean[] $jacocoInit = $jacocoInit();
        String[] split = url.split("&");
        int length = split.length;
        $jacocoInit[64] = true;
        int i = 0;
        while (i < length) {
            String part = split[i];
            $jacocoInit[65] = true;
            if (part.contains(Constants.PACKAGE)) {
                $jacocoInit[66] = true;
                String str = part.split("=")[1];
                $jacocoInit[67] = true;
                return str;
            }
            i++;
            $jacocoInit[68] = true;
        }
        $jacocoInit[69] = true;
        return "";
    }

    public void sendNotificationTouchEvent(String trackUrl, int notificationType, String url, int campaignId2, String abTestingGroup2) {
        boolean[] $jacocoInit = $jacocoInit();
        sendNotificationTouchEvent(trackUrl);
        if (notificationType != 0) {
            $jacocoInit[70] = true;
        } else {
            $jacocoInit[71] = true;
            AptoideInstall aptoideInstall2 = this.aptoideInstallParser.parse(url);
            $jacocoInit[72] = true;
            if (aptoideInstall2.getAppId() > 0) {
                $jacocoInit[73] = true;
            } else {
                $jacocoInit[74] = true;
                if (aptoideInstall2.getPackageName() == null) {
                    $jacocoInit[75] = true;
                } else {
                    String packageName = aptoideInstall2.getPackageName();
                    $jacocoInit[76] = true;
                    if (packageName.isEmpty()) {
                        $jacocoInit[77] = true;
                    } else {
                        $jacocoInit[78] = true;
                    }
                }
            }
            this.aptoideInstall = aptoideInstall2;
            this.campaignId = campaignId2;
            this.abTestingGroup = abTestingGroup2;
            $jacocoInit[79] = true;
        }
        $jacocoInit[80] = true;
    }

    public int getCampaignId(String packageName, long appId) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isSameApp(packageName, appId)) {
            int aux = this.campaignId;
            this.campaignId = 0;
            $jacocoInit[81] = true;
            return aux;
        }
        $jacocoInit[82] = true;
        return 0;
    }

    private boolean isSameApp(String packageName, long appId) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        AptoideInstall aptoideInstall2 = this.aptoideInstall;
        if (aptoideInstall2 == null) {
            $jacocoInit[83] = true;
        } else {
            String packageName2 = aptoideInstall2.getPackageName();
            $jacocoInit[84] = true;
            if (packageName2.equals(packageName)) {
                $jacocoInit[85] = true;
            } else if (this.aptoideInstall.getAppId() != appId) {
                $jacocoInit[86] = true;
            } else {
                $jacocoInit[87] = true;
            }
            $jacocoInit[88] = true;
            z = true;
            $jacocoInit[90] = true;
            return z;
        }
        z = false;
        $jacocoInit[89] = true;
        $jacocoInit[90] = true;
        return z;
    }

    public String getAbTestingGroup(String packageName, long appId) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isSameApp(packageName, appId)) {
            String aux = this.abTestingGroup;
            this.abTestingGroup = null;
            $jacocoInit[91] = true;
            return aux;
        }
        $jacocoInit[92] = true;
        return "";
    }

    private String getViewName(boolean isCurrent) {
        boolean[] $jacocoInit = $jacocoInit();
        String viewName = this.navigationTracker.getViewName(isCurrent);
        $jacocoInit[93] = true;
        return viewName;
    }
}
