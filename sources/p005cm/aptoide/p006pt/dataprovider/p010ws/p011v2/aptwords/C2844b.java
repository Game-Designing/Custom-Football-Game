package p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords;

import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v2.aptwords.b */
/* compiled from: lambda */
public final /* synthetic */ class C2844b implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ HashMapNotNull f6096a;

    /* renamed from: b */
    private final /* synthetic */ Interfaces f6097b;

    /* renamed from: c */
    private final /* synthetic */ boolean f6098c;

    public /* synthetic */ C2844b(HashMapNotNull hashMapNotNull, Interfaces interfaces, boolean z) {
        this.f6096a = hashMapNotNull;
        this.f6097b = interfaces;
        this.f6098c = z;
    }

    public final Object call(Object obj) {
        return this.f6096a.put("aptvercode", String.valueOf((Integer) obj));
    }
}
