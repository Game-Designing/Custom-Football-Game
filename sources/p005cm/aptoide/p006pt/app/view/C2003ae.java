package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.ae */
/* compiled from: lambda */
public final /* synthetic */ class C2003ae implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewPresenter f5040a;

    /* renamed from: b */
    private final /* synthetic */ Action f5041b;

    public /* synthetic */ C2003ae(AppViewPresenter appViewPresenter, Action action) {
        this.f5040a = appViewPresenter;
        this.f5041b = action;
    }

    public final Object call(Object obj) {
        return this.f5040a.mo10587a(this.f5041b, (AppViewViewModel) obj);
    }
}
