package p005cm.aptoide.p006pt.view;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.view.p */
/* compiled from: lambda */
public final /* synthetic */ class C5357p implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ String f9155a;

    public /* synthetic */ C5357p(String str) {
        this.f9155a = str;
    }

    public final Object call(Object obj) {
        String str = this.f9155a;
        DeepLinkManager.m9501b(str, (GetStoreMeta) obj);
        return str;
    }
}
