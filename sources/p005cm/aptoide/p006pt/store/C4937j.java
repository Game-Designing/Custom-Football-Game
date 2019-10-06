package p005cm.aptoide.p006pt.store;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreMetaRequest;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.store.j */
/* compiled from: lambda */
public final /* synthetic */ class C4937j implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ StoreUtilsProxy f8588a;

    /* renamed from: b */
    private final /* synthetic */ GetStoreMetaRequest f8589b;

    public /* synthetic */ C4937j(StoreUtilsProxy storeUtilsProxy, GetStoreMetaRequest getStoreMetaRequest) {
        this.f8588a = storeUtilsProxy;
        this.f8589b = getStoreMetaRequest;
    }

    public final void call(Object obj) {
        this.f8588a.mo2346a(this.f8589b, (GetStoreMeta) obj);
    }
}
