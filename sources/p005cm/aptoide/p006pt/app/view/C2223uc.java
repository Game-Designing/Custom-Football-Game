package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.app.view.uc */
/* compiled from: lambda */
public final /* synthetic */ class C2223uc implements C0128a {

    /* renamed from: a */
    private final /* synthetic */ AppViewPresenter f5294a;

    /* renamed from: b */
    private final /* synthetic */ AppViewViewModel f5295b;

    /* renamed from: c */
    private final /* synthetic */ Action f5296c;

    public /* synthetic */ C2223uc(AppViewPresenter appViewPresenter, AppViewViewModel appViewViewModel, Action action) {
        this.f5294a = appViewPresenter;
        this.f5295b = appViewViewModel;
        this.f5296c = action;
    }

    public final void call() {
        this.f5294a.mo10606a(this.f5295b, this.f5296c);
    }
}
