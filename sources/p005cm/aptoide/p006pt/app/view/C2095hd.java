package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.app.view.hd */
/* compiled from: lambda */
public final /* synthetic */ class C2095hd implements C0128a {

    /* renamed from: a */
    private final /* synthetic */ AppViewPresenter f5150a;

    /* renamed from: b */
    private final /* synthetic */ AppViewViewModel f5151b;

    /* renamed from: c */
    private final /* synthetic */ Action f5152c;

    public /* synthetic */ C2095hd(AppViewPresenter appViewPresenter, AppViewViewModel appViewViewModel, Action action) {
        this.f5150a = appViewPresenter;
        this.f5151b = appViewViewModel;
        this.f5152c = action;
    }

    public final void call() {
        this.f5150a.mo10662d(this.f5151b, this.f5152c);
    }
}
