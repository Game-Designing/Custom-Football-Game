package p005cm.aptoide.p006pt.store.view;

import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;

/* renamed from: cm.aptoide.pt.store.view.f */
/* compiled from: lambda */
public final /* synthetic */ class C4990f implements SuccessRequestListener {

    /* renamed from: a */
    private final /* synthetic */ AddStoreDialog f8659a;

    public /* synthetic */ C4990f(AddStoreDialog addStoreDialog) {
        this.f8659a = addStoreDialog;
    }

    public final void call(Object obj) {
        this.f8659a.mo16467a((GetStoreMeta) obj);
    }
}
