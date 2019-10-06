package p005cm.aptoide.p006pt.dataprovider;

import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.dataprovider.b */
/* compiled from: lambda */
public final /* synthetic */ class C2839b implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ ErrorRequestListener f6076a;

    public /* synthetic */ C2839b(ErrorRequestListener errorRequestListener) {
        this.f6076a = errorRequestListener;
    }

    public final void call(Object obj) {
        this.f6076a.onError((Throwable) obj);
    }
}
