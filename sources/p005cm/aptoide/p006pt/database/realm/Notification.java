package p005cm.aptoide.p006pt.database.realm;

import p024io.realm.C0106Z;
import p024io.realm.C0110x;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.Notification */
public class Notification extends C0106Z implements C0110x {
    public static final String KEY = "key";
    public static final int NOT_DISMISSED = -1;
    private String abTestingGroup;
    private String appName;
    private String body;
    private int campaignId;
    private long dismissed;
    private Long expire;
    private String graphic;
    private String img;
    private String key;
    private String lang;
    private String notificationCenterUrlTrack;
    private String ownerId;
    private boolean processed;
    private long timeStamp;
    private String title;
    private int type;
    private String url;
    private String urlTrack;

    public String realmGet$abTestingGroup() {
        return this.abTestingGroup;
    }

    public String realmGet$appName() {
        return this.appName;
    }

    public String realmGet$body() {
        return this.body;
    }

    public int realmGet$campaignId() {
        return this.campaignId;
    }

    public long realmGet$dismissed() {
        return this.dismissed;
    }

    public Long realmGet$expire() {
        return this.expire;
    }

    public String realmGet$graphic() {
        return this.graphic;
    }

    public String realmGet$img() {
        return this.img;
    }

    public String realmGet$key() {
        return this.key;
    }

    public String realmGet$lang() {
        return this.lang;
    }

    public String realmGet$notificationCenterUrlTrack() {
        return this.notificationCenterUrlTrack;
    }

    public String realmGet$ownerId() {
        return this.ownerId;
    }

    public boolean realmGet$processed() {
        return this.processed;
    }

    public long realmGet$timeStamp() {
        return this.timeStamp;
    }

    public String realmGet$title() {
        return this.title;
    }

    public int realmGet$type() {
        return this.type;
    }

    public String realmGet$url() {
        return this.url;
    }

    public String realmGet$urlTrack() {
        return this.urlTrack;
    }

    public void realmSet$abTestingGroup(String str) {
        this.abTestingGroup = str;
    }

    public void realmSet$appName(String str) {
        this.appName = str;
    }

    public void realmSet$body(String str) {
        this.body = str;
    }

    public void realmSet$campaignId(int i) {
        this.campaignId = i;
    }

    public void realmSet$dismissed(long j) {
        this.dismissed = j;
    }

    public void realmSet$expire(Long l) {
        this.expire = l;
    }

    public void realmSet$graphic(String str) {
        this.graphic = str;
    }

    public void realmSet$img(String str) {
        this.img = str;
    }

    public void realmSet$key(String str) {
        this.key = str;
    }

    public void realmSet$lang(String str) {
        this.lang = str;
    }

    public void realmSet$notificationCenterUrlTrack(String str) {
        this.notificationCenterUrlTrack = str;
    }

    public void realmSet$ownerId(String str) {
        this.ownerId = str;
    }

    public void realmSet$processed(boolean z) {
        this.processed = z;
    }

    public void realmSet$timeStamp(long j) {
        this.timeStamp = j;
    }

    public void realmSet$title(String str) {
        this.title = str;
    }

    public void realmSet$type(int i) {
        this.type = i;
    }

    public void realmSet$url(String str) {
        this.url = str;
    }

    public void realmSet$urlTrack(String str) {
        this.urlTrack = str;
    }

    public Notification(Long expire2, String abTestingGroup2, String body2, int campaignId2, String img2, String lang2, String title2, String url2, String urlTrack2, String notificationCenterUrlTrack2, long timeStamp2, int type2, long dismissed2, String appName2, String graphic2, String ownerId2, boolean processed2) {
        long j = timeStamp2;
        int i = type2;
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        realmSet$expire(expire2);
        realmSet$body(body2);
        realmSet$img(img2);
        realmSet$title(title2);
        realmSet$url(url2);
        realmSet$notificationCenterUrlTrack(notificationCenterUrlTrack2);
        realmSet$type(i);
        realmSet$abTestingGroup(abTestingGroup2);
        realmSet$campaignId(campaignId2);
        realmSet$lang(lang2);
        realmSet$urlTrack(urlTrack2);
        realmSet$timeStamp(j);
        realmSet$dismissed(dismissed2);
        realmSet$appName(appName2);
        realmSet$graphic(graphic2);
        realmSet$ownerId(ownerId2);
        realmSet$processed(processed2);
        realmSet$key(String.valueOf(((long) i) + j));
    }

    public Notification() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        realmSet$expire(Long.valueOf(0));
    }

    public Long getExpire() {
        return realmGet$expire();
    }

    public String getAppName() {
        return realmGet$appName();
    }

    public String getGraphic() {
        return realmGet$graphic();
    }

    public long getDismissed() {
        return realmGet$dismissed();
    }

    public int getType() {
        return realmGet$type();
    }

    public String getAbTestingGroup() {
        return realmGet$abTestingGroup();
    }

    public String getBody() {
        return realmGet$body();
    }

    public int getCampaignId() {
        return realmGet$campaignId();
    }

    public String getImg() {
        return realmGet$img();
    }

    public String getLang() {
        return realmGet$lang();
    }

    public String getTitle() {
        return realmGet$title();
    }

    public String getUrl() {
        return realmGet$url();
    }

    public String getUrlTrack() {
        return realmGet$urlTrack();
    }

    public long getTimeStamp() {
        return realmGet$timeStamp();
    }

    public String getOwnerId() {
        return realmGet$ownerId();
    }

    public String getKey() {
        return realmGet$key();
    }

    public boolean isDismissed() {
        return realmGet$dismissed() != -1;
    }

    public void setDismissed(long dismissed2) {
        realmSet$dismissed(dismissed2);
    }

    public String getNotificationCenterUrlTrack() {
        return realmGet$notificationCenterUrlTrack();
    }

    public boolean isProcessed() {
        return realmGet$processed();
    }
}
