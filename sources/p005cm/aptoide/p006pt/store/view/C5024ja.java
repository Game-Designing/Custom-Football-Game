package p005cm.aptoide.p006pt.store.view;

import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;

/* renamed from: cm.aptoide.pt.store.view.ja */
/* compiled from: lambda */
public final /* synthetic */ class C5024ja implements SuccessRequestListener {

    /* renamed from: a */
    private final /* synthetic */ PrivateStoreDialog f8705a;

    public /* synthetic */ C5024ja(PrivateStoreDialog privateStoreDialog) {
        this.f8705a = privateStoreDialog;
    }

    public final void call(Object obj) {
        this.f8705a.mo16570a((GetStoreMeta) obj);
    }
}
