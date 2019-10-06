package p005cm.aptoide.p006pt.store;

import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.store.b */
/* compiled from: lambda */
public final /* synthetic */ class C4929b implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ SuccessRequestListener f8572a;

    public /* synthetic */ C4929b(SuccessRequestListener successRequestListener) {
        this.f8572a = successRequestListener;
    }

    public final void call(Object obj) {
        StoreUtils.m9268a(this.f8572a, (GetStoreMeta) obj);
    }
}
