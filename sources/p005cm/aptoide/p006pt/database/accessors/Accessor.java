package p005cm.aptoide.p006pt.database.accessors;

import java.util.List;
import p024io.realm.C0106Z;

/* renamed from: cm.aptoide.pt.database.accessors.Accessor */
public interface Accessor<T extends C0106Z> {
    void insertAll(List<T> list);

    void removeAll();
}
