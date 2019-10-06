package p005cm.aptoide.p006pt.database.accessors;

import java.util.List;
import p024io.realm.C0106Z;
import p026rx.C0120S;

@Deprecated
/* renamed from: cm.aptoide.pt.database.accessors.SimpleAccessor */
public class SimpleAccessor<T extends C0106Z> implements Accessor<T> {
    private final Class clazz;
    protected final Database database;

    public SimpleAccessor(Database db, Class<T> clazz2) {
        this.database = db;
        this.clazz = clazz2;
    }

    public void insertAll(List<T> objects) {
        this.database.insertAll(objects);
    }

    public void removeAll() {
        Class cls = this.clazz;
        if (cls != null) {
            this.database.deleteAll(cls);
        }
    }

    public void insert(T object) {
        this.database.insert(object);
    }

    public C0120S<Long> count() {
        return this.database.count(this.clazz);
    }
}
