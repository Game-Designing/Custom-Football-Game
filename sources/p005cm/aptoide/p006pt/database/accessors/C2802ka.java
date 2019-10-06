package p005cm.aptoide.p006pt.database.accessors;

import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.database.schedulers.RealmSchedulers;
import p024io.realm.C13990F;
import p024io.realm.C14064ia;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.database.accessors.ka */
/* compiled from: lambda */
public final /* synthetic */ class C2802ka implements C0132p {

    /* renamed from: a */
    public static final /* synthetic */ C2802ka f6028a = new C2802ka();

    private /* synthetic */ C2802ka() {
    }

    public final Object call(Object obj) {
        return ((C13990F) obj).mo43540c(Installed.class).mo43677a("name", C14064ia.ASCENDING).mo43707c().mo3643c(RealmSchedulers.getScheduler());
    }
}
