package p005cm.aptoide.p006pt.database.accessors;

import p005cm.aptoide.p006pt.database.schedulers.RealmSchedulers;
import p024io.realm.C13990F;
import p026rx.C0120S;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.database.accessors.l */
/* compiled from: lambda */
public final /* synthetic */ class C2804l implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Class f6030a;

    public /* synthetic */ C2804l(Class cls) {
        this.f6030a = cls;
    }

    public final Object call(Object obj) {
        return C0120S.m652c(Long.valueOf(((C13990F) obj).mo43540c(this.f6030a).mo43666a())).mo3643c(RealmSchedulers.getScheduler());
    }
}
