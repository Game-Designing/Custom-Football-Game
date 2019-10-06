package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.Wf */
/* compiled from: lambda */
public final /* synthetic */ class C1960Wf implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewPresenter f4984a;

    /* renamed from: b */
    private final /* synthetic */ Action f4985b;

    public /* synthetic */ C1960Wf(AppViewPresenter appViewPresenter, Action action) {
        this.f4984a = appViewPresenter;
        this.f4985b = action;
    }

    public final Object call(Object obj) {
        return this.f4984a.mo10642c(this.f4985b, (AppViewViewModel) obj);
    }
}
