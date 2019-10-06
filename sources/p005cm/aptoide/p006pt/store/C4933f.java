package p005cm.aptoide.p006pt.store;

import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreMetaRequest;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.store.f */
/* compiled from: lambda */
public final /* synthetic */ class C4933f implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ GetStoreMetaRequest f8579a;

    /* renamed from: b */
    private final /* synthetic */ StoreAccessor f8580b;

    public /* synthetic */ C4933f(GetStoreMetaRequest getStoreMetaRequest, StoreAccessor storeAccessor) {
        this.f8579a = getStoreMetaRequest;
        this.f8580b = storeAccessor;
    }

    public final void call(Object obj) {
        StoreUtils.m9269a(this.f8579a, this.f8580b, (GetStoreMeta) obj);
    }
}
