package p005cm.aptoide.p006pt.database.realm;

import p024io.realm.C0106Z;
import p024io.realm.C14019W;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.RealmLocalNotificationSync */
public class RealmLocalNotificationSync extends C0106Z implements C14019W {
    public static String PRIMARY_KEY_NAME = "notificationId";
    private String body;

    /* renamed from: id */
    private String f6071id;
    private String image;
    private String navigationUrl;
    private String notificationId;
    private String title;
    private long trigger;

    public String realmGet$body() {
        return this.body;
    }

    public String realmGet$id() {
        return this.f6071id;
    }

    public String realmGet$image() {
        return this.image;
    }

    public String realmGet$navigationUrl() {
        return this.navigationUrl;
    }

    public String realmGet$notificationId() {
        return this.notificationId;
    }

    public String realmGet$title() {
        return this.title;
    }

    public long realmGet$trigger() {
        return this.trigger;
    }

    public void realmSet$body(String str) {
        this.body = str;
    }

    public void realmSet$id(String str) {
        this.f6071id = str;
    }

    public void realmSet$image(String str) {
        this.image = str;
    }

    public void realmSet$navigationUrl(String str) {
        this.navigationUrl = str;
    }

    public void realmSet$notificationId(String str) {
        this.notificationId = str;
    }

    public void realmSet$title(String str) {
        this.title = str;
    }

    public void realmSet$trigger(long j) {
        this.trigger = j;
    }

    public RealmLocalNotificationSync(String notificationId2, String title2, String body2, String image2, String navigationUrl2, long trigger2, String id) {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        realmSet$notificationId(notificationId2);
        realmSet$title(title2);
        realmSet$body(body2);
        realmSet$image(image2);
        realmSet$navigationUrl(navigationUrl2);
        realmSet$trigger(trigger2);
        realmSet$id(id);
    }

    public RealmLocalNotificationSync() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
    }

    public String getNotificationId() {
        return realmGet$notificationId();
    }

    public String getTitle() {
        return realmGet$title();
    }

    public String getBody() {
        return realmGet$body();
    }

    public String getImage() {
        return realmGet$image();
    }

    public String getNavigationUrl() {
        return realmGet$navigationUrl();
    }

    public long getTrigger() {
        return realmGet$trigger();
    }

    public String getId() {
        return realmGet$id();
    }
}
