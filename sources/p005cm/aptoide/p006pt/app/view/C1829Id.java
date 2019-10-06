package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.app.view.Id */
/* compiled from: lambda */
public final /* synthetic */ class C1829Id implements C0128a {

    /* renamed from: a */
    private final /* synthetic */ AppViewPresenter f4830a;

    /* renamed from: b */
    private final /* synthetic */ AppViewViewModel f4831b;

    /* renamed from: c */
    private final /* synthetic */ Action f4832c;

    public /* synthetic */ C1829Id(AppViewPresenter appViewPresenter, AppViewViewModel appViewViewModel, Action action) {
        this.f4830a = appViewPresenter;
        this.f4831b = appViewViewModel;
        this.f4832c = action;
    }

    public final void call() {
        this.f4830a.mo10675g(this.f4831b, this.f4832c);
    }
}
