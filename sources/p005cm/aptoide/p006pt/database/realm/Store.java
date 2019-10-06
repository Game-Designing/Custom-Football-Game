package p005cm.aptoide.p006pt.database.realm;

import p024io.realm.C0106Z;
import p024io.realm.C0108ka;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.Store */
public class Store extends C0106Z implements C0108ka {
    public static final String DOWNLOADS = "downloads";
    public static final String ICON_PATH = "iconPath";
    public static final String PASSWORD_SHA1 = "passwordSha1";
    public static final String STORE_ID = "storeId";
    public static final String STORE_NAME = "storeName";
    public static final String THEME = "theme";
    public static final String USERNAME = "username";
    private long downloads;
    private String iconPath;
    private String passwordSha1;
    private long storeId;
    private String storeName;
    private String theme;
    private String username;

    public long realmGet$downloads() {
        return this.downloads;
    }

    public String realmGet$iconPath() {
        return this.iconPath;
    }

    public String realmGet$passwordSha1() {
        return this.passwordSha1;
    }

    public long realmGet$storeId() {
        return this.storeId;
    }

    public String realmGet$storeName() {
        return this.storeName;
    }

    public String realmGet$theme() {
        return this.theme;
    }

    public String realmGet$username() {
        return this.username;
    }

    public void realmSet$downloads(long j) {
        this.downloads = j;
    }

    public void realmSet$iconPath(String str) {
        this.iconPath = str;
    }

    public void realmSet$passwordSha1(String str) {
        this.passwordSha1 = str;
    }

    public void realmSet$storeId(long j) {
        this.storeId = j;
    }

    public void realmSet$storeName(String str) {
        this.storeName = str;
    }

    public void realmSet$theme(String str) {
        this.theme = str;
    }

    public void realmSet$username(String str) {
        this.username = str;
    }

    public Store() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
    }

    public long getStoreId() {
        return realmGet$storeId();
    }

    public void setStoreId(long storeId2) {
        realmSet$storeId(storeId2);
    }

    public String getIconPath() {
        return realmGet$iconPath();
    }

    public void setIconPath(String iconPath2) {
        realmSet$iconPath(iconPath2);
    }

    public String getTheme() {
        return realmGet$theme();
    }

    public void setTheme(String theme2) {
        realmSet$theme(theme2);
    }

    public long getDownloads() {
        return realmGet$downloads();
    }

    public void setDownloads(long downloads2) {
        realmSet$downloads(downloads2);
    }

    public String getStoreName() {
        return realmGet$storeName();
    }

    public void setStoreName(String storeName2) {
        realmSet$storeName(storeName2);
    }

    public String getUsername() {
        return realmGet$username();
    }

    public void setUsername(String username2) {
        realmSet$username(username2);
    }

    public String getPasswordSha1() {
        return realmGet$passwordSha1();
    }

    public void setPasswordSha1(String passwordSha12) {
        realmSet$passwordSha1(passwordSha12);
    }
}
