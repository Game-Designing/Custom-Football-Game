package p005cm.aptoide.p006pt.database.accessors;

import p005cm.aptoide.p006pt.database.schedulers.RealmSchedulers;
import p024io.realm.C0106Z;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.database.accessors.k */
/* compiled from: lambda */
public final /* synthetic */ class C2801k implements C0132p {

    /* renamed from: a */
    public static final /* synthetic */ C2801k f6027a = new C2801k();

    private /* synthetic */ C2801k() {
    }

    public final Object call(Object obj) {
        return ((C0106Z) obj).asObservable().mo3643c(RealmSchedulers.getScheduler());
    }
}
