package p005cm.aptoide.p006pt.database.realm;

import p024io.realm.C0106Z;
import p024io.realm.C14070l;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.ExcludedAd */
public class ExcludedAd extends C0106Z implements C14070l {
    public static final String PACKAGE_NAME = "packageName";
    private String packageName;

    public String realmGet$packageName() {
        return this.packageName;
    }

    public void realmSet$packageName(String str) {
        this.packageName = str;
    }

    public ExcludedAd() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
    }

    public String getPackageName() {
        return realmGet$packageName();
    }

    public void setPackageName(String packageName2) {
        realmSet$packageName(packageName2);
    }
}
