package p005cm.aptoide.p006pt.billing.persistence;

import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p005cm.aptoide.p006pt.billing.authorization.Authorization.Status;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.persistence.i */
/* compiled from: lambda */
public final /* synthetic */ class C2360i implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ RealmAuthorizationPersistence f5506a;

    /* renamed from: b */
    private final /* synthetic */ Status f5507b;

    /* renamed from: c */
    private final /* synthetic */ String f5508c;

    public /* synthetic */ C2360i(RealmAuthorizationPersistence realmAuthorizationPersistence, Status status, String str) {
        this.f5506a = realmAuthorizationPersistence;
        this.f5507b = status;
        this.f5508c = str;
    }

    public final Object call(Object obj) {
        return this.f5506a.mo11219a(this.f5507b, this.f5508c, (Authorization) obj);
    }
}
