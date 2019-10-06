package p005cm.aptoide.p006pt.billing.persistence;

import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.billing.persistence.j */
/* compiled from: lambda */
public final /* synthetic */ class C2361j implements C0128a {

    /* renamed from: a */
    private final /* synthetic */ RealmAuthorizationPersistence f5509a;

    /* renamed from: b */
    private final /* synthetic */ Authorization f5510b;

    public /* synthetic */ C2361j(RealmAuthorizationPersistence realmAuthorizationPersistence, Authorization authorization) {
        this.f5509a = realmAuthorizationPersistence;
        this.f5510b = authorization;
    }

    public final void call() {
        this.f5509a.mo11222b(this.f5510b);
    }
}
