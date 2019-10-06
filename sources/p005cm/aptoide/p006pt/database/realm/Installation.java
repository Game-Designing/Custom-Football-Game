package p005cm.aptoide.p006pt.database.realm;

import p024io.realm.C0106Z;
import p024io.realm.C14083q;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.Installation */
public class Installation extends C0106Z implements C14083q {
    public static final String PACKAGE_NAME = "packageName";
    private String icon;
    private String name;
    private String packageName;
    private int versionCode;
    private String versionName;

    public String realmGet$icon() {
        return this.icon;
    }

    public String realmGet$name() {
        return this.name;
    }

    public String realmGet$packageName() {
        return this.packageName;
    }

    public int realmGet$versionCode() {
        return this.versionCode;
    }

    public String realmGet$versionName() {
        return this.versionName;
    }

    public void realmSet$icon(String str) {
        this.icon = str;
    }

    public void realmSet$name(String str) {
        this.name = str;
    }

    public void realmSet$packageName(String str) {
        this.packageName = str;
    }

    public void realmSet$versionCode(int i) {
        this.versionCode = i;
    }

    public void realmSet$versionName(String str) {
        this.versionName = str;
    }

    public Installation() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
    }

    public Installation(String packageName2, String name2, String icon2, int versionCode2, String versionName2) {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        realmSet$packageName(packageName2);
        realmSet$name(name2);
        realmSet$icon(icon2);
        realmSet$versionCode(versionCode2);
        realmSet$versionName(versionName2);
    }

    public String getIcon() {
        return realmGet$icon();
    }

    public void setIcon(String icon2) {
        realmSet$icon(icon2);
    }

    public String getPackageName() {
        return realmGet$packageName();
    }

    public void setPackageName(String packageName2) {
        realmSet$packageName(packageName2);
    }

    public String getName() {
        return realmGet$name();
    }

    public void setName(String name2) {
        realmSet$name(name2);
    }

    public int getVersionCode() {
        return realmGet$versionCode();
    }

    public void setVersionCode(int versionCode2) {
        realmSet$versionCode(versionCode2);
    }

    public String getVersionName() {
        return realmGet$versionName();
    }

    public void setVersionName(String versionName2) {
        realmSet$versionName(versionName2);
    }
}
