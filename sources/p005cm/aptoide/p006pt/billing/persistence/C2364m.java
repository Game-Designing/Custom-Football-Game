package p005cm.aptoide.p006pt.billing.persistence;

import java.util.List;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.persistence.m */
/* compiled from: lambda */
public final /* synthetic */ class C2364m implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ String f5514a;

    /* renamed from: b */
    private final /* synthetic */ String f5515b;

    public /* synthetic */ C2364m(String str, String str2) {
        this.f5514a = str;
        this.f5515b = str2;
    }

    public final Object call(Object obj) {
        return RealmAuthorizationPersistence.m7031a(this.f5514a, this.f5515b, (List) obj);
    }
}
