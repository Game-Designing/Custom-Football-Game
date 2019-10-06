package p005cm.aptoide.p006pt.notification;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.notification.AptoideNotification */
public class AptoideNotification {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final int APPC_PROMOTION = 7;
    public static final int CAMPAIGN = 0;
    public static final int COMMENT = 1;
    public static final int LIKE = 2;
    public static final int NEW_ACTIVITY = 6;
    public static final int NEW_FOLLOWER = 4;
    public static final int NEW_SHARE = 5;
    public static final int NOT_DISMISSED = -1;
    public static final int POPULAR = 3;
    private String abTestingGroup;
    private String appName;
    private String body;
    private int campaignId;
    private long dismissed;
    private Long expire;
    private String graphic;
    private String img;
    private String lang;
    private String notificationCenterUrlTrack;
    private String ownerId;
    private boolean processed;
    private long timeStamp;
    private String title;
    private int type;
    private String url;
    private String urlTrack;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: cm.aptoide.pt.notification.AptoideNotification$NotificationType */
    public @interface NotificationType {
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6535189626488406481L, "cm/aptoide/pt/notification/AptoideNotification", 22);
        $jacocoData = probes;
        return probes;
    }

    public AptoideNotification(String body2, String img2, String title2, String url2, int type2, long timeStamp2, String appName2, String graphic2, long dismissed2, String ownerId2, String urlTrack2, String notificationCenterUrlTrack2, boolean processed2, Long expireSecsUtc) {
        boolean[] $jacocoInit = $jacocoInit();
        this.body = body2;
        this.img = img2;
        this.title = title2;
        this.url = url2;
        this.type = type2;
        this.timeStamp = timeStamp2;
        this.appName = appName2;
        this.graphic = graphic2;
        this.dismissed = dismissed2;
        this.ownerId = ownerId2;
        this.expire = expireSecsUtc;
        this.urlTrack = urlTrack2;
        this.notificationCenterUrlTrack = notificationCenterUrlTrack2;
        this.processed = processed2;
        $jacocoInit[0] = true;
    }

    public AptoideNotification(String body2, String img2, String title2, String url2, int type2, String appName2, String graphic2, long dismissed2, String ownerId2, String urlTrack2, String notificationCenterUrlTrack2, boolean processed2, long timeStamp2, Long expireSecsUtc, String abTestingGroup2, int campaignId2, String lang2) {
        String str = body2;
        String str2 = img2;
        String str3 = title2;
        String str4 = url2;
        int i = type2;
        String str5 = appName2;
        String str6 = graphic2;
        long j = dismissed2;
        String str7 = ownerId2;
        String str8 = urlTrack2;
        String str9 = notificationCenterUrlTrack2;
        boolean z = processed2;
        long j2 = timeStamp2;
        Long l = expireSecsUtc;
        boolean[] $jacocoInit = $jacocoInit();
        this(str, str2, str3, str4, i, j2, str5, str6, j, str7, str8, str9, z, l);
        this.abTestingGroup = abTestingGroup2;
        this.campaignId = campaignId2;
        this.lang = lang2;
        $jacocoInit[1] = true;
    }

    public AptoideNotification(String img2, String title2, String url2, String urlTrack2, String graphic2, int type2, int campaignId2, long timeStamp2, String ownerId2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.img = img2;
        this.title = title2;
        this.url = url2;
        this.urlTrack = urlTrack2;
        this.graphic = graphic2;
        this.type = type2;
        this.campaignId = campaignId2;
        this.timeStamp = timeStamp2;
        this.ownerId = ownerId2;
        $jacocoInit[2] = true;
    }

    public String toString() {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("AptoideNotification{title='");
        sb.append(this.title);
        sb.append('\'');
        sb.append('}');
        String sb2 = sb.toString();
        $jacocoInit[3] = true;
        return sb2;
    }

    public boolean isProcessed() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.processed;
        $jacocoInit[4] = true;
        return z;
    }

    public void setProcessed(boolean processed2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.processed = processed2;
        $jacocoInit[5] = true;
    }

    public long getDismissed() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.dismissed;
        $jacocoInit[6] = true;
        return j;
    }

    public String getAppName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appName;
        $jacocoInit[7] = true;
        return str;
    }

    public String getGraphic() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.graphic;
        $jacocoInit[8] = true;
        return str;
    }

    public int getType() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.type;
        $jacocoInit[9] = true;
        return i;
    }

    public String getAbTestingGroup() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.abTestingGroup;
        $jacocoInit[10] = true;
        return str;
    }

    public String getBody() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.body;
        $jacocoInit[11] = true;
        return str;
    }

    public int getCampaignId() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.campaignId;
        $jacocoInit[12] = true;
        return i;
    }

    public String getImg() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.img;
        $jacocoInit[13] = true;
        return str;
    }

    public String getLang() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.lang;
        $jacocoInit[14] = true;
        return str;
    }

    public String getTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        $jacocoInit[15] = true;
        return str;
    }

    public String getUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.url;
        $jacocoInit[16] = true;
        return str;
    }

    public String getUrlTrack() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.urlTrack;
        $jacocoInit[17] = true;
        return str;
    }

    public long getTimeStamp() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.timeStamp;
        $jacocoInit[18] = true;
        return j;
    }

    public String getOwnerId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.ownerId;
        $jacocoInit[19] = true;
        return str;
    }

    public Long getExpire() {
        boolean[] $jacocoInit = $jacocoInit();
        Long l = this.expire;
        $jacocoInit[20] = true;
        return l;
    }

    public String getNotificationCenterUrlTrack() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.notificationCenterUrlTrack;
        $jacocoInit[21] = true;
        return str;
    }
}
