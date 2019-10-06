package p005cm.aptoide.p006pt.install;

import java.util.List;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.install.W */
/* compiled from: lambda */
public final /* synthetic */ class C4018W implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Installed f7516a;

    public /* synthetic */ C4018W(Installed installed) {
        this.f7516a = installed;
    }

    public final Object call(Object obj) {
        List list = (List) obj;
        InstallManager.m321a(this.f7516a, list);
        return list;
    }
}
