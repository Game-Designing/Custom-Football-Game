package p005cm.aptoide.p006pt.billing.persistence;

import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.persistence.h */
/* compiled from: lambda */
public final /* synthetic */ class C2359h implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ String f5504a;

    /* renamed from: b */
    private final /* synthetic */ String f5505b;

    public /* synthetic */ C2359h(String str, String str2) {
        this.f5504a = str;
        this.f5505b = str2;
    }

    public final Object call(Object obj) {
        return RealmAuthorizationPersistence.m7033c(this.f5504a, this.f5505b, (Authorization) obj);
    }
}
