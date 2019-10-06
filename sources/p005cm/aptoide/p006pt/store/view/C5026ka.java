package p005cm.aptoide.p006pt.store.view;

import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;

/* renamed from: cm.aptoide.pt.store.view.ka */
/* compiled from: lambda */
public final /* synthetic */ class C5026ka implements ErrorRequestListener {

    /* renamed from: a */
    private final /* synthetic */ PrivateStoreDialog f8707a;

    public /* synthetic */ C5026ka(PrivateStoreDialog privateStoreDialog) {
        this.f8707a = privateStoreDialog;
    }

    public final void onError(Throwable th) {
        this.f8707a.mo16571a(th);
    }
}
