package p005cm.aptoide.p006pt.store.view;

import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;

/* renamed from: cm.aptoide.pt.store.view.r */
/* compiled from: lambda */
public final /* synthetic */ class C5070r implements ErrorRequestListener {

    /* renamed from: a */
    private final /* synthetic */ AddStoreDialog f8759a;

    public /* synthetic */ C5070r(AddStoreDialog addStoreDialog) {
        this.f8759a = addStoreDialog;
    }

    public final void onError(Throwable th) {
        this.f8759a.mo16468a(th);
    }
}
