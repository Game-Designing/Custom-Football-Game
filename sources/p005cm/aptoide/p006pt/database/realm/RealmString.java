package p005cm.aptoide.p006pt.database.realm;

import p005cm.aptoide.p006pt.utils.IdUtils;
import p024io.realm.C0106Z;
import p024io.realm.C14060ga;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.RealmString */
public class RealmString extends C0106Z implements C14060ga {

    /* renamed from: id */
    private String f6072id;
    private String string;

    public String realmGet$id() {
        return this.f6072id;
    }

    public String realmGet$string() {
        return this.string;
    }

    public void realmSet$id(String str) {
        this.f6072id = str;
    }

    public void realmSet$string(String str) {
        this.string = str;
    }

    public RealmString(String string2) {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        realmSet$id(IdUtils.randomString());
        realmSet$string(string2);
    }

    public RealmString() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
    }

    public String getId() {
        return realmGet$id();
    }

    public void setId(String id) {
        realmSet$id(id);
    }

    public String getString() {
        return realmGet$string();
    }

    public void setString(String string2) {
        realmSet$string(string2);
    }
}
