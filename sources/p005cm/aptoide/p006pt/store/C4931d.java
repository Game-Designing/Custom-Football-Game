package p005cm.aptoide.p006pt.store;

import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.store.d */
/* compiled from: lambda */
public final /* synthetic */ class C4931d implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ ErrorRequestListener f8577a;

    public /* synthetic */ C4931d(ErrorRequestListener errorRequestListener) {
        this.f8577a = errorRequestListener;
    }

    public final void call(Object obj) {
        StoreUtils.m9267a(this.f8577a, (Throwable) obj);
    }
}
