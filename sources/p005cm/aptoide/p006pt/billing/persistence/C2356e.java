package p005cm.aptoide.p006pt.billing.persistence;

import java.util.List;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.persistence.e */
/* compiled from: lambda */
public final /* synthetic */ class C2356e implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ String f5499a;

    /* renamed from: b */
    private final /* synthetic */ String f5500b;

    public /* synthetic */ C2356e(String str, String str2) {
        this.f5499a = str;
        this.f5500b = str2;
    }

    public final Object call(Object obj) {
        return InMemoryTransactionPersistence.m7025a(this.f5499a, this.f5500b, (List) obj);
    }
}
