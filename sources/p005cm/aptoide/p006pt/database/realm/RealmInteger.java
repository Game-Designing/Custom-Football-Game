package p005cm.aptoide.p006pt.database.realm;

import p005cm.aptoide.p006pt.utils.IdUtils;
import p024io.realm.C0106Z;
import p024io.realm.C14012S;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.RealmInteger */
public class RealmInteger extends C0106Z implements C14012S {

    /* renamed from: id */
    private String f6070id;
    private Integer integer;

    public String realmGet$id() {
        return this.f6070id;
    }

    public Integer realmGet$integer() {
        return this.integer;
    }

    public void realmSet$id(String str) {
        this.f6070id = str;
    }

    public void realmSet$integer(Integer num) {
        this.integer = num;
    }

    public RealmInteger(Integer downloadId) {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        realmSet$id(IdUtils.randomString());
        realmSet$integer(downloadId);
    }

    public RealmInteger() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
    }

    public Integer getInteger() {
        return realmGet$integer();
    }

    public void setInteger(Integer integer2) {
        realmSet$integer(integer2);
    }
}
