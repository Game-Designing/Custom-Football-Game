package p005cm.aptoide.p006pt.database.accessors;

import java.util.List;
import p005cm.aptoide.p006pt.database.realm.Store;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.database.accessors.StoreAccessor */
public class StoreAccessor extends SimpleAccessor<Store> {
    public StoreAccessor(Database db) {
        super(db, Store.class);
    }

    public C0120S<List<Store>> getAll() {
        return this.database.getAll(Store.class);
    }

    public C0120S<Store> get(String storeName) {
        return this.database.get(Store.class, "storeName", storeName);
    }

    public C0120S<Store> get(long storeId) {
        return this.database.get(Store.class, Store.STORE_ID, Long.valueOf(storeId));
    }

    public void remove(long storeId) {
        this.database.delete(Store.class, Store.STORE_ID, Long.valueOf(storeId));
    }

    public void remove(String storeName) {
        this.database.delete(Store.class, "storeName", storeName);
    }

    public void save(Store store) {
        this.database.insert(store);
    }

    public C0120S<List<Store>> getAsList(long storeId) {
        return this.database.getAsList(Store.class, Store.STORE_ID, Long.valueOf(storeId));
    }

    public C0120S<List<Store>> getAsList(String storeName) {
        return this.database.getAsList(Store.class, "storeName", storeName);
    }
}
