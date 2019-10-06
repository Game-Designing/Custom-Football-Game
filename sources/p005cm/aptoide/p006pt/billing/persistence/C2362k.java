package p005cm.aptoide.p006pt.billing.persistence;

import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.persistence.k */
/* compiled from: lambda */
public final /* synthetic */ class C2362k implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ String f5511a;

    /* renamed from: b */
    private final /* synthetic */ String f5512b;

    public /* synthetic */ C2362k(String str, String str2) {
        this.f5511a = str;
        this.f5512b = str2;
    }

    public final Object call(Object obj) {
        return RealmAuthorizationPersistence.m7032b(this.f5511a, this.f5512b, (Authorization) obj);
    }
}
