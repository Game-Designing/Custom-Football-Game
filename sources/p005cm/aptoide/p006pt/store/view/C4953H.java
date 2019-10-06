package p005cm.aptoide.p006pt.store.view;

import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;

/* renamed from: cm.aptoide.pt.store.view.H */
/* compiled from: lambda */
public final /* synthetic */ class C4953H implements ErrorRequestListener {

    /* renamed from: a */
    private final /* synthetic */ GetStoreEndlessFragment f8604a;

    public /* synthetic */ C4953H(GetStoreEndlessFragment getStoreEndlessFragment) {
        this.f8604a = getStoreEndlessFragment;
    }

    public final void onError(Throwable th) {
        this.f8604a.finishLoading(th);
    }
}
