package p005cm.aptoide.p006pt.app.view;

import p005cm.aptoide.p006pt.app.AppViewViewModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.view.Cf */
/* compiled from: lambda */
public final /* synthetic */ class C1777Cf implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppViewPresenter f4769a;

    /* renamed from: b */
    private final /* synthetic */ Action f4770b;

    /* renamed from: c */
    private final /* synthetic */ AppViewViewModel f4771c;

    public /* synthetic */ C1777Cf(AppViewPresenter appViewPresenter, Action action, AppViewViewModel appViewViewModel) {
        this.f4769a = appViewPresenter;
        this.f4770b = action;
        this.f4771c = appViewViewModel;
    }

    public final Object call(Object obj) {
        return this.f4769a.mo10588a(this.f4770b, this.f4771c, (Boolean) obj);
    }
}
