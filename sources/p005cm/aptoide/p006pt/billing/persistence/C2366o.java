package p005cm.aptoide.p006pt.billing.persistence;

import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.persistence.o */
/* compiled from: lambda */
public final /* synthetic */ class C2366o implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ String f5517a;

    /* renamed from: b */
    private final /* synthetic */ String f5518b;

    public /* synthetic */ C2366o(String str, String str2) {
        this.f5517a = str;
        this.f5518b = str2;
    }

    public final Object call(Object obj) {
        return RealmAuthorizationPersistence.m7028a(this.f5517a, this.f5518b, (Authorization) obj);
    }
}
