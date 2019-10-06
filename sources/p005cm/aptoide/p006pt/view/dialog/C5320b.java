package p005cm.aptoide.p006pt.view.dialog;

import android.app.Activity;
import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;
import p026rx.C14980ia;

/* renamed from: cm.aptoide.pt.view.dialog.b */
/* compiled from: lambda */
public final /* synthetic */ class C5320b implements ErrorRequestListener {

    /* renamed from: a */
    private final /* synthetic */ Activity f9094a;

    /* renamed from: b */
    private final /* synthetic */ C14980ia f9095b;

    public /* synthetic */ C5320b(Activity activity, C14980ia iaVar) {
        this.f9094a = activity;
        this.f9095b = iaVar;
    }

    public final void onError(Throwable th) {
        DialogUtils.m9600a(this.f9094a, this.f9095b, th);
    }
}
