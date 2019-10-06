package p005cm.aptoide.p006pt.view.dialog;

import android.app.Activity;
import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.view.dialog.n */
/* compiled from: lambda */
public final /* synthetic */ class C5332n implements SuccessRequestListener {

    /* renamed from: a */
    private final /* synthetic */ DialogUtils f9129a;

    /* renamed from: b */
    private final /* synthetic */ Activity f9130b;

    /* renamed from: c */
    private final /* synthetic */ C0128a f9131c;

    public /* synthetic */ C5332n(DialogUtils dialogUtils, Activity activity, C0128a aVar) {
        this.f9129a = dialogUtils;
        this.f9130b = activity;
        this.f9131c = aVar;
    }

    public final void call(Object obj) {
        this.f9129a.mo17172a(this.f9130b, this.f9131c, (BaseV7Response) obj);
    }
}
