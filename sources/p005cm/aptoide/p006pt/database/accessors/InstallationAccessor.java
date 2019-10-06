package p005cm.aptoide.p006pt.database.accessors;

import java.util.List;
import p005cm.aptoide.p006pt.database.realm.Installation;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.database.accessors.InstallationAccessor */
public class InstallationAccessor extends SimpleAccessor<Installation> {
    public InstallationAccessor(Database db) {
        super(db, Installation.class);
    }

    public C0120S<List<Installation>> getInstallationsHistory() {
        return this.database.getAll(Installation.class);
    }
}
