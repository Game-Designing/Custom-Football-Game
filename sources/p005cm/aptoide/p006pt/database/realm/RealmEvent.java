package p005cm.aptoide.p006pt.database.realm;

import p024io.realm.C0106Z;
import p024io.realm.C14006N;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.RealmEvent */
public class RealmEvent extends C0106Z implements C14006N {
    public static String PRIMARY_KEY_NAME = "timestamp";
    private int action;
    private String context;
    private String data;
    private String eventName;
    private long timestamp;

    public int realmGet$action() {
        return this.action;
    }

    public String realmGet$context() {
        return this.context;
    }

    public String realmGet$data() {
        return this.data;
    }

    public String realmGet$eventName() {
        return this.eventName;
    }

    public long realmGet$timestamp() {
        return this.timestamp;
    }

    public void realmSet$action(int i) {
        this.action = i;
    }

    public void realmSet$context(String str) {
        this.context = str;
    }

    public void realmSet$data(String str) {
        this.data = str;
    }

    public void realmSet$eventName(String str) {
        this.eventName = str;
    }

    public void realmSet$timestamp(long j) {
        this.timestamp = j;
    }

    public RealmEvent(long timestamp2, String eventName2, int action2, String context2, String data2) {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        realmSet$timestamp(timestamp2);
        realmSet$eventName(eventName2);
        realmSet$action(action2);
        realmSet$context(context2);
        realmSet$data(data2);
    }

    public RealmEvent() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
    }

    public long getTimestamp() {
        return realmGet$timestamp();
    }

    public String getEventName() {
        return realmGet$eventName();
    }

    public int getAction() {
        return realmGet$action();
    }

    public String getContext() {
        return realmGet$context();
    }

    public String getData() {
        return realmGet$data();
    }
}
