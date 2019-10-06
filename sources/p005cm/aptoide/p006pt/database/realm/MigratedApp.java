package p005cm.aptoide.p006pt.database.realm;

import p024io.realm.C0106Z;
import p024io.realm.C14088u;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.MigratedApp */
public class MigratedApp extends C0106Z implements C14088u {
    private String packageName;

    public String realmGet$packageName() {
        return this.packageName;
    }

    public void realmSet$packageName(String str) {
        this.packageName = str;
    }

    public MigratedApp() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
    }

    public MigratedApp(String packageName2) {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        realmSet$packageName(packageName2);
    }

    public String getPackageName() {
        return realmGet$packageName();
    }

    public void setPackageName(String packageName2) {
        realmSet$packageName(packageName2);
    }
}
