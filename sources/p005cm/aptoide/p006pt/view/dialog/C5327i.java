package p005cm.aptoide.p006pt.view.dialog;

import android.app.Activity;
import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;

/* renamed from: cm.aptoide.pt.view.dialog.i */
/* compiled from: lambda */
public final /* synthetic */ class C5327i implements ErrorRequestListener {

    /* renamed from: a */
    private final /* synthetic */ Activity f9113a;

    public /* synthetic */ C5327i(Activity activity) {
        this.f9113a = activity;
    }

    public final void onError(Throwable th) {
        DialogUtils.m9599a(this.f9113a, th);
    }
}
