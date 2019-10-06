package p005cm.aptoide.p006pt.view.dialog;

import android.app.Activity;
import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p026rx.C14980ia;

/* renamed from: cm.aptoide.pt.view.dialog.d */
/* compiled from: lambda */
public final /* synthetic */ class C5322d implements SuccessRequestListener {

    /* renamed from: a */
    private final /* synthetic */ DialogUtils f9097a;

    /* renamed from: b */
    private final /* synthetic */ Activity f9098b;

    /* renamed from: c */
    private final /* synthetic */ C14980ia f9099c;

    public /* synthetic */ C5322d(DialogUtils dialogUtils, Activity activity, C14980ia iaVar) {
        this.f9097a = dialogUtils;
        this.f9098b = activity;
        this.f9099c = iaVar;
    }

    public final void call(Object obj) {
        this.f9097a.mo17173a(this.f9098b, this.f9099c, (BaseV7Response) obj);
    }
}
