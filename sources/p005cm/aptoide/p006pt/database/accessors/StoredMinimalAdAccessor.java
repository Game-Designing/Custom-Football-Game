package p005cm.aptoide.p006pt.database.accessors;

import p005cm.aptoide.p006pt.database.realm.StoredMinimalAd;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.database.accessors.StoredMinimalAdAccessor */
public class StoredMinimalAdAccessor extends SimpleAccessor<StoredMinimalAd> {
    public StoredMinimalAdAccessor(Database db) {
        super(db, StoredMinimalAd.class);
    }

    public C0120S<StoredMinimalAd> get(String packageName) {
        return this.database.get(StoredMinimalAd.class, "packageName", packageName);
    }

    public void remove(StoredMinimalAd storeMinimalAd) {
        this.database.delete(StoredMinimalAd.class, "packageName", storeMinimalAd.getPackageName());
    }

    public void insert(StoredMinimalAd storedMinimalAd) {
        this.database.insert(storedMinimalAd);
    }
}
